package com.google.android.gms.analytics.internal;

public class zzz extends zzq<zzaa> {

    private static class zza implements com.google.android.gms.analytics.internal.zzq.zza<zzaa> {
        private final zzf zzOP;
        private final zzaa zzRj = new zzaa();

        public zza(zzf com_google_android_gms_analytics_internal_zzf) {
            this.zzOP = com_google_android_gms_analytics_internal_zzf;
        }

        public void zzc(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.zzRj.zzRn = i;
            } else {
                this.zzOP.zziU().zzd("Int xml configuration name not recognized", str);
            }
        }

        public void zzc(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.zzRj.zzRo = z ? 1 : 0;
                return;
            }
            this.zzOP.zziU().zzd("Bool xml configuration name not recognized", str);
        }

        public /* synthetic */ zzp zzjZ() {
            return zzkN();
        }

        public void zzk(String str, String str2) {
        }

        public zzaa zzkN() {
            return this.zzRj;
        }

        public void zzl(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.zzRj.zzRk = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.zzRj.zzRl = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.zzRj.zzRm = str2;
            } else {
                this.zzOP.zziU().zzd("String xml configuration name not recognized", str);
            }
        }
    }

    public zzz(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf, new zza(com_google_android_gms_analytics_internal_zzf));
    }
}
