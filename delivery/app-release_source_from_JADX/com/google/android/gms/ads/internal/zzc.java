package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzci;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzjn;

@zzha
public abstract class zzc extends zzb implements zzg, zzfs {
    public zzc(Context context, AdSizeParcel adSizeParcel, String str, zzew com_google_android_gms_internal_zzew, VersionInfoParcel versionInfoParcel, zzd com_google_android_gms_ads_internal_zzd) {
        super(context, adSizeParcel, str, com_google_android_gms_internal_zzew, versionInfoParcel, com_google_android_gms_ads_internal_zzd);
    }

    public void recordClick() {
        onAdClicked();
    }

    public void recordImpression() {
        zza(this.zzoZ.zzqW, false);
    }

    protected zzjn zza(zza com_google_android_gms_internal_zzie_zza, zze com_google_android_gms_ads_internal_zze) {
        zzjn com_google_android_gms_internal_zzjn;
        View nextView = this.zzoZ.zzqS.getNextView();
        zzjn com_google_android_gms_internal_zzjn2;
        if (nextView instanceof zzjn) {
            zzb.zzaF("Reusing webview...");
            com_google_android_gms_internal_zzjn2 = (zzjn) nextView;
            com_google_android_gms_internal_zzjn2.zza(this.zzoZ.context, this.zzoZ.zzqV, this.zzoU);
            com_google_android_gms_internal_zzjn = com_google_android_gms_internal_zzjn2;
        } else {
            if (nextView != null) {
                this.zzoZ.zzqS.removeView(nextView);
            }
            com_google_android_gms_internal_zzjn2 = zzp.zzby().zza(this.zzoZ.context, this.zzoZ.zzqV, false, false, this.zzoZ.zzqQ, this.zzoZ.zzqR, this.zzoU, this.zzpc);
            if (this.zzoZ.zzqV.zztX == null) {
                zzb(com_google_android_gms_internal_zzjn2.getView());
            }
            com_google_android_gms_internal_zzjn = com_google_android_gms_internal_zzjn2;
        }
        com_google_android_gms_internal_zzjn.zzhC().zzb(this, this, this, this, false, this, null, com_google_android_gms_ads_internal_zze, this);
        com_google_android_gms_internal_zzjn.zzaJ(com_google_android_gms_internal_zzie_zza.zzJK.zzGF);
        return com_google_android_gms_internal_zzjn;
    }

    public void zza(int i, int i2, int i3, int i4) {
        zzaU();
    }

    public void zza(zzcl com_google_android_gms_internal_zzcl) {
        zzx.zzcx("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzoZ.zzrk = com_google_android_gms_internal_zzcl;
    }

    protected void zza(final zza com_google_android_gms_internal_zzie_zza, final zzch com_google_android_gms_internal_zzch) {
        if (com_google_android_gms_internal_zzie_zza.errorCode != -2) {
            zzip.zzKO.post(new Runnable(this) {
                final /* synthetic */ zzc zzpi;

                public void run() {
                    this.zzpi.zzb(new zzie(com_google_android_gms_internal_zzie_zza, null, null, null, null, null, null));
                }
            });
            return;
        }
        if (com_google_android_gms_internal_zzie_zza.zzqV != null) {
            this.zzoZ.zzqV = com_google_android_gms_internal_zzie_zza.zzqV;
        }
        if (com_google_android_gms_internal_zzie_zza.zzJL.zzGN) {
            this.zzoZ.zzrp = 0;
            this.zzoZ.zzqU = zzp.zzbw().zza(this.zzoZ.context, this, com_google_android_gms_internal_zzie_zza, this.zzoZ.zzqQ, null, this.zzpd, this, com_google_android_gms_internal_zzch);
            return;
        }
        zzip.zzKO.post(new Runnable(this) {
            final /* synthetic */ zzc zzpi;

            public void run() {
                if (com_google_android_gms_internal_zzie_zza.zzJL.zzGW && this.zzpi.zzoZ.zzrk != null) {
                    String str = null;
                    if (com_google_android_gms_internal_zzie_zza.zzJL.zzDE != null) {
                        str = zzp.zzbx().zzaz(com_google_android_gms_internal_zzie_zza.zzJL.zzDE);
                    }
                    zzck com_google_android_gms_internal_zzci = new zzci(this.zzpi, str, com_google_android_gms_internal_zzie_zza.zzJL.body);
                    this.zzpi.zzoZ.zzrp = 1;
                    try {
                        this.zzpi.zzoZ.zzrk.zza(com_google_android_gms_internal_zzci);
                        return;
                    } catch (Throwable e) {
                        zzb.zzd("Could not call the onCustomRenderedAdLoadedListener.", e);
                    }
                }
                final zze com_google_android_gms_ads_internal_zze = new zze();
                zzjn zza = this.zzpi.zza(com_google_android_gms_internal_zzie_zza, com_google_android_gms_ads_internal_zze);
                com_google_android_gms_ads_internal_zze.zza(new zze.zzb(com_google_android_gms_internal_zzie_zza, zza));
                zza.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ C01692 zzpl;

                    public boolean onTouch(View v, MotionEvent event) {
                        com_google_android_gms_ads_internal_zze.recordClick();
                        return false;
                    }
                });
                zza.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ C01692 zzpl;

                    public void onClick(View v) {
                        com_google_android_gms_ads_internal_zze.recordClick();
                    }
                });
                this.zzpi.zzoZ.zzrp = 0;
                this.zzpi.zzoZ.zzqU = zzp.zzbw().zza(this.zzpi.zzoZ.context, this.zzpi, com_google_android_gms_internal_zzie_zza, this.zzpi.zzoZ.zzqQ, zza, this.zzpi.zzpd, this.zzpi, com_google_android_gms_internal_zzch);
            }
        });
    }

    protected boolean zza(zzie com_google_android_gms_internal_zzie, zzie com_google_android_gms_internal_zzie2) {
        if (this.zzoZ.zzbQ() && this.zzoZ.zzqS != null) {
            this.zzoZ.zzqS.zzbW().zzaC(com_google_android_gms_internal_zzie2.zzGS);
        }
        return super.zza(com_google_android_gms_internal_zzie, com_google_android_gms_internal_zzie2);
    }

    public void zzbe() {
        zzaS();
    }

    public void zzc(View view) {
        this.zzoZ.zzro = view;
        zzb(new zzie(this.zzoZ.zzqX, null, null, null, null, null, null));
    }
}
