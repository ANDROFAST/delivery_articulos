package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class C0532S implements ServiceConnection {
    final /* synthetic */ LoginActivity f874a;

    C0532S(LoginActivity loginActivity) {
        this.f874a = loginActivity;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        new StringBuilder().append(LoginActivity.class.getSimpleName()).append(".onServiceConnected");
        this.f874a.f752r = ((aG) iBinder).f895a;
        if (this.f874a.f752r.m633a(new C0837T(this))) {
            this.f874a.m536a();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f874a.f752r = null;
    }
}
