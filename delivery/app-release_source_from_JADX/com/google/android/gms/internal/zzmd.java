package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zza;

public class zzmd implements zzmh {
    private final zzmi zzafD;

    public zzmd(zzmi com_google_android_gms_internal_zzmi) {
        this.zzafD = com_google_android_gms_internal_zzmi;
    }

    private <A extends zzb> void zza(zze<A> com_google_android_gms_internal_zzmg_zze_A) throws DeadObjectException {
        this.zzafD.zzafp.zzb((zze) com_google_android_gms_internal_zzmg_zze_A);
        zzb zza = this.zzafD.zzafp.zza(com_google_android_gms_internal_zzmg_zze_A.zzoA());
        if (zza.isConnected() || !this.zzafD.zzagJ.containsKey(com_google_android_gms_internal_zzmg_zze_A.zzoA())) {
            com_google_android_gms_internal_zzmg_zze_A.zzb(zza);
        } else {
            com_google_android_gms_internal_zzmg_zze_A.zzx(new Status(17));
        }
    }

    public void begin() {
    }

    public void connect() {
    }

    public void disconnect() {
        this.zzafD.zzj(null);
    }

    public void onConnected(Bundle connectionHint) {
    }

    public void onConnectionSuspended(int cause) {
        this.zzafD.zzj(null);
        this.zzafD.zzagN.zzbz(cause);
    }

    public <A extends zzb, R extends Result, T extends zza<R, A>> T zza(T t) {
        return zzb(t);
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends zzb, T extends zza<? extends Result, A>> T zzb(T t) {
        try {
            zza((zze) t);
        } catch (DeadObjectException e) {
            this.zzafD.zza(new zza(this, this) {
                final /* synthetic */ zzmd zzafE;

                public void zzpc() {
                    this.zzafE.onConnectionSuspended(1);
                }
            });
        }
        return t;
    }
}
