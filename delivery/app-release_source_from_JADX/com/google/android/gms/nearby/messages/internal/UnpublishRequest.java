package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zzc.zza;

public final class UnpublishRequest implements SafeParcelable {
    public static final Creator<UnpublishRequest> CREATOR = new zzq();
    final int mVersionCode;
    public final String zzaWI;
    public final boolean zzaWK;
    public final MessageWrapper zzaXF;
    public final String zzaXH;
    public final zzc zzaXm;

    UnpublishRequest(int versionCode, MessageWrapper messageWrapper, IBinder callbackAsBinder, String zeroPartyPackageName, String realClientPackageName, boolean useRealClientApiKey) {
        this.mVersionCode = versionCode;
        this.zzaXF = messageWrapper;
        this.zzaXm = zza.zzdu(callbackAsBinder);
        this.zzaWI = zeroPartyPackageName;
        this.zzaXH = realClientPackageName;
        this.zzaWK = useRealClientApiKey;
    }

    UnpublishRequest(MessageWrapper messageWrapper, IBinder callbackAsBinder, String zeroPartyPackageName, String realClientPackageName, boolean useRealClientApiKey) {
        this(1, messageWrapper, callbackAsBinder, zeroPartyPackageName, realClientPackageName, useRealClientApiKey);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzq.zza(this, dest, flags);
    }

    IBinder zzCJ() {
        return this.zzaXm.asBinder();
    }
}
