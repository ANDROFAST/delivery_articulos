package com.google.android.gms.analytics.internal;

public abstract class zzd extends zzc {
    private boolean zzOQ;
    private boolean zzOR;

    protected zzd(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
    }

    public boolean isInitialized() {
        return this.zzOQ && !this.zzOR;
    }

    public void zza() {
        zzir();
        this.zzOQ = true;
    }

    protected abstract void zzir();

    protected void zzje() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
