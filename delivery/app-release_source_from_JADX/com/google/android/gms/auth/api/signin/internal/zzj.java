package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzlf;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzj {
    private final Map<zze, zzld> zzWf;

    public zzj(Activity activity, List<zze> list, Map<zze, List<String>> map) {
        zzx.zzy(activity);
        zzx.zzy(list);
        zzx.zzy(map);
        Map hashMap = new HashMap();
        for (zze com_google_android_gms_auth_api_signin_zze : list) {
            List list2 = (List) map.get(com_google_android_gms_auth_api_signin_zze);
            if (list2 == null) {
                list2 = Collections.emptyList();
            }
            zzld zza = zza(com_google_android_gms_auth_api_signin_zze, activity, list2);
            if (zza != null) {
                hashMap.put(com_google_android_gms_auth_api_signin_zze, zza);
            }
        }
        this.zzWf = Collections.unmodifiableMap(hashMap);
    }

    private zzld zza(zze com_google_android_gms_auth_api_signin_zze, Activity activity, List<String> list) {
        return zze.FACEBOOK.equals(com_google_android_gms_auth_api_signin_zze) ? new zzlf(activity, list) : null;
    }

    public zzld zza(zze com_google_android_gms_auth_api_signin_zze) {
        zzx.zzy(com_google_android_gms_auth_api_signin_zze);
        return (zzld) this.zzWf.get(com_google_android_gms_auth_api_signin_zze);
    }

    public Collection<zzld> zzmO() {
        return this.zzWf.values();
    }
}
