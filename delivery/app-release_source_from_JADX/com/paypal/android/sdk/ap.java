package com.paypal.android.sdk;

import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.X509TrustManager;

public final class ap implements X509TrustManager {
    private final aq f192a;
    private final List f193b = new LinkedList();
    private final Set f194c = Collections.synchronizedSet(new HashSet());

    public ap(aq aqVar) {
        this.f192a = aqVar;
        String[] strArr = an.f188a;
        for (int i = 0; i < 2; i++) {
            this.f193b.add(m138a(strArr[i]));
        }
    }

    private boolean m137a(X509Certificate x509Certificate) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.f193b) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            throw new CertificateException(e);
        }
    }

    private static byte[] m138a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("Client certificates not supported!");
    }

    public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (!this.f194c.contains(x509CertificateArr[0])) {
            for (X509Certificate a : new am(x509CertificateArr, this.f192a).m136a()) {
                if (m137a(a)) {
                    this.f194c.add(x509CertificateArr[0]);
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
    }

    public final X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
