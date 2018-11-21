package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class cW {
    private static final List f568a = Arrays.asList(new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET"});
    private final Context f569b;

    static {
        cW.class.getSimpleName();
    }

    public cW(Context context) {
        this.f569b = context;
    }

    public final void m410a() {
        try {
            Set hashSet = new HashSet(f568a);
            String[] strArr = this.f569b.getPackageManager().getPackageInfo(this.f569b.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (Object remove : strArr) {
                    hashSet.remove(remove);
                }
            }
            if (!hashSet.isEmpty()) {
                throw new RuntimeException("Missing required permissions in manifest:" + hashSet);
            }
        } catch (NameNotFoundException e) {
            throw new RuntimeException("Exception loading manifest" + e.getMessage());
        }
    }
}
