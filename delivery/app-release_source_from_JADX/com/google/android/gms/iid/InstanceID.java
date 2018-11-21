package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.MotionEventCompat;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class InstanceID {
    public static final String ERROR_BACKOFF = "RETRY_LATER";
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String ERROR_TIMEOUT = "TIMEOUT";
    static Map<String, InstanceID> zzaKc = new HashMap();
    private static zzd zzaKd;
    private static zzc zzaKe;
    static String zzaKi;
    Context mContext;
    KeyPair zzaKf;
    String zzaKg = "";
    long zzaKh;

    protected InstanceID(Context context, String subtype, Bundle options) {
        this.mContext = context.getApplicationContext();
        this.zzaKg = subtype;
    }

    public static InstanceID getInstance(Context context) {
        return zza(context, null);
    }

    public static synchronized InstanceID zza(Context context, Bundle bundle) {
        InstanceID instanceID;
        synchronized (InstanceID.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (zzaKd == null) {
                zzaKd = new zzd(applicationContext);
                zzaKe = new zzc(applicationContext);
            }
            zzaKi = Integer.toString(zzaK(applicationContext));
            instanceID = (InstanceID) zzaKc.get(str);
            if (instanceID == null) {
                instanceID = new InstanceID(applicationContext, str, bundle);
                zzaKc.put(str, instanceID);
            }
        }
        return instanceID;
    }

    static String zza(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & MotionEventCompat.ACTION_MASK);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static int zzaK(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("InstanceID", "Never happens: can't find own package " + e);
            return i;
        }
    }

    static String zzn(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public void deleteInstanceID() throws IOException {
        zzb("*", "*", null);
        zzxO();
    }

    public void deleteToken(String authorizedEntity, String scope) throws IOException {
        zzb(authorizedEntity, scope, null);
    }

    public long getCreationTime() {
        if (this.zzaKh == 0) {
            String str = zzaKd.get(this.zzaKg, "cre");
            if (str != null) {
                this.zzaKh = Long.parseLong(str);
            }
        }
        return this.zzaKh;
    }

    public String getId() {
        return zza(zzxN());
    }

    public String getToken(String authorizedEntity, String scope) throws IOException {
        return getToken(authorizedEntity, scope, null);
    }

    public String getToken(String authorizedEntity, String scope, Bundle extras) throws IOException {
        Object obj = null;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        Object obj2 = 1;
        String zzg = zzxR() ? null : zzaKd.zzg(this.zzaKg, authorizedEntity, scope);
        if (zzg == null) {
            if (extras == null) {
                extras = new Bundle();
            }
            if (extras.getString("ttl") != null) {
                obj2 = null;
            }
            if (!"jwt".equals(extras.getString("type"))) {
                obj = obj2;
            }
            zzg = zzc(authorizedEntity, scope, extras);
            Log.w("InstanceID", "token: " + zzg);
            if (!(zzg == null || r1 == null)) {
                zzaKd.zza(this.zzaKg, authorizedEntity, scope, zzg, zzaKi);
            }
        }
        return zzg;
    }

    public void zzb(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        zzaKd.zzh(this.zzaKg, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", "".equals(this.zzaKg) ? str : this.zzaKg);
        String str3 = "X-subtype";
        if (!"".equals(this.zzaKg)) {
            str = this.zzaKg;
        }
        bundle.putString(str3, str);
        zzaKe.zzv(zzaKe.zza(bundle, zzxN()));
    }

    public String zzc(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.zzaKg) ? str : this.zzaKg;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return zzaKe.zzv(zzaKe.zza(bundle, zzxN()));
    }

    KeyPair zzxN() {
        if (this.zzaKf == null) {
            this.zzaKf = zzaKd.zzdN(this.zzaKg);
        }
        if (this.zzaKf == null) {
            this.zzaKh = System.currentTimeMillis();
            this.zzaKf = zzaKd.zzd(this.zzaKg, this.zzaKh);
        }
        return this.zzaKf;
    }

    void zzxO() {
        this.zzaKh = 0;
        zzaKd.zzdO(this.zzaKg);
        this.zzaKf = null;
    }

    zzd zzxP() {
        return zzaKd;
    }

    zzc zzxQ() {
        return zzaKe;
    }

    boolean zzxR() {
        String str = zzaKd.get("appVersion");
        if (str == null || !str.equals(zzaKi)) {
            return true;
        }
        str = zzaKd.get("lastToken");
        if (str == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str)).longValue() > 604800;
    }
}
