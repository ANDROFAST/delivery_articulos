package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpb.zza;
import java.util.Arrays;
import java.util.List;

public class DataSourcesRequest implements SafeParcelable {
    public static final Creator<DataSourcesRequest> CREATOR = new zzh();
    private final int mVersionCode;
    private final List<DataType> zzatZ;
    private final List<Integer> zzayB;
    private final boolean zzayC;
    private final zzpb zzayD;

    public static class Builder {
        private boolean zzayC = false;
        private DataType[] zzayE = new DataType[0];
        private int[] zzayF = new int[]{0, 1};

        public DataSourcesRequest build() {
            boolean z = true;
            zzx.zza(this.zzayE.length > 0, (Object) "Must add at least one data type");
            if (this.zzayF.length <= 0) {
                z = false;
            }
            zzx.zza(z, (Object) "Must add at least one data source type");
            return new DataSourcesRequest();
        }

        public Builder setDataSourceTypes(int... dataSourceTypes) {
            this.zzayF = dataSourceTypes;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypes) {
            this.zzayE = dataTypes;
            return this;
        }
    }

    DataSourcesRequest(int versionCode, List<DataType> dataTypes, List<Integer> dataSourceTypes, boolean includeDbOnlySources, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzatZ = dataTypes;
        this.zzayB = dataSourceTypes;
        this.zzayC = includeDbOnlySources;
        this.zzayD = zza.zzbD(callback);
    }

    private DataSourcesRequest(Builder builder) {
        this(zznh.zzb(builder.zzayE), Arrays.asList(zznh.zza(builder.zzayF)), builder.zzayC, null);
    }

    public DataSourcesRequest(DataSourcesRequest request, zzpb callback) {
        this(request.zzatZ, request.zzayB, request.zzayC, callback);
    }

    public DataSourcesRequest(List<DataType> dataTypes, List<Integer> dataSourceTypes, boolean includeDbOnlySources, zzpb callback) {
        this.mVersionCode = 4;
        this.zzatZ = dataTypes;
        this.zzayB = dataSourceTypes;
        this.zzayC = includeDbOnlySources;
        this.zzayD = callback;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return this.zzatZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        zzw.zza zzg = zzw.zzx(this).zzg("dataTypes", this.zzatZ).zzg("sourceTypes", this.zzayB);
        if (this.zzayC) {
            zzg.zzg("includeDbOnlySources", "true");
        }
        return zzg.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzh.zza(this, parcel, flags);
    }

    public IBinder zzui() {
        return this.zzayD == null ? null : this.zzayD.asBinder();
    }

    public List<Integer> zzur() {
        return this.zzayB;
    }

    public boolean zzus() {
        return this.zzayC;
    }
}
