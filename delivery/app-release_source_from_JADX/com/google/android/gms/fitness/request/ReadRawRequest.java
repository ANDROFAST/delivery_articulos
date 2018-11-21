package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpl;
import com.google.android.gms.internal.zzpl.zza;
import java.util.List;

public class ReadRawRequest implements SafeParcelable {
    public static final Creator<ReadRawRequest> CREATOR = new zzq();
    private final int mVersionCode;
    private final zzpl zzayK;
    private final List<DataSourceQueryParams> zzayL;
    private final boolean zzayv;
    private final boolean zzayw;

    ReadRawRequest(int versionCode, IBinder callback, List<DataSourceQueryParams> queryParams, boolean flushBufferBeforeRead, boolean serverQueriesEnabled) {
        this.mVersionCode = versionCode;
        this.zzayK = zza.zzbN(callback);
        this.zzayL = queryParams;
        this.zzayv = flushBufferBeforeRead;
        this.zzayw = serverQueriesEnabled;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzq.zza(this, parcel, flags);
    }

    public IBinder zzui() {
        return this.zzayK != null ? this.zzayK.asBinder() : null;
    }

    public boolean zzun() {
        return this.zzayw;
    }

    public boolean zzuo() {
        return this.zzayv;
    }

    public List<DataSourceQueryParams> zzut() {
        return this.zzayL;
    }
}
