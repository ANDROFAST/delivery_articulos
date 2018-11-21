package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzbe;
import com.google.android.gms.internal.zzbs;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzdm;
import com.google.android.gms.internal.zzdq;
import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzei.zzd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhd;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzjn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzm extends zzil {
    static final long zzHl = TimeUnit.SECONDS.toMillis(10);
    private static boolean zzHm = false;
    private static zzei zzHn = null;
    private static zzdm zzHo = null;
    private static zzdq zzHp = null;
    private static zzdl zzHq = null;
    private static final Object zzqf = new Object();
    private final Context mContext;
    private final Object zzFf = new Object();
    private final com.google.android.gms.ads.internal.request.zza.zza zzGd;
    private final com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza zzGe;
    private zzd zzHr;

    class C01643 implements Runnable {
        final /* synthetic */ zzm zzHs;

        C01643(zzm com_google_android_gms_ads_internal_request_zzm) {
            this.zzHs = com_google_android_gms_ads_internal_request_zzm;
        }

        public void run() {
            if (this.zzHs.zzHr != null) {
                this.zzHs.zzHr.release();
                this.zzHs.zzHr = null;
            }
        }
    }

    public static class zza implements com.google.android.gms.internal.zzei.zzb<zzbb> {
        public void zza(zzbb com_google_android_gms_internal_zzbb) {
            zzm.zzd(com_google_android_gms_internal_zzbb);
        }

        public /* synthetic */ void zzc(Object obj) {
            zza((zzbb) obj);
        }
    }

    public static class zzb implements com.google.android.gms.internal.zzei.zzb<zzbb> {
        public void zza(zzbb com_google_android_gms_internal_zzbb) {
            zzm.zzc(com_google_android_gms_internal_zzbb);
        }

        public /* synthetic */ void zzc(Object obj) {
            zza((zzbb) obj);
        }
    }

    public static class zzc implements zzdl {
        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            String str = (String) map.get("request_id");
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Invalid request: " + ((String) map.get("errors")));
            zzm.zzHp.zzX(str);
        }
    }

    public zzm(Context context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza, com.google.android.gms.ads.internal.request.zza.zza com_google_android_gms_ads_internal_request_zza_zza) {
        super(true);
        this.zzGd = com_google_android_gms_ads_internal_request_zza_zza;
        this.mContext = context;
        this.zzGe = com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza;
        synchronized (zzqf) {
            if (!zzHm) {
                zzHp = new zzdq();
                zzHo = new zzdm(context.getApplicationContext(), com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzqR);
                zzHq = new zzc();
                zzHn = new zzei(this.mContext.getApplicationContext(), this.zzGe.zzqR, (String) zzbz.zzvg.get(), new zzb(), new zza());
                zzHm = true;
            }
        }
    }

    private JSONObject zza(AdRequestInfoParcel adRequestInfoParcel, String str) {
        Throwable e;
        Object obj;
        Map hashMap;
        JSONObject jSONObject = null;
        Bundle bundle = adRequestInfoParcel.zzGq.extras.getBundle("sdk_less_server_data");
        String string = adRequestInfoParcel.zzGq.extras.getString("sdk_less_network_id");
        if (bundle != null) {
            JSONObject zza = zzhd.zza(this.mContext, adRequestInfoParcel, zzp.zzbD().zzE(this.mContext), jSONObject, jSONObject, new zzbs((String) zzbz.zzvg.get()), jSONObject, jSONObject, new ArrayList(), jSONObject);
            if (zza != null) {
                Info advertisingIdInfo;
                try {
                    advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
                } catch (IOException e2) {
                    e = e2;
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", zza);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzp.zzbx().zzz(hashMap);
                    return jSONObject;
                } catch (IllegalStateException e3) {
                    e = e3;
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", zza);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        }
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzp.zzbx().zzz(hashMap);
                    return jSONObject;
                } catch (GooglePlayServicesNotAvailableException e4) {
                    e = e4;
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", zza);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        }
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzp.zzbx().zzz(hashMap);
                    return jSONObject;
                } catch (GooglePlayServicesRepairableException e5) {
                    e = e5;
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Cannot get advertising id info", e);
                    obj = jSONObject;
                    hashMap = new HashMap();
                    hashMap.put("request_id", str);
                    hashMap.put("network_id", string);
                    hashMap.put("request_param", zza);
                    hashMap.put("data", bundle);
                    if (advertisingIdInfo != null) {
                        hashMap.put("adid", advertisingIdInfo.getId());
                        if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        }
                        hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                    }
                    jSONObject = zzp.zzbx().zzz(hashMap);
                    return jSONObject;
                }
                hashMap = new HashMap();
                hashMap.put("request_id", str);
                hashMap.put("network_id", string);
                hashMap.put("request_param", zza);
                hashMap.put("data", bundle);
                if (advertisingIdInfo != null) {
                    hashMap.put("adid", advertisingIdInfo.getId());
                    if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                    }
                    hashMap.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 0 : 1));
                }
                try {
                    jSONObject = zzp.zzbx().zzz(hashMap);
                } catch (JSONException e6) {
                }
            }
        }
        return jSONObject;
    }

    protected static void zzc(zzbb com_google_android_gms_internal_zzbb) {
        com_google_android_gms_internal_zzbb.zza("/loadAd", zzHp);
        com_google_android_gms_internal_zzbb.zza("/fetchHttpRequest", zzHo);
        com_google_android_gms_internal_zzbb.zza("/invalidRequest", zzHq);
    }

    protected static void zzd(zzbb com_google_android_gms_internal_zzbb) {
        com_google_android_gms_internal_zzbb.zzb("/loadAd", zzHp);
        com_google_android_gms_internal_zzbb.zzb("/fetchHttpRequest", zzHo);
        com_google_android_gms_internal_zzbb.zzb("/invalidRequest", zzHq);
    }

    private AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) {
        final String uuid = UUID.randomUUID().toString();
        final JSONObject zza = zza(adRequestInfoParcel, uuid);
        if (zza == null) {
            return new AdResponseParcel(0);
        }
        long elapsedRealtime = zzp.zzbB().elapsedRealtime();
        Future zzW = zzHp.zzW(uuid);
        com.google.android.gms.ads.internal.util.client.zza.zzLE.post(new Runnable(this) {
            final /* synthetic */ zzm zzHs;

            class C06151 implements com.google.android.gms.internal.zzjg.zzc<zzbe> {
                final /* synthetic */ C01632 zzHv;

                C06151(C01632 c01632) {
                    this.zzHv = c01632;
                }

                public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                    try {
                        com_google_android_gms_internal_zzbe.zza("AFMA_getAdapterLessMediationAd", zza);
                    } catch (Throwable e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", e);
                        zzm.zzHp.zzX(uuid);
                    }
                }

                public /* synthetic */ void zzc(Object obj) {
                    zzb((zzbe) obj);
                }
            }

            class C06162 implements com.google.android.gms.internal.zzjg.zza {
                final /* synthetic */ C01632 zzHv;

                C06162(C01632 c01632) {
                    this.zzHv = c01632;
                }

                public void run() {
                    zzm.zzHp.zzX(uuid);
                }
            }

            public void run() {
                this.zzHs.zzHr = zzm.zzHn.zzei();
                this.zzHs.zzHr.zza(new C06151(this), new C06162(this));
            }
        });
        try {
            JSONObject jSONObject = (JSONObject) zzW.get(zzHl - (zzp.zzbB().elapsedRealtime() - elapsedRealtime), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new AdResponseParcel(-1);
            }
            AdResponseParcel zza2 = zzhd.zza(this.mContext, adRequestInfoParcel, jSONObject.toString());
            return (zza2.errorCode == -3 || !TextUtils.isEmpty(zza2.body)) ? zza2 : new AdResponseParcel(3);
        } catch (CancellationException e) {
            return new AdResponseParcel(-1);
        } catch (InterruptedException e2) {
            return new AdResponseParcel(-1);
        } catch (TimeoutException e3) {
            return new AdResponseParcel(2);
        } catch (ExecutionException e4) {
            return new AdResponseParcel(0);
        }
    }

    public void onStop() {
        synchronized (this.zzFf) {
            com.google.android.gms.ads.internal.util.client.zza.zzLE.post(new C01643(this));
        }
    }

    public void zzbp() {
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("SdkLessAdLoaderBackgroundTask started.");
        AdRequestInfoParcel adRequestInfoParcel = new AdRequestInfoParcel(this.zzGe, null, -1);
        AdResponseParcel zze = zze(adRequestInfoParcel);
        AdSizeParcel adSizeParcel = null;
        final com.google.android.gms.internal.zzie.zza com_google_android_gms_internal_zzie_zza = new com.google.android.gms.internal.zzie.zza(adRequestInfoParcel, zze, null, adSizeParcel, zze.errorCode, zzp.zzbB().elapsedRealtime(), zze.zzGR, null);
        com.google.android.gms.ads.internal.util.client.zza.zzLE.post(new Runnable(this) {
            final /* synthetic */ zzm zzHs;

            public void run() {
                this.zzHs.zzGd.zza(com_google_android_gms_internal_zzie_zza);
                if (this.zzHs.zzHr != null) {
                    this.zzHs.zzHr.release();
                    this.zzHs.zzHr = null;
                }
            }
        });
    }
}
