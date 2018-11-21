package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzim extends Handler {
    public zzim(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message msg) {
        try {
            super.handleMessage(msg);
        } catch (Throwable e) {
            zzp.zzbA().zzb(e, false);
            throw e;
        }
    }
}
