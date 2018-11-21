package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class C0511g implements Parcelable {
    public static final Creator CREATOR = new C0512h();
    private String f673a;

    public C0511g(Parcel parcel) {
        this.f673a = parcel.readString();
    }

    public C0511g(String str) {
        if (str.equals("OTHER") || str.length() == 2) {
            this.f673a = str;
        } else {
            this.f673a = "US";
        }
    }

    public final String m474a() {
        return this.f673a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f673a.equals(((C0511g) obj).f673a);
    }

    public int hashCode() {
        return this.f673a.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f673a);
    }
}
