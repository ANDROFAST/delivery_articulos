package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;
import android.util.Log;

public class zzoo {
    private static int zzaxj = -1;

    public static boolean zzaC(Context context) {
        return zzaF(context) == 3;
    }

    private static int zzaD(Context context) {
        return ((zzaE(context) % 1000) / 100) + 5;
    }

    private static int zzaE(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("Fitness", "Could not find package info for Google Play Services");
            return -1;
        }
    }

    public static int zzaF(Context context) {
        if (zzaxj == -1) {
            switch (zzaD(context)) {
                case 8:
                case 13:
                    zzaxj = 0;
                    break;
                case 10:
                    zzaxj = 3;
                    break;
                default:
                    zzaxj = zzaG(context) ? 1 : 2;
                    break;
            }
        }
        return zzaxj;
    }

    private static boolean zzaG(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
        } catch (Throwable e) {
            Log.wtf("Fitness", "Unable to determine type of device, assuming phone.  Version: " + zzaE(context), e);
            return true;
        }
    }
}
