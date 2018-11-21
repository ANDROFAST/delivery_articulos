package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzer.zza;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public final class zzeq implements zza {
    private final Context mContext;
    private final String zzBd;
    private final long zzBe;
    private final zzen zzBf;
    private final zzem zzBg;
    private final AdSizeParcel zzBh;
    private zzex zzBi;
    private int zzBj = -2;
    private zzez zzBk;
    private final NativeAdOptionsParcel zzpE;
    private final List<String> zzpF;
    private final VersionInfoParcel zzpI;
    private final Object zzpK = new Object();
    private final zzew zzpd;
    private final AdRequestParcel zzqo;
    private final boolean zzrF;

    public zzeq(Context context, String str, zzew com_google_android_gms_internal_zzew, zzen com_google_android_gms_internal_zzen, zzem com_google_android_gms_internal_zzem, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, VersionInfoParcel versionInfoParcel, boolean z, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
        this.mContext = context;
        this.zzpd = com_google_android_gms_internal_zzew;
        this.zzBg = com_google_android_gms_internal_zzem;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.zzBd = zzen();
        } else {
            this.zzBd = str;
        }
        this.zzBf = com_google_android_gms_internal_zzen;
        this.zzBe = com_google_android_gms_internal_zzen.zzAP != -1 ? com_google_android_gms_internal_zzen.zzAP : 10000;
        this.zzqo = adRequestParcel;
        this.zzBh = adSizeParcel;
        this.zzpI = versionInfoParcel;
        this.zzrF = z;
        this.zzpE = nativeAdOptionsParcel;
        this.zzpF = list;
    }

    private void zza(long j, long j2, long j3, long j4) {
        while (this.zzBj == -2) {
            zzb(j, j2, j3, j4);
        }
    }

    private void zza(zzep com_google_android_gms_internal_zzep) {
        if ("com.google.ads.mediation.AdUrlAdapter".equals(this.zzBd)) {
            Bundle bundle = this.zzqo.zztA.getBundle(this.zzBd);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("sdk_less_network_id", this.zzBg.zzAF);
            this.zzqo.zztA.putBundle(this.zzBd, bundle);
        }
        String zzae = zzae(this.zzBg.zzAL);
        try {
            if (this.zzpI.zzLG < 4100000) {
                if (this.zzBh.zztW) {
                    this.zzBi.zza(zze.zzB(this.mContext), this.zzqo, zzae, com_google_android_gms_internal_zzep);
                } else {
                    this.zzBi.zza(zze.zzB(this.mContext), this.zzBh, this.zzqo, zzae, (zzey) com_google_android_gms_internal_zzep);
                }
            } else if (this.zzrF) {
                this.zzBi.zza(zze.zzB(this.mContext), this.zzqo, zzae, this.zzBg.zzAE, com_google_android_gms_internal_zzep, this.zzpE, this.zzpF);
            } else if (this.zzBh.zztW) {
                this.zzBi.zza(zze.zzB(this.mContext), this.zzqo, zzae, this.zzBg.zzAE, (zzey) com_google_android_gms_internal_zzep);
            } else {
                this.zzBi.zza(zze.zzB(this.mContext), this.zzBh, this.zzqo, zzae, this.zzBg.zzAE, com_google_android_gms_internal_zzep);
            }
        } catch (Throwable e) {
            zzb.zzd("Could not request ad from mediation adapter.", e);
            zzr(5);
        }
    }

    private String zzae(String str) {
        if (!(str == null || !zzeq() || zzs(2))) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.remove("cpm_floor_cents");
                str = jSONObject.toString();
            } catch (JSONException e) {
                zzb.zzaH("Could not remove field. Returning the original value");
            }
        }
        return str;
    }

    private void zzb(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            zzb.zzaG("Timed out waiting for adapter.");
            this.zzBj = 3;
            return;
        }
        try {
            this.zzpK.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.zzBj = -1;
        }
    }

    private String zzen() {
        try {
            if (!TextUtils.isEmpty(this.zzBg.zzAI)) {
                return this.zzpd.zzag(this.zzBg.zzAI) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException e) {
            zzb.zzaH("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private zzez zzeo() {
        if (this.zzBj != 0 || !zzeq()) {
            return null;
        }
        try {
            if (!(!zzs(4) || this.zzBk == null || this.zzBk.zzes() == 0)) {
                return this.zzBk;
            }
        } catch (RemoteException e) {
            zzb.zzaH("Could not get cpm value from MediationResponseMetadata");
        }
        return zzt(zzer());
    }

    private zzex zzep() {
        zzb.zzaG("Instantiating mediation adapter: " + this.zzBd);
        if (((Boolean) zzbz.zzwA.get()).booleanValue()) {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzBd)) {
                return new zzfd(new AdMobAdapter());
            }
            if ("com.google.ads.mediation.AdUrlAdapter".equals(this.zzBd)) {
                return new zzfd(new AdUrlAdapter());
            }
        }
        try {
            return this.zzpd.zzaf(this.zzBd);
        } catch (Throwable e) {
            zzb.zza("Could not instantiate mediation adapter: " + this.zzBd, e);
            return null;
        }
    }

    private boolean zzeq() {
        return this.zzBf.zzAX != -1;
    }

    private int zzer() {
        if (this.zzBg.zzAL == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.zzBg.zzAL);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzBd)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int optInt = zzs(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return optInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : optInt;
        } catch (JSONException e) {
            zzb.zzaH("Could not convert to json. Returning 0");
            return 0;
        }
    }

    private boolean zzs(int i) {
        try {
            Bundle zzex = this.zzrF ? this.zzBi.zzex() : this.zzBh.zztW ? this.zzBi.getInterstitialAdapterInfo() : this.zzBi.zzew();
            if (zzex == null) {
                return false;
            }
            return (zzex.getInt("capabilities", 0) & i) == i;
        } catch (RemoteException e) {
            zzb.zzaH("Could not get adapter info. Returning false");
            return false;
        }
    }

    private static zzez zzt(final int i) {
        return new zzez.zza() {
            public int zzes() throws RemoteException {
                return i;
            }
        };
    }

    public void cancel() {
        synchronized (this.zzpK) {
            try {
                if (this.zzBi != null) {
                    this.zzBi.destroy();
                }
            } catch (Throwable e) {
                zzb.zzd("Could not destroy mediation adapter.", e);
            }
            this.zzBj = -1;
            this.zzpK.notify();
        }
    }

    public zzer zza(long j, long j2) {
        zzer com_google_android_gms_internal_zzer;
        synchronized (this.zzpK) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final zzep com_google_android_gms_internal_zzep = new zzep();
            zzip.zzKO.post(new Runnable(this) {
                final /* synthetic */ zzeq zzBm;

                public void run() {
                    synchronized (this.zzBm.zzpK) {
                        if (this.zzBm.zzBj != -2) {
                            return;
                        }
                        this.zzBm.zzBi = this.zzBm.zzep();
                        if (this.zzBm.zzBi == null) {
                            this.zzBm.zzr(4);
                        } else if (!this.zzBm.zzeq() || this.zzBm.zzs(1)) {
                            com_google_android_gms_internal_zzep.zza(this.zzBm);
                            this.zzBm.zza(com_google_android_gms_internal_zzep);
                        } else {
                            zzb.zzaH("Ignoring adapter " + this.zzBm.zzBd + " as delayed" + " impression is not supported");
                            this.zzBm.zzr(2);
                        }
                    }
                }
            });
            zza(elapsedRealtime, this.zzBe, j, j2);
            com_google_android_gms_internal_zzer = new zzer(this.zzBg, this.zzBi, this.zzBd, com_google_android_gms_internal_zzep, this.zzBj, zzeo());
        }
        return com_google_android_gms_internal_zzer;
    }

    public void zza(int i, zzez com_google_android_gms_internal_zzez) {
        synchronized (this.zzpK) {
            this.zzBj = i;
            this.zzBk = com_google_android_gms_internal_zzez;
            this.zzpK.notify();
        }
    }

    public void zzr(int i) {
        synchronized (this.zzpK) {
            this.zzBj = i;
            this.zzpK.notify();
        }
    }
}
