package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzg extends zzak {
    private static final String ID = zzad.APP_NAME.toString();
    private final Context mContext;

    public zzg(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean zzEa() {
        return true;
    }

    public zza zzI(Map<String, zza> map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return zzdf.zzR(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (Throwable e) {
            zzbg.zzb("App name is not found.", e);
            return zzdf.zzFJ();
        }
    }
}
