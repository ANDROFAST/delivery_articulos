package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    Bundle extras;
    private final int mVersionCode;
    List<DetectedActivity> zzaKH;
    long zzaKI;
    long zzaKJ;
    int zzaKK;

    public ActivityRecognitionResult(int versionCode, List<DetectedActivity> probableActivities, long timeMillis, long elapsedRealtimeMillis, int detectorInfoId, Bundle extras) {
        this.mVersionCode = versionCode;
        this.zzaKH = probableActivities;
        this.zzaKI = timeMillis;
        this.zzaKJ = elapsedRealtimeMillis;
        this.zzaKK = detectorInfoId;
        this.extras = extras;
    }

    public ActivityRecognitionResult(DetectedActivity mostProbableActivity, long time, long elapsedRealtimeMillis) {
        this(mostProbableActivity, time, elapsedRealtimeMillis, 0, null);
    }

    public ActivityRecognitionResult(DetectedActivity mostProbableActivity, long time, long elapsedRealtimeMillis, int detectorInfoId, Bundle extra) {
        this(Collections.singletonList(mostProbableActivity), time, elapsedRealtimeMillis, detectorInfoId, extra);
    }

    public ActivityRecognitionResult(List<DetectedActivity> probableActivities, long time, long elapsedRealtimeMillis) {
        this((List) probableActivities, time, elapsedRealtimeMillis, 0, null);
    }

    public ActivityRecognitionResult(List<DetectedActivity> probableActivities, long time, long elapsedRealtimeMillis, int detectorInfoId, Bundle extras) {
        boolean z = true;
        boolean z2 = probableActivities != null && probableActivities.size() > 0;
        zzx.zzb(z2, (Object) "Must have at least 1 detected activity");
        if (time <= 0 || elapsedRealtimeMillis <= 0) {
            z = false;
        }
        zzx.zzb(z, (Object) "Must set times");
        this.mVersionCode = 2;
        this.zzaKH = probableActivities;
        this.zzaKI = time;
        this.zzaKJ = elapsedRealtimeMillis;
        this.zzaKK = detectorInfoId;
        this.extras = extras;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        if (!hasResult(intent)) {
            return null;
        }
        Object obj = intent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
        if (!(obj instanceof byte[])) {
            return obj instanceof ActivityRecognitionResult ? (ActivityRecognitionResult) obj : null;
        } else {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall((byte[]) obj, 0, ((byte[]) obj).length);
            obtain.setDataPosition(0);
            return CREATOR.createFromParcel(obtain);
        }
    }

    public static boolean hasResult(Intent intent) {
        return intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
    }

    private static boolean zzc(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if ((bundle == null && bundle2 != null) || (bundle != null && bundle2 == null)) {
            return false;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            if (bundle.get(str) == null) {
                if (bundle2.get(str) != null) {
                    return false;
                }
            } else if (bundle.get(str) instanceof Bundle) {
                if (!zzc(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else if (!bundle.get(str).equals(bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) o;
        return this.zzaKI == activityRecognitionResult.zzaKI && this.zzaKJ == activityRecognitionResult.zzaKJ && this.zzaKK == activityRecognitionResult.zzaKK && zzw.equal(this.zzaKH, activityRecognitionResult.zzaKH) && zzc(this.extras, activityRecognitionResult.extras);
    }

    public int getActivityConfidence(int activityType) {
        for (DetectedActivity detectedActivity : this.zzaKH) {
            if (detectedActivity.getType() == activityType) {
                return detectedActivity.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.zzaKJ;
    }

    public DetectedActivity getMostProbableActivity() {
        return (DetectedActivity) this.zzaKH.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.zzaKH;
    }

    public long getTime() {
        return this.zzaKI;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzaKI), Long.valueOf(this.zzaKJ), Integer.valueOf(this.zzaKK), this.zzaKH, this.extras);
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.zzaKH + ", timeMillis=" + this.zzaKI + ", elapsedRealtimeMillis=" + this.zzaKJ + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        ActivityRecognitionResultCreator.zza(this, out, flags);
    }
}
