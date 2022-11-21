package com.projeto.photoface.callback;

import com.projeto.photoface.entity.body.Document;

import java.util.List;

public interface DocumentCallback {
    void onCapturedDocument(List<Document> documentList);
}

