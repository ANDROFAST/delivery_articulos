package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

@Deprecated
public class zzae {
    private static volatile Logger zzRB;

    static {
        setLogger(new zzs());
    }

    public static Logger getLogger() {
        return zzRB;
    }

    public static void setLogger(Logger logger) {
        zzRB = logger;
    }

    public static void m8v(String msg) {
        zzaf zzlg = zzaf.zzlg();
        if (zzlg != null) {
            zzlg.zzba(msg);
        } else if (zzQ(0)) {
            Log.v((String) zzy.zzQr.get(), msg);
        }
        Logger logger = zzRB;
        if (logger != null) {
            logger.verbose(msg);
        }
    }

    public static boolean zzQ(int i) {
        return getLogger() != null && getLogger().getLogLevel() <= i;
    }

    public static void zzaG(String str) {
        zzaf zzlg = zzaf.zzlg();
        if (zzlg != null) {
            zzlg.zzbc(str);
        } else if (zzQ(1)) {
            Log.i((String) zzy.zzQr.get(), str);
        }
        Logger logger = zzRB;
        if (logger != null) {
            logger.info(str);
        }
    }

    public static void zzaH(String str) {
        zzaf zzlg = zzaf.zzlg();
        if (zzlg != null) {
            zzlg.zzbd(str);
        } else if (zzQ(2)) {
            Log.w((String) zzy.zzQr.get(), str);
        }
        Logger logger = zzRB;
        if (logger != null) {
            logger.warn(str);
        }
    }

    public static void zzf(String str, Object obj) {
        zzaf zzlg = zzaf.zzlg();
        if (zzlg != null) {
            zzlg.zze(str, obj);
        } else if (zzQ(3)) {
            Log.e((String) zzy.zzQr.get(), obj != null ? str + ":" + obj : str);
        }
        Logger logger = zzRB;
        if (logger != null) {
            logger.error(str);
        }
    }
}
