package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class zzrf implements PanoramaApi {

    private static final class zzb extends com.google.android.gms.internal.zzrd.zza {
        private final com.google.android.gms.internal.zzlx.zzb<PanoramaResult> zzakL;

        public zzb(com.google.android.gms.internal.zzlx.zzb<PanoramaResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_panorama_PanoramaApi_PanoramaResult) {
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_panorama_PanoramaApi_PanoramaResult;
        }

        public void zza(int i, Bundle bundle, int i2, Intent intent) {
            this.zzakL.zzr(new zzrh(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    private static abstract class zzc<R extends Result> extends com.google.android.gms.internal.zzlx.zza<R, zzrg> {
        protected zzc(GoogleApiClient googleApiClient) {
            super(Panorama.zzTo, googleApiClient);
        }

        protected abstract void zza(Context context, zzre com_google_android_gms_internal_zzre) throws RemoteException;

        protected final void zza(zzrg com_google_android_gms_internal_zzrg) throws RemoteException {
            zza(com_google_android_gms_internal_zzrg.getContext(), (zzre) com_google_android_gms_internal_zzrg.zzqs());
        }
    }

    private static abstract class zza extends zzc<PanoramaResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected PanoramaResult zzaZ(Status status) {
            return new zzrh(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzaZ(status);
        }
    }

    private static void zza(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    private static void zza(final Context context, zzre com_google_android_gms_internal_zzre, final zzrd com_google_android_gms_internal_zzrd, final Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission("com.google.android.gms", uri, 1);
        try {
            com_google_android_gms_internal_zzre.zza(new com.google.android.gms.internal.zzrd.zza() {
                public void zza(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
                    zzrf.zza(context, uri);
                    com_google_android_gms_internal_zzrd.zza(i, bundle, i2, intent);
                }
            }, uri, bundle, true);
        } catch (RemoteException e) {
            zza(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            zza(context, uri);
            throw e2;
        }
    }

    public PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient client, final Uri uri) {
        return client.zza(new zza(this, client) {
            final /* synthetic */ zzrf zzaYg;

            protected void zza(Context context, zzre com_google_android_gms_internal_zzre) throws RemoteException {
                com_google_android_gms_internal_zzre.zza(new zzb(this), uri, null, false);
            }
        });
    }

    public PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, final Uri uri) {
        return client.zza(new zza(this, client) {
            final /* synthetic */ zzrf zzaYg;

            protected void zza(Context context, zzre com_google_android_gms_internal_zzre) throws RemoteException {
                zzrf.zza(context, com_google_android_gms_internal_zzre, new zzb(this), uri, null);
            }
        });
    }
}
