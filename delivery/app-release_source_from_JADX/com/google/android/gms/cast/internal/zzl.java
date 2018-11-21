package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Locale;

public class zzl {
    private static boolean zzacw = false;
    protected final String mTag;
    private String zzacA;
    private final boolean zzacx;
    private boolean zzacy;
    private boolean zzacz;

    public zzl(String str) {
        this(str, zzof());
    }

    public zzl(String str, boolean z) {
        zzx.zzh(str, "The log tag cannot be null or empty.");
        this.mTag = str;
        this.zzacx = str.length() <= 23;
        this.zzacy = z;
        this.zzacz = false;
    }

    public static boolean zzof() {
        return zzacw;
    }

    public void zzY(boolean z) {
        this.zzacy = z;
    }

    public void zza(String str, Object... objArr) {
        if (zzoe()) {
            Log.v(this.mTag, zzg(str, objArr));
        }
    }

    public void zzb(String str, Object... objArr) {
        if (zzod() || zzacw) {
            Log.d(this.mTag, zzg(str, objArr));
        }
    }

    public void zzb(Throwable th, String str, Object... objArr) {
        if (zzod() || zzacw) {
            Log.d(this.mTag, zzg(str, objArr), th);
        }
    }

    public void zzc(String str, Object... objArr) {
        Log.e(this.mTag, zzg(str, objArr));
    }

    public void zzc(Throwable th, String str, Object... objArr) {
        Log.w(this.mTag, zzg(str, objArr), th);
    }

    public void zzch(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            str2 = String.format("[%s] ", new Object[]{str});
        }
        this.zzacA = str2;
    }

    public void zze(String str, Object... objArr) {
        Log.i(this.mTag, zzg(str, objArr));
    }

    public void zzf(String str, Object... objArr) {
        Log.w(this.mTag, zzg(str, objArr));
    }

    protected String zzg(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(Locale.ROOT, str, objArr);
        }
        return !TextUtils.isEmpty(this.zzacA) ? this.zzacA + str : str;
    }

    public boolean zzod() {
        return this.zzacy || (this.zzacx && Log.isLoggable(this.mTag, 3));
    }

    public boolean zzoe() {
        return this.zzacz;
    }
}
