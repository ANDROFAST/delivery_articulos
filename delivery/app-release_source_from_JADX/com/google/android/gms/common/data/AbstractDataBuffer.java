package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {
    protected final DataHolder zzafC;

    protected AbstractDataBuffer(DataHolder dataHolder) {
        this.zzafC = dataHolder;
        if (this.zzafC != null) {
            this.zzafC.zzt(this);
        }
    }

    @Deprecated
    public final void close() {
        release();
    }

    public abstract T get(int i);

    public int getCount() {
        return this.zzafC == null ? 0 : this.zzafC.getCount();
    }

    @Deprecated
    public boolean isClosed() {
        return this.zzafC == null || this.zzafC.isClosed();
    }

    public Iterator<T> iterator() {
        return new zzb(this);
    }

    public void release() {
        if (this.zzafC != null) {
            this.zzafC.close();
        }
    }

    public Iterator<T> singleRefIterator() {
        return new zzg(this);
    }

    public Bundle zzpH() {
        return this.zzafC.zzpH();
    }
}
