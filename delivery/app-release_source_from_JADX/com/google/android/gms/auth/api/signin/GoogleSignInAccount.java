package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzno;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount implements SafeParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new zzc();
    public static zznl zzVs = zzno.zzrM();
    private static Comparator<Scope> zzVz = new C02051();
    final int versionCode;
    List<Scope> zzTV;
    private String zzUN;
    private String zzVt;
    private String zzVu;
    private Uri zzVv;
    private String zzVw;
    private long zzVx;
    private String zzVy;
    private String zzxX;

    static class C02051 implements Comparator<Scope> {
        C02051() {
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return zza((Scope) x0, (Scope) x1);
        }

        public int zza(Scope scope, Scope scope2) {
            return scope.zzoM().compareTo(scope2.zzoM());
        }
    }

    GoogleSignInAccount(int versionCode, String id, String idToken, String email, String displayName, Uri photoUrl, String serverAuthCode, long expirationTimeSecs, String obfuscatedIdentifier, List<Scope> grantedScopes) {
        this.versionCode = versionCode;
        this.zzxX = id;
        this.zzUN = idToken;
        this.zzVt = email;
        this.zzVu = displayName;
        this.zzVv = photoUrl;
        this.zzVw = serverAuthCode;
        this.zzVx = expirationTimeSecs;
        this.zzVy = obfuscatedIdentifier;
        this.zzTV = grantedScopes;
    }

    public static GoogleSignInAccount zza(String str, String str2, String str3, String str4, Uri uri, Long l, String str5, Set<Scope> set) {
        if (l == null) {
            l = Long.valueOf(zzVs.currentTimeMillis() / 1000);
        }
        return new GoogleSignInAccount(2, str, str2, str3, str4, uri, null, l.longValue(), zzx.zzcG(str5), new ArrayList((Collection) zzx.zzy(set)));
    }

    public static GoogleSignInAccount zzbE(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return zza(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).zzbF(jSONObject.optString("serverAuthCode", null));
    }

    private JSONObject zzms() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put("email", getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.zzVx);
            jSONObject.put("obfuscatedIdentifier", zzmw());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zzTV, zzVz);
            for (Scope zzoM : this.zzTV) {
                jSONArray.put(zzoM.zzoM());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof GoogleSignInAccount) ? false : ((GoogleSignInAccount) obj).zzmr().equals(zzmr());
    }

    public String getDisplayName() {
        return this.zzVu;
    }

    public String getEmail() {
        return this.zzVt;
    }

    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.zzTV);
    }

    public String getId() {
        return this.zzxX;
    }

    public String getIdToken() {
        return this.zzUN;
    }

    public Uri getPhotoUrl() {
        return this.zzVv;
    }

    public String getServerAuthCode() {
        return this.zzVw;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }

    public boolean zzb() {
        return zzVs.currentTimeMillis() / 1000 >= this.zzVx - 300;
    }

    public GoogleSignInAccount zzbF(String str) {
        this.zzVw = str;
        return this;
    }

    public String zzmr() {
        return zzms().toString();
    }

    public long zzmv() {
        return this.zzVx;
    }

    public String zzmw() {
        return this.zzVy;
    }

    public String zzmx() {
        JSONObject zzms = zzms();
        zzms.remove("serverAuthCode");
        return zzms.toString();
    }
}
