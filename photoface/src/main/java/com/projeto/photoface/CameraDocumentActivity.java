package com.projeto.photoface;

import android.content.pm.ActivityInfo;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;

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
    private PictureResult pictureResult;

    private Button btnCapture;
    private Button btnBack;
    private TextView textTitle, previewTitle;
    private CameraView camera;
    private ImageView capturePreview;

    private boolean isPreview = false;

    protected static final String BUTTON_COLOR = "BUTTON_COLOR";
    protected static final String BUTTON_TEXT_COLOR = "BUTTON_TEXT_COLOR";
    protected static final String TEXT_COLOR = "TEXT_COLOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_document);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        camera = findViewById(R.id.cameraDoc);
        textTitle = findViewById(R.id.title_text);
        btnCapture = findViewById(R.id.button);
        btnBack = findViewById(R.id.btn_back);
        capturePreview = findViewById(R.id.captureResultImage);
        previewTitle = findViewById(R.id.previewTitleText);

        setLayoutCustomColor();

        textTitle.setText(getString(R.string.photoface_document_title_front_text));
        camera.setLifecycleOwner(this);
        camera.setPictureSize(SizeSelectors.smallest());
        camera.setUseDeviceOrientation(false);
        camera.addCameraListener(new CameraListener() {
            @Override
            public void onPictureTaken(PictureResult result) {
                pictureResult = result;
                showPreview(result);
            }
        });

        btnCapture.setOnClickListener(view -> {
            if (isPreview) {
                setPicture(pictureResult);
                isPreview = false;
                if (frente == null || verso == null) {
                    isPreviewEnabled(false);
                }
            } else {
                camera.takePictureSnapshot();
            }
        });
        btnBack.setOnClickListener(view -> {
            if (isPreview)  {
                isPreview = false;
                isPreviewEnabled(false);
            } else {
                finish();
            }
        });
    }

    private void setPicture(PictureResult result) {
        if (frente == null) {
            frente = result;
            textTitle.setText(R.string.photoface_document_title_back_text);
        } else {
            verso = result;
        }
        if (frente != null && verso != null) {
            btnCapture.setEnabled(false);
            CallLib.sendDocument(frente, verso);
        }
    }

    private void showPreview(PictureResult result) {
        isPreview = true;
        capturePreview.setImageBitmap(BitmapFactory.decodeByteArray(result.getData(), 0, result.getData().length));
        isPreviewEnabled(true);
    }

    private void isPreviewEnabled(boolean isPreview) {

        if (isPreview) {
            capturePreview.setVisibility(View.VISIBLE);
            camera.setVisibility(View.GONE);
            previewTitle.setVisibility(View.VISIBLE);
            btnCapture.setText(R.string.photoface_document_yes_text);
            btnBack.setText(R.string.photoface_document_remake_text);
        } else {
            capturePreview.setVisibility(View.GONE);
            camera.setVisibility(View.VISIBLE);
            previewTitle.setVisibility(View.GONE);
            btnCapture.setText(R.string.photoface_document_capture_button_text);
            btnBack.setText(R.string.photoface_document_back_button_text);
        }
    }

    private void setLayoutCustomColor() {

        String buttonColor = getIntent().getStringExtra(BUTTON_COLOR);
        String buttonTextColor = getIntent().getStringExtra(BUTTON_TEXT_COLOR);
        String textColor = getIntent().getStringExtra(TEXT_COLOR);

        btnCapture.getBackground().setColorFilter(
                BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                        Color.parseColor(buttonColor),
                        BlendModeCompat.SRC_ATOP
                )
        );
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