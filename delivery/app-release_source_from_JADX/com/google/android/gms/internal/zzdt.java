package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@zzha
public final class zzdt implements zzdl {
    private final Map<zzjn, Integer> zzzi = new WeakHashMap();

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = zzl.zzcN().zzb(context, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                zzb.zzaH("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        return i;
    }

    public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        String str = (String) map.get("action");
        if (str == null) {
            zzb.zzaH("Action missing from video GMSG.");
            return;
        }
        if (zzb.zzQ(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            zzb.zzaF("Video GMSG: " + str + " " + jSONObject.toString());
        }
        String str2;
        if ("background".equals(str)) {
            str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzb.zzaH("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                int parseColor = Color.parseColor(str2);
                zzjm zzhJ = com_google_android_gms_internal_zzjn.zzhJ();
                if (zzhJ != null) {
                    zzk zzhv = zzhJ.zzhv();
                    if (zzhv != null) {
                        zzhv.setBackgroundColor(parseColor);
                        return;
                    }
                }
                this.zzzi.put(com_google_android_gms_internal_zzjn, Integer.valueOf(parseColor));
                return;
            } catch (IllegalArgumentException e) {
                zzb.zzaH("Invalid color parameter in video GMSG.");
                return;
            }
        }
        zzjm zzhJ2 = com_google_android_gms_internal_zzjn.zzhJ();
        if (zzhJ2 == null) {
            zzb.zzaH("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        int zza;
        int zza2;
        if (equals || equals2) {
            int parseInt;
            Context context = com_google_android_gms_internal_zzjn.getContext();
            int zza3 = zza(context, map, "x", 0);
            zza = zza(context, map, "y", 0);
            zza2 = zza(context, map, "w", -1);
            int zza4 = zza(context, map, "h", -1);
            try {
                parseInt = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e2) {
                parseInt = 0;
            }
            if (equals && zzhJ2.zzhv() == null) {
                zzhJ2.zza(zza3, zza, zza2, zza4, parseInt);
                if (this.zzzi.containsKey(com_google_android_gms_internal_zzjn)) {
                    zza3 = ((Integer) this.zzzi.get(com_google_android_gms_internal_zzjn)).intValue();
                    zzk zzhv2 = zzhJ2.zzhv();
                    zzhv2.setBackgroundColor(zza3);
                    zzhv2.zzft();
                    return;
                }
                return;
            }
            zzhJ2.zze(zza3, zza, zza2, zza4);
            return;
        }
        zzk zzhv3 = zzhJ2.zzhv();
        if (zzhv3 == null) {
            zzk.zzd(com_google_android_gms_internal_zzjn);
        } else if ("click".equals(str)) {
            Context context2 = com_google_android_gms_internal_zzjn.getContext();
            zza = zza(context2, map, "x", 0);
            zza2 = zza(context2, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza, (float) zza2, 0);
            zzhv3.zzd(obtain);
            obtain.recycle();
        } else if ("currentTime".equals(str)) {
            str2 = (String) map.get("time");
            if (str2 == null) {
                zzb.zzaH("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zzhv3.seekTo((int) (Float.parseFloat(str2) * 1000.0f));
            } catch (NumberFormatException e3) {
                zzb.zzaH("Could not parse time parameter from currentTime video GMSG: " + str2);
            }
        } else if ("hide".equals(str)) {
            zzhv3.setVisibility(4);
        } else if ("load".equals(str)) {
            zzhv3.zzfs();
        } else if ("mimetype".equals(str)) {
            zzhv3.setMimeType((String) map.get("mimetype"));
        } else if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                zzhv3.zzeU();
            } else {
                zzhv3.zzeV();
            }
        } else if ("pause".equals(str)) {
            zzhv3.pause();
        } else if ("play".equals(str)) {
            zzhv3.play();
        } else if ("show".equals(str)) {
            zzhv3.setVisibility(0);
        } else if ("src".equals(str)) {
            zzhv3.zzao((String) map.get("src"));
        } else if ("volume".equals(str)) {
            str2 = (String) map.get("volume");
            if (str2 == null) {
                zzb.zzaH("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                zzhv3.zza(Float.parseFloat(str2));
            } catch (NumberFormatException e4) {
                zzb.zzaH("Could not parse volume parameter from volume video GMSG: " + str2);
            }
        } else if ("watermark".equals(str)) {
            zzhv3.zzft();
        } else {
            zzb.zzaH("Unknown video action: " + str);
        }
    }
}
