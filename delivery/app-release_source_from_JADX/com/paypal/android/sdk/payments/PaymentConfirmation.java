package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import org.json.JSONObject;

public final class PaymentConfirmation implements Parcelable {
    public static final Creator CREATOR = new bl();
    private static final String f849a = PaymentConfirmation.class.getSimpleName();
    private String f850b;
    private PayPalPayment f851c;
    private ProofOfPayment f852d;

    private PaymentConfirmation(Parcel parcel) {
        this.f850b = parcel.readString();
        this.f851c = (PayPalPayment) parcel.readParcelable(PayPalPayment.class.getClassLoader());
        this.f852d = (ProofOfPayment) parcel.readParcelable(ProofOfPayment.class.getClassLoader());
    }

    PaymentConfirmation(String str, PayPalPayment payPalPayment, ProofOfPayment proofOfPayment) {
        this.f850b = str;
        this.f851c = payPalPayment;
        this.f852d = proofOfPayment;
    }

    public final int describeContents() {
        return 0;
    }

    public final String getEnvironment() {
        return this.f850b;
    }

    public final PayPalPayment getPayment() {
        return this.f851c;
    }

    public final ProofOfPayment getProofOfPayment() {
        return this.f852d;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("environment", this.f850b);
            jSONObject2.put("paypal_sdk_version", "2.9.8");
            jSONObject2.put("platform", "Android");
            jSONObject2.put("product_name", "PayPal-Android-SDK");
            jSONObject.put("client", jSONObject2);
            jSONObject.put("response", this.f852d.toJSONObject());
            jSONObject.put("response_type", "payment");
            return jSONObject;
        } catch (Throwable e) {
            Log.e(f849a, "Error encoding JSON", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f850b);
        parcel.writeParcelable(this.f851c, 0);
        parcel.writeParcelable(this.f852d, 0);
    }
}
