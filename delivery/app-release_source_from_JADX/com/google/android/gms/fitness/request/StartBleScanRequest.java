package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zza.zza;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzpp;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest implements SafeParcelable {
    public static final Creator<StartBleScanRequest> CREATOR = new zzaa();
    private final int mVersionCode;
    private final List<DataType> zzatZ;
    private final zzpp zzayj;
    private final zzn zzazg;
    private final int zzazh;

    public static class Builder {
        private DataType[] zzayE = new DataType[0];
        private zzn zzazg;
        private int zzazh = 10;

        public StartBleScanRequest build() {
            zzx.zza(this.zzazg != null, (Object) "Must set BleScanCallback");
            return new StartBleScanRequest();
        }

        public Builder setBleScanCallback(BleScanCallback bleScanCallback) {
            zza(zza.zzug().zza(bleScanCallback));
            return this;
        }

        public Builder setDataTypes(DataType... dataTypes) {
            this.zzayE = dataTypes;
            return this;
        }

        public Builder setTimeoutSecs(int stopTimeSecs) {
            boolean z = true;
            zzx.zzb(stopTimeSecs > 0, (Object) "Stop time must be greater than zero");
            if (stopTimeSecs > 60) {
                z = false;
            }
            zzx.zzb(z, (Object) "Stop time must be less than 1 minute");
            this.zzazh = stopTimeSecs;
            return this;
        }

        public Builder zza(zzn com_google_android_gms_fitness_request_zzn) {
            this.zzazg = com_google_android_gms_fitness_request_zzn;
            return this;
        }
    }

    StartBleScanRequest(int versionCode, List<DataType> dataTypes, IBinder bleScanCallback, int timeoutSecs, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzatZ = dataTypes;
        this.zzazg = zzn.zza.zzbU(bleScanCallback);
        this.zzazh = timeoutSecs;
        this.zzayj = zzpp.zza.zzbR(callback);
    }

    private StartBleScanRequest(Builder builder) {
        this(zznh.zzb(builder.zzayE), builder.zzazg, builder.zzazh, null);
    }

    public StartBleScanRequest(StartBleScanRequest request, zzpp callback) {
        this(request.zzatZ, request.zzazg, request.zzazh, callback);
    }

    public StartBleScanRequest(List<DataType> dataTypes, zzn bleScanCallback, int timeoutSecs, zzpp callback) {
        this.mVersionCode = 4;
        this.zzatZ = dataTypes;
        this.zzazg = bleScanCallback;
        this.zzazh = timeoutSecs;
        this.zzayj = callback;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzatZ);
    }

    public int getTimeoutSecs() {
        return this.zzazh;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return zzw.zzx(this).zzg("dataTypes", this.zzatZ).zzg("timeoutSecs", Integer.valueOf(this.zzazh)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzaa.zza(this, parcel, flags);
    }

    public IBinder zzuE() {
        return this.zzazg.asBinder();
    }

    public IBinder zzui() {
        return this.zzayj == null ? null : this.zzayj.asBinder();
    }
}
