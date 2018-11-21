package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.paypal.android.sdk.cj;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

final class bx implements Parcelable {
    public static final Creator CREATOR = new by();
    private List f981a;
    private String f982b;
    private String f983c;
    private String f984d;

    bx() {
        this.f981a = new ArrayList();
    }

    public bx(Parcel parcel) {
        this();
        if (parcel != null) {
            this.f982b = parcel.readString();
            this.f983c = parcel.readString();
            this.f984d = parcel.readString();
            this.f981a = new ArrayList();
            parcel.readList(this.f981a, String.class.getClassLoader());
        }
    }

    bx(cj cjVar) {
        this.f981a = m765a(cjVar.m1215u());
        this.f982b = cjVar.m1216v();
        this.f983c = cjVar.m1217w();
        this.f984d = cjVar.m1218x();
    }

    private static List m765a(Map map) {
        List arrayList = new ArrayList();
        for (String str : map.keySet()) {
            if (((String) map.get(str)).toUpperCase().equals("Y")) {
                arrayList.add(str.toLowerCase(Locale.US));
            }
        }
        return arrayList;
    }

    public final List m766a() {
        return this.f981a;
    }

    public final String m767b() {
        return this.f982b;
    }

    public final String m768c() {
        return this.f983c;
    }

    public final String m769d() {
        return this.f984d;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f982b);
        parcel.writeString(this.f983c);
        parcel.writeString(this.f984d);
        parcel.writeList(this.f981a);
    }
}
