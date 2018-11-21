package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzbs;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhc;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjg;
import com.google.android.gms.internal.zzjg.zzc;

@zzha
public abstract class zzd implements com.google.android.gms.ads.internal.request.zzc.zza, zzir<Void> {
    private final zzjg<AdRequestInfoParcel> zzGi;
    private final com.google.android.gms.ads.internal.request.zzc.zza zzGj;
    private final Object zzpK = new Object();

    class C06142 implements com.google.android.gms.internal.zzjg.zza {
        final /* synthetic */ zzd zzGl;

        C06142(zzd com_google_android_gms_ads_internal_request_zzd) {
            this.zzGl = com_google_android_gms_ads_internal_request_zzd;
        }

        public void run() {
            this.zzGl.zzge();
        }
    }

    @zzha
    public static final class zza extends zzd {
        private final Context mContext;

        public zza(Context context, zzjg<AdRequestInfoParcel> com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel, com.google.android.gms.ads.internal.request.zzc.zza com_google_android_gms_ads_internal_request_zzc_zza) {
            super(com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza);
            this.mContext = context;
        }

        public /* synthetic */ Object zzfR() {
            return super.zzfO();
        }

        public void zzge() {
        }

        public zzj zzgf() {
            return zzhc.zza(this.mContext, new zzbs((String) zzbz.zzvg.get()), zzhb.zzgn());
        }
    }

    @zzha
    public static class zzb extends zzd implements ConnectionCallbacks, OnConnectionFailedListener {
        private Context mContext;
        private zzjg<AdRequestInfoParcel> zzGi;
        private final com.google.android.gms.ads.internal.request.zzc.zza zzGj;
        protected zze zzGm;
        private boolean zzGn;
        private VersionInfoParcel zzpI;
        private final Object zzpK = new Object();

        public zzb(Context context, VersionInfoParcel versionInfoParcel, zzjg<AdRequestInfoParcel> com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel, com.google.android.gms.ads.internal.request.zzc.zza com_google_android_gms_ads_internal_request_zzc_zza) {
            Looper zzhk;
            super(com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza);
            this.mContext = context;
            this.zzpI = versionInfoParcel;
            this.zzGi = com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel;
            this.zzGj = com_google_android_gms_ads_internal_request_zzc_zza;
            if (((Boolean) zzbz.zzvF.get()).booleanValue()) {
                this.zzGn = true;
                zzhk = zzp.zzbJ().zzhk();
            } else {
                zzhk = context.getMainLooper();
            }
            this.zzGm = new zze(context, zzhk, this, this, this.zzpI.zzLG);
            connect();
        }

        protected void connect() {
            this.zzGm.zzqp();
        }

        public void onConnected(Bundle connectionHint) {
            zzfO();
        }

        public void onConnectionFailed(ConnectionResult result) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Cannot connect to remote service, fallback to local instance.");
            zzgg().zzfR();
            Bundle bundle = new Bundle();
            bundle.putString("action", "gms_connection_failed_fallback_to_local");
            zzp.zzbx().zzb(this.mContext, this.zzpI.afmaVersion, "gmob-apps", bundle, true);
        }

        public void onConnectionSuspended(int cause) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Disconnected from remote ad request service.");
        }

        public /* synthetic */ Object zzfR() {
            return super.zzfO();
        }

        public void zzge() {
            synchronized (this.zzpK) {
                if (this.zzGm.isConnected() || this.zzGm.isConnecting()) {
                    this.zzGm.disconnect();
                }
                Binder.flushPendingCommands();
                if (this.zzGn) {
                    zzp.zzbJ().zzhl();
                    this.zzGn = false;
                }
            }
        }

        public zzj zzgf() {
            zzj zzgj;
            synchronized (this.zzpK) {
                try {
                    zzgj = this.zzGm.zzgj();
                } catch (IllegalStateException e) {
                    zzgj = null;
                    return zzgj;
                } catch (DeadObjectException e2) {
                    zzgj = null;
                    return zzgj;
                }
            }
            return zzgj;
        }

        zzir zzgg() {
            return new zza(this.mContext, this.zzGi, this.zzGj);
        }
    }

    public zzd(zzjg<AdRequestInfoParcel> com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel, com.google.android.gms.ads.internal.request.zzc.zza com_google_android_gms_ads_internal_request_zzc_zza) {
        this.zzGi = com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel;
        this.zzGj = com_google_android_gms_ads_internal_request_zzc_zza;
    }

    public void cancel() {
        zzge();
    }

    boolean zza(zzj com_google_android_gms_ads_internal_request_zzj, AdRequestInfoParcel adRequestInfoParcel) {
        try {
            com_google_android_gms_ads_internal_request_zzj.zza(adRequestInfoParcel, new zzg(this));
            return true;
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service.", e);
            zzp.zzbA().zzb(e, true);
        } catch (Throwable e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", e2);
            zzp.zzbA().zzb(e2, true);
        } catch (Throwable e22) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", e22);
            zzp.zzbA().zzb(e22, true);
        } catch (Throwable e222) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", e222);
            zzp.zzbA().zzb(e222, true);
        }
        this.zzGj.zzb(new AdResponseParcel(0));
        return false;
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        synchronized (this.zzpK) {
            this.zzGj.zzb(adResponseParcel);
            zzge();
        }
    }

    public Void zzfO() {
        final zzj zzgf = zzgf();
        if (zzgf == null) {
            this.zzGj.zzb(new AdResponseParcel(0));
            zzge();
        } else {
            this.zzGi.zza(new zzc<AdRequestInfoParcel>(this) {
                final /* synthetic */ zzd zzGl;

                public void zzc(AdRequestInfoParcel adRequestInfoParcel) {
                    if (!this.zzGl.zza(zzgf, adRequestInfoParcel)) {
                        this.zzGl.zzge();
                    }
                }
            }, new C06142(this));
        }
        return null;
    }

    public /* synthetic */ Object zzfR() {
        return zzfO();
    }

    public abstract void zzge();

    public abstract zzj zzgf();
}
