package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class zzc extends com.google.android.gms.common.data.zzc implements Moment {
    private MomentEntity zzbax;

    public zzc(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private MomentEntity zzDt() {
        synchronized (this) {
            if (this.zzbax == null) {
                byte[] byteArray = getByteArray("momentImpl");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.zzbax = MomentEntity.CREATOR.zzgs(obtain);
                obtain.recycle();
            }
        }
        return this.zzbax;
    }

    public /* synthetic */ Object freeze() {
        return zzDs();
    }

    public String getId() {
        return zzDt().getId();
    }

    public ItemScope getResult() {
        return zzDt().getResult();
    }

    public String getStartDate() {
        return zzDt().getStartDate();
    }

    public ItemScope getTarget() {
        return zzDt().getTarget();
    }

    public String getType() {
        return zzDt().getType();
    }

    public boolean hasId() {
        return zzDt().hasId();
    }

    public boolean hasResult() {
        return zzDt().hasResult();
    }

    public boolean hasStartDate() {
        return zzDt().hasStartDate();
    }

    public boolean hasTarget() {
        return zzDt().hasTarget();
    }

    public boolean hasType() {
        return zzDt().hasType();
    }

    public MomentEntity zzDs() {
        return zzDt();
    }
}
