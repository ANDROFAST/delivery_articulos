package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSubscriptionsResult implements Result, SafeParcelable {
    public static final Creator<ListSubscriptionsResult> CREATOR = new zzh();
    private final int mVersionCode;
    private final Status zzTA;
    private final List<Subscription> zzazs;

    ListSubscriptionsResult(int versionCode, List<Subscription> subscriptions, Status status) {
        this.mVersionCode = versionCode;
        this.zzazs = subscriptions;
        this.zzTA = status;
    }

    public ListSubscriptionsResult(List<Subscription> subscriptions, Status status) {
        this.mVersionCode = 3;
        this.zzazs = Collections.unmodifiableList(subscriptions);
        this.zzTA = (Status) zzx.zzb((Object) status, (Object) "status");
    }

    public static ListSubscriptionsResult zzU(Status status) {
        return new ListSubscriptionsResult(Collections.emptyList(), status);
    }

    private boolean zzb(ListSubscriptionsResult listSubscriptionsResult) {
        return this.zzTA.equals(listSubscriptionsResult.zzTA) && zzw.equal(this.zzazs, listSubscriptionsResult.zzazs);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof ListSubscriptionsResult) && zzb((ListSubscriptionsResult) that));
    }

    public Status getStatus() {
        return this.zzTA;
    }

    public List<Subscription> getSubscriptions() {
        return this.zzazs;
    }

    public List<Subscription> getSubscriptions(DataType dataType) {
        List arrayList = new ArrayList();
        for (Subscription subscription : this.zzazs) {
            if (dataType.equals(subscription.zztV())) {
                arrayList.add(subscription);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzTA, this.zzazs);
    }

    public String toString() {
        return zzw.zzx(this).zzg("status", this.zzTA).zzg("subscriptions", this.zzazs).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
