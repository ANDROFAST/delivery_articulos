package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest implements SafeParcelable {
    public static final Creator<GeofencingRequest> CREATOR = new zza();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final int mVersionCode;
    private final List<ParcelableGeofence> zzaKZ;
    private final int zzaLa;

    public static final class Builder {
        private final List<ParcelableGeofence> zzaKZ = new ArrayList();
        private int zzaLa = 5;

        public static int zzhg(int i) {
            return i & 7;
        }

        public Builder addGeofence(Geofence geofence) {
            zzx.zzb((Object) geofence, (Object) "geofence can't be null.");
            zzx.zzb(geofence instanceof ParcelableGeofence, (Object) "Geofence must be created using Geofence.Builder.");
            this.zzaKZ.add((ParcelableGeofence) geofence);
            return this;
        }

        public Builder addGeofences(List<Geofence> geofences) {
            if (!(geofences == null || geofences.isEmpty())) {
                for (Geofence geofence : geofences) {
                    if (geofence != null) {
                        addGeofence(geofence);
                    }
                }
            }
            return this;
        }

        public GeofencingRequest build() {
            zzx.zzb(!this.zzaKZ.isEmpty(), (Object) "No geofence has been added to this request.");
            return new GeofencingRequest(this.zzaKZ, this.zzaLa);
        }

        public Builder setInitialTrigger(int initialTrigger) {
            this.zzaLa = zzhg(initialTrigger);
            return this;
        }
    }

    GeofencingRequest(int version, List<ParcelableGeofence> geofences, int initialTrigger) {
        this.mVersionCode = version;
        this.zzaKZ = geofences;
        this.zzaLa = initialTrigger;
    }

    private GeofencingRequest(List<ParcelableGeofence> geofences, int initialTrigger) {
        this(1, (List) geofences, initialTrigger);
    }

    public int describeContents() {
        return 0;
    }

    public List<Geofence> getGeofences() {
        List<Geofence> arrayList = new ArrayList();
        arrayList.addAll(this.zzaKZ);
        return arrayList;
    }

    public int getInitialTrigger() {
        return this.zzaLa;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }

    public List<ParcelableGeofence> zzxW() {
        return this.zzaKZ;
    }
}
