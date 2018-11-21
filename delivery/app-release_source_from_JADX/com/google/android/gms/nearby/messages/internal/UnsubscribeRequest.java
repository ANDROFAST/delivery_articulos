package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zzb.zza;

public final class UnsubscribeRequest implements SafeParcelable {
    public static final Creator<UnsubscribeRequest> CREATOR = new zzr();
    final int mVersionCode;
    public final String zzaWI;
    public final boolean zzaWK;
    public final String zzaXH;
    public final zzb zzaXL;
    public final PendingIntent zzaXN;
    public final int zzaXO;
    public final zzc zzaXm;

    UnsubscribeRequest(int versionCode, IBinder messageListener, IBinder callbackAsBinder, PendingIntent pendingIntent, int messageListenerKey, String zeroPartyPackageName, String realClientPackageName, boolean useRealClientApiKey) {
        this.mVersionCode = versionCode;
        this.zzaXL = zza.zzdt(messageListener);
        this.zzaXm = zzc.zza.zzdu(callbackAsBinder);
        this.zzaXN = pendingIntent;
        this.zzaXO = messageListenerKey;
        this.zzaWI = zeroPartyPackageName;
        this.zzaXH = realClientPackageName;
        this.zzaWK = useRealClientApiKey;
    }

    UnsubscribeRequest(IBinder messageListener, IBinder callbackAsBinder, PendingIntent pendingIntent, int messageListenerKey, String zeroPartyPackageName, String realClientPackageName, boolean useRealClientApiKey) {
        this(1, messageListener, callbackAsBinder, pendingIntent, messageListenerKey, zeroPartyPackageName, realClientPackageName, useRealClientApiKey);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzr.zza(this, dest, flags);
    }

    IBinder zzCJ() {
        return this.zzaXm.asBinder();
    }

    IBinder zzCM() {
        return this.zzaXL == null ? null : this.zzaXL.asBinder();
    }
}
