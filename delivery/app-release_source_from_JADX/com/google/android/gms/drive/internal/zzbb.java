package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

public class zzbb implements Creator<OnEventResponse> {
    static void zza(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onEventResponse.mVersionCode);
        zzb.zzc(parcel, 2, onEventResponse.zzalo);
        zzb.zza(parcel, 3, onEventResponse.zzaqj, i, false);
        zzb.zza(parcel, 5, onEventResponse.zzaqk, i, false);
        zzb.zza(parcel, 6, onEventResponse.zzaql, i, false);
        zzb.zza(parcel, 7, onEventResponse.zzaqm, i, false);
        zzb.zza(parcel, 8, onEventResponse.zzaqn, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdw(x0);
    }

    public OnEventResponse zzbB(Parcel parcel) {
        int i = 0;
        ProgressEvent progressEvent = null;
        int zzau = zza.zzau(parcel);
        ChangesAvailableEvent changesAvailableEvent = null;
        QueryResultEventParcelable queryResultEventParcelable = null;
        CompletionEvent completionEvent = null;
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    changeEvent = (ChangeEvent) zza.zza(parcel, zzat, ChangeEvent.CREATOR);
                    break;
                case 5:
                    completionEvent = (CompletionEvent) zza.zza(parcel, zzat, CompletionEvent.CREATOR);
                    break;
                case 6:
                    queryResultEventParcelable = (QueryResultEventParcelable) zza.zza(parcel, zzat, QueryResultEventParcelable.CREATOR);
                    break;
                case 7:
                    changesAvailableEvent = (ChangesAvailableEvent) zza.zza(parcel, zzat, ChangesAvailableEvent.CREATOR);
                    break;
                case 8:
                    progressEvent = (ProgressEvent) zza.zza(parcel, zzat, ProgressEvent.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnEventResponse(i2, i, changeEvent, completionEvent, queryResultEventParcelable, changesAvailableEvent, progressEvent);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnEventResponse[] zzdw(int i) {
        return new OnEventResponse[i];
    }
}
