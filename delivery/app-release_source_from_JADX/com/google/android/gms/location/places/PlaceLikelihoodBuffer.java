package com.google.android.gms.location.places;

import android.content.Context;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.places.internal.zzn;

public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood> implements Result {
    private final Context mContext;
    private final Status zzTA;
    private final String zzaMG;
    private final int zzuW;

    public static class zza {
        static int zzhE(int i) {
            switch (i) {
                case 100:
                case Quests.SELECT_COMPLETED_UNCLAIMED /*101*/:
                case 102:
                case Quests.SELECT_RECENTLY_FAILED /*103*/:
                case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                case LocationRequest.PRIORITY_NO_POWER /*105*/:
                    return i;
                default:
                    throw new IllegalArgumentException("invalid source: " + i);
            }
        }
    }

    public PlaceLikelihoodBuffer(DataHolder dataHolder, int source, Context context) {
        super(dataHolder);
        this.mContext = context;
        this.zzTA = PlacesStatusCodes.zzhJ(dataHolder.getStatusCode());
        this.zzuW = zza.zzhE(source);
        if (dataHolder == null || dataHolder.zzpH() == null) {
            this.zzaMG = null;
        } else {
            this.zzaMG = dataHolder.zzpH().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    public PlaceLikelihood get(int position) {
        return new zzn(this.zzafC, position, this.mContext);
    }

    public CharSequence getAttributions() {
        return this.zzaMG;
    }

    public Status getStatus() {
        return this.zzTA;
    }

    public String toString() {
        return zzw.zzx(this).zzg("status", getStatus()).zzg("attributions", this.zzaMG).toString();
    }
}
