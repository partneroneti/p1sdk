package com.projeto.photoface;

import androidx.annotation.NonNull;

import com.acesso.acessobio_android.onboarding.AcessoBioConfigDataSource;

import org.jetbrains.annotations.NotNull;

public class UnicoConfig implements AcessoBioConfigDataSource {

    private String hostKey;
    private String environment;
    private String bundleIdentifier;


    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @NonNull
    @Override
    public String getBundleIdentifier() {
        return bundleIdentifier;
    }

    public void setBundleIdentifier(String bundleIdentifier) {
        this.bundleIdentifier = bundleIdentifier;
    }



    @NonNull
    @Override
    public String getHostKey() {
        return hostKey;
    }

    public void setHostKey(String hostKey) {
        this.hostKey = hostKey;
    }


}
