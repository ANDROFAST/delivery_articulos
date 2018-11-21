package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzi extends zzak {
    private static final String ID = zzad.APP_VERSION_NAME.toString();
    private final Context mContext;

    public zzi(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean zzEa() {
        return true;
    }

    public zza zzI(Map<String, zza> map) {
        try {
            return zzdf.zzR(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName);
        } catch (NameNotFoundException e) {
            zzbg.m9e("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return zzdf.zzFJ();
        }
    }
}
