package com.google.android.gms.ads.internal;

import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzjn;

@zzha
public class zze {
    private zza zzpo;
    private boolean zzpp;
    private boolean zzpq;

    public interface zza {
        void zzq(String str);
    }

    @zzha
    public static class zzb implements zza {
        private final com.google.android.gms.internal.zzie.zza zzpr;
        private final zzjn zzps;

        public zzb(com.google.android.gms.internal.zzie.zza com_google_android_gms_internal_zzie_zza, zzjn com_google_android_gms_internal_zzjn) {
            this.zzpr = com_google_android_gms_internal_zzie_zza;
            this.zzps = com_google_android_gms_internal_zzjn;
        }

        public void zzq(String str) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("An auto-clicking creative is blocked");
            Builder builder = new Builder();
            builder.scheme("https");
            builder.path("//pagead2.googlesyndication.com/pagead/gen_204");
            builder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(str)) {
                builder.appendQueryParameter("navigationURL", str);
            }
            if (!(this.zzpr == null || this.zzpr.zzJL == null || TextUtils.isEmpty(this.zzpr.zzJL.zzGS))) {
                builder.appendQueryParameter("debugDialog", this.zzpr.zzJL.zzGS);
            }
            zzp.zzbx().zzc(this.zzps.getContext(), this.zzps.zzhF().afmaVersion, builder.toString());
        }
    }

    public zze() {
        this.zzpq = ((Boolean) zzbz.zzvn.get()).booleanValue();
    }

    public zze(boolean z) {
        this.zzpq = z;
    }

    public void recordClick() {
        this.zzpp = true;
    }

    public void zza(zza com_google_android_gms_ads_internal_zze_zza) {
        this.zzpo = com_google_android_gms_ads_internal_zze_zza;
    }

    public boolean zzbg() {
        return !this.zzpq || this.zzpp;
    }

    public void zzp(String str) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Action was blocked because no click was detected.");
        if (this.zzpo != null) {
            this.zzpo.zzq(str);
        }
    }
}
