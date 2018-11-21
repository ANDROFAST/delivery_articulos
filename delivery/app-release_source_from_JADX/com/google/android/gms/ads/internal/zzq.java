package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzij;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@zzha
public final class zzq implements OnGlobalLayoutListener, OnScrollChangedListener {
    public final Context context;
    final String zzqO;
    public String zzqP;
    final zzan zzqQ;
    public final VersionInfoParcel zzqR;
    zza zzqS;
    public zzil zzqT;
    public zzir zzqU;
    public AdSizeParcel zzqV;
    public zzie zzqW;
    public com.google.android.gms.internal.zzie.zza zzqX;
    public zzif zzqY;
    zzn zzqZ;
    boolean zzqa;
    zzo zzra;
    zzu zzrb;
    zzv zzrc;
    zzgc zzrd;
    zzgg zzre;
    zzcx zzrf;
    zzcy zzrg;
    SimpleArrayMap<String, zzcz> zzrh;
    SimpleArrayMap<String, zzda> zzri;
    NativeAdOptionsParcel zzrj;
    zzcl zzrk;
    List<String> zzrl;
    zzk zzrm;
    public zzij zzrn;
    View zzro;
    public int zzrp;
    boolean zzrq;
    private HashSet<zzif> zzrr;
    private int zzrs;
    private int zzrt;
    private zzix zzru;
    private boolean zzrv;
    private boolean zzrw;
    private boolean zzrx;

    public static class zza extends ViewSwitcher {
        private final zzis zzry;
        private final zzja zzrz;

        public zza(Context context, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
            super(context);
            this.zzry = new zzis(context);
            if (context instanceof Activity) {
                this.zzrz = new zzja((Activity) context, onGlobalLayoutListener, onScrollChangedListener);
                this.zzrz.zzhm();
                return;
            }
            this.zzrz = null;
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.zzrz != null) {
                this.zzrz.onAttachedToWindow();
            }
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.zzrz != null) {
                this.zzrz.onDetachedFromWindow();
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent event) {
            this.zzry.zze(event);
            return false;
        }

