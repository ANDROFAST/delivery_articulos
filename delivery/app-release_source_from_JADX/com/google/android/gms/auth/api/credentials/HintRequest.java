package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class HintRequest implements SafeParcelable {
    public static final Creator<HintRequest> CREATOR = new zzd();
    final int mVersionCode;
    private final String[] zzUH;
    private final CredentialPickerConfig zzUK;
    private final boolean zzUL;
    private final boolean zzUM;

    public static final class Builder {
        private String[] zzUH;
        private CredentialPickerConfig zzUK = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        private boolean zzUL;
        private boolean zzUM;

        public HintRequest build() {
            if (this.zzUH == null) {
                this.zzUH = new String[0];
            }
            if (this.zzUL || this.zzUM || this.zzUH.length != 0) {
                return new HintRequest();
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        public Builder setAccountTypes(String... accountTypes) {
            if (accountTypes == null) {
                accountTypes = new String[0];
            }
            this.zzUH = accountTypes;
            return this;
        }

        public Builder setEmailAddressIdentifierSupported(boolean emailAddressIdentifierSupported) {
            this.zzUL = emailAddressIdentifierSupported;
            return this;
        }

        public Builder setHintPickerConfig(CredentialPickerConfig hintPickerConfig) {
            this.zzUK = (CredentialPickerConfig) zzx.zzy(hintPickerConfig);
            return this;
        }
    }

    HintRequest(int version, CredentialPickerConfig hintPickerConfig, boolean emailAddressIdentifierSupported, boolean phoneNumberIdentifierSupported, String[] accountTypes) {
        this.mVersionCode = version;
        this.zzUK = (CredentialPickerConfig) zzx.zzy(hintPickerConfig);
        this.zzUL = emailAddressIdentifierSupported;
        this.zzUM = phoneNumberIdentifierSupported;
        this.zzUH = (String[]) zzx.zzy(accountTypes);
    }

    private HintRequest(Builder builder) {
        this(1, builder.zzUK, builder.zzUL, builder.zzUM, builder.zzUH);
    }

    public int describeContents() {
        return 0;
    }

    public String[] getAccountTypes() {
        return this.zzUH;
    }

    public CredentialPickerConfig getHintPickerConfig() {
        return this.zzUK;
    }

    public boolean isEmailAddressIdentifierSupported() {
        return this.zzUL;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }

    public boolean zzmh() {
        return this.zzUM;
    }
}
