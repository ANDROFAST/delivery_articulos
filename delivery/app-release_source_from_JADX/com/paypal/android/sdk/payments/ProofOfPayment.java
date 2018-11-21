package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.paypal.android.sdk.C0510f;
import org.json.JSONObject;

public final class ProofOfPayment implements Parcelable {
    public static final Creator CREATOR = new bz();
    private static final String f864a = ProofOfPayment.class.getSimpleName();
    private String f865b;
    private String f866c;
    private String f867d;
    private String f868e;
    private String f869f;

    private ProofOfPayment(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
    }

    ProofOfPayment(String str, String str2, String str3, String str4, String str5) {
        this.f865b = str;
        this.f866c = str2;
        this.f867d = str3;
        this.f868e = str4;
        this.f869f = str5;
        new StringBuilder("ProofOfPayment created: ").append(toString());
    }

    public final int describeContents() {
        return 0;
    }

    public final String getCreateTime() {
        return this.f867d;
    }

    public final String getIntent() {
        return this.f868e;
    }

    public final String getPaymentId() {
        return this.f866c;
    }

    public final String getState() {
        return this.f865b;
    }

    public final String getTransactionId() {
        return this.f869f;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("create_time", this.f867d);
            jSONObject.put("id", this.f866c);
            jSONObject.put("intent", this.f868e);
            jSONObject.put("state", this.f865b);
            if (!C0510f.m467d(this.f869f) || !C0510f.m467d(this.f868e)) {
                return jSONObject;
            }
            if (this.f868e.equals(PayPalPayment.PAYMENT_INTENT_AUTHORIZE)) {
                jSONObject.put("authorization_id", this.f869f);
                return jSONObject;
            } else if (!this.f868e.equals(PayPalPayment.PAYMENT_INTENT_ORDER)) {
                return jSONObject;
            } else {
                jSONObject.put("order_id", this.f869f);
                return jSONObject;
            }
        } catch (Throwable e) {
            Log.e(f864a, "error encoding JSON", e);
            return null;
        }
    }

    public final String toString() {
        return "{" + this.f868e + ": " + (C0510f.m467d(this.f869f) ? this.f869f : "no transactionId") + "}";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f865b);
        parcel.writeString(this.f866c);
        parcel.writeString(this.f867d);
        parcel.writeString(this.f868e);
        parcel.writeString(this.f869f);
    }
}
