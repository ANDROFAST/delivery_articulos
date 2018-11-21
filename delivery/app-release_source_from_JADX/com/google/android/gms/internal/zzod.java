package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class zzod implements ThreadFactory {
    private final int mPriority;
    private final String zzamw;
    private final AtomicInteger zzamx;
    private final ThreadFactory zzamy;

    public zzod(String str) {
        this(str, 0);
    }

    public zzod(String str, int i) {
        this.zzamx = new AtomicInteger();
        this.zzamy = Executors.defaultThreadFactory();
        this.zzamw = (String) zzx.zzb((Object) str, (Object) "Name must not be null");
        this.mPriority = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.zzamy.newThread(new zzoe(runnable, this.mPriority));
        newThread.setName(this.zzamw + "[" + this.zzamx.getAndIncrement() + "]");
        return newThread;
    }
}
