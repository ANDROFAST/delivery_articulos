package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;

public final class PlacesOptions implements Optional {
    public final String zzaNb;
    public final int zzaNc;

    public static class Builder {
        private int zzaNc = 0;
        private String zzaNd;

        public PlacesOptions build() {
            return new PlacesOptions();
        }
    }

    private PlacesOptions(Builder builder) {
        this.zzaNb = builder.zzaNd;
        this.zzaNc = builder.zzaNc;
    }
}
