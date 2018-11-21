package com.google.android.gms.nearby;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.internal.zzqs;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.nearby.bootstrap.zza;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.internal.zzk;
import com.google.android.gms.nearby.messages.internal.zzl;
import com.google.android.gms.nearby.messages.zzc;
import com.google.android.gms.nearby.sharing.internal.zzh;
import com.google.android.gms.nearby.sharing.internal.zzi;
import com.google.android.gms.nearby.sharing.zzd;
import com.google.android.gms.nearby.sharing.zze;

public final class Nearby {
    public static final Api<NoOptions> CONNECTIONS_API = new Api("Nearby.CONNECTIONS_API", zzra.zzTp, zzra.zzTo);
    public static final Connections Connections = new zzra();
    public static final Api<MessagesOptions> MESSAGES_API = new Api("Nearby.MESSAGES_API", zzk.zzTp, zzk.zzTo);
    public static final Messages Messages = new zzk();
    public static final zzc zzaVN = new zzl();
    public static final Api<NoOptions> zzaVO = new Api("Nearby.SHARING_API", zzh.zzTp, zzh.zzTo);
    public static final zzd zzaVP = new zzh();
    public static final zze zzaVQ = new zzi();
    public static final Api<NoOptions> zzaVR = new Api("Nearby.BOOTSTRAP_API", zzqs.zzTp, zzqs.zzTo);
    public static final zza zzaVS = new zzqs();

    private Nearby() {
    }
}
