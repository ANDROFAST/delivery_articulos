package com.google.android.gms.internal;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;

public class zzse {
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private static String zzbce = "*gcore*:";
    private final Context mContext;
    private final String zzalZ;
    private final WakeLock zzbcf;
    private WorkSource zzbcg;
    private final int zzbch;
    private final String zzbci;
    private boolean zzbcj;
    private int zzbck;
    private int zzbcl;

    public zzse(Context context, int i, String str) {
        this(context, i, str, null, null);
    }

    public zzse(Context context, int i, String str, String str2, String str3) {
        this.zzbcj = true;
        zzx.zzh(str, "Wake lock name can NOT be empty");
        this.zzbch = i;
        this.zzbci = str2;
        this.mContext = context.getApplicationContext();
        if (zzob.zzcP(str3) || "com.google.android.gms" == str3) {
            this.zzalZ = str;
        } else {
            this.zzalZ = zzbce + str;
        }
        this.zzbcf = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zzoc.zzaz(this.mContext)) {
            if (zzob.zzcP(str3)) {
                if (zzd.zzaiU && zzmt.isInitialized()) {
                    Log.e(TAG, "callingPackage is not supposed to be empty for wakelock " + this.zzalZ + "!", new IllegalArgumentException());
                    str3 = "com.google.android.gms";
                } else {
                    str3 = context.getPackageName();
                }
            }
            this.zzbcg = zzoc.zzk(context, str3);
            zzc(this.zzbcg);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzeV(java.lang.String r9) {
        /*
        r8 = this;
        r0 = r8.zzeW(r9);
        r5 = r8.zzj(r9, r0);
        r1 = DEBUG;
        if (r1 == 0) goto L_0x0068;
    L_0x000c:
        r1 = TAG;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Release:\n mWakeLockName: ";
        r2 = r2.append(r3);
        r3 = r8.zzalZ;
        r2 = r2.append(r3);
        r3 = "\n mSecondaryName: ";
        r2 = r2.append(r3);
        r3 = r8.zzbci;
        r2 = r2.append(r3);
        r3 = "\nmReferenceCounted: ";
        r2 = r2.append(r3);
        r3 = r8.zzbcj;
        r2 = r2.append(r3);
        r3 = "\nreason: ";
        r2 = r2.append(r3);
        r2 = r2.append(r9);
        r3 = "\n mOpenEventCount";
        r2 = r2.append(r3);
        r3 = r8.zzbcl;
        r2 = r2.append(r3);
        r3 = "\nuseWithReason: ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r3 = "\ntrackingName: ";
        r2 = r2.append(r3);
        r2 = r2.append(r5);
        r2 = r2.toString();
        android.util.Log.d(r1, r2);
    L_0x0068:
        monitor-enter(r8);
        r1 = r8.zzbcj;	 Catch:{ all -> 0x00a3 }
        if (r1 == 0) goto L_0x0077;
    L_0x006d:
        r1 = r8.zzbck;	 Catch:{ all -> 0x00a3 }
        r1 = r1 + -1;
        r8.zzbck = r1;	 Catch:{ all -> 0x00a3 }
        if (r1 == 0) goto L_0x0080;
    L_0x0075:
        if (r0 != 0) goto L_0x0080;
    L_0x0077:
        r0 = r8.zzbcj;	 Catch:{ all -> 0x00a3 }
        if (r0 != 0) goto L_0x00a1;
    L_0x007b:
        r0 = r8.zzbcl;	 Catch:{ all -> 0x00a3 }
        r1 = 1;
        if (r0 != r1) goto L_0x00a1;
    L_0x0080:
        r0 = com.google.android.gms.common.stats.zzi.zzrJ();	 Catch:{ all -> 0x00a3 }
        r1 = r8.mContext;	 Catch:{ all -> 0x00a3 }
        r2 = r8.zzbcf;	 Catch:{ all -> 0x00a3 }
        r2 = com.google.android.gms.common.stats.zzg.zza(r2, r5);	 Catch:{ all -> 0x00a3 }
        r3 = 8;
        r4 = r8.zzalZ;	 Catch:{ all -> 0x00a3 }
        r6 = r8.zzbch;	 Catch:{ all -> 0x00a3 }
        r7 = r8.zzbcg;	 Catch:{ all -> 0x00a3 }
        r7 = com.google.android.gms.internal.zzoc.zzb(r7);	 Catch:{ all -> 0x00a3 }
        r0.zza(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x00a3 }
        r0 = r8.zzbcl;	 Catch:{ all -> 0x00a3 }
        r0 = r0 + -1;
        r8.zzbcl = r0;	 Catch:{ all -> 0x00a3 }
    L_0x00a1:
        monitor-exit(r8);	 Catch:{ all -> 0x00a3 }
        return;
    L_0x00a3:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x00a3 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzse.zzeV(java.lang.String):void");
    }

    private boolean zzeW(String str) {
        return (TextUtils.isEmpty(str) || str.equals(this.zzbci)) ? false : true;
    }

    private String zzj(String str, boolean z) {
        return this.zzbcj ? z ? str : this.zzbci : this.zzbci;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzj(java.lang.String r11, long r12) {
        /*
        r10 = this;
        r0 = r10.zzeW(r11);
        r5 = r10.zzj(r11, r0);
        r1 = DEBUG;
        if (r1 == 0) goto L_0x0072;
    L_0x000c:
        r1 = TAG;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Acquire:\n mWakeLockName: ";
        r2 = r2.append(r3);
        r3 = r10.zzalZ;
        r2 = r2.append(r3);
        r3 = "\n mSecondaryName: ";
        r2 = r2.append(r3);
        r3 = r10.zzbci;
        r2 = r2.append(r3);
        r3 = "\nmReferenceCounted: ";
        r2 = r2.append(r3);
        r3 = r10.zzbcj;
        r2 = r2.append(r3);
        r3 = "\nreason: ";
        r2 = r2.append(r3);
        r2 = r2.append(r11);
        r3 = "\nmOpenEventCount";
        r2 = r2.append(r3);
        r3 = r10.zzbcl;
        r2 = r2.append(r3);
        r3 = "\nuseWithReason: ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r3 = "\ntrackingName: ";
        r2 = r2.append(r3);
        r2 = r2.append(r5);
        r3 = "\ntimeout: ";
        r2 = r2.append(r3);
        r2 = r2.append(r12);
        r2 = r2.toString();
        android.util.Log.d(r1, r2);
    L_0x0072:
        monitor-enter(r10);
        r1 = r10.zzbcj;	 Catch:{ all -> 0x00ac }
        if (r1 == 0) goto L_0x0081;
    L_0x0077:
        r1 = r10.zzbck;	 Catch:{ all -> 0x00ac }
        r2 = r1 + 1;
        r10.zzbck = r2;	 Catch:{ all -> 0x00ac }
        if (r1 == 0) goto L_0x0089;
    L_0x007f:
        if (r0 != 0) goto L_0x0089;
    L_0x0081:
        r0 = r10.zzbcj;	 Catch:{ all -> 0x00ac }
        if (r0 != 0) goto L_0x00aa;
    L_0x0085:
        r0 = r10.zzbcl;	 Catch:{ all -> 0x00ac }
        if (r0 != 0) goto L_0x00aa;
    L_0x0089:
        r0 = com.google.android.gms.common.stats.zzi.zzrJ();	 Catch:{ all -> 0x00ac }
        r1 = r10.mContext;	 Catch:{ all -> 0x00ac }
        r2 = r10.zzbcf;	 Catch:{ all -> 0x00ac }
        r2 = com.google.android.gms.common.stats.zzg.zza(r2, r5);	 Catch:{ all -> 0x00ac }
        r3 = 7;
        r4 = r10.zzalZ;	 Catch:{ all -> 0x00ac }
        r6 = r10.zzbch;	 Catch:{ all -> 0x00ac }
        r7 = r10.zzbcg;	 Catch:{ all -> 0x00ac }
        r7 = com.google.android.gms.internal.zzoc.zzb(r7);	 Catch:{ all -> 0x00ac }
        r8 = r12;
        r0.zza(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x00ac }
        r0 = r10.zzbcl;	 Catch:{ all -> 0x00ac }
        r0 = r0 + 1;
        r10.zzbcl = r0;	 Catch:{ all -> 0x00ac }
    L_0x00aa:
        monitor-exit(r10);	 Catch:{ all -> 0x00ac }
        return;
    L_0x00ac:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x00ac }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzse.zzj(java.lang.String, long):void");
    }

    public void acquire(long timeout) {
        if (!zznx.zzrQ() && this.zzbcj) {
            Log.wtf(TAG, "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: " + this.zzalZ);
        }
        zzj(null, timeout);
        this.zzbcf.acquire(timeout);
    }

    public boolean isHeld() {
        return this.zzbcf.isHeld();
    }

    public void release() {
        zzeV(null);
        this.zzbcf.release();
    }

    public void setReferenceCounted(boolean value) {
        this.zzbcf.setReferenceCounted(value);
        this.zzbcj = value;
    }

    public void zzc(WorkSource workSource) {
        if (zzoc.zzaz(this.mContext) && workSource != null) {
            if (this.zzbcg != null) {
                this.zzbcg.add(workSource);
            } else {
                this.zzbcg = workSource;
            }
            this.zzbcf.setWorkSource(this.zzbcg);
        }
    }
}
