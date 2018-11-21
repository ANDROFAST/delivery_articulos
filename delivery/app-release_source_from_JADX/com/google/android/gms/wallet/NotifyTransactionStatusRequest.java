package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class NotifyTransactionStatusRequest implements SafeParcelable {
    public static final Creator<NotifyTransactionStatusRequest> CREATOR = new zzm();
    final int mVersionCode;
    int status;
    String zzbjg;
    String zzbkq;

    public final class Builder {
        final /* synthetic */ NotifyTransactionStatusRequest zzbkr;

        private Builder(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
            this.zzbkr = notifyTransactionStatusRequest;
        }

        public NotifyTransactionStatusRequest build() {
            boolean z = true;
            zzx.zzb(!TextUtils.isEmpty(this.zzbkr.zzbjg), (Object) "googleTransactionId is required");
            if (this.zzbkr.status < 1 || this.zzbkr.status > 8) {
                z = false;
            }
            zzx.zzb(z, (Object) "status is an unrecognized value");
            return this.zzbkr;
        }

        public Builder setDetailedReason(String detailedReason) {
            this.zzbkr.zzbkq = detailedReason;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.zzbkr.zzbjg = googleTransactionId;
            return this;
        }

        public Builder setStatus(int status) {
            this.zzbkr.status = status;
            return this;
        }
    }

    public interface Status {
        public static final int SUCCESS = 1;

        public interface Error {
            public static final int AVS_DECLINE = 7;
            public static final int BAD_CARD = 4;
            public static final int BAD_CVC = 3;
            public static final int DECLINED = 5;
            public static final int FRAUD_DECLINE = 8;
            public static final int OTHER = 6;
            public static final int UNKNOWN = 2;
        }
    }

    NotifyTransactionStatusRequest() {
        this.mVersionCode = 1;
    }

    NotifyTransactionStatusRequest(int versionCode, String googleTransactionId, int status, String detailedReason) {
        this.mVersionCode = versionCode;
        this.zzbjg = googleTransactionId;
        this.status = status;
        this.zzbkq = detailedReason;
    }

    public static Builder newBuilder() {
        NotifyTransactionStatusRequest notifyTransactionStatusRequest = new NotifyTransactionStatusRequest();
        notifyTransactionStatusRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getDetailedReason() {
        return this.zzbkq;
    }

    public String getGoogleTransactionId() {
        return this.zzbjg;
    }

    public int getStatus() {
        return this.status;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzm.zza(this, out, flags);
    }
}
