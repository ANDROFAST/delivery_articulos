package io.card.payment;

import android.content.Context;
import android.view.OrientationEventListener;

final class C0556b extends OrientationEventListener {
    private /* synthetic */ CardIOActivity f1074a;

    C0556b(CardIOActivity cardIOActivity, Context context, int i) {
        this.f1074a = cardIOActivity;
        super(context, 2);
    }

    public final void onOrientationChanged(int i) {
        this.f1074a.m806b(i);
    }
}
