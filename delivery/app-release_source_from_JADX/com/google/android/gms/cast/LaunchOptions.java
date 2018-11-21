package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public class LaunchOptions implements SafeParcelable {
    public static final Creator<LaunchOptions> CREATOR = new zzd();
    private final int mVersionCode;
    private boolean zzZd;
    private String zzZe;

    public static final class Builder {
        private LaunchOptions zzZf = new LaunchOptions();

        public LaunchOptions build() {
            return this.zzZf;
        }

        public Builder setLocale(Locale locale) {
            this.zzZf.setLanguage(zzf.zzb(locale));
            return this;
        }

        public Builder setRelaunchIfRunning(boolean relaunchIfRunning) {
            this.zzZf.setRelaunchIfRunning(relaunchIfRunning);
            return this;
        }
    }

    public LaunchOptions() {
        this(1, false, zzf.zzb(Locale.getDefault()));
    }

    LaunchOptions(int versionCode, boolean relaunchIfRunning, String language) {
        this.mVersionCode = versionCode;
        this.zzZd = relaunchIfRunning;
        this.zzZe = language;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.zzZd == launchOptions.zzZd && zzf.zza(this.zzZe, launchOptions.zzZe);
    }

    public String getLanguage() {
        return this.zzZe;
    }

    public boolean getRelaunchIfRunning() {
        return this.zzZd;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Boolean.valueOf(this.zzZd), this.zzZe);
    }

    public void setLanguage(String language) {
        this.zzZe = language;
    }

    public void setRelaunchIfRunning(boolean relaunchIfRunning) {
        this.zzZd = relaunchIfRunning;
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[]{Boolean.valueOf(this.zzZd), this.zzZe});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }
}
