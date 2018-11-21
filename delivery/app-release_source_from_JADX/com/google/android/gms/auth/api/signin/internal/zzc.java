package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmo;
import java.util.HashSet;

public class zzc implements GoogleSignInApi {

    private abstract class zza<R extends Result> extends com.google.android.gms.internal.zzlx.zza<R, zzd> {
        final /* synthetic */ zzc zzVV;

        public zza(zzc com_google_android_gms_auth_api_signin_internal_zzc, GoogleApiClient googleApiClient) {
            this.zzVV = com_google_android_gms_auth_api_signin_internal_zzc;
            super(Auth.zzUa, googleApiClient);
        }
    }

    private GoogleSignInOptions zza(GoogleApiClient googleApiClient) {
        return ((zzd) googleApiClient.zza(Auth.zzUa)).zzmL();
    }

    private OptionalPendingResult<GoogleSignInResult> zza(final GoogleApiClient googleApiClient, final GoogleSignInOptions googleSignInOptions) {
        Log.d("GoogleSignInApiImpl", "trySilentSignIn");
        return new zzmo(googleApiClient.zza(new zza<GoogleSignInResult>(this, googleApiClient) {
            final /* synthetic */ zzc zzVV;

            class C11781 extends zza {
                final /* synthetic */ C12031 zzVW;

                C11781(C12031 c12031) {
                    this.zzVW = c12031;
                }

                public void zza(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
                    if (googleSignInAccount != null) {
                        zzn.zzae(googleApiClient.getContext()).zzb(googleSignInAccount, googleSignInOptions);
                    }
                    this.zzVW.zzb(new GoogleSignInResult(googleSignInAccount, status));
                }
            }

            protected void zza(zzd com_google_android_gms_auth_api_signin_internal_zzd) throws RemoteException {
                ((zzg) com_google_android_gms_auth_api_signin_internal_zzd.zzqs()).zza(new C11781(this), googleSignInOptions);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzn(status);
            }

            protected GoogleSignInResult zzn(Status status) {
                return new GoogleSignInResult(null, status);
            }
        }));
    }

    private boolean zza(Account account, Account account2) {
        return account == null ? account2 == null : account.equals(account2);
    }

    public Intent getSignInIntent(GoogleApiClient client) {
        zzx.zzy(client);
        return ((zzd) client.zza(Auth.zzUa)).zzmK();
    }

    public GoogleSignInResult getSignInResultFromIntent(Intent data) {
        if (data == null || (!data.hasExtra("googleSignInStatus") && !data.hasExtra("googleSignInAccount"))) {
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) data.getParcelableExtra("googleSignInAccount");
        Status status = (Status) data.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.zzaeX;
        }
        return new GoogleSignInResult(googleSignInAccount, status);
    }

    public PendingResult<Status> revokeAccess(final GoogleApiClient client) {
        zzn.zzae(client.getContext()).zzmZ();
        for (GoogleApiClient zzoF : GoogleApiClient.zzoE()) {
            zzoF.zzoF();
        }
        return client.zzb(new zza<Status>(this, client) {
            final /* synthetic */ zzc zzVV;

            class C11801 extends zza {
                final /* synthetic */ C12053 zzVY;

                C11801(C12053 c12053) {
                    this.zzVY = c12053;
                }

                public void zzm(Status status) throws RemoteException {
                    this.zzVY.zzb(status);
                }
            }

            protected void zza(zzd com_google_android_gms_auth_api_signin_internal_zzd) throws RemoteException {
                ((zzg) com_google_android_gms_auth_api_signin_internal_zzd.zzqs()).zzc(new C11801(this), this.zzVV.zza(client));
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public PendingResult<Status> signOut(final GoogleApiClient client) {
        zzn.zzae(client.getContext()).zzmZ();
        for (GoogleApiClient zzoF : GoogleApiClient.zzoE()) {
            zzoF.zzoF();
        }
        return client.zzb(new zza<Status>(this, client) {
            final /* synthetic */ zzc zzVV;

            class C11791 extends zza {
                final /* synthetic */ C12042 zzVX;

                C11791(C12042 c12042) {
                    this.zzVX = c12042;
                }

                public void zzl(Status status) throws RemoteException {
                    this.zzVX.zzb(status);
                }
            }

            protected void zza(zzd com_google_android_gms_auth_api_signin_internal_zzd) throws RemoteException {
                ((zzg) com_google_android_gms_auth_api_signin_internal_zzd.zzqs()).zzb(new C11791(this), this.zzVV.zza(client));
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient client) {
        GoogleSignInOptions zza = zza(client);
        Result zza2 = zza(client.getContext(), zza);
        return zza2 != null ? PendingResults.zzb(zza2, client) : zza(client, zza);
    }

    public GoogleSignInResult zza(Context context, GoogleSignInOptions googleSignInOptions) {
        Log.d("GoogleSignInApiImpl", "getSavedSignInResultIfEligible");
        zzx.zzy(googleSignInOptions);
        zzn zzae = zzn.zzae(context);
        GoogleSignInOptions zzmX = zzae.zzmX();
        if (zzmX == null || !zza(zzmX.getAccount(), googleSignInOptions.getAccount()) || googleSignInOptions.zzmz()) {
            return null;
        }
        if ((googleSignInOptions.zzmy() && (!zzmX.zzmy() || !googleSignInOptions.zzmB().equals(zzmX.zzmB()))) || !new HashSet(zzmX.zzmu()).containsAll(new HashSet(googleSignInOptions.zzmu()))) {
            return null;
        }
        GoogleSignInAccount zzmW = zzae.zzmW();
        return (zzmW == null || zzmW.zzb()) ? null : new GoogleSignInResult(zzmW, Status.zzaeX);
    }
}
