package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zze;

public final class IndoorLevel {
    private final zze zzaQv;

    public IndoorLevel(zze delegate) {
        this.zzaQv = (zze) zzx.zzy(delegate);
    }

    public void activate() {
        try {
            this.zzaQv.activate();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object other) {
        if (!(other instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.zzaQv.zza(((IndoorLevel) other).zzaQv);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getName() {
        try {
            return this.zzaQv.getName();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getShortName() {
        try {
            return this.zzaQv.getShortName();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.zzaQv.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
