package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions implements SafeParcelable {
    public static final Creator<WalletFragmentOptions> CREATOR = new zzb();
    private int mTheme;
    final int mVersionCode;
    private int zzamE;
    private int zzbkD;
    private WalletFragmentStyle zzblj;

    public final class Builder {
        final /* synthetic */ WalletFragmentOptions zzblk;

        private Builder(WalletFragmentOptions walletFragmentOptions) {
            this.zzblk = walletFragmentOptions;
        }

        public WalletFragmentOptions build() {
            return this.zzblk;
        }

        public Builder setEnvironment(int environment) {
            this.zzblk.zzbkD = environment;
            return this;
        }

        public Builder setFragmentStyle(int styleResourceId) {
            this.zzblk.zzblj = new WalletFragmentStyle().setStyleResourceId(styleResourceId);
            return this;
        }

        public Builder setFragmentStyle(WalletFragmentStyle fragmentStyle) {
            this.zzblk.zzblj = fragmentStyle;
            return this;
        }

        public Builder setMode(int mode) {
            this.zzblk.zzamE = mode;
            return this;
        }

        public Builder setTheme(int theme) {
            this.zzblk.mTheme = theme;
            return this;
        }
    }

    private WalletFragmentOptions() {
        this.mVersionCode = 1;
        this.zzbkD = 3;
        this.zzblj = new WalletFragmentStyle();
    }

    WalletFragmentOptions(int versionCode, int environment, int theme, WalletFragmentStyle fragmentStyle, int mode) {
        this.mVersionCode = versionCode;
        this.zzbkD = environment;
        this.mTheme = theme;
        this.zzblj = fragmentStyle;
        this.zzamE = mode;
    }

    public static Builder newBuilder() {
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.getClass();
        return new Builder();
    }

    public static WalletFragmentOptions zzb(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WalletFragmentOptions);
        int i = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_appTheme, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_environment, 1);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int i3 = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_fragmentMode, 1);
        obtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.mTheme = i;
        walletFragmentOptions.zzbkD = i2;
        walletFragmentOptions.zzblj = new WalletFragmentStyle().setStyleResourceId(resourceId);
        walletFragmentOptions.zzblj.zzbc(context);
        walletFragmentOptions.zzamE = i3;
        return walletFragmentOptions;
    }

    public int describeContents() {
        return 0;
    }

    public int getEnvironment() {
        return this.zzbkD;
    }

    public WalletFragmentStyle getFragmentStyle() {
        return this.zzblj;
    }

    public int getMode() {
        return this.zzamE;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public void zzbc(Context context) {
        if (this.zzblj != null) {
            this.zzblj.zzbc(context);
        }
    }
}
