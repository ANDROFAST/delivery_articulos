package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzl {
    private static final Object zzakg = new Object();
    private static zzl zzakh;

    public static zzl zzat(Context context) {
        synchronized (zzakg) {
            if (zzakh == null) {
                zzakh = new zzm(context.getApplicationContext());
            }
        }
        return zzakh;
    }

    public abstract boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract boolean zza(String str, ServiceConnection serviceConnection, String str2);

    public abstract void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract void zzb(String str, ServiceConnection serviceConnection, String str2);
}
