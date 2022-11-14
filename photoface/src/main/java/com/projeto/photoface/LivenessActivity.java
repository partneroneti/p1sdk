package com.projeto.photoface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
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
        getSupportActionBar().hide();
        Context context = this;
        ftsp = new FaceTecFaceScanProcessor() {
            @Override
            public void processSessionWhileFaceTecSDKWaits(FaceTecSessionResult faceTecSessionResult, FaceTecFaceScanResultCallback faceTecFaceScanResultCallback) {
                CallLib.callLiveSession(faceTecSessionResult, faceTecFaceScanResultCallback);
            }
        };

        FaceTecSessionActivity.createAndLaunchSession(context, ftsp);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}