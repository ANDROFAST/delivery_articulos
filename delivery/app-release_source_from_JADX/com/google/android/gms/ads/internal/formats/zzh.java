package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzjn;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

@zzha
public class zzh {
    private final Context mContext;
    private final VersionInfoParcel zzpI;
    private final Object zzpK = new Object();
    private zzjn zzps;
    private final zzn zzxP;
    private final JSONObject zzxS;
    private final zzbb zzxT;
    private final zza zzxU;
    private final zzan zzxV;
    private boolean zzxW;
    private String zzxX;
    private WeakReference<View> zzxY = null;

    public interface zza {
        String getCustomTemplateId();

        void zzb(zzh com_google_android_gms_ads_internal_formats_zzh);

        String zzdF();

        zza zzdG();
    }

    class C06061 implements zzdl {
        final /* synthetic */ zzh zzxZ;

        C06061(zzh com_google_android_gms_ads_internal_formats_zzh) {
            this.zzxZ = com_google_android_gms_ads_internal_formats_zzh;
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, final Map<String, String> map) {
            this.zzxZ.zzps.zzhC().zza(new com.google.android.gms.internal.zzjo.zza(this) {
                final /* synthetic */ C06061 zzyb;

                public void zza(zzjn com_google_android_gms_internal_zzjn, boolean z) {
                    this.zzyb.zzxZ.zzxX = (String) map.get("id");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("messageType", "htmlLoaded");
                        jSONObject.put("id", this.zzyb.zzxZ.zzxX);
                        this.zzyb.zzxZ.zzxT.zzb("sendMessageToNativeJs", jSONObject);
                    } catch (Throwable e) {
                        zzb.zzb("Unable to dispatch sendMessageToNativeJsevent", e);
                    }
                }
            });
            String str = (String) map.get("overlayHtml");
            String str2 = (String) map.get("baseUrl");
            if (TextUtils.isEmpty(str2)) {
                this.zzxZ.zzps.loadData(str, "text/html", "UTF-8");
            } else {
                this.zzxZ.zzps.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
            }
        }
    }

    class C06072 implements zzdl {
        final /* synthetic */ zzh zzxZ;

        C06072(zzh com_google_android_gms_ads_internal_formats_zzh) {
            this.zzxZ = com_google_android_gms_ads_internal_formats_zzh;
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            this.zzxZ.zzps.getView().setVisibility(0);
        }
    }

    class C06083 implements zzdl {
        final /* synthetic */ zzh zzxZ;

        C06083(zzh com_google_android_gms_ads_internal_formats_zzh) {
            this.zzxZ = com_google_android_gms_ads_internal_formats_zzh;
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            this.zzxZ.zzps.getView().setVisibility(8);
        }
    }

    class C06094 implements zzdl {
        final /* synthetic */ zzh zzxZ;

        C06094(zzh com_google_android_gms_ads_internal_formats_zzh) {
            this.zzxZ = com_google_android_gms_ads_internal_formats_zzh;
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            this.zzxZ.zzps.getView().setVisibility(8);
        }
    }

    class C06105 implements zzdl {
        final /* synthetic */ zzh zzxZ;

        C06105(zzh com_google_android_gms_ads_internal_formats_zzh) {
            this.zzxZ = com_google_android_gms_ads_internal_formats_zzh;
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str : map.keySet()) {
                    jSONObject.put(str, map.get(str));
                }
                jSONObject.put("id", this.zzxZ.zzxX);
                this.zzxZ.zzxT.zzb("sendMessageToNativeJs", jSONObject);
            } catch (Throwable e) {
                zzb.zzb("Unable to dispatch sendMessageToNativeJs event", e);
            }
        }
    }

    public zzh(Context context, zzn com_google_android_gms_ads_internal_zzn, zzbb com_google_android_gms_internal_zzbb, zzan com_google_android_gms_internal_zzan, JSONObject jSONObject, zza com_google_android_gms_ads_internal_formats_zzh_zza, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzxP = com_google_android_gms_ads_internal_zzn;
        this.zzxT = com_google_android_gms_internal_zzbb;
        this.zzxV = com_google_android_gms_internal_zzan;
        this.zzxS = jSONObject;
        this.zzxU = com_google_android_gms_ads_internal_formats_zzh_zza;
        this.zzpI = versionInfoParcel;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void recordImpression() {
        zzx.zzcx("recordImpression must be called on the main UI thread.");
        zzn(true);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzxS);
            this.zzxT.zza("google.afma.nativeAds.handleImpressionPing", jSONObject);
        } catch (Throwable e) {
            zzb.zzb("Unable to create impression JSON.", e);
        }
        this.zzxP.zza(this);
    }

    public zzb zza(OnClickListener onClickListener) {
        zza zzdG = this.zzxU.zzdG();
        if (zzdG == null) {
            return null;
        }
        zzb com_google_android_gms_ads_internal_formats_zzb = new zzb(this.mContext, zzdG);
        com_google_android_gms_ads_internal_formats_zzb.setLayoutParams(new LayoutParams(-1, -1));
        com_google_android_gms_ads_internal_formats_zzb.zzdB().setOnClickListener(onClickListener);
        com_google_android_gms_ads_internal_formats_zzb.zzdB().setContentDescription("Ad attribution icon");
        return com_google_android_gms_ads_internal_formats_zzb;
    }

    public void zza(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzx.zzcx("performClick must be called on the main UI thread.");
        for (Entry entry : map.entrySet()) {
            if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                zza((String) entry.getKey(), jSONObject, jSONObject2, jSONObject3);
                return;
            }
        }
    }

    public void zza(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzx.zzcx("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("asset", str);
            jSONObject4.put("template", this.zzxU.zzdF());
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("ad", this.zzxS);
            jSONObject5.put("click", jSONObject4);
            jSONObject5.put("has_custom_click_handler", this.zzxP.zzr(this.zzxU.getCustomTemplateId()) != null);
            if (jSONObject != null) {
                jSONObject5.put("view_rectangles", jSONObject);
            }
            if (jSONObject2 != null) {
                jSONObject5.put("click_point", jSONObject2);
            }
            if (jSONObject3 != null) {
                jSONObject5.put("native_view_rectangle", jSONObject3);
            }
            this.zzxT.zza("google.afma.nativeAds.handleClickGmsg", jSONObject5);
        } catch (Throwable e) {
            zzb.zzb("Unable to create click JSON.", e);
        }
    }

    public void zzb(MotionEvent motionEvent) {
        this.zzxV.zza(motionEvent);
    }

    public zzjn zzdK() {
        this.zzps = zzdM();
        this.zzps.getView().setVisibility(8);
        this.zzxT.zza("/loadHtml", new C06061(this));
        this.zzxT.zza("/showOverlay", new C06072(this));
        this.zzxT.zza("/hideOverlay", new C06083(this));
        this.zzps.zzhC().zza("/hideOverlay", new C06094(this));
        this.zzps.zzhC().zza("/sendMessageToSdk", new C06105(this));
        return this.zzps;
    }

    public View zzdL() {
        return this.zzxY != null ? (View) this.zzxY.get() : null;
    }

    zzjn zzdM() {
        return zzp.zzby().zza(this.mContext, AdSizeParcel.zzt(this.mContext), false, false, this.zzxV, this.zzpI);
    }

    public void zzh(View view) {
    }

    public void zzi(View view) {
        synchronized (this.zzpK) {
            if (this.zzxW) {
            } else if (!view.isShown()) {
            } else if (view.getGlobalVisibleRect(new Rect(), null)) {
                recordImpression();
            }
        }
    }

    public void zzj(View view) {
        this.zzxY = new WeakReference(view);
    }

    protected void zzn(boolean z) {
        this.zzxW = z;
    }
}
