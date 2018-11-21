package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.auth.api.credentials.IdentityProviders;

public enum zze {
    GOOGLE("google.com", R.string.auth_google_play_services_client_google_display_name, IdentityProviders.GOOGLE),
    FACEBOOK("facebook.com", R.string.auth_google_play_services_client_facebook_display_name, IdentityProviders.FACEBOOK);
    
    private final String zzUB;
    private final String zzVL;
    private final int zzVM;

    private zze(String str, int i, String str2) {
        this.zzVL = str;
        this.zzVM = i;
        this.zzUB = str2;
    }

    public static zze zzbI(String str) {
        if (str != null) {
            for (zze com_google_android_gms_auth_api_signin_zze : values()) {
                if (com_google_android_gms_auth_api_signin_zze.zzmC().equals(str)) {
                    return com_google_android_gms_auth_api_signin_zze;
                }
            }
            Log.w("IdProvider", "Unrecognized providerId: " + str);
        }
        return null;
    }

    public String toString() {
        return this.zzVL;
    }

    public CharSequence zzad(Context context) {
        return context.getResources().getString(this.zzVM);
    }

    public String zzmC() {
        return this.zzVL;
    }
}
