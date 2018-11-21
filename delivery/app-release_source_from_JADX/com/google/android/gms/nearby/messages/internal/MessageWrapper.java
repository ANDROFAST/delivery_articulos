package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;

public class MessageWrapper implements SafeParcelable {
    public static final zzi CREATOR = new zzi();
    final int mVersionCode;
    public final Message zzaXn;

    MessageWrapper(int versionCode, Message message) {
        this.mVersionCode = versionCode;
        this.zzaXn = (Message) zzx.zzy(message);
    }

    public static final MessageWrapper zza(Message message) {
        return new MessageWrapper(1, message);
    }

    public int describeContents() {
        zzi com_google_android_gms_nearby_messages_internal_zzi = CREATOR;
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageWrapper)) {
            return false;
        }
        return zzw.equal(this.zzaXn, ((MessageWrapper) o).zzaXn);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaXn);
    }

    public void writeToParcel(Parcel out, int flags) {
        zzi com_google_android_gms_nearby_messages_internal_zzi = CREATOR;
        zzi.zza(this, out, flags);
    }
}
