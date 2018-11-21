package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcd;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzit;
import com.google.android.gms.internal.zzit.zza;
import com.google.android.gms.internal.zzit.zzb;
import java.util.concurrent.TimeUnit;

@zzha
public class zzp {
    private final Context mContext;
    private final String zzDX;
    private final VersionInfoParcel zzDY;
    private final zzcf zzDZ;
    private final zzch zzEa;
    private final zzit zzEb = new zzb().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzhi();
    private final long[] zzEc;
    private final String[] zzEd;
    private zzcf zzEe;
    private zzcf zzEf;
    private zzcf zzEg;
    private zzcf zzEh;
    private boolean zzEi;
    private zzi zzEj;
    private boolean zzEk;
    private boolean zzEl;
    private long zzEm = -1;

    public zzp(Context context, VersionInfoParcel versionInfoParcel, String str, zzch com_google_android_gms_internal_zzch, zzcf com_google_android_gms_internal_zzcf) {
        this.mContext = context;
        this.zzDY = versionInfoParcel;
        this.zzDX = str;
        this.zzEa = com_google_android_gms_internal_zzch;
        this.zzDZ = com_google_android_gms_internal_zzcf;
        String str2 = (String) zzbz.zzvA.get();
        if (str2 == null) {
            this.zzEd = new String[0];
            this.zzEc = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzEd = new String[split.length];
        this.zzEc = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzEc[i] = Long.parseLong(split[i]);
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Unable to parse frame hash target time number.", e);
                this.zzEc[i] = -1;
            }
        }
    }

    private void zzc(zzi com_google_android_gms_ads_internal_overlay_zzi) {
        long longValue = ((Long) zzbz.zzvB.get()).longValue();
        long currentPosition = (long) com_google_android_gms_ads_internal_overlay_zzi.getCurrentPosition();
        int i = 0;
        while (i < this.zzEd.length) {
            if (this.zzEd[i] == null && longValue > Math.abs(currentPosition - this.zzEc[i])) {
                this.zzEd[i] = zza((TextureView) com_google_android_gms_ads_internal_overlay_zzi);
                return;
            }
            i++;
        }
    }

    private void zzfA() {
        if (this.zzEg != null && this.zzEh == null) {
            zzcd.zza(this.zzEa, this.zzEg, "vff");
            zzcd.zza(this.zzEa, this.zzDZ, "vtt");
            this.zzEh = zzcd.zzb(this.zzEa);
        }
        long nanoTime = com.google.android.gms.ads.internal.zzp.zzbB().nanoTime();
        if (this.zzEi && this.zzEl && this.zzEm != -1) {
            this.zzEb.zza(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzEm)));
        }
        this.zzEl = this.zzEi;
        this.zzEm = nanoTime;
    }

    public void onStop() {
        if (((Boolean) zzbz.zzvz.get()).booleanValue() && !this.zzEk) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzDX);
            bundle.putString("player", this.zzEj.zzeO());
            for (zza com_google_android_gms_internal_zzit_zza : this.zzEb.getBuckets()) {
                bundle.putString("fps_c_" + com_google_android_gms_internal_zzit_zza.name, Integer.toString(com_google_android_gms_internal_zzit_zza.count));
                bundle.putString("fps_p_" + com_google_android_gms_internal_zzit_zza.name, Double.toString(com_google_android_gms_internal_zzit_zza.zzLg));
            }
            for (int i = 0; i < this.zzEc.length; i++) {
                String str = this.zzEd[i];
                if (str != null) {
                    bundle.putString("fh_" + Long.valueOf(this.zzEc[i]), str);
                }
            }
            com.google.android.gms.ads.internal.zzp.zzbx().zza(this.mContext, this.zzDY.afmaVersion, "gmob-apps", bundle, true);
            this.zzEk = true;
        }
    }

    String zza(TextureView textureView) {
        Bitmap bitmap = textureView.getBitmap(8, 8);
        long j = 0;
        long j2 = 63;
        int i = 0;
        while (i < 8) {
            long j3 = j;
            j = j2;
            for (int i2 = 0; i2 < 8; i2++) {
                int pixel = bitmap.getPixel(i2, i);
                j3 |= (Color.green(pixel) + (Color.blue(pixel) + Color.red(pixel)) > 128 ? 1 : 0) << ((int) j);
                j--;
            }
            i++;
            j2 = j;
            j = j3;
        }
        return String.format("%016X", new Object[]{Long.valueOf(j)});
    }

    public void zza(zzi com_google_android_gms_ads_internal_overlay_zzi) {
        zzcd.zza(this.zzEa, this.zzDZ, "vpc");
        this.zzEe = zzcd.zzb(this.zzEa);
        this.zzEj = com_google_android_gms_ads_internal_overlay_zzi;
    }

    public void zzb(zzi com_google_android_gms_ads_internal_overlay_zzi) {
        zzfA();
        zzc(com_google_android_gms_ads_internal_overlay_zzi);
    }

    public void zzfB() {
        this.zzEi = true;
        if (this.zzEf != null && this.zzEg == null) {
            zzcd.zza(this.zzEa, this.zzEf, "vfp");
            this.zzEg = zzcd.zzb(this.zzEa);
        }
    }

    public void zzfC() {
        this.zzEi = false;
    }

    public void zzfo() {
        if (this.zzEe != null && this.zzEf == null) {
            zzcd.zza(this.zzEa, this.zzEe, "vfr");
            this.zzEf = zzcd.zzb(this.zzEa);
        }
    }
}
