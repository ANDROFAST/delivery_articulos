package com.google.android.gms.tagmanager;

import android.content.Context;
import java.net.URLEncoder;

public class zzz implements zzar {
    private static final Object zzbcs = new Object();
    private static zzz zzbdF;
    private zzcd zzbcV;
    private String zzbdG;
    private String zzbdH;
    private zzas zzbdI;

    private zzz(Context context) {
        this(zzat.zzaZ(context), new zzcs());
    }

    zzz(zzas com_google_android_gms_tagmanager_zzas, zzcd com_google_android_gms_tagmanager_zzcd) {
        this.zzbdI = com_google_android_gms_tagmanager_zzas;
        this.zzbcV = com_google_android_gms_tagmanager_zzcd;
    }

    public static zzar zzaX(Context context) {
        zzar com_google_android_gms_tagmanager_zzar;
        synchronized (zzbcs) {
            if (zzbdF == null) {
                zzbdF = new zzz(context);
            }
            com_google_android_gms_tagmanager_zzar = zzbdF;
        }
        return com_google_android_gms_tagmanager_zzar;
    }

    public boolean zzfo(String str) {
        if (this.zzbcV.zzlf()) {
            if (!(this.zzbdG == null || this.zzbdH == null)) {
                try {
                    str = this.zzbdG + "?" + this.zzbdH + "=" + URLEncoder.encode(str, "UTF-8");
                    zzbg.m10v("Sending wrapped url hit: " + str);
                } catch (Throwable e) {
                    zzbg.zzd("Error wrapping URL for testing.", e);
                    return false;
                }
            }
            this.zzbdI.zzfs(str);
            return true;
        }
        zzbg.zzaH("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
