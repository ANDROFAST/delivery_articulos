package com.google.android.gms.location.places.ui;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

abstract class zza {
    public static final int RESULT_ERROR = 2;

    protected static abstract class zza {
        protected final Intent mIntent;

        public zza(String str) {
            this.mIntent = new Intent(str);
            this.mIntent.setPackage("com.google.android.gms");
        }

        protected Intent zzaO(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
            GoogleApiAvailability.getInstance().zzai(context);
            return this.mIntent;
        }
    }

    zza() {
    }
}
