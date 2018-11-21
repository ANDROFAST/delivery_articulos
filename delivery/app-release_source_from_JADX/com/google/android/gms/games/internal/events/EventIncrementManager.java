package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
    private final AtomicReference<EventIncrementCache> zzaFz = new AtomicReference();

    public void flush() {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.zzaFz.get();
        if (eventIncrementCache != null) {
            eventIncrementCache.flush();
        }
    }

    public void zzp(String str, int i) {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.zzaFz.get();
        if (eventIncrementCache == null) {
            eventIncrementCache = zzwo();
            if (!this.zzaFz.compareAndSet(null, eventIncrementCache)) {
                eventIncrementCache = (EventIncrementCache) this.zzaFz.get();
            }
        }
        eventIncrementCache.zzw(str, i);
    }

    protected abstract EventIncrementCache zzwo();
}
