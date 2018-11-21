package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import com.google.android.gms.common.internal.zzx;

@zzha
public class zzbr {
    private final Context mContext;

    public zzbr(Context context) {
        zzx.zzb((Object) context, (Object) "Context can not be null");
        this.mContext = context;
    }

    public static boolean zzdh() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public boolean zza(Intent intent) {
        zzx.zzb((Object) intent, (Object) "Intent can not be null");
        return !this.mContext.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public boolean zzdd() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return zza(intent);
    }

    public boolean zzde() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return zza(intent);
    }

    public boolean zzdf() {
        return zzdh() && this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public boolean zzdg() {
        return true;
    }

    public boolean zzdi() {
        return VERSION.SDK_INT >= 14 && zza(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
