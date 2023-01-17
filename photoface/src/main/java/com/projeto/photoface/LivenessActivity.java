package com.projeto.photoface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.facetec.sdk.FaceTecFaceScanProcessor;
import com.facetec.sdk.FaceTecFaceScanResultCallback;
import com.facetec.sdk.FaceTecSDK;
import com.facetec.sdk.FaceTecSessionActivity;
import com.facetec.sdk.FaceTecSessionResult;

public class LivenessActivity extends AppCompatActivity {

    public FaceTecFaceScanProcessor ftsp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Context context = this;
        ftsp = new FaceTecFaceScanProcessor() {
            @Override
            public void processSessionWhileFaceTecSDKWaits(
                    FaceTecSessionResult faceTecSessionResult,
                    FaceTecFaceScanResultCallback faceTecFaceScanResultCallback
            ) {
                if (faceTecSessionResult.getStatus().name().equals("USER_CANCELLED")) {
                    faceTecFaceScanResultCallback.cancel();
                    finish();
                } else {
                    CallLib.liveNess(faceTecSessionResult, faceTecFaceScanResultCallback);
                }

            }
        };

        Bundle extras = getIntent().getExtras();

        String sessionToken = extras.getString("sessionToken");


        FaceTecSessionActivity.createAndLaunchSession(context, ftsp, sessionToken);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}