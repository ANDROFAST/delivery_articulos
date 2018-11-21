package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzqq.zza;
import com.google.android.gms.internal.zzqq.zzb;
import com.google.android.gms.internal.zzqq.zzc;
import com.google.android.gms.internal.zzqq.zzd;
import com.google.android.gms.internal.zzqq.zze;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzt {
    private static zzx zzaUg;
    private static volatile zzt zzaUh;
    private final Context mContext;
    private final boolean zzOQ;
    private final zzc zzaUi;
    private final zzr zzaUj;
    private final zzo zzaUk;
    private final zzs zzaUl;
    private final AppMeasurement zzaUm;
    private final zzae zzaUn;
    private final zzd zzaUo;
    private final zzp zzaUp;
    private final zzz zzaUq;
    private final zzf zzaUr;
    private final zzy zzaUs;
    private final zzm zzaUt;
    private final zzq zzaUu;
    private final zzab zzaUv;
    private Boolean zzaUw;
    private List<Long> zzaUx;
    private int zzaUy;
    private int zzaUz;
    private final zznl zzqD;

    class C03831 implements Runnable {
        final /* synthetic */ zzt zzaUA;

        C03831(zzt com_google_android_gms_measurement_internal_zzt) {
            this.zzaUA = com_google_android_gms_measurement_internal_zzt;
        }

        public void run() {
            this.zzaUA.start();
        }
    }

    class C07702 implements zza {
        final /* synthetic */ zzt zzaUA;

        C07702(zzt com_google_android_gms_measurement_internal_zzt) {
            this.zzaUA = com_google_android_gms_measurement_internal_zzt;
        }

        public void zza(int i, Throwable th, byte[] bArr) {
            this.zzaUA.zzb(i, th, bArr);
        }
    }

    zzt(zzx com_google_android_gms_measurement_internal_zzx) {
        zzx.zzy(com_google_android_gms_measurement_internal_zzx);
        this.mContext = com_google_android_gms_measurement_internal_zzx.mContext;
        this.zzqD = com_google_android_gms_measurement_internal_zzx.zzj(this);
        this.zzaUi = com_google_android_gms_measurement_internal_zzx.zza(this);
        zzr zzb = com_google_android_gms_measurement_internal_zzx.zzb(this);
        zzb.zza();
        this.zzaUj = zzb;
        zzo zzc = com_google_android_gms_measurement_internal_zzx.zzc(this);
        zzc.zza();
        this.zzaUk = zzc;
        this.zzaUn = com_google_android_gms_measurement_internal_zzx.zzg(this);
        zzf zzl = com_google_android_gms_measurement_internal_zzx.zzl(this);
        zzl.zza();
        this.zzaUr = zzl;
        zzm zzm = com_google_android_gms_measurement_internal_zzx.zzm(this);
        zzm.zza();
        this.zzaUt = zzm;
        zzd zzh = com_google_android_gms_measurement_internal_zzx.zzh(this);
        zzh.zza();
        this.zzaUo = zzh;
        zzp zzi = com_google_android_gms_measurement_internal_zzx.zzi(this);
        zzi.zza();
        this.zzaUp = zzi;
        zzz zzk = com_google_android_gms_measurement_internal_zzx.zzk(this);
        zzk.zza();
        this.zzaUq = zzk;
        zzy zzf = com_google_android_gms_measurement_internal_zzx.zzf(this);
        zzf.zza();
        this.zzaUs = zzf;
        zzab zzo = com_google_android_gms_measurement_internal_zzx.zzo(this);
        zzo.zza();
        this.zzaUv = zzo;
        this.zzaUu = com_google_android_gms_measurement_internal_zzx.zzn(this);
        this.zzaUm = com_google_android_gms_measurement_internal_zzx.zze(this);
        zzs zzd = com_google_android_gms_measurement_internal_zzx.zzd(this);
        zzd.zza();
        this.zzaUl = zzd;
        if (this.zzaUy != this.zzaUz) {
            zzzz().zzBl().zze("Not all components initialized", Integer.valueOf(this.zzaUy), Integer.valueOf(this.zzaUz));
        }
        this.zzOQ = true;
        if (!(this.zzaUi.zzka() || zzBI())) {
            if (!(this.mContext.getApplicationContext() instanceof Application)) {
                zzzz().zzBm().zzez("Application context is not an Application");
            } else if (VERSION.SDK_INT >= 14) {
                zzBB().zzBR();
            } else {
                zzzz().zzBq().zzez("Not tracking deep linking pre-ICS");
            }
        }
        this.zzaUl.zzg(new C03831(this));
    }

    private boolean zzBJ() {
        zziS();
        return this.zzaUx != null;
    }

    private boolean zzBL() {
        return !TextUtils.isEmpty(zzBD().zzAY());
    }

    private void zzBM() {
        zziS();
        zzje();
        if (zzBz() && zzBL()) {
            long zzBN = zzBN();
            if (zzBN == 0) {
                zzBG().unregister();
                zzBH().cancel();
                return;
            } else if (zzBE().zzlk()) {
                long j = zzAW().zzaTH.get();
                long zzAL = zzAX().zzAL();
                if (!zzAU().zzc(j, zzAL)) {
                    zzBN = Math.max(zzBN, j + zzAL);
                }
                zzBG().unregister();
                zzBN -= zziT().currentTimeMillis();
                if (zzBN <= 0) {
                    zzBH().zzt(1);
                    return;
                }
                zzzz().zzBr().zzj("Upload scheduled in approximately ms", Long.valueOf(zzBN));
                zzBH().zzt(zzBN);
                return;
            } else {
                zzBG().zzlh();
                zzBH().cancel();
                return;
            }
        }
        zzBG().unregister();
        zzBH().cancel();
    }

    private long zzBN() {
        long currentTimeMillis = zziT().currentTimeMillis();
        long zzAO = zzAX().zzAO();
        long zzAM = zzAX().zzAM();
        long j = zzAW().zzaTF.get();
        long j2 = zzAW().zzaTG.get();
        long zzBb = zzBD().zzBb();
        if (zzBb == 0) {
            return 0;
        }
        currentTimeMillis -= Math.abs(zzBb - currentTimeMillis);
        zzAO += currentTimeMillis;
        if (!zzAU().zzc(j, zzAM)) {
            zzAO = j + zzAM;
        }
        if (j2 == 0 || j2 < currentTimeMillis) {
            return zzAO;
        }
        for (int i = 0; i < zzAX().zzAQ(); i++) {
            zzAO += ((long) (1 << i)) * zzAX().zzAP();
            if (zzAO > j2) {
                return zzAO;
            }
        }
        return 0;
    }

    private void zza(zzv com_google_android_gms_measurement_internal_zzv) {
        if (com_google_android_gms_measurement_internal_zzv == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private void zza(zzw com_google_android_gms_measurement_internal_zzw) {
        if (com_google_android_gms_measurement_internal_zzw == null) {
            throw new IllegalStateException("Component not created");
        } else if (!com_google_android_gms_measurement_internal_zzw.isInitialized()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    public static zzt zzaU(Context context) {
        zzx.zzy(context);
        zzx.zzy(context.getApplicationContext());
        if (zzaUh == null) {
            synchronized (zzt.class) {
                if (zzaUh == null) {
                    zzaUh = (zzaUg != null ? zzaUg : new zzx(context)).zzBQ();
                }
            }
        }
        return zzaUh;
    }

    private void zzb(int i, Throwable th, byte[] bArr) {
        int i2 = 0;
        zziS();
        zzje();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.zzaUx;
        this.zzaUx = null;
        if ((i == 200 || i == 204) && th == null) {
            zzAW().zzaTF.set(zziT().currentTimeMillis());
            zzAW().zzaTG.set(0);
            zzBM();
            zzzz().zzBr().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            zzBD().beginTransaction();
            try {
                for (Long longValue : list) {
                    zzBD().zzP(longValue.longValue());
                }
                zzBD().setTransactionSuccessful();
                if (zzBE().zzlk() && zzBL()) {
                    zzBK();
                } else {
                    zzBM();
                }
            } finally {
                zzBD().endTransaction();
            }
        } else {
            zzzz().zzBr().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzAW().zzaTG.set(zziT().currentTimeMillis());
            if (i == 503 || i == 429) {
                i2 = 1;
            }
            if (i2 != 0) {
                zzAW().zzaTH.set(zziT().currentTimeMillis());
            }
            zzBM();
        }
    }

    private void zze(AppMetadata appMetadata) {
        zziS();
        zzje();
        zzx.zzy(appMetadata);
        zzx.zzcG(appMetadata.packageName);
        zza zzew = zzBD().zzew(appMetadata.packageName);
        String zzBu = zzAW().zzBu();
        Object obj = null;
        if (zzew == null) {
            zzew = new zza(appMetadata.packageName, zzAW().zzBv(), appMetadata.zzaSn, zzBu, 0, 0, appMetadata.zzaKi, appMetadata.zzaSo, appMetadata.zzaSp, appMetadata.zzaSq, appMetadata.zzaSs);
            obj = 1;
        } else if (!zzBu.equals(zzew.zzaSg)) {
            zzew = zzew.zzJ(zzAW().zzBv(), zzBu);
            obj = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.zzaSn) || (appMetadata.zzaSn.equals(zzew.zzaSf) && appMetadata.zzaSp == zzew.zzaSk))) {
            zzew = zzew.zze(appMetadata.zzaSn, appMetadata.zzaSp);
            obj = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.zzaKi) || (appMetadata.zzaKi.equals(zzew.zzRl) && appMetadata.zzaSo.equals(zzew.zzaSj)))) {
            zzew = zzew.zzK(appMetadata.zzaKi, appMetadata.zzaSo);
            obj = 1;
        }
        if (appMetadata.zzaSq != zzew.zzaSl) {
            zzew = zzew.zzO(appMetadata.zzaSq);
            obj = 1;
        }
        if (appMetadata.zzaSs != zzew.zzaSm) {
            zzew = zzew.zzao(appMetadata.zzaSs);
            obj = 1;
        }
        if (obj != null) {
            zzBD().zza(zzew);
        }
    }

    private void zzx(List<Long> list) {
        zzx.zzab(!list.isEmpty());
        if (this.zzaUx != null) {
            zzzz().zzBl().zzez("Set uploading progress before finishing the previous upload");
        } else {
            this.zzaUx = new ArrayList(list);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    protected void start() {
        zziS();
        zzzz().zzBp().zzez("App measurement is starting up");
        zzzz().zzBq().zzez("Debug logging enabled");
        if (!zzBI() || (this.zzaUl.isInitialized() && !this.zzaUl.zzBP())) {
            zzBD().zzAZ();
            if (!zzBz()) {
                if (!zzAU().zzbh("android.permission.INTERNET")) {
                    zzzz().zzBl().zzez("App is missing INTERNET permission");
                }
                if (!zzAU().zzbh("android.permission.ACCESS_NETWORK_STATE")) {
                    zzzz().zzBl().zzez("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!AppMeasurementReceiver.zzX(getContext())) {
                    zzzz().zzBl().zzez("AppMeasurementReceiver not registered/enabled");
                }
                if (!AppMeasurementService.zzY(getContext())) {
                    zzzz().zzBl().zzez("AppMeasurementService not registered/enabled");
                }
                zzzz().zzBl().zzez("Uploading is not possible. App measurement disabled");
            } else if (!(zzAX().zzka() || zzBI() || TextUtils.isEmpty(zzAS().zzBi()))) {
                zzBB().zzBS();
            }
            zzBM();
            return;
        }
        zzzz().zzBl().zzez("Scheduler shutting down before Scion.start() called");
    }

    public zzm zzAS() {
        zza(this.zzaUt);
        return this.zzaUt;
    }

    public zzz zzAT() {
        zza(this.zzaUq);
        return this.zzaUq;
    }

    public zzae zzAU() {
        zza(this.zzaUn);
        return this.zzaUn;
    }

    public zzs zzAV() {
        zza(this.zzaUl);
        return this.zzaUl;
    }

    public zzr zzAW() {
        zza(this.zzaUj);
        return this.zzaUj;
    }

    public zzc zzAX() {
        return this.zzaUi;
    }

    zzs zzBA() {
        return this.zzaUl;
    }

    public zzy zzBB() {
        zza(this.zzaUs);
        return this.zzaUs;
    }

    public AppMeasurement zzBC() {
        return this.zzaUm;
    }

    public zzd zzBD() {
        zza(this.zzaUo);
        return this.zzaUo;
    }

    public zzp zzBE() {
        zza(this.zzaUp);
        return this.zzaUp;
    }

    public zzf zzBF() {
        zza(this.zzaUr);
        return this.zzaUr;
    }

    public zzq zzBG() {
        if (this.zzaUu != null) {
            return this.zzaUu;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public zzab zzBH() {
        zza(this.zzaUv);
        return this.zzaUv;
    }

    protected boolean zzBI() {
        return false;
    }

    public void zzBK() {
        int i = 0;
        zziS();
        zzje();
        if (!zzAX().zzka()) {
            Boolean zzBx = zzAW().zzBx();
            if (zzBx == null) {
                zzzz().zzBm().zzez("Upload data called on the client side before use of service was decided");
                return;
            } else if (zzBx.booleanValue()) {
                zzzz().zzBl().zzez("Upload called in the client side when service should be used");
                return;
            }
        }
        if (zzBJ()) {
            zzzz().zzBm().zzez("Uploading requested multiple times");
        } else if (zzBE().zzlk()) {
            long j = zzAW().zzaTF.get();
            if (j != 0) {
                zzzz().zzBq().zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(zziT().currentTimeMillis() - j)));
            }
            Object zzAY = zzBD().zzAY();
            if (!TextUtils.isEmpty(zzAY)) {
                List<Pair> zzn = zzBD().zzn(zzAY, zzAX().zzAI(), zzAX().zzAJ());
                if (!zzn.isEmpty()) {
                    zzd com_google_android_gms_internal_zzqq_zzd;
                    Object obj;
                    List subList;
                    for (Pair pair : zzn) {
                        com_google_android_gms_internal_zzqq_zzd = (zzd) pair.first;
                        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzqq_zzd.zzaVF)) {
                            obj = com_google_android_gms_internal_zzqq_zzd.zzaVF;
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        for (int i2 = 0; i2 < zzn.size(); i2++) {
                            com_google_android_gms_internal_zzqq_zzd = (zzd) ((Pair) zzn.get(i2)).first;
                            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzqq_zzd.zzaVF) && !com_google_android_gms_internal_zzqq_zzd.zzaVF.equals(obj)) {
                                subList = zzn.subList(0, i2);
                                break;
                            }
                        }
                    }
                    subList = zzn;
                    zzc com_google_android_gms_internal_zzqq_zzc = new zzc();
                    com_google_android_gms_internal_zzqq_zzc.zzaVp = new zzd[subList.size()];
                    List arrayList = new ArrayList(subList.size());
                    long currentTimeMillis = zziT().currentTimeMillis();
                    while (i < com_google_android_gms_internal_zzqq_zzc.zzaVp.length) {
                        com_google_android_gms_internal_zzqq_zzc.zzaVp[i] = (zzd) ((Pair) subList.get(i)).first;
                        arrayList.add(((Pair) subList.get(i)).second);
                        com_google_android_gms_internal_zzqq_zzc.zzaVp[i].zzaVE = Long.valueOf(zzAX().zzAE());
                        com_google_android_gms_internal_zzqq_zzc.zzaVp[i].zzaVu = Long.valueOf(currentTimeMillis);
                        com_google_android_gms_internal_zzqq_zzc.zzaVp[i].zzaVK = Boolean.valueOf(zzAX().zzka());
                        i++;
                    }
                    byte[] zza = zzAU().zza(com_google_android_gms_internal_zzqq_zzc);
                    String zzAK = zzAX().zzAK();
                    try {
                        URL url = new URL(zzAK);
                        zzx(arrayList);
                        zzAW().zzaTG.set(zziT().currentTimeMillis());
                        zzBE().zza(url, zza, new C07702(this));
                    } catch (MalformedURLException e) {
                        zzzz().zzBl().zzj("Failed to parse upload URL. Not uploading", zzAK);
                    }
                }
            }
        } else {
            zzzz().zzBm().zzez("Network not connected, ignoring upload request");
            zzBM();
        }
    }

    void zzBO() {
        this.zzaUz++;
    }

    protected boolean zzBz() {
        boolean z = true;
        zzje();
        zziS();
        if (this.zzaUw == null) {
            boolean z2 = zzAU().zzbh("android.permission.INTERNET") && zzAU().zzbh("android.permission.ACCESS_NETWORK_STATE") && AppMeasurementReceiver.zzX(getContext()) && AppMeasurementService.zzY(getContext());
            this.zzaUw = Boolean.valueOf(z2);
            if (this.zzaUw.booleanValue() && !zzAX().zzka()) {
                if (TextUtils.isEmpty(zzAS().zzBi())) {
                    z = false;
                }
                this.zzaUw = Boolean.valueOf(z);
            }
        }
        return this.zzaUw.booleanValue();
    }

    public void zzJ(boolean z) {
        zzBM();
    }

    zzd zza(zzg[] com_google_android_gms_measurement_internal_zzgArr, AppMetadata appMetadata) {
        int i;
        zzx.zzy(appMetadata);
        zzx.zzy(com_google_android_gms_measurement_internal_zzgArr);
        zziS();
        zzd com_google_android_gms_internal_zzqq_zzd = new zzd();
        com_google_android_gms_internal_zzqq_zzd.zzaVr = Integer.valueOf(1);
        com_google_android_gms_internal_zzqq_zzd.zzaVz = "android";
        com_google_android_gms_internal_zzqq_zzd.appId = appMetadata.packageName;
        com_google_android_gms_internal_zzqq_zzd.zzaSo = appMetadata.zzaSo;
        com_google_android_gms_internal_zzqq_zzd.zzaKi = appMetadata.zzaKi;
        com_google_android_gms_internal_zzqq_zzd.zzaVD = Long.valueOf(appMetadata.zzaSp);
        com_google_android_gms_internal_zzqq_zzd.zzaSn = appMetadata.zzaSn;
        com_google_android_gms_internal_zzqq_zzd.zzaVI = appMetadata.zzaSq == 0 ? null : Long.valueOf(appMetadata.zzaSq);
        Pair zzBt = zzAW().zzBt();
        if (!(zzBt == null || zzBt.first == null || zzBt.second == null)) {
            com_google_android_gms_internal_zzqq_zzd.zzaVF = (String) zzBt.first;
            com_google_android_gms_internal_zzqq_zzd.zzaVG = (Boolean) zzBt.second;
        }
        com_google_android_gms_internal_zzqq_zzd.zzaVA = zzBF().zzhb();
        com_google_android_gms_internal_zzqq_zzd.osVersion = zzBF().zzBe();
        com_google_android_gms_internal_zzqq_zzd.zzaVC = Integer.valueOf((int) zzBF().zzBf());
        com_google_android_gms_internal_zzqq_zzd.zzaVB = zzBF().zzBg();
        com_google_android_gms_internal_zzqq_zzd.zzaVE = null;
        com_google_android_gms_internal_zzqq_zzd.zzaVu = null;
        com_google_android_gms_internal_zzqq_zzd.zzaVv = Long.valueOf(com_google_android_gms_measurement_internal_zzgArr[0].zzacS);
        com_google_android_gms_internal_zzqq_zzd.zzaVw = Long.valueOf(com_google_android_gms_measurement_internal_zzgArr[0].zzacS);
        for (int i2 = 1; i2 < com_google_android_gms_measurement_internal_zzgArr.length; i2++) {
            com_google_android_gms_internal_zzqq_zzd.zzaVv = Long.valueOf(Math.min(com_google_android_gms_internal_zzqq_zzd.zzaVv.longValue(), com_google_android_gms_measurement_internal_zzgArr[i2].zzacS));
            com_google_android_gms_internal_zzqq_zzd.zzaVw = Long.valueOf(Math.max(com_google_android_gms_internal_zzqq_zzd.zzaVw.longValue(), com_google_android_gms_measurement_internal_zzgArr[i2].zzacS));
        }
        zza zzew = zzBD().zzew(appMetadata.packageName);
        if (zzew == null) {
            zzew = new zza(appMetadata.packageName, zzAW().zzBv(), appMetadata.zzaSn, zzAW().zzBu(), 0, 0, appMetadata.zzaKi, appMetadata.zzaSo, appMetadata.zzaSp, appMetadata.zzaSq, appMetadata.zzaSs);
        }
        zza zza = zzew.zza(zzzz(), com_google_android_gms_internal_zzqq_zzd.zzaVw.longValue());
        zzBD().zza(zza);
        com_google_android_gms_internal_zzqq_zzd.zzaVH = zza.zzaSe;
        com_google_android_gms_internal_zzqq_zzd.zzaVJ = Integer.valueOf((int) zza.zzaSh);
        com_google_android_gms_internal_zzqq_zzd.zzaVy = zzew.zzaSi == 0 ? null : Long.valueOf(zzew.zzaSi);
        com_google_android_gms_internal_zzqq_zzd.zzaVx = com_google_android_gms_internal_zzqq_zzd.zzaVy;
        List zzev = zzBD().zzev(appMetadata.packageName);
        com_google_android_gms_internal_zzqq_zzd.zzaVt = new zze[zzev.size()];
        for (i = 0; i < zzev.size(); i++) {
            zze com_google_android_gms_internal_zzqq_zze = new zze();
            com_google_android_gms_internal_zzqq_zzd.zzaVt[i] = com_google_android_gms_internal_zzqq_zze;
            com_google_android_gms_internal_zzqq_zze.name = ((zzac) zzev.get(i)).mName;
            com_google_android_gms_internal_zzqq_zze.zzaVM = Long.valueOf(((zzac) zzev.get(i)).zzaVf);
            zzAU().zza(com_google_android_gms_internal_zzqq_zze, ((zzac) zzev.get(i)).zzLI);
        }
        com_google_android_gms_internal_zzqq_zzd.zzaVs = new zza[com_google_android_gms_measurement_internal_zzgArr.length];
        for (i = 0; i < com_google_android_gms_measurement_internal_zzgArr.length; i++) {
            zza com_google_android_gms_internal_zzqq_zza = new zza();
            com_google_android_gms_internal_zzqq_zzd.zzaVs[i] = com_google_android_gms_internal_zzqq_zza;
            com_google_android_gms_internal_zzqq_zza.name = com_google_android_gms_measurement_internal_zzgArr[i].mName;
            com_google_android_gms_internal_zzqq_zza.zzaVl = Long.valueOf(com_google_android_gms_measurement_internal_zzgArr[i].zzacS);
            com_google_android_gms_internal_zzqq_zza.zzaVk = new zzb[com_google_android_gms_measurement_internal_zzgArr[i].zzaSE.size()];
            Iterator it = com_google_android_gms_measurement_internal_zzgArr[i].zzaSE.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                String str = (String) it.next();
                zzb com_google_android_gms_internal_zzqq_zzb = new zzb();
                int i4 = i3 + 1;
                com_google_android_gms_internal_zzqq_zza.zzaVk[i3] = com_google_android_gms_internal_zzqq_zzb;
                com_google_android_gms_internal_zzqq_zzb.name = str;
                zzAU().zza(com_google_android_gms_internal_zzqq_zzb, com_google_android_gms_measurement_internal_zzgArr[i].zzaSE.get(str));
                i3 = i4;
            }
        }
        com_google_android_gms_internal_zzqq_zzd.zzaSr = zzzz().zzBs();
        return com_google_android_gms_internal_zzqq_zzd;
    }

    void zza(EventParcel eventParcel, String str) {
        zza zzew = zzBD().zzew(str);
        if (zzew == null || TextUtils.isEmpty(zzew.zzRl)) {
            zzzz().zzBq().zzj("No app data available; dropping event", str);
            return;
        }
        zzb(eventParcel, new AppMetadata(str, zzew.zzaSf, zzew.zzRl, zzew.zzaSj, zzew.zzaSk, zzew.zzaSl, null, zzew.zzaSm));
    }

    void zzb(EventParcel eventParcel, AppMetadata appMetadata) {
        zziS();
        zzje();
        zzx.zzcG(appMetadata.packageName);
        if (!TextUtils.isEmpty(appMetadata.zzaSn)) {
            zzzz().zzBr().zzj("Logging event", eventParcel);
            Object com_google_android_gms_measurement_internal_zzg = new zzg(this, eventParcel.zzaSM, appMetadata.packageName, eventParcel.name, eventParcel.zzaSN, 0, eventParcel.zzaSL.zzBh());
            zzBD().beginTransaction();
            try {
                zzh com_google_android_gms_measurement_internal_zzh;
                zze(appMetadata);
                zzh zzL = zzBD().zzL(appMetadata.packageName, com_google_android_gms_measurement_internal_zzg.mName);
                if (zzL == null) {
                    com_google_android_gms_measurement_internal_zzh = new zzh(appMetadata.packageName, com_google_android_gms_measurement_internal_zzg.mName, 1, 1, com_google_android_gms_measurement_internal_zzg.zzacS);
                } else {
                    com_google_android_gms_measurement_internal_zzg = com_google_android_gms_measurement_internal_zzg.zza(this, zzL.zzaSH);
                    com_google_android_gms_measurement_internal_zzh = zzL.zzQ(com_google_android_gms_measurement_internal_zzg.zzacS);
                }
                zzBD().zza(com_google_android_gms_measurement_internal_zzh);
                zzBD().zza(zza(new zzg[]{com_google_android_gms_measurement_internal_zzg}, appMetadata));
                zzBD().setTransactionSuccessful();
                zzzz().zzBq().zzj("Event logged", com_google_android_gms_measurement_internal_zzg);
                zzBM();
            } finally {
                zzBD().endTransaction();
            }
        }
    }

    void zzb(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zziS();
        zzje();
        if (!TextUtils.isEmpty(appMetadata.zzaSn)) {
            zzAU().zzeF(userAttributeParcel.name);
            Object zzm = zzAU().zzm(userAttributeParcel.name, userAttributeParcel.getValue());
            if (zzm != null) {
                zzac com_google_android_gms_measurement_internal_zzac = new zzac(appMetadata.packageName, userAttributeParcel.name, userAttributeParcel.zzaVg, zzm);
                zzzz().zzBq().zze("Setting user attribute", com_google_android_gms_measurement_internal_zzac.mName, zzm);
                zzBD().beginTransaction();
                try {
                    zze(appMetadata);
                    zzBD().zza(com_google_android_gms_measurement_internal_zzac);
                    zzBD().setTransactionSuccessful();
                    zzzz().zzBq().zze("User attribute set", com_google_android_gms_measurement_internal_zzac.mName, com_google_android_gms_measurement_internal_zzac.zzLI);
                } finally {
                    zzBD().endTransaction();
                }
            }
        }
    }

    void zzb(zzw com_google_android_gms_measurement_internal_zzw) {
        this.zzaUy++;
    }

    void zzc(AppMetadata appMetadata) {
        zziS();
        zzje();
        zzx.zzcG(appMetadata.packageName);
        zze(appMetadata);
    }

    void zzc(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zziS();
        zzje();
        if (!TextUtils.isEmpty(appMetadata.zzaSn)) {
            zzzz().zzBq().zzj("Removing user attribute", userAttributeParcel.name);
            zzBD().beginTransaction();
            try {
                zze(appMetadata);
                zzBD().zzM(appMetadata.packageName, userAttributeParcel.name);
                zzBD().setTransactionSuccessful();
                zzzz().zzBq().zzj("User attribute removed", userAttributeParcel.name);
            } finally {
                zzBD().endTransaction();
            }
        }
    }

    public void zzd(AppMetadata appMetadata) {
        zziS();
        zzje();
        zzx.zzy(appMetadata);
        zzx.zzcG(appMetadata.packageName);
        if (!TextUtils.isEmpty(appMetadata.zzaSn)) {
            zze(appMetadata);
            if (zzBD().zzL(appMetadata.packageName, "_f") == null) {
                long currentTimeMillis = zziT().currentTimeMillis();
                zzb(new UserAttributeParcel("_fot", currentTimeMillis, Long.valueOf(3600000 * ((currentTimeMillis / 3600000) + 1)), "auto"), appMetadata);
                Bundle bundle = new Bundle();
                bundle.putLong("_c", 1);
                zzb(new EventParcel("_f", new EventParams(bundle), "auto", currentTimeMillis), appMetadata);
            }
        }
    }

    void zziR() {
        if (zzAX().zzka()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    public void zziS() {
        zzAV().zziS();
    }

    public zznl zziT() {
        return this.zzqD;
    }

    void zzje() {
        if (!this.zzOQ) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    public zzo zzzz() {
        zza(this.zzaUk);
        return this.zzaUk;
    }
}
