package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.location.internal.zzi.zza;

public class zzb extends zzj<zzi> {
    private final String zzaLE;
    protected final zzp<zzi> zzaLF = new C07671(this);

    class C07671 implements zzp<zzi> {
        final /* synthetic */ zzb zzaLG;

        C07671(zzb com_google_android_gms_location_internal_zzb) {
            this.zzaLG = com_google_android_gms_location_internal_zzb;
        }

        public void zzqr() {
            this.zzaLG.zzqr();
        }

        public /* synthetic */ IInterface zzqs() throws DeadObjectException {
            return zzya();
        }

        public zzi zzya() throws DeadObjectException {
            return (zzi) this.zzaLG.zzqs();
        }
    }

    public zzb(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, 23, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzaLE = str;
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzcg(iBinder);
    }

    protected zzi zzcg(IBinder iBinder) {
        return zza.zzcj(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    protected Bundle zzlU() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.zzaLE);
        return bundle;
    }
}
