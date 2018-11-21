package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.MatchResult;

public final class ParticipantResult implements SafeParcelable {
    public static final Creator<ParticipantResult> CREATOR = new ParticipantResultCreator();
    public static final int MATCH_RESULT_DISAGREED = 5;
    public static final int MATCH_RESULT_DISCONNECT = 4;
    public static final int MATCH_RESULT_LOSS = 1;
    public static final int MATCH_RESULT_NONE = 3;
    public static final int MATCH_RESULT_TIE = 2;
    public static final int MATCH_RESULT_UNINITIALIZED = -1;
    public static final int MATCH_RESULT_WIN = 0;
    public static final int PLACING_UNINITIALIZED = -1;
    private final int mVersionCode;
    private final String zzaCu;
    private final int zzaHf;
    private final int zzaHg;

    public ParticipantResult(int versionCode, String participantId, int result, int placing) {
        this.mVersionCode = versionCode;
        this.zzaCu = (String) zzx.zzy(participantId);
        zzx.zzaa(MatchResult.isValid(result));
        this.zzaHf = result;
        this.zzaHg = placing;
    }

    public ParticipantResult(String participantId, int result, int placing) {
        this(1, participantId, result, placing);
    }

    public int describeContents() {
        return 0;
    }

    public String getParticipantId() {
        return this.zzaCu;
    }

    public int getPlacing() {
        return this.zzaHg;
    }

    public int getResult() {
        return this.zzaHf;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        ParticipantResultCreator.zza(this, out, flags);
    }
}
