package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;

public abstract class Task implements Parcelable {
    public static final int EXTRAS_LIMIT_BYTES = 10240;
    public static final int NETWORK_STATE_ANY = 2;
    public static final int NETWORK_STATE_CONNECTED = 0;
    public static final int NETWORK_STATE_UNMETERED = 1;
    protected static final long UNINITIALIZED = -1;
    private final Bundle mExtras;
    private final String mTag;
    private final String zzaJt;
    private final boolean zzaJu;
    private final boolean zzaJv;
    private final int zzaJw;
    private final boolean zzaJx;
    private final zzd zzaJy;

    public static abstract class Builder {
        protected Bundle extras;
        protected String gcmTaskService;
        protected boolean isPersisted;
        protected int requiredNetworkState;
        protected boolean requiresCharging;
        protected String tag;
        protected boolean updateCurrent;
        protected zzd zzaJz = zzd.zzaJo;

        public abstract Task build();

        protected void checkConditions() {
            zzx.zzb(this.gcmTaskService != null, (Object) "Must provide an endpoint for this task by calling setService(ComponentName).");
            GcmNetworkManager.zzdE(this.tag);
            Task.zza(this.zzaJz);
            if (this.isPersisted) {
                Task.zzF(this.extras);
            }
        }

        public abstract Builder setExtras(Bundle bundle);

        public abstract Builder setPersisted(boolean z);

        public abstract Builder setRequiredNetwork(int i);

        public abstract Builder setRequiresCharging(boolean z);

        public abstract Builder setService(Class<? extends GcmTaskService> cls);

        public abstract Builder setTag(String str);

        public abstract Builder setUpdateCurrent(boolean z);
    }

    @Deprecated
    Task(Parcel in) {
        boolean z = true;
        Log.e("Task", "Constructing a Task object using a parcel.");
        this.zzaJt = in.readString();
        this.mTag = in.readString();
        this.zzaJu = in.readInt() == 1;
        if (in.readInt() != 1) {
            z = false;
        }
        this.zzaJv = z;
        this.zzaJw = 2;
        this.zzaJx = false;
        this.zzaJy = zzd.zzaJo;
        this.mExtras = null;
    }

    Task(Builder builder) {
        this.zzaJt = builder.gcmTaskService;
        this.mTag = builder.tag;
        this.zzaJu = builder.updateCurrent;
        this.zzaJv = builder.isPersisted;
        this.zzaJw = builder.requiredNetworkState;
        this.zzaJx = builder.requiresCharging;
        this.zzaJy = builder.zzaJz;
        this.mExtras = builder.extras;
    }

    private static boolean zzC(Object obj) {
        return (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean);
    }

    public static void zzF(Bundle bundle) {
        if (bundle != null) {
            Parcel obtain = Parcel.obtain();
            bundle.writeToParcel(obtain, 0);
            int dataSize = obtain.dataSize();
            if (dataSize > EXTRAS_LIMIT_BYTES) {
                obtain.recycle();
                throw new IllegalArgumentException("Extras exceeding maximum size(10240 bytes): " + dataSize);
            }
            obtain.recycle();
            for (String str : bundle.keySet()) {
                if (!zzC(bundle.get(str))) {
                    throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean. ");
                }
            }
        }
    }

    public static void zza(zzd com_google_android_gms_gcm_zzd) {
        if (com_google_android_gms_gcm_zzd != null) {
            int zzxA = com_google_android_gms_gcm_zzd.zzxA();
            if (zzxA == 1 || zzxA == 0) {
                int zzxB = com_google_android_gms_gcm_zzd.zzxB();
                int zzxC = com_google_android_gms_gcm_zzd.zzxC();
                if (zzxA == 0 && zzxB < 0) {
                    throw new IllegalArgumentException("InitialBackoffSeconds can't be negative: " + zzxB);
                } else if (zzxA == 1 && zzxB < 10) {
                    throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
                } else if (zzxC < zzxB) {
                    throw new IllegalArgumentException("MaximumBackoffSeconds must be greater than InitialBackoffSeconds: " + com_google_android_gms_gcm_zzd.zzxC());
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("Must provide a valid RetryPolicy: " + zzxA);
        }
    }

    public int describeContents() {
        return 0;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public int getRequiredNetwork() {
        return this.zzaJw;
    }

    public boolean getRequiresCharging() {
        return this.zzaJx;
    }

    public String getServiceName() {
        return this.zzaJt;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean isPersisted() {
        return this.zzaJv;
    }

    public boolean isUpdateCurrent() {
        return this.zzaJu;
    }

    public void toBundle(Bundle bundle) {
        bundle.putString("tag", this.mTag);
        bundle.putBoolean("update_current", this.zzaJu);
        bundle.putBoolean("persisted", this.zzaJv);
        bundle.putString("service", this.zzaJt);
        bundle.putInt("requiredNetwork", this.zzaJw);
        bundle.putBoolean("requiresCharging", this.zzaJx);
        bundle.putBundle("retryStrategy", this.zzaJy.zzE(new Bundle()));
        bundle.putBundle("extras", this.mExtras);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.zzaJt);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.zzaJu ? 1 : 0);
        if (!this.zzaJv) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
