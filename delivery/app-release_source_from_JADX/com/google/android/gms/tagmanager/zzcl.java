package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.zzaf.zzj;
import com.google.android.gms.internal.zzsh;
import com.google.android.gms.internal.zzsl;
import com.google.android.gms.internal.zzsm;
import com.google.android.gms.tagmanager.zzbf.zza;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

class zzcl implements Runnable {
    private final Context mContext;
    private final String zzbcF;
    private volatile String zzbdc;
    private final zzsm zzbeX;
    private final String zzbeY;
    private zzbf<zzj> zzbeZ;
    private volatile zzs zzbfa;
    private volatile String zzbfb;

    zzcl(Context context, String str, zzsm com_google_android_gms_internal_zzsm, zzs com_google_android_gms_tagmanager_zzs) {
        this.mContext = context;
        this.zzbeX = com_google_android_gms_internal_zzsm;
        this.zzbcF = str;
        this.zzbfa = com_google_android_gms_tagmanager_zzs;
        this.zzbeY = "/r?id=" + str;
        this.zzbdc = this.zzbeY;
        this.zzbfb = null;
    }

    public zzcl(Context context, String str, zzs com_google_android_gms_tagmanager_zzs) {
        this(context, str, new zzsm(), com_google_android_gms_tagmanager_zzs);
    }

    private boolean zzFb() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbg.m10v("...no network connectivity");
        return false;
    }

    private void zzFc() {
        if (zzFb()) {
            zzbg.m10v("Start loading resource from network ...");
            String zzFd = zzFd();
            zzsl zzGf = this.zzbeX.zzGf();
            try {
                InputStream zzfU = zzGf.zzfU(zzFd);
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    zzsh.zzb(zzfU, byteArrayOutputStream);
                    zzj zzd = zzj.zzd(byteArrayOutputStream.toByteArray());
                    zzbg.m10v("Successfully loaded supplemented resource: " + zzd);
                    if (zzd.zzjl == null && zzd.zzjk.length == 0) {
                        zzbg.m10v("No change for container: " + this.zzbcF);
                    }
                    this.zzbeZ.zzI(zzd);
                    zzbg.m10v("Load resource from network finished.");
                } catch (Throwable e) {
                    zzbg.zzd("Error when parsing downloaded resources from url: " + zzFd + " " + e.getMessage(), e);
                    this.zzbeZ.zza(zza.SERVER_ERROR);
                    zzGf.close();
                }
            } catch (FileNotFoundException e2) {
                zzbg.zzaH("No data is retrieved from the given url: " + zzFd + ". Make sure container_id: " + this.zzbcF + " is correct.");
                this.zzbeZ.zza(zza.SERVER_ERROR);
            } catch (Throwable e3) {
                zzbg.zzd("Error when loading resources from url: " + zzFd + " " + e3.getMessage(), e3);
                this.zzbeZ.zza(zza.IO_ERROR);
            } finally {
                zzGf.close();
            }
        } else {
            this.zzbeZ.zza(zza.NOT_AVAILABLE);
        }
    }

    public void run() {
        if (this.zzbeZ == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.zzbeZ.zzEo();
        zzFc();
    }

    String zzFd() {
        String str = this.zzbfa.zzEq() + this.zzbdc + "&v=a65833898";
        if (!(this.zzbfb == null || this.zzbfb.trim().equals(""))) {
            str = str + "&pv=" + this.zzbfb;
        }
        return zzcb.zzEY().zzEZ().equals(zza.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    void zza(zzbf<zzj> com_google_android_gms_tagmanager_zzbf_com_google_android_gms_internal_zzaf_zzj) {
        this.zzbeZ = com_google_android_gms_tagmanager_zzbf_com_google_android_gms_internal_zzaf_zzj;
    }

    void zzfi(String str) {
        if (str == null) {
            this.zzbdc = this.zzbeY;
            return;
        }
        zzbg.zzaF("Setting CTFE URL path: " + str);
        this.zzbdc = str;
    }

    void zzfx(String str) {
        zzbg.zzaF("Setting previous container version: " + str);
        this.zzbfb = str;
    }
}
