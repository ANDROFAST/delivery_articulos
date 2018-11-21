package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzi;
import com.google.android.gms.maps.model.internal.zzi.zza;

public final class TileOverlayOptions implements SafeParcelable {
    public static final zzo CREATOR = new zzo();
    private final int mVersionCode;
    private zzi zzaQR;
    private TileProvider zzaQS;
    private boolean zzaQT;
    private float zzaQj;
    private boolean zzaQk;

    class C07691 implements TileProvider {
        private final zzi zzaQU = this.zzaQV.zzaQR;
        final /* synthetic */ TileOverlayOptions zzaQV;

        C07691(TileOverlayOptions tileOverlayOptions) {
            this.zzaQV = tileOverlayOptions;
        }

        public Tile getTile(int x, int y, int zoom) {
            try {
                return this.zzaQU.getTile(x, y, zoom);
            } catch (RemoteException e) {
                return null;
            }
        }
    }

    public TileOverlayOptions() {
        this.zzaQk = true;
        this.zzaQT = true;
        this.mVersionCode = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.zzaQk = true;
        this.zzaQT = true;
        this.mVersionCode = versionCode;
        this.zzaQR = zza.zzdh(delegate);
        this.zzaQS = this.zzaQR == null ? null : new C07691(this);
        this.zzaQk = visible;
        this.zzaQj = zIndex;
        this.zzaQT = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.zzaQT = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.zzaQT;
    }

    public TileProvider getTileProvider() {
        return this.zzaQS;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public float getZIndex() {
        return this.zzaQj;
    }

    public boolean isVisible() {
        return this.zzaQk;
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.zzaQS = tileProvider;
        this.zzaQR = this.zzaQS == null ? null : new zza(this) {
            final /* synthetic */ TileOverlayOptions zzaQV;

            public Tile getTile(int x, int y, int zoom) {
                return tileProvider.getTile(x, y, zoom);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.zzaQk = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzo.zza(this, out, flags);
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.zzaQj = zIndex;
        return this;
    }

    IBinder zzzx() {
        return this.zzaQR.asBinder();
    }
}
