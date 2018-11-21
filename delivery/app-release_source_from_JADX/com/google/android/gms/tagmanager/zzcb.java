package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class zzcb {
    private static zzcb zzbeJ;
    private volatile String zzbcF;
    private volatile zza zzbeK;
    private volatile String zzbeL;
    private volatile String zzbeM;

    enum zza {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    zzcb() {
        clear();
    }

    static zzcb zzEY() {
        zzcb com_google_android_gms_tagmanager_zzcb;
        synchronized (zzcb.class) {
            if (zzbeJ == null) {
                zzbeJ = new zzcb();
            }
            com_google_android_gms_tagmanager_zzcb = zzbeJ;
        }
        return com_google_android_gms_tagmanager_zzcb;
    }

    private String zzfw(String str) {
        return str.split("&")[0].split("=")[1];
    }

    private String zzq(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    void clear() {
        this.zzbeK = zza.NONE;
        this.zzbeL = null;
        this.zzbcF = null;
        this.zzbeM = null;
    }

    String getContainerId() {
        return this.zzbcF;
    }

    zza zzEZ() {
        return this.zzbeK;
    }

    String zzFa() {
        return this.zzbeL;
    }

    synchronized boolean zzp(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    zzbg.m10v("Container preview url: " + decode);
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.zzbeK = zza.CONTAINER_DEBUG;
                    } else {
                        this.zzbeK = zza.CONTAINER;
                    }
                    this.zzbeM = zzq(uri);
                    if (this.zzbeK == zza.CONTAINER || this.zzbeK == zza.CONTAINER_DEBUG) {
                        this.zzbeL = "/r?" + this.zzbeM;
                    }
                    this.zzbcF = zzfw(this.zzbeM);
                } else {
                    if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                        zzbg.zzaH("Invalid preview uri: " + decode);
                        z = false;
                    } else if (zzfw(uri.getQuery()).equals(this.zzbcF)) {
                        zzbg.m10v("Exit preview mode for container: " + this.zzbcF);
                        this.zzbeK = zza.NONE;
                        this.zzbeL = null;
                    } else {
                        z = false;
                    }
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }
}
