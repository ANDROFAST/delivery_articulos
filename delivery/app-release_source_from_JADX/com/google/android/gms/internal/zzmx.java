package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import com.google.android.gms.common.internal.zzw;

public final class zzmx extends LruCache<zza, Drawable> {

    public static final class zza {
        public final int zzaiP;
        public final int zzaiQ;

        public zza(int i, int i2) {
            this.zzaiP = i;
            this.zzaiQ = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zza com_google_android_gms_internal_zzmx_zza = (zza) obj;
            return com_google_android_gms_internal_zzmx_zza.zzaiP == this.zzaiP && com_google_android_gms_internal_zzmx_zza.zzaiQ == this.zzaiQ;
        }

        public int hashCode() {
            return zzw.hashCode(Integer.valueOf(this.zzaiP), Integer.valueOf(this.zzaiQ));
        }
    }

    public zzmx() {
        super(10);
    }
}
