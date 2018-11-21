package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;
import java.util.Map;

public final class zzqm extends zze<zzqm> {
    public boolean zzaRR;
    public String zzavc;

    public String getDescription() {
        return this.zzavc;
    }

    public void setDescription(String description) {
        this.zzavc = description;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzavc);
        hashMap.put("fatal", Boolean.valueOf(this.zzaRR));
        return zze.zzE(hashMap);
    }

    public boolean zzAk() {
        return this.zzaRR;
    }

    public void zza(zzqm com_google_android_gms_internal_zzqm) {
        if (!TextUtils.isEmpty(this.zzavc)) {
            com_google_android_gms_internal_zzqm.setDescription(this.zzavc);
        }
        if (this.zzaRR) {
            com_google_android_gms_internal_zzqm.zzal(this.zzaRR);
        }
    }

    public void zzal(boolean z) {
        this.zzaRR = z;
    }
}
