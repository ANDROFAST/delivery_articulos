package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzfp.zza;
import java.util.Map;

@zzha
public class zzfq extends zzfr implements zzdl {
    private final Context mContext;
    DisplayMetrics zzCA;
    private float zzCB;
    int zzCC = -1;
    int zzCD = -1;
    private int zzCE;
    int zzCF = -1;
    int zzCG = -1;
    int zzCH = -1;
    int zzCI = -1;
    private final zzbr zzCz;
    private final zzjn zzps;
    private final WindowManager zzrR;

    public zzfq(zzjn com_google_android_gms_internal_zzjn, Context context, zzbr com_google_android_gms_internal_zzbr) {
        super(com_google_android_gms_internal_zzjn);
        this.zzps = com_google_android_gms_internal_zzjn;
        this.mContext = context;
        this.zzCz = com_google_android_gms_internal_zzbr;
        this.zzrR = (WindowManager) context.getSystemService("window");
    }

    private void zzeF() {
        this.zzCA = new DisplayMetrics();
        Display defaultDisplay = this.zzrR.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzCA);
        this.zzCB = this.zzCA.density;
        this.zzCE = defaultDisplay.getRotation();
    }

    private void zzeK() {
        int[] iArr = new int[2];
        this.zzps.getLocationOnScreen(iArr);
        zzf(zzl.zzcN().zzc(this.mContext, iArr[0]), zzl.zzcN().zzc(this.mContext, iArr[1]));
    }

    private zzfp zzeN() {
        return new zza().zzr(this.zzCz.zzdd()).zzq(this.zzCz.zzde()).zzs(this.zzCz.zzdi()).zzt(this.zzCz.zzdf()).zzu(this.zzCz.zzdg()).zzeE();
    }

    public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        zzeI();
    }

    void zzeG() {
        this.zzCC = zzl.zzcN().zzb(this.zzCA, this.zzCA.widthPixels);
        this.zzCD = zzl.zzcN().zzb(this.zzCA, this.zzCA.heightPixels);
        Activity zzhx = this.zzps.zzhx();
        if (zzhx == null || zzhx.getWindow() == null) {
            this.zzCF = this.zzCC;
            this.zzCG = this.zzCD;
            return;
        }
        int[] zzg = zzp.zzbx().zzg(zzhx);
        this.zzCF = zzl.zzcN().zzb(this.zzCA, zzg[0]);
        this.zzCG = zzl.zzcN().zzb(this.zzCA, zzg[1]);
    }

    void zzeH() {
        if (this.zzps.zzaP().zztW) {
            this.zzCH = this.zzCC;
            this.zzCI = this.zzCD;
            return;
        }
        this.zzps.measure(0, 0);
        this.zzCH = zzl.zzcN().zzc(this.mContext, this.zzps.getMeasuredWidth());
        this.zzCI = zzl.zzcN().zzc(this.mContext, this.zzps.getMeasuredHeight());
    }

    public void zzeI() {
        zzeF();
        zzeG();
        zzeH();
        zzeL();
        zzeM();
        zzeK();
        zzeJ();
    }

    void zzeJ() {
        if (zzb.zzQ(2)) {
            zzb.zzaG("Dispatching Ready Event.");
        }
        zzam(this.zzps.zzhF().afmaVersion);
    }

    void zzeL() {
        zza(this.zzCC, this.zzCD, this.zzCF, this.zzCG, this.zzCB, this.zzCE);
    }

    void zzeM() {
        this.zzps.zzb("onDeviceFeaturesReceived", zzeN().toJson());
    }

    public void zzf(int i, int i2) {
        zzc(i, i2 - (this.mContext instanceof Activity ? zzp.zzbx().zzj((Activity) this.mContext)[0] : 0), this.zzCH, this.zzCI);
        this.zzps.zzhC().zze(i, i2);
    }
}
