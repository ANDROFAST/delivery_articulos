package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zzof;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
    public static final Creator<MetadataBundle> CREATOR = new zzh();
    final int mVersionCode;
    final Bundle zzaqL;

    MetadataBundle(int versionCode, Bundle valueBundle) {
        this.mVersionCode = versionCode;
        this.zzaqL = (Bundle) zzx.zzy(valueBundle);
        this.zzaqL.setClassLoader(getClass().getClassLoader());
        List<String> arrayList = new ArrayList();
        for (String str : this.zzaqL.keySet()) {
            if (zze.zzcU(str) == null) {
                arrayList.add(str);
                zzz.zzA("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        for (String str2 : arrayList) {
            this.zzaqL.remove(str2);
        }
    }

    private MetadataBundle(Bundle valueBundle) {
        this(1, valueBundle);
    }

    public static <T> MetadataBundle zza(MetadataField<T> metadataField, T t) {
        MetadataBundle zztf = zztf();
        zztf.zzb(metadataField, t);
        return zztf;
    }

    public static MetadataBundle zza(MetadataBundle metadataBundle) {
        return new MetadataBundle(new Bundle(metadataBundle.zzaqL));
    }

    public static MetadataBundle zztf() {
        return new MetadataBundle(new Bundle());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.zzaqL.keySet();
        if (!keySet.equals(metadataBundle.zzaqL.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!zzw.equal(this.zzaqL.get(str), metadataBundle.zzaqL.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (String str : this.zzaqL.keySet()) {
            i *= 31;
            i = this.zzaqL.get(str).hashCode() + i;
        }
        return i;
    }

    public void setContext(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zzof.zzart);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.zzc(context.getCacheDir());
        }
    }

    public String toString() {
        return "MetadataBundle [values=" + this.zzaqL + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zzm(this.zzaqL);
    }

    public <T> void zzb(MetadataField<T> metadataField, T t) {
        if (zze.zzcU(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.zza(t, this.zzaqL);
    }

    public boolean zzc(MetadataField<?> metadataField) {
        return this.zzaqL.containsKey(metadataField.getName());
    }

    public Set<MetadataField<?>> zztg() {
        Set<MetadataField<?>> hashSet = new HashSet();
        for (String zzcU : this.zzaqL.keySet()) {
            hashSet.add(zze.zzcU(zzcU));
        }
        return hashSet;
    }
}
