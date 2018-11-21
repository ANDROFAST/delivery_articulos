package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class zzng<E> extends AbstractSet<E> {
    private final ArrayMap<E, E> zzami;

    public zzng() {
        this.zzami = new ArrayMap();
    }

    public zzng(int i) {
        this.zzami = new ArrayMap(i);
    }

    public zzng(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    public boolean add(E object) {
        if (this.zzami.containsKey(object)) {
            return false;
        }
        this.zzami.put(object, object);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof zzng ? zza((zzng) collection) : super.addAll(collection);
    }

    public void clear() {
        this.zzami.clear();
    }

    public boolean contains(Object object) {
        return this.zzami.containsKey(object);
    }

    public Iterator<E> iterator() {
        return this.zzami.keySet().iterator();
    }

    public boolean remove(Object object) {
        if (!this.zzami.containsKey(object)) {
            return false;
        }
        this.zzami.remove(object);
        return true;
    }

    public int size() {
        return this.zzami.size();
    }

    public boolean zza(zzng<? extends E> com_google_android_gms_internal_zzng__extends_E) {
        int size = size();
        this.zzami.putAll(com_google_android_gms_internal_zzng__extends_E.zzami);
        return size() > size;
    }
}
