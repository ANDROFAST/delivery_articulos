package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.zzx;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.UUID;

class zzr extends zzw {
    static final Pair<String, Long> zzaTD = new Pair("", Long.valueOf(0));
    private SharedPreferences zzRN;
    public final zzb zzaTE = new zzb("health_monitor", zzAX().zzkG());
    public final zza zzaTF = new zza(this, "last_upload", 0);
    public final zza zzaTG = new zza(this, "last_upload_attempt", 0);
    public final zza zzaTH = new zza(this, "backoff", 0);
    public final zza zzaTI = new zza(this, "last_delete_stale", 0);
    private String zzaTJ;
    private boolean zzaTK;
    private long zzaTL;
    private final SecureRandom zzaTM = new SecureRandom();

    public final class zza {
        private long zzaBq;
        private final long zzaTN;
        private boolean zzaTO;
        final /* synthetic */ zzr zzaTP;
        private final String zzuX;

        public zza(zzr com_google_android_gms_measurement_internal_zzr, String str, long j) {
            this.zzaTP = com_google_android_gms_measurement_internal_zzr;
            zzx.zzcG(str);
            this.zzuX = str;
            this.zzaTN = j;
        }

        private void zzBy() {
            if (!this.zzaTO) {
                this.zzaTO = true;
                this.zzaBq = this.zzaTP.zzRN.getLong(this.zzuX, this.zzaTN);
            }
        }

        public long get() {
            zzBy();
            return this.zzaBq;
        }

        public void set(long value) {
            Editor edit = this.zzaTP.zzRN.edit();
            edit.putLong(this.zzuX, value);
            edit.apply();
            this.zzaBq = value;
        }
    }

    public final class zzb {
        private final long zzRR;
        final /* synthetic */ zzr zzaTP;
        final String zzaTQ;
        private final String zzaTR;
        private final String zzaTS;

        private zzb(zzr com_google_android_gms_measurement_internal_zzr, String str, long j) {
            this.zzaTP = com_google_android_gms_measurement_internal_zzr;
            zzx.zzcG(str);
            zzx.zzab(j > 0);
            this.zzaTQ = str + ":start";
            this.zzaTR = str + ":count";
            this.zzaTS = str + ":value";
            this.zzRR = j;
        }

        private void zzlu() {
            this.zzaTP.zziS();
            long currentTimeMillis = this.zzaTP.zziT().currentTimeMillis();
            Editor edit = this.zzaTP.zzRN.edit();
            edit.remove(this.zzaTR);
            edit.remove(this.zzaTS);
            edit.putLong(this.zzaTQ, currentTimeMillis);
            edit.apply();
        }

        private long zzlv() {
            this.zzaTP.zziS();
            long zzlx = zzlx();
            if (zzlx != 0) {
                return Math.abs(zzlx - this.zzaTP.zziT().currentTimeMillis());
            }
            zzlu();
            return 0;
        }

        private long zzlx() {
            return this.zzaTP.zzBw().getLong(this.zzaTQ, 0);
        }

        public void zzbn(String str) {
            zzg(str, 1);
        }

        public void zzg(String str, long j) {
            this.zzaTP.zziS();
            if (zzlx() == 0) {
                zzlu();
            }
            if (str == null) {
                str = "";
            }
            long j2 = this.zzaTP.zzRN.getLong(this.zzaTR, 0);
            if (j2 <= 0) {
                Editor edit = this.zzaTP.zzRN.edit();
                edit.putString(this.zzaTS, str);
                edit.putLong(this.zzaTR, j);
                edit.apply();
                return;
            }
            Object obj = (this.zzaTP.zzaTM.nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j ? 1 : null;
            Editor edit2 = this.zzaTP.zzRN.edit();
            if (obj != null) {
                edit2.putString(this.zzaTS, str);
            }
            edit2.putLong(this.zzaTR, j2 + j);
            edit2.apply();
        }

        public Pair<String, Long> zzlw() {
            this.zzaTP.zziS();
            long zzlv = zzlv();
            if (zzlv < this.zzRR) {
                return null;
            }
            if (zzlv > this.zzRR * 2) {
                zzlu();
                return null;
            }
            String string = this.zzaTP.zzBw().getString(this.zzaTS, null);
            zzlv = this.zzaTP.zzBw().getLong(this.zzaTR, 0);
            zzlu();
            return (string == null || zzlv <= 0) ? zzr.zzaTD : new Pair(string, Long.valueOf(zzlv));
        }
    }

    zzr(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    private SharedPreferences zzBw() {
        zziS();
        zzje();
        return this.zzRN;
    }

    static MessageDigest zzbs(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    void setMeasurementEnabled(boolean enabled) {
        zziS();
        zzzz().zzBr().zzj("Setting measurementEnabled", Boolean.valueOf(enabled));
        Editor edit = zzBw().edit();
        edit.putBoolean("measurement_enabled", enabled);
        edit.apply();
    }

    Pair<String, Boolean> zzBt() {
        zziS();
        long elapsedRealtime = zziT().elapsedRealtime();
        if (this.zzaTJ != null && elapsedRealtime < this.zzaTL) {
            return new Pair(this.zzaTJ, Boolean.valueOf(this.zzaTK));
        }
        this.zzaTL = elapsedRealtime + zzAX().zzAD();
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            this.zzaTJ = advertisingIdInfo.getId();
            this.zzaTK = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            zzzz().zzBq().zzj("Unable to get advertising id", th);
            this.zzaTJ = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.zzaTJ, Boolean.valueOf(this.zzaTK));
    }

    String zzBu() {
        String str = (String) zzBt().first;
        if (zzbs("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzbs("MD5").digest(str.getBytes()))});
    }

    String zzBv() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    Boolean zzBx() {
        zziS();
        return !zzBw().contains("use_service") ? null : Boolean.valueOf(zzBw().getBoolean("use_service", false));
    }

    void zzap(boolean z) {
        zziS();
        zzzz().zzBr().zzj("Setting useService", Boolean.valueOf(z));
        Editor edit = zzBw().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    protected void zzir() {
        this.zzRN = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
    }

    boolean zzzC() {
        zziS();
        return zzBw().getBoolean("measurement_enabled", true);
    }
}
