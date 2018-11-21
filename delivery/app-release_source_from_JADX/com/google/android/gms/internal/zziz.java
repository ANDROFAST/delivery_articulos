package com.google.android.gms.internal;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;

@zzha
public class zziz {
    public static <T> T zzb(Callable<T> callable) {
        T call;
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            call = callable.call();
        } catch (Throwable th) {
            zzb.zzb("Unexpected exception.", th);
            zzp.zzbA().zzb(th, true);
            call = null;
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        return call;
    }
}
