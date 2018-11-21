package com.google.android.gms.analytics.internal;

import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzny;
import java.util.HashSet;
import java.util.Set;

public class zzr {
    private final zzf zzNq;
    private volatile Boolean zzQe;
    private String zzQf;
    private Set<Integer> zzQg;

    protected zzr(zzf com_google_android_gms_analytics_internal_zzf) {
        zzx.zzy(com_google_android_gms_analytics_internal_zzf);
        this.zzNq = com_google_android_gms_analytics_internal_zzf;
    }

    public String zzkA() {
        return "google_analytics_v4.db";
    }

    public String zzkB() {
        return "google_analytics2_v4.db";
    }

    public long zzkC() {
        return 86400000;
    }

    public int zzkD() {
        return ((Integer) zzy.zzQT.get()).intValue();
    }

    public int zzkE() {
        return ((Integer) zzy.zzQU.get()).intValue();
    }

    public long zzkF() {
        return ((Long) zzy.zzQV.get()).longValue();
    }

    public long zzkG() {
        return ((Long) zzy.zzRe.get()).longValue();
    }

    public boolean zzka() {
        return zzd.zzaiU;
    }

    public boolean zzkb() {
        if (this.zzQe == null) {
            synchronized (this) {
                if (this.zzQe == null) {
                    ApplicationInfo applicationInfo = this.zzNq.getContext().getApplicationInfo();
                    String zzj = zzny.zzj(this.zzNq.getContext(), Process.myPid());
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(zzj);
                        this.zzQe = Boolean.valueOf(z);
                    }
                    if ((this.zzQe == null || !this.zzQe.booleanValue()) && "com.google.android.gms.analytics".equals(zzj)) {
                        this.zzQe = Boolean.TRUE;
                    }
                    if (this.zzQe == null) {
                        this.zzQe = Boolean.TRUE;
                        this.zzNq.zziU().zzbe("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzQe.booleanValue();
    }

    public boolean zzkc() {
        return ((Boolean) zzy.zzQq.get()).booleanValue();
    }

    public int zzkd() {
        return ((Integer) zzy.zzQJ.get()).intValue();
    }

    public int zzke() {
        return ((Integer) zzy.zzQN.get()).intValue();
    }

    public int zzkf() {
        return ((Integer) zzy.zzQO.get()).intValue();
    }

    public int zzkg() {
        return ((Integer) zzy.zzQP.get()).intValue();
    }

    public long zzkh() {
        return ((Long) zzy.zzQy.get()).longValue();
    }

    public long zzki() {
        return ((Long) zzy.zzQx.get()).longValue();
    }

    public long zzkj() {
        return ((Long) zzy.zzQB.get()).longValue();
    }

    public long zzkk() {
        return ((Long) zzy.zzQC.get()).longValue();
    }

    public int zzkl() {
        return ((Integer) zzy.zzQD.get()).intValue();
    }

    public int zzkm() {
        return ((Integer) zzy.zzQE.get()).intValue();
    }

    public long zzkn() {
        return (long) ((Integer) zzy.zzQR.get()).intValue();
    }

    public String zzko() {
        return (String) zzy.zzQG.get();
    }

    public String zzkp() {
        return (String) zzy.zzQF.get();
    }

    public String zzkq() {
        return (String) zzy.zzQH.get();
    }

    public String zzkr() {
        return (String) zzy.zzQI.get();
    }

    public zzm zzks() {
        return zzm.zzbj((String) zzy.zzQK.get());
    }

    public zzo zzkt() {
        return zzo.zzbk((String) zzy.zzQL.get());
    }

    public Set<Integer> zzku() {
        String str = (String) zzy.zzQQ.get();
        if (this.zzQg == null || this.zzQf == null || !this.zzQf.equals(str)) {
            String[] split = TextUtils.split(str, ",");
            Set hashSet = new HashSet();
            for (String parseInt : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(parseInt)));
                } catch (NumberFormatException e) {
                }
            }
            this.zzQf = str;
            this.zzQg = hashSet;
        }
        return this.zzQg;
    }

    public long zzkv() {
        return ((Long) zzy.zzQZ.get()).longValue();
    }

    public long zzkw() {
        return ((Long) zzy.zzRa.get()).longValue();
    }

    public long zzkx() {
        return ((Long) zzy.zzRd.get()).longValue();
    }

    public int zzky() {
        return ((Integer) zzy.zzQu.get()).intValue();
    }

    public int zzkz() {
        return ((Integer) zzy.zzQw.get()).intValue();
    }
}
