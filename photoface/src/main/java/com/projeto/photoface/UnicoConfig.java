package com.projeto.photoface;

import androidx.annotation.NonNull;

import com.acesso.acessobio_android.onboarding.AcessoBioConfigDataSource;

public class UnicoConfig implements AcessoBioConfigDataSource {

    private String hostKey;
    private String hostInfo;
    private String projectId;
    private String projectNumber;
    private String mobilesdkAppId;
    private String bundleIdentifier;

    @NonNull
    @Override
    public String getHostKey() {
        return hostKey != null ? hostKey : "";
    }

    public void setHostKey(String hostKey) {
        this.hostKey = hostKey;
    }

    @Override
    public String getHostInfo() {
        return hostInfo != null ? hostInfo : "";
    }

    public void setHostInfo(String hostInfo) {
        this.hostInfo = hostInfo;
    }

    @Override
    public String getProjectId() {
        return projectId != null ? projectId : "";
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public String getProjectNumber() {
        return projectNumber != null ? projectNumber : "";
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getMobilesdkAppId() {
        return mobilesdkAppId != null ? mobilesdkAppId : "";
    }

    public void setMobilesdkAppId(String mobilesdkAppId) {
        this.mobilesdkAppId = mobilesdkAppId;
    }

    @NonNull
    @Override
    public String getBundleIdentifier() {
        return bundleIdentifier != null ? bundleIdentifier : "";
    }

    public void setBundleIdentifier(String bundleIdentifier) {
        this.bundleIdentifier = bundleIdentifier;
    }
}
