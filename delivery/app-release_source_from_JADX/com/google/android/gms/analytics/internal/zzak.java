package com.google.android.gms.analytics.internal;

public class zzak extends zzq<zzal> {

    private static class zza extends zzc implements com.google.android.gms.analytics.internal.zzq.zza<zzal> {
        private final zzal zzRT = new zzal();

        public zza(zzf com_google_android_gms_analytics_internal_zzf) {
            super(com_google_android_gms_analytics_internal_zzf);
        }

        public void zzc(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.zzRT.zzRV = i;
            } else {
                zzd("int configuration name not recognized", str);
            }
        }

        public void zzc(String str, boolean z) {
            int i = 1;
            zzal com_google_android_gms_analytics_internal_zzal;
            if ("ga_autoActivityTracking".equals(str)) {
                com_google_android_gms_analytics_internal_zzal = this.zzRT;
                if (!z) {
                    i = 0;
                }
                com_google_android_gms_analytics_internal_zzal.zzRW = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                com_google_android_gms_analytics_internal_zzal = this.zzRT;
                if (!z) {
                    i = 0;
                }
                com_google_android_gms_analytics_internal_zzal.zzRX = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                com_google_android_gms_analytics_internal_zzal = this.zzRT;
                if (!z) {
                    i = 0;
                }
                com_google_android_gms_analytics_internal_zzal.zzRY = i;
            } else {
                zzd("bool configuration name not recognized", str);
            }
        }

        public /* synthetic */ zzp zzjZ() {
            return zzlB();
        }

        public void zzk(String str, String str2) {
            this.zzRT.zzRZ.put(str, str2);
        }

        public void zzl(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.zzRT.zzNB = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.zzRT.zzRU = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    zzc("Error parsing ga_sampleFrequency value", str2, e);
                }
            } else {
                zzd("string configuration name not recognized", str);
            }
        }

        public zzal zzlB() {
            return this.zzRT;
        }
    }

    public zzak(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf, new zza(com_google_android_gms_analytics_internal_zzf));
    }
}
