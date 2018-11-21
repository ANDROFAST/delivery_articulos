package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;

public class DataSource implements SafeParcelable {
    public static final Creator<DataSource> CREATOR = new zzf();
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW = 0;
    private final String mName;
    private final int mVersionCode;
    private final int zzZU;
    private final DataType zzatO;
    private final Device zzaum;
    private final Application zzaun;
    private final String zzauo;
    private final String zzaup;

    public static final class Builder {
        private String mName;
        private int zzZU = -1;
        private DataType zzatO;
        private Device zzaum;
        private Application zzaun;
        private String zzauo = "";

        public DataSource build() {
            boolean z = true;
            zzx.zza(this.zzatO != null, (Object) "Must set data type");
            if (this.zzZU < 0) {
                z = false;
            }
            zzx.zza(z, (Object) "Must set data source type");
            return new DataSource();
        }

        public Builder setAppPackageName(Context appContext) {
            return setAppPackageName(appContext.getPackageName());
        }

        public Builder setAppPackageName(String packageName) {
            this.zzaun = Application.zzde(packageName);
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.zzatO = dataType;
            return this;
        }

        public Builder setDevice(Device device) {
            this.zzaum = device;
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }

        public Builder setStreamName(String streamName) {
            zzx.zzb(streamName != null, (Object) "Must specify a valid stream name");
            this.zzauo = streamName;
            return this;
        }

        public Builder setType(int type) {
            this.zzZU = type;
            return this;
        }
    }

    DataSource(int versionCode, DataType dataType, String name, int type, Device device, Application application, String streamName) {
        this.mVersionCode = versionCode;
        this.zzatO = dataType;
        this.zzZU = type;
        this.mName = name;
        this.zzaum = device;
        this.zzaun = application;
        this.zzauo = streamName;
        this.zzaup = zztL();
    }

    private DataSource(Builder builder) {
        this.mVersionCode = 3;
        this.zzatO = builder.zzatO;
        this.zzZU = builder.zzZU;
        this.mName = builder.mName;
        this.zzaum = builder.zzaum;
        this.zzaun = builder.zzaun;
        this.zzauo = builder.zzauo;
        this.zzaup = zztL();
    }

    public static DataSource extract(Intent intent) {
        return intent == null ? null : (DataSource) zzc.zza(intent, EXTRA_DATA_SOURCE, CREATOR);
    }

    private String getTypeString() {
        switch (this.zzZU) {
            case 0:
                return "raw";
            case 1:
                return "derived";
            default:
                throw new IllegalArgumentException("invalid type value");
        }
    }

    private boolean zza(DataSource dataSource) {
        return this.zzaup.equals(dataSource.zzaup);
    }

    private String zztL() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getTypeString());
        stringBuilder.append(":").append(this.zzatO.getName());
        if (this.zzaun != null) {
            stringBuilder.append(":").append(this.zzaun.getPackageName());
        }
        if (this.zzaum != null) {
            stringBuilder.append(":").append(this.zzaum.getStreamIdentifier());
        }
        if (this.zzauo != null) {
            stringBuilder.append(":").append(this.zzauo);
        }
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataSource) && zza((DataSource) that));
    }

    public String getAppPackageName() {
        return this.zzaun == null ? null : this.zzaun.getPackageName();
    }

    public DataType getDataType() {
        return this.zzatO;
    }

    public Device getDevice() {
        return this.zzaum;
    }

    public String getName() {
        return this.mName;
    }

    public String getStreamIdentifier() {
        return this.zzaup;
    }

    public String getStreamName() {
        return this.zzauo;
    }

    public int getType() {
        return this.zzZU;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return this.zzaup.hashCode();
    }

    public String toDebugString() {
        StringBuilder append = new StringBuilder().append(this.zzZU == 0 ? "r" : "d").append(":").append(this.zzatO.zztM());
        String str = this.zzaun == null ? "" : this.zzaun.equals(Application.zzatV) ? ":gms" : ":" + this.zzaun.getPackageName();
        return append.append(str).append(this.zzaum != null ? ":" + this.zzaum.getModel() + ":" + this.zzaum.getUid() : "").append(this.zzauo != null ? ":" + this.zzauo : "").toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DataSource{");
        stringBuilder.append(getTypeString());
        if (this.mName != null) {
            stringBuilder.append(":").append(this.mName);
        }
        if (this.zzaun != null) {
            stringBuilder.append(":").append(this.zzaun);
        }
        if (this.zzaum != null) {
            stringBuilder.append(":").append(this.zzaum);
        }
        if (this.zzauo != null) {
            stringBuilder.append(":").append(this.zzauo);
        }
        stringBuilder.append(":").append(this.zzatO);
        return stringBuilder.append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzf.zza(this, parcel, flags);
    }

    public Application zztK() {
        return this.zzaun;
    }
}
