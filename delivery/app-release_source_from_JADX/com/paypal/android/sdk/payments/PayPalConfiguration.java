package com.paypal.android.sdk.payments;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.paypal.android.sdk.C0506b;
import com.paypal.android.sdk.C0508d;
import com.paypal.android.sdk.C0510f;
import com.paypal.android.sdk.av;
import java.util.concurrent.ExecutorService;

public final class PayPalConfiguration implements Parcelable {
    public static final Creator CREATOR = new am();
    public static final String ENVIRONMENT_NO_NETWORK = "mock";
    public static final String ENVIRONMENT_PRODUCTION = "live";
    public static final String ENVIRONMENT_SANDBOX = "sandbox";
    private static final String f759a = PayPalConfiguration.class.getSimpleName();
    private String f760b;
    private String f761c;
    private String f762d;
    private String f763e;
    private String f764f;
    private boolean f765g;
    private String f766h;
    private String f767i;
    private boolean f768j;
    private String f769k;
    private String f770l;
    private Uri f771m;
    private Uri f772n;
    private boolean f773o;

    public PayPalConfiguration() {
        this.f768j = true;
        this.f773o = true;
    }

    private PayPalConfiguration(Parcel parcel) {
        boolean z = true;
        this.f768j = true;
        this.f773o = true;
        this.f761c = parcel.readString();
        this.f760b = parcel.readString();
        this.f762d = parcel.readString();
        this.f763e = parcel.readString();
        this.f764f = parcel.readString();
        this.f765g = parcel.readByte() == (byte) 1;
        this.f766h = parcel.readString();
        this.f767i = parcel.readString();
        this.f768j = parcel.readByte() == (byte) 1;
        this.f769k = parcel.readString();
        this.f770l = parcel.readString();
        this.f771m = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f772n = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f773o = z;
    }

    private static void m537a(boolean z, String str) {
        if (!z) {
            Log.e(f759a, str + " is invalid.  Please see the docs.");
        }
    }

    public static final String getApplicationCorrelationId(Context context) {
        return getClientMetadataId(context);
    }

    public static final String getClientMetadataId(Context context) {
        ExecutorService executorService = PayPalService.f809a;
        C0840l c0840l = new C0840l();
        return C0508d.m433a(executorService, context, new C0506b(context, "AndroidBasePrefs"), "2.9.8");
    }

    public static final String getLibraryVersion() {
        return "2.9.8";
    }

    final String m538a() {
        return this.f760b;
    }

    public final PayPalConfiguration acceptCreditCards(boolean z) {
        this.f768j = z;
        return this;
    }

    final String m539b() {
        if (C0510f.m459a(this.f761c)) {
            this.f761c = ENVIRONMENT_PRODUCTION;
            Log.w("paypal.sdk", "defaulting to production environment");
        }
        return this.f761c;
    }

    final String m540c() {
        return this.f762d;
    }

    public final PayPalConfiguration clientId(String str) {
        this.f769k = str;
        return this;
    }

    final String m541d() {
        return this.f763e;
    }

    public final PayPalConfiguration defaultUserEmail(String str) {
        this.f762d = str;
        return this;
    }

    public final PayPalConfiguration defaultUserPhone(String str) {
        this.f763e = str;
        return this;
    }

    public final PayPalConfiguration defaultUserPhoneCountryCode(String str) {
        this.f764f = str;
        return this;
    }

    public final int describeContents() {
        return 0;
    }

    final String m542e() {
        return this.f764f;
    }

    public final PayPalConfiguration environment(String str) {
        this.f761c = str;
        return this;
    }

    final boolean m543f() {
        return this.f765g;
    }

    public final PayPalConfiguration forceDefaultsOnSandbox(boolean z) {
        this.f765g = z;
        return this;
    }

    final String m544g() {
        return this.f766h;
    }

    final String m545h() {
        return this.f767i;
    }

    final boolean m546i() {
        return this.f768j;
    }

    final boolean m547j() {
        return this.f773o;
    }

    final String m548k() {
        return this.f769k;
    }

    final String m549l() {
        return this.f770l;
    }

    public final PayPalConfiguration languageOrLocale(String str) {
        this.f760b = str;
        return this;
    }

    final Uri m550m() {
        return this.f771m;
    }

    public final PayPalConfiguration merchantName(String str) {
        this.f770l = str;
        return this;
    }

    public final PayPalConfiguration merchantPrivacyPolicyUri(Uri uri) {
        this.f771m = uri;
        return this;
    }

    public final PayPalConfiguration merchantUserAgreementUri(Uri uri) {
        this.f772n = uri;
        return this;
    }

    final Uri m551n() {
        return this.f772n;
    }

    final boolean m552o() {
        boolean z;
        boolean a = C0510f.m460a(f759a, m539b(), "environment");
        m537a(a, "environment");
        if (!a) {
            z = false;
        } else if (av.m167a(m539b())) {
            z = true;
        } else {
            z = C0510f.m460a(f759a, this.f769k, "clientId");
            m537a(z, "clientId");
        }
        return a && z;
    }

    public final PayPalConfiguration rememberUser(boolean z) {
        this.f773o = z;
        return this;
    }

    public final PayPalConfiguration sandboxUserPassword(String str) {
        this.f766h = str;
        return this;
    }

    public final PayPalConfiguration sandboxUserPin(String str) {
        this.f767i = str;
        return this;
    }

    public final String toString() {
        return String.format(PayPalConfiguration.class.getSimpleName() + ": {environment:%s, client_id:%s, languageOrLocale:%s}", new Object[]{this.f761c, this.f769k, this.f760b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.f761c);
        parcel.writeString(this.f760b);
        parcel.writeString(this.f762d);
        parcel.writeString(this.f763e);
        parcel.writeString(this.f764f);
        parcel.writeByte((byte) (this.f765g ? 1 : 0));
        parcel.writeString(this.f766h);
        parcel.writeString(this.f767i);
        parcel.writeByte((byte) (this.f768j ? 1 : 0));
        parcel.writeString(this.f769k);
        parcel.writeString(this.f770l);
        parcel.writeParcelable(this.f771m, 0);
        parcel.writeParcelable(this.f772n, 0);
        if (!this.f773o) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
    }
}
