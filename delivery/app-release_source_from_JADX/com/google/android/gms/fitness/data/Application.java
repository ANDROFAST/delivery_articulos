package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class Application implements SafeParcelable {
    public static final Creator<Application> CREATOR = new zza();
    public static final Application zzatV = new Application("com.google.android.gms", String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), null);
    private final int mVersionCode;
    private final String zzSp;
    private final String zzabv;
    private final String zzatW;

    Application(int versionCode, String packageName, String version, String domainName) {
        this.mVersionCode = versionCode;
        this.zzSp = (String) zzx.zzy(packageName);
        this.zzabv = "";
        this.zzatW = domainName;
    }

    public Application(String packageName, String version, String domainName) {
        this(1, packageName, "", domainName);
    }

    private boolean zza(Application application) {
        return this.zzSp.equals(application.zzSp) && zzw.equal(this.zzabv, application.zzabv) && zzw.equal(this.zzatW, application.zzatW);
    }

    public static Application zzde(String str) {
        return zze(str, null, null);
    }

    public static Application zze(String str, String str2, String str3) {
        return "com.google.android.gms".equals(str) ? zzatV : new Application(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Application) && zza((Application) that));
    }

    public String getPackageName() {
        return this.zzSp;
    }

    public String getVersion() {
        return this.zzabv;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzSp, this.zzabv, this.zzatW);
    }

    public String toString() {
        return String.format("Application{%s:%s:%s}", new Object[]{this.zzSp, this.zzabv, this.zzatW});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }

    public String zzty() {
        return this.zzatW;
    }
}
