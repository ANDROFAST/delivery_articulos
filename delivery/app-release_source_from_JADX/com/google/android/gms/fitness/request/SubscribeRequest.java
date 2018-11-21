package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class SubscribeRequest implements SafeParcelable {
    public static final Creator<SubscribeRequest> CREATOR = new zzac();
    private final int mVersionCode;
    private final zzpp zzayj;
    private Subscription zzazi;
    private final boolean zzazj;

    SubscribeRequest(int versionCode, Subscription subscription, boolean serverOnly, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzazi = subscription;
        this.zzazj = serverOnly;
        this.zzayj = zza.zzbR(callback);
    }

    public SubscribeRequest(Subscription subscription, boolean serverOnly, zzpp callback) {
        this.mVersionCode = 3;
        this.zzazi = subscription;
        this.zzazj = serverOnly;
        this.zzayj = callback;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return zzw.zzx(this).zzg("subscription", this.zzazi).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzac.zza(this, dest, flags);
    }

    public Subscription zzuF() {
        return this.zzazi;
    }

    public boolean zzuG() {
        return this.zzazj;
    }

    public IBinder zzui() {
        return this.zzayj == null ? null : this.zzayj.asBinder();
    }
}
