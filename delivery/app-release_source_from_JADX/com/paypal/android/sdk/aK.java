package com.paypal.android.sdk;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public final class aK implements X509TrustManager {
    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
