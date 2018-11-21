package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR = new C02461();
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String zzaHh;
    private final byte[] zzaHi;
    private final int zzaHj;

    static class C02461 implements Creator<RealTimeMessage> {
        C02461() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzem(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzgC(x0);
        }

        public RealTimeMessage zzem(Parcel parcel) {
            return new RealTimeMessage(parcel);
        }

        public RealTimeMessage[] zzgC(int i) {
            return new RealTimeMessage[i];
        }
    }

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String senderParticipantId, byte[] messageData, int isReliable) {
        this.zzaHh = (String) zzx.zzy(senderParticipantId);
        this.zzaHi = (byte[]) ((byte[]) zzx.zzy(messageData)).clone();
        this.zzaHj = isReliable;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.zzaHi;
    }

    public String getSenderParticipantId() {
        return this.zzaHh;
    }

    public boolean isReliable() {
        return this.zzaHj == 1;
    }

    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(this.zzaHh);
        parcel.writeByteArray(this.zzaHi);
        parcel.writeInt(this.zzaHj);
    }
}
