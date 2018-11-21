package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.zzc.zza;

public final class PublishRequest implements SafeParcelable {
    public static final Creator<PublishRequest> CREATOR = new zzn();
    final int mVersionCode;
    public final String zzaWI;
    public final boolean zzaWJ;
    public final boolean zzaWK;
    public final MessageWrapper zzaXF;
    public final Strategy zzaXG;
    public final String zzaXH;
    public final zze zzaXI;
    public final zzc zzaXm;

    PublishRequest(int versionCode, MessageWrapper messageWrapper, Strategy strategy, IBinder callbackAsBinder, String zeroPartyPackageName, String realClientPackageName, boolean isIgnoreNearbyPermission, IBinder publishCallbackAsBinder, boolean useRealClientApiKey) {
        this.mVersionCode = versionCode;
        this.zzaXF = messageWrapper;
        this.zzaXG = strategy;
        this.zzaXm = zza.zzdu(callbackAsBinder);
        this.zzaWI = zeroPartyPackageName;
        this.zzaXH = realClientPackageName;
        this.zzaWJ = isIgnoreNearbyPermission;
        this.zzaXI = publishCallbackAsBinder == null ? null : zze.zza.zzdw(publishCallbackAsBinder);
        this.zzaWK = useRealClientApiKey;
    }

    PublishRequest(MessageWrapper messageWrapper, Strategy strategy, IBinder callbackAsBinder, String zeroPartyPackageName, String realClientPackageName, boolean isIgnoreNearbyPermission, IBinder publishCallbackAsBinder, boolean useRealClientApiKey) {
        this(2, messageWrapper, strategy, callbackAsBinder, zeroPartyPackageName, realClientPackageName, isIgnoreNearbyPermission, publishCallbackAsBinder, useRealClientApiKey);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzn.zza(this, dest, flags);
    }

    IBinder zzCJ() {
        return this.zzaXm.asBinder();
    }

    IBinder zzCK() {
        return this.zzaXI == null ? null : this.zzaXI.asBinder();
    }
}
