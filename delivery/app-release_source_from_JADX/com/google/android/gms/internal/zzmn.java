package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzx;

public final class zzmn<L> {
    private volatile L mListener;
    private final zza zzagR;

    private final class zza extends Handler {
        final /* synthetic */ zzmn zzagS;

        public zza(zzmn com_google_android_gms_internal_zzmn, Looper looper) {
            this.zzagS = com_google_android_gms_internal_zzmn;
            super(looper);
        }

        public void handleMessage(Message msg) {
            boolean z = true;
            if (msg.what != 1) {
                z = false;
            }
            zzx.zzab(z);
            this.zzagS.zzb((zzb) msg.obj);
        }
    }

    public interface zzb<L> {
        void zzpb();

        void zzs(L l);
    }

    zzmn(Looper looper, L l) {
        this.zzagR = new zza(this, looper);
        this.mListener = zzx.zzb((Object) l, (Object) "Listener must not be null");
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzb<? super L> com_google_android_gms_internal_zzmn_zzb__super_L) {
        zzx.zzb((Object) com_google_android_gms_internal_zzmn_zzb__super_L, (Object) "Notifier must not be null");
        this.zzagR.sendMessage(this.zzagR.obtainMessage(1, com_google_android_gms_internal_zzmn_zzb__super_L));
    }

    void zzb(zzb<? super L> com_google_android_gms_internal_zzmn_zzb__super_L) {
        Object obj = this.mListener;
        if (obj == null) {
            com_google_android_gms_internal_zzmn_zzb__super_L.zzpb();
            return;
        }
        try {
            com_google_android_gms_internal_zzmn_zzb__super_L.zzs(obj);
        } catch (RuntimeException e) {
            com_google_android_gms_internal_zzmn_zzb__super_L.zzpb();
            throw e;
        }
    }
}
