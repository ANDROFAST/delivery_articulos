package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgi;

public class InAppPurchaseActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
    public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
    private zzgd zzNc;

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (this.zzNc != null) {
                this.zzNc.onActivityResult(requestCode, resultCode, data);
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.zzNc = zzgi.zze(this);
        if (this.zzNc == null) {
            zzb.zzaH("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.zzNc.onCreate();
        } catch (Throwable e) {
            zzb.zzd("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.zzNc != null) {
                this.zzNc.onDestroy();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
