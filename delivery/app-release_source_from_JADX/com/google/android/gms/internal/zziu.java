package com.google.android.gms.internal;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@zzha
public class zziu {
    private static zzl zzLk;
    public static final zza<Void> zzLl = new C07271();
    private static final Object zzqf = new Object();

    public interface zza<T> {
        T zzgc();

        T zzh(InputStream inputStream);
    }

    static class C07271 implements zza {
        C07271() {
        }

        public /* synthetic */ Object zzgc() {
            return zzhj();
        }

        public /* synthetic */ Object zzh(InputStream inputStream) {
            return zzi(inputStream);
        }

        public Void zzhj() {
            return null;
        }

        public Void zzi(InputStream inputStream) {
            return null;
        }
    }

    private static class zzb<T> extends zzk<InputStream> {
        private final zza<T> zzLp;
        private final com.google.android.gms.internal.zzm.zzb<T> zzaG;

        class C07291 implements com.google.android.gms.internal.zzm.zza {
            final /* synthetic */ com.google.android.gms.internal.zzm.zzb zzLq;
            final /* synthetic */ zza zzLr;

            C07291(com.google.android.gms.internal.zzm.zzb com_google_android_gms_internal_zzm_zzb, zza com_google_android_gms_internal_zziu_zza) {
                this.zzLq = com_google_android_gms_internal_zzm_zzb;
                this.zzLr = com_google_android_gms_internal_zziu_zza;
            }

            public void zze(zzr com_google_android_gms_internal_zzr) {
                this.zzLq.zzb(this.zzLr.zzgc());
            }
        }

        public zzb(String str, zza<T> com_google_android_gms_internal_zziu_zza_T, com.google.android.gms.internal.zzm.zzb<T> com_google_android_gms_internal_zzm_zzb_T) {
            super(0, str, new C07291(com_google_android_gms_internal_zzm_zzb_T, com_google_android_gms_internal_zziu_zza_T));
            this.zzLp = com_google_android_gms_internal_zziu_zza_T;
            this.zzaG = com_google_android_gms_internal_zzm_zzb_T;
        }

        protected zzm<InputStream> zza(zzi com_google_android_gms_internal_zzi) {
            return zzm.zza(new ByteArrayInputStream(com_google_android_gms_internal_zzi.data), zzx.zzb(com_google_android_gms_internal_zzi));
        }

        protected /* synthetic */ void zza(Object obj) {
            zzj((InputStream) obj);
        }

        protected void zzj(InputStream inputStream) {
            this.zzaG.zzb(this.zzLp.zzh(inputStream));
        }
    }

    private class zzc<T> extends zzjb<T> implements com.google.android.gms.internal.zzm.zzb<T> {
        final /* synthetic */ zziu zzLn;

        private zzc(zziu com_google_android_gms_internal_zziu) {
            this.zzLn = com_google_android_gms_internal_zziu;
        }

        public void zzb(T t) {
            super.zzf(t);
        }
    }

    public zziu(Context context) {
        zzLk = zzR(context);
    }

    private static zzl zzR(Context context) {
        zzl com_google_android_gms_internal_zzl;
        synchronized (zzqf) {
            if (zzLk == null) {
                zzLk = zzac.zza(context.getApplicationContext());
            }
            com_google_android_gms_internal_zzl = zzLk;
        }
        return com_google_android_gms_internal_zzl;
    }

    public <T> zzje<T> zza(String str, zza<T> com_google_android_gms_internal_zziu_zza_T) {
        Object com_google_android_gms_internal_zziu_zzc = new zzc();
        zzLk.zze(new zzb(str, com_google_android_gms_internal_zziu_zza_T, com_google_android_gms_internal_zziu_zzc));
        return com_google_android_gms_internal_zziu_zzc;
    }

    public zzje<String> zza(final String str, Map<String, String> map) {
        final Object com_google_android_gms_internal_zziu_zzc = new zzc();
        final Map<String, String> map2 = map;
        zzLk.zze(new zzab(this, str, com_google_android_gms_internal_zziu_zzc, new com.google.android.gms.internal.zzm.zza(this) {
            final /* synthetic */ zziu zzLn;

            public void zze(zzr com_google_android_gms_internal_zzr) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Failed to load URL: " + str + "\n" + com_google_android_gms_internal_zzr.toString());
                com_google_android_gms_internal_zziu_zzc.zzb(null);
            }
        }) {
            final /* synthetic */ zziu zzLn;

            public Map<String, String> getHeaders() throws zza {
                return map2 == null ? super.getHeaders() : map2;
            }
        });
        return com_google_android_gms_internal_zziu_zzc;
    }
}
