package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;

public class EventParams implements SafeParcelable, Iterable<String> {
    public static final zzi CREATOR = new zzi();
    public final int versionCode;
    private final Bundle zzaSI;

    class C03771 implements Iterator<String> {
        Iterator<String> zzaSJ = this.zzaSK.zzaSI.keySet().iterator();
        final /* synthetic */ EventParams zzaSK;

        C03771(EventParams eventParams) {
            this.zzaSK = eventParams;
        }

        public boolean hasNext() {
            return this.zzaSJ.hasNext();
        }

        public String next() {
            return (String) this.zzaSJ.next();
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

    EventParams(int versionCode, Bundle bundle) {
        this.versionCode = versionCode;
        this.zzaSI = bundle;
    }

    EventParams(Bundle bundle) {
        zzx.zzy(bundle);
        this.zzaSI = bundle;
        this.versionCode = 1;
    }

    public int describeContents() {
        return 0;
    }

    Object get(String key) {
        return this.zzaSI.get(key);
    }

    public Iterator<String> iterator() {
        return new C03771(this);
    }

    public int size() {
        return this.zzaSI.size();
    }

    public String toString() {
        return this.zzaSI.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzi.zza(this, out, flags);
    }

    public Bundle zzBh() {
        return new Bundle(this.zzaSI);
    }
}
