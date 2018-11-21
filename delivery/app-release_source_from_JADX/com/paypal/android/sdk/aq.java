package com.paypal.android.sdk;

import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;

public class aq {
    private static aq f195a;
    private final HashMap f196b = m140a(am.m135b());

    private aq() {
    }

    public static synchronized aq m139a() {
        aq aqVar;
        synchronized (aq.class) {
            if (f195a == null) {
                f195a = new aq();
            }
            aqVar = f195a;
        }
        return aqVar;
    }

    private static HashMap m140a(KeyStore keyStore) {
        try {
            HashMap hashMap = new HashMap();
            Enumeration aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                String str = (String) aliases.nextElement();
                aq.class.getSimpleName();
                new StringBuilder("\t adding cert. alias:").append(str);
                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(str);
                if (x509Certificate != null) {
                    hashMap.put(x509Certificate.getSubjectX500Principal(), x509Certificate);
                }
            }
            return hashMap;
        } catch (KeyStoreException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean m141a(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = (X509Certificate) this.f196b.get(x509Certificate.getSubjectX500Principal());
        return x509Certificate2 != null && x509Certificate2.getPublicKey().equals(x509Certificate.getPublicKey());
    }

    public final X509Certificate m142b(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = (X509Certificate) this.f196b.get(x509Certificate.getIssuerX500Principal());
        if (x509Certificate2 == null) {
            return null;
        }
        if (x509Certificate2.getSubjectX500Principal().equals(x509Certificate.getSubjectX500Principal())) {
            return null;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return x509Certificate2;
        } catch (GeneralSecurityException e) {
            return null;
        }
    }
}
