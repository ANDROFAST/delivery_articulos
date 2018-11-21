package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzha
public class zzjb<T> implements zzje<T> {
    private boolean zzBy = false;
    private T zzLI = null;
    private boolean zzLJ = false;
    private final zzjf zzLK = new zzjf();
    private final Object zzpK = new Object();

    public boolean cancel(boolean mayInterruptIfRunning) {
        if (!mayInterruptIfRunning) {
            return false;
        }
        synchronized (this.zzpK) {
            if (this.zzLJ) {
                return false;
            }
            this.zzBy = true;
            this.zzLJ = true;
            this.zzpK.notifyAll();
            this.zzLK.zzht();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.zzpK) {
            if (!this.zzLJ) {
                try {
                    this.zzpK.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzBy) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.zzLI;
        }
        return t;
    }

    public T get(long timeout, TimeUnit unit) throws TimeoutException {
        T t;
        synchronized (this.zzpK) {
            if (!this.zzLJ) {
                try {
                    long toMillis = unit.toMillis(timeout);
                    if (toMillis != 0) {
                        this.zzpK.wait(toMillis);
                    }
                } catch (InterruptedException e) {
                }
            }
            if (!this.zzLJ) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.zzBy) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.zzLI;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzBy;
        }
        return z;
    }

    public boolean isDone() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzLJ;
        }
        return z;
    }

    public void zzb(Runnable runnable) {
        this.zzLK.zzb(runnable);
    }

    public void zzc(Runnable runnable) {
        this.zzLK.zzc(runnable);
    }

    public void zzf(T t) {
        synchronized (this.zzpK) {
            if (this.zzBy) {
            } else if (this.zzLJ) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            } else {
                this.zzLJ = true;
                this.zzLI = t;
                this.zzpK.notifyAll();
                this.zzLK.zzht();
            }
        }
    }
}
