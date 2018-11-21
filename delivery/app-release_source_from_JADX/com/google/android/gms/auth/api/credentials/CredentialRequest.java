package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class CredentialRequest implements SafeParcelable {
    public static final Creator<CredentialRequest> CREATOR = new zzc();
    final int mVersionCode;
    private final boolean zzUG;
    private final String[] zzUH;
    private final CredentialPickerConfig zzUI;
    private final CredentialPickerConfig zzUJ;

    public static final class Builder {
        private boolean zzUG;
        private String[] zzUH;
        private CredentialPickerConfig zzUI;
        private CredentialPickerConfig zzUJ;

        public CredentialRequest build() {
            if (this.zzUH == null) {
                this.zzUH = new String[0];
            }
            if (this.zzUG || this.zzUH.length != 0) {
                return new CredentialRequest();
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

        public Builder setCredentialHintPickerConfig(CredentialPickerConfig config) {
            this.zzUJ = config;
            return this;
        }

        public Builder setCredentialPickerConfig(CredentialPickerConfig config) {
            this.zzUI = config;
            return this;
        }

        public Builder setPasswordLoginSupported(boolean passwordLoginSupported) {
            this.zzUG = passwordLoginSupported;
            return this;
        }

        @Deprecated
        public Builder setSupportsPasswordLogin(boolean supportsPasswordLogin) {
            return setPasswordLoginSupported(supportsPasswordLogin);
        }
    }

    CredentialRequest(int version, boolean passwordLoginSupported, String[] accountTypes, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialHintPickerConfig) {
        this.mVersionCode = version;
        this.zzUG = passwordLoginSupported;
        this.zzUH = (String[]) zzx.zzy(accountTypes);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzUI = credentialPickerConfig;
        if (credentialHintPickerConfig == null) {
            credentialHintPickerConfig = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzUJ = credentialHintPickerConfig;
    }

    private CredentialRequest(Builder builder) {
        this(2, builder.zzUG, builder.zzUH, builder.zzUI, builder.zzUJ);
    }

    public int describeContents() {
        return 0;
    }

    public String[] getAccountTypes() {
        return this.zzUH;
    }

    public CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zzUJ;
    }

    public CredentialPickerConfig getCredentialPickerConfig() {
        return this.zzUI;
    }

    @Deprecated
    public boolean getSupportsPasswordLogin() {
        return isPasswordLoginSupported();
    }

    public boolean isPasswordLoginSupported() {
        return this.zzUG;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}
