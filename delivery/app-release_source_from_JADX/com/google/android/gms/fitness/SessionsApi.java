package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;

public interface SessionsApi {

    public static class ViewIntentBuilder {
        private final Context mContext;
        private String zzatR;
        private Session zzatS;
        private boolean zzatT = false;

        public ViewIntentBuilder(Context context) {
            this.mContext = context;
        }

        private Intent zzl(Intent intent) {
            if (this.zzatR == null) {
                return intent;
            }
            Intent intent2 = new Intent(intent).setPackage(this.zzatR);
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent2, 0);
            if (resolveActivity == null) {
                return intent;
            }
            intent2.setComponent(new ComponentName(this.zzatR, resolveActivity.activityInfo.name));
            return intent2;
        }

        public Intent build() {
            zzx.zza(this.zzatS != null, (Object) "Session must be set");
            Intent intent = new Intent(Fitness.ACTION_VIEW);
            intent.setType(Session.getMimeType(this.zzatS.getActivity()));
            zzc.zza(this.zzatS, intent, Session.EXTRA_SESSION);
            if (!this.zzatT) {
                this.zzatR = this.zzatS.getAppPackageName();
            }
            return zzl(intent);
        }

        public ViewIntentBuilder setPreferredApplication(String packageName) {
            this.zzatR = packageName;
            this.zzatT = true;
            return this;
        }

        public ViewIntentBuilder setSession(Session session) {
            this.zzatS = session;
            return this;
        }
    }

    PendingResult<Status> insertSession(GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest);

    PendingResult<SessionReadResult> readSession(GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest);

    PendingResult<Status> registerForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult<Status> startSession(GoogleApiClient googleApiClient, Session session);

    PendingResult<SessionStopResult> stopSession(GoogleApiClient googleApiClient, String str);

    PendingResult<Status> unregisterForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);
}
