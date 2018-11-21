package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zzb;

public class zzbt extends zzd {
    private final zzb<Status> zzakL;

    public zzbt(zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
        this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status;
    }

    public void onSuccess() throws RemoteException {
        this.zzakL.zzr(Status.zzaeX);
    }

    public void zzA(Status status) throws RemoteException {
        this.zzakL.zzr(status);
    }
}
