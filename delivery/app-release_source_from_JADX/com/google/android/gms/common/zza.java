package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class zza implements ServiceConnection {
    boolean zzadP = false;
    private final BlockingQueue<IBinder> zzadQ = new LinkedBlockingQueue();

    public void onServiceConnected(ComponentName name, IBinder service) {
        this.zzadQ.add(service);
    }

    public void onServiceDisconnected(ComponentName name) {
    }

    public IBinder zzor() throws InterruptedException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        } else if (this.zzadP) {
            throw new IllegalStateException();
        } else {
            this.zzadP = true;
            return (IBinder) this.zzadQ.take();
        }
    }
}
