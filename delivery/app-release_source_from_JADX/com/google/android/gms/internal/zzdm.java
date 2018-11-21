package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.plus.PlusShare;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzdm implements zzdl {
    private final Context mContext;
    private final VersionInfoParcel zzpI;

    @zzha
    static class zza {
        private final String mValue;
        private final String zzuX;

        public zza(String str, String str2) {
            this.zzuX = str;
            this.mValue = str2;
        }

        public String getKey() {
            return this.zzuX;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    @zzha
    static class zzb {
        private final String zzyQ;
        private final URL zzyR;
        private final ArrayList<zza> zzyS;
        private final String zzyT;

        public zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            this.zzyQ = str;
            this.zzyR = url;
            if (arrayList == null) {
                this.zzyS = new ArrayList();
            } else {
                this.zzyS = arrayList;
            }
            this.zzyT = str2;
        }

        public String zzdN() {
            return this.zzyQ;
        }

        public URL zzdO() {
            return this.zzyR;
        }

        public ArrayList<zza> zzdP() {
            return this.zzyS;
        }

        public String zzdQ() {
            return this.zzyT;
        }
    }

    @zzha
    class zzc {
        final /* synthetic */ zzdm zzyN;
        private final zzd zzyU;
        private final boolean zzyV;
        private final String zzyW;

        public zzc(zzdm com_google_android_gms_internal_zzdm, boolean z, zzd com_google_android_gms_internal_zzdm_zzd, String str) {
            this.zzyN = com_google_android_gms_internal_zzdm;
            this.zzyV = z;
            this.zzyU = com_google_android_gms_internal_zzdm_zzd;
            this.zzyW = str;
        }

        public String getReason() {
            return this.zzyW;
        }

        public boolean isSuccess() {
            return this.zzyV;
        }

        public zzd zzdR() {
            return this.zzyU;
        }
    }

    @zzha
    static class zzd {
        private final String zzxA;
        private final String zzyQ;
        private final int zzyX;
        private final List<zza> zzyY;

        public zzd(String str, int i, List<zza> list, String str2) {
            this.zzyQ = str;
            this.zzyX = i;
            if (list == null) {
                this.zzyY = new ArrayList();
            } else {
                this.zzyY = list;
            }
            this.zzxA = str2;
        }

        public String getBody() {
            return this.zzxA;
        }

        public int getResponseCode() {
            return this.zzyX;
        }

        public String zzdN() {
            return this.zzyQ;
        }

        public Iterable<zza> zzdS() {
            return this.zzyY;
        }
    }

    public zzdm(Context context, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzpI = versionInfoParcel;
    }

    public JSONObject zzV(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            Object obj = "";
            try {
                obj = jSONObject.optString("http_request_id");
                zzc zza = zza(zzb(jSONObject));
                if (zza.isSuccess()) {
                    jSONObject2.put("response", zza(zza.zzdR()));
                    jSONObject2.put("success", true);
                    return jSONObject2;
                }
                jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", zza.getReason());
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.util.client.zzb.m6e("The request is not a valid JSON.");
            try {
                return new JSONObject().put("success", false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }

    protected zzc zza(zzb com_google_android_gms_internal_zzdm_zzb) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) com_google_android_gms_internal_zzdm_zzb.zzdO().openConnection();
            zzp.zzbx().zza(this.mContext, this.zzpI.afmaVersion, false, httpURLConnection);
            Iterator it = com_google_android_gms_internal_zzdm_zzb.zzdP().iterator();
            while (it.hasNext()) {
                zza com_google_android_gms_internal_zzdm_zza = (zza) it.next();
                httpURLConnection.addRequestProperty(com_google_android_gms_internal_zzdm_zza.getKey(), com_google_android_gms_internal_zzdm_zza.getValue());
            }
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzdm_zzb.zzdQ())) {
                httpURLConnection.setDoOutput(true);
                byte[] bytes = com_google_android_gms_internal_zzdm_zzb.zzdQ().getBytes();
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
            }
            List arrayList = new ArrayList();
            if (httpURLConnection.getHeaderFields() != null) {
                for (Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
                    for (String com_google_android_gms_internal_zzdm_zza2 : (List) entry.getValue()) {
                        arrayList.add(new zza((String) entry.getKey(), com_google_android_gms_internal_zzdm_zza2));
                    }
                }
            }
            return new zzc(this, true, new zzd(com_google_android_gms_internal_zzdm_zzb.zzdN(), httpURLConnection.getResponseCode(), arrayList, zzp.zzbx().zza(new InputStreamReader(httpURLConnection.getInputStream()))), null);
        } catch (Exception e) {
            return new zzc(this, false, null, e.toString());
        }
    }

    protected JSONObject zza(zzd com_google_android_gms_internal_zzdm_zzd) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", com_google_android_gms_internal_zzdm_zzd.zzdN());
            if (com_google_android_gms_internal_zzdm_zzd.getBody() != null) {
                jSONObject.put("body", com_google_android_gms_internal_zzdm_zzd.getBody());
            }
            JSONArray jSONArray = new JSONArray();
            for (zza com_google_android_gms_internal_zzdm_zza : com_google_android_gms_internal_zzdm_zzd.zzdS()) {
                jSONArray.put(new JSONObject().put("key", com_google_android_gms_internal_zzdm_zza.getKey()).put("value", com_google_android_gms_internal_zzdm_zza.getValue()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", com_google_android_gms_internal_zzdm_zzd.getResponseCode());
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    public void zza(final zzjn com_google_android_gms_internal_zzjn, final Map<String, String> map) {
        zzio.zza(new Runnable(this) {
            final /* synthetic */ zzdm zzyN;

            public void run() {
                com.google.android.gms.ads.internal.util.client.zzb.zzaF("Received Http request.");
                final JSONObject zzV = this.zzyN.zzV((String) map.get("http_request"));
                if (zzV == null) {
                    com.google.android.gms.ads.internal.util.client.zzb.m6e("Response should not be null.");
                } else {
                    zzip.zzKO.post(new Runnable(this) {
                        final /* synthetic */ C02801 zzyP;

                        public void run() {
                            com_google_android_gms_internal_zzjn.zzb("fetchHttpRequestCompleted", zzV);
                            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Dispatched http response.");
                        }
                    });
                }
            }
        });
    }

    protected zzb zzb(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new zza(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new zzb(optString, url, arrayList, optString3);
    }
}
