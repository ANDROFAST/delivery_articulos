package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class zzp extends zzw {

    interface zza {
        void zza(int i, Throwable th, byte[] bArr);
    }

    private static class zzb implements Runnable {
        private final int zzAk;
        private final zza zzaTv;
        private final Throwable zzaTw;
        private final byte[] zzaTx;

        private zzb(zza com_google_android_gms_measurement_internal_zzp_zza, int i, Throwable th, byte[] bArr) {
            this.zzaTv = com_google_android_gms_measurement_internal_zzp_zza;
            this.zzAk = i;
            this.zzaTw = th;
            this.zzaTx = bArr;
        }

        public void run() {
            this.zzaTv.zza(this.zzAk, this.zzaTw, this.zzaTx);
        }
    }

    private class zzc implements Runnable {
        final /* synthetic */ zzp zzaTA;
        private final byte[] zzaTy;
        private final zza zzaTz;
        private final URL zzyR;

        public zzc(zzp com_google_android_gms_measurement_internal_zzp, URL url, byte[] bArr, zza com_google_android_gms_measurement_internal_zzp_zza) {
            this.zzaTA = com_google_android_gms_measurement_internal_zzp;
            this.zzyR = url;
            this.zzaTy = bArr;
            this.zzaTz = com_google_android_gms_measurement_internal_zzp_zza;
        }

        public void run() {
            HttpURLConnection zzc;
            OutputStream outputStream;
            Throwable e;
            int i;
            Throwable th;
            this.zzaTA.zzAR();
            int i2 = 0;
            try {
                byte[] zzg = this.zzaTA.zzAU().zzg(this.zzaTy);
                zzc = this.zzaTA.zzc(this.zzyR);
                try {
                    zzc.setDoOutput(true);
                    zzc.addRequestProperty("Content-Encoding", "gzip");
                    zzc.setFixedLengthStreamingMode(zzg.length);
                    zzc.connect();
                    outputStream = zzc.getOutputStream();
                } catch (IOException e2) {
                    e = e2;
                    i = i2;
                    outputStream = null;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e3) {
                            this.zzaTA.zzzz().zzBl().zzj("Error closing HTTP compressed POST connection output stream", e3);
                        }
                    }
                    if (zzc != null) {
                        zzc.disconnect();
                    }
                    this.zzaTA.zzAV().zzg(new zzb(this.zzaTz, i, e, null));
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = null;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e32) {
                            this.zzaTA.zzzz().zzBl().zzj("Error closing HTTP compressed POST connection output stream", e32);
                        }
                    }
                    if (zzc != null) {
                        zzc.disconnect();
                    }
                    this.zzaTA.zzAV().zzg(new zzb(this.zzaTz, i2, null, null));
                    throw th;
                }
                try {
                    outputStream.write(zzg);
                    outputStream.close();
                    outputStream = null;
                    i2 = zzc.getResponseCode();
                    zzg = this.zzaTA.zzc(zzc);
                    if (null != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e322) {
                            this.zzaTA.zzzz().zzBl().zzj("Error closing HTTP compressed POST connection output stream", e322);
                        }
                    }
                    if (zzc != null) {
                        zzc.disconnect();
                    }
                    this.zzaTA.zzAV().zzg(new zzb(this.zzaTz, i2, null, zzg));
                } catch (IOException e4) {
                    e = e4;
                    i = 0;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (zzc != null) {
                        zzc.disconnect();
                    }
                    this.zzaTA.zzAV().zzg(new zzb(this.zzaTz, i, e, null));
                } catch (Throwable th3) {
                    th = th3;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (zzc != null) {
                        zzc.disconnect();
                    }
                    this.zzaTA.zzAV().zzg(new zzb(this.zzaTz, i2, null, null));
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                i = 0;
                outputStream = null;
                zzc = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (zzc != null) {
                    zzc.disconnect();
                }
                this.zzaTA.zzAV().zzg(new zzb(this.zzaTz, i, e, null));
            } catch (Throwable th22) {
                th = th22;
                zzc = null;
                outputStream = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (zzc != null) {
                    zzc.disconnect();
                }
                this.zzaTA.zzAV().zzg(new zzb(this.zzaTz, i2, null, null));
                throw th;
            }
        }
    }

    public zzp(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    private byte[] zzc(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            return toByteArray;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ void zzAR() {
        super.zzAR();
    }

    public /* bridge */ /* synthetic */ zzm zzAS() {
        return super.zzAS();
    }

    public /* bridge */ /* synthetic */ zzz zzAT() {
        return super.zzAT();
    }

    public /* bridge */ /* synthetic */ zzae zzAU() {
        return super.zzAU();
    }

    public /* bridge */ /* synthetic */ zzs zzAV() {
        return super.zzAV();
    }

    public /* bridge */ /* synthetic */ zzr zzAW() {
        return super.zzAW();
    }

    public /* bridge */ /* synthetic */ zzc zzAX() {
        return super.zzAX();
    }

    public void zza(URL url, byte[] bArr, zza com_google_android_gms_measurement_internal_zzp_zza) {
        zziS();
        zzje();
        zzx.zzy(url);
        zzx.zzy(bArr);
        zzx.zzy(com_google_android_gms_measurement_internal_zzp_zza);
        zzAV().zzh(new zzc(this, url, bArr, com_google_android_gms_measurement_internal_zzp_zza));
    }

    protected HttpURLConnection zzc(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout((int) zzAX().zzAB());
            httpURLConnection.setReadTimeout((int) zzAX().zzAC());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }

    public /* bridge */ /* synthetic */ void zziR() {
        super.zziR();
    }

    public /* bridge */ /* synthetic */ void zziS() {
        super.zziS();
    }

    public /* bridge */ /* synthetic */ zznl zziT() {
        return super.zziT();
    }

    protected void zzir() {
    }

    public boolean zzlk() {
        NetworkInfo activeNetworkInfo;
        zzje();
        try {
            activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public /* bridge */ /* synthetic */ zzo zzzz() {
        return super.zzzz();
    }
}
