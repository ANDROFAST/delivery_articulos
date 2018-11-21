package com.google.android.gms.internal;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import java.util.Set;

@zzha
public class zzfm extends zzfr {
    static final Set<String> zzCa = zznm.zzc("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private AdSizeParcel zzBh;
    private String zzCb = "top-right";
    private boolean zzCc = true;
    private int zzCd = 0;
    private int zzCe = 0;
    private int zzCf = 0;
    private int zzCg = 0;
    private final Activity zzCh;
    private ImageView zzCi;
    private LinearLayout zzCj;
    private zzfs zzCk;
    private PopupWindow zzCl;
    private RelativeLayout zzCm;
    private ViewGroup zzCn;
    private int zzov = -1;
    private int zzow = -1;
    private final Object zzpK = new Object();
    private final zzjn zzps;

    class C03091 implements OnClickListener {
        final /* synthetic */ zzfm zzCo;

        C03091(zzfm com_google_android_gms_internal_zzfm) {
            this.zzCo = com_google_android_gms_internal_zzfm;
        }

        public void onClick(View view) {
            this.zzCo.zzp(true);
        }
    }

    public zzfm(zzjn com_google_android_gms_internal_zzjn, zzfs com_google_android_gms_internal_zzfs) {
        super(com_google_android_gms_internal_zzjn, "resize");
        this.zzps = com_google_android_gms_internal_zzjn;
        this.zzCh = com_google_android_gms_internal_zzjn.zzhx();
        this.zzCk = com_google_android_gms_internal_zzfs;
    }

    private int[] zzeB() {
        if (!zzeD()) {
            return null;
        }
        if (this.zzCc) {
            return new int[]{this.zzCd + this.zzCf, this.zzCe + this.zzCg};
        }
        int[] zzh = zzp.zzbx().zzh(this.zzCh);
        int[] zzj = zzp.zzbx().zzj(this.zzCh);
        int i = zzh[0];
        int i2 = this.zzCd + this.zzCf;
        int i3 = this.zzCe + this.zzCg;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.zzov + i2 > i) {
            i2 = i - this.zzov;
        }
        if (i3 < zzj[0]) {
            i3 = zzj[0];
        } else if (this.zzow + i3 > zzj[1]) {
            i3 = zzj[1] - this.zzow;
        }
        return new int[]{i2, i3};
    }

