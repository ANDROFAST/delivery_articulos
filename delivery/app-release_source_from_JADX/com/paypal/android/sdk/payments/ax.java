package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.Calendar;

final class ax implements ServiceConnection {
    private /* synthetic */ PayPalProfileSharingActivity f937a;

    ax(PayPalProfileSharingActivity payPalProfileSharingActivity) {
        this.f937a = payPalProfileSharingActivity;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        new StringBuilder().append(PayPalProfileSharingActivity.class.getSimpleName()).append(".onServiceConnected");
        if (this.f937a.isFinishing()) {
            new StringBuilder().append(PayPalProfileSharingActivity.class.getSimpleName()).append(".onServiceConnected exit - isFinishing");
            return;
        }
        this.f937a.f806d = ((aG) iBinder).f895a;
        if (this.f937a.f806d.m637d() == null) {
            Log.e(PayPalProfileSharingActivity.f803a, "Service state invalid.  Did you start the PayPalService?");
            this.f937a.setResult(2);
            this.f937a.finish();
            return;
        }
        aA aAVar = new aA(this.f937a.getIntent(), this.f937a.f806d.m637d(), true);
        if (!aAVar.m491d()) {
            Log.e(PayPalProfileSharingActivity.f803a, "Service extras invalid.  Please see the docs.");
            this.f937a.setResult(2);
            this.f937a.finish();
        } else if (!aAVar.mo3762e()) {
            Log.e(PayPalProfileSharingActivity.f803a, "Extras invalid.  Please see the docs.");
            this.f937a.setResult(2);
            this.f937a.finish();
        } else if (this.f937a.f806d.m642i()) {
            ProfileSharingConsentActivity.m1061a(this.f937a, 1, this.f937a.f806d.m637d());
        } else {
            Calendar instance = Calendar.getInstance();
            instance.add(13, 1);
            this.f937a.f804b = instance.getTime();
            this.f937a.f806d.m628a(new ay(this.f937a), false);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f937a.f806d = null;
        PayPalProfileSharingActivity.f803a;
    }
}
