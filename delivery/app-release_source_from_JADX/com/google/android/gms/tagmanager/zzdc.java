package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

public class zzdc {
    private Context mContext;
    private Tracker zzNH;
    private GoogleAnalytics zzNJ;

    static class zza implements Logger {
        zza() {
        }

        private static int zzjW(int i) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            zzbg.zzb("", exception);
        }

        public void error(String message) {
            zzbg.m9e(message);
        }

        public int getLogLevel() {
            return zzjW(zzbg.getLogLevel());
        }

        public void info(String message) {
            zzbg.zzaG(message);
        }

        public void setLogLevel(int logLevel) {
            zzbg.zzaH("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String message) {
            zzbg.m10v(message);
        }

        public void warn(String message) {
            zzbg.zzaH(message);
        }
    }

    public zzdc(Context context) {
        this.mContext = context;
    }

    private synchronized void zzfD(String str) {
        if (this.zzNJ == null) {
            this.zzNJ = GoogleAnalytics.getInstance(this.mContext);
            this.zzNJ.setLogger(new zza());
            this.zzNH = this.zzNJ.newTracker(str);
        }
    }

    public Tracker zzfC(String str) {
        zzfD(str);
        return this.zzNH;
    }
}
