package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONObject;

public class EmailSignInOptions implements SafeParcelable {
    public static final Creator<EmailSignInOptions> CREATOR = new zza();
    final int versionCode;
    private final Uri zzVo;
    private String zzVp;
    private Uri zzVq;

    EmailSignInOptions(int versionCode, Uri serverWidgetUrl, String modeQueryName, Uri tosUrl) {
        zzx.zzb((Object) serverWidgetUrl, (Object) "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzh(serverWidgetUrl.toString(), "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzb(Patterns.WEB_URL.matcher(serverWidgetUrl.toString()).matches(), (Object) "Invalid server widget url");
        this.versionCode = versionCode;
        this.zzVo = serverWidgetUrl;
        this.zzVp = modeQueryName;
        this.zzVq = tosUrl;
    }

    private JSONObject zzms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("serverWidgetUrl", this.zzVo.toString());
            if (!TextUtils.isEmpty(this.zzVp)) {
                jSONObject.put("modeQueryName", this.zzVp);
            }
            if (this.zzVq != null) {
                jSONObject.put("tosUrl", this.zzVq.toString());
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
            EmailSignInOptions emailSignInOptions = (EmailSignInOptions) obj;
            if (!this.zzVo.equals(emailSignInOptions.zzmo())) {
                return false;
            }
            if (this.zzVq == null) {
                if (emailSignInOptions.zzmp() != null) {
                    return false;
                }
            } else if (!this.zzVq.equals(emailSignInOptions.zzmp())) {
                return false;
            }
            if (TextUtils.isEmpty(this.zzVp)) {
                if (!TextUtils.isEmpty(emailSignInOptions.zzmq())) {
                    return false;
                }
            } else if (!this.zzVp.equals(emailSignInOptions.zzmq())) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return new zze().zzo(this.zzVo).zzo(this.zzVq).zzo(this.zzVp).zzmM();
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public Uri zzmo() {
        return this.zzVo;
    }

    public Uri zzmp() {
        return this.zzVq;
    }

    public String zzmq() {
        return this.zzVp;
    }

    public String zzmr() {
        return zzms().toString();
    }
}
