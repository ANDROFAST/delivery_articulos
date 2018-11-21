package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import java.io.IOException;

public abstract class zzd {
    protected final zzl zzabN;
    private final String zzabO;
    private zzn zzabP;

    protected zzd(String str, String str2, String str3) {
        zzf.zzcb(str);
        this.zzabO = str;
        this.zzabN = new zzl(str2);
        setSessionLabel(str3);
    }

    public final String getNamespace() {
        return this.zzabO;
    }

    public void setSessionLabel(String sessionLabel) {
        if (!TextUtils.isEmpty(sessionLabel)) {
            this.zzabN.zzch(sessionLabel);
        }
    }

    public final void zza(zzn com_google_android_gms_cast_internal_zzn) {
        this.zzabP = com_google_android_gms_cast_internal_zzn;
        if (this.zzabP == null) {
            zznN();
        }
    }

    protected final void zza(String str, long j, String str2) throws IOException {
        this.zzabN.zza("Sending text message: %s to: %s", str, str2);
        this.zzabP.zza(this.zzabO, str, j, str2);
    }

    public void zzb(long j, int i) {
    }

    public void zzbZ(String str) {
    }

    public void zznN() {
    }

    protected final long zznO() {
        return this.zzabP.zzny();
    }
}
