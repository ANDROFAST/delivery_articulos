package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzgb;
import com.google.android.gms.internal.zzgd.zza;
import com.google.android.gms.internal.zzha;

@zzha
public class zze extends zza implements ServiceConnection {
    private final Activity mActivity;
    private zzb zzEB;
    zzh zzEC;
    private zzk zzEE;
    private Context zzEJ;
    private zzgb zzEK;
    private zzf zzEL;
    private zzj zzEM;
    private String zzEN = null;

    public zze(Activity activity) {
        this.mActivity = activity;
        this.zzEC = zzh.zzy(this.mActivity.getApplicationContext());
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1001) {
            boolean z = false;
            try {
                int zzd = zzp.zzbH().zzd(data);
                if (resultCode == -1) {
                    zzp.zzbH();
                    if (zzd == 0) {
                        if (this.zzEE.zza(this.zzEN, resultCode, data)) {
                            z = true;
                        }
                        this.zzEK.recordPlayBillingResolution(zzd);
                        this.mActivity.finish();
                        zza(this.zzEK.getProductId(), z, resultCode, data);
                    }
                }
                this.zzEC.zza(this.zzEL);
                this.zzEK.recordPlayBillingResolution(zzd);
                this.mActivity.finish();
                zza(this.zzEK.getProductId(), z, resultCode, data);
            } catch (RemoteException e) {
                zzb.zzaH("Fail to process purchase result.");
                this.mActivity.finish();
            } finally {
                this.zzEN = null;
            }
        }
    }

    public void onCreate() {
        GInAppPurchaseManagerInfoParcel zzc = GInAppPurchaseManagerInfoParcel.zzc(this.mActivity.getIntent());
        this.zzEM = zzc.zzEx;
        this.zzEE = zzc.zzrm;
        this.zzEK = zzc.zzEv;
        this.zzEB = new zzb(this.mActivity.getApplicationContext());
        this.zzEJ = zzc.zzEw;
        if (this.mActivity.getResources().getConfiguration().orientation == 2) {
            this.mActivity.setRequestedOrientation(zzp.zzbz().zzhd());
        } else {
            this.mActivity.setRequestedOrientation(zzp.zzbz().zzhe());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        this.mActivity.bindService(intent, this, 1);
    }

    public void onDestroy() {
        this.mActivity.unbindService(this);
        this.zzEB.destroy();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        Throwable e;
        this.zzEB.zzN(service);
        try {
            this.zzEN = this.zzEE.zzfN();
            Bundle zzb = this.zzEB.zzb(this.mActivity.getPackageName(), this.zzEK.getProductId(), this.zzEN);
            PendingIntent pendingIntent = (PendingIntent) zzb.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int zzd = zzp.zzbH().zzd(zzb);
                this.zzEK.recordPlayBillingResolution(zzd);
                zza(this.zzEK.getProductId(), false, zzd, null);
                this.mActivity.finish();
                return;
            }
            this.zzEL = new zzf(this.zzEK.getProductId(), this.zzEN);
            this.zzEC.zzb(this.zzEL);
            this.mActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        } catch (RemoteException e2) {
            e = e2;
            zzb.zzd("Error when connecting in-app billing service", e);
            this.mActivity.finish();
        } catch (SendIntentException e3) {
            e = e3;
            zzb.zzd("Error when connecting in-app billing service", e);
            this.mActivity.finish();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        zzb.zzaG("In-app billing service disconnected.");
        this.zzEB.destroy();
    }

    protected void zza(String str, boolean z, int i, Intent intent) {
        if (this.zzEM != null) {
            this.zzEM.zza(str, z, i, intent, this.zzEL);
        }
    }
}
