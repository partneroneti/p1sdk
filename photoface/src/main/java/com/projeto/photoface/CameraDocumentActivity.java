package com.projeto.photoface;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.size.SizeSelectors;

public class CameraDocumentActivity extends AppCompatActivity {

    PictureResult frente;
    PictureResult verso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_document);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        CameraView camera = findViewById(R.id.cameraDoc);
        TextView tv = findViewById(R.id.textView2);
        Button btn = findViewById(R.id.button);

        tv.setText("FRENTE");
        camera.setLifecycleOwner(this);
        camera.setPictureSize(SizeSelectors.smallest());
        camera.addCameraListener(new CameraListener() {
            @Override
            public void onPictureTaken(PictureResult result) {
                if (frente == null) {
                    frente = result;
                    tv.setText("VERSO");
                } else {
                    verso = result;
                }
                if (frente != null && verso != null) {
                    btn.setEnabled(false);
                    CallLib.sendDocument(frente, verso);
                }

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camera.takePictureSnapshot();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}