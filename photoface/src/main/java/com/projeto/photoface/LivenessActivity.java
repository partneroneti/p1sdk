package com.projeto.photoface;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.acesso.acessobio_android.AcessoBioListener;
import com.acesso.acessobio_android.iAcessoBioSelfie;
import com.acesso.acessobio_android.onboarding.AcessoBio;
import com.acesso.acessobio_android.onboarding.AcessoBioConfigDataSource;
import com.acesso.acessobio_android.onboarding.IAcessoBioBuilder;
import com.acesso.acessobio_android.onboarding.IAcessoBioTheme;
import com.acesso.acessobio_android.onboarding.camera.CameraListener;
import com.acesso.acessobio_android.onboarding.camera.UnicoCheckCamera;
import com.acesso.acessobio_android.onboarding.camera.UnicoCheckCameraOpener;
import com.acesso.acessobio_android.services.dto.ErrorBio;
import com.acesso.acessobio_android.services.dto.ResultCamera;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;


public class LivenessActivity extends AppCompatActivity
        implements AcessoBioListener,iAcessoBioSelfie,CameraListener {

    private static final int CAMERA_PERMISSION_CODE = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String packageName = getApplicationContext().getPackageName();
        Resources resources = this.getBaseContext().getResources();

        // Verifica se a versão do Android é 6.0 (API 23) ou superior
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Se for Android 6.0 ou superior, verificar e solicitar a permissão
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
            } else {
                startLiveness(resources);
            }
        } else {
            // Para Android 5.0 e 5.1, a permissão já foi concedida na instalação
            startLiveness(resources);
        }

    }

    private void startLiveness(Resources resources) {
        IAcessoBioTheme unicoTheme = new UnicoTheme(resources);

        Bundle extras =  getIntent().getExtras();
        String unicoConfig = (String)extras.get("unicoConfig");
        UnicoConfig config = (new Gson()).fromJson(unicoConfig,UnicoConfig.class);
        try {
            new AcessoBio(this, this)
                    .setAutoCapture(false)
                    .setSmartFrame(false)
                    .setTheme(unicoTheme)
                    .setTimeoutSession(50)
                    .build()
                    .prepareCamera(config, this)
            ;
        }catch (Exception e){
            Log.e(this.getClass().getSimpleName(),e.toString());
        }
    }

    @Override
    public void onErrorAcessoBio(ErrorBio errorBio) {
        TextView textViewDescription = findViewById(R.id.textViewDescription);
        textViewDescription.setText(errorBio.getDescription());
    }

    @Override
    public void onUserClosedCameraManually() {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    @Override
    public void onSystemClosedCameraTimeoutSession() {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    @Override
    public void onSystemChangedTypeCameraTimeoutFaceInference() {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    @Override
    public void onSuccessSelfie(ResultCamera resultCamera) {
        CallLib.liveNess(resultCamera,null);
        finish();
    }

    @Override
    public void onErrorSelfie(ErrorBio errorBio) {
        TextView textViewDescription = findViewById(R.id.textViewDescription);
        textViewDescription.setText(errorBio.getDescription());
        finish();
    }

    @Override
    public void onCameraReady(UnicoCheckCameraOpener.Camera camera) {
        camera.open(this);
    }

    @Override
    public void onCameraFailed(String s) {

        Log.e("ERROR", s);
    }
}