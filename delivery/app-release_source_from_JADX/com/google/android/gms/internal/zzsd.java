package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks;
import com.google.android.gms.common.internal.zzx;

public final class zzsd implements Optional {
    public static final zzsd zzbbH = new zza().zzDQ();
    private final boolean zzVD;
    private final boolean zzVF;
    private final String zzVG;
    private final boolean zzbbI;
    private final ServerAuthCodeCallbacks zzbbJ;
    private final boolean zzbbK;
    private final boolean zzbbL;

    public static final class zza {
        private String zzaYL;
        private boolean zzbbM;
        private boolean zzbbN;
        private ServerAuthCodeCallbacks zzbbO;
        private boolean zzbbP;
        private boolean zzbbQ;
        private boolean zzbbR;

        private String zzbH(String str) {
            zzx.zzy(str);
            boolean z = this.zzaYL == null || this.zzaYL.equals(str);
            zzx.zzb(z, (Object) "two different server client ids provided");
            return str;
        }

        public zzsd zzDQ() {
            return new zzsd(this.zzbbM, this.zzbbN, this.zzaYL, this.zzbbO, this.zzbbP, this.zzbbQ, this.zzbbR);
        }

        public zza zza(String str, ServerAuthCodeCallbacks serverAuthCodeCallbacks) {
            this.zzbbM = true;
            this.zzbbN = true;
            this.zzaYL = zzbH(str);
            this.zzbbO = (ServerAuthCodeCallbacks) zzx.zzy(serverAuthCodeCallbacks);
            return this;
        }
    }

    private zzsd(boolean z, boolean z2, String str, ServerAuthCodeCallbacks serverAuthCodeCallbacks, boolean z3, boolean z4, boolean z5) {
        this.zzbbI = z;
        this.zzVD = z2;
        this.zzVG = str;
        this.zzbbJ = serverAuthCodeCallbacks;
        this.zzbbK = z3;
        this.zzVF = z4;
        this.zzbbL = z5;
    }

    public boolean zzDM() {
        return this.zzbbI;
    }

    public ServerAuthCodeCallbacks zzDN() {
        return this.zzbbJ;
    }

    public boolean zzDO() {
        return this.zzbbK;
    }

    public boolean zzDP() {
        return this.zzbbL;
    }

    public boolean zzmA() {
        return this.zzVF;
    }

    public String zzmB() {
        return this.zzVG;
    }

    public boolean zzmy() {
        return this.zzVD;
    }
}
