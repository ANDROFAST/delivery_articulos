package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
    public static final Creator<UserAddressRequest> CREATOR = new zza();
    private final int mVersionCode;
    List<CountrySpecification> zzaJN;

    public final class Builder {
        final /* synthetic */ UserAddressRequest zzaJO;

        private Builder(UserAddressRequest userAddressRequest) {
            this.zzaJO = userAddressRequest;
        }

        public Builder addAllowedCountrySpecification(CountrySpecification countrySpecification) {
            if (this.zzaJO.zzaJN == null) {
                this.zzaJO.zzaJN = new ArrayList();
            }
            this.zzaJO.zzaJN.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> countrySpecifications) {
            if (this.zzaJO.zzaJN == null) {
                this.zzaJO.zzaJN = new ArrayList();
            }
            this.zzaJO.zzaJN.addAll(countrySpecifications);
            return this;
        }

        public UserAddressRequest build() {
            if (this.zzaJO.zzaJN != null) {
                this.zzaJO.zzaJN = Collections.unmodifiableList(this.zzaJO.zzaJN);
            }
            return this.zzaJO;
        }
    }

    UserAddressRequest() {
        this.mVersionCode = 1;
    }

    UserAddressRequest(int versionCode, List<CountrySpecification> allowedCountrySpecifications) {
        this.mVersionCode = versionCode;
        this.zzaJN = allowedCountrySpecifications;
    }

    public static Builder newBuilder() {
        UserAddressRequest userAddressRequest = new UserAddressRequest();
        userAddressRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}
