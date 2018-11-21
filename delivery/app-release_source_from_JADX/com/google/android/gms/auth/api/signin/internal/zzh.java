package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.FacebookSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class zzh {
    public static void zza(SignInConfiguration signInConfiguration, List<zze> list, Map<zze, List<String>> map) {
        List linkedList;
        Iterator it;
        zzx.zzy(signInConfiguration);
        zzx.zzy(list);
        zzx.zzy(map);
        GoogleSignInOptions zzmR = signInConfiguration.zzmR();
        if (zzmR != null) {
            list.add(zze.GOOGLE);
            linkedList = new LinkedList();
            it = zzmR.zzmu().iterator();
            while (it.hasNext()) {
                linkedList.add(((Scope) it.next()).zzoM());
            }
            map.put(zze.GOOGLE, linkedList);
        }
        FacebookSignInOptions zzmS = signInConfiguration.zzmS();
        if (zzmS != null) {
            list.add(zze.FACEBOOK);
            linkedList = new LinkedList();
            it = zzmS.zzmu().iterator();
            while (it.hasNext()) {
                linkedList.add((String) it.next());
            }
            map.put(zze.FACEBOOK, linkedList);
        }
    }
}
