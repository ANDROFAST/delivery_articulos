package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import java.util.UUID;

public class zzai extends zzd {
    private SharedPreferences zzRN;
    private long zzRO;
    private long zzRP = -1;
    private final zza zzRQ = new zza("monitoring", zziV().zzkG());

    public final class zza {
        private final String mName;
        private final long zzRR;
        final /* synthetic */ zzai zzRS;

        private zza(zzai com_google_android_gms_analytics_internal_zzai, String str, long j) {
            this.zzRS = com_google_android_gms_analytics_internal_zzai;
            zzx.zzcG(str);
            zzx.zzab(j > 0);
            this.mName = str;
            this.zzRR = j;
        }

        private void zzlu() {
            long currentTimeMillis = this.zzRS.zziT().currentTimeMillis();
            Editor edit = this.zzRS.zzRN.edit();
            edit.remove(zzlz());
            edit.remove(zzlA());
            edit.putLong(zzly(), currentTimeMillis);
            edit.commit();
        }

        private long zzlv() {
            long zzlx = zzlx();
            return zzlx == 0 ? 0 : Math.abs(zzlx - this.zzRS.zziT().currentTimeMillis());
        }

        private long zzlx() {
            return this.zzRS.zzRN.getLong(zzly(), 0);
        }

        private String zzly() {
            return this.mName + ":start";
        }

        private String zzlz() {
            return this.mName + ":count";
        }

        public void zzbn(String str) {
            if (zzlx() == 0) {
                zzlu();
            }
            if (str == null) {
                str = "";
            }
            synchronized (this) {
                long j = this.zzRS.zzRN.getLong(zzlz(), 0);
                if (j <= 0) {
                    Editor edit = this.zzRS.zzRN.edit();
                    edit.putString(zzlA(), str);
                    edit.putLong(zzlz(), 1);
                    edit.apply();
                    return;
                }
                Object obj = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (j + 1) ? 1 : null;
                Editor edit2 = this.zzRS.zzRN.edit();
                if (obj != null) {
                    edit2.putString(zzlA(), str);
                }
                edit2.putLong(zzlz(), j + 1);
                edit2.apply();
            }
        }

        protected String zzlA() {
            return this.mName + ":value";
        }

        public Pair<String, Long> zzlw() {
            long zzlv = zzlv();
            if (zzlv < this.zzRR) {
                return null;
            }
            if (zzlv > this.zzRR * 2) {
                zzlu();
                return null;
            }
            String string = this.zzRS.zzRN.getString(zzlA(), null);
            zzlv = this.zzRS.zzRN.getLong(zzlz(), 0);
            zzlu();
            return (string == null || zzlv <= 0) ? null : new Pair(string, Long.valueOf(zzlv));
        }
    }

    protected zzai(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
    }

    public void zzbm(String str) {
        zziS();
        zzje();
        Editor edit = this.zzRN.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            zzbd("Failed to commit campaign data");
        }
    }

    protected void zzir() {
        this.zzRN = getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public long zzlo() {
        zziS();
        zzje();
        if (this.zzRO == 0) {
            long j = this.zzRN.getLong("first_run", 0);
            if (j != 0) {
                this.zzRO = j;
            } else {
                j = zziT().currentTimeMillis();
                Editor edit = this.zzRN.edit();
                edit.putLong("first_run", j);
                if (!edit.commit()) {
                    zzbd("Failed to commit first run time");
                }
                this.zzRO = j;
            }
        }
        return this.zzRO;
    }

    public zzaj zzlp() {
        return new zzaj(zziT(), zzlo());
    }

    public long zzlq() {
        zziS();
        zzje();
        if (this.zzRP == -1) {
            this.zzRP = this.zzRN.getLong("last_dispatch", 0);
        }
        return this.zzRP;
    }

    public void zzlr() {
        zziS();
        zzje();
        long currentTimeMillis = zziT().currentTimeMillis();
        Editor edit = this.zzRN.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.zzRP = currentTimeMillis;
    }

    public String zzls() {
        zziS();
        zzje();
        CharSequence string = this.zzRN.getString("installation_campaign", null);
        return TextUtils.isEmpty(string) ? null : string;
    }

    public zza zzlt() {
        return this.zzRQ;
    }
}
