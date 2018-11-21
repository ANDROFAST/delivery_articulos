package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzlx.zza;
import com.google.android.gms.safetynet.SafetyNet;

abstract class zzrq<R extends Result> extends zza<R, zzru> {
    public zzrq(GoogleApiClient googleApiClient) {
        super(SafetyNet.zzTo, googleApiClient);
    }
}
