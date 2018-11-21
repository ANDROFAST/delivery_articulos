package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class C0552x implements ServiceConnection {
    final /* synthetic */ C0549p f1006a;

    C0552x(C0549p c0549p) {
        this.f1006a = c0549p;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        new StringBuilder().append(C0549p.f993d).append(".onServiceConnected");
        this.f1006a.f995a = ((aG) iBinder).f895a;
        if (this.f1006a.f995a.m633a(new C0846y(this))) {
            C0549p.m787d(this.f1006a);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f1006a.f995a = null;
    }
}
