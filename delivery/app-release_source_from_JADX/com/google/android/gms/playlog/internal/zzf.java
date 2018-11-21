package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zztk;
import com.google.android.gms.playlog.internal.zzb.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzf extends zzj<zza> {
    private final String zzSp;
    private final zzd zzaYG;
    private final zzb zzaYH = new zzb();
    private boolean zzaYI = true;
    private final Object zzpK = new Object();

    public zzf(Context context, Looper looper, zzd com_google_android_gms_playlog_internal_zzd, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, 24, com_google_android_gms_common_internal_zzf, com_google_android_gms_playlog_internal_zzd, com_google_android_gms_playlog_internal_zzd);
        this.zzSp = context.getPackageName();
        this.zzaYG = (zzd) zzx.zzy(com_google_android_gms_playlog_internal_zzd);
        this.zzaYG.zza(this);
    }

    private void zzDb() {
        zzb.zzaa(!this.zzaYI);
        if (!this.zzaYH.isEmpty()) {
            PlayLoggerContext playLoggerContext = null;
            try {
                List arrayList = new ArrayList();
                Iterator it = this.zzaYH.zzCZ().iterator();
                while (it.hasNext()) {
                    zza com_google_android_gms_playlog_internal_zzb_zza = (zza) it.next();
                    if (com_google_android_gms_playlog_internal_zzb_zza.zzaYv != null) {
                        ((zza) zzqs()).zza(this.zzSp, com_google_android_gms_playlog_internal_zzb_zza.zzaYt, zztk.toByteArray(com_google_android_gms_playlog_internal_zzb_zza.zzaYv));
                    } else {
                        PlayLoggerContext playLoggerContext2;
                        if (com_google_android_gms_playlog_internal_zzb_zza.zzaYt.equals(playLoggerContext)) {
                            arrayList.add(com_google_android_gms_playlog_internal_zzb_zza.zzaYu);
                            playLoggerContext2 = playLoggerContext;
                        } else {
                            if (!arrayList.isEmpty()) {
                                ((zza) zzqs()).zza(this.zzSp, playLoggerContext, arrayList);
                                arrayList.clear();
                            }
                            PlayLoggerContext playLoggerContext3 = com_google_android_gms_playlog_internal_zzb_zza.zzaYt;
                            arrayList.add(com_google_android_gms_playlog_internal_zzb_zza.zzaYu);
                            playLoggerContext2 = playLoggerContext3;
                        }
                        playLoggerContext = playLoggerContext2;
                    }
                }
                if (!arrayList.isEmpty()) {
                    ((zza) zzqs()).zza(this.zzSp, playLoggerContext, arrayList);
                }
                this.zzaYH.clear();
            } catch (RemoteException e) {
                Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
            }
        }
    }

    private void zzc(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.zzaYH.zza(playLoggerContext, logEvent);
    }

    private void zzd(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        try {
            zzDb();
            ((zza) zzqs()).zza(this.zzSp, playLoggerContext, logEvent);
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            zzc(playLoggerContext, logEvent);
        } catch (IllegalStateException e2) {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            zzc(playLoggerContext, logEvent);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
        r3 = this;
        r1 = r3.zzpK;
        monitor-enter(r1);
        r0 = r3.isConnecting();	 Catch:{ all -> 0x001c }
        if (r0 != 0) goto L_0x000f;
    L_0x0009:
        r0 = r3.isConnected();	 Catch:{ all -> 0x001c }
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
    L_0x0010:
        return;
    L_0x0011:
        r0 = r3.zzaYG;	 Catch:{ all -> 0x001c }
        r2 = 1;
        r0.zzar(r2);	 Catch:{ all -> 0x001c }
        r3.zzqp();	 Catch:{ all -> 0x001c }
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
        goto L_0x0010;
    L_0x001c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001c }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.playlog.internal.zzf.start():void");
    }

    public void stop() {
        synchronized (this.zzpK) {
            this.zzaYG.zzar(false);
            disconnect();
        }
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzdJ(iBinder);
    }

    void zzas(boolean z) {
        synchronized (this.zzpK) {
            boolean z2 = this.zzaYI;
            this.zzaYI = z;
            if (z2 && !this.zzaYI) {
                zzDb();
            }
        }
    }

    public void zzb(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        synchronized (this.zzpK) {
            if (this.zzaYI) {
                zzc(playLoggerContext, logEvent);
            } else {
                zzd(playLoggerContext, logEvent);
            }
        }
    }

    protected zza zzdJ(IBinder iBinder) {
        return zza.zza.zzdI(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.playlog.service.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }
}
