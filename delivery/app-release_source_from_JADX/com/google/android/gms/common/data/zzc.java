package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public abstract class zzc {
    protected final DataHolder zzafC;
    protected int zzahw;
    private int zzahx;

    public zzc(DataHolder dataHolder, int i) {
        this.zzafC = (DataHolder) zzx.zzy(dataHolder);
        zzbG(i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc com_google_android_gms_common_data_zzc = (zzc) obj;
        return zzw.equal(Integer.valueOf(com_google_android_gms_common_data_zzc.zzahw), Integer.valueOf(this.zzahw)) && zzw.equal(Integer.valueOf(com_google_android_gms_common_data_zzc.zzahx), Integer.valueOf(this.zzahx)) && com_google_android_gms_common_data_zzc.zzafC == this.zzafC;
    }

    protected boolean getBoolean(String column) {
        return this.zzafC.zze(column, this.zzahw, this.zzahx);
    }

    protected byte[] getByteArray(String column) {
        return this.zzafC.zzg(column, this.zzahw, this.zzahx);
    }

    protected float getFloat(String column) {
        return this.zzafC.zzf(column, this.zzahw, this.zzahx);
    }

    protected int getInteger(String column) {
        return this.zzafC.zzc(column, this.zzahw, this.zzahx);
    }

    protected long getLong(String column) {
        return this.zzafC.zzb(column, this.zzahw, this.zzahx);
    }

    protected String getString(String column) {
        return this.zzafC.zzd(column, this.zzahw, this.zzahx);
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzahw), Integer.valueOf(this.zzahx), this.zzafC);
    }

    public boolean isDataValid() {
        return !this.zzafC.isClosed();
    }

    protected void zza(String str, CharArrayBuffer charArrayBuffer) {
        this.zzafC.zza(str, this.zzahw, this.zzahx, charArrayBuffer);
    }

    protected void zzbG(int i) {
        boolean z = i >= 0 && i < this.zzafC.getCount();
        zzx.zzaa(z);
        this.zzahw = i;
        this.zzahx = this.zzafC.zzbI(this.zzahw);
    }

    public boolean zzct(String str) {
        return this.zzafC.zzct(str);
    }

    protected Uri zzcu(String str) {
        return this.zzafC.zzh(str, this.zzahw, this.zzahx);
    }

    protected boolean zzcv(String str) {
        return this.zzafC.zzi(str, this.zzahw, this.zzahx);
    }

    protected int zzpK() {
        return this.zzahw;
    }
}
