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

public final class aZ implements X509TrustManager {
    private final ba f172a;
    private final List f173b = new LinkedList();
    private final Set f174c = Collections.synchronizedSet(new HashSet());

    public aZ(ba baVar) {
        this.f172a = baVar;
        String[] strArr = aX.f168a;
        for (int i = 0; i < 2; i++) {
            this.f173b.add(m118a(strArr[i]));
        }
    }

    private boolean m117a(X509Certificate x509Certificate) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.f173b) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            throw new CertificateException(e);
        }
    }

    private static byte[] m118a(String str) {
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
        if (!this.f174c.contains(x509CertificateArr[0])) {
            for (X509Certificate a : new aW(x509CertificateArr, this.f172a).m116a()) {
                if (m117a(a)) {
                    this.f174c.add(x509CertificateArr[0]);
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
