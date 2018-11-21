package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
    public static final Creator<Cart> CREATOR = new zzb();
    private final int mVersionCode;
    String zzbiZ;
    String zzbja;
    ArrayList<LineItem> zzbjb;

    public final class Builder {
        final /* synthetic */ Cart zzbjc;

        private Builder(Cart cart) {
            this.zzbjc = cart;
        }

        public Builder addLineItem(LineItem lineItem) {
            this.zzbjc.zzbjb.add(lineItem);
            return this;
        }

        public Cart build() {
            return this.zzbjc;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.zzbjc.zzbja = currencyCode;
            return this;
        }

        public Builder setLineItems(List<LineItem> lineItems) {
            this.zzbjc.zzbjb.clear();
            this.zzbjc.zzbjb.addAll(lineItems);
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            this.zzbjc.zzbiZ = totalPrice;
            return this;
        }
    }

    Cart() {
        this.mVersionCode = 1;
        this.zzbjb = new ArrayList();
    }

    Cart(int versionCode, String totalPrice, String currencyCode, ArrayList<LineItem> lineItems) {
        this.mVersionCode = versionCode;
        this.zzbiZ = totalPrice;
        this.zzbja = currencyCode;
        this.zzbjb = lineItems;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzbja;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.zzbjb;
    }

    public String getTotalPrice() {
        return this.zzbiZ;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
