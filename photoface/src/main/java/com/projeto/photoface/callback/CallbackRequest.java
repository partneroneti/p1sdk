package com.projeto.photoface.callback;

import com.projeto.photoface.entity.body.DocumentBody;
import com.projeto.photoface.entity.response.AuthObj;
import com.projeto.photoface.entity.response.CpfObj;
import com.projeto.photoface.entity.response.SessionLiveResponse;
import com.projeto.photoface.entity.response.StatusObj;

public interface CallbackRequest {
    void onAuthObjResponse(AuthObj authObj);
    void onCpfObjResponse(CpfObj cpfObj);
    void onStatusObjResponse(StatusObj statusObj);
    void onSessionLiveResponse(SessionLiveResponse sessionLiveResponse);
    void onDocumentBodyResponse(DocumentBody documentBody);
}
