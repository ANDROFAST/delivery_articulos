package com.paypal.android.sdk;

import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;

public class ba {
    private static ba f307a;
    private final HashMap f308b = m250a(aW.m115b());

    private ba() {
    }

    public static synchronized ba m249a() {
        ba baVar;
        synchronized (ba.class) {
            if (f307a == null) {
                f307a = new ba();
            }
            baVar = f307a;
        }
        return baVar;
    }

    private static HashMap m250a(KeyStore keyStore) {
        try {
            HashMap hashMap = new HashMap();
            Enumeration aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                String str = (String) aliases.nextElement();
                ba.class.getSimpleName();
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

    public final boolean m251a(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = (X509Certificate) this.f308b.get(x509Certificate.getSubjectX500Principal());
        return x509Certificate2 != null && x509Certificate2.getPublicKey().equals(x509Certificate.getPublicKey());
    }

    public final X509Certificate m252b(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = (X509Certificate) this.f308b.get(x509Certificate.getIssuerX500Principal());
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
