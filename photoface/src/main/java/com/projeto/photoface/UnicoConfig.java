package com.projeto.photoface;

import androidx.annotation.NonNull;

import com.acesso.acessobio_android.onboarding.AcessoBioConfigDataSource;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class UnicoConfig implements AcessoBioConfigDataSource {

    @SerializedName("hostKey")
    private String hostKey = "";

    @SerializedName("environment")
    private String environment = "";

    @SerializedName("bundleIdentifier")
    private String bundleIdentifier = "";


    public String getEnvironment() {
        return environment != null ? environment : "";
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @NonNull
    @Override
    public String getBundleIdentifier() {
        return bundleIdentifier != null ? bundleIdentifier : "";
    }

    public void setBundleIdentifier(String bundleIdentifier) {
        this.bundleIdentifier = bundleIdentifier;
    }



    @NonNull
    @Override
    public String getHostKey() {
        return hostKey != null ? hostKey : "";
    }

    public void setHostKey(String hostKey) {
        this.hostKey = hostKey;
    }


}
