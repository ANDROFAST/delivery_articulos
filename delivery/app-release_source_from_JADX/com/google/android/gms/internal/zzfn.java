package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzha
public class zzfn {
    private final boolean zzCp;
    private final String zzCq;
    private final zzjn zzps;

    public zzfn(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        this.zzps = com_google_android_gms_internal_zzjn;
        this.zzCq = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzCp = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        } else {
            this.zzCp = true;
        }
    }

    public void execute() {
        if (this.zzps == null) {
            zzb.zzaH("AdWebView is null");
            return;
        }
        int zzhe = "portrait".equalsIgnoreCase(this.zzCq) ? zzp.zzbz().zzhe() : "landscape".equalsIgnoreCase(this.zzCq) ? zzp.zzbz().zzhd() : this.zzCp ? -1 : zzp.zzbz().zzhf();
        this.zzps.setRequestedOrientation(zzhe);
    }
}
