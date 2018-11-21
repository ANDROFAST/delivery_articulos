package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class zzd {
    Context context;
    SharedPreferences zzaKG;

    public zzd(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    public zzd(Context context, String str) {
        this.context = context;
        this.zzaKG = context.getSharedPreferences(str, 4);
        zzdL(str + "-no-backup");
    }

    private void zzdL(String str) {
        File file = new File(new ContextCompat().getNoBackupFilesDir(this.context), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    InstanceIDListenerService.zza(this.context, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    Log.d("InstanceID/Store", "Error creating file in no backup dir: " + e.getMessage());
                }
            }
        }
    }

    private String zzf(String str, String str2, String str3) {
        return str + "|T|" + str2 + "|" + str3;
    }

    synchronized String get(String key) {
        return this.zzaKG.getString(key, null);
    }

    synchronized String get(String subtype, String key) {
        return this.zzaKG.getString(subtype + "|S|" + key, null);
    }

    boolean isEmpty() {
        return this.zzaKG.getAll().isEmpty();
    }

    synchronized void zza(Editor editor, String str, String str2, String str3) {
        editor.putString(str + "|S|" + str2, str3);
    }

    public synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String zzf = zzf(str, str2, str3);
        Editor edit = this.zzaKG.edit();
        edit.putString(zzf, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
    }

    synchronized KeyPair zzd(String str, long j) {
        KeyPair zzxM;
        zzxM = zza.zzxM();
        Editor edit = this.zzaKG.edit();
        zza(edit, str, "|P|", InstanceID.zzn(zzxM.getPublic().getEncoded()));
        zza(edit, str, "|K|", InstanceID.zzn(zzxM.getPrivate().getEncoded()));
        zza(edit, str, "cre", Long.toString(j));
        edit.commit();
        return zzxM;
    }

    public synchronized void zzdM(String str) {
        Editor edit = this.zzaKG.edit();
        for (String str2 : this.zzaKG.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public KeyPair zzdN(String str) {
        return zzdQ(str);
    }

    void zzdO(String str) {
        zzdM(str + "|");
    }

    public void zzdP(String str) {
        zzdM(str + "|T|");
    }

    KeyPair zzdQ(String str) {
        Object e;
        String str2 = get(str, "|P|");
        String str3 = get(str, "|K|");
        if (str3 == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str2, 8);
            byte[] decode2 = Base64.decode(str3, 8);
            KeyFactory instance = KeyFactory.getInstance("RSA");
            return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
        } catch (InvalidKeySpecException e2) {
            e = e2;
            Log.w("InstanceID/Store", "Invalid key stored " + e);
            InstanceIDListenerService.zza(this.context, this);
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            Log.w("InstanceID/Store", "Invalid key stored " + e);
            InstanceIDListenerService.zza(this.context, this);
            return null;
        }
    }

    public synchronized String zzg(String str, String str2, String str3) {
        return this.zzaKG.getString(zzf(str, str2, str3), null);
    }

    public synchronized void zzh(String str, String str2, String str3) {
        String zzf = zzf(str, str2, str3);
        Editor edit = this.zzaKG.edit();
        edit.remove(zzf);
        edit.commit();
    }

    public synchronized void zzxU() {
        this.zzaKG.edit().clear().commit();
    }
}
