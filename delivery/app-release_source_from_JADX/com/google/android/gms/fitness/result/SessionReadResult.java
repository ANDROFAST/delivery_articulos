package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionReadResult implements Result, SafeParcelable {
    public static final Creator<SessionReadResult> CREATOR = new zzj();
    private final int mVersionCode;
    private final Status zzTA;
    private final List<Session> zzaym;
    private final List<SessionDataSet> zzazu;

    SessionReadResult(int versionCode, List<Session> sessions, List<SessionDataSet> sessionDataSets, Status status) {
        this.mVersionCode = versionCode;
        this.zzaym = sessions;
        this.zzazu = Collections.unmodifiableList(sessionDataSets);
        this.zzTA = status;
    }

    public SessionReadResult(List<Session> sessions, List<SessionDataSet> sessionDataSets, Status status) {
        this.mVersionCode = 3;
        this.zzaym = sessions;
        this.zzazu = Collections.unmodifiableList(sessionDataSets);
        this.zzTA = status;
    }

    public static SessionReadResult zzV(Status status) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    private boolean zzb(SessionReadResult sessionReadResult) {
        return this.zzTA.equals(sessionReadResult.zzTA) && zzw.equal(this.zzaym, sessionReadResult.zzaym) && zzw.equal(this.zzazu, sessionReadResult.zzazu);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SessionReadResult) && zzb((SessionReadResult) that));
    }

    public List<DataSet> getDataSet(Session session) {
        zzx.zzb(this.zzaym.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (SessionDataSet sessionDataSet : this.zzazu) {
            if (zzw.equal(session, sessionDataSet.getSession())) {
                arrayList.add(sessionDataSet.zztT());
            }
        }
        return arrayList;
    }

    public List<DataSet> getDataSet(Session session, DataType dataType) {
        zzx.zzb(this.zzaym.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (SessionDataSet sessionDataSet : this.zzazu) {
            if (zzw.equal(session, sessionDataSet.getSession()) && dataType.equals(sessionDataSet.zztT().getDataType())) {
                arrayList.add(sessionDataSet.zztT());
            }
        }
        return arrayList;
    }

    public List<Session> getSessions() {
        return this.zzaym;
    }

    public Status getStatus() {
        return this.zzTA;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzTA, this.zzaym, this.zzazu);
    }

    public String toString() {
        return zzw.zzx(this).zzg("status", this.zzTA).zzg("sessions", this.zzaym).zzg("sessionDataSets", this.zzazu).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    public List<SessionDataSet> zzuN() {
        return this.zzazu;
    }
}
