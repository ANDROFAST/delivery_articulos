package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zzd;
import com.google.android.gms.maps.model.internal.zze.zza;
import java.util.ArrayList;
import java.util.List;

public final class IndoorBuilding {
    private final zzd zzaQu;

    public IndoorBuilding(zzd delegate) {
        this.zzaQu = (zzd) zzx.zzy(delegate);
    }

    public boolean equals(Object other) {
        if (!(other instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.zzaQu.zzb(((IndoorBuilding) other).zzaQu);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getActiveLevelIndex() {
        try {
            return this.zzaQu.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getDefaultLevelIndex() {
        try {
            return this.zzaQu.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<IndoorLevel> getLevels() {
        try {
            List<IBinder> levels = this.zzaQu.getLevels();
            List<IndoorLevel> arrayList = new ArrayList(levels.size());
            for (IBinder zzdc : levels) {
                arrayList.add(new IndoorLevel(zza.zzdc(zzdc)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.zzaQu.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUnderground() {
        try {
            return this.zzaQu.isUnderground();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
