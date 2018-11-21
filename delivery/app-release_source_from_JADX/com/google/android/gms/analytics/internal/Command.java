package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command implements Parcelable {
    @Deprecated
    public static final Creator<Command> CREATOR = new C01831();
    private String mValue;
    private String zzPZ;
    private String zzxX;

    static class C01831 implements Creator<Command> {
        C01831() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzq(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzag(x0);
        }

        @Deprecated
        public Command[] zzag(int i) {
            return new Command[i];
        }

        @Deprecated
        public Command zzq(Parcel parcel) {
            return new Command(parcel);
        }
    }

    @Deprecated
    Command(Parcel in) {
        readFromParcel(in);
    }

    @Deprecated
    private void readFromParcel(Parcel in) {
        this.zzxX = in.readString();
        this.zzPZ = in.readString();
        this.mValue = in.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzxX;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.zzxX);
        out.writeString(this.zzPZ);
        out.writeString(this.mValue);
    }
}
