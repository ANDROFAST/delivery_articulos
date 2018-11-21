package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

public class OnEventResponse implements SafeParcelable {
    public static final Creator<OnEventResponse> CREATOR = new zzbb();
    final int mVersionCode;
    final int zzalo;
    final ChangeEvent zzaqj;
    final CompletionEvent zzaqk;
    final QueryResultEventParcelable zzaql;
    final ChangesAvailableEvent zzaqm;
    final ProgressEvent zzaqn;

    OnEventResponse(int versionCode, int eventType, ChangeEvent changeEvent, CompletionEvent completionEvent, QueryResultEventParcelable queryResultEvent, ChangesAvailableEvent changesAvailableEvent, ProgressEvent progressEvent) {
        this.mVersionCode = versionCode;
        this.zzalo = eventType;
        this.zzaqj = changeEvent;
        this.zzaqk = completionEvent;
        this.zzaql = queryResultEvent;
        this.zzaqm = changesAvailableEvent;
        this.zzaqn = progressEvent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbb.zza(this, dest, flags);
    }

    public DriveEvent zzsT() {
        switch (this.zzalo) {
            case 1:
                return this.zzaqj;
            case 2:
                return this.zzaqk;
            case 3:
                return this.zzaql;
            case 4:
                return this.zzaqm;
            case 5:
            case 6:
                return this.zzaqn;
            default:
                throw new IllegalStateException("Unexpected event type " + this.zzalo);
        }
    }
}
