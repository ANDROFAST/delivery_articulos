package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    private static final String[] zzahy = new String[]{"data"};
    private final Creator<T> zzahz;

    public zzd(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.zzahz = creator;
    }

    public /* synthetic */ Object get(int x0) {
        return zzbH(x0);
    }

    public T zzbH(int i) {
        byte[] zzg = this.zzafC.zzg("data", i, this.zzafC.zzbI(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(zzg, 0, zzg.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.zzahz.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }
}
