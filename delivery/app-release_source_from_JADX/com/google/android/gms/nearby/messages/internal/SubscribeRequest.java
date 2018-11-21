package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.zzb.zza;

public final class SubscribeRequest implements SafeParcelable {
    public static final Creator<SubscribeRequest> CREATOR = new zzp();
    final int mVersionCode;
    public final String zzaWI;
    public final boolean zzaWJ;
    public final boolean zzaWK;
    public final Strategy zzaXG;
    public final String zzaXH;
    public final zzb zzaXL;
    public final MessageFilter zzaXM;
    public final PendingIntent zzaXN;
    public final int zzaXO;
    public final byte[] zzaXP;
    public final zzg zzaXQ;
    public final zzc zzaXm;

    SubscribeRequest(int versionCode, IBinder messageListener, Strategy strategy, IBinder callbackAsBinder, MessageFilter filter, PendingIntent pendingIntent, int messageListenerKey, String zeroPartyPackageName, String realClientPackageName, byte[] hint, boolean isIgnoreNearbyPermission, IBinder subscribeCallbackAsBinder, boolean useRealClientApiKey) {
        this.mVersionCode = versionCode;
        this.zzaXL = zza.zzdt(messageListener);
        this.zzaXG = strategy;
        this.zzaXm = zzc.zza.zzdu(callbackAsBinder);
        this.zzaXM = filter;
        this.zzaXN = pendingIntent;
        this.zzaXO = messageListenerKey;
        this.zzaWI = zeroPartyPackageName;
        this.zzaXH = realClientPackageName;
        this.zzaXP = hint;
        this.zzaWJ = isIgnoreNearbyPermission;
        this.zzaXQ = subscribeCallbackAsBinder == null ? null : zzg.zza.zzdy(subscribeCallbackAsBinder);
        this.zzaWK = useRealClientApiKey;
    }

    public SubscribeRequest(IBinder messageListener, Strategy strategy, IBinder callbackAsBinder, MessageFilter filter, PendingIntent pendingIntent, int messageListenerKey, String zeroPartyPackageName, String realClientPackageName, byte[] hint, boolean isIgnoreNearbyPermission, IBinder subscribeCallbackAsBinder, boolean useRealClientApiKey) {
        this(3, messageListener, strategy, callbackAsBinder, filter, pendingIntent, messageListenerKey, zeroPartyPackageName, realClientPackageName, hint, isIgnoreNearbyPermission, subscribeCallbackAsBinder, useRealClientApiKey);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzp.zza(this, dest, flags);
    }

    IBinder zzCJ() {
        return this.zzaXm == null ? null : this.zzaXm.asBinder();
    }

    IBinder zzCM() {
        return this.zzaXL == null ? null : this.zzaXL.asBinder();
    }

    IBinder zzCN() {
        return this.zzaXQ == null ? null : this.zzaXQ.asBinder();
    }
}
