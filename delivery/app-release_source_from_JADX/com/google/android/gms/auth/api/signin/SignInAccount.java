package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public class SignInAccount implements SafeParcelable {
    public static final Creator<SignInAccount> CREATOR = new zzf();
    final int versionCode;
    private String zzJg;
    private String zzUN;
    private String zzVL;
    private GoogleSignInAccount zzVO;
    private String zzVP;
    private String zzVt;
    private String zzVu;
    private Uri zzVv;

    SignInAccount(int versionCode, String providerId, String idToken, String email, String displayName, Uri photoUrl, GoogleSignInAccount googleSignInAccount, String userId, String refreshToken) {
        this.versionCode = versionCode;
        this.zzVt = zzx.zzh(email, "Email cannot be empty.");
        this.zzVu = displayName;
        this.zzVv = photoUrl;
        this.zzVL = providerId;
        this.zzUN = idToken;
        this.zzVO = googleSignInAccount;
        this.zzJg = zzx.zzcG(userId);
        this.zzVP = refreshToken;
    }

    public static SignInAccount zza(zze com_google_android_gms_auth_api_signin_zze, String str, String str2, String str3, Uri uri, String str4, String str5) {
        String str6 = null;
        if (com_google_android_gms_auth_api_signin_zze != null) {
            str6 = com_google_android_gms_auth_api_signin_zze.zzmC();
        }
        return new SignInAccount(2, str6, str, str2, str3, uri, null, str4, str5);
    }

    public static SignInAccount zzbJ(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        return zza(zze.zzbI(jSONObject.optString("providerId", null)), jSONObject.optString("tokenId", null), jSONObject.getString("email"), jSONObject.optString("displayName", null), !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null, jSONObject.getString("localId"), jSONObject.optString("refreshToken")).zza(GoogleSignInAccount.zzbE(jSONObject.optString("googleSignInAccount")));
    }

    private JSONObject zzms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("email", getEmail());
            if (!TextUtils.isEmpty(this.zzVu)) {
                jSONObject.put("displayName", this.zzVu);
            }
            if (this.zzVv != null) {
                jSONObject.put("photoUrl", this.zzVv.toString());
            }
            if (!TextUtils.isEmpty(this.zzVL)) {
                jSONObject.put("providerId", this.zzVL);
            }
            if (!TextUtils.isEmpty(this.zzUN)) {
                jSONObject.put("tokenId", this.zzUN);
            }
            if (this.zzVO != null) {
                jSONObject.put("googleSignInAccount", this.zzVO.zzmr());
            }
            if (!TextUtils.isEmpty(this.zzVP)) {
                jSONObject.put("refreshToken", this.zzVP);
            }
            jSONObject.put("localId", getUserId());
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getDisplayName() {
        return this.zzVu;
    }

    public String getEmail() {
        return this.zzVt;
    }

    public String getIdToken() {
        return this.zzUN;
    }

    public Uri getPhotoUrl() {
        return this.zzVv;
    }

    public String getUserId() {
        return this.zzJg;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf.zza(this, out, flags);
    }

    public SignInAccount zza(GoogleSignInAccount googleSignInAccount) {
        this.zzVO = googleSignInAccount;
        return this;
    }

    String zzmC() {
        return this.zzVL;
    }

    public GoogleSignInAccount zzmD() {
        return this.zzVO;
    }

    public String zzmE() {
        return this.zzVP;
    }

    public String zzmr() {
        return zzms().toString();
    }
}
