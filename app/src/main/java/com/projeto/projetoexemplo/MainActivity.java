package com.projeto.projetoexemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import com.projeto.photoface.CallBackCapture;
import com.projeto.photoface.CallLib;
import com.projeto.photoface.MaskUtil;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    String cert = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5PxZ3DLj+zP6T6HFgzzk\n" +
            "M77LdzP3fojBoLasw7EfzvLMnJNUlyRb5m8e5QyyJxI+wRjsALHvFgLzGwxM8ehz\n" +
            "DqqBZed+f4w33GgQXFZOS4AOvyPbALgCYoLehigLAbbCNTkeY5RDcmmSI/sbp+s6\n" +
            "mAiAKKvCdIqe17bltZ/rfEoL3gPKEfLXeN549LTj3XBp0hvG4loQ6eC1E1tRzSkf\n" +
            "GJD4GIVvR+j12gXAaftj3ahfYxioBH7F7HQxzmWkwDyn3bqU54eaiB7f0ftsPpWM\n" +
            "ceUaqkL2DZUvgN0efEJjnWy5y1/Gkq5GGWCROI9XG/SwXJ30BbVUehTbVcD70+ZF\n" +
            "8QIDAQAB\n" +
            "-----END PUBLIC KEY-----";

    String key = "d07TsYFnYXn0d4d2jc58BMgfhGfYPfXN";
    String urlPadrao = "https://testapi.io/api/pgdev/";
    String urlDocLive = "https://webhook.site/";
    String user = "xxx";
    String password = "xxxx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Activity act = this;
        Button btn = findViewById(R.id.button2);
        EditText edt = findViewById(R.id.editTextNumber2);

        edt.addTextChangedListener(MaskUtil.insert(edt));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setEnabled(false);

                CallLib.start(act, cert, key, urlPadrao, user, password, urlDocLive);
                CallLib.call(edt.getText().toString(), new CallBackCapture() {
                    @Override
                    public void finish() {
                        btn.setEnabled(true);
                        Intent intent = new Intent(getApplicationContext(), StatusActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });

            }
        });
    }
}