package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzha
public class zzih {
    final String zzJX;
    long zzKl = -1;
    long zzKm = -1;
    int zzKn = -1;
    int zzKo = 0;
    int zzKp = 0;
    private final Object zzpK = new Object();

    public zzih(String str) {
        this.zzJX = str;
    }

    public static boolean zzH(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            zzb.zzaG("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzb.zzaG("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (NameNotFoundException e) {
            zzb.zzaH("Fail to fetch AdActivity theme");
            zzb.zzaG("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public void zzb(AdRequestParcel adRequestParcel, long j) {
        synchronized (this.zzpK) {
            if (this.zzKm == -1) {
                this.zzKm = j;
                this.zzKl = this.zzKm;
            } else {
                this.zzKl = j;
            }
            if (adRequestParcel.extras == null || adRequestParcel.extras.getInt("gw", 2) != 1) {
                this.zzKn++;
                return;
            }
        }
    }

    public Bundle zzc(Context context, String str) {
        Bundle bundle;
        synchronized (this.zzpK) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzJX);
            bundle.putLong("basets", this.zzKm);
            bundle.putLong("currts", this.zzKl);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzKn);
            bundle.putInt("pclick", this.zzKo);
            bundle.putInt("pimp", this.zzKp);
            bundle.putBoolean("support_transparent_background", zzH(context));
        }
        return bundle;
    }

    public void zzgD() {
        synchronized (this.zzpK) {
            this.zzKp++;
        }
    }

    public void zzgE() {
        synchronized (this.zzpK) {
            this.zzKo++;
        }
    }

    public long zzgV() {
        return this.zzKm;
    }
}
