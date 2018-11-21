package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzha
public class zzc extends zzil implements ServiceConnection {
    private Context mContext;
    private zzgg zzAe;
    private boolean zzEA;
    private zzb zzEB;
    private zzh zzEC;
    private List<zzf> zzED;
    private zzk zzEE;
    private final Object zzpK;

    public zzc(Context context, zzgg com_google_android_gms_internal_zzgg, zzk com_google_android_gms_ads_internal_purchase_zzk) {
        this(context, com_google_android_gms_internal_zzgg, com_google_android_gms_ads_internal_purchase_zzk, new zzb(context), zzh.zzy(context.getApplicationContext()));
    }

    zzc(Context context, zzgg com_google_android_gms_internal_zzgg, zzk com_google_android_gms_ads_internal_purchase_zzk, zzb com_google_android_gms_ads_internal_purchase_zzb, zzh com_google_android_gms_ads_internal_purchase_zzh) {
        this.zzpK = new Object();
        this.zzEA = false;
        this.zzED = null;
        this.mContext = context;
        this.zzAe = com_google_android_gms_internal_zzgg;
        this.zzEE = com_google_android_gms_ads_internal_purchase_zzk;
        this.zzEB = com_google_android_gms_ads_internal_purchase_zzb;
        this.zzEC = com_google_android_gms_ads_internal_purchase_zzh;
        this.zzED = this.zzEC.zzg(10);
    }

    private void zze(long j) {
        do {
            if (!zzf(j)) {
                zzb.m7v("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.zzEA);
    }

    private boolean zzf(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzpK.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            zzb.zzaH("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        synchronized (this.zzpK) {
            this.zzEB.zzN(service);
            zzfJ();
            this.zzEA = true;
            this.zzpK.notify();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        zzb.zzaG("In-app billing service disconnected.");
        this.zzEB.destroy();
    }

    public void onStop() {
        synchronized (this.zzpK) {
            com.google.android.gms.common.stats.zzb.zzrz().zza(this.mContext, this);
            this.zzEB.destroy();
        }
    }

    protected void zza(final zzf com_google_android_gms_ads_internal_purchase_zzf, String str, String str2) {
        final Intent intent = new Intent();
        zzp.zzbH();
        intent.putExtra("RESPONSE_CODE", 0);
        zzp.zzbH();
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        zzp.zzbH();
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        zzip.zzKO.post(new Runnable(this) {
            final /* synthetic */ zzc zzEG;

            public void run() {
                try {
                    if (this.zzEG.zzEE.zza(com_google_android_gms_ads_internal_purchase_zzf.zzEP, -1, intent)) {
                        this.zzEG.zzAe.zza(new zzg(this.zzEG.mContext, com_google_android_gms_ads_internal_purchase_zzf.zzEQ, true, -1, intent, com_google_android_gms_ads_internal_purchase_zzf));
                    } else {
                        this.zzEG.zzAe.zza(new zzg(this.zzEG.mContext, com_google_android_gms_ads_internal_purchase_zzf.zzEQ, false, -1, intent, com_google_android_gms_ads_internal_purchase_zzf));
                    }
                } catch (RemoteException e) {
                    zzb.zzaH("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    public void zzbp() {
        synchronized (this.zzpK) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
            com.google.android.gms.common.stats.zzb.zzrz().zza(this.mContext, intent, (ServiceConnection) this, 1);
            zze(SystemClock.elapsedRealtime());
            com.google.android.gms.common.stats.zzb.zzrz().zza(this.mContext, this);
            this.zzEB.destroy();
        }
    }

    protected void zzfJ() {
        if (!this.zzED.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (zzf com_google_android_gms_ads_internal_purchase_zzf : this.zzED) {
                hashMap.put(com_google_android_gms_ads_internal_purchase_zzf.zzEQ, com_google_android_gms_ads_internal_purchase_zzf);
            }
            String str = null;
            while (true) {
                Bundle zzi = this.zzEB.zzi(this.mContext.getPackageName(), str);
                if (zzi == null || zzp.zzbH().zzd(zzi) != 0) {
                    break;
                }
                ArrayList stringArrayList = zzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList stringArrayList2 = zzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList stringArrayList3 = zzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String string = zzi.getString("INAPP_CONTINUATION_TOKEN");
                for (int i = 0; i < stringArrayList.size(); i++) {
                    if (hashMap.containsKey(stringArrayList.get(i))) {
                        str = (String) stringArrayList.get(i);
                        String str2 = (String) stringArrayList2.get(i);
                        String str3 = (String) stringArrayList3.get(i);
                        zzf com_google_android_gms_ads_internal_purchase_zzf2 = (zzf) hashMap.get(str);
                        if (com_google_android_gms_ads_internal_purchase_zzf2.zzEP.equals(zzp.zzbH().zzap(str2))) {
                            zza(com_google_android_gms_ads_internal_purchase_zzf2, str2, str3);
                            hashMap.remove(str);
                        }
                    }
                }
                if (string == null || hashMap.isEmpty()) {
                    break;
                }
                str = string;
            }
            for (String str4 : hashMap.keySet()) {
                this.zzEC.zza((zzf) hashMap.get(str4));
            }
        }
    }
}
