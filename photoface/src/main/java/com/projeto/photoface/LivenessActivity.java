package com.projeto.photoface;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
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


public class LivenessActivity extends AppCompatActivity {


    private final AcessoBioListener callback = new AcessoBioListener() {
        @Override
        public void onErrorAcessoBio(ErrorBio errorBio) { }

        @Override
        public void onUserClosedCameraManually() { }

        @Override
        public void onSystemClosedCameraTimeoutSession() { }

        @Override
        public void onSystemChangedTypeCameraTimeoutFaceInference() { }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String packageName = getApplicationContext().getPackageName();
        Resources resources = this.getBaseContext().getResources();
        IAcessoBioBuilder acessoBioBuilder = new AcessoBio(this, callback);

        IAcessoBioTheme unicoTheme = new IAcessoBioTheme() {
            @Override
            public Object getColorBackground() {
                return resources.getColor( R.color.liveness_background);
            }

            @Override
            public Object getColorBoxMessage() {
                return resources.getColor( R.color.liveness_color_box_message);
            }

            @Override
            public Object getColorTextMessage() {
                return resources.getColor( R.color.liveness_color_text_message);
            }

            @Override
            public Object getColorBackgroundPopupError() {
                return resources.getColor( R.color.liveness_color_popup_error);
            }

            @Override
            public Object getColorTextPopupError() {
                return resources.getColor( R.color.liveness_color_text_popup_error);
            }

            @Override
            public Object getColorBackgroundButtonPopupError() {
                return resources.getColor( R.color.liveness_color_button_popup_error);
            }

            @Override
            public Object getColorTextButtonPopupError() {
                return resources.getColor( R.color.liveness_color_text_button_popup_error);
            }

            @Override
            public Object getColorBackgroundTakePictureButton() {
                return resources.getColor( R.color.liveness_color_background_take_picture_button);
            }

            @Override
            public Object getColorIconTakePictureButton() {
                return resources.getColor( R.color.liveness_color_icon_take_picture_button);
            }

            @Override
            public Object getColorBackgroundBottomDocument() {
                return resources.getColor( R.color.liveness_color_background_document_button);
            }

            @Override
            public Object getColorTextBottomDocument() {
                return resources.getColor( R.color.liveness_color_text_button_document);
            }

            @Override
            public Object getColorSilhouetteSuccess() {
                return resources.getColor( R.color.liveness_color_silhouette_success);
            }

            @Override
            public Object getColorSilhouetteError() {
                return resources.getColor( R.color.liveness_color_silhouette_success_error);
            }

            @Override
            public Object getColorSilhouetteNeutral() {
                return resources.getColor( R.color.liveness_color_silhouette_neutral);
            }
        };

        acessoBioBuilder.setTheme(unicoTheme);

        UnicoCheckCamera unicoCheckCamera = acessoBioBuilder
                .setAutoCapture(false)
                .setSmartFrame(false)
                .build();

        AcessoBioConfigDataSource unicoConfig = new AcessoBioConfigDataSource() {

            @Override
            public String getHostKey() {
                return resources.getString(R.string.host_key);
            }

            @Override
            public String getHostInfo() {
                return resources.getString(R.string.host_info);
            }

            @Override
            public String getBundleIdentifier() {
                return "";
            }

            @Override
            public String getMobileSdkAppId() {
                return resources.getString(R.string.mobilesdk_app_id);
            }

            @Override
            public String getProjectId() {
                return resources.getString(R.string.project_id);
            }

            @Override
            public String getProjectNumber() {
                return resources.getString(R.string.project_number);
            }
        };


        iAcessoBioSelfie cameraListener = new iAcessoBioSelfie() {
            @Override
            public void onSuccessSelfie(ResultCamera result) {
                CallLib.liveNess(result,null);
            }

            @Override
            public void onErrorSelfie(ErrorBio errorBio) {
                TextView textViewDescription = findViewById(R.id.textViewDescription);
                textViewDescription.setText(errorBio.getDescription());
            }
        };

        unicoCheckCamera.prepareCamera(unicoConfig, new CameraListener() {
            public void onCameraReady(UnicoCheckCameraOpener.Camera cameraOpener) {
                cameraOpener.open(cameraListener);
            }

            @Override
            public void onCameraFailed(String message) {

                Log.e("ERROR", message);

            }
        });
    }
}