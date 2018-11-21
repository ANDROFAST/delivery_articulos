package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

public final class zznq {
    private static IntentFilter zzaml = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long zzamm;
    private static float zzamn = Float.NaN;

    public static int zzaw(Context context) {
        int i = 1;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzaml);
        int i2 = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        int i3 = (zznx.zzrV() ? ((PowerManager) context.getSystemService("power")).isInteractive() : ((PowerManager) context.getSystemService("power")).isScreenOn() ? 1 : 0) << 1;
        if (i2 == 0) {
            i = 0;
        }
        return i3 | i;
    }

    public static synchronized float zzax(Context context) {
        float f;
        synchronized (zznq.class) {
            if (SystemClock.elapsedRealtime() - zzamm >= 60000 || zzamn == Float.NaN) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzaml);
                if (registerReceiver != null) {
                    zzamn = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                zzamm = SystemClock.elapsedRealtime();
                f = zzamn;
            } else {
                f = zzamn;
            }
        }
        return f;
    }
}
