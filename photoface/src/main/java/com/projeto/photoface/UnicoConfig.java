package com.projeto.photoface;

import androidx.annotation.NonNull;

import com.acesso.acessobio_android.onboarding.AcessoBioConfigDataSource;

public class UnicoConfig implements AcessoBioConfigDataSource {

    @NonNull
    @Override
    public String getBundleIdentifier() {
        return "com.projeto.projetoexemplo";
    }

    @NonNull
    @Override
    public String getHostKey() {
        return "F/c0dcA4RT2GnaqxrwpFpUnaJkVrKXLwRvUmlbwAVERLOdUWVer6rXC4/iWPu0Ou";
    }

    @Override
    public String getProjectNumber() {
        return "9200425810982653706";
    }

    @Override
    public String getProjectId() {
        return "crefisa";
    }

    @Override
    public String getMobileSdkAppId() {
        return "1:59150:android";
    }

    @Override
    public String getHostInfo() {
        return "nRMqSJJeWMZ0K4n9Dxs/Zhb5RslAxes+pmH0gJgmVtZdwNyOQ5wThBl1Sd+1hKs+D0gFCgAOsDVc6cWdPbtDMQ==";
    }
}
