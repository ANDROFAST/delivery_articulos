package com.google.android.gms.internal;

import android.content.MutableContextWrapper;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.LinkedList;

@zzha
class zzef {
    private final String zzpH;
    private AdRequestParcel zzqo;
    private final LinkedList<zza> zzzW = new LinkedList();

    class zza {
        boolean zzAa;
        boolean zzAb;
        final /* synthetic */ zzef zzAc;
        zzk zzzX;
        zzeb zzzY = new zzeb();
        long zzzZ;
        MutableContextWrapper zzzz;

        zza(zzef com_google_android_gms_internal_zzef, zzea com_google_android_gms_internal_zzea) {
            this.zzAc = com_google_android_gms_internal_zzef;
            zzea zzdV = com_google_android_gms_internal_zzea.zzdV();
            this.zzzz = com_google_android_gms_internal_zzea.zzdW();
            this.zzzX = zzdV.zzac(com_google_android_gms_internal_zzef.zzpH);
            this.zzzY.zzc(this.zzzX);
        }

        private void zzed() {
            if (!this.zzAa && this.zzAc.zzqo != null) {
                this.zzAb = this.zzzX.zzb(this.zzAc.zzqo);
                this.zzAa = true;
                this.zzzZ = zzp.zzbB().currentTimeMillis();
            }
        }

        void zzc(zzea com_google_android_gms_internal_zzea) {
            this.zzzz.setBaseContext(com_google_android_gms_internal_zzea.zzdW().getBaseContext());
        }

        void zzh(AdRequestParcel adRequestParcel) {
            if (adRequestParcel != null) {
                this.zzAc.zzqo = adRequestParcel;
            }
            zzed();
            Iterator it = this.zzAc.zzzW.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzed();
            }
        }
    }

    zzef(AdRequestParcel adRequestParcel, String str) {
        zzx.zzy(adRequestParcel);
        zzx.zzy(str);
        this.zzqo = adRequestParcel;
        this.zzpH = str;
    }

    String getAdUnitId() {
        return this.zzpH;
    }

    int size() {
        return this.zzzW.size();
    }

    void zzb(zzea com_google_android_gms_internal_zzea) {
        zza com_google_android_gms_internal_zzef_zza = new zza(this, com_google_android_gms_internal_zzea);
        this.zzzW.add(com_google_android_gms_internal_zzef_zza);
        com_google_android_gms_internal_zzef_zza.zzh(this.zzqo);
    }

    AdRequestParcel zzeb() {
        return this.zzqo;
    }

    zza zzec() {
        return (zza) this.zzzW.remove();
    }
}
