package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

@zzha
public class zzjc<T> implements zzje<T> {
    private final T zzLI;
    private final zzjf zzLK = new zzjf();

    public zzjc(T t) {
        this.zzLI = t;
        this.zzLK.zzht();
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    public T get() {
        return this.zzLI;
    }

    public T get(long timeout, TimeUnit unit) {
        return this.zzLI;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public void zzb(Runnable runnable) {
        this.zzLK.zzb(runnable);
    }
}
