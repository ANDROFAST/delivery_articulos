package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzha
public class zzbj {
    private final Object zzpK = new Object();
    private int zzsM;
    private List<zzbi> zzsN = new LinkedList();

    public boolean zza(zzbi com_google_android_gms_internal_zzbi) {
        boolean z;
        synchronized (this.zzpK) {
            if (this.zzsN.contains(com_google_android_gms_internal_zzbi)) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean zzb(zzbi com_google_android_gms_internal_zzbi) {
        boolean z;
        synchronized (this.zzpK) {
            Iterator it = this.zzsN.iterator();
            while (it.hasNext()) {
                zzbi com_google_android_gms_internal_zzbi2 = (zzbi) it.next();
                if (com_google_android_gms_internal_zzbi != com_google_android_gms_internal_zzbi2 && com_google_android_gms_internal_zzbi2.zzcu().equals(com_google_android_gms_internal_zzbi.zzcu())) {
                    it.remove();
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public void zzc(zzbi com_google_android_gms_internal_zzbi) {
        synchronized (this.zzpK) {
            if (this.zzsN.size() >= 10) {
                zzb.zzaF("Queue is full, current size = " + this.zzsN.size());
                this.zzsN.remove(0);
            }
            int i = this.zzsM;
            this.zzsM = i + 1;
            com_google_android_gms_internal_zzbi.zzh(i);
            this.zzsN.add(com_google_android_gms_internal_zzbi);
        }
    }

    public zzbi zzcA() {
        zzbi com_google_android_gms_internal_zzbi = null;
        synchronized (this.zzpK) {
            if (this.zzsN.size() == 0) {
                zzb.zzaF("Queue empty");
                return null;
            } else if (this.zzsN.size() >= 2) {
                int i = Integer.MIN_VALUE;
                for (zzbi com_google_android_gms_internal_zzbi2 : this.zzsN) {
                    zzbi com_google_android_gms_internal_zzbi3;
                    int i2;
                    int score = com_google_android_gms_internal_zzbi2.getScore();
                    if (score > i) {
                        int i3 = score;
                        com_google_android_gms_internal_zzbi3 = com_google_android_gms_internal_zzbi2;
                        i2 = i3;
                    } else {
                        i2 = i;
                        com_google_android_gms_internal_zzbi3 = com_google_android_gms_internal_zzbi;
                    }
                    i = i2;
                    com_google_android_gms_internal_zzbi = com_google_android_gms_internal_zzbi3;
                }
                this.zzsN.remove(com_google_android_gms_internal_zzbi);
                return com_google_android_gms_internal_zzbi;
            } else {
                com_google_android_gms_internal_zzbi2 = (zzbi) this.zzsN.get(0);
                com_google_android_gms_internal_zzbi2.zzcv();
                return com_google_android_gms_internal_zzbi2;
            }
        }
    }
}
