package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzp.zza;
import java.util.Collection;

public class GetServiceRequest implements SafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new zzi();
    final int version;
    final int zzajA;
    int zzajB;
    String zzajC;
    IBinder zzajD;
    Scope[] zzajE;
    Bundle zzajF;
    Account zzajG;

    public GetServiceRequest(int serviceId) {
        this.version = 2;
        this.zzajB = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzajA = serviceId;
    }

    GetServiceRequest(int version, int serviceId, int clientVersion, String callingPackage, IBinder accountAccessorBinder, Scope[] scopes, Bundle extraArgs, Account clientRequestedAccount) {
        this.version = version;
        this.zzajA = serviceId;
        this.zzajB = clientVersion;
        this.zzajC = callingPackage;
        if (version < 2) {
            this.zzajG = zzaO(accountAccessorBinder);
        } else {
            this.zzajD = accountAccessorBinder;
            this.zzajG = clientRequestedAccount;
        }
        this.zzajE = scopes;
        this.zzajF = extraArgs;
    }

    private Account zzaO(IBinder iBinder) {
        return iBinder != null ? zza.zzb(zza.zzaP(iBinder)) : null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }

    public GetServiceRequest zzc(Account account) {
        this.zzajG = account;
        return this;
    }

    public GetServiceRequest zzc(zzp com_google_android_gms_common_internal_zzp) {
        if (com_google_android_gms_common_internal_zzp != null) {
            this.zzajD = com_google_android_gms_common_internal_zzp.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzcA(String str) {
        this.zzajC = str;
        return this;
    }

    public GetServiceRequest zzd(Collection<Scope> collection) {
        this.zzajE = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public GetServiceRequest zzj(Bundle bundle) {
        this.zzajF = bundle;
        return this;
    }
}
