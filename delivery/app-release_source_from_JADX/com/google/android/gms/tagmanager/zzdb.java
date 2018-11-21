package com.google.android.gms.tagmanager;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class zzdb extends zzak {
    private static final String ID = zzad.TIMER_LISTENER.toString();
    private static final String NAME = zzae.NAME.toString();
    private static final String zzbgj = zzae.INTERVAL.toString();
    private static final String zzbgk = zzae.LIMIT.toString();
    private static final String zzbgl = zzae.UNIQUE_TRIGGER_ID.toString();
    private final Context mContext;
    private Handler mHandler;
    private DataLayer zzbcG;
    private boolean zzbgm;
    private boolean zzbgn;
    private final HandlerThread zzbgo;
    private final Set<String> zzbgp = new HashSet();

    private final class zza implements Runnable {
        private final long zzBv = System.currentTimeMillis();
        private final long zzaLk;
        private final String zzbgq;
        private final String zzbgr;
        private final long zzbgs;
        private long zzbgt;
        final /* synthetic */ zzdb zzbgu;

        zza(zzdb com_google_android_gms_tagmanager_zzdb, String str, String str2, long j, long j2) {
            this.zzbgu = com_google_android_gms_tagmanager_zzdb;
            this.zzbgq = str;
            this.zzbgr = str2;
            this.zzaLk = j;
            this.zzbgs = j2;
        }

        public void run() {
            if (this.zzbgs <= 0 || this.zzbgt < this.zzbgs) {
                this.zzbgt++;
                if (zzcC()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.zzbgu.zzbcG.push(DataLayer.mapOf("event", this.zzbgq, "gtm.timerInterval", String.valueOf(this.zzaLk), "gtm.timerLimit", String.valueOf(this.zzbgs), "gtm.timerStartTime", String.valueOf(this.zzBv), "gtm.timerCurrentTime", String.valueOf(currentTimeMillis), "gtm.timerElapsedTime", String.valueOf(currentTimeMillis - this.zzBv), "gtm.timerEventNumber", String.valueOf(this.zzbgt), "gtm.triggers", this.zzbgr));
                }
                this.zzbgu.mHandler.postDelayed(this, this.zzaLk);
            } else if (!"0".equals(this.zzbgr)) {
                this.zzbgu.zzbgp.remove(this.zzbgr);
            }
        }

        protected boolean zzcC() {
            if (this.zzbgu.zzbgn) {
                return this.zzbgu.zzbgm;
            }
            KeyguardManager keyguardManager = (KeyguardManager) this.zzbgu.mContext.getSystemService("keyguard");
            PowerManager powerManager = (PowerManager) this.zzbgu.mContext.getSystemService("power");
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) this.zzbgu.mContext.getSystemService("activity")).getRunningAppProcesses()) {
                if (Process.myPid() == runningAppProcessInfo.pid && runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && powerManager.isScreenOn()) {
                    return true;
                }
            }
            return false;
        }
    }

    public zzdb(Context context, DataLayer dataLayer) {
        super(ID, zzbgj, NAME);
        this.mContext = context;
        this.zzbcG = dataLayer;
        this.zzbgo = new HandlerThread("Google GTM SDK Timer", 10);
        this.zzbgo.start();
        this.mHandler = new Handler(this.zzbgo.getLooper());
    }

    public boolean zzEa() {
        return false;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        long parseLong;
        long parseLong2;
        Object zzg = zzdf.zzg((com.google.android.gms.internal.zzag.zza) map.get(NAME));
        String zzg2 = zzdf.zzg((com.google.android.gms.internal.zzag.zza) map.get(zzbgl));
        String zzg3 = zzdf.zzg((com.google.android.gms.internal.zzag.zza) map.get(zzbgj));
        String zzg4 = zzdf.zzg((com.google.android.gms.internal.zzag.zza) map.get(zzbgk));
        try {
            parseLong = Long.parseLong(zzg3);
        } catch (NumberFormatException e) {
            parseLong = 0;
        }
        try {
            parseLong2 = Long.parseLong(zzg4);
        } catch (NumberFormatException e2) {
            parseLong2 = 0;
        }
        if (parseLong > 0 && !TextUtils.isEmpty(zzg)) {
            if (zzg2 == null || zzg2.isEmpty()) {
                zzg2 = "0";
            }
            if (!this.zzbgp.contains(zzg2)) {
                if (!"0".equals(zzg2)) {
                    this.zzbgp.add(zzg2);
                }
                this.mHandler.postDelayed(new zza(this, zzg, zzg2, parseLong, parseLong2), parseLong);
            }
        }
        return zzdf.zzFJ();
    }
}
