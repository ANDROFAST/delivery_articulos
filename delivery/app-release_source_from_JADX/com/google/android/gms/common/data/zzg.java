package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class zzg<T> extends zzb<T> {
    private T zzahQ;

    public zzg(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        if (hasNext()) {
            this.zzahu++;
            if (this.zzahu == 0) {
                this.zzahQ = this.zzaht.get(0);
                if (!(this.zzahQ instanceof zzc)) {
                    throw new IllegalStateException("DataBuffer reference of type " + this.zzahQ.getClass() + " is not movable");
                }
            }
            ((zzc) this.zzahQ).zzbG(this.zzahu);
            return this.zzahQ;
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzahu);
    }
}
