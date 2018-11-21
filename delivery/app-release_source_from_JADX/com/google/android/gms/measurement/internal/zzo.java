package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.measurement.AppMeasurement;

public class zzo extends zzw {
    private final long zzaSk = zzAX().zzAE();
    private final char zzaTh;
    private final zza zzaTi;
    private final zza zzaTj;
    private final zza zzaTk;
    private final zza zzaTl;
    private final zza zzaTm;
    private final zza zzaTn;
    private final zza zzaTo;
    private final zza zzaTp;
    private final zza zzaTq;
    private final String zzakw = zzAX().zzAs();

    public class zza {
        private final int mPriority;
        final /* synthetic */ zzo zzaTs;
        private final boolean zzaTt;
        private final boolean zzaTu;

        zza(zzo com_google_android_gms_measurement_internal_zzo, int i, boolean z, boolean z2) {
            this.zzaTs = com_google_android_gms_measurement_internal_zzo;
            this.mPriority = i;
            this.zzaTt = z;
            this.zzaTu = z2;
        }

        public void zzd(String str, Object obj, Object obj2, Object obj3) {
            this.zzaTs.zza(this.mPriority, this.zzaTt, this.zzaTu, str, obj, obj2, obj3);
        }

        public void zze(String str, Object obj, Object obj2) {
            this.zzaTs.zza(this.mPriority, this.zzaTt, this.zzaTu, str, obj, obj2, null);
        }

        public void zzez(String str) {
            this.zzaTs.zza(this.mPriority, this.zzaTt, this.zzaTu, str, null, null, null);
        }

        public void zzj(String str, Object obj) {
            this.zzaTs.zza(this.mPriority, this.zzaTt, this.zzaTu, str, obj, null, null);
        }
    }

    zzo(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
        if (zzAX().zzkb()) {
            this.zzaTh = zzAX().zzka() ? 'P' : 'C';
        } else {
            this.zzaTh = zzAX().zzka() ? 'p' : 'c';
        }
        this.zzaTi = new zza(this, 6, false, false);
        this.zzaTj = new zza(this, 6, true, false);
        this.zzaTk = new zza(this, 6, false, true);
        this.zzaTl = new zza(this, 5, false, false);
        this.zzaTm = new zza(this, 5, true, false);
        this.zzaTn = new zza(this, 5, false, true);
        this.zzaTo = new zza(this, 4, false, false);
        this.zzaTp = new zza(this, 3, false, false);
        this.zzaTq = new zza(this, 2, false, false);
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object zzc = zzc(z, obj);
        Object zzc2 = zzc(z, obj2);
        Object zzc3 = zzc(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zzc)) {
            stringBuilder.append(str2);
            stringBuilder.append(zzc);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzc2)) {
            stringBuilder.append(str2);
            stringBuilder.append(zzc2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzc3)) {
            stringBuilder.append(str2);
            stringBuilder.append(zzc3);
        }
        return stringBuilder.toString();
    }

    static String zzc(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return str + Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1))) + "..." + str + Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d);
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return z ? "-" : String.valueOf(valueOf);
            } else {
                Throwable th = (Throwable) valueOf;
                StringBuilder stringBuilder = new StringBuilder(th.toString());
                String zzey = zzey(AppMeasurement.class.getCanonicalName());
                String zzey2 = zzey(zzt.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = zzey(className);
                            if (className.equals(zzey) || className.equals(zzey2)) {
                                stringBuilder.append(": ");
                                stringBuilder.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return stringBuilder.toString();
            }
        }
    }

    private static String zzey(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ void zzAR() {
        super.zzAR();
    }

    public /* bridge */ /* synthetic */ zzm zzAS() {
        return super.zzAS();
    }

    public /* bridge */ /* synthetic */ zzz zzAT() {
        return super.zzAT();
    }

    public /* bridge */ /* synthetic */ zzae zzAU() {
        return super.zzAU();
    }

    public /* bridge */ /* synthetic */ zzs zzAV() {
        return super.zzAV();
    }

    public /* bridge */ /* synthetic */ zzr zzAW() {
        return super.zzAW();
    }

    public /* bridge */ /* synthetic */ zzc zzAX() {
        return super.zzAX();
    }

    public zza zzBl() {
        return this.zzaTi;
    }

    public zza zzBm() {
        return this.zzaTl;
    }

    public zza zzBn() {
        return this.zzaTm;
    }

    public zza zzBo() {
        return this.zzaTn;
    }

    public zza zzBp() {
        return this.zzaTo;
    }

    public zza zzBq() {
        return this.zzaTp;
    }

    public zza zzBr() {
        return this.zzaTq;
    }

    public String zzBs() {
        Pair zzlw = zzAW().zzaTE.zzlw();
        return zzlw == null ? null : String.valueOf(zzlw.second) + ":" + ((String) zzlw.first);
    }

    protected boolean zzQ(int i) {
        return Log.isLoggable(this.zzakw, i);
    }

    protected void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && zzQ(i)) {
            zzn(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            zzb(i, str, obj, obj2, obj3);
        }
    }

    public void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        zzx.zzy(str);
        zzs zzBA = this.zzaQX.zzBA();
        if (zzBA == null || !zzBA.isInitialized() || zzBA.zzBP()) {
            zzn(6, "Scheduler not initialized or shutdown. Not logging error/warn.");
            return;
        }
        if (i < 0) {
            i = 0;
        }
        if (i >= "01VDIWEA?".length()) {
            i = "01VDIWEA?".length() - 1;
        }
        String str2 = "1" + "01VDIWEA?".charAt(i) + this.zzaTh + this.zzaSk + ":" + zza(true, str, obj, obj2, obj3);
        final String substring = str2.length() > 1024 ? str.substring(0, 1024) : str2;
        zzBA.zzg(new Runnable(this) {
            final /* synthetic */ zzo zzaTs;

            public void run() {
                zzr zzAW = this.zzaTs.zzaQX.zzAW();
                if (!zzAW.isInitialized() || zzAW.zzBP()) {
                    this.zzaTs.zzn(6, "Persisted config not initialized . Not logging error/warn.");
                } else {
                    zzAW.zzaTE.zzbn(substring);
                }
            }
        });
    }

    public /* bridge */ /* synthetic */ void zziR() {
        super.zziR();
    }

    public /* bridge */ /* synthetic */ void zziS() {
        super.zziS();
    }

    public /* bridge */ /* synthetic */ zznl zziT() {
        return super.zziT();
    }

    protected void zzir() {
    }

    protected void zzn(int i, String str) {
        Log.println(i, this.zzakw, str);
    }

    public /* bridge */ /* synthetic */ zzo zzzz() {
        return super.zzzz();
    }
}
