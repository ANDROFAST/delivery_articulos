package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import org.json.JSONObject;

public final class PayPalAuthorization implements Parcelable {
    public static final Creator CREATOR = new al();
    private String f756a;
    private String f757b;
    private String f758c;

    static {
        PayPalAuthorization.class.getSimpleName();
    }

    private PayPalAuthorization(Parcel parcel) {
        this.f756a = parcel.readString();
        this.f757b = parcel.readString();
        this.f758c = parcel.readString();
    }

    PayPalAuthorization(String str, String str2, String str3) {
        this.f756a = str;
        this.f757b = str2;
        if ("partner".equals(BuildConfig.FLAVOR)) {
            this.f758c = str3;
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final String getAuthorizationCode() {
        return this.f757b;
    }

    public final String getEnvironment() {
        return this.f756a;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("environment", this.f756a);
            jSONObject2.put("paypal_sdk_version", "2.9.8");
            jSONObject2.put("platform", "Android");
            jSONObject2.put("product_name", "PayPal-Android-SDK");
            jSONObject.put("client", jSONObject2);
            jSONObject2 = new JSONObject();
            jSONObject2.put("code", this.f757b);
            jSONObject.put("response", jSONObject2);
            if ("partner".equals(BuildConfig.FLAVOR)) {
                jSONObject2 = new JSONObject();
                jSONObject2.put("display_string", this.f758c);
                jSONObject.put("user", jSONObject2);
            }
            jSONObject.put("response_type", "authorization_code");
            return jSONObject;
        } catch (Throwable e) {
            Log.e("paypal.sdk", "Error encoding JSON", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f756a);
        parcel.writeString(this.f757b);
        parcel.writeString(this.f758c);
    }
}
