package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
    public static final Creator<AppVisibleCustomProperties> CREATOR = new zza();
    public static final AppVisibleCustomProperties zzaqF = new zza().zztb();
    final int mVersionCode;
    final List<CustomProperty> zzaqG;

    public static class zza {
        private final Map<CustomPropertyKey, CustomProperty> zzaqH = new HashMap();

        public zza zza(CustomPropertyKey customPropertyKey, String str) {
            zzx.zzb((Object) customPropertyKey, (Object) "key");
            this.zzaqH.put(customPropertyKey, new CustomProperty(customPropertyKey, str));
            return this;
        }

        public zza zza(CustomProperty customProperty) {
            zzx.zzb((Object) customProperty, (Object) "property");
            this.zzaqH.put(customProperty.zztc(), customProperty);
            return this;
        }

        public AppVisibleCustomProperties zztb() {
            return new AppVisibleCustomProperties(this.zzaqH.values());
        }
    }

    AppVisibleCustomProperties(int versionCode, Collection<CustomProperty> properties) {
        this.mVersionCode = versionCode;
        zzx.zzy(properties);
        this.zzaqG = new ArrayList(properties);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> properties) {
        this(1, (Collection) properties);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return (o == null || o.getClass() != getClass()) ? false : zzta().equals(((AppVisibleCustomProperties) o).zzta());
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaqG);
    }

    public Iterator<CustomProperty> iterator() {
        return this.zzaqG.iterator();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }

    public Map<CustomPropertyKey, String> zzta() {
        Map hashMap = new HashMap(this.zzaqG.size());
        for (CustomProperty customProperty : this.zzaqG) {
            hashMap.put(customProperty.zztc(), customProperty.getValue());
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
