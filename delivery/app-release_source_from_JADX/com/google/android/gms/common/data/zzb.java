package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T> implements Iterator<T> {
    protected final DataBuffer<T> zzaht;
    protected int zzahu = -1;

    public zzb(DataBuffer<T> dataBuffer) {
        this.zzaht = (DataBuffer) zzx.zzy(dataBuffer);
    }

    public boolean hasNext() {
        return this.zzahu < this.zzaht.getCount() + -1;
    }

    public T next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.zzaht;
            int i = this.zzahu + 1;
            this.zzahu = i;
            return dataBuffer.get(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzahu);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
