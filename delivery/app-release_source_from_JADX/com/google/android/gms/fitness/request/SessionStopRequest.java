package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzpo.zza;

public class SessionStopRequest implements SafeParcelable {
    public static final Creator<SessionStopRequest> CREATOR = new zzy();
    private final String mName;
    private final int mVersionCode;
    private final String zzavb;
    private final zzpo zzazf;

    SessionStopRequest(int versionCode, String name, String identifier, IBinder callback) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzavb = identifier;
        this.zzazf = zza.zzbQ(callback);
    }

    public SessionStopRequest(String name, String identifier, zzpo callback) {
        this.mVersionCode = 3;
        this.mName = name;
        this.zzavb = identifier;
        this.zzazf = callback;
    }

    private boolean zzb(SessionStopRequest sessionStopRequest) {
        return zzw.equal(this.mName, sessionStopRequest.mName) && zzw.equal(this.zzavb, sessionStopRequest.zzavb);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionStopRequest) && zzb((SessionStopRequest) o));
    }

    public String getIdentifier() {
        return this.zzavb;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName, this.zzavb);
    }

    public String toString() {
        return zzw.zzx(this).zzg("name", this.mName).zzg("identifier", this.zzavb).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzy.zza(this, dest, flags);
    }

    public IBinder zzui() {
        return this.zzazf == null ? null : this.zzazf.asBinder();
    }
}
