package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.nearby.messages.Strategy;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@zzha
public final class zziw extends zzil {
    private final Context mContext;
    private final String zzF;
    private String zzKi = null;
    private final String zzrD;

    public zziw(Context context, String str, String str2) {
        this.mContext = context;
        this.zzrD = str;
        this.zzF = str2;
    }

    public zziw(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.zzrD = str;
        this.zzF = str2;
        this.zzKi = str3;
    }

    public void onStop() {
    }

    public void zzbp() {
        HttpURLConnection httpURLConnection;
        try {
            zzb.m7v("Pinging URL: " + this.zzF);
            httpURLConnection = (HttpURLConnection) new URL(this.zzF).openConnection();
            if (TextUtils.isEmpty(this.zzKi)) {
                zzp.zzbx().zza(this.mContext, this.zzrD, true, httpURLConnection);
            } else {
                zzp.zzbx().zza(this.mContext, this.zzrD, true, httpURLConnection, this.zzKi);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= Strategy.TTL_SECONDS_DEFAULT) {
                zzb.zzaH("Received non-success response code " + responseCode + " from pinging URL: " + this.zzF);
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            zzb.zzaH("Error while parsing ping URL: " + this.zzF + ". " + e.getMessage());
        } catch (IOException e2) {
            zzb.zzaH("Error while pinging URL: " + this.zzF + ". " + e2.getMessage());
        } catch (RuntimeException e3) {
            zzb.zzaH("Error while pinging URL: " + this.zzF + ". " + e3.getMessage());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
