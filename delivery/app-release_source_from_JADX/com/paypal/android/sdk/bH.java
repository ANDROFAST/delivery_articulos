package com.paypal.android.sdk;

import android.os.Parcel;

public abstract class bH {
    protected String f277a;
    protected long f278b;

    public bH(Parcel parcel) {
        this.f277a = parcel.readString();
        this.f278b = parcel.readLong();
    }

    public final String m189b() {
        return this.f277a;
    }

    public final boolean m190c() {
        return this.f278b > System.currentTimeMillis();
    }
}
