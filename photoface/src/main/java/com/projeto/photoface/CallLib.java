package com.projeto.photoface;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;


import com.acesso.acessobio_android.services.dto.ResultCamera;
import com.otaliastudios.cameraview.PictureResult;
import com.projeto.photoface.callback.DocumentCallback;
import com.projeto.photoface.callback.FaceCallback;
import com.projeto.photoface.entity.body.Document;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CallLib {

    private static FaceCallback faceCallback;
    private static DocumentCallback documentCallback;
    private static Context mContext;

    public static void startDocumentCapture(
            Context context,
            String buttonHexaColor,
            String buttonTextHexaColor,
            String textHexaColor
    ) {
        Intent intent = new Intent(context, CameraDocumentActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(CameraDocumentActivity.BUTTON_COLOR, buttonHexaColor);
        intent.putExtra(CameraDocumentActivity.BUTTON_TEXT_COLOR, buttonTextHexaColor);
        intent.putExtra(CameraDocumentActivity.TEXT_COLOR, textHexaColor);
        context.startActivity(intent);
    }

    protected static void initFaceCapture(Context context, String sessionToken) {
        Intent intent = new Intent(context, LivenessActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("sessionToken", sessionToken);
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

        Intent intent = new Intent(context, LivenessActivity.class);
        intent.putExtra("unicoConfig",new String(Base64.decode(certKey.getBytes(StandardCharsets.UTF_8),Base64.DEFAULT)));
        context.startActivity(intent);
    }

    public static void faceListener(FaceCallback callback) {
        faceCallback = callback;
    }

    public static void docListener(DocumentCallback callback) {
        documentCallback = callback;
    }


    protected static void liveNess(
            ResultCamera result,String error
            //FaceTecSessionResult faceTecSessionResult,
            //FaceTecFaceScanResultCallback faceTecFaceScanResultCallback
    ) {
         if(error!=null){
//           faceCallback.onCapturedFace(null,null,null, error);
           faceCallback.onError(error);
           return;
        }
        String faceScan =result.getEncrypted()+"/u";
        String auditTrailImage = result.getBase64();
        String lowQualityAuditTrailImage ="";// faceTecSessionResult.getLowQualityAuditTrailCompressedBase64()[0];

        faceCallback.onCapturedFace(faceScan, auditTrailImage, lowQualityAuditTrailImage, null);
        // faceTecFaceScanResultCallback.cancel();
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

    public static String createUserAgentForNewSession() {
        return "";// FaceTecSDK.createFaceTecAPIUserAgentString("");
    }

    public static String createUserAgentForSession(String sessionId) {
        return "";//FaceTecSDK.createFaceTecAPIUserAgentString(sessionId);
    }

}
