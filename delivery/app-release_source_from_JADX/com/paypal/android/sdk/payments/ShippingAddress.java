package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.paypal.android.sdk.C0510f;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShippingAddress implements Parcelable {
    public static final Creator CREATOR = new bC();
    private static final String f875a = ShippingAddress.class.getSimpleName();
    private String f876b;
    private String f877c;
    private String f878d;
    private String f879e;
    private String f880f;
    private String f881g;
    private String f882h;

    private ShippingAddress(Parcel parcel) {
        this.f876b = parcel.readString();
        this.f877c = parcel.readString();
        this.f878d = parcel.readString();
        this.f879e = parcel.readString();
        this.f880f = parcel.readString();
        this.f881g = parcel.readString();
        this.f882h = parcel.readString();
    }

    private static void m720a(boolean z, String str) {
        if (!z) {
            Log.e(f875a, str + " is invalid.  Please see the docs.");
        }
    }

    private static boolean m721a(String str) {
        return C0510f.m467d((CharSequence) str);
    }

    private static boolean m722a(String str, String str2) {
        return C0510f.m464c((CharSequence) str) ? C0510f.m464c((CharSequence) str2) : C0510f.m464c((CharSequence) str2) ? false : str.trim().equals(str2.trim());
    }

    final boolean m723a(JSONObject jSONObject) {
        return m722a(jSONObject.optString("recipient_name"), this.f876b) && m722a(jSONObject.optString("line1"), this.f877c) && m722a(jSONObject.optString("line2"), this.f878d) && m722a(jSONObject.optString("city"), this.f879e) && m722a(jSONObject.optString("state"), this.f880f) && m722a(jSONObject.optString("country_code"), this.f882h) && m722a(jSONObject.optString("postal_code"), this.f881g);
    }

    public final ShippingAddress city(String str) {
        this.f879e = str;
        return this;
    }

    public final ShippingAddress countryCode(String str) {
        this.f882h = str;
        return this;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean isProcessable() {
        boolean d = C0510f.m467d(this.f876b);
        boolean d2 = C0510f.m467d(this.f877c);
        boolean d3 = C0510f.m467d(this.f879e);
        boolean z = C0510f.m467d(this.f882h) && this.f882h.length() == 2;
        m720a(d, "recipient_name");
        m720a(d2, "line1");
        m720a(d3, "city");
        m720a(z, "country_code");
        return d && d2 && d3 && z;
    }

    public final ShippingAddress line1(String str) {
        this.f877c = str;
        return this;
    }

    public final ShippingAddress line2(String str) {
        this.f878d = str;
        return this;
    }

    public final ShippingAddress postalCode(String str) {
        this.f881g = str;
        return this;
    }

    public final ShippingAddress recipientName(String str) {
        this.f876b = str;
        return this;
    }

    public final ShippingAddress state(String str) {
        this.f880f = str;
        return this;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.accumulate("recipient_name", this.f876b);
            jSONObject.accumulate("line1", this.f877c);
            jSONObject.accumulate("city", this.f879e);
            jSONObject.accumulate("country_code", this.f882h);
            if (m721a(this.f878d)) {
                jSONObject.accumulate("line2", this.f878d);
            }
            if (m721a(this.f880f)) {
                jSONObject.accumulate("state", this.f880f);
            }
            if (m721a(this.f881g)) {
                jSONObject.accumulate("postal_code", this.f881g);
            }
        } catch (JSONException e) {
            Log.e(f875a, e.getMessage());
        }
        return jSONObject;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f876b);
        parcel.writeString(this.f877c);
        parcel.writeString(this.f878d);
        parcel.writeString(this.f879e);
        parcel.writeString(this.f880f);
        parcel.writeString(this.f881g);
        parcel.writeString(this.f882h);
    }
}
