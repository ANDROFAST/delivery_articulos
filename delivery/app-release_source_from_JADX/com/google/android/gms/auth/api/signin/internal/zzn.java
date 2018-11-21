package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class zzn {
    private static final Lock zzWv = new ReentrantLock();
    private static zzn zzWw;
    private final Lock zzWx = new ReentrantLock();
    private final SharedPreferences zzWy;

    zzn(Context context) {
        this.zzWy = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static zzn zzae(Context context) {
        zzx.zzy(context);
        zzWv.lock();
        try {
            if (zzWw == null) {
                zzWw = new zzn(context.getApplicationContext());
            }
            zzn com_google_android_gms_auth_api_signin_internal_zzn = zzWw;
            return com_google_android_gms_auth_api_signin_internal_zzn;
        } finally {
            zzWv.unlock();
        }
    }

    private String zzt(String str, String str2) {
        return str + ":" + str2;
    }

    void zza(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzx.zzy(googleSignInAccount);
        zzx.zzy(googleSignInOptions);
        String zzmw = googleSignInAccount.zzmw();
        zzs(zzt("googleSignInAccount", zzmw), googleSignInAccount.zzmx());
        zzs(zzt("googleSignInOptions", zzmw), googleSignInOptions.zzmr());
    }

    void zza(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        zzx.zzy(signInAccount);
        zzx.zzy(signInConfiguration);
        String userId = signInAccount.getUserId();
        SignInAccount zzbK = zzbK(userId);
        if (!(zzbK == null || zzbK.zzmD() == null)) {
            zzbP(zzbK.zzmD().zzmw());
        }
        zzs(zzt("signInConfiguration", userId), signInConfiguration.zzmr());
        zzs(zzt("signInAccount", userId), signInAccount.zzmr());
        if (signInAccount.zzmD() != null) {
            zza(signInAccount.zzmD(), signInConfiguration.zzmR());
        }
    }

    public void zzb(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzx.zzy(googleSignInAccount);
        zzx.zzy(googleSignInOptions);
        zzs("defaultGoogleSignInAccount", googleSignInAccount.zzmw());
        zza(googleSignInAccount, googleSignInOptions);
    }

    public void zzb(SignInAccount signInAccount, SignInConfiguration signInConfiguration) {
        zzx.zzy(signInAccount);
        zzx.zzy(signInConfiguration);
        zzmY();
        zzs("defaultSignInAccount", signInAccount.getUserId());
        if (signInAccount.zzmD() != null) {
            zzs("defaultGoogleSignInAccount", signInAccount.zzmD().zzmw());
        }
        zza(signInAccount, signInConfiguration);
    }

    SignInAccount zzbK(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object zzbN = zzbN(zzt("signInAccount", str));
        if (TextUtils.isEmpty(zzbN)) {
            return null;
        }
        try {
            SignInAccount zzbJ = SignInAccount.zzbJ(zzbN);
            if (zzbJ.zzmD() != null) {
                GoogleSignInAccount zzbL = zzbL(zzbJ.zzmD().zzmw());
                if (zzbL != null) {
                    zzbJ.zza(zzbL);
                }
            }
            return zzbJ;
        } catch (JSONException e) {
            return null;
        }
    }

    GoogleSignInAccount zzbL(String str) {
        GoogleSignInAccount googleSignInAccount = null;
        if (!TextUtils.isEmpty(str)) {
            String zzbN = zzbN(zzt("googleSignInAccount", str));
            if (zzbN != null) {
                try {
                    googleSignInAccount = GoogleSignInAccount.zzbE(zzbN);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInAccount;
    }

    GoogleSignInOptions zzbM(String str) {
        GoogleSignInOptions googleSignInOptions = null;
        if (!TextUtils.isEmpty(str)) {
            String zzbN = zzbN(zzt("googleSignInOptions", str));
            if (zzbN != null) {
                try {
                    googleSignInOptions = GoogleSignInOptions.zzbG(zzbN);
                } catch (JSONException e) {
                }
            }
        }
        return googleSignInOptions;
    }

    protected String zzbN(String str) {
        this.zzWx.lock();
        try {
            String string = this.zzWy.getString(str, null);
            return string;
        } finally {
            this.zzWx.unlock();
        }
    }

    void zzbO(String str) {
        if (!TextUtils.isEmpty(str)) {
            SignInAccount zzbK = zzbK(str);
            zzbQ(zzt("signInAccount", str));
            zzbQ(zzt("signInConfiguration", str));
            if (zzbK != null && zzbK.zzmD() != null) {
                zzbP(zzbK.zzmD().zzmw());
            }
        }
    }

    void zzbP(String str) {
        if (!TextUtils.isEmpty(str)) {
            zzbQ(zzt("googleSignInAccount", str));
            zzbQ(zzt("googleSignInOptions", str));
        }
    }

    protected void zzbQ(String str) {
        this.zzWx.lock();
        try {
            this.zzWy.edit().remove(str).apply();
        } finally {
            this.zzWx.unlock();
        }
    }

    public GoogleSignInAccount zzmW() {
        return zzbL(zzbN("defaultGoogleSignInAccount"));
    }

    public GoogleSignInOptions zzmX() {
        return zzbM(zzbN("defaultGoogleSignInAccount"));
    }

    public void zzmY() {
        String zzbN = zzbN("defaultSignInAccount");
        zzbQ("defaultSignInAccount");
        zzmZ();
        zzbO(zzbN);
    }

    public void zzmZ() {
        String zzbN = zzbN("defaultGoogleSignInAccount");
        zzbQ("defaultGoogleSignInAccount");
        zzbP(zzbN);
    }

    protected void zzs(String str, String str2) {
        this.zzWx.lock();
        try {
            this.zzWy.edit().putString(str, str2).apply();
        } finally {
            this.zzWx.unlock();
        }
    }
}
