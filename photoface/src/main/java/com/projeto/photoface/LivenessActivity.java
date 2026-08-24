package com.projeto.photoface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.acesso.acessobio_android.AcessoBioListener;
import com.acesso.acessobio_android.iAcessoBioSelfie;
import com.acesso.acessobio_android.onboarding.AcessoBio;
import com.acesso.acessobio_android.onboarding.IAcessoBioTheme;
import com.acesso.acessobio_android.onboarding.camera.CameraListener;
import com.acesso.acessobio_android.onboarding.camera.UnicoCheckCamera;
import com.acesso.acessobio_android.onboarding.camera.UnicoCheckCameraOpener;
import com.acesso.acessobio_android.onboarding.models.Environment;
import com.acesso.acessobio_android.services.dto.ErrorBio;
import com.acesso.acessobio_android.services.dto.ResultCamera;
import com.google.gson.Gson;

public class LivenessActivity extends AppCompatActivity
        implements AcessoBioListener, iAcessoBioSelfie, CameraListener {

    private static final String TAG = "P1SDK_Liveness";
    private static final String SDK_VERSION = "2.0.20";
    private static final int CAMERA_PERMISSION_CODE = 100;

    private Resources resources;
    private AcessoBio acessoBio;
    private UnicoCheckCamera unicoCheckCamera;
    private String environmentLabel = "unknown";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.resources = this.getBaseContext().getResources();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
            } else {
                startLiveness(resources);
            }
        } else {
            startLiveness(resources);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLiveness(resources);
            } else {
                notifyError(buildDiagnosticError("onRequestPermissionsResult", "Permissão da câmera negada"));
            }
        }
    }

    private void startLiveness(Resources resources) {
        IAcessoBioTheme unicoTheme = new UnicoTheme(resources);

        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.containsKey("unicoConfig")) {
            notifyError(buildDiagnosticError("startLiveness", "unicoConfig ausente no Intent"));
            return;
        }

        String unicoConfig = extras.getString("unicoConfig");
        Log.d(TAG, "unicoConfig raw: " + unicoConfig); // diagnóstico: JSON que chegou no Intent
        UnicoConfig config = (new Gson()).fromJson(unicoConfig, UnicoConfig.class);
        if (config == null) {
            notifyError(buildDiagnosticError("startLiveness", "falha ao parsear unicoConfig"));
            return;
        }
        Log.d(TAG, "environment parsed: '" + config.getEnvironment() + "'"); // diagnóstico: campo após Gson

        config.setBundleIdentifier(getApplicationContext().getPackageName());

        Environment environment = resolveEnvironment(config.getEnvironment());
        if (environment == null) {
            notifyError(buildDiagnosticError("startLiveness",
                    "environment inválido ou ausente no JSON: '" + config.getEnvironment() + "'"));
            return;
        }
        environmentLabel = environment == Environment.PROD ? "PROD" : "UAT";

        try {
            this.acessoBio = new AcessoBio(this, this);

            this.acessoBio.setAutoCapture(false)
                    .setSmartFrame(false)
                    .setTheme(unicoTheme)
                    .setTimeoutSession(50)
                    .setEnvironment(environment);

            this.unicoCheckCamera = this.acessoBio.build();
            this.unicoCheckCamera.prepareCamera(config, this);
        } catch (Exception e) {
            notifyError(buildDiagnosticError("startLiveness", "exceção ao iniciar liveness: " + e.getMessage()));
        }
    }

    private Environment resolveEnvironment(String env) {
        if (env == null || env.trim().isEmpty()) {
            return null;
        }
        String normalized = env.trim().toUpperCase();
        if (normalized.contains("DEV") || normalized.contains("UAT")
                || normalized.contains("HOMOLOG") || normalized.equals("1")
                || normalized.contains("STA")) {
            return Environment.UAT;
        }
        if (normalized.contains("PRD") || normalized.contains("PROD")
                || normalized.contains("PRODUCTION") || normalized.equals("2")) {
            return Environment.PROD;
        }
        return null; // environment desconhecido: falha explícita, sem fallback
    }

    @Override
    public void onErrorAcessoBio(ErrorBio errorBio) {
        notifyError(formatErrorBio("onErrorAcessoBio", errorBio));
    }

    @Override
    public void onUserClosedCameraManually() {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    @Override
    public void onSystemClosedCameraTimeoutSession() {
        notifyError(buildDiagnosticError("onSystemClosedCameraTimeoutSession", "timeout de sessão da câmera"));
    }

    @Override
    public void onSystemChangedTypeCameraTimeoutFaceInference() {
        notifyError(buildDiagnosticError(
                "onSystemChangedTypeCameraTimeoutFaceInference",
                "timeout de inferência facial"
        ));
    }

    @Override
    public void onSuccessSelfie(ResultCamera resultCamera) {
        CallLib.liveNess(resultCamera, null);
        finish();
    }

    @Override
    public void onErrorSelfie(ErrorBio errorBio) {
        notifyError(formatErrorBio("onErrorSelfie", errorBio));
    }

    @Override
    public void onCameraReady(UnicoCheckCameraOpener.Camera camera) {
        camera.open(this);
    }

    @Override
    public void onCameraFailed(String message) {
        String detail = message != null && !message.isEmpty() ? message : "motivo não informado pela SDK";
        notifyError(buildDiagnosticError("onCameraFailed", detail));
    }

    private void notifyError(String message) {
        Log.e(TAG, message);
        CallLib.liveNess(null, message);
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    private String formatErrorBio(String source, ErrorBio errorBio) {
        if (errorBio == null) {
            return buildDiagnosticError(source, "ErrorBio nulo");
        }

        String detail = String.format(
                "code=%s desc=%s",
                errorBio.getCode(),
                errorBio.getDescription() != null ? errorBio.getDescription() : "null"
        );
        return buildDiagnosticError(source, detail);
    }

    private String buildDiagnosticError(String source, String detail) {
        return String.format(
                "[%s] %s | device=%s %s | android=%s | p1sdk=%s | env=%s | cameraPermission=%s",
                source,
                detail,
                Build.MANUFACTURER,
                Build.MODEL,
                Build.VERSION.RELEASE,
                SDK_VERSION,
                environmentLabel,
                hasCameraPermission() ? "GRANTED" : "DENIED"
        );
    }

    private boolean hasCameraPermission() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }
}
