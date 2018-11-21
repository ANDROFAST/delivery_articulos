package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.concurrent.Future;

@zzha
public final class zzin {

    public interface zzb {
        void zze(Bundle bundle);
    }

    private static abstract class zza extends zzil {
        private zza() {
        }

        public void onStop() {
        }
    }

    public static Future zza(final Context context, final int i) {
        return new zza() {
            public void zzbp() {
                Editor edit = zzin.zzw(context).edit();
                edit.putInt("webview_cache_version", i);
                edit.apply();
            }
        }.zzgX();
    }

    public static Future zza(final Context context, final zzb com_google_android_gms_internal_zzin_zzb) {
        return new zza() {
            public void zzbp() {
                SharedPreferences zzI = zzin.zzw(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("use_https", zzI.getBoolean("use_https", true));
                if (com_google_android_gms_internal_zzin_zzb != null) {
                    com_google_android_gms_internal_zzin_zzb.zze(bundle);
                }
            }
        }.zzgX();
    }

    public static Future zza(final Context context, final boolean z) {
        return new zza() {
            public void zzbp() {
                Editor edit = zzin.zzw(context).edit();
                edit.putBoolean("use_https", z);
                edit.apply();
            }
        }.zzgX();
    }

    public static Future zzb(final Context context, final zzb com_google_android_gms_internal_zzin_zzb) {
        return new zza() {
            public void zzbp() {
                SharedPreferences zzI = zzin.zzw(context);
                Bundle bundle = new Bundle();
                bundle.putInt("webview_cache_version", zzI.getInt("webview_cache_version", 0));
                if (com_google_android_gms_internal_zzin_zzb != null) {
                    com_google_android_gms_internal_zzin_zzb.zze(bundle);
                }
            }
        }.zzgX();
    }

    public static Future zzb(final Context context, final boolean z) {
        return new zza() {
            public void zzbp() {
                Editor edit = zzin.zzw(context).edit();
                edit.putBoolean("content_url_opted_out", z);
                edit.apply();
            }
        }.zzgX();
    }

    public static Future zzc(final Context context, final zzb com_google_android_gms_internal_zzin_zzb) {
        return new zza() {
            public void zzbp() {
                SharedPreferences zzI = zzin.zzw(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", zzI.getBoolean("content_url_opted_out", true));
                if (com_google_android_gms_internal_zzin_zzb != null) {
                    com_google_android_gms_internal_zzin_zzb.zze(bundle);
                }
            }
        }.zzgX();
    }

    private static SharedPreferences zzw(Context context) {
        return context.getSharedPreferences("admob", 0);
    }
}
