package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

public class zze {
    private final long zzalW;
    private final int zzalX;
    private final SimpleArrayMap<String, Long> zzalY;

    public zze() {
        this.zzalW = 60000;
        this.zzalX = 10;
        this.zzalY = new SimpleArrayMap(10);
    }

    public zze(int i, long j) {
        this.zzalW = j;
        this.zzalX = i;
        this.zzalY = new SimpleArrayMap();
    }

    private void zzb(long j, long j2) {
        for (int size = this.zzalY.size() - 1; size >= 0; size--) {
            if (j2 - ((Long) this.zzalY.valueAt(size)).longValue() > j) {
                this.zzalY.removeAt(size);
            }
        }
    }

    public Long zzcM(String str) {
        Long l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.zzalW;
        synchronized (this) {
            while (this.zzalY.size() >= this.zzalX) {
                zzb(j, elapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", "The max capacity " + this.zzalX + " is not enough. Current durationThreshold is: " + j);
            }
            l = (Long) this.zzalY.put(str, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public boolean zzcN(String str) {
        boolean z;
        synchronized (this) {
            z = this.zzalY.remove(str) != null;
        }
        return z;
    }
}
