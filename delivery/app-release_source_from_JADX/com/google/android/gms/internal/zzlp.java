package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzls.zza;

public class zzlp extends zzj<zzlr> implements DeathRecipient {
    private static final zzl zzYy = new zzl("CastRemoteDisplayClientImpl");
    private CastDevice zzYi;
    private CastRemoteDisplaySessionCallbacks zzade;

    public zzlp(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, CastDevice castDevice, CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 83, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        zzYy.zzb("instance created", new Object[0]);
        this.zzade = castRemoteDisplaySessionCallbacks;
        this.zzYi = castDevice;
    }

    public void binderDied() {
    }

    public void disconnect() {
        zzYy.zzb("disconnect", new Object[0]);
        this.zzade = null;
        this.zzYi = null;
        try {
            ((zzlr) zzqs()).disconnect();
            super.disconnect();
        } catch (RemoteException e) {
            super.disconnect();
        } catch (IllegalStateException e2) {
            super.disconnect();
        } catch (Throwable th) {
            super.disconnect();
        }
    }

    public /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzaG(iBinder);
    }

    public void zza(zzlq com_google_android_gms_internal_zzlq) throws RemoteException {
        zzYy.zzb("stopRemoteDisplay", new Object[0]);
        ((zzlr) zzqs()).zza(com_google_android_gms_internal_zzlq);
    }

    public void zza(zzlq com_google_android_gms_internal_zzlq, int i) throws RemoteException {
        ((zzlr) zzqs()).zza(com_google_android_gms_internal_zzlq, i);
    }

    public void zza(zzlq com_google_android_gms_internal_zzlq, final zzls com_google_android_gms_internal_zzls, String str) throws RemoteException {
        zzYy.zzb("startRemoteDisplay", new Object[0]);
        ((zzlr) zzqs()).zza(com_google_android_gms_internal_zzlq, new zza(this) {
            final /* synthetic */ zzlp zzadg;

            public void zzbp(int i) throws RemoteException {
                zzlp.zzYy.zzb("onRemoteDisplayEnded", new Object[0]);
                if (com_google_android_gms_internal_zzls != null) {
                    com_google_android_gms_internal_zzls.zzbp(i);
                }
                if (this.zzadg.zzade != null) {
                    this.zzadg.zzade.onRemoteDisplayEnded(new Status(i));
                }
            }
        }, this.zzYi.getDeviceId(), str);
    }

    public zzlr zzaG(IBinder iBinder) {
        return zzlr.zza.zzaI(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.cast.remote_display.service.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
    }
}
