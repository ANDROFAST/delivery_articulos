package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcn.zza;
import com.google.android.gms.internal.zzha;

@zzha
public class zzc extends zza {
    private final Uri mUri;
    private final Drawable zzxw;
    private final double zzxx;

    public zzc(Drawable drawable, Uri uri, double d) {
        this.zzxw = drawable;
        this.mUri = uri;
        this.zzxx = d;
    }

    public double getScale() {
        return this.zzxx;
    }

    public Uri getUri() throws RemoteException {
        return this.mUri;
    }

    public zzd zzdC() throws RemoteException {
        return zze.zzB(this.zzxw);
    }
}
