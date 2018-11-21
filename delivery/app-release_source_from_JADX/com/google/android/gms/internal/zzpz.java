package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

public class zzpz implements SessionsApi {

    private static class zza extends com.google.android.gms.internal.zzpn.zza {
        private final com.google.android.gms.internal.zzlx.zzb<SessionReadResult> zzakL;

        private zza(com.google.android.gms.internal.zzlx.zzb<SessionReadResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_fitness_result_SessionReadResult) {
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_fitness_result_SessionReadResult;
        }

        public void zza(SessionReadResult sessionReadResult) throws RemoteException {
            this.zzakL.zzr(sessionReadResult);
        }
    }

    private static class zzb extends com.google.android.gms.internal.zzpo.zza {
        private final com.google.android.gms.internal.zzlx.zzb<SessionStopResult> zzakL;

        private zzb(com.google.android.gms.internal.zzlx.zzb<SessionStopResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_fitness_result_SessionStopResult) {
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_fitness_result_SessionStopResult;
        }

        public void zza(SessionStopResult sessionStopResult) {
            this.zzakL.zzr(sessionStopResult);
        }
    }

    private PendingResult<SessionStopResult> zza(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new zza<SessionStopResult>(this, googleApiClient) {
            final /* synthetic */ zzpz zzaxY;

            protected SessionStopResult zzP(Status status) {
                return SessionStopResult.zzW(status);
            }

            protected void zza(zzoy com_google_android_gms_internal_zzoy) throws RemoteException {
                ((zzpj) com_google_android_gms_internal_zzoy.zzqs()).zza(new SessionStopRequest(str, str2, new zzb(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzP(status);
            }
        });
    }

    public PendingResult<Status> insertSession(GoogleApiClient client, final SessionInsertRequest request) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zzpz zzaxY;

            protected void zza(zzoy com_google_android_gms_internal_zzoy) throws RemoteException {
                ((zzpj) com_google_android_gms_internal_zzoy.zzqs()).zza(new SessionInsertRequest(request, new zzqa(this)));
            }
        });
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient client, final SessionReadRequest request) {
        return client.zza(new zza<SessionReadResult>(this, client) {
            final /* synthetic */ zzpz zzaxY;

            protected SessionReadResult zzQ(Status status) {
                return SessionReadResult.zzV(status);
            }

            protected void zza(zzoy com_google_android_gms_internal_zzoy) throws RemoteException {
                ((zzpj) com_google_android_gms_internal_zzoy.zzqs()).zza(new SessionReadRequest(request, new zza(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzQ(status);
            }
        });
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient client, PendingIntent intent) {
        return zza(client, intent, 0);
    }

    public PendingResult<Status> startSession(GoogleApiClient client, final Session session) {
        zzx.zzb((Object) session, (Object) "Session cannot be null");
        zzx.zzb(session.getEndTime(TimeUnit.MILLISECONDS) == 0, (Object) "Cannot start a session which has already ended");
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpz zzaxY;

            protected void zza(zzoy com_google_android_gms_internal_zzoy) throws RemoteException {
                ((zzpj) com_google_android_gms_internal_zzoy.zzqs()).zza(new SessionStartRequest(session, new zzqa(this)));
            }
        });
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient client, String identifier) {
        return zza(client, null, identifier);
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient client, final PendingIntent intent) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpz zzaxY;

            protected void zza(zzoy com_google_android_gms_internal_zzoy) throws RemoteException {
                ((zzpj) com_google_android_gms_internal_zzoy.zzqs()).zza(new SessionUnregistrationRequest(intent, new zzqa(this)));
            }
        });
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, final PendingIntent pendingIntent, final int i) {
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzpz zzaxY;

            protected void zza(zzoy com_google_android_gms_internal_zzoy) throws RemoteException {
                ((zzpj) com_google_android_gms_internal_zzoy.zzqs()).zza(new SessionRegistrationRequest(pendingIntent, new zzqa(this), i));
            }
        });
    }
}
