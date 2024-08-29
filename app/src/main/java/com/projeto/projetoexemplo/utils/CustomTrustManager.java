package com.projeto.projetoexemplo.utils;

import java.security.cert.CertificateException;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class CustomTrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
        // Não faz nada, aceitando qualquer cliente
    }

    @Override
    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
        // Não faz nada, aceitando qualquer servidor
    }

    @Override
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return new java.security.cert.X509Certificate[]{};
    }

    public static TrustManager[] getTrustManagers() {
        return new TrustManager[]{new CustomTrustManager()};
    }
}
