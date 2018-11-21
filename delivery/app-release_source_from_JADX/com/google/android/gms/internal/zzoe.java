package com.google.android.gms.internal;

import android.os.Process;

class zzoe implements Runnable {
    private final int mPriority;
    private final Runnable zzx;

    public zzoe(Runnable runnable, int i) {
        this.zzx = runnable;
        this.mPriority = i;
    }

    public void run() {
        Process.setThreadPriority(this.mPriority);
        this.zzx.run();
    }
}
