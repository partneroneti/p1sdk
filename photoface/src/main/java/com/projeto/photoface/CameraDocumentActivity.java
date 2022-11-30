package com.projeto.photoface;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.size.SizeSelectors;
import com.projeto.photoface.callback.DocumentCallback;
import com.projeto.photoface.entity.body.Document;

import java.util.List;

public class CameraDocumentActivity extends AppCompatActivity implements DocumentCallback {

    PictureResult frente;
    PictureResult verso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_document);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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

        btn.setOnClickListener(view -> camera.takePictureSnapshot());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCapturedDocument(List<Document> documentList) {
        finish();
    }
}