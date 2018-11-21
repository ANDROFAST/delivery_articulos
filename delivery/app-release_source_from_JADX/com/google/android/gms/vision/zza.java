package com.google.android.gms.vision;

import android.util.SparseArray;

public class zza {
    private static int zzbif = 0;
    private static final Object zzqf = new Object();
    private SparseArray<Integer> zzbig = new SparseArray();
    private SparseArray<Integer> zzbih = new SparseArray();

    public int zzka(int i) {
        int intValue;
        synchronized (zzqf) {
            Integer num = (Integer) this.zzbig.get(i);
            if (num != null) {
                intValue = num.intValue();
            } else {
                intValue = zzbif;
                zzbif++;
                this.zzbig.append(i, Integer.valueOf(intValue));
                this.zzbih.append(intValue, Integer.valueOf(i));
            }
        }
        return intValue;
    }

    public int zzkb(int i) {
        int intValue;
        synchronized (zzqf) {
            intValue = ((Integer) this.zzbih.get(i)).intValue();
        }
        return intValue;
    }
}
