package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.LargeAssetApi.zzb;
import com.google.android.gms.wearable.LargeAssetApi.zzc;

public final class zzbt extends AbstractDataBuffer<zzb> implements zzc {
    private static final long[] zzboC = new long[0];
    private static final int[] zzboD = new int[0];
    private final Status zzTA;
    private final LongSparseArray<zza> zzboE;

    private static final class zza {
        public final int state;
        public final int zzboF;

        public zza(int i, int i2) {
            this.state = zzbt.zzmd(i);
            this.zzboF = i2;
        }

        public String toString() {
            return "EntryMetadata{state=" + this.state + ", refuseCode=" + this.zzboF + "}";
        }
    }

    public zzbt(DataHolder dataHolder) {
        super(dataHolder);
        this.zzTA = zzbz.zzfU(dataHolder.getStatusCode());
        this.zzboE = zzM(dataHolder.zzpH());
    }

    private String zzA(int i, int i2) {
        return this.zzafC.zzd("nodeId", i, i2);
    }

    private Uri zzB(int i, int i2) {
        return Uri.parse(this.zzafC.zzd("destinationUri", i, i2));
    }

    private boolean zzC(int i, int i2) {
        return this.zzafC.zze("append", i, i2);
    }

    private boolean zzD(int i, int i2) {
        return this.zzafC.zze("allowedOverMetered", i, i2);
    }

    private boolean zzE(int i, int i2) {
        return this.zzafC.zze("allowedWithLowBattery", i, i2);
    }

    private static long[] zzK(Bundle bundle) {
        long[] longArray = bundle.getLongArray("notPausedTransferIds");
        return longArray != null ? longArray : zzboC;
    }

    private static int[] zzL(Bundle bundle) {
        int[] intArray = bundle.getIntArray("refuseCodes");
        return intArray != null ? intArray : zzboD;
    }

    private static LongSparseArray<zza> zzM(Bundle bundle) {
        if (bundle == null) {
            return new LongSparseArray(0);
        }
        long[] zzK = zzK(bundle);
        int[] intArray = bundle.getIntArray("notPausedStates");
        return intArray == null ? zza(zzK, new zza(2, 0)) : zza(zzK, intArray, zzL(bundle));
    }

    private int zzY(long j) {
        zza com_google_android_gms_wearable_internal_zzbt_zza = (zza) this.zzboE.get(j);
        return com_google_android_gms_wearable_internal_zzbt_zza == null ? 1 : com_google_android_gms_wearable_internal_zzbt_zza.state;
    }

    private int zzZ(long j) {
        zza com_google_android_gms_wearable_internal_zzbt_zza = (zza) this.zzboE.get(j);
        return com_google_android_gms_wearable_internal_zzbt_zza == null ? 0 : com_google_android_gms_wearable_internal_zzbt_zza.zzboF;
    }

    private static <T> LongSparseArray<T> zza(long[] jArr, T t) {
        zzx.zzy(t);
        LongSparseArray<T> longSparseArray = new LongSparseArray(jArr.length);
        for (long put : jArr) {
            longSparseArray.put(put, t);
        }
        return longSparseArray;
    }

    private static LongSparseArray<zza> zza(long[] jArr, int[] iArr, int[] iArr2) {
        zzx.zzb(jArr.length == iArr.length, (Object) "transferIds and states differ in length.");
        zzx.zzy(iArr2);
        LongSparseArray<zza> longSparseArray = new LongSparseArray(jArr.length);
        int i = 0;
        for (int i2 = 0; i2 < jArr.length; i2++) {
            int i3;
            if (iArr[i2] == 4) {
                zzx.zzb(i < iArr2.length, (Object) "More entries in STATE_REFUSED than refuseCodes");
                i3 = iArr2[i];
                i++;
            } else {
                i3 = 0;
            }
            longSparseArray.put(jArr[i2], new zza(iArr[i2], i3));
        }
        return longSparseArray;
    }

    private static int zzmd(int i) {
        boolean z = i == 2 || i == 1 || i == 3 || i == 4 || i == 5;
        zzx.zzb(z, "Invalid queue entry state: %s", Integer.valueOf(i));
        return i;
    }

    private long zzy(int i, int i2) {
        return this.zzafC.zzb("transferId", i, i2);
    }

    private String zzz(int i, int i2) {
        return this.zzafC.zzd("path", i, i2);
    }

    public /* synthetic */ Object get(int x0) {
        return zzmc(x0);
    }

    public Status getStatus() {
        return this.zzTA;
    }

    public String toString() {
        return "QueueEntryBufferImpl{status=" + this.zzTA + ", entryMetadataByTransferId=" + this.zzboE + "}";
    }

    public zzb zzmc(int i) {
        int zzbI = this.zzafC.zzbI(i);
        long zzy = zzy(i, zzbI);
        return new LargeAssetQueueEntryParcelable(zzy, zzY(zzy), zzz(i, zzbI), zzA(i, zzbI), zzB(i, zzbI), zzZ(zzy), zzC(i, zzbI), zzD(i, zzbI), zzE(i, zzbI));
    }
}
