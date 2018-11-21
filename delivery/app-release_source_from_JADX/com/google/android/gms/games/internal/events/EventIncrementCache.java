package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object zzaFt = new Object();
    private Handler zzaFu;
    private boolean zzaFv;
    private HashMap<String, AtomicInteger> zzaFw;
    private int zzaFx;

    class C02431 implements Runnable {
        final /* synthetic */ EventIncrementCache zzaFy;

        C02431(EventIncrementCache eventIncrementCache) {
            this.zzaFy = eventIncrementCache;
        }

        public void run() {
            this.zzaFy.zzwE();
        }
    }

    public EventIncrementCache(Looper looper, int flushIntervalMillis) {
        this.zzaFu = new Handler(looper);
        this.zzaFw = new HashMap();
        this.zzaFx = flushIntervalMillis;
    }

    private void zzwE() {
        synchronized (this.zzaFt) {
            this.zzaFv = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.zzaFt) {
            for (Entry entry : this.zzaFw.entrySet()) {
                zzs((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.zzaFw.clear();
        }
    }

    protected abstract void zzs(String str, int i);

    public void zzw(String str, int i) {
        synchronized (this.zzaFt) {
            if (!this.zzaFv) {
                this.zzaFv = true;
                this.zzaFu.postDelayed(new C02431(this), (long) this.zzaFx);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.zzaFw.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzaFw.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
