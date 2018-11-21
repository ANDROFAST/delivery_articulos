package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import java.math.BigDecimal;
import java.util.Currency;

public class bV implements Parcelable {
    public static final Creator CREATOR = new bW();
    private static /* synthetic */ boolean f293d = (!bV.class.desiredAssertionStatus());
    private BigDecimal f294a;
    private Currency f295b;
    private long f296c;

    public bV(Parcel parcel) {
        this.f296c = parcel.readLong();
        this.f294a = new BigDecimal(parcel.readString());
        try {
            this.f295b = Currency.getInstance(parcel.readString());
        } catch (IllegalArgumentException e) {
            Log.e("MoneySpec", "Exception reading currency code from parcel, reset to default");
            bY bYVar = null;
            this.f295b = Currency.getInstance(bYVar.mo3736b());
        }
    }

    public bV(BigDecimal bigDecimal, String str) {
        Currency instance = Currency.getInstance(str);
        this.f296c = System.currentTimeMillis();
        this.f294a = bigDecimal;
        this.f295b = instance;
    }

    public final BigDecimal m231a() {
        return this.f294a;
    }

    public final Currency m232b() {
        return this.f295b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (f293d || (obj instanceof bV)) {
            bV bVVar = (bV) obj;
            return bVVar.f294a == this.f294a && bVVar.f295b.equals(this.f295b);
        } else {
            throw new AssertionError();
        }
    }

    public String toString() {
        bY bYVar = null;
        return bO.m219a(bYVar.mo3736b(), this.f294a.doubleValue(), this.f295b);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f296c);
        parcel.writeString(this.f294a.toString());
        parcel.writeString(this.f295b.getCurrencyCode());
    }
}
