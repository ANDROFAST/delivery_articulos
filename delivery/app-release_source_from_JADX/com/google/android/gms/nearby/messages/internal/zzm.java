package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.nearby.messages.internal.zzc.zza;

final class zzm extends zza {
    private final zzb<Status> zzaXE;

    private zzm(zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
        this.zzaXE = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status;
    }

    static zzm zzk(zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
        return new zzm(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
    }

    public void zzaX(Status status) throws RemoteException {
        this.zzaXE.zzr(status);
    }
}
