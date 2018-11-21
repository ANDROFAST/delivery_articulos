package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class zzoc {
    private static final Method zzamr = zzrZ();
    private static final Method zzams = zzsa();
    private static final Method zzamt = zzsb();
    private static final Method zzamu = zzsc();
    private static final Method zzamv = zzsd();

    public static int zza(WorkSource workSource) {
        if (zzamt != null) {
            try {
                return ((Integer) zzamt.invoke(workSource, new Object[0])).intValue();
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    public static String zza(WorkSource workSource, int i) {
        if (zzamv != null) {
            try {
                return (String) zzamv.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return null;
    }

    public static void zza(WorkSource workSource, int i, String str) {
        if (zzams != null) {
            if (str == null) {
                str = "";
            }
            try {
                zzams.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Throwable e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        } else if (zzamr != null) {
            try {
                zzamr.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
    }

    public static boolean zzaz(Context context) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        return packageManager != null && packageManager.checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0;
    }

    public static List<String> zzb(WorkSource workSource) {
        int i = 0;
        int zza = workSource == null ? 0 : zza(workSource);
        if (zza == 0) {
            return Collections.EMPTY_LIST;
        }
        List<String> arrayList = new ArrayList();
        while (i < zza) {
            String zza2 = zza(workSource, i);
            if (!zzob.zzcP(zza2)) {
                arrayList.add(zza2);
            }
            i++;
        }
        return arrayList;
    }

    public static WorkSource zzh(int i, String str) {
        WorkSource workSource = new WorkSource();
        zza(workSource, i, str);
        return workSource;
    }

    public static WorkSource zzk(Context context, String str) {
        if (context == null || context.getPackageManager() == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return zzh(applicationInfo.uid, str);
            }
            Log.e("WorkSourceUtil", "Could not get applicationInfo from package: " + str);
            return null;
        } catch (NameNotFoundException e) {
            Log.e("WorkSourceUtil", "Could not find package: " + str);
            return null;
        }
    }

    private static Method zzrZ() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod(ProductAction.ACTION_ADD, new Class[]{Integer.TYPE});
        } catch (Exception e) {
        }
        return method;
    }

    private static Method zzsa() {
        Method method = null;
        if (zznx.zzrT()) {
            try {
                method = WorkSource.class.getMethod(ProductAction.ACTION_ADD, new Class[]{Integer.TYPE, String.class});
            } catch (Exception e) {
            }
        }
        return method;
    }

    private static Method zzsb() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
        }
        return method;
    }

    private static Method zzsc() {
        Method method = null;
        try {
            method = WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception e) {
        }
        return method;
    }

    private static Method zzsd() {
        Method method = null;
        if (zznx.zzrT()) {
            try {
                method = WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
            } catch (Exception e) {
            }
        }
        return method;
    }
}
