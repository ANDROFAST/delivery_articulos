package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

class zzrh implements PanoramaResult {
    private final Status zzTA;
    private final Intent zzaYi;

    public zzrh(Status status, Intent intent) {
        this.zzTA = (Status) zzx.zzy(status);
        this.zzaYi = intent;
    }

    public Status getStatus() {
        return this.zzTA;
    }

    public Intent getViewerIntent() {
        return this.zzaYi;
    }
}
