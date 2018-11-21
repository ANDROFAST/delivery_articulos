package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Future;

@zzha
public class zzbc {

    private static class zza<JavascriptEngine> extends zzjb<JavascriptEngine> {
        JavascriptEngine zzst;

        private zza() {
        }
    }

    private zzbb zza(Context context, VersionInfoParcel versionInfoParcel, final zza<zzbb> com_google_android_gms_internal_zzbc_zza_com_google_android_gms_internal_zzbb, zzan com_google_android_gms_internal_zzan) {
        final zzbb com_google_android_gms_internal_zzbd = new zzbd(context, versionInfoParcel, com_google_android_gms_internal_zzan);
        com_google_android_gms_internal_zzbc_zza_com_google_android_gms_internal_zzbb.zzst = com_google_android_gms_internal_zzbd;
        com_google_android_gms_internal_zzbd.zza(new com.google.android.gms.internal.zzbb.zza(this) {
            final /* synthetic */ zzbc zzsr;

            public void zzcr() {
                com_google_android_gms_internal_zzbc_zza_com_google_android_gms_internal_zzbb.zzf(com_google_android_gms_internal_zzbd);
            }
        });
        return com_google_android_gms_internal_zzbd;
    }

    public Future<zzbb> zza(Context context, VersionInfoParcel versionInfoParcel, String str, zzan com_google_android_gms_internal_zzan) {
        final Future com_google_android_gms_internal_zzbc_zza = new zza();
        final Context context2 = context;
        final VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        final zzan com_google_android_gms_internal_zzan2 = com_google_android_gms_internal_zzan;
        final String str2 = str;
        zzip.zzKO.post(new Runnable(this) {
            final /* synthetic */ zzbc zzsr;

            public void run() {
                this.zzsr.zza(context2, versionInfoParcel2, com_google_android_gms_internal_zzbc_zza, com_google_android_gms_internal_zzan2).zzt(str2);
            }
        });
        return com_google_android_gms_internal_zzbc_zza;
    }
}
