package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;

@zzha
public final class zzdj implements zzdl {
    private void zzb(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        String str = (String) map.get(PlusShare.KEY_CALL_TO_ACTION_LABEL);
        String str2 = (String) map.get("start_label");
        String str3 = (String) map.get("timestamp");
        if (TextUtils.isEmpty(str)) {
            zzb.zzaH("No label given for CSI tick.");
        } else if (TextUtils.isEmpty(str3)) {
            zzb.zzaH("No timestamp given for CSI tick.");
        } else {
            try {
                long zzc = zzc(Long.parseLong(str3));
                if (TextUtils.isEmpty(str2)) {
                    str2 = "native:view_load";
                }
                com_google_android_gms_internal_zzjn.zzhL().zza(str, str2, zzc);
            } catch (Throwable e) {
                zzb.zzd("Malformed timestamp for CSI tick.", e);
            }
        }
    }

    private long zzc(long j) {
        return (j - zzp.zzbB().currentTimeMillis()) + zzp.zzbB().elapsedRealtime();
    }

    private void zzc(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        String str = (String) map.get("value");
        if (TextUtils.isEmpty(str)) {
            zzb.zzaH("No value given for CSI experiment.");
            return;
        }
        zzch zzdt = com_google_android_gms_internal_zzjn.zzhL().zzdt();
        if (zzdt == null) {
            zzb.zzaH("No ticker for WebView, dropping experiment ID.");
        } else {
            zzdt.zzd("e", str);
        }
    }

    private void zzd(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        String str = (String) map.get("name");
        String str2 = (String) map.get("value");
        if (TextUtils.isEmpty(str2)) {
            zzb.zzaH("No value given for CSI extra.");
        } else if (TextUtils.isEmpty(str)) {
            zzb.zzaH("No name given for CSI extra.");
        } else {
            zzch zzdt = com_google_android_gms_internal_zzjn.zzhL().zzdt();
            if (zzdt == null) {
                zzb.zzaH("No ticker for WebView, dropping extra parameter.");
            } else {
                zzdt.zzd(str, str2);
            }
        }
    }

    public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            zzb(com_google_android_gms_internal_zzjn, map);
        } else if ("experiment".equals(str)) {
            zzc(com_google_android_gms_internal_zzjn, map);
        } else if ("extra".equals(str)) {
            zzd(com_google_android_gms_internal_zzjn, map);
        }
    }
}
