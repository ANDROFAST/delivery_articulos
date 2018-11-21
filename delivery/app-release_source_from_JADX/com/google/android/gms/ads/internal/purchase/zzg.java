package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.internal.zzgf.zza;
import com.google.android.gms.internal.zzha;

@zzha
public final class zzg extends zza implements ServiceConnection {
    private Context mContext;
    zzb zzEB;
    private String zzEH;
    private zzf zzEL;
    private boolean zzER = false;
    private int zzES;
    private Intent zzET;

    public zzg(Context context, String str, boolean z, int i, Intent intent, zzf com_google_android_gms_ads_internal_purchase_zzf) {
        this.zzEH = str;
        this.zzES = i;
        this.zzET = intent;
        this.zzER = z;
        this.mContext = context;
        this.zzEL = com_google_android_gms_ads_internal_purchase_zzf;
    }

    public void finishPurchase() {
        int zzd = zzp.zzbH().zzd(this.zzET);
        if (this.zzES == -1 && zzd == 0) {
            this.zzEB = new zzb(this.mContext);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
            zzb.zzrz().zza(this.mContext, intent, (ServiceConnection) this, 1);
        }
    }

    public String getProductId() {
        return this.zzEH;
    }

    public Intent getPurchaseData() {
        return this.zzET;
    }

    public int getResultCode() {
        return this.zzES;
    }

    public boolean isVerified() {
        return this.zzER;
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaG("In-app billing service connected.");
        this.zzEB.zzN(service);
        String zzaq = zzp.zzbH().zzaq(zzp.zzbH().zze(this.zzET));
        if (zzaq != null) {
            if (this.zzEB.zzh(this.mContext.getPackageName(), zzaq) == 0) {
                zzh.zzy(this.mContext).zza(this.zzEL);
            }
            zzb.zzrz().zza(this.mContext, this);
            this.zzEB.destroy();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaG("In-app billing service disconnected.");
        this.zzEB.destroy();
    }
}
