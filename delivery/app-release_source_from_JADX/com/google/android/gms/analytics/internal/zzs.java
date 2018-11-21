package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

class zzs implements Logger {
    private boolean zzNQ;
    private int zzQh = 2;

    zzs() {
    }

    public void error(Exception exception) {
    }

    public void error(String msg) {
    }

    public int getLogLevel() {
        return this.zzQh;
    }

    public void info(String msg) {
    }

    public void setLogLevel(int level) {
        this.zzQh = level;
        if (!this.zzNQ) {
            Log.i((String) zzy.zzQr.get(), "Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + ((String) zzy.zzQr.get()) + " DEBUG");
            this.zzNQ = true;
        }
    }

    public void verbose(String msg) {
    }

    public void warn(String msg) {
    }
}
