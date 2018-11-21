package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

public abstract class WriteAwareParcelable implements Parcelable {
    private volatile transient boolean zzanA = false;

    public void writeToParcel(Parcel dest, int flags) {
        zzx.zzaa(!zzsw());
        this.zzanA = true;
        zzJ(dest, flags);
    }

    protected abstract void zzJ(Parcel parcel, int i);

    public final boolean zzsw() {
        return this.zzanA;
    }
}
