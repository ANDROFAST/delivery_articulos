package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzie.zza;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Future;

@zzha
public class zzhz extends zzil implements zzhy {
    private final Context mContext;
    private final zza zzFc;
    private final zzhs zzJA;
    private final String zzJg;
    private final ArrayList<Future> zzJx = new ArrayList();
    private final ArrayList<String> zzJy = new ArrayList();
    private final HashSet<String> zzJz = new HashSet();
    private final Object zzpK = new Object();

    public zzhz(Context context, String str, zza com_google_android_gms_internal_zzie_zza, zzhs com_google_android_gms_internal_zzhs) {
        this.mContext = context;
        this.zzJg = str;
        this.zzFc = com_google_android_gms_internal_zzie_zza;
        this.zzJA = com_google_android_gms_internal_zzhs;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzj(java.lang.String r10, java.lang.String r11) {
        /*
        r9 = this;
        r8 = r9.zzpK;
        monitor-enter(r8);
        r0 = r9.zzJA;	 Catch:{ all -> 0x0037 }
        r6 = r0.zzav(r10);	 Catch:{ all -> 0x0037 }
        if (r6 == 0) goto L_0x0017;
    L_0x000b:
        r0 = r6.zzgB();	 Catch:{ all -> 0x0037 }
        if (r0 == 0) goto L_0x0017;
    L_0x0011:
        r0 = r6.zzgA();	 Catch:{ all -> 0x0037 }
        if (r0 != 0) goto L_0x0019;
    L_0x0017:
        monitor-exit(r8);	 Catch:{ all -> 0x0037 }
    L_0x0018:
        return;
    L_0x0019:
        r0 = new com.google.android.gms.internal.zzhu;	 Catch:{ all -> 0x0037 }
        r1 = r9.mContext;	 Catch:{ all -> 0x0037 }
        r3 = r9.zzJg;	 Catch:{ all -> 0x0037 }
        r5 = r9.zzFc;	 Catch:{ all -> 0x0037 }
        r2 = r10;
        r4 = r11;
        r7 = r9;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0037 }
        r1 = r9.zzJx;	 Catch:{ all -> 0x0037 }
        r0 = r0.zzgX();	 Catch:{ all -> 0x0037 }
        r1.add(r0);	 Catch:{ all -> 0x0037 }
        r0 = r9.zzJy;	 Catch:{ all -> 0x0037 }
        r0.add(r10);	 Catch:{ all -> 0x0037 }
        monitor-exit(r8);	 Catch:{ all -> 0x0037 }
        goto L_0x0018;
    L_0x0037:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0037 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhz.zzj(java.lang.String, java.lang.String):void");
    }

    public void onStop() {
    }

    public void zza(String str, int i) {
    }

    public void zzaw(String str) {
        synchronized (this.zzpK) {
            this.zzJz.add(str);
        }
    }

    public void zzbp() {
        final zzie com_google_android_gms_internal_zzie;
        for (zzem com_google_android_gms_internal_zzem : this.zzFc.zzJF.zzAO) {
            String str = com_google_android_gms_internal_zzem.zzAL;
            for (String zzj : com_google_android_gms_internal_zzem.zzAG) {
                zzj(zzj, str);
            }
        }
        int i = 0;
        while (i < this.zzJx.size()) {
            try {
                ((Future) this.zzJx.get(i)).get();
                synchronized (this.zzpK) {
                    if (this.zzJz.contains(this.zzJy.get(i))) {
                        com_google_android_gms_internal_zzie = new zzie(this.zzFc.zzJK.zzGq, null, this.zzFc.zzJL.zzAQ, -2, this.zzFc.zzJL.zzAR, this.zzFc.zzJL.zzGP, this.zzFc.zzJL.orientation, this.zzFc.zzJL.zzAU, this.zzFc.zzJK.zzGt, this.zzFc.zzJL.zzGN, (zzem) this.zzFc.zzJF.zzAO.get(i), null, (String) this.zzJy.get(i), this.zzFc.zzJF, null, this.zzFc.zzJL.zzGO, this.zzFc.zzqV, this.zzFc.zzJL.zzGM, this.zzFc.zzJH, this.zzFc.zzJL.zzGR, this.zzFc.zzJL.zzGS, this.zzFc.zzJE, null);
                        com.google.android.gms.ads.internal.util.client.zza.zzLE.post(new Runnable(this) {
                            final /* synthetic */ zzhz zzJB;

                            public void run() {
                                this.zzJB.zzJA.zzb(com_google_android_gms_internal_zzie);
                            }
                        });
                        return;
                    }
                }
            } catch (InterruptedException e) {
            } catch (Exception e2) {
            }
        }
        com_google_android_gms_internal_zzie = new zzie(this.zzFc.zzJK.zzGq, null, this.zzFc.zzJL.zzAQ, 3, this.zzFc.zzJL.zzAR, this.zzFc.zzJL.zzGP, this.zzFc.zzJL.orientation, this.zzFc.zzJL.zzAU, this.zzFc.zzJK.zzGt, this.zzFc.zzJL.zzGN, null, null, null, this.zzFc.zzJF, null, this.zzFc.zzJL.zzGO, this.zzFc.zzqV, this.zzFc.zzJL.zzGM, this.zzFc.zzJH, this.zzFc.zzJL.zzGR, this.zzFc.zzJL.zzGS, this.zzFc.zzJE, null);
        com.google.android.gms.ads.internal.util.client.zza.zzLE.post(new Runnable(this) {
            final /* synthetic */ zzhz zzJB;

            public void run() {
                this.zzJB.zzJA.zzb(com_google_android_gms_internal_zzie);
            }
        });
        return;
        i++;
    }
}
