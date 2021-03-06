package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import java.util.ArrayList;

public final class AppContentSectionBuffer extends zzf<AppContentSection> {
    private final ArrayList<DataHolder> zzaBi;

    public void release() {
        super.release();
        int size = this.zzaBi.size();
        for (int i = 1; i < size; i++) {
            DataHolder dataHolder = (DataHolder) this.zzaBi.get(i);
            if (dataHolder != null) {
                dataHolder.close();
            }
        }
    }

    protected /* synthetic */ Object zzk(int i, int i2) {
        return zzn(i, i2);
    }

    protected AppContentSection zzn(int i, int i2) {
        return new AppContentSectionRef(this.zzaBi, i, i2);
    }

    protected String zzpO() {
        return "section_id";
    }

    protected String zzpQ() {
        return "card_id";
    }
}
