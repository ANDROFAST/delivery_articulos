package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

@zzha
public class zzed {
    private final Map<zzee, zzef> zzzS = new HashMap();
    private final LinkedList<zzee> zzzT = new LinkedList();
    private zzea zzzU;

    private static void zza(String str, zzee com_google_android_gms_internal_zzee) {
        if (zzb.zzQ(2)) {
            zzb.m7v(String.format(str, new Object[]{com_google_android_gms_internal_zzee}));
        }
    }

    private String[] zzad(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), "UTF-8");
            }
            return split;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    private String zzdY() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = this.zzzT.iterator();
            while (it.hasNext()) {
                stringBuilder.append(Base64.encodeToString(((zzee) it.next()).toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    stringBuilder.append("\u0000");
                }
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    void flush() {
        while (this.zzzT.size() > 0) {
            zzee com_google_android_gms_internal_zzee = (zzee) this.zzzT.remove();
            zzef com_google_android_gms_internal_zzef = (zzef) this.zzzS.get(com_google_android_gms_internal_zzee);
            zza("Flushing interstitial queue for %s.", com_google_android_gms_internal_zzee);
            while (com_google_android_gms_internal_zzef.size() > 0) {
                com_google_android_gms_internal_zzef.zzec().zzzX.zzbo();
            }
            this.zzzS.remove(com_google_android_gms_internal_zzee);
        }
    }

    void restore() {
        Throwable e;
        if (this.zzzU != null) {
            zzee com_google_android_gms_internal_zzee;
            SharedPreferences sharedPreferences = this.zzzU.zzdW().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
            flush();
            Map hashMap = new HashMap();
            for (Entry entry : sharedPreferences.getAll().entrySet()) {
                try {
                    if (!((String) entry.getKey()).equals("PoolKeys")) {
                        zzeh com_google_android_gms_internal_zzeh = new zzeh((String) entry.getValue());
                        com_google_android_gms_internal_zzee = new zzee(com_google_android_gms_internal_zzeh.zzqo, com_google_android_gms_internal_zzeh.zzpH);
                        if (!this.zzzS.containsKey(com_google_android_gms_internal_zzee)) {
                            this.zzzS.put(com_google_android_gms_internal_zzee, new zzef(com_google_android_gms_internal_zzeh.zzqo, com_google_android_gms_internal_zzeh.zzpH));
                            hashMap.put(com_google_android_gms_internal_zzee.toString(), com_google_android_gms_internal_zzee);
                            zza("Restored interstitial queue for %s.", com_google_android_gms_internal_zzee);
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    zzb.zzd("Malformed preferences value for InterstitialAdPool.", e);
                } catch (ClassCastException e3) {
                    e = e3;
                    zzb.zzd("Malformed preferences value for InterstitialAdPool.", e);
                }
            }
            for (Object obj : zzad(sharedPreferences.getString("PoolKeys", ""))) {
                com_google_android_gms_internal_zzee = (zzee) hashMap.get(obj);
                if (this.zzzS.containsKey(com_google_android_gms_internal_zzee)) {
                    this.zzzT.add(com_google_android_gms_internal_zzee);
                }
            }
        }
    }

    void save() {
        if (this.zzzU != null) {
            Editor edit = this.zzzU.zzdW().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
            edit.clear();
            for (Entry entry : this.zzzS.entrySet()) {
                zzee com_google_android_gms_internal_zzee = (zzee) entry.getKey();
                if (com_google_android_gms_internal_zzee.zzea()) {
                    zzef com_google_android_gms_internal_zzef = (zzef) entry.getValue();
                    edit.putString(com_google_android_gms_internal_zzee.toString(), new zzeh(com_google_android_gms_internal_zzef.zzeb(), com_google_android_gms_internal_zzef.getAdUnitId()).zzef());
                    zza("Saved interstitial queue for %s.", com_google_android_gms_internal_zzee);
                }
            }
            edit.putString("PoolKeys", zzdY());
            edit.commit();
        }
    }

    zza zza(AdRequestParcel adRequestParcel, String str) {
        zzef com_google_android_gms_internal_zzef;
        zzee com_google_android_gms_internal_zzee = new zzee(adRequestParcel, str);
        zzef com_google_android_gms_internal_zzef2 = (zzef) this.zzzS.get(com_google_android_gms_internal_zzee);
        if (com_google_android_gms_internal_zzef2 == null) {
            zza("Interstitial pool created at %s.", com_google_android_gms_internal_zzee);
            com_google_android_gms_internal_zzef2 = new zzef(adRequestParcel, str);
            this.zzzS.put(com_google_android_gms_internal_zzee, com_google_android_gms_internal_zzef2);
            com_google_android_gms_internal_zzef = com_google_android_gms_internal_zzef2;
        } else {
            com_google_android_gms_internal_zzef = com_google_android_gms_internal_zzef2;
        }
        this.zzzT.remove(com_google_android_gms_internal_zzee);
        this.zzzT.add(com_google_android_gms_internal_zzee);
        com_google_android_gms_internal_zzee.zzdZ();
        while (this.zzzT.size() > ((Integer) zzbz.zzwl.get()).intValue()) {
            zzee com_google_android_gms_internal_zzee2 = (zzee) this.zzzT.remove();
            zzef com_google_android_gms_internal_zzef3 = (zzef) this.zzzS.get(com_google_android_gms_internal_zzee2);
            zza("Evicting interstitial queue for %s.", com_google_android_gms_internal_zzee2);
            while (com_google_android_gms_internal_zzef3.size() > 0) {
                com_google_android_gms_internal_zzef3.zzec().zzzX.zzbo();
            }
            this.zzzS.remove(com_google_android_gms_internal_zzee2);
        }
        while (com_google_android_gms_internal_zzef.size() > 0) {
            zza zzec = com_google_android_gms_internal_zzef.zzec();
            if (!zzec.zzAa || zzp.zzbB().currentTimeMillis() - zzec.zzzZ <= 1000 * ((long) ((Integer) zzbz.zzwn.get()).intValue())) {
                zza("Pooled interstitial returned at %s.", com_google_android_gms_internal_zzee);
                return zzec;
            }
            zza("Expired interstitial at %s.", com_google_android_gms_internal_zzee);
        }
        return null;
    }

    void zza(zzea com_google_android_gms_internal_zzea) {
        if (this.zzzU == null) {
            this.zzzU = com_google_android_gms_internal_zzea;
            restore();
        }
    }

    void zzdX() {
        if (this.zzzU != null) {
            for (Entry entry : this.zzzS.entrySet()) {
                zzee com_google_android_gms_internal_zzee = (zzee) entry.getKey();
                zzef com_google_android_gms_internal_zzef = (zzef) entry.getValue();
                while (com_google_android_gms_internal_zzef.size() < ((Integer) zzbz.zzwm.get()).intValue()) {
                    zza("Pooling one interstitial for %s.", com_google_android_gms_internal_zzee);
                    com_google_android_gms_internal_zzef.zzb(this.zzzU);
                }
            }
            save();
        }
    }
}
