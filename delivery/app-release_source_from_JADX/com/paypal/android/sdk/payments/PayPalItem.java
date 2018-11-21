package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.paypal.android.sdk.C0510f;
import com.paypal.android.sdk.bO;
import java.math.BigDecimal;
import org.json.JSONArray;
import org.json.JSONObject;

public final class PayPalItem implements Parcelable {
    public static final Creator CREATOR = new as();
    private String f780a;
    private Integer f781b;
    private BigDecimal f782c;
    private String f783d;
    private String f784e;

    static {
        PayPalItem.class.getSimpleName();
    }

    private PayPalItem(Parcel parcel) {
        this.f780a = parcel.readString();
        this.f781b = Integer.valueOf(parcel.readInt());
        try {
            this.f782c = new BigDecimal(parcel.readString());
        } catch (NumberFormatException e) {
        }
        this.f783d = parcel.readString();
        this.f784e = parcel.readString();
    }

    public PayPalItem(String str, Integer num, BigDecimal bigDecimal, String str2, String str3) {
        this.f780a = str;
        this.f781b = num;
        this.f782c = bigDecimal;
        this.f783d = str2;
        this.f784e = str3;
    }

    public static BigDecimal getItemTotal(PayPalItem[] payPalItemArr) {
        BigDecimal bigDecimal = new BigDecimal("0.00");
        for (PayPalItem payPalItem : payPalItemArr) {
            bigDecimal = bigDecimal.add(payPalItem.f782c.multiply(BigDecimal.valueOf((long) payPalItem.f781b.intValue())));
        }
        return bigDecimal;
    }

    public static JSONArray toJSONArray(PayPalItem[] payPalItemArr) {
        JSONArray jSONArray = new JSONArray();
        for (PayPalItem payPalItem : payPalItemArr) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.accumulate("quantity", Integer.toString(payPalItem.f781b.intValue()));
            jSONObject.accumulate("name", payPalItem.f780a);
            jSONObject.accumulate("price", payPalItem.f782c.toString());
            jSONObject.accumulate("currency", payPalItem.f783d);
            if (payPalItem.f784e != null) {
                jSONObject.accumulate("sku", payPalItem.f784e);
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public final int describeContents() {
        return 0;
    }

    public final String getCurrency() {
        return this.f783d;
    }

    public final String getName() {
        return this.f780a;
    }

    public final BigDecimal getPrice() {
        return this.f782c;
    }

    public final Integer getQuantity() {
        return this.f781b;
    }

    public final String getSku() {
        return this.f784e;
    }

    public final boolean isValid() {
        if (this.f781b.intValue() <= 0) {
            Log.e("paypal.sdk", "item.quantity must be a positive integer.");
            return false;
        } else if (!bO.m222a(this.f783d)) {
            Log.e("paypal.sdk", "item.currency field is required, and must be a supported currency.");
            return false;
        } else if (C0510f.m464c(this.f780a)) {
            Log.e("paypal.sdk", "item.name field is required.");
            return false;
        } else if (bO.m223a(this.f782c, this.f783d, false)) {
            return true;
        } else {
            Log.e("paypal.sdk", "item.price field is required.");
            return false;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f780a);
        parcel.writeInt(this.f781b.intValue());
        parcel.writeString(this.f782c.toString());
        parcel.writeString(this.f783d);
        parcel.writeString(this.f784e);
    }
}
