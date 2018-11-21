package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzkj implements AppInviteApi {

    static class zza extends com.google.android.gms.internal.zzkm.zza {
        zza() {
        }

        public void zza(Status status, Intent intent) {
            throw new UnsupportedOperationException();
        }

        public void zzd(Status status) throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    static abstract class zzb<R extends Result> extends com.google.android.gms.internal.zzlx.zza<R, zzkk> {
        public zzb(GoogleApiClient googleApiClient) {
            super(AppInvite.zzTo, googleApiClient);
        }
    }

    final class zzc extends zzb<Status> {
        private final String zzTr;
        final /* synthetic */ zzkj zzTs;

        class C11891 extends zza {
            final /* synthetic */ zzc zzTt;

            C11891(zzc com_google_android_gms_internal_zzkj_zzc) {
                this.zzTt = com_google_android_gms_internal_zzkj_zzc;
            }

            public void zzd(Status status) throws RemoteException {
                this.zzTt.zzb(status);
            }
        }

        public zzc(zzkj com_google_android_gms_internal_zzkj, GoogleApiClient googleApiClient, String str) {
            this.zzTs = com_google_android_gms_internal_zzkj;
            super(googleApiClient);
            this.zzTr = str;
        }

        protected void zza(zzkk com_google_android_gms_internal_zzkk) throws RemoteException {
            com_google_android_gms_internal_zzkk.zzb(new C11891(this), this.zzTr);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    final class zzd extends zzb<Status> {
        private final String zzTr;
        final /* synthetic */ zzkj zzTs;

        class C11901 extends zza {
            final /* synthetic */ zzd zzTu;

            C11901(zzd com_google_android_gms_internal_zzkj_zzd) {
                this.zzTu = com_google_android_gms_internal_zzkj_zzd;
            }

            public void zzd(Status status) throws RemoteException {
                this.zzTu.zzb(status);
            }
        }

        public zzd(zzkj com_google_android_gms_internal_zzkj, GoogleApiClient googleApiClient, String str) {
            this.zzTs = com_google_android_gms_internal_zzkj;
            super(googleApiClient);
            this.zzTr = str;
        }

        protected void zza(zzkk com_google_android_gms_internal_zzkk) throws RemoteException {
            com_google_android_gms_internal_zzkk.zza(new C11901(this), this.zzTr);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    final class zze extends zzb<AppInviteInvitationResult> {
        final /* synthetic */ zzkj zzTs;
        private final Activity zzTv;
        private final boolean zzTw;
        private final Intent zzTx;

        class C11911 extends zza {
            final /* synthetic */ zze zzTy;

            C11911(zze com_google_android_gms_internal_zzkj_zze) {
                this.zzTy = com_google_android_gms_internal_zzkj_zze;
            }

            public void zza(Status status, Intent intent) {
                this.zzTy.zzb(new zzkl(status, intent));
                if (AppInviteReferral.hasReferral(intent) && this.zzTy.zzTw && this.zzTy.zzTv != null) {
                    this.zzTy.zzTv.startActivity(intent);
                }
            }
        }

        public zze(zzkj com_google_android_gms_internal_zzkj, GoogleApiClient googleApiClient, Activity activity, boolean z) {
            this.zzTs = com_google_android_gms_internal_zzkj;
            super(googleApiClient);
            this.zzTv = activity;
            this.zzTw = z;
            this.zzTx = this.zzTv != null ? this.zzTv.getIntent() : null;
        }

        protected void zza(zzkk com_google_android_gms_internal_zzkk) throws RemoteException {
            if (AppInviteReferral.hasReferral(this.zzTx)) {
                zzb(new zzkl(Status.zzaeX, this.zzTx));
            } else {
                com_google_android_gms_internal_zzkk.zza(new C11911(this));
            }
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zze(status);
        }

        protected AppInviteInvitationResult zze(Status status) {
            return new zzkl(status, new Intent());
        }
    }

    public PendingResult<Status> convertInvitation(GoogleApiClient client, String invitationId) {
        return client.zza(new zzd(this, client, invitationId));
    }

    public PendingResult<AppInviteInvitationResult> getInvitation(GoogleApiClient client, Activity currentActivity, boolean launchDeepLink) {
        return client.zza(new zze(this, client, currentActivity, launchDeepLink));
    }

    public PendingResult<Status> updateInvitationOnInstall(GoogleApiClient client, String invitationId) {
        return client.zza(new zzc(this, client, invitationId));
    }
}
