package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class zze extends zzj<zzd> {
    private Person zzaYV;
    private final PlusSession zzaYW;

    static final class zza implements LoadMomentsResult {
        private final Status zzTA;
        private final String zzaYX;
        private final String zzaYY;
        private final MomentBuffer zzaYZ;

        public zza(Status status, DataHolder dataHolder, String str, String str2) {
            this.zzTA = status;
            this.zzaYX = str;
            this.zzaYY = str2;
            this.zzaYZ = dataHolder != null ? new MomentBuffer(dataHolder) : null;
        }

        public MomentBuffer getMomentBuffer() {
            return this.zzaYZ;
        }

        public String getNextPageToken() {
            return this.zzaYX;
        }

        public Status getStatus() {
            return this.zzTA;
        }

        public String getUpdated() {
            return this.zzaYY;
        }

        public void release() {
            if (this.zzaYZ != null) {
                this.zzaYZ.release();
            }
        }
    }

    static final class zzb implements LoadPeopleResult {
        private final Status zzTA;
        private final String zzaYX;
        private final PersonBuffer zzaZa;

        public zzb(Status status, DataHolder dataHolder, String str) {
            this.zzTA = status;
            this.zzaYX = str;
            this.zzaZa = dataHolder != null ? new PersonBuffer(dataHolder) : null;
        }

        public String getNextPageToken() {
            return this.zzaYX;
        }

        public PersonBuffer getPersonBuffer() {
            return this.zzaZa;
        }

        public Status getStatus() {
            return this.zzTA;
        }

        public void release() {
            if (this.zzaZa != null) {
                this.zzaZa.release();
            }
        }
    }

    static final class zzc extends zza {
        private final com.google.android.gms.internal.zzlx.zzb<Status> zzaLZ;

        public zzc(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
            this.zzaLZ = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzba(Status status) {
            this.zzaLZ.zzr(status);
        }
    }

    static final class zzd extends zza {
        private final com.google.android.gms.internal.zzlx.zzb<LoadMomentsResult> zzaLZ;

        public zzd(com.google.android.gms.internal.zzlx.zzb<LoadMomentsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult) {
            this.zzaLZ = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult;
        }

        public void zza(DataHolder dataHolder, String str, String str2) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zzpH() != null ? (PendingIntent) dataHolder.zzpH().getParcelable("pendingIntent") : null);
            if (!(status.isSuccess() || dataHolder == null)) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzaLZ.zzr(new zza(status, dataHolder, str, str2));
        }
    }

    static final class zze extends zza {
        private final com.google.android.gms.internal.zzlx.zzb<LoadPeopleResult> zzaLZ;

        public zze(com.google.android.gms.internal.zzlx.zzb<LoadPeopleResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_People_LoadPeopleResult) {
            this.zzaLZ = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_People_LoadPeopleResult;
        }

        public void zza(DataHolder dataHolder, String str) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zzpH() != null ? (PendingIntent) dataHolder.zzpH().getParcelable("pendingIntent") : null);
            if (!(status.isSuccess() || dataHolder == null)) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzaLZ.zzr(new zzb(status, dataHolder, str));
        }
    }

    static final class zzf extends zza {
        private final com.google.android.gms.internal.zzlx.zzb<Status> zzaLZ;

        public zzf(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
            this.zzaLZ = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzi(int i, Bundle bundle) {
            this.zzaLZ.zzr(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }
    }

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, PlusSession plusSession, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 2, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzaYW = plusSession;
    }

    public static boolean zzd(Set<Scope> set) {
        return (set == null || set.isEmpty()) ? false : (set.size() == 1 && set.contains(new Scope("plus_one_placeholder_scope"))) ? false : true;
    }

    private Bundle zzlV() {
        Bundle zzDp = this.zzaYW.zzDp();
        zzDp.putStringArray("request_visible_actions", this.zzaYW.zzDj());
        zzDp.putString("auth_package", this.zzaYW.zzDl());
        return zzDp;
    }

    public String getAccountName() {
        zzqr();
        try {
            return ((zzd) zzqs()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void zzDd() {
        zzqr();
        try {
            this.zzaYV = null;
            ((zzd) zzqs()).zzDd();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person zzDf() {
        zzqr();
        return this.zzaYV;
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzdN(iBinder);
    }

    public zzq zza(com.google.android.gms.internal.zzlx.zzb<LoadPeopleResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_People_LoadPeopleResult, int i, String str) {
        zzqr();
        Object com_google_android_gms_plus_internal_zze_zze = new zze(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            return ((zzd) zzqs()).zza(com_google_android_gms_plus_internal_zze_zze, 1, i, -1, str);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zze.zza(DataHolder.zzbJ(8), null);
            return null;
        }
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.zzaYV = PersonEntity.zzu(bundle.getByteArray("loaded_person"));
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(com.google.android.gms.internal.zzlx.zzb<LoadMomentsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult, int i, String str, Uri uri, String str2, String str3) {
        zzqr();
        Object com_google_android_gms_plus_internal_zze_zzd = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult != null ? new zzd(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult) : null;
        try {
            ((zzd) zzqs()).zza(com_google_android_gms_plus_internal_zze_zzd, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zzd.zza(DataHolder.zzbJ(8), null, null);
        }
    }

    public void zza(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, Moment moment) {
        zzqr();
        zzb com_google_android_gms_plus_internal_zze_zzc = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status != null ? new zzc(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) : null;
        try {
            ((zzd) zzqs()).zza(com_google_android_gms_plus_internal_zze_zzc, SafeParcelResponse.zza((MomentEntity) moment));
        } catch (Throwable e) {
            if (com_google_android_gms_plus_internal_zze_zzc == null) {
                throw new IllegalStateException(e);
            }
            com_google_android_gms_plus_internal_zze_zzc.zzba(new Status(8, null, null));
        }
    }

    public void zza(com.google.android.gms.internal.zzlx.zzb<LoadPeopleResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_People_LoadPeopleResult, Collection<String> collection) {
        zzqr();
        zzb com_google_android_gms_plus_internal_zze_zze = new zze(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            ((zzd) zzqs()).zza(com_google_android_gms_plus_internal_zze_zze, new ArrayList(collection));
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zze.zza(DataHolder.zzbJ(8), null);
        }
    }

    public void zzd(com.google.android.gms.internal.zzlx.zzb<LoadPeopleResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_People_LoadPeopleResult, String[] strArr) {
        zza((com.google.android.gms.internal.zzlx.zzb) com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_People_LoadPeopleResult, Arrays.asList(strArr));
    }

    protected zzd zzdN(IBinder iBinder) {
        return com.google.android.gms.plus.internal.zzd.zza.zzdM(iBinder);
    }

    public void zzeS(String str) {
        zzqr();
        try {
            ((zzd) zzqs()).zzeS(str);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected String zzgh() {
        return "com.google.android.gms.plus.service.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public void zzl(com.google.android.gms.internal.zzlx.zzb<LoadMomentsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult) {
        zza(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult, 20, null, null, null, "me");
    }

    protected Bundle zzlU() {
        return zzlV();
    }

    public void zzm(com.google.android.gms.internal.zzlx.zzb<LoadPeopleResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_People_LoadPeopleResult) {
        zzqr();
        Object com_google_android_gms_plus_internal_zze_zze = new zze(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            ((zzd) zzqs()).zza(com_google_android_gms_plus_internal_zze_zze, 2, 1, -1, null);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zze.zza(DataHolder.zzbJ(8), null);
        }
    }

    public boolean zzmn() {
        return zzd(zzqq().zzb(Plus.API));
    }

    public void zzn(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
        zzqr();
        zzDd();
        Object com_google_android_gms_plus_internal_zze_zzf = new zzf(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
        try {
            ((zzd) zzqs()).zzb(com_google_android_gms_plus_internal_zze_zzf);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zzf.zzi(8, null);
        }
    }

    public zzq zzq(com.google.android.gms.internal.zzlx.zzb<LoadPeopleResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_People_LoadPeopleResult, String str) {
        return zza(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_plus_People_LoadPeopleResult, 0, str);
    }

    protected Bundle zzqt() {
        return zzlV();
    }
}
