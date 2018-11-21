package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzld.zza;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class zzle implements zzld {
    protected final Activity mActivity;
    protected final Set<String> zzVH;
    private String zzVt;
    private String zzWq;
    private zza zzWz;

    protected zzle(Activity activity, List<String> list, List<String> list2) {
        this.mActivity = (Activity) zzx.zzy(activity);
        Set hashSet = new HashSet((Collection) zzx.zzy(list));
        hashSet.addAll((Collection) zzx.zzy(list2));
        this.zzVH = Collections.unmodifiableSet(hashSet);
    }

    protected Intent zza(IdpTokenType idpTokenType, String str, String str2) {
        zzx.zzy(idpTokenType);
        zzx.zzcG(str);
        Intent intent = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        intent.putExtra("idpTokenType", idpTokenType);
        intent.putExtra("idpToken", str);
        intent.putExtra("pendingToken", str2);
        zze zzna = zzna();
        if (zzna != null) {
            intent.putExtra("idProvider", zzna.zzmC());
        }
        return intent;
    }

    protected void zzb(zza com_google_android_gms_internal_zzld_zza) {
        this.zzWz = (zza) zzx.zzy(com_google_android_gms_internal_zzld_zza);
    }

    protected void zzb(String str, String str2, zza com_google_android_gms_internal_zzld_zza) {
        zzbR(str);
        zzbS(str2);
        zzb(com_google_android_gms_internal_zzld_zza);
    }

    protected void zzbR(String str) {
        this.zzVt = str;
    }

    protected void zzbS(String str) {
        this.zzWq = str;
    }

    protected Set<String> zznb() {
        return this.zzVH;
    }

    protected zza zznc() {
        return this.zzWz;
    }

    protected String zznd() {
        return this.zzWq;
    }
}
