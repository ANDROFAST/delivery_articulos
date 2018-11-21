package io.card.payment;

import android.view.View;
import android.view.View.OnClickListener;

final class C0562i implements OnClickListener {
    private /* synthetic */ DataEntryActivity f1083a;

    C0562i(DataEntryActivity dataEntryActivity) {
        this.f1083a = dataEntryActivity;
    }

    public final void onClick(View view) {
        this.f1083a.setResult(CardIOActivity.RESULT_ENTRY_CANCELED);
        this.f1083a.finish();
    }
}
