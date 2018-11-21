package com.paypal.android.sdk;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

class aW {
    private X509Certificate[] f166a;
    private ba f167b;

    aW(X509Certificate[] x509CertificateArr, ba baVar) {
        this.f166a = x509CertificateArr;
        this.f167b = baVar;
    }

    private static boolean m114a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getIssuerX500Principal())) {
            return false;
        }
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            return true;
        } catch (GeneralSecurityException e) {
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.security.KeyStore m115b() {
        /*
        r0 = "BKS";
        r1 = java.security.KeyStore.getInstance(r0);	 Catch:{ KeyStoreException -> 0x001f, NoSuchAlgorithmException -> 0x0041, CertificateException -> 0x004f, NotFoundException -> 0x0056, IOException -> 0x005d }
        r0 = com.paypal.android.sdk.aX.f169b;	 Catch:{ KeyStoreException -> 0x001f, NoSuchAlgorithmException -> 0x0041, CertificateException -> 0x004f, NotFoundException -> 0x0056, IOException -> 0x005d }
        r2 = 0;
        r0 = android.util.Base64.decode(r0, r2);	 Catch:{ KeyStoreException -> 0x001f, NoSuchAlgorithmException -> 0x0041, CertificateException -> 0x004f, NotFoundException -> 0x0056, IOException -> 0x005d }
    L_0x000d:
        r2 = new java.io.ByteArrayInputStream;	 Catch:{ KeyStoreException -> 0x0035, NoSuchAlgorithmException -> 0x0041, CertificateException -> 0x004f, NotFoundException -> 0x0056, IOException -> 0x005d }
        r2.<init>(r0);	 Catch:{ KeyStoreException -> 0x0035, NoSuchAlgorithmException -> 0x0041, CertificateException -> 0x004f, NotFoundException -> 0x0056, IOException -> 0x005d }
        r0 = "hunkyhunkyburninglove";
        r0 = r0.toCharArray();	 Catch:{ all -> 0x003c }
        r1.load(r2, r0);	 Catch:{ all -> 0x003c }
        r2.close();	 Catch:{ IOException -> 0x002e, KeyStoreException -> 0x0035, NoSuchAlgorithmException -> 0x0041, CertificateException -> 0x004f, NotFoundException -> 0x0056 }
    L_0x001e:
        return r1;
    L_0x001f:
        r0 = move-exception;
        r0 = "JKS";
        r1 = java.security.KeyStore.getInstance(r0);	 Catch:{ KeyStoreException -> 0x0035, NoSuchAlgorithmException -> 0x0041, CertificateException -> 0x004f, NotFoundException -> 0x0056, IOException -> 0x005d }
        r0 = com.paypal.android.sdk.aX.f170c;	 Catch:{ KeyStoreException -> 0x0035, NoSuchAlgorithmException -> 0x0041, CertificateException -> 0x004f, NotFoundException -> 0x0056, IOException -> 0x005d }
        r2 = 0;
        r0 = android.util.Base64.decode(r0, r2);	 Catch:{ KeyStoreException -> 0x0035, NoSuchAlgorithmException -> 0x0041, CertificateException -> 0x004f, NotFoundException -> 0x0056, IOException -> 0x005d }
        goto L_0x000d;
    L_0x002e:
        r0 = move-exception;
        r2 = "SystemKeyStore";
        android.util.Log.w(r2, r0);	 Catch:{ KeyStoreException -> 0x0035, NoSuchAlgorithmException -> 0x0041, CertificateException -> 0x004f, NotFoundException -> 0x0056, IOException -> 0x005d }
        goto L_0x001e;
    L_0x0035:
        r0 = move-exception;
        r1 = new java.lang.AssertionError;
        r1.<init>(r0);
        throw r1;
    L_0x003c:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x0048, KeyStoreException -> 0x0035, NoSuchAlgorithmException -> 0x0041, CertificateException -> 0x004f, NotFoundException -> 0x0056 }
    L_0x0040:
        throw r0;	 Catch:{ KeyStoreException -> 0x0035, NoSuchAlgorithmException -> 0x0041, CertificateException -> 0x004f, NotFoundException -> 0x0056, IOException -> 0x005d }
    L_0x0041:
        r0 = move-exception;
        r1 = new java.lang.AssertionError;
        r1.<init>(r0);
        throw r1;
    L_0x0048:
        r1 = move-exception;
        r2 = "SystemKeyStore";
        android.util.Log.w(r2, r1);	 Catch:{ KeyStoreException -> 0x0035, NoSuchAlgorithmException -> 0x0041, CertificateException -> 0x004f, NotFoundException -> 0x0056, IOException -> 0x005d }
        goto L_0x0040;
    L_0x004f:
        r0 = move-exception;
        r1 = new java.lang.AssertionError;
        r1.<init>(r0);
        throw r1;
    L_0x0056:
        r0 = move-exception;
        r1 = new java.lang.AssertionError;
        r1.<init>(r0);
        throw r1;
    L_0x005d:
        r0 = move-exception;
        r1 = new java.lang.AssertionError;
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.aW.b():java.security.KeyStore");
    }

    public final X509Certificate[] m116a() {
        int i = 1;
        LinkedList linkedList = new LinkedList();
        int i2 = this.f167b.m251a(this.f166a[0]) ? 1 : 0;
        linkedList.add(this.f166a[0]);
        int i3 = i2;
        i2 = 1;
        while (i2 < this.f166a.length) {
            if (this.f167b.m251a(this.f166a[i2])) {
                i3 = 1;
            }
            if (!m114a(this.f166a[i2], this.f166a[i2 - 1])) {
                break;
            }
            linkedList.add(this.f166a[i2]);
            i2++;
        }
        X509Certificate b = this.f167b.m252b(this.f166a[i2 - 1]);
        if (b != null) {
            linkedList.add(b);
        } else {
            i = i3;
        }
        if (i != 0) {
            return (X509Certificate[]) linkedList.toArray(new X509Certificate[linkedList.size()]);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
    }
}
