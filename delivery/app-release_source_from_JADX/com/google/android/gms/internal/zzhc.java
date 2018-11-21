package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzj.zza;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzei.zzb;
import com.google.android.gms.internal.zzei.zzc;
import com.google.android.gms.internal.zzei.zzd;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public final class zzhc extends zza {
    private static zzhc zzHF;
    private static final Object zzqf = new Object();
    private final Context mContext;
    private final zzhb zzHG;
    private final zzbs zzHH;
    private final zzei zzrO;

    class C07246 implements zzb<zzbb> {
        final /* synthetic */ zzhc zzHS;

        C07246(zzhc com_google_android_gms_internal_zzhc) {
            this.zzHS = com_google_android_gms_internal_zzhc;
        }

        public void zza(zzbb com_google_android_gms_internal_zzbb) {
            com_google_android_gms_internal_zzbb.zza("/log", zzdk.zzyG);
        }

        public /* synthetic */ void zzc(Object obj) {
            zza((zzbb) obj);
        }
    }

    zzhc(Context context, zzbs com_google_android_gms_internal_zzbs, zzhb com_google_android_gms_internal_zzhb) {
        this.mContext = context;
        this.zzHG = com_google_android_gms_internal_zzhb;
        this.zzHH = com_google_android_gms_internal_zzbs;
        this.zzrO = new zzei(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(8298000, 8298000, true), com_google_android_gms_internal_zzbs.zzdj(), new C07246(this), new zzc());
    }

    private static AdResponseParcel zza(Context context, zzei com_google_android_gms_internal_zzei, zzbs com_google_android_gms_internal_zzbs, zzhb com_google_android_gms_internal_zzhb, AdRequestInfoParcel adRequestInfoParcel) {
        Bundle bundle;
        Future future;
        Throwable e;
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Starting ad request from service.");
        zzbz.initialize(context);
        final zzch com_google_android_gms_internal_zzch = new zzch(((Boolean) zzbz.zzvL.get()).booleanValue(), "load_ad", adRequestInfoParcel.zzqV.zztV);
        if (adRequestInfoParcel.versionCode > 10 && adRequestInfoParcel.zzGI != -1) {
            com_google_android_gms_internal_zzch.zza(com_google_android_gms_internal_zzch.zzb(adRequestInfoParcel.zzGI), "cts");
        }
        zzcf zzdu = com_google_android_gms_internal_zzch.zzdu();
        Bundle bundle2 = (adRequestInfoParcel.versionCode < 4 || adRequestInfoParcel.zzGx == null) ? null : adRequestInfoParcel.zzGx;
        if (!((Boolean) zzbz.zzvU.get()).booleanValue() || com_google_android_gms_internal_zzhb.zzHE == null) {
            bundle = bundle2;
            future = null;
        } else {
            if (bundle2 == null && ((Boolean) zzbz.zzvV.get()).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.m7v("contentInfo is not present, but we'll still launch the app index task");
                bundle2 = new Bundle();
            }
            if (bundle2 != null) {
                final zzhb com_google_android_gms_internal_zzhb2 = com_google_android_gms_internal_zzhb;
                final Context context2 = context;
                final AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
                bundle = bundle2;
                future = zzio.zza(new Callable<Void>() {
                    public /* synthetic */ Object call() throws Exception {
                        return zzdm();
                    }

                    public Void zzdm() throws Exception {
                        com_google_android_gms_internal_zzhb2.zzHE.zza(context2, adRequestInfoParcel2.zzGr.packageName, bundle2);
                        return null;
                    }
                });
            } else {
                bundle = bundle2;
                future = null;
            }
        }
        com_google_android_gms_internal_zzhb.zzHz.init();
        zzhi zzE = zzp.zzbD().zzE(context);
        if (zzE.zzIM == -1) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Device is offline.");
            return new AdResponseParcel(2);
        }
        String uuid = adRequestInfoParcel.versionCode >= 7 ? adRequestInfoParcel.zzGF : UUID.randomUUID().toString();
        final zzhe com_google_android_gms_internal_zzhe = new zzhe(uuid, adRequestInfoParcel.applicationInfo.packageName);
        if (adRequestInfoParcel.zzGq.extras != null) {
            String string = adRequestInfoParcel.zzGq.extras.getString("_ad");
            if (string != null) {
                return zzhd.zza(context, adRequestInfoParcel, string);
            }
        }
        Location zzd = com_google_android_gms_internal_zzhb.zzHz.zzd(250);
        String token = com_google_android_gms_internal_zzhb.zzHA.getToken(context, adRequestInfoParcel.zzqP, adRequestInfoParcel.zzGr.packageName);
        List zza = com_google_android_gms_internal_zzhb.zzHx.zza(adRequestInfoParcel);
        String zzf = com_google_android_gms_internal_zzhb.zzHB.zzf(adRequestInfoParcel);
        zzhm.zza zzF = com_google_android_gms_internal_zzhb.zzHC.zzF(context);
        if (future != null) {
            try {
                com.google.android.gms.ads.internal.util.client.zzb.m7v("Waiting for app index fetching task.");
                future.get(((Long) zzbz.zzvW.get()).longValue(), TimeUnit.MILLISECONDS);
                com.google.android.gms.ads.internal.util.client.zzb.m7v("App index fetching task completed.");
            } catch (ExecutionException e2) {
                e = e2;
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to fetch app index signal", e);
            } catch (InterruptedException e3) {
                e = e3;
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to fetch app index signal", e);
            } catch (TimeoutException e4) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaF("Timed out waiting for app index fetching task");
            }
        }
        JSONObject zza2 = zzhd.zza(context, adRequestInfoParcel, zzE, zzF, zzd, com_google_android_gms_internal_zzbs, token, zzf, zza, bundle);
        if (adRequestInfoParcel.versionCode < 7) {
            try {
                zza2.put("request_id", uuid);
            } catch (JSONException e5) {
            }
        }
        if (zza2 == null) {
            return new AdResponseParcel(0);
        }
        final String jSONObject = zza2.toString();
        com_google_android_gms_internal_zzch.zza(zzdu, "arc");
        final zzcf zzdu2 = com_google_android_gms_internal_zzch.zzdu();
        if (((Boolean) zzbz.zzvh.get()).booleanValue()) {
            final zzei com_google_android_gms_internal_zzei2 = com_google_android_gms_internal_zzei;
            final zzhe com_google_android_gms_internal_zzhe2 = com_google_android_gms_internal_zzhe;
            final zzch com_google_android_gms_internal_zzch2 = com_google_android_gms_internal_zzch;
            zzip.zzKO.post(new Runnable() {

                class C07222 implements zzjg.zza {
                    final /* synthetic */ C03212 zzHQ;

                    C07222(C03212 c03212) {
                        this.zzHQ = c03212;
                    }

                    public void run() {
                    }
                }

                public void run() {
                    zzd zzei = com_google_android_gms_internal_zzei2.zzei();
                    com_google_android_gms_internal_zzhe2.zzb(zzei);
                    com_google_android_gms_internal_zzch2.zza(zzdu2, "rwc");
                    final zzcf zzdu = com_google_android_gms_internal_zzch2.zzdu();
                    zzei.zza(new zzjg.zzc<zzbe>(this) {
                        final /* synthetic */ C03212 zzHQ;

                        public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                            com_google_android_gms_internal_zzch2.zza(zzdu, "jsf");
                            com_google_android_gms_internal_zzch2.zzdv();
                            com_google_android_gms_internal_zzbe.zza("/invalidRequest", com_google_android_gms_internal_zzhe2.zzHY);
                            com_google_android_gms_internal_zzbe.zza("/loadAdURL", com_google_android_gms_internal_zzhe2.zzHZ);
                            try {
                                com_google_android_gms_internal_zzbe.zza("AFMA_buildAdURL", jSONObject);
                            } catch (Throwable e) {
                                com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", e);
                            }
                        }

                        public /* synthetic */ void zzc(Object obj) {
                            zzb((zzbe) obj);
                        }
                    }, new C07222(this));
                }
            });
        } else {
            final Context context3 = context;
            final AdRequestInfoParcel adRequestInfoParcel3 = adRequestInfoParcel;
            final zzcf com_google_android_gms_internal_zzcf = zzdu2;
            final String str = jSONObject;
            final zzbs com_google_android_gms_internal_zzbs2 = com_google_android_gms_internal_zzbs;
            zzip.zzKO.post(new Runnable() {
                public void run() {
                    zzjn zza = zzp.zzby().zza(context3, new AdSizeParcel(), false, false, null, adRequestInfoParcel3.zzqR);
                    if (zzp.zzbA().zzgS()) {
                        zza.clearCache(true);
                    }
                    zza.getWebView().setWillNotDraw(true);
                    com_google_android_gms_internal_zzhe.zze(zza);
                    com_google_android_gms_internal_zzch.zza(com_google_android_gms_internal_zzcf, "rwc");
                    zzjo.zza zzb = zzhc.zza(str, com_google_android_gms_internal_zzch, com_google_android_gms_internal_zzch.zzdu());
                    zzjo zzhC = zza.zzhC();
                    zzhC.zza("/invalidRequest", com_google_android_gms_internal_zzhe.zzHY);
                    zzhC.zza("/loadAdURL", com_google_android_gms_internal_zzhe.zzHZ);
                    zzhC.zza("/log", zzdk.zzyG);
                    zzhC.zza(zzb);
                    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Loading the JS library.");
                    zza.loadUrl(com_google_android_gms_internal_zzbs2.zzdj());
                }
            });
        }
        AdResponseParcel adResponseParcel;
        try {
            zzhh com_google_android_gms_internal_zzhh = (zzhh) com_google_android_gms_internal_zzhe.zzgp().get(10, TimeUnit.SECONDS);
            if (com_google_android_gms_internal_zzhh == null) {
                adResponseParcel = new AdResponseParcel(0);
                return adResponseParcel;
            } else if (com_google_android_gms_internal_zzhh.getErrorCode() != -2) {
                adResponseParcel = new AdResponseParcel(com_google_android_gms_internal_zzhh.getErrorCode());
                com_google_android_gms_internal_zzhb2 = com_google_android_gms_internal_zzhb;
                context2 = context;
                adRequestInfoParcel2 = adRequestInfoParcel;
                zzip.zzKO.post(new Runnable() {
                    public void run() {
                        com_google_android_gms_internal_zzhb2.zzHy.zza(context2, com_google_android_gms_internal_zzhe, adRequestInfoParcel2.zzqR);
                    }
                });
                return adResponseParcel;
            } else {
                if (com_google_android_gms_internal_zzch.zzdx() != null) {
                    com_google_android_gms_internal_zzch.zza(com_google_android_gms_internal_zzch.zzdx(), "rur");
                }
                String str2 = null;
                if (com_google_android_gms_internal_zzhh.zzgt()) {
                    str2 = com_google_android_gms_internal_zzhb.zzHw.zzax(adRequestInfoParcel.zzGr.packageName);
                }
                adResponseParcel = zza(adRequestInfoParcel, context, adRequestInfoParcel.zzqR.afmaVersion, com_google_android_gms_internal_zzhh.getUrl(), str2, com_google_android_gms_internal_zzhh.zzgu() ? token : null, com_google_android_gms_internal_zzhh, com_google_android_gms_internal_zzch, com_google_android_gms_internal_zzhb);
                if (adResponseParcel.zzGZ == 1) {
                    com_google_android_gms_internal_zzhb.zzHA.clearToken(context, adRequestInfoParcel.zzGr.packageName);
                }
                com_google_android_gms_internal_zzch.zza(zzdu, "tts");
                adResponseParcel.zzHb = com_google_android_gms_internal_zzch.zzdw();
                com_google_android_gms_internal_zzhb2 = com_google_android_gms_internal_zzhb;
                context2 = context;
                adRequestInfoParcel2 = adRequestInfoParcel;
                zzip.zzKO.post(/* anonymous class already generated */);
                return adResponseParcel;
            }
        } catch (Exception e6) {
            adResponseParcel = new AdResponseParcel(0);
            return adResponseParcel;
        } finally {
            com_google_android_gms_internal_zzhb2 = com_google_android_gms_internal_zzhb;
            context2 = context;
            adRequestInfoParcel2 = adRequestInfoParcel;
            zzip.zzKO.post(/* anonymous class already generated */);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, com.google.android.gms.internal.zzhh r19, com.google.android.gms.internal.zzch r20, com.google.android.gms.internal.zzhb r21) {
        /*
        if (r20 == 0) goto L_0x00f6;
    L_0x0002:
        r2 = r20.zzdu();
        r3 = r2;
    L_0x0007:
        r8 = new com.google.android.gms.internal.zzhf;	 Catch:{ IOException -> 0x010e }
        r8.<init>(r13);	 Catch:{ IOException -> 0x010e }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x010e }
        r2.<init>();	 Catch:{ IOException -> 0x010e }
        r4 = "AdRequestServiceImpl: Sending request: ";
        r2 = r2.append(r4);	 Catch:{ IOException -> 0x010e }
        r0 = r16;
        r2 = r2.append(r0);	 Catch:{ IOException -> 0x010e }
        r2 = r2.toString();	 Catch:{ IOException -> 0x010e }
        com.google.android.gms.ads.internal.util.client.zzb.zzaF(r2);	 Catch:{ IOException -> 0x010e }
        r4 = new java.net.URL;	 Catch:{ IOException -> 0x010e }
        r0 = r16;
        r4.<init>(r0);	 Catch:{ IOException -> 0x010e }
        r2 = 0;
        r5 = com.google.android.gms.ads.internal.zzp.zzbB();	 Catch:{ IOException -> 0x010e }
        r10 = r5.elapsedRealtime();	 Catch:{ IOException -> 0x010e }
        r6 = r2;
        r7 = r4;
    L_0x0036:
        if (r21 == 0) goto L_0x003f;
    L_0x0038:
        r0 = r21;
        r2 = r0.zzHD;	 Catch:{ IOException -> 0x010e }
        r2.zzgw();	 Catch:{ IOException -> 0x010e }
    L_0x003f:
        r2 = r7.openConnection();	 Catch:{ IOException -> 0x010e }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ IOException -> 0x010e }
        r4 = com.google.android.gms.ads.internal.zzp.zzbx();	 Catch:{ all -> 0x0100 }
        r5 = 0;
        r4.zza(r14, r15, r5, r2);	 Catch:{ all -> 0x0100 }
        r4 = android.text.TextUtils.isEmpty(r17);	 Catch:{ all -> 0x0100 }
        if (r4 != 0) goto L_0x005a;
    L_0x0053:
        r4 = "x-afma-drt-cookie";
        r0 = r17;
        r2.addRequestProperty(r4, r0);	 Catch:{ all -> 0x0100 }
    L_0x005a:
        r4 = android.text.TextUtils.isEmpty(r18);	 Catch:{ all -> 0x0100 }
        if (r4 != 0) goto L_0x007a;
    L_0x0060:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0100 }
        r4.<init>();	 Catch:{ all -> 0x0100 }
        r5 = "Bearer ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0100 }
        r0 = r18;
        r4 = r4.append(r0);	 Catch:{ all -> 0x0100 }
        r4 = r4.toString();	 Catch:{ all -> 0x0100 }
        r5 = "Authorization";
        r2.addRequestProperty(r5, r4);	 Catch:{ all -> 0x0100 }
    L_0x007a:
        if (r19 == 0) goto L_0x00a6;
    L_0x007c:
        r4 = r19.zzgs();	 Catch:{ all -> 0x0100 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0100 }
        if (r4 != 0) goto L_0x00a6;
    L_0x0086:
        r4 = 1;
        r2.setDoOutput(r4);	 Catch:{ all -> 0x0100 }
        r4 = r19.zzgs();	 Catch:{ all -> 0x0100 }
        r9 = r4.getBytes();	 Catch:{ all -> 0x0100 }
        r4 = r9.length;	 Catch:{ all -> 0x0100 }
        r2.setFixedLengthStreamingMode(r4);	 Catch:{ all -> 0x0100 }
        r5 = 0;
        r4 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x00fa }
        r12 = r2.getOutputStream();	 Catch:{ all -> 0x00fa }
        r4.<init>(r12);	 Catch:{ all -> 0x00fa }
        r4.write(r9);	 Catch:{ all -> 0x01d0 }
        com.google.android.gms.internal.zznt.zzb(r4);	 Catch:{ all -> 0x0100 }
    L_0x00a6:
        r9 = r2.getResponseCode();	 Catch:{ all -> 0x0100 }
        r12 = r2.getHeaderFields();	 Catch:{ all -> 0x0100 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r9 < r4) goto L_0x0136;
    L_0x00b2:
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 >= r4) goto L_0x0136;
    L_0x00b6:
        r6 = r7.toString();	 Catch:{ all -> 0x0100 }
        r5 = 0;
        r4 = new java.io.InputStreamReader;	 Catch:{ all -> 0x0130 }
        r7 = r2.getInputStream();	 Catch:{ all -> 0x0130 }
        r4.<init>(r7);	 Catch:{ all -> 0x0130 }
        r5 = com.google.android.gms.ads.internal.zzp.zzbx();	 Catch:{ all -> 0x01cd }
        r5 = r5.zza(r4);	 Catch:{ all -> 0x01cd }
        com.google.android.gms.internal.zznt.zzb(r4);	 Catch:{ all -> 0x0100 }
        zza(r6, r12, r5, r9);	 Catch:{ all -> 0x0100 }
        r8.zzb(r6, r12, r5);	 Catch:{ all -> 0x0100 }
        if (r20 == 0) goto L_0x00e4;
    L_0x00d7:
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x0100 }
        r5 = 0;
        r6 = "ufe";
        r4[r5] = r6;	 Catch:{ all -> 0x0100 }
        r0 = r20;
        r0.zza(r3, r4);	 Catch:{ all -> 0x0100 }
    L_0x00e4:
        r3 = r8.zzj(r10);	 Catch:{ all -> 0x0100 }
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x00f4;
    L_0x00ed:
        r0 = r21;
        r2 = r0.zzHD;	 Catch:{ IOException -> 0x010e }
        r2.zzgx();	 Catch:{ IOException -> 0x010e }
    L_0x00f4:
        r2 = r3;
    L_0x00f5:
        return r2;
    L_0x00f6:
        r2 = 0;
        r3 = r2;
        goto L_0x0007;
    L_0x00fa:
        r3 = move-exception;
        r4 = r5;
    L_0x00fc:
        com.google.android.gms.internal.zznt.zzb(r4);	 Catch:{ all -> 0x0100 }
        throw r3;	 Catch:{ all -> 0x0100 }
    L_0x0100:
        r3 = move-exception;
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x010d;
    L_0x0106:
        r0 = r21;
        r2 = r0.zzHD;	 Catch:{ IOException -> 0x010e }
        r2.zzgx();	 Catch:{ IOException -> 0x010e }
    L_0x010d:
        throw r3;	 Catch:{ IOException -> 0x010e }
    L_0x010e:
        r2 = move-exception;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Error while connecting to ad server: ";
        r3 = r3.append(r4);
        r2 = r2.getMessage();
        r2 = r3.append(r2);
        r2 = r2.toString();
        com.google.android.gms.ads.internal.util.client.zzb.zzaH(r2);
        r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel;
        r3 = 2;
        r2.<init>(r3);
        goto L_0x00f5;
    L_0x0130:
        r3 = move-exception;
        r4 = r5;
    L_0x0132:
        com.google.android.gms.internal.zznt.zzb(r4);	 Catch:{ all -> 0x0100 }
        throw r3;	 Catch:{ all -> 0x0100 }
    L_0x0136:
        r4 = r7.toString();	 Catch:{ all -> 0x0100 }
        r5 = 0;
        zza(r4, r12, r5, r9);	 Catch:{ all -> 0x0100 }
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r9 < r4) goto L_0x018f;
    L_0x0142:
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r9 >= r4) goto L_0x018f;
    L_0x0146:
        r4 = "Location";
        r4 = r2.getHeaderField(r4);	 Catch:{ all -> 0x0100 }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0100 }
        if (r5 == 0) goto L_0x016b;
    L_0x0152:
        r3 = "No location header to follow redirect.";
        com.google.android.gms.ads.internal.util.client.zzb.zzaH(r3);	 Catch:{ all -> 0x0100 }
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0100 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0100 }
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x0169;
    L_0x0162:
        r0 = r21;
        r2 = r0.zzHD;	 Catch:{ IOException -> 0x010e }
        r2.zzgx();	 Catch:{ IOException -> 0x010e }
    L_0x0169:
        r2 = r3;
        goto L_0x00f5;
    L_0x016b:
        r5 = new java.net.URL;	 Catch:{ all -> 0x0100 }
        r5.<init>(r4);	 Catch:{ all -> 0x0100 }
        r4 = r6 + 1;
        r6 = 5;
        if (r4 <= r6) goto L_0x01ba;
    L_0x0175:
        r3 = "Too many redirects.";
        com.google.android.gms.ads.internal.util.client.zzb.zzaH(r3);	 Catch:{ all -> 0x0100 }
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0100 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0100 }
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x018c;
    L_0x0185:
        r0 = r21;
        r2 = r0.zzHD;	 Catch:{ IOException -> 0x010e }
        r2.zzgx();	 Catch:{ IOException -> 0x010e }
    L_0x018c:
        r2 = r3;
        goto L_0x00f5;
    L_0x018f:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0100 }
        r3.<init>();	 Catch:{ all -> 0x0100 }
        r4 = "Received error HTTP response code: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0100 }
        r3 = r3.append(r9);	 Catch:{ all -> 0x0100 }
        r3 = r3.toString();	 Catch:{ all -> 0x0100 }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH(r3);	 Catch:{ all -> 0x0100 }
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0100 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0100 }
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x01b7;
    L_0x01b0:
        r0 = r21;
        r2 = r0.zzHD;	 Catch:{ IOException -> 0x010e }
        r2.zzgx();	 Catch:{ IOException -> 0x010e }
    L_0x01b7:
        r2 = r3;
        goto L_0x00f5;
    L_0x01ba:
        r8.zzh(r12);	 Catch:{ all -> 0x0100 }
        r2.disconnect();	 Catch:{ IOException -> 0x010e }
        if (r21 == 0) goto L_0x01c9;
    L_0x01c2:
        r0 = r21;
        r2 = r0.zzHD;	 Catch:{ IOException -> 0x010e }
        r2.zzgx();	 Catch:{ IOException -> 0x010e }
    L_0x01c9:
        r6 = r4;
        r7 = r5;
        goto L_0x0036;
    L_0x01cd:
        r3 = move-exception;
        goto L_0x0132;
    L_0x01d0:
        r3 = move-exception;
        goto L_0x00fc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhc.zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.zzhh, com.google.android.gms.internal.zzch, com.google.android.gms.internal.zzhb):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static zzhc zza(Context context, zzbs com_google_android_gms_internal_zzbs, zzhb com_google_android_gms_internal_zzhb) {
        zzhc com_google_android_gms_internal_zzhc;
        synchronized (zzqf) {
            if (zzHF == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzHF = new zzhc(context, com_google_android_gms_internal_zzbs, com_google_android_gms_internal_zzhb);
            }
            com_google_android_gms_internal_zzhc = zzHF;
        }
        return com_google_android_gms_internal_zzhc;
    }

    private static zzjo.zza zza(final String str, final zzch com_google_android_gms_internal_zzch, final zzcf com_google_android_gms_internal_zzcf) {
        return new zzjo.zza() {
            public void zza(zzjn com_google_android_gms_internal_zzjn, boolean z) {
                com_google_android_gms_internal_zzch.zza(com_google_android_gms_internal_zzcf, "jsf");
                com_google_android_gms_internal_zzch.zzdv();
                com_google_android_gms_internal_zzjn.zza("AFMA_buildAdURL", str);
            }
        };
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (com.google.android.gms.ads.internal.util.client.zzb.zzQ(2)) {
            com.google.android.gms.ads.internal.util.client.zzb.m7v("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    com.google.android.gms.ads.internal.util.client.zzb.m7v("    " + str3 + ":");
                    for (String str32 : (List) map.get(str32)) {
                        com.google.android.gms.ads.internal.util.client.zzb.m7v("      " + str32);
                    }
                }
            }
            com.google.android.gms.ads.internal.util.client.zzb.m7v("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    com.google.android.gms.ads.internal.util.client.zzb.m7v(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzb.m7v("    null");
            }
            com.google.android.gms.ads.internal.util.client.zzb.m7v("  Response Code:\n    " + i + "\n}");
        }
    }

    public void zza(final AdRequestInfoParcel adRequestInfoParcel, final zzk com_google_android_gms_ads_internal_request_zzk) {
        zzp.zzbA().zzb(this.mContext, adRequestInfoParcel.zzqR);
        zzio.zza(new Runnable(this) {
            final /* synthetic */ zzhc zzHS;

            public void run() {
                AdResponseParcel zzd;
                try {
                    zzd = this.zzHS.zzd(adRequestInfoParcel);
                } catch (Throwable e) {
                    zzp.zzbA().zzb(e, true);
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response due to an Exception.", e);
                    zzd = null;
                }
                if (zzd == null) {
                    zzd = new AdResponseParcel(0);
                }
                try {
                    com_google_android_gms_ads_internal_request_zzk.zzb(zzd);
                } catch (Throwable e2) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to forward ad response.", e2);
                }
            }
        });
    }

    public AdResponseParcel zzd(AdRequestInfoParcel adRequestInfoParcel) {
        return zza(this.mContext, this.zzrO, this.zzHH, this.zzHG, adRequestInfoParcel);
    }
}