    private void zzf(Map<String, String> map) {
        if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
            this.zzov = zzp.zzbx().zzaA((String) map.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
            this.zzow = zzp.zzbx().zzaA((String) map.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
            this.zzCf = zzp.zzbx().zzaA((String) map.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
            this.zzCg = zzp.zzbx().zzaA((String) map.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
            this.zzCc = Boolean.parseBoolean((String) map.get("allowOffscreen"));
        }
        String str = (String) map.get("customClosePosition");
        if (!TextUtils.isEmpty(str)) {
            this.zzCb = str;
        }
    }

    public void zza(int i, int i2, boolean z) {
        synchronized (this.zzpK) {
            this.zzCd = i;
            this.zzCe = i2;
            if (this.zzCl != null && z) {
                int[] zzeB = zzeB();
                if (zzeB != null) {
                    this.zzCl.update(zzl.zzcN().zzb(this.zzCh, zzeB[0]), zzl.zzcN().zzb(this.zzCh, zzeB[1]), this.zzCl.getWidth(), this.zzCl.getHeight());
                    zzd(zzeB[0], zzeB[1]);
                } else {
                    zzp(true);
                }
            }
        }
    }

    void zzc(int i, int i2) {
        if (this.zzCk != null) {
            this.zzCk.zza(i, i2, this.zzov, this.zzow);
        }
    }

    void zzd(int i, int i2) {
        zzb(i, i2 - zzp.zzbx().zzj(this.zzCh)[0], this.zzov, this.zzow);
    }

    public void zze(int i, int i2) {
        this.zzCd = i;
        this.zzCe = i2;
    }

    boolean zzeA() {
        return this.zzov > -1 && this.zzow > -1;
    }

    public boolean zzeC() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzCl != null;
        }
        return z;
    }

    boolean zzeD() {
        int[] zzh = zzp.zzbx().zzh(this.zzCh);
        int[] zzj = zzp.zzbx().zzj(this.zzCh);
        int i = zzh[0];
        int i2 = zzh[1];
        if (this.zzov < 50 || this.zzov > i) {
            zzb.zzaH("Width is too small or too large.");
            return false;
        } else if (this.zzow < 50 || this.zzow > i2) {
            zzb.zzaH("Height is too small or too large.");
            return false;
        } else if (this.zzow == i2 && this.zzov == i) {
            zzb.zzaH("Cannot resize to a full-screen ad.");
            return false;
        } else {
            if (this.zzCc) {
                int i3;
                String str = this.zzCb;
                boolean z = true;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            z = false;
                            break;
                        }
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        i3 = this.zzCf + this.zzCd;
                        i2 = this.zzCe + this.zzCg;
                        break;
                    case true:
                        i3 = ((this.zzCd + this.zzCf) + (this.zzov / 2)) - 25;
                        i2 = this.zzCe + this.zzCg;
                        break;
                    case true:
                        i3 = ((this.zzCd + this.zzCf) + (this.zzov / 2)) - 25;
                        i2 = ((this.zzCe + this.zzCg) + (this.zzow / 2)) - 25;
                        break;
                    case true:
                        i3 = this.zzCf + this.zzCd;
                        i2 = ((this.zzCe + this.zzCg) + this.zzow) - 50;
                        break;
                    case true:
                        i3 = ((this.zzCd + this.zzCf) + (this.zzov / 2)) - 25;
                        i2 = ((this.zzCe + this.zzCg) + this.zzow) - 50;
                        break;
                    case true:
                        i3 = ((this.zzCd + this.zzCf) + this.zzov) - 50;
                        i2 = ((this.zzCe + this.zzCg) + this.zzow) - 50;
                        break;
                    default:
                        i3 = ((this.zzCd + this.zzCf) + this.zzov) - 50;
                        i2 = this.zzCe + this.zzCg;
                        break;
                }
                if (i3 < 0 || i3 + 50 > i || r2 < zzj[0] || r2 + 50 > zzj[1]) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzg(java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
        r12 = this;
        r4 = -1;
        r5 = 1;
        r3 = 0;
        r6 = r12.zzpK;
        monitor-enter(r6);
        r1 = r12.zzCh;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0011;
    L_0x000a:
        r1 = "Not an activity context. Cannot resize.";
        r12.zzal(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
    L_0x0010:
        return;
    L_0x0011:
        r1 = r12.zzps;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzaP();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0023;
    L_0x0019:
        r1 = "Webview is not yet available, size is not set.";
        r12.zzal(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0020:
        r1 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        throw r1;
    L_0x0023:
        r1 = r12.zzps;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzaP();	 Catch:{ all -> 0x0020 }
        r1 = r1.zztW;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0034;
    L_0x002d:
        r1 = "Is interstitial. Cannot resize an interstitial.";
        r12.zzal(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0034:
        r1 = r12.zzps;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzhG();	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0043;
    L_0x003c:
        r1 = "Cannot resize an expanded banner.";
        r12.zzal(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0043:
        r12.zzf(r13);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzeA();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0053;
    L_0x004c:
        r1 = "Invalid width and height options. Cannot resize.";
        r12.zzal(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0053:
        r1 = r12.zzCh;	 Catch:{ all -> 0x0020 }
        r7 = r1.getWindow();	 Catch:{ all -> 0x0020 }
        if (r7 == 0) goto L_0x0061;
    L_0x005b:
        r1 = r7.getDecorView();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0068;
    L_0x0061:
        r1 = "Activity context is not ready, cannot get window or decor view.";
        r12.zzal(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0068:
        r8 = r12.zzeB();	 Catch:{ all -> 0x0020 }
        if (r8 != 0) goto L_0x0075;
    L_0x006e:
        r1 = "Resize location out of screen or close button is not visible.";
        r12.zzal(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0075:
        r1 = com.google.android.gms.ads.internal.client.zzl.zzcN();	 Catch:{ all -> 0x0020 }
        r2 = r12.zzCh;	 Catch:{ all -> 0x0020 }
        r9 = r12.zzov;	 Catch:{ all -> 0x0020 }
        r9 = r1.zzb(r2, r9);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.client.zzl.zzcN();	 Catch:{ all -> 0x0020 }
        r2 = r12.zzCh;	 Catch:{ all -> 0x0020 }
        r10 = r12.zzow;	 Catch:{ all -> 0x0020 }
        r10 = r1.zzb(r2, r10);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzps;	 Catch:{ all -> 0x0020 }
        r1 = r1.getView();	 Catch:{ all -> 0x0020 }
        r2 = r1.getParent();	 Catch:{ all -> 0x0020 }
        if (r2 == 0) goto L_0x01d5;
    L_0x0099:
        r1 = r2 instanceof android.view.ViewGroup;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x01d5;
    L_0x009d:
        r0 = r2;
        r0 = (android.view.ViewGroup) r0;	 Catch:{ all -> 0x0020 }
        r1 = r0;
        r11 = r12.zzps;	 Catch:{ all -> 0x0020 }
        r11 = r11.getView();	 Catch:{ all -> 0x0020 }
        r1.removeView(r11);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzCl;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01ce;
    L_0x00ae:
        r2 = (android.view.ViewGroup) r2;	 Catch:{ all -> 0x0020 }
        r12.zzCn = r2;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.zzp.zzbx();	 Catch:{ all -> 0x0020 }
        r2 = r12.zzps;	 Catch:{ all -> 0x0020 }
        r2 = r2.getView();	 Catch:{ all -> 0x0020 }
        r1 = r1.zzl(r2);	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.ImageView;	 Catch:{ all -> 0x0020 }
        r11 = r12.zzCh;	 Catch:{ all -> 0x0020 }
        r2.<init>(r11);	 Catch:{ all -> 0x0020 }
        r12.zzCi = r2;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzCi;	 Catch:{ all -> 0x0020 }
        r2.setImageBitmap(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzps;	 Catch:{ all -> 0x0020 }
        r1 = r1.zzaP();	 Catch:{ all -> 0x0020 }
        r12.zzBh = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.zzCn;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzCi;	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
    L_0x00dd:
        r1 = new android.widget.RelativeLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzCh;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.zzCm = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.zzCm;	 Catch:{ all -> 0x0020 }
        r2 = 0;
        r1.setBackgroundColor(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzCm;	 Catch:{ all -> 0x0020 }
        r2 = new android.view.ViewGroup$LayoutParams;	 Catch:{ all -> 0x0020 }
        r2.<init>(r9, r10);	 Catch:{ all -> 0x0020 }
        r1.setLayoutParams(r2);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.zzp.zzbx();	 Catch:{ all -> 0x0020 }
        r2 = r12.zzCm;	 Catch:{ all -> 0x0020 }
        r11 = 0;
        r1 = r1.zza(r2, r9, r10, r11);	 Catch:{ all -> 0x0020 }
        r12.zzCl = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.zzCl;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setOutsideTouchable(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzCl;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setTouchable(r2);	 Catch:{ all -> 0x0020 }
        r2 = r12.zzCl;	 Catch:{ all -> 0x0020 }
        r1 = r12.zzCc;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01dd;
    L_0x0115:
        r1 = r5;
    L_0x0116:
        r2.setClippingEnabled(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzCm;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzps;	 Catch:{ all -> 0x0020 }
        r2 = r2.getView();	 Catch:{ all -> 0x0020 }
        r9 = -1;
        r10 = -1;
        r1.addView(r2, r9, r10);	 Catch:{ all -> 0x0020 }
        r1 = new android.widget.LinearLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzCh;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.zzCj = r1;	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.RelativeLayout$LayoutParams;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.client.zzl.zzcN();	 Catch:{ all -> 0x0020 }
        r9 = r12.zzCh;	 Catch:{ all -> 0x0020 }
        r10 = 50;
        r1 = r1.zzb(r9, r10);	 Catch:{ all -> 0x0020 }
        r9 = com.google.android.gms.ads.internal.client.zzl.zzcN();	 Catch:{ all -> 0x0020 }
        r10 = r12.zzCh;	 Catch:{ all -> 0x0020 }
        r11 = 50;
        r9 = r9.zzb(r10, r11);	 Catch:{ all -> 0x0020 }
        r2.<init>(r1, r9);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzCb;	 Catch:{ all -> 0x0020 }
        r9 = r1.hashCode();	 Catch:{ all -> 0x0020 }
        switch(r9) {
            case -1364013995: goto L_0x01f6;
            case -1012429441: goto L_0x01e0;
            case -655373719: goto L_0x0201;
            case 1163912186: goto L_0x0217;
            case 1288627767: goto L_0x020c;
            case 1755462605: goto L_0x01eb;
            default: goto L_0x0155;
        };	 Catch:{ all -> 0x0020 }
    L_0x0155:
        r1 = r4;
    L_0x0156:
        switch(r1) {
            case 0: goto L_0x0222;
            case 1: goto L_0x022e;
            case 2: goto L_0x023a;
            case 3: goto L_0x0241;
            case 4: goto L_0x024d;
            case 5: goto L_0x0259;
            default: goto L_0x0159;
        };	 Catch:{ all -> 0x0020 }
    L_0x0159:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
    L_0x0163:
        r1 = r12.zzCj;	 Catch:{ all -> 0x0020 }
        r3 = new com.google.android.gms.internal.zzfm$1;	 Catch:{ all -> 0x0020 }
        r3.<init>(r12);	 Catch:{ all -> 0x0020 }
        r1.setOnClickListener(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzCj;	 Catch:{ all -> 0x0020 }
        r3 = "Close button";
        r1.setContentDescription(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzCm;	 Catch:{ all -> 0x0020 }
        r3 = r12.zzCj;	 Catch:{ all -> 0x0020 }
        r1.addView(r3, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzCl;	 Catch:{ RuntimeException -> 0x0265 }
        r2 = r7.getDecorView();	 Catch:{ RuntimeException -> 0x0265 }
        r3 = 0;
        r4 = com.google.android.gms.ads.internal.client.zzl.zzcN();	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r12.zzCh;	 Catch:{ RuntimeException -> 0x0265 }
        r7 = 0;
        r7 = r8[r7];	 Catch:{ RuntimeException -> 0x0265 }
        r4 = r4.zzb(r5, r7);	 Catch:{ RuntimeException -> 0x0265 }
        r5 = com.google.android.gms.ads.internal.client.zzl.zzcN();	 Catch:{ RuntimeException -> 0x0265 }
        r7 = r12.zzCh;	 Catch:{ RuntimeException -> 0x0265 }
        r9 = 1;
        r9 = r8[r9];	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r5.zzb(r7, r9);	 Catch:{ RuntimeException -> 0x0265 }
        r1.showAtLocation(r2, r3, r4, r5);	 Catch:{ RuntimeException -> 0x0265 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.zzc(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzps;	 Catch:{ all -> 0x0020 }
        r2 = new com.google.android.gms.ads.internal.client.AdSizeParcel;	 Catch:{ all -> 0x0020 }
        r3 = r12.zzCh;	 Catch:{ all -> 0x0020 }
        r4 = new com.google.android.gms.ads.AdSize;	 Catch:{ all -> 0x0020 }
        r5 = r12.zzov;	 Catch:{ all -> 0x0020 }
        r7 = r12.zzow;	 Catch:{ all -> 0x0020 }
        r4.<init>(r5, r7);	 Catch:{ all -> 0x0020 }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x0020 }
        r1.zza(r2);	 Catch:{ all -> 0x0020 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.zzd(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = "resized";
        r12.zzan(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01ce:
        r1 = r12.zzCl;	 Catch:{ all -> 0x0020 }
        r1.dismiss();	 Catch:{ all -> 0x0020 }
        goto L_0x00dd;
    L_0x01d5:
        r1 = "Webview is detached, probably in the middle of a resize or expand.";
        r12.zzal(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01dd:
        r1 = r3;
        goto L_0x0116;
    L_0x01e0:
        r5 = "top-left";
        r1 = r1.equals(r5);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01e8:
        r1 = r3;
        goto L_0x0156;
    L_0x01eb:
        r3 = "top-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01f3:
        r1 = r5;
        goto L_0x0156;
    L_0x01f6:
        r3 = "center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01fe:
        r1 = 2;
        goto L_0x0156;
    L_0x0201:
        r3 = "bottom-left";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0209:
        r1 = 3;
        goto L_0x0156;
    L_0x020c:
        r3 = "bottom-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0214:
        r1 = 4;
        goto L_0x0156;
    L_0x0217:
        r3 = "bottom-right";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x021f:
        r1 = 5;
        goto L_0x0156;
    L_0x0222:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x022e:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x023a:
        r1 = 13;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0241:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x024d:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0259:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0265:
        r1 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0020 }
        r2.<init>();	 Catch:{ all -> 0x0020 }
        r3 = "Cannot show popup window: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0020 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0020 }
        r1 = r2.append(r1);	 Catch:{ all -> 0x0020 }
        r1 = r1.toString();	 Catch:{ all -> 0x0020 }
        r12.zzal(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzCm;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzps;	 Catch:{ all -> 0x0020 }
        r2 = r2.getView();	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzCn;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x02a8;
    L_0x028f:
        r1 = r12.zzCn;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzCi;	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzCn;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzps;	 Catch:{ all -> 0x0020 }
        r2 = r2.getView();	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.zzps;	 Catch:{ all -> 0x0020 }
        r2 = r12.zzBh;	 Catch:{ all -> 0x0020 }
        r1.zza(r2);	 Catch:{ all -> 0x0020 }
    L_0x02a8:
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfm.zzg(java.util.Map):void");
    }

    public void zzp(boolean z) {
        synchronized (this.zzpK) {
            if (this.zzCl != null) {
                this.zzCl.dismiss();
                this.zzCm.removeView(this.zzps.getView());
                if (this.zzCn != null) {
                    this.zzCn.removeView(this.zzCi);
                    this.zzCn.addView(this.zzps.getView());
                    this.zzps.zza(this.zzBh);
                }
                if (z) {
                    zzan("default");
                    if (this.zzCk != null) {
                        this.zzCk.zzbe();
                    }
                }
                this.zzCl = null;
                this.zzCm = null;
                this.zzCn = null;
                this.zzCj = null;
            }
        }
    }
}
