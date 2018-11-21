package com.google.android.gms.location.places;

import android.content.Context;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzs;

public class PlaceBuffer extends AbstractDataBuffer<Place> implements Result {
    private final Context mContext;
    private final Status zzTA;
    private final String zzaMG;

    public PlaceBuffer(DataHolder dataHolder, Context context) {
        super(dataHolder);
        this.mContext = context;
        this.zzTA = PlacesStatusCodes.zzhJ(dataHolder.getStatusCode());
        if (dataHolder == null || dataHolder.zzpH() == null) {
            this.zzaMG = null;
        } else {
            this.zzaMG = dataHolder.zzpH().getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    public Place get(int position) {
        return new zzs(this.zzafC, position, this.mContext);
    }

    public CharSequence getAttributions() {
        return this.zzaMG;
    }

    public Status getStatus() {
        return this.zzTA;
    }
}
