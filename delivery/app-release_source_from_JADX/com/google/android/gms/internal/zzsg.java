package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzsh.zzc;
import java.util.HashMap;
import java.util.Map;

public class zzsg {
    private final Context mContext;
    private String zzbdh;
    private final zzsi zzbgZ;
    Map<String, Object<zzc>> zzbha;
    private final Map<String, Object> zzbhb;
    private final zznl zzqD;

    public zzsg(Context context) {
        this(context, new HashMap(), new zzsi(context), zzno.zzrM());
    }

    zzsg(Context context, Map<String, Object> map, zzsi com_google_android_gms_internal_zzsi, zznl com_google_android_gms_internal_zznl) {
        this.zzbdh = null;
        this.zzbha = new HashMap();
        this.mContext = context;
        this.zzqD = com_google_android_gms_internal_zznl;
        this.zzbgZ = com_google_android_gms_internal_zzsi;
        this.zzbhb = map;
    }

    public void zzfN(String str) {
        this.zzbdh = str;
    }
}
