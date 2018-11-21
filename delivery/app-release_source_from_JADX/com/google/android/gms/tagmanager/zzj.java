package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzj extends zzdd {
    private static final String ID = zzad.ARBITRARY_PIXEL.toString();
    private static final String URL = zzae.URL.toString();
    static final String zzbcA = ("gtm_" + ID + "_unrepeatable");
    private static final Set<String> zzbcB = new HashSet();
    private static final String zzbcy = zzae.ADDITIONAL_PARAMS.toString();
    private static final String zzbcz = zzae.UNREPEATABLE.toString();
    private final Context mContext;
    private final zza zzbcC;

    public interface zza {
        zzar zzEb();
    }

    class C07931 implements zza {
        final /* synthetic */ Context zzsm;

        C07931(Context context) {
            this.zzsm = context;
        }

        public zzar zzEb() {
            return zzz.zzaX(this.zzsm);
        }
    }

    public zzj(Context context) {
        this(context, new C07931(context));
    }

    zzj(Context context, zza com_google_android_gms_tagmanager_zzj_zza) {
        super(ID, URL);
        this.zzbcC = com_google_android_gms_tagmanager_zzj_zza;
        this.mContext = context;
    }

    private synchronized boolean zzeX(String str) {
        boolean z = true;
        synchronized (this) {
            if (!zzeZ(str)) {
                if (zzeY(str)) {
                    zzbcB.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    public void zzK(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        String zzg = map.get(zzbcz) != null ? zzdf.zzg((com.google.android.gms.internal.zzag.zza) map.get(zzbcz)) : null;
        if (zzg == null || !zzeX(zzg)) {
            Builder buildUpon = Uri.parse(zzdf.zzg((com.google.android.gms.internal.zzag.zza) map.get(URL))).buildUpon();
            com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza = (com.google.android.gms.internal.zzag.zza) map.get(zzbcy);
            if (com_google_android_gms_internal_zzag_zza != null) {
                Object zzl = zzdf.zzl(com_google_android_gms_internal_zzag_zza);
                if (zzl instanceof List) {
                    for (Object zzl2 : (List) zzl2) {
                        if (zzl2 instanceof Map) {
                            for (Entry entry : ((Map) zzl2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            zzbg.m9e("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                            return;
                        }
                    }
                }
                zzbg.m9e("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                return;
            }
            String uri = buildUpon.build().toString();
            this.zzbcC.zzEb().zzfo(uri);
            zzbg.m10v("ArbitraryPixel: url = " + uri);
            if (zzg != null) {
                synchronized (zzj.class) {
                    zzbcB.add(zzg);
                    zzcv.zzb(this.mContext, zzbcA, zzg, "true");
                }
            }
        }
    }

    boolean zzeY(String str) {
        return this.mContext.getSharedPreferences(zzbcA, 0).contains(str);
    }

    boolean zzeZ(String str) {
        return zzbcB.contains(str);
    }
}
