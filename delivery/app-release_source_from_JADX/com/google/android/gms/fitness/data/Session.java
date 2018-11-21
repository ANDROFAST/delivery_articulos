package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.plus.PlusShare;
import java.util.concurrent.TimeUnit;

public class Session implements SafeParcelable {
    public static final Creator<Session> CREATOR = new zzp();
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
    private final String mName;
    private final int mVersionCode;
    private final long zzQj;
    private final long zzatQ;
    private final int zzaua;
    private final Application zzaun;
    private final String zzavb;
    private final String zzavc;
    private final Long zzavd;

    public static class Builder {
        private String mName = null;
        private long zzQj = 0;
        private long zzatQ = 0;
        private int zzaua = 4;
        private Application zzaun;
        private String zzavb;
        private String zzavc;
        private Long zzavd;

        public Session build() {
            boolean z = false;
            zzx.zza(this.zzQj > 0, (Object) "Start time should be specified.");
            if (this.zzatQ == 0 || this.zzatQ > this.zzQj) {
                z = true;
            }
            zzx.zza(z, (Object) "End time should be later than start time.");
            if (this.zzavb == null) {
                this.zzavb = (this.mName == null ? "" : this.mName) + this.zzQj;
            }
            return new Session();
        }

        public Builder setActiveTime(long time, TimeUnit timeUnit) {
            this.zzavd = Long.valueOf(timeUnit.toMillis(time));
            return this;
        }

        public Builder setActivity(String activity) {
            return zzeV(FitnessActivities.zzdd(activity));
        }

        public Builder setDescription(String description) {
            zzx.zzb(description.length() <= 1000, "Session description cannot exceed %d characters", Integer.valueOf(1000));
            this.zzavc = description;
            return this;
        }

        public Builder setEndTime(long time, TimeUnit timeUnit) {
            zzx.zza(time >= 0, (Object) "End time should be positive.");
            this.zzatQ = timeUnit.toMillis(time);
            return this;
        }

        public Builder setIdentifier(String identifier) {
            boolean z = identifier != null && TextUtils.getTrimmedLength(identifier) > 0;
            zzx.zzab(z);
            this.zzavb = identifier;
            return this;
        }

        public Builder setName(String name) {
            zzx.zzb(name.length() <= 100, "Session name cannot exceed %d characters", Integer.valueOf(100));
            this.mName = name;
            return this;
        }

        public Builder setStartTime(long time, TimeUnit timeUnit) {
            zzx.zza(time > 0, (Object) "Start time should be positive.");
            this.zzQj = timeUnit.toMillis(time);
            return this;
        }

        public Builder zzeV(int i) {
            this.zzaua = i;
            return this;
        }
    }

    Session(int versionCode, long startTimeMillis, long endTimeMillis, String name, String identifier, String description, int activityType, Application application, Long activeTimeMillis) {
        this.mVersionCode = versionCode;
        this.zzQj = startTimeMillis;
        this.zzatQ = endTimeMillis;
        this.mName = name;
        this.zzavb = identifier;
        this.zzavc = description;
        this.zzaua = activityType;
        this.zzaun = application;
        this.zzavd = activeTimeMillis;
    }

    public Session(long startTimeMillis, long endTimeMillis, String name, String identifier, String description, int activityType, Application application, Long activeTimeMillis) {
        this(3, startTimeMillis, endTimeMillis, name, identifier, description, activityType, application, activeTimeMillis);
    }

    private Session(Builder builder) {
        this(builder.zzQj, builder.zzatQ, builder.mName, builder.zzavb, builder.zzavc, builder.zzaua, builder.zzaun, builder.zzavd);
    }

    public static Session extract(Intent intent) {
        return intent == null ? null : (Session) zzc.zza(intent, EXTRA_SESSION, CREATOR);
    }

    public static String getMimeType(String activity) {
        return MIME_TYPE_PREFIX + activity;
    }

    private boolean zza(Session session) {
        return this.zzQj == session.zzQj && this.zzatQ == session.zzatQ && zzw.equal(this.mName, session.mName) && zzw.equal(this.zzavb, session.zzavb) && zzw.equal(this.zzavc, session.zzavc) && zzw.equal(this.zzaun, session.zzaun) && this.zzaua == session.zzaua;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof Session) && zza((Session) o));
    }

    public long getActiveTime(TimeUnit timeUnit) {
        zzx.zza(this.zzavd != null, (Object) "Active time is not set");
        return timeUnit.convert(this.zzavd.longValue(), TimeUnit.MILLISECONDS);
    }

    public String getActivity() {
        return FitnessActivities.getName(this.zzaua);
    }

    public String getAppPackageName() {
        return this.zzaun == null ? null : this.zzaun.getPackageName();
    }

    public String getDescription() {
        return this.zzavc;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzatQ, TimeUnit.MILLISECONDS);
    }

    public String getIdentifier() {
        return this.zzavb;
    }

    public String getName() {
        return this.mName;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzQj, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasActiveTime() {
        return this.zzavd != null;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ), this.zzavb);
    }

    public boolean isOngoing() {
        return this.zzatQ == 0;
    }

    public String toString() {
        return zzw.zzx(this).zzg("startTime", Long.valueOf(this.zzQj)).zzg("endTime", Long.valueOf(this.zzatQ)).zzg("name", this.mName).zzg("identifier", this.zzavb).zzg(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzavc).zzg("activity", Integer.valueOf(this.zzaua)).zzg("application", this.zzaun).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzp.zza(this, dest, flags);
    }

    public long zzlx() {
        return this.zzQj;
    }

    public long zztB() {
        return this.zzatQ;
    }

    public Application zztK() {
        return this.zzaun;
    }

    public Long zztS() {
        return this.zzavd;
    }

    public int zztz() {
        return this.zzaua;
    }
}
