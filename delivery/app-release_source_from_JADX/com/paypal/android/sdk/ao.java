package com.paypal.android.sdk;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class ao extends SSLSocketFactory {
    private final javax.net.ssl.SSLSocketFactory f191a;

    public ao() {
        super(null);
        aq a = aq.m139a();
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init(null, new TrustManager[]{new ap(a)}, null);
        this.f191a = instance.getSocketFactory();
    }

    public final Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) {
        SSLSocket sSLSocket = (SSLSocket) (socket != null ? socket : createSocket());
        if (inetAddress != null || i2 > 0) {
            if (i2 < 0) {
                i2 = 0;
            }
            sSLSocket.bind(new InetSocketAddress(inetAddress, i2));
        }
        int connectionTimeout = HttpConnectionParams.getConnectionTimeout(httpParams);
        int soTimeout = HttpConnectionParams.getSoTimeout(httpParams);
        sSLSocket.connect(new InetSocketAddress(str, i), connectionTimeout);
        sSLSocket.setSoTimeout(soTimeout);
        try {
            SSLSocketFactory.STRICT_HOSTNAME_VERIFIER.verify(str, sSLSocket);
            return sSLSocket;
        } catch (IOException e) {
            try {
                sSLSocket.close();
            } catch (Exception e2) {
            }
            throw e;
        }
    }

    public final Socket createSocket() {
        return this.f191a.createSocket();
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        if (i == -1) {
            i = 443;
        }
        SSLSocket sSLSocket = (SSLSocket) this.f191a.createSocket(socket, str, i, z);
        SSLSocketFactory.STRICT_HOSTNAME_VERIFIER.verify(str, sSLSocket);
        return sSLSocket;
    }

    public final X509HostnameVerifier getHostnameVerifier() {
        return SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
    }

    public final void setHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        throw new IllegalArgumentException("Only strict hostname verification is supported!");
    }
}
