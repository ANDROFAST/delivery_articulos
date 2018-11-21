package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.plus.PlusShare;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzgv implements Callable<zzie> {
    private static final long zzFC = TimeUnit.SECONDS.toMillis(60);
    private final Context mContext;
    private final zziu zzFD;
    private final zzn zzFE;
    private final zzbc zzFF;
    private boolean zzFG;
    private List<String> zzFH;
    private JSONObject zzFI;
    private final com.google.android.gms.internal.zzie.zza zzFc;
    private int zzFt;
    private final Object zzpK = new Object();
    private final zzan zzxV;

    public interface zza<T extends com.google.android.gms.ads.internal.formats.zzh.zza> {
        T zza(zzgv com_google_android_gms_internal_zzgv, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException;
    }

    class zzb {
        final /* synthetic */ zzgv zzFM;
        public zzdl zzFY;

        zzb(zzgv com_google_android_gms_internal_zzgv) {
            this.zzFM = com_google_android_gms_internal_zzgv;
        }
    }

    public zzgv(Context context, zzn com_google_android_gms_ads_internal_zzn, zzbc com_google_android_gms_internal_zzbc, zziu com_google_android_gms_internal_zziu, zzan com_google_android_gms_internal_zzan, com.google.android.gms.internal.zzie.zza com_google_android_gms_internal_zzie_zza) {
        this.mContext = context;
        this.zzFE = com_google_android_gms_ads_internal_zzn;
        this.zzFD = com_google_android_gms_internal_zziu;
        this.zzFF = com_google_android_gms_internal_zzbc;
        this.zzFc = com_google_android_gms_internal_zzie_zza;
        this.zzxV = com_google_android_gms_internal_zzan;
        this.zzFG = false;
        this.zzFt = -2;
        this.zzFH = null;
    }

    private com.google.android.gms.ads.internal.formats.zzh.zza zza(zzbb com_google_android_gms_internal_zzbb, zza com_google_android_gms_internal_zzgv_zza, JSONObject jSONObject) throws ExecutionException, InterruptedException, JSONException {
        if (zzga()) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("tracking_urls_and_actions");
        String[] zzc = zzc(jSONObject2, "impression_tracking_urls");
        this.zzFH = zzc == null ? null : Arrays.asList(zzc);
        this.zzFI = jSONObject2.optJSONObject("active_view");
        com.google.android.gms.ads.internal.formats.zzh.zza zza = com_google_android_gms_internal_zzgv_zza.zza(this, jSONObject);
        if (zza == null) {
            com.google.android.gms.ads.internal.util.client.zzb.m6e("Failed to retrieve ad assets.");
            return null;
        }
        zza.zzb(new zzh(this.mContext, this.zzFE, com_google_android_gms_internal_zzbb, this.zzxV, jSONObject, zza, this.zzFc.zzJK.zzqR));
        return zza;
    }

    private zzie zza(com.google.android.gms.ads.internal.formats.zzh.zza com_google_android_gms_ads_internal_formats_zzh_zza) {
        int i;
        synchronized (this.zzpK) {
            i = this.zzFt;
            if (com_google_android_gms_ads_internal_formats_zzh_zza == null && this.zzFt == -2) {
                i = 0;
            }
        }
        return new zzie(this.zzFc.zzJK.zzGq, null, this.zzFc.zzJL.zzAQ, i, this.zzFc.zzJL.zzAR, this.zzFH, this.zzFc.zzJL.orientation, this.zzFc.zzJL.zzAU, this.zzFc.zzJK.zzGt, false, null, null, null, null, null, 0, this.zzFc.zzqV, this.zzFc.zzJL.zzGM, this.zzFc.zzJH, this.zzFc.zzJI, this.zzFc.zzJL.zzGS, this.zzFI, i != -2 ? null : com_google_android_gms_ads_internal_formats_zzh_zza);
    }

    private zzje<zzc> zza(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        final String string = z ? jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL) : jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        final double optDouble = jSONObject.optDouble("scale", 1.0d);
        if (TextUtils.isEmpty(string)) {
            zza(0, z);
            return new zzjc(null);
        } else if (z2) {
            return new zzjc(new zzc(null, Uri.parse(string), optDouble));
        } else {
            final boolean z3 = z;
            return this.zzFD.zza(string, new com.google.android.gms.internal.zziu.zza<zzc>(this) {
                final /* synthetic */ zzgv zzFM;

                public zzc zzg(InputStream inputStream) {
                    byte[] zzk;
                    try {
                        zzk = zznt.zzk(inputStream);
                    } catch (IOException e) {
                        zzk = null;
                    }
                    if (zzk == null) {
                        this.zzFM.zza(2, z3);
                        return null;
                    }
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(zzk, 0, zzk.length);
                    if (decodeByteArray == null) {
                        this.zzFM.zza(2, z3);
                        return null;
                    }
                    decodeByteArray.setDensity((int) (160.0d * optDouble));
                    return new zzc(new BitmapDrawable(Resources.getSystem(), decodeByteArray), Uri.parse(string), optDouble);
                }

                public zzc zzgb() {
                    this.zzFM.zza(2, z3);
                    return null;
                }

                public /* synthetic */ Object zzgc() {
                    return zzgb();
                }

                public /* synthetic */ Object zzh(InputStream inputStream) {
                    return zzg(inputStream);
                }
            });
        }
    }

    private void zza(com.google.android.gms.ads.internal.formats.zzh.zza com_google_android_gms_ads_internal_formats_zzh_zza, zzbb com_google_android_gms_internal_zzbb) {
        if (com_google_android_gms_ads_internal_formats_zzh_zza instanceof zzf) {
            final zzf com_google_android_gms_ads_internal_formats_zzf = (zzf) com_google_android_gms_ads_internal_formats_zzh_zza;
            zzb com_google_android_gms_internal_zzgv_zzb = new zzb(this);
            zzdl c07183 = new zzdl(this) {
                final /* synthetic */ zzgv zzFM;

                public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
                    this.zzFM.zzb(com_google_android_gms_ads_internal_formats_zzf, (String) map.get("asset"));
                }
            };
            com_google_android_gms_internal_zzgv_zzb.zzFY = c07183;
            com_google_android_gms_internal_zzbb.zza("/nativeAdCustomClick", c07183);
        }
    }

    private Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    private JSONObject zzb(final zzbb com_google_android_gms_internal_zzbb) throws TimeoutException, JSONException {
        if (zzga()) {
            return null;
        }
        final zzjb com_google_android_gms_internal_zzjb = new zzjb();
        final zzb com_google_android_gms_internal_zzgv_zzb = new zzb(this);
        zzdl c07171 = new zzdl(this) {
            final /* synthetic */ zzgv zzFM;

            public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
                com_google_android_gms_internal_zzbb.zzb("/nativeAdPreProcess", com_google_android_gms_internal_zzgv_zzb.zzFY);
                try {
                    String str = (String) map.get("success");
                    if (!TextUtils.isEmpty(str)) {
                        com_google_android_gms_internal_zzjb.zzf(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                        return;
                    }
                } catch (Throwable e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzb("Malformed native JSON response.", e);
                }
                this.zzFM.zzF(0);
                zzx.zza(this.zzFM.zzga(), (Object) "Unable to set the ad state error!");
                com_google_android_gms_internal_zzjb.zzf(null);
            }
        };
        com_google_android_gms_internal_zzgv_zzb.zzFY = c07171;
        com_google_android_gms_internal_zzbb.zza("/nativeAdPreProcess", c07171);
        com_google_android_gms_internal_zzbb.zza("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.zzFc.zzJL.body));
        return (JSONObject) com_google_android_gms_internal_zzjb.get(zzFC, TimeUnit.MILLISECONDS);
    }

    private void zzb(zzcv com_google_android_gms_internal_zzcv, String str) {
        try {
            zzcz zzr = this.zzFE.zzr(com_google_android_gms_internal_zzcv.getCustomTemplateId());
            if (zzr != null) {
                zzr.zza(com_google_android_gms_internal_zzcv, str);
            }
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call onCustomClick for asset " + str + ".", e);
        }
    }

    private String[] zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    private static List<Drawable> zzf(List<zzc> list) throws RemoteException {
        List<Drawable> arrayList = new ArrayList();
        for (zzc zzdC : list) {
            arrayList.add((Drawable) zze.zzp(zzdC.zzdC()));
        }
        return arrayList;
    }

    private zzbb zzfZ() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        if (zzga()) {
            return null;
        }
        zzbb com_google_android_gms_internal_zzbb = (zzbb) this.zzFF.zza(this.mContext, this.zzFc.zzJK.zzqR, (this.zzFc.zzJL.zzDE.indexOf("https") == 0 ? "https:" : "http:") + ((String) zzbz.zzwh.get()), this.zzxV).get(zzFC, TimeUnit.MILLISECONDS);
        com_google_android_gms_internal_zzbb.zza(this.zzFE, this.zzFE, this.zzFE, this.zzFE, false, null, null, null, null);
        return com_google_android_gms_internal_zzbb;
    }

    public /* synthetic */ Object call() throws Exception {
        return zzfY();
    }

    public void zzF(int i) {
        synchronized (this.zzpK) {
            this.zzFG = true;
            this.zzFt = i;
        }
    }

    public zzje<zzc> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public List<zzje<zzc>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        List<zzje<zzc>> arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            zza(0, z);
            return arrayList;
        }
        int length = z3 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(zza(jSONObject2, z, z2));
        }
        return arrayList;
    }

    public Future<zzc> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, optBoolean, z);
    }

    public void zza(int i, boolean z) {
        if (z) {
            zzF(i);
        }
    }

    protected zza zzd(JSONObject jSONObject) throws JSONException, TimeoutException {
        if (zzga()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.zzFc.zzJK.zzrj != null ? this.zzFc.zzJK.zzrj.zzyc : false;
        boolean z2 = this.zzFc.zzJK.zzrj != null ? this.zzFc.zzJK.zzrj.zzye : false;
        if ("2".equals(string)) {
            return new zzgw(z, z2);
        }
        if ("1".equals(string)) {
            return new zzgx(z, z2);
        }
        if ("3".equals(string)) {
            final String string2 = jSONObject.getString("custom_template_id");
            final zzjb com_google_android_gms_internal_zzjb = new zzjb();
            zzip.zzKO.post(new Runnable(this) {
                final /* synthetic */ zzgv zzFM;

                public void run() {
                    com_google_android_gms_internal_zzjb.zzf(this.zzFM.zzFE.zzbq().get(string2));
                }
            });
            if (com_google_android_gms_internal_zzjb.get(zzFC, TimeUnit.MILLISECONDS) != null) {
                return new zzgy(z);
            }
            com.google.android.gms.ads.internal.util.client.zzb.m6e("No handler for custom template: " + jSONObject.getString("custom_template_id"));
        } else {
            zzF(0);
        }
        return null;
    }

    public zzje<com.google.android.gms.ads.internal.formats.zza> zze(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return new zzjc(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer zzb = zzb(optJSONObject, "text_color");
        Integer zzb2 = zzb(optJSONObject, "bg_color");
        final int optInt2 = optJSONObject.optInt("animation_ms", 1000);
        final int optInt3 = optJSONObject.optInt("presentation_ms", 4000);
        List arrayList = new ArrayList();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = zza(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(zza(optJSONObject, "image", false, false));
        }
        final String str = optString;
        final Integer num = zzb2;
        final Integer num2 = zzb;
        final int i = optInt;
        return zzjd.zza(zzjd.zzj(arrayList), new com.google.android.gms.internal.zzjd.zza<List<zzc>, com.google.android.gms.ads.internal.formats.zza>(this) {
            final /* synthetic */ zzgv zzFM;

            public /* synthetic */ Object zze(Object obj) {
                return zzh((List) obj);
            }

            public com.google.android.gms.ads.internal.formats.zza zzh(List<zzc> list) {
                com.google.android.gms.ads.internal.formats.zza com_google_android_gms_ads_internal_formats_zza;
                if (list != null) {
                    try {
                        if (!list.isEmpty()) {
                            com_google_android_gms_ads_internal_formats_zza = new com.google.android.gms.ads.internal.formats.zza(str, zzgv.zzf(list), num, num2, i > 0 ? Integer.valueOf(i) : null, optInt3 + optInt2);
                            return com_google_android_gms_ads_internal_formats_zza;
                        }
                    } catch (Throwable e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzb("Could not get attribution icon", e);
                        return null;
                    }
                }
                com_google_android_gms_ads_internal_formats_zza = null;
                return com_google_android_gms_ads_internal_formats_zza;
            }
        });
    }

    public zzie zzfY() {
        try {
            zzbb zzfZ = zzfZ();
            JSONObject zzb = zzb(zzfZ);
            com.google.android.gms.ads.internal.formats.zzh.zza zza = zza(zzfZ, zzd(zzb), zzb);
            zza(zza, zzfZ);
            return zza(zza);
        } catch (CancellationException e) {
            if (!this.zzFG) {
                zzF(0);
            }
            return zza(null);
        } catch (ExecutionException e2) {
            if (this.zzFG) {
                zzF(0);
            }
            return zza(null);
        } catch (InterruptedException e3) {
            if (this.zzFG) {
                zzF(0);
            }
            return zza(null);
        } catch (Throwable e4) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Malformed native JSON response.", e4);
            if (this.zzFG) {
                zzF(0);
            }
            return zza(null);
        } catch (Throwable e42) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Timeout when loading native ad.", e42);
            if (this.zzFG) {
                zzF(0);
            }
            return zza(null);
        }
    }

    public boolean zzga() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzFG;
        }
        return z;
    }
}
