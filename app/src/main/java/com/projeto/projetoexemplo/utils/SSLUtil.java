package com.projeto.projetoexemplo.utils;

import java.security.SecureRandom;

import javax.net.ssl.SSLContext;

public class SSLUtil {
    public static void configureGlobalSSLContext() {
        try {
            // Configura o SSLContext para usar nosso TrustManager que aceita todos os certificados
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, CustomTrustManager.getTrustManagers(), new SecureRandom());

            // Define o SSLContext padrão para todas as conexões HTTPS
            SSLContext.setDefault(sslContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
