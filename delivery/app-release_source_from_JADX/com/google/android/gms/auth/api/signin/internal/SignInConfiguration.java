package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.FacebookSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONObject;

public final class SignInConfiguration implements SafeParcelable {
    public static final Creator<SignInConfiguration> CREATOR = new zzm();
    final int versionCode;
    private String zzVG;
    private final String zzWh;
    private EmailSignInOptions zzWi;
    private GoogleSignInOptions zzWj;
    private FacebookSignInOptions zzWk;
    private String zzWl;

    SignInConfiguration(int versionCode, String consumerPkgName, String serverClientId, EmailSignInOptions emailConfig, GoogleSignInOptions googleConfig, FacebookSignInOptions facebookConfig, String apiKey) {
        this.versionCode = versionCode;
        this.zzWh = zzx.zzcG(consumerPkgName);
        this.zzVG = serverClientId;
        this.zzWi = emailConfig;
        this.zzWj = googleConfig;
        this.zzWk = facebookConfig;
        this.zzWl = apiKey;
    }

    public SignInConfiguration(String consumerPkgName) {
        this(2, consumerPkgName, null, null, null, null, null);
    }

    private JSONObject zzms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consumerPackageName", this.zzWh);
            if (!TextUtils.isEmpty(this.zzVG)) {
                jSONObject.put("serverClientId", this.zzVG);
            }
            if (this.zzWi != null) {
                jSONObject.put("emailSignInOptions", this.zzWi.zzmr());
            }
            if (this.zzWj != null) {
                jSONObject.put("googleSignInOptions", this.zzWj.zzmr());
            }
            if (this.zzWk != null) {
                jSONObject.put("facebookSignInOptions", this.zzWk.zzmr());
            }
            if (!TextUtils.isEmpty(this.zzWl)) {
                jSONObject.put("apiKey", this.zzWl);
            }
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (!this.zzWh.equals(signInConfiguration.zzmP())) {
                return false;
            }
            if (TextUtils.isEmpty(this.zzVG)) {
                if (!TextUtils.isEmpty(signInConfiguration.zzmB())) {
                    return false;
                }
            } else if (!this.zzVG.equals(signInConfiguration.zzmB())) {
                return false;
            }
            if (TextUtils.isEmpty(this.zzWl)) {
                if (!TextUtils.isEmpty(signInConfiguration.zzmT())) {
                    return false;
                }
            } else if (!this.zzWl.equals(signInConfiguration.zzmT())) {
                return false;
            }
            if (this.zzWi == null) {
                if (signInConfiguration.zzmQ() != null) {
                    return false;
                }
            } else if (!this.zzWi.equals(signInConfiguration.zzmQ())) {
                return false;
            }
            if (this.zzWk == null) {
                if (signInConfiguration.zzmS() != null) {
                    return false;
                }
            } else if (!this.zzWk.equals(signInConfiguration.zzmS())) {
                return false;
            }
            if (this.zzWj == null) {
                if (signInConfiguration.zzmR() != null) {
                    return false;
                }
            } else if (!this.zzWj.equals(signInConfiguration.zzmR())) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return new zze().zzo(this.zzWh).zzo(this.zzVG).zzo(this.zzWl).zzo(this.zzWi).zzo(this.zzWj).zzo(this.zzWk).zzmM();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzm.zza(this, out, flags);
    }

    public SignInConfiguration zzi(GoogleSignInOptions googleSignInOptions) {
        this.zzWj = (GoogleSignInOptions) zzx.zzb((Object) googleSignInOptions, (Object) "GoogleSignInOptions cannot be null.");
        return this;
    }

    public String zzmB() {
        return this.zzVG;
    }

    public String zzmP() {
        return this.zzWh;
    }

    public EmailSignInOptions zzmQ() {
        return this.zzWi;
    }

    public GoogleSignInOptions zzmR() {
        return this.zzWj;
    }

    public FacebookSignInOptions zzmS() {
        return this.zzWk;
    }

    public String zzmT() {
        return this.zzWl;
    }

    public String zzmr() {
        return zzms().toString();
    }
}
