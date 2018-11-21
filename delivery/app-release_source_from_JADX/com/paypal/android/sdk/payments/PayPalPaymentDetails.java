package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import java.math.BigDecimal;
import org.json.JSONObject;

public final class PayPalPaymentDetails implements Parcelable {
    public static final Creator CREATOR = new av();
    private static final String f799a = PayPalPaymentDetails.class.getSimpleName();
    private BigDecimal f800b;
    private BigDecimal f801c;
    private BigDecimal f802d;

    private PayPalPaymentDetails(Parcel parcel) {
        BigDecimal bigDecimal = null;
        try {
            String readString = parcel.readString();
            this.f801c = readString == null ? null : new BigDecimal(readString);
            readString = parcel.readString();
            this.f800b = readString == null ? null : new BigDecimal(readString);
            String readString2 = parcel.readString();
            if (readString2 != null) {
                bigDecimal = new BigDecimal(readString2);
            }
            this.f802d = bigDecimal;
        } catch (NumberFormatException e) {
            throw new RuntimeException("error unparceling PayPalPaymentDetails");
        }
    }

    public PayPalPaymentDetails(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3) {
        this.f801c = bigDecimal;
        this.f800b = bigDecimal2;
        this.f802d = bigDecimal3;
    }

    protected final BigDecimal m578a() {
        return this.f800b;
    }

    protected final BigDecimal m579b() {
        return this.f801c;
    }

    protected final BigDecimal m580c() {
        return this.f802d;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean isProcessable() {
        return this.f800b != null;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f801c != null) {
                jSONObject.put("shipping", this.f801c.toPlainString());
            }
            if (this.f800b != null) {
                jSONObject.put("subtotal", this.f800b.toPlainString());
            }
            if (this.f802d == null) {
                return jSONObject;
            }
            jSONObject.put("tax", this.f802d.toPlainString());
            return jSONObject;
        } catch (Throwable e) {
            Log.e(f799a, "error encoding JSON", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        String str = null;
        parcel.writeString(this.f801c == null ? null : this.f801c.toString());
        parcel.writeString(this.f800b == null ? null : this.f800b.toString());
        if (this.f802d != null) {
            str = this.f802d.toString();
        }
        parcel.writeString(str);
    }
}
