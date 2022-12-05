package com.projeto.photoface;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.PorterDuff;
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

    private PictureResult frente;
    private PictureResult verso;

    private Button btnCapture;
    private Button btnBack;
    private TextView textTitle;

    protected static final String BUTTON_COLOR = "BUTTON_COLOR";
    protected static final String BUTTON_TEXT_COLOR = "BUTTON_TEXT_COLOR";
    protected static final String TEXT_COLOR = "TEXT_COLOR";
    protected static final String TITLE_FRONT = "Frente";
    protected static final String TITLE_BACK = "Verso";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_document);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        CameraView camera = findViewById(R.id.cameraDoc);
        textTitle = findViewById(R.id.title_text);
        btnCapture = findViewById(R.id.button);
        btnBack = findViewById(R.id.btn_back);

        setLayoutCustomColor();

        textTitle.setText(TITLE_FRONT);
        camera.setLifecycleOwner(this);
        camera.setPictureSize(SizeSelectors.smallest());
        camera.addCameraListener(new CameraListener() {
            @Override
            public void onPictureTaken(PictureResult result) {
                if (frente == null) {
                    frente = result;
                    textTitle.setText(TITLE_BACK);
                } else {
                    verso = result;
                }
                if (frente != null && verso != null) {
                    btnCapture.setEnabled(false);
                    CallLib.sendDocument(frente, verso);
                }

            }
        });

        btnCapture.setOnClickListener(view -> camera.takePictureSnapshot());
        btnBack.setOnClickListener(view -> finish());
    }

    private void setLayoutCustomColor() {

        String buttonColor = getIntent().getStringExtra(BUTTON_COLOR);
        String buttonTextColor = getIntent().getStringExtra(BUTTON_TEXT_COLOR);
        String textColor = getIntent().getStringExtra(TEXT_COLOR);

        btnCapture.getBackground().setColorFilter(Color.parseColor(buttonColor), PorterDuff.Mode.SRC_OVER);
        btnCapture.setTextColor(Color.parseColor(buttonTextColor));
        textTitle.setTextColor(Color.parseColor(textColor));
        btnBack.setTextColor(Color.parseColor(textColor));

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