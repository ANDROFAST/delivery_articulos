package io.card.payment;

import android.content.Intent;

final class C0557c implements Runnable {
    private /* synthetic */ CardIOActivity f1075a;

    C0557c(CardIOActivity cardIOActivity) {
        this.f1075a = cardIOActivity;
    }

    public final void run() {
        CardIOActivity.f1011c;
        this.f1075a.getWindow().clearFlags(1024);
        this.f1075a.getWindow().addFlags(512);
        Intent intent = new Intent(this.f1075a, DataEntryActivity.class);
        if (this.f1075a.f1017g != null) {
            this.f1075a.f1017g.m856c();
            if (!(CardIOActivity.f1009a == null || CardIOActivity.f1009a.isRecycled())) {
                CardIOActivity.f1009a.recycle();
            }
            CardIOActivity.f1009a = this.f1075a.f1017g.m854b();
        }
        if (this.f1075a.f1020j != null) {
            intent.putExtra(CardIOActivity.EXTRA_SCAN_RESULT, this.f1075a.f1020j);
            this.f1075a.f1020j = null;
        } else {
            intent.putExtra("io.card.payment.manualEntryScanResult", true);
        }
        intent.putExtras(this.f1075a.getIntent());
        intent.addFlags(1082195968);
        this.f1075a.startActivityForResult(intent, CardIOActivity.f1014f);
    }
}
