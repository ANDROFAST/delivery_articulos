package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class SessionDataSet implements SafeParcelable {
    public static final Creator<SessionDataSet> CREATOR = new zzq();
    final int mVersionCode;
    private final Session zzatS;
    private final DataSet zzave;

    SessionDataSet(int versionCode, Session session, DataSet dataSet) {
        this.mVersionCode = versionCode;
        this.zzatS = session;
        this.zzave = dataSet;
    }

    private boolean zza(SessionDataSet sessionDataSet) {
        return zzw.equal(this.zzatS, sessionDataSet.zzatS) && zzw.equal(this.zzave, sessionDataSet.zzave);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionDataSet) && zza((SessionDataSet) o));
    }

    public Session getSession() {
        return this.zzatS;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzatS, this.zzave);
    }

    public String toString() {
        return zzw.zzx(this).zzg("session", this.zzatS).zzg("dataSet", this.zzave).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzq.zza(this, dest, flags);
    }

    public DataSet zztT() {
        return this.zzave;
    }
}
