package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialPickerConfig implements SafeParcelable {
    public static final Creator<CredentialPickerConfig> CREATOR = new zzb();
    private final boolean mShowCancelButton;
    final int mVersionCode;
    private final boolean zzUE;
    private final boolean zzUF;

    public static class Builder {
        private boolean mShowCancelButton = true;
        private boolean zzUE = false;
        private boolean zzUF = false;

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig();
        }

        public Builder setForNewAccount(boolean forNewAccount) {
            this.zzUF = forNewAccount;
            return this;
        }

        public Builder setShowAddAccountButton(boolean showAddAccountButton) {
            this.zzUE = showAddAccountButton;
            return this;
        }

        public Builder setShowCancelButton(boolean showCancelButton) {
            this.mShowCancelButton = showCancelButton;
            return this;
        }
    }

    CredentialPickerConfig(int version, boolean showAddAccountButton, boolean showCancelButton, boolean forNewAccount) {
        this.mVersionCode = version;
        this.zzUE = showAddAccountButton;
        this.mShowCancelButton = showCancelButton;
        this.zzUF = forNewAccount;
    }

    private CredentialPickerConfig(Builder builder) {
        this(1, builder.zzUE, builder.mShowCancelButton, builder.zzUF);
    }

    public int describeContents() {
        return 0;
    }

    public boolean isForNewAccount() {
        return this.zzUF;
    }

    public boolean shouldShowAddAccountButton() {
        return this.zzUE;
    }

    public boolean shouldShowCancelButton() {
        return this.mShowCancelButton;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
