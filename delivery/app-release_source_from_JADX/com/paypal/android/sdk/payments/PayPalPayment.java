package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.paypal.android.sdk.C0510f;
import com.paypal.android.sdk.bO;
import com.paypal.android.sdk.bq;
import java.math.BigDecimal;
import java.util.Locale;
import org.json.JSONObject;

public final class PayPalPayment implements Parcelable {
    public static final Creator CREATOR = new au();
    public static final String PAYMENT_INTENT_AUTHORIZE = "authorize";
    public static final String PAYMENT_INTENT_ORDER = "order";
    public static final String PAYMENT_INTENT_SALE = "sale";
    private static final String f786a = PayPalPayment.class.getSimpleName();
    private BigDecimal f787b;
    private String f788c;
    private String f789d;
    private String f790e;
    private PayPalPaymentDetails f791f;
    private String f792g;
    private PayPalItem[] f793h;
    private boolean f794i;
    private ShippingAddress f795j;
    private String f796k;
    private String f797l;
    private String f798m;

    private PayPalPayment(Parcel parcel) {
        this.f788c = parcel.readString();
        try {
            this.f787b = new BigDecimal(parcel.readString());
        } catch (NumberFormatException e) {
        }
        this.f789d = parcel.readString();
        this.f792g = parcel.readString();
        this.f790e = parcel.readString();
        this.f791f = (PayPalPaymentDetails) parcel.readParcelable(PayPalPaymentDetails.class.getClassLoader());
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.f793h = new PayPalItem[readInt];
            parcel.readTypedArray(this.f793h, PayPalItem.CREATOR);
        }
        this.f795j = (ShippingAddress) parcel.readParcelable(ShippingAddress.class.getClassLoader());
        this.f794i = parcel.readInt() == 1;
        this.f796k = parcel.readString();
        this.f797l = parcel.readString();
        this.f798m = parcel.readString();
    }

    public PayPalPayment(BigDecimal bigDecimal, String str, String str2, String str3) {
        this.f787b = bigDecimal;
        this.f788c = str;
        this.f789d = str2;
        this.f792g = str3;
        this.f791f = null;
        this.f790e = null;
        toString();
    }

    private static void m566a(boolean z, String str) {
        if (!z) {
            Log.e("paypal.sdk", str + " is invalid.  Please see the docs.");
        }
    }

    private static boolean m567a(String str, String str2, int i) {
        if (!C0510f.m467d((CharSequence) str) || str.length() <= i) {
            return true;
        }
        Log.e("paypal.sdk", str2 + " is too long (max " + i + ")");
        return false;
    }

    protected final BigDecimal m568a() {
        return this.f787b;
    }

    protected final String m569b() {
        return this.f789d;
    }

    public final PayPalPayment bnCode(String str) {
        this.f790e = str;
        return this;
    }

    protected final String m570c() {
        return this.f792g;
    }

    public final PayPalPayment custom(String str) {
        this.f797l = str;
        return this;
    }

    protected final String m571d() {
        return this.f788c;
    }

    public final int describeContents() {
        return 0;
    }

    protected final String m572e() {
        return this.f790e;
    }

    public final PayPalPayment enablePayPalShippingAddressesRetrieval(boolean z) {
        this.f794i = z;
        return this;
    }

    protected final PayPalPaymentDetails m573f() {
        return this.f791f;
    }

    protected final PayPalItem[] m574g() {
        return this.f793h;
    }

    public final String getAmountAsLocalizedString() {
        if (this.f787b == null) {
            return null;
        }
        return bO.m221a(Locale.getDefault(), bq.m947a().mo3737c().m474a(), this.f787b.doubleValue(), this.f788c, true);
    }

    public final ShippingAddress getProvidedShippingAddress() {
        return this.f795j;
    }

    protected final String m575h() {
        return this.f796k;
    }

    protected final String m576i() {
        return this.f797l;
    }

    public final PayPalPayment invoiceNumber(String str) {
        this.f796k = str;
        return this;
    }

    public final boolean isEnablePayPalShippingAddressesRetrieval() {
        return this.f794i;
    }

    public final boolean isProcessable() {
        boolean z;
        boolean a = bO.m222a(this.f788c);
        boolean a2 = bO.m223a(this.f787b, this.f788c, true);
        boolean b = C0510f.m462b(this.f789d);
        boolean z2 = C0510f.m467d(this.f792g) && (this.f792g.equals(PAYMENT_INTENT_SALE) || this.f792g.equals(PAYMENT_INTENT_AUTHORIZE) || this.f792g.equals(PAYMENT_INTENT_ORDER));
        boolean isProcessable = this.f791f == null ? true : this.f791f.isProcessable();
        boolean e = C0510f.m464c(this.f790e) ? true : C0510f.m469e(this.f790e);
        if (this.f793h == null || this.f793h.length == 0) {
            z = true;
        } else {
            for (PayPalItem isValid : this.f793h) {
                if (!isValid.isValid()) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        boolean z3 = m567a(this.f796k, "invoiceNumber", 256);
        if (!m567a(this.f797l, "custom", 256)) {
            z3 = false;
        }
        if (!m567a(this.f798m, "softDescriptor", 22)) {
            z3 = false;
        }
        m566a(a, "currencyCode");
        m566a(a2, "amount");
        m566a(b, "shortDescription");
        m566a(z2, "paymentIntent");
        m566a(isProcessable, "details");
        m566a(e, "bnCode");
        m566a(z, "items");
        return a && a2 && b && isProcessable && z2 && e && z && z3;
    }

    public final PayPalPayment items(PayPalItem[] payPalItemArr) {
        this.f793h = payPalItemArr;
        return this;
    }

    protected final String m577j() {
        return this.f798m;
    }

    public final PayPalPayment paymentDetails(PayPalPaymentDetails payPalPaymentDetails) {
        this.f791f = payPalPaymentDetails;
        return this;
    }

    public final PayPalPayment providedShippingAddress(ShippingAddress shippingAddress) {
        this.f795j = shippingAddress;
        return this;
    }

    public final PayPalPayment softDescriptor(String str) {
        this.f798m = str;
        return this;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("amount", this.f787b.toPlainString());
            jSONObject.put("currency_code", this.f788c);
            if (this.f791f != null) {
                jSONObject.put("details", this.f791f.toJSONObject());
            }
            jSONObject.put("short_description", this.f789d);
            jSONObject.put("intent", this.f792g.toString());
            if (C0510f.m467d(this.f790e)) {
                jSONObject.put("bn_code", this.f790e);
            }
            if (this.f793h == null || this.f793h.length <= 0) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.accumulate("items", PayPalItem.toJSONArray(this.f793h));
            jSONObject.put("item_list", jSONObject2);
            return jSONObject;
        } catch (Throwable e) {
            Log.e("paypal.sdk", "error encoding JSON", e);
            return null;
        }
    }

    public final String toString() {
        String str = "PayPalPayment: {%s: $%s %s, %s}";
        Object[] objArr = new Object[4];
        objArr[0] = this.f789d;
        objArr[1] = this.f787b != null ? this.f787b.toString() : null;
        objArr[2] = this.f788c;
        objArr[3] = this.f792g;
        return String.format(str, objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.f788c);
        parcel.writeString(this.f787b.toString());
        parcel.writeString(this.f789d);
        parcel.writeString(this.f792g);
        parcel.writeString(this.f790e);
        parcel.writeParcelable(this.f791f, 0);
        if (this.f793h != null) {
            parcel.writeInt(this.f793h.length);
            parcel.writeTypedArray(this.f793h, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.f795j, 0);
        if (this.f794i) {
            i2 = 1;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.f796k);
        parcel.writeString(this.f797l);
        parcel.writeString(this.f798m);
    }
}
