package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzf extends zzak {
    private static final String ID = zzad.APP_ID.toString();
    private final Context mContext;

    public zzf(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean zzEa() {
        return true;
    }

    public zza zzI(Map<String, zza> map) {
        return zzdf.zzR(this.mContext.getPackageName());
    }
}
