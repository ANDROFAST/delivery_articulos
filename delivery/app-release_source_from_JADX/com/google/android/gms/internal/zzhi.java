package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Locale;

@zzha
public final class zzhi {
    public final int zzGA;
    public final int zzGB;
    public final float zzGC;
    public final int zzIA;
    public final boolean zzIB;
    public final boolean zzIC;
    public final String zzID;
    public final String zzIE;
    public final boolean zzIF;
    public final boolean zzIG;
    public final boolean zzIH;
    public final boolean zzII;
    public final String zzIJ;
    public final String zzIK;
    public final int zzIL;
    public final int zzIM;
    public final int zzIN;
    public final int zzIO;
    public final int zzIP;
    public final int zzIQ;
    public final double zzIR;
    public final boolean zzIS;
    public final boolean zzIT;
    public final int zzIU;
    public final String zzIV;

    public static final class zza {
        private int zzGA;
        private int zzGB;
        private float zzGC;
        private int zzIA;
        private boolean zzIB;
        private boolean zzIC;
        private String zzID;
        private String zzIE;
        private boolean zzIF;
        private boolean zzIG;
        private boolean zzIH;
        private boolean zzII;
        private String zzIJ;
        private String zzIK;
        private int zzIL;
        private int zzIM;
        private int zzIN;
        private int zzIO;
        private int zzIP;
        private int zzIQ;
        private double zzIR;
        private boolean zzIS;
        private boolean zzIT;
        private int zzIU;
        private String zzIV;

        public zza(Context context) {
            boolean z = true;
            PackageManager packageManager = context.getPackageManager();
            zzB(context);
            zza(context, packageManager);
            zzC(context);
            Locale locale = Locale.getDefault();
            this.zzIB = zza(packageManager, "geo:0,0?q=donuts") != null;
            if (zza(packageManager, "http://www.google.com") == null) {
                z = false;
            }
            this.zzIC = z;
            this.zzIE = locale.getCountry();
            this.zzIF = zzl.zzcN().zzhq();
            this.zzIG = GooglePlayServicesUtil.zzao(context);
            this.zzIJ = locale.getLanguage();
            this.zzIK = zza(packageManager);
            Resources resources = context.getResources();
            if (resources != null) {
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                if (displayMetrics != null) {
                    this.zzGC = displayMetrics.density;
                    this.zzGA = displayMetrics.widthPixels;
                    this.zzGB = displayMetrics.heightPixels;
                }
            }
        }

        public zza(Context context, zzhi com_google_android_gms_internal_zzhi) {
            PackageManager packageManager = context.getPackageManager();
            zzB(context);
            zza(context, packageManager);
            zzC(context);
            zzD(context);
            this.zzIB = com_google_android_gms_internal_zzhi.zzIB;
            this.zzIC = com_google_android_gms_internal_zzhi.zzIC;
            this.zzIE = com_google_android_gms_internal_zzhi.zzIE;
            this.zzIF = com_google_android_gms_internal_zzhi.zzIF;
            this.zzIG = com_google_android_gms_internal_zzhi.zzIG;
            this.zzIJ = com_google_android_gms_internal_zzhi.zzIJ;
            this.zzIK = com_google_android_gms_internal_zzhi.zzIK;
            this.zzGC = com_google_android_gms_internal_zzhi.zzGC;
            this.zzGA = com_google_android_gms_internal_zzhi.zzGA;
            this.zzGB = com_google_android_gms_internal_zzhi.zzGB;
        }

        private void zzB(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            this.zzIA = audioManager.getMode();
            this.zzIH = audioManager.isMusicActive();
            this.zzII = audioManager.isSpeakerphoneOn();
            this.zzIL = audioManager.getStreamVolume(3);
            this.zzIP = audioManager.getRingerMode();
            this.zzIQ = audioManager.getStreamVolume(2);
        }

        private void zzC(Context context) {
            boolean z = false;
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra("status", -1);
                this.zzIR = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
                if (intExtra == 2 || intExtra == 5) {
                    z = true;
                }
                this.zzIS = z;
                return;
            }
            this.zzIR = -1.0d;
            this.zzIS = false;
        }

        private void zzD(Context context) {
            this.zzIV = Build.FINGERPRINT;
        }

        private static ResolveInfo zza(PackageManager packageManager, String str) {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        }

        private static String zza(PackageManager packageManager) {
            String str = null;
            ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
            if (zza != null) {
                ActivityInfo activityInfo = zza.activityInfo;
                if (activityInfo != null) {
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
                        if (packageInfo != null) {
                            str = packageInfo.versionCode + "." + activityInfo.packageName;
                        }
                    } catch (NameNotFoundException e) {
                    }
                }
            }
            return str;
        }

        private void zza(Context context, PackageManager packageManager) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.zzID = telephonyManager.getNetworkOperator();
            this.zzIN = telephonyManager.getNetworkType();
            this.zzIO = telephonyManager.getPhoneType();
            this.zzIM = -2;
            this.zzIT = false;
            this.zzIU = -1;
            if (zzp.zzbx().zza(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    this.zzIM = activeNetworkInfo.getType();
                    this.zzIU = activeNetworkInfo.getDetailedState().ordinal();
                } else {
                    this.zzIM = -1;
                }
                if (VERSION.SDK_INT >= 16) {
                    this.zzIT = connectivityManager.isActiveNetworkMetered();
                }
            }
        }

        public zzhi zzgv() {
            return new zzhi(this.zzIA, this.zzIB, this.zzIC, this.zzID, this.zzIE, this.zzIF, this.zzIG, this.zzIH, this.zzII, this.zzIJ, this.zzIK, this.zzIL, this.zzIM, this.zzIN, this.zzIO, this.zzIP, this.zzIQ, this.zzGC, this.zzGA, this.zzGB, this.zzIR, this.zzIS, this.zzIT, this.zzIU, this.zzIV);
        }
    }

    zzhi(int i, boolean z, boolean z2, String str, String str2, boolean z3, boolean z4, boolean z5, boolean z6, String str3, String str4, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, double d, boolean z7, boolean z8, int i10, String str5) {
        this.zzIA = i;
        this.zzIB = z;
        this.zzIC = z2;
        this.zzID = str;
        this.zzIE = str2;
        this.zzIF = z3;
        this.zzIG = z4;
        this.zzIH = z5;
        this.zzII = z6;
        this.zzIJ = str3;
        this.zzIK = str4;
        this.zzIL = i2;
        this.zzIM = i3;
        this.zzIN = i4;
        this.zzIO = i5;
        this.zzIP = i6;
        this.zzIQ = i7;
        this.zzGC = f;
        this.zzGA = i8;
        this.zzGB = i9;
        this.zzIR = d;
        this.zzIS = z7;
        this.zzIT = z8;
        this.zzIU = i10;
        this.zzIV = str5;
    }
}
