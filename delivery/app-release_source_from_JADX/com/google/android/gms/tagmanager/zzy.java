package com.google.android.gms.tagmanager;

import android.util.Log;

public class zzy implements zzbh {
    private int zzQh = 5;

    public void mo3518e(String message) {
        if (this.zzQh <= 6) {
            Log.e("GoogleTagManager", message);
        }
    }

    public void setLogLevel(int logLevel) {
        this.zzQh = logLevel;
    }

    public void mo3520v(String message) {
        if (this.zzQh <= 2) {
            Log.v("GoogleTagManager", message);
        }
    }

    public void zzaF(String str) {
        if (this.zzQh <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    public void zzaG(String str) {
        if (this.zzQh <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void zzaH(String str) {
        if (this.zzQh <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    public void zzb(String str, Throwable th) {
        if (this.zzQh <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void zzd(String str, Throwable th) {
        if (this.zzQh <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }
}
