package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEvent implements SafeParcelable {
    public static final Creator<ParcelableEvent> CREATOR = new zzc();
    final int mVersionCode;
    final String zzJX;
    final String zzJg;
    final String zzasF;
    final List<String> zzasL;
    final boolean zzasM;
    final boolean zzasN;
    final boolean zzasO;
    final String zzasP;
    final TextInsertedDetails zzasQ;
    final TextDeletedDetails zzasR;
    final ValuesAddedDetails zzasS;
    final ValuesRemovedDetails zzasT;
    final ValuesSetDetails zzasU;
    final ValueChangedDetails zzasV;
    final ReferenceShiftedDetails zzasW;
    final ObjectChangedDetails zzasX;
    final FieldChangedDetails zzasY;

    ParcelableEvent(int versionCode, String sessionId, String userId, List<String> compoundOperationNames, boolean isLocal, boolean isUndo, boolean isRedo, String objectId, String objectType, TextInsertedDetails textInsertedDetails, TextDeletedDetails textDeletedDetails, ValuesAddedDetails valuesAddedDetails, ValuesRemovedDetails valuesRemovedDetails, ValuesSetDetails valuesSetDetails, ValueChangedDetails valueChangedDetails, ReferenceShiftedDetails referenceShiftedDetails, ObjectChangedDetails objectChangedDetails, FieldChangedDetails fieldChangedDetails) {
        this.mVersionCode = versionCode;
        this.zzJX = sessionId;
        this.zzJg = userId;
        this.zzasL = compoundOperationNames;
        this.zzasM = isLocal;
        this.zzasN = isUndo;
        this.zzasO = isRedo;
        this.zzasF = objectId;
        this.zzasP = objectType;
        this.zzasQ = textInsertedDetails;
        this.zzasR = textDeletedDetails;
        this.zzasS = valuesAddedDetails;
        this.zzasT = valuesRemovedDetails;
        this.zzasU = valuesSetDetails;
        this.zzasV = valueChangedDetails;
        this.zzasW = referenceShiftedDetails;
        this.zzasX = objectChangedDetails;
        this.zzasY = fieldChangedDetails;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
