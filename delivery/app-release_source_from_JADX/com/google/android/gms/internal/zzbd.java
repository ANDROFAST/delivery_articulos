package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

@zzha
public class zzbd implements zzbb {
    private final zzjn zzps;

    public zzbd(Context context, VersionInfoParcel versionInfoParcel, zzan com_google_android_gms_internal_zzan) {
        this.zzps = zzp.zzby().zza(context, new AdSizeParcel(), false, false, com_google_android_gms_internal_zzan, versionInfoParcel);
        this.zzps.getWebView().setWillNotDraw(true);
    }

    private void runOnUiThread(Runnable runnable) {
        if (zzl.zzcN().zzhr()) {
            runnable.run();
        } else {
            zzip.zzKO.post(runnable);
        }
    }

    public void destroy() {
        this.zzps.destroy();
    }

    public void zza(zza com_google_android_gms_ads_internal_client_zza, zzg com_google_android_gms_ads_internal_overlay_zzg, zzdh com_google_android_gms_internal_zzdh, zzn com_google_android_gms_ads_internal_overlay_zzn, boolean z, zzdn com_google_android_gms_internal_zzdn, zzdp com_google_android_gms_internal_zzdp, zze com_google_android_gms_ads_internal_zze, zzfs com_google_android_gms_internal_zzfs) {
        this.zzps.zzhC().zzb(com_google_android_gms_ads_internal_client_zza, com_google_android_gms_ads_internal_overlay_zzg, com_google_android_gms_internal_zzdh, com_google_android_gms_ads_internal_overlay_zzn, z, com_google_android_gms_internal_zzdn, com_google_android_gms_internal_zzdp, new zze(false), com_google_android_gms_internal_zzfs);
    }

    public void zza(final zzbb.zza com_google_android_gms_internal_zzbb_zza) {
        this.zzps.zzhC().zza(new zzjo.zza(this) {
            final /* synthetic */ zzbd zzsw;

            public void zza(zzjn com_google_android_gms_internal_zzjn, boolean z) {
                com_google_android_gms_internal_zzbb_zza.zzcr();
            }
        });
    }

    public void zza(String str, zzdl com_google_android_gms_internal_zzdl) {
        this.zzps.zzhC().zza(str, com_google_android_gms_internal_zzdl);
    }

    public void zza(final String str, final String str2) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzbd zzsw;

            public void run() {
                this.zzsw.zzps.zza(str, str2);
            }
        });
    }

    public void zza(final String str, final JSONObject jSONObject) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzbd zzsw;

            public void run() {
                this.zzsw.zzps.zza(str, jSONObject);
            }
        });
    }

    public void zzb(String str, zzdl com_google_android_gms_internal_zzdl) {
        this.zzps.zzhC().zzb(str, com_google_android_gms_internal_zzdl);
    }

    public void zzb(String str, JSONObject jSONObject) {
        this.zzps.zzb(str, jSONObject);
    }

    public zzbf zzcq() {
        return new zzbg(this);
    }

    public void zzs(String str) {
        final String format = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str});
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzbd zzsw;

            public void run() {
                this.zzsw.zzps.loadData(format, "text/html", "UTF-8");
            }
        });
    }

    public void zzt(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzbd zzsw;

            public void run() {
                this.zzsw.zzps.loadUrl(str);
            }
        });
    }

    public void zzu(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzbd zzsw;

            public void run() {
                this.zzsw.zzps.loadData(str, "text/html", "UTF-8");
            }
        });
    }
}
