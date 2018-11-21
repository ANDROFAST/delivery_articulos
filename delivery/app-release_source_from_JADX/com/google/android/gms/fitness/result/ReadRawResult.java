package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public class ReadRawResult implements Result, SafeParcelable {
    public static final Creator<ReadRawResult> CREATOR = new zzi();
    private final int mVersionCode;
    private final DataHolder zzafC;
    private final List<DataHolder> zzazt;

    ReadRawResult(int versionCode, DataHolder dataHolder, List<DataHolder> dataHolders) {
        this.mVersionCode = versionCode;
        this.zzafC = dataHolder;
        if (dataHolders == null) {
            dataHolders = Collections.singletonList(dataHolder);
        }
        this.zzazt = dataHolders;
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return new Status(this.zzafC.getStatusCode());
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }

    DataHolder zzsA() {
        return this.zzafC;
    }

    List<DataHolder> zzuM() {
        return this.zzazt;
    }
}
