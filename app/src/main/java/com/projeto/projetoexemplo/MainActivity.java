package com.projeto.projetoexemplo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.projeto.photoface.CallBackCapture;
import com.projeto.photoface.CallLib;
import com.projeto.photoface.MaskUtil;
import com.projeto.photoface.entity.body.DocumentBody;
import com.projeto.photoface.entity.response.AuthObj;
import com.projeto.photoface.entity.response.CpfObj;
import com.projeto.photoface.entity.response.LivenessResponse;
import com.projeto.photoface.entity.response.SessionLiveResponse;
import com.projeto.photoface.entity.response.StatusObj;

public class MainActivity extends AppCompatActivity {

    String certKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5PxZ3DLj+zP6T6HFgzzk\n" +
            "M77LdzP3fojBoLasw7EfzvLMnJNUlyRb5m8e5QyyJxI+wRjsALHvFgLzGwxM8ehz\n" +
            "DqqBZed+f4w33GgQXFZOS4AOvyPbALgCYoLehigLAbbCNTkeY5RDcmmSI/sbp+s6\n" +
            "mAiAKKvCdIqe17bltZ/rfEoL3gPKEfLXeN549LTj3XBp0hvG4loQ6eC1E1tRzSkf\n" +
            "GJD4GIVvR+j12gXAaftj3ahfYxioBH7F7HQxzmWkwDyn3bqU54eaiB7f0ftsPpWM\n" +
            "ceUaqkL2DZUvgN0efEJjnWy5y1/Gkq5GGWCROI9XG/SwXJ30BbVUehTbVcD70+ZF\n" +
            "8QIDAQAB\n" +
            "-----END PUBLIC KEY-----";

    String deviceKeyIdentifier = "d07TsYFnYXn0d4d2jc58BMgfhGfYPfXN";
    String baseUrl = "https://testapi.io/api/pgdev/";
    String urlDocLive = "https://webhook.site/";
    String user = "xxx";
    String password = "xxxx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Context mContext = this;
        Button btn = findViewById(R.id.button2);
        EditText edt = findViewById(R.id.editTextNumber2);

        edt.addTextChangedListener(MaskUtil.insert(edt));

        btn.setOnClickListener(view -> {
            btn.setEnabled(false);

            CallLib.start(
                    mContext,
                    certKey,
                    deviceKeyIdentifier,
                    baseUrl,
                    user,
                    password,
                    urlDocLive
            );
            CallLib.call(edt.getText().toString(), new CallBackCapture() {
                @Override
                public void finish() {
                    btn.setEnabled(true);
                    Intent intent = new Intent(getApplicationContext(), StatusActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

                @Override
                public void onAuthObjResponse(AuthObj authObj) {
                    Log.d("CallLib", "onAuthObjResponse: " + authObj);
                }

                @Override
                public void onCpfObjResponse(CpfObj cpfObj) {
                    Log.d("CallLib", "onCpfObjResponse: " + cpfObj);
                }

                @Override
                public void onStatusObjResponse(StatusObj statusObj) {
                    Log.d("CallLib", "onStatusObjResponse: " + statusObj);
                }

                @Override
                public void onSessionLiveResponse(SessionLiveResponse sessionLiveResponse) {
                    Log.d("CallLib", "onSessionLiveResponse: " + sessionLiveResponse);

                }

                @Override
                public void onLivenessResponse(LivenessResponse livenessResponse) {
                    Log.d("CallLib", "onLivenessResponse: " + livenessResponse);

                }

                @Override
                public void onDocumentBodyResponse(DocumentBody documentBody) {
                    Log.d("CallLib", "onDocumentBodyResponse: " + documentBody);
                }
            });
        });
    }
}