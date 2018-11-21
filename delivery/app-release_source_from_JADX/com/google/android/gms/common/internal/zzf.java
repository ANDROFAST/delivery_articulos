package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzsd;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzf {
    private final Account zzSo;
    private final String zzTz;
    private final Set<Scope> zzaeA;
    private final int zzaeC;
    private final View zzaeD;
    private final String zzaeE;
    private final zzsd zzaeP;
    private final Set<Scope> zzajr;
    private final Map<Api<?>, zza> zzajs;
    private Integer zzajt;

    public static final class zza {
        public final Set<Scope> zzVH;
        public final boolean zzaju;

        public zza(Set<Scope> set, boolean z) {
            zzx.zzy(set);
            this.zzVH = Collections.unmodifiableSet(set);
            this.zzaju = z;
        }
    }

    public zzf(Account account, Set<Scope> set, Map<Api<?>, zza> map, int i, View view, String str, String str2, zzsd com_google_android_gms_internal_zzsd) {
        Map map2;
        this.zzSo = account;
        this.zzaeA = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.zzajs = map2;
        this.zzaeD = view;
        this.zzaeC = i;
        this.zzTz = str;
        this.zzaeE = str2;
        this.zzaeP = com_google_android_gms_internal_zzsd;
        Set hashSet = new HashSet(this.zzaeA);
        for (zza com_google_android_gms_common_internal_zzf_zza : this.zzajs.values()) {
            hashSet.addAll(com_google_android_gms_common_internal_zzf_zza.zzVH);
        }
        this.zzajr = Collections.unmodifiableSet(hashSet);
    }

    public static zzf zzas(Context context) {
        return new Builder(context).zzoH();
    }

    public Account getAccount() {
        return this.zzSo;
    }

    @Deprecated
    public String getAccountName() {
        return this.zzSo != null ? this.zzSo.name : null;
    }

    public void zza(Integer num) {
        this.zzajt = num;
    }

    public Set<Scope> zzb(Api<?> api) {
        zza com_google_android_gms_common_internal_zzf_zza = (zza) this.zzajs.get(api);
        if (com_google_android_gms_common_internal_zzf_zza == null || com_google_android_gms_common_internal_zzf_zza.zzVH.isEmpty()) {
            return this.zzaeA;
        }
        Set<Scope> hashSet = new HashSet(this.zzaeA);
        hashSet.addAll(com_google_android_gms_common_internal_zzf_zza.zzVH);
        return hashSet;
    }

    public Account zzpY() {
        return this.zzSo != null ? this.zzSo : new Account("<<default account>>", GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
    }

    public int zzpZ() {
        return this.zzaeC;
    }

    public Set<Scope> zzqa() {
        return this.zzaeA;
    }

    public Set<Scope> zzqb() {
        return this.zzajr;
    }

    public Map<Api<?>, zza> zzqc() {
        return this.zzajs;
    }

    public String zzqd() {
        return this.zzTz;
    }

    public String zzqe() {
        return this.zzaeE;
    }

    public View zzqf() {
        return this.zzaeD;
    }

    public zzsd zzqg() {
        return this.zzaeP;
    }

    public Integer zzqh() {
        return this.zzajt;
    }
}
