package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem implements SafeParcelable {
    public static final Creator<LineItem> CREATOR = new zzi();
    String description;
    private final int mVersionCode;
    String zzbiZ;
    String zzbjC;
    String zzbjD;
    int zzbjE;
    String zzbja;

    public final class Builder {
        final /* synthetic */ LineItem zzbjF;

        private Builder(LineItem lineItem) {
            this.zzbjF = lineItem;
        }

        public LineItem build() {
            return this.zzbjF;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.zzbjF.zzbja = currencyCode;
            return this;
        }

        public Builder setDescription(String description) {
            this.zzbjF.description = description;
            return this;
        }

        public Builder setQuantity(String quantity) {
            this.zzbjF.zzbjC = quantity;
            return this;
        }

        public Builder setRole(int role) {
            this.zzbjF.zzbjE = role;
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            this.zzbjF.zzbiZ = totalPrice;
            return this;
        }

        public Builder setUnitPrice(String unitPrice) {
            this.zzbjF.zzbjD = unitPrice;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    LineItem() {
        this.mVersionCode = 1;
        this.zzbjE = 0;
    }

    LineItem(int versionCode, String description, String quantity, String unitPrice, String totalPrice, int role, String currencyCode) {
        this.mVersionCode = versionCode;
        this.description = description;
        this.zzbjC = quantity;
        this.zzbjD = unitPrice;
        this.zzbiZ = totalPrice;
        this.zzbjE = role;
        this.zzbja = currencyCode;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzbja;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.zzbjC;
    }

    public int getRole() {
        return this.zzbjE;
    }

    public String getTotalPrice() {
        return this.zzbiZ;
    }

    public String getUnitPrice() {
        return this.zzbjD;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
