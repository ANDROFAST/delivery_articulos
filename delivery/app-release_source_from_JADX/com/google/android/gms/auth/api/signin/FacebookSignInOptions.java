package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class FacebookSignInOptions implements SafeParcelable {
    public static final Creator<FacebookSignInOptions> CREATOR = new zzb();
    private Intent mIntent;
    final int versionCode;
    private final ArrayList<String> zzVr;

    public FacebookSignInOptions() {
        this(1, null, new ArrayList());
    }

    FacebookSignInOptions(int versionCode, Intent intent, ArrayList<String> scopes) {
        this.versionCode = versionCode;
        this.mIntent = intent;
        this.zzVr = scopes;
    }

    private JSONObject zzms() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.zzVr.iterator();
            while (it.hasNext()) {
                jSONArray.put((String) it.next());
            }
            jSONObject.put("scopes", jSONArray);
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
            FacebookSignInOptions facebookSignInOptions = (FacebookSignInOptions) obj;
            return this.zzVr.size() == facebookSignInOptions.zzmu().size() && this.zzVr.containsAll(facebookSignInOptions.zzmu());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        Collections.sort(this.zzVr);
        return this.zzVr.hashCode();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public String zzmr() {
        return zzms().toString();
    }

    public Intent zzmt() {
        return this.mIntent;
    }

    public ArrayList<String> zzmu() {
        return new ArrayList(this.zzVr);
    }
}
