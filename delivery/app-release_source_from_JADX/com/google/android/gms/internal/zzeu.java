package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;

@zzha
public class zzeu implements zzel {
    private final Context mContext;
    private zzeq zzBD;
    private final zzen zzBf;
    private final AdRequestInfoParcel zzBu;
    private final long zzBv;
    private final long zzBw;
    private boolean zzBy = false;
    private final zzch zzoU;
    private final Object zzpK = new Object();
    private final zzew zzpd;
    private final boolean zzrF;

    public zzeu(Context context, AdRequestInfoParcel adRequestInfoParcel, zzew com_google_android_gms_internal_zzew, zzen com_google_android_gms_internal_zzen, boolean z, long j, long j2, zzch com_google_android_gms_internal_zzch) {
        this.mContext = context;
        this.zzBu = adRequestInfoParcel;
        this.zzpd = com_google_android_gms_internal_zzew;
        this.zzBf = com_google_android_gms_internal_zzen;
        this.zzrF = z;
        this.zzBv = j;
        this.zzBw = j2;
        this.zzoU = com_google_android_gms_internal_zzch;
    }

    public void cancel() {
        synchronized (this.zzpK) {
            this.zzBy = true;
            if (this.zzBD != null) {
                this.zzBD.cancel();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzer zzc(java.util.List<com.google.android.gms.internal.zzem> r21) {
        /*
        r20 = this;
        r2 = "Starting mediation.";
        com.google.android.gms.ads.internal.util.client.zzb.zzaF(r2);
        r14 = new java.util.ArrayList;
        r14.<init>();
        r0 = r20;
        r2 = r0.zzoU;
        r15 = r2.zzdu();
        r16 = r21.iterator();
    L_0x0016:
        r2 = r16.hasNext();
        if (r2 == 0) goto L_0x0123;
    L_0x001c:
        r7 = r16.next();
        r7 = (com.google.android.gms.internal.zzem) r7;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Trying mediation network: ";
        r2 = r2.append(r3);
        r3 = r7.zzAF;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.google.android.gms.ads.internal.util.client.zzb.zzaG(r2);
        r2 = r7.zzAG;
        r17 = r2.iterator();
    L_0x0040:
        r2 = r17.hasNext();
        if (r2 == 0) goto L_0x0016;
    L_0x0046:
        r4 = r17.next();
        r4 = (java.lang.String) r4;
        r0 = r20;
        r2 = r0.zzoU;
        r18 = r2.zzdu();
        r0 = r20;
        r0 = r0.zzpK;
        r19 = r0;
        monitor-enter(r19);
        r0 = r20;
        r2 = r0.zzBy;	 Catch:{ all -> 0x00fa }
        if (r2 == 0) goto L_0x0069;
    L_0x0061:
        r2 = new com.google.android.gms.internal.zzer;	 Catch:{ all -> 0x00fa }
        r3 = -1;
        r2.<init>(r3);	 Catch:{ all -> 0x00fa }
        monitor-exit(r19);	 Catch:{ all -> 0x00fa }
    L_0x0068:
        return r2;
    L_0x0069:
        r2 = new com.google.android.gms.internal.zzeq;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r3 = r0.mContext;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r5 = r0.zzpd;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r6 = r0.zzBf;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r8 = r0.zzBu;	 Catch:{ all -> 0x00fa }
        r8 = r8.zzGq;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r9 = r0.zzBu;	 Catch:{ all -> 0x00fa }
        r9 = r9.zzqV;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r10 = r0.zzBu;	 Catch:{ all -> 0x00fa }
        r10 = r10.zzqR;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r11 = r0.zzrF;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r12 = r0.zzBu;	 Catch:{ all -> 0x00fa }
        r12 = r12.zzrj;	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r13 = r0.zzBu;	 Catch:{ all -> 0x00fa }
        r13 = r13.zzrl;	 Catch:{ all -> 0x00fa }
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r0.zzBD = r2;	 Catch:{ all -> 0x00fa }
        monitor-exit(r19);	 Catch:{ all -> 0x00fa }
        r0 = r20;
        r2 = r0.zzBD;
        r0 = r20;
        r8 = r0.zzBv;
        r0 = r20;
        r10 = r0.zzBw;
        r2 = r2.zza(r8, r10);
        r3 = r2.zzBo;
        if (r3 != 0) goto L_0x00fd;
    L_0x00b5:
        r3 = "Adapter succeeded.";
        com.google.android.gms.ads.internal.util.client.zzb.zzaF(r3);
        r0 = r20;
        r3 = r0.zzoU;
        r5 = "mediation_network_succeed";
        r3.zzd(r5, r4);
        r3 = r14.isEmpty();
        if (r3 != 0) goto L_0x00d8;
    L_0x00c9:
        r0 = r20;
        r3 = r0.zzoU;
        r4 = "mediation_networks_fail";
        r5 = ",";
        r5 = android.text.TextUtils.join(r5, r14);
        r3.zzd(r4, r5);
    L_0x00d8:
        r0 = r20;
        r3 = r0.zzoU;
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "mls";
        r4[r5] = r6;
        r0 = r18;
        r3.zza(r0, r4);
        r0 = r20;
        r3 = r0.zzoU;
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "ttm";
        r4[r5] = r6;
        r3.zza(r15, r4);
        goto L_0x0068;
    L_0x00fa:
        r2 = move-exception;
        monitor-exit(r19);	 Catch:{ all -> 0x00fa }
        throw r2;
    L_0x00fd:
        r14.add(r4);
        r0 = r20;
        r3 = r0.zzoU;
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "mlf";
        r4[r5] = r6;
        r0 = r18;
        r3.zza(r0, r4);
        r3 = r2.zzBq;
        if (r3 == 0) goto L_0x0040;
    L_0x0115:
        r3 = com.google.android.gms.internal.zzip.zzKO;
        r4 = new com.google.android.gms.internal.zzeu$1;
        r0 = r20;
        r4.<init>(r0, r2);
        r3.post(r4);
        goto L_0x0040;
    L_0x0123:
        r2 = r14.isEmpty();
        if (r2 != 0) goto L_0x0138;
    L_0x0129:
        r0 = r20;
        r2 = r0.zzoU;
        r3 = "mediation_networks_fail";
        r4 = ",";
        r4 = android.text.TextUtils.join(r4, r14);
        r2.zzd(r3, r4);
    L_0x0138:
        r2 = new com.google.android.gms.internal.zzer;
        r3 = 1;
        r2.<init>(r3);
        goto L_0x0068;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeu.zzc(java.util.List):com.google.android.gms.internal.zzer");
    }
}
