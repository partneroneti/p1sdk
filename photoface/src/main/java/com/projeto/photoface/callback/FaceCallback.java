package com.projeto.photoface.callback;

public interface FaceCallback {
    void onCapturedFace(
            String faceScan,
            String auditTrailImage,
            String lowQualityAuditTrailImage,
            String error
    );
}
