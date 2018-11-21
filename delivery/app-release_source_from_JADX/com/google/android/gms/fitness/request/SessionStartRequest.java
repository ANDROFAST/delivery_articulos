package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class SessionStartRequest implements SafeParcelable {
    public static final Creator<SessionStartRequest> CREATOR = new zzx();
    private final int mVersionCode;
    private final Session zzatS;
    private final zzpp zzayj;

    SessionStartRequest(int versionCode, Session session, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzatS = session;
        this.zzayj = zza.zzbR(callback);
    }

    public SessionStartRequest(Session session, zzpp callback) {
        zzx.zzb(session.isOngoing(), (Object) "Cannot start a session which has already ended");
        this.mVersionCode = 3;
        this.zzatS = session;
        this.zzayj = callback;
    }

    private boolean zzb(SessionStartRequest sessionStartRequest) {
        return zzw.equal(this.zzatS, sessionStartRequest.zzatS);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionStartRequest) && zzb((SessionStartRequest) o));
    }

    public Session getSession() {
        return this.zzatS;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzatS);
    }

    public String toString() {
        return zzw.zzx(this).zzg("session", this.zzatS).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzx.zza(this, dest, flags);
    }

    public IBinder zzui() {
        return this.zzayj == null ? null : this.zzayj.asBinder();
    }
}
