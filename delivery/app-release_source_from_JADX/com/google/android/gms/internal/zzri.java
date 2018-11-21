package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zzrj.zza;

@Deprecated
public class zzri implements zza {
    private final zzrj zzaYj;
    private boolean zzaYk;

    public zzri(Context context, int i) {
        this(context, i, null);
    }

    public zzri(Context context, int i, String str) {
        this(context, i, str, null, true);
    }

    public zzri(Context context, int i, String str, String str2, boolean z) {
        this.zzaYj = new zzrj(context, i, str, str2, this, z, context != context.getApplicationContext() ? context.getClass().getName() : "OneTimePlayLogger");
        this.zzaYk = true;
    }

    private void zzCW() {
        if (!this.zzaYk) {
            throw new IllegalStateException("Cannot reuse one-time logger after sending.");
        }
    }

    public void send() {
        zzCW();
        this.zzaYj.start();
        this.zzaYk = false;
    }

    public void zzCX() {
        this.zzaYj.stop();
    }

    public void zzCY() {
        Log.w("OneTimePlayLogger", "logger connection failed");
    }

    public void zza(String str, byte[] bArr, String... strArr) {
        zzCW();
        this.zzaYj.zzb(str, bArr, strArr);
    }

    public void zze(PendingIntent pendingIntent) {
        Log.w("OneTimePlayLogger", "logger connection failed: " + pendingIntent);
    }
}
