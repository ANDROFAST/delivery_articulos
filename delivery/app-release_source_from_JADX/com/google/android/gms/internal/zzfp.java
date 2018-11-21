package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import org.json.JSONObject;

@zzha
public class zzfp {
    private final boolean zzCu;
    private final boolean zzCv;
    private final boolean zzCw;
    private final boolean zzCx;
    private final boolean zzCy;

    public static final class zza {
        private boolean zzCu;
        private boolean zzCv;
        private boolean zzCw;
        private boolean zzCx;
        private boolean zzCy;

        public zzfp zzeE() {
            return new zzfp();
        }

        public zza zzq(boolean z) {
            this.zzCu = z;
            return this;
        }

        public zza zzr(boolean z) {
            this.zzCv = z;
            return this;
        }

        public zza zzs(boolean z) {
            this.zzCw = z;
            return this;
        }

        public zza zzt(boolean z) {
            this.zzCx = z;
            return this;
        }

        public zza zzu(boolean z) {
            this.zzCy = z;
            return this;
        }
    }

    private zzfp(zza com_google_android_gms_internal_zzfp_zza) {
        this.zzCu = com_google_android_gms_internal_zzfp_zza.zzCu;
        this.zzCv = com_google_android_gms_internal_zzfp_zza.zzCv;
        this.zzCw = com_google_android_gms_internal_zzfp_zza.zzCw;
        this.zzCx = com_google_android_gms_internal_zzfp_zza.zzCx;
        this.zzCy = com_google_android_gms_internal_zzfp_zza.zzCy;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zzCu).put("tel", this.zzCv).put("calendar", this.zzCw).put("storePicture", this.zzCx).put("inlineVideo", this.zzCy);
        } catch (Throwable e) {
            zzb.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
