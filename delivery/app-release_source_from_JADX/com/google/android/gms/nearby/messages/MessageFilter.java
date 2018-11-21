package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.NearbyDeviceFilter;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageFilter implements SafeParcelable {
    public static final Creator<MessageFilter> CREATOR = new zzb();
    public static final MessageFilter INCLUDE_ALL_MY_TYPES = new Builder().includeAllMyTypes().build();
    final int mVersionCode;
    private final List<MessageType> zzaWE;
    private final List<NearbyDeviceFilter> zzaWF;
    private final boolean zzaWG;

    public static final class Builder {
        private final List<NearbyDeviceFilter> zzaWF = new ArrayList();
        private boolean zzaWG;
        private final List<MessageType> zzaWH = new ArrayList();

        private Builder zzP(String str, String str2) {
            this.zzaWH.add(new MessageType(str, str2));
            return this;
        }

        public MessageFilter build() {
            boolean z = this.zzaWG || !this.zzaWH.isEmpty();
            zzx.zza(z, (Object) "At least one of the include methods must be called.");
            return new MessageFilter(this.zzaWH, this.zzaWF, this.zzaWG);
        }

        public Builder includeAllMyTypes() {
            this.zzaWG = true;
            return this;
        }

        public Builder includeFilter(MessageFilter filter) {
            this.zzaWH.addAll(filter.zzCx());
            this.zzaWF.addAll(filter.zzCz());
            this.zzaWG |= filter.zzCy();
            return this;
        }

        public Builder includeNamespacedType(String namespace, String type) {
            return zzP(namespace, type);
        }
    }

    MessageFilter(int versionCode, List<MessageType> messageTypes, List<NearbyDeviceFilter> deviceFilters, boolean includeAllMyTypes) {
        this.mVersionCode = versionCode;
        this.zzaWE = Collections.unmodifiableList((List) zzx.zzy(messageTypes));
        this.zzaWG = includeAllMyTypes;
        if (deviceFilters == null) {
            deviceFilters = Collections.emptyList();
        }
        this.zzaWF = Collections.unmodifiableList(deviceFilters);
    }

    private MessageFilter(List<MessageType> messageTypes, List<NearbyDeviceFilter> deviceFilters, boolean includeAllMyTypes) {
        this(1, (List) messageTypes, (List) deviceFilters, includeAllMyTypes);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageFilter)) {
            return false;
        }
        MessageFilter messageFilter = (MessageFilter) o;
        return this.zzaWG == messageFilter.zzaWG && zzw.equal(this.zzaWE, messageFilter.zzaWE) && zzw.equal(this.zzaWF, messageFilter.zzaWF);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaWE, this.zzaWF, Boolean.valueOf(this.zzaWG));
    }

    public String toString() {
        return "MessageFilter{includeAllMyTypes=" + this.zzaWG + ", messageTypes=" + this.zzaWE + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    List<MessageType> zzCx() {
        return this.zzaWE;
    }

    boolean zzCy() {
        return this.zzaWG;
    }

    List<NearbyDeviceFilter> zzCz() {
        return this.zzaWF;
    }
}
