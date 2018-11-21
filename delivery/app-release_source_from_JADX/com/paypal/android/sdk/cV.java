package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class cV {
    private Context f567a;

    public cV(Context context) {
        this.f567a = context;
    }

    public final void m409a(Collection collection) {
        try {
            Set hashSet = new HashSet(collection);
            ActivityInfo[] activityInfoArr = this.f567a.getPackageManager().getPackageInfo(this.f567a.getPackageName(), 1).activities;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    hashSet.remove(activityInfo.name);
                }
            }
            if (!hashSet.isEmpty()) {
                throw new RuntimeException("Missing required activities in manifest:" + hashSet);
            }
        } catch (NameNotFoundException e) {
            throw new RuntimeException("Exception loading manifest" + e.getMessage());
        }
    }
}