        public void removeAllViews() {
            List<zzjn> arrayList = new ArrayList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt != null && (childAt instanceof zzjn)) {
                    arrayList.add((zzjn) childAt);
                }
            }
            super.removeAllViews();
            for (zzjn destroy : arrayList) {
                destroy.destroy();
            }
        }

        public void zzbS() {
            zzb.m7v("Disable position monitoring on adFrame.");
            if (this.zzrz != null) {
                this.zzrz.zzhn();
            }
        }

        public zzis zzbW() {
            return this.zzry;
        }
    }

    public zzq(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel) {
        this(context, adSizeParcel, str, versionInfoParcel, null);
    }

    zzq(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel, zzan com_google_android_gms_internal_zzan) {
        this.zzrn = null;
        this.zzro = null;
        this.zzrp = 0;
        this.zzrq = false;
        this.zzqa = false;
        this.zzrr = null;
        this.zzrs = -1;
        this.zzrt = -1;
        this.zzrv = true;
        this.zzrw = true;
        this.zzrx = false;
        zzbz.initialize(context);
        if (zzp.zzbA().zzgM() != null) {
            List zzdl = zzbz.zzdl();
            if (versionInfoParcel.zzLF != 0) {
                zzdl.add(Integer.toString(versionInfoParcel.zzLF));
            }
            zzp.zzbA().zzgM().zzb(zzdl);
        }
        this.zzqO = UUID.randomUUID().toString();
        if (adSizeParcel.zztW || adSizeParcel.zztY) {
            this.zzqS = null;
        } else {
            this.zzqS = new zza(context, this, this);
            this.zzqS.setMinimumWidth(adSizeParcel.widthPixels);
            this.zzqS.setMinimumHeight(adSizeParcel.heightPixels);
            this.zzqS.setVisibility(4);
        }
        this.zzqV = adSizeParcel;
        this.zzqP = str;
        this.context = context;
        this.zzqR = versionInfoParcel;
        if (com_google_android_gms_internal_zzan == null) {
            com_google_android_gms_internal_zzan = new zzan(new zzh(this));
        }
        this.zzqQ = com_google_android_gms_internal_zzan;
        this.zzru = new zzix(200);
        this.zzri = new SimpleArrayMap();
    }

    private void zzbT() {
        View findViewById = this.zzqS.getRootView().findViewById(16908290);
        if (findViewById != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            this.zzqS.getGlobalVisibleRect(rect);
            findViewById.getGlobalVisibleRect(rect2);
            if (rect.top != rect2.top) {
                this.zzrv = false;
            }
            if (rect.bottom != rect2.bottom) {
                this.zzrw = false;
            }
        }
    }

    private void zze(boolean z) {
        boolean z2 = true;
        if (this.zzqS != null && this.zzqW != null && this.zzqW.zzDC != null) {
            if (!z || this.zzru.tryAcquire()) {
                if (this.zzqW.zzDC.zzhC().zzcb()) {
                    int[] iArr = new int[2];
                    this.zzqS.getLocationOnScreen(iArr);
                    int zzc = zzl.zzcN().zzc(this.context, iArr[0]);
                    int zzc2 = zzl.zzcN().zzc(this.context, iArr[1]);
                    if (!(zzc == this.zzrs && zzc2 == this.zzrt)) {
                        this.zzrs = zzc;
                        this.zzrt = zzc2;
                        zzjo zzhC = this.zzqW.zzDC.zzhC();
                        zzc = this.zzrs;
                        int i = this.zzrt;
                        if (z) {
                            z2 = false;
                        }
                        zzhC.zza(zzc, i, z2);
                    }
                }
                zzbT();
            }
        }
    }

    public void destroy() {
        zzbS();
        this.zzra = null;
        this.zzrb = null;
        this.zzre = null;
        this.zzrd = null;
        this.zzrk = null;
        this.zzrc = null;
        zzf(false);
        if (this.zzqS != null) {
            this.zzqS.removeAllViews();
        }
        zzbN();
        zzbP();
        this.zzqW = null;
    }

    public void onGlobalLayout() {
        zze(false);
    }

    public void onScrollChanged() {
        zze(true);
        this.zzrx = true;
    }

    public void zza(HashSet<zzif> hashSet) {
        this.zzrr = hashSet;
    }

    public HashSet<zzif> zzbM() {
        return this.zzrr;
    }

    public void zzbN() {
        if (this.zzqW != null && this.zzqW.zzDC != null) {
            this.zzqW.zzDC.destroy();
        }
    }

    public void zzbO() {
        if (this.zzqW != null && this.zzqW.zzDC != null) {
            this.zzqW.zzDC.stopLoading();
        }
    }

    public void zzbP() {
        if (this.zzqW != null && this.zzqW.zzBq != null) {
            try {
                this.zzqW.zzBq.destroy();
            } catch (RemoteException e) {
                zzb.zzaH("Could not destroy mediation adapter.");
            }
        }
    }

    public boolean zzbQ() {
        return this.zzrp == 0;
    }

    public boolean zzbR() {
        return this.zzrp == 1;
    }

    public void zzbS() {
        if (this.zzqS != null) {
            this.zzqS.zzbS();
        }
    }

    public String zzbU() {
        return (this.zzrv && this.zzrw) ? "" : this.zzrv ? this.zzrx ? "top-scrollable" : "top-locked" : this.zzrw ? this.zzrx ? "bottom-scrollable" : "bottom-locked" : "";
    }

    public void zzbV() {
        this.zzqY.zzl(this.zzqW.zzJH);
        this.zzqY.zzm(this.zzqW.zzJI);
        this.zzqY.zzz(this.zzqV.zztW);
        this.zzqY.zzA(this.zzqW.zzGN);
    }

    public void zzf(boolean z) {
        if (this.zzrp == 0) {
            zzbO();
        }
        if (this.zzqT != null) {
            this.zzqT.cancel();
        }
        if (this.zzqU != null) {
            this.zzqU.cancel();
        }
        if (z) {
            this.zzqW = null;
        }
    }
}
