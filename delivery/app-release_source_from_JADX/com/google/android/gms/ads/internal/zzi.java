package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzp.zza;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@zzha
public class zzi extends zza {
    private final Context mContext;
    private final zzcx zzpA;
    private final zzcy zzpB;
    private final SimpleArrayMap<String, zzda> zzpC;
    private final SimpleArrayMap<String, zzcz> zzpD;
    private final NativeAdOptionsParcel zzpE;
    private final List<String> zzpF;
    private final zzv zzpG;
    private final String zzpH;
    private final VersionInfoParcel zzpI;
    private WeakReference<zzn> zzpJ;
    private final Object zzpK = new Object();
    private final zzew zzpd;
    private final zzo zzpz;

    zzi(Context context, String str, zzew com_google_android_gms_internal_zzew, VersionInfoParcel versionInfoParcel, zzo com_google_android_gms_ads_internal_client_zzo, zzcx com_google_android_gms_internal_zzcx, zzcy com_google_android_gms_internal_zzcy, SimpleArrayMap<String, zzda> simpleArrayMap, SimpleArrayMap<String, zzcz> simpleArrayMap2, NativeAdOptionsParcel nativeAdOptionsParcel, zzv com_google_android_gms_ads_internal_client_zzv) {
        this.mContext = context;
        this.zzpH = str;
        this.zzpd = com_google_android_gms_internal_zzew;
        this.zzpI = versionInfoParcel;
        this.zzpz = com_google_android_gms_ads_internal_client_zzo;
        this.zzpB = com_google_android_gms_internal_zzcy;
        this.zzpA = com_google_android_gms_internal_zzcx;
        this.zzpC = simpleArrayMap;
        this.zzpD = simpleArrayMap2;
        this.zzpE = nativeAdOptionsParcel;
        this.zzpF = zzbk();
        this.zzpG = com_google_android_gms_ads_internal_client_zzv;
    }

    private List<String> zzbk() {
        List<String> arrayList = new ArrayList();
        if (this.zzpB != null) {
            arrayList.add("1");
        }
        if (this.zzpA != null) {
            arrayList.add("2");
        }
        if (this.zzpC.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getMediationAdapterClassName() {
        /*
        r3 = this;
        r1 = 0;
        r2 = r3.zzpK;
        monitor-enter(r2);
        r0 = r3.zzpJ;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001a;
    L_0x0008:
        r0 = r3.zzpJ;	 Catch:{ all -> 0x001d }
        r0 = r0.get();	 Catch:{ all -> 0x001d }
        r0 = (com.google.android.gms.ads.internal.zzn) r0;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0018;
    L_0x0012:
        r0 = r0.getMediationAdapterClassName();	 Catch:{ all -> 0x001d }
    L_0x0016:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r1;
        goto L_0x0016;
    L_0x001a:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        r0 = r1;
        goto L_0x0017;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzi.getMediationAdapterClassName():java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isLoading() {
        /*
        r3 = this;
        r1 = 0;
        r2 = r3.zzpK;
        monitor-enter(r2);
        r0 = r3.zzpJ;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001a;
    L_0x0008:
        r0 = r3.zzpJ;	 Catch:{ all -> 0x001d }
        r0 = r0.get();	 Catch:{ all -> 0x001d }
        r0 = (com.google.android.gms.ads.internal.zzn) r0;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0018;
    L_0x0012:
        r0 = r0.isLoading();	 Catch:{ all -> 0x001d }
    L_0x0016:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r1;
        goto L_0x0016;
    L_0x001a:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        r0 = r1;
        goto L_0x0017;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzi.isLoading():boolean");
    }

    protected void runOnUiThread(Runnable runnable) {
        zzip.zzKO.post(runnable);
    }

    protected zzn zzbl() {
        return new zzn(this.mContext, AdSizeParcel.zzt(this.mContext), this.zzpH, this.zzpd, this.zzpI);
    }

    public void zzf(final AdRequestParcel adRequestParcel) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzi zzpM;

            public void run() {
                synchronized (this.zzpM.zzpK) {
                    zzn zzbl = this.zzpM.zzbl();
                    this.zzpM.zzpJ = new WeakReference(zzbl);
                    zzbl.zzb(this.zzpM.zzpA);
                    zzbl.zzb(this.zzpM.zzpB);
                    zzbl.zza(this.zzpM.zzpC);
                    zzbl.zza(this.zzpM.zzpz);
                    zzbl.zzb(this.zzpM.zzpD);
                    zzbl.zza(this.zzpM.zzbk());
                    zzbl.zzb(this.zzpM.zzpE);
                    zzbl.zza(this.zzpM.zzpG);
                    zzbl.zzb(adRequestParcel);
                }
            }
        });
    }
}
