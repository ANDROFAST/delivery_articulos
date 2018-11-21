package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzaz.zza;
import com.google.android.gms.internal.zzaz.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@zzha
public class zzay implements zzba {
    private final VersionInfoParcel zzpI;
    private final Object zzpK = new Object();
    private final WeakHashMap<zzie, zzaz> zzrG = new WeakHashMap();
    private final ArrayList<zzaz> zzrH = new ArrayList();
    private final Context zzrI;
    private final zzei zzrJ;

    public zzay(Context context, VersionInfoParcel versionInfoParcel, zzei com_google_android_gms_internal_zzei) {
        this.zzrI = context.getApplicationContext();
        this.zzpI = versionInfoParcel;
        this.zzrJ = com_google_android_gms_internal_zzei;
    }

    public zzaz zza(AdSizeParcel adSizeParcel, zzie com_google_android_gms_internal_zzie) {
        return zza(adSizeParcel, com_google_android_gms_internal_zzie, com_google_android_gms_internal_zzie.zzDC.getView());
    }

    public zzaz zza(AdSizeParcel adSizeParcel, zzie com_google_android_gms_internal_zzie, View view) {
        return zza(adSizeParcel, com_google_android_gms_internal_zzie, new zzd(view, com_google_android_gms_internal_zzie));
    }

    public zzaz zza(AdSizeParcel adSizeParcel, zzie com_google_android_gms_internal_zzie, zzh com_google_android_gms_ads_internal_formats_zzh) {
        return zza(adSizeParcel, com_google_android_gms_internal_zzie, new zza(com_google_android_gms_ads_internal_formats_zzh));
    }

    public zzaz zza(AdSizeParcel adSizeParcel, zzie com_google_android_gms_internal_zzie, zzbh com_google_android_gms_internal_zzbh) {
        zzaz com_google_android_gms_internal_zzaz;
        synchronized (this.zzpK) {
            if (zzd(com_google_android_gms_internal_zzie)) {
                com_google_android_gms_internal_zzaz = (zzaz) this.zzrG.get(com_google_android_gms_internal_zzie);
            } else {
                com_google_android_gms_internal_zzaz = new zzaz(this.zzrI, adSizeParcel, com_google_android_gms_internal_zzie, this.zzpI, com_google_android_gms_internal_zzbh, this.zzrJ);
                com_google_android_gms_internal_zzaz.zza((zzba) this);
                this.zzrG.put(com_google_android_gms_internal_zzie, com_google_android_gms_internal_zzaz);
                this.zzrH.add(com_google_android_gms_internal_zzaz);
            }
        }
        return com_google_android_gms_internal_zzaz;
    }

    public void zza(zzaz com_google_android_gms_internal_zzaz) {
        synchronized (this.zzpK) {
            if (!com_google_android_gms_internal_zzaz.zzch()) {
                this.zzrH.remove(com_google_android_gms_internal_zzaz);
                Iterator it = this.zzrG.entrySet().iterator();
                while (it.hasNext()) {
                    if (((Entry) it.next()).getValue() == com_google_android_gms_internal_zzaz) {
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean zzd(zzie com_google_android_gms_internal_zzie) {
        boolean z;
        synchronized (this.zzpK) {
            zzaz com_google_android_gms_internal_zzaz = (zzaz) this.zzrG.get(com_google_android_gms_internal_zzie);
            z = com_google_android_gms_internal_zzaz != null && com_google_android_gms_internal_zzaz.zzch();
        }
        return z;
    }

    public void zze(zzie com_google_android_gms_internal_zzie) {
        synchronized (this.zzpK) {
            zzaz com_google_android_gms_internal_zzaz = (zzaz) this.zzrG.get(com_google_android_gms_internal_zzie);
            if (com_google_android_gms_internal_zzaz != null) {
                com_google_android_gms_internal_zzaz.zzcf();
            }
        }
    }

    public void zzf(zzie com_google_android_gms_internal_zzie) {
        synchronized (this.zzpK) {
            zzaz com_google_android_gms_internal_zzaz = (zzaz) this.zzrG.get(com_google_android_gms_internal_zzie);
            if (com_google_android_gms_internal_zzaz != null) {
                com_google_android_gms_internal_zzaz.stop();
            }
        }
    }

    public void zzg(zzie com_google_android_gms_internal_zzie) {
        synchronized (this.zzpK) {
            zzaz com_google_android_gms_internal_zzaz = (zzaz) this.zzrG.get(com_google_android_gms_internal_zzie);
            if (com_google_android_gms_internal_zzaz != null) {
                com_google_android_gms_internal_zzaz.pause();
            }
        }
    }

    public void zzh(zzie com_google_android_gms_internal_zzie) {
        synchronized (this.zzpK) {
            zzaz com_google_android_gms_internal_zzaz = (zzaz) this.zzrG.get(com_google_android_gms_internal_zzie);
            if (com_google_android_gms_internal_zzaz != null) {
                com_google_android_gms_internal_zzaz.resume();
            }
        }
    }
}
