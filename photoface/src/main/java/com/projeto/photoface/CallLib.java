package com.projeto.photoface;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;

import com.facetec.sdk.FaceTecFaceScanResultCallback;
import com.facetec.sdk.FaceTecSDK;
import com.facetec.sdk.FaceTecSessionResult;
import com.otaliastudios.cameraview.PictureResult;
import com.projeto.photoface.callback.DocumentCallback;
import com.projeto.photoface.callback.FaceCallback;
import com.projeto.photoface.entity.body.Document;

import java.util.ArrayList;
import java.util.List;

public class CallLib {

    private static FaceCallback faceCallback;
    private static DocumentCallback documentCallback;
    private static Context mContext;

    public static void startDocumentCapture(Context context) {
        Intent intent = new Intent(context, CameraDocumentActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    protected static void initFaceCapture(Context context, String sessionToken) {
        Intent intent = new Intent(context, LivenessActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("sessionToken",sessionToken);
        context.startActivity(intent);
    }

    public static void startFaceCapture(
            Context context,
            String certKey,
            String deviceKeyIdentifier,
            String productionKeyText,
            String sessionToken
    ) {
        mContext = context;

        Config.initializeFaceTecSDKFromAutogeneratedConfig(
                mContext,
                deviceKeyIdentifier,
                certKey,
                productionKeyText,
                new FaceTecSDK.InitializeCallback() {
                    @Override
                    public void onCompletion(boolean b) {
                        initFaceCapture(mContext,sessionToken);
                    }
                });
        ThemeHelpers.setAppTheme(mContext, "Pseudo-Fullscreen");
    }

    public static void faceListener(FaceCallback callback) {
        faceCallback = callback;
    }

    public static void docListener(DocumentCallback callback) {
        documentCallback = callback;
    }


    protected static void liveNess(
            FaceTecSessionResult faceTecSessionResult,
            FaceTecFaceScanResultCallback faceTecFaceScanResultCallback
    ) {
        String faceScan = faceTecSessionResult.getFaceScanBase64();
        String auditTrailImage = faceTecSessionResult.getAuditTrailCompressedBase64()[0];
        String lowQualityAuditTrailImage = faceTecSessionResult.getLowQualityAuditTrailCompressedBase64()[0];

        faceCallback.onCapturedFace(faceScan, auditTrailImage, lowQualityAuditTrailImage);
        faceTecFaceScanResultCallback.cancel();
    }

    protected static void sendDocument(PictureResult frente, PictureResult verso) {

        List<Document> listDoc = new ArrayList<>();
        Document frenteDoc = new Document();
        frenteDoc.setType("FRENTE");
        frenteDoc.setByte(Base64.encodeToString(frente.getData(), Base64.DEFAULT).replaceAll("\n", ""));
        Document versoDoc = new Document();
        versoDoc.setType("VERSO");
        versoDoc.setByte(Base64.encodeToString(verso.getData(), Base64.DEFAULT).replaceAll("\n", ""));
        listDoc.add(frenteDoc);
        listDoc.add(versoDoc);

        documentCallback.onCapturedDocument(listDoc);
    }

        public static String createUserAgentForNewSession(){
            return FaceTecSDK.createFaceTecAPIUserAgentString("");
        }

    public static String createUserAgentForSession(String sessionId){
        return FaceTecSDK.createFaceTecAPIUserAgentString(sessionId);
    }

}
