package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.zzk;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.ActionResult;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class zzki implements zzk, AppIndexApi {

    @Deprecated
    private static final class zza implements ActionResult {
        private zzki zzTj;
        private PendingResult<Status> zzTk;
        private Action zzTl;

        zza(zzki com_google_android_gms_internal_zzki, PendingResult<Status> pendingResult, Action action) {
            this.zzTj = com_google_android_gms_internal_zzki;
            this.zzTk = pendingResult;
            this.zzTl = action;
        }

        public PendingResult<Status> end(GoogleApiClient apiClient) {
            String packageName = apiClient.getContext().getPackageName();
            UsageInfo zza = zzkh.zza(this.zzTl, System.currentTimeMillis(), packageName, 2);
            return this.zzTj.zza(apiClient, zza);
        }

        public PendingResult<Status> getPendingResult() {
            return this.zzTk;
        }
    }

    private static abstract class zzb<T extends Result> extends com.google.android.gms.internal.zzlx.zza<T, zzkg> {
        public zzb(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.appdatasearch.zza.zzSe, googleApiClient);
        }

        protected abstract void zza(zzkd com_google_android_gms_internal_zzkd) throws RemoteException;

        protected final void zza(zzkg com_google_android_gms_internal_zzkg) throws RemoteException {
            zza(com_google_android_gms_internal_zzkg.zzlS());
        }
    }

    private static final class zzd extends zzkf<Status> {
        public zzd(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(Status status) {
            this.zzTf.zzr(status);
        }
    }

    private static abstract class zzc<T extends Result> extends zzb<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public static Intent zza(String str, Uri uri) {
        zzb(str, uri);
        if (zzk(uri)) {
            return new Intent("android.intent.action.VIEW", uri);
        }
        if (zzl(uri)) {
            return new Intent("android.intent.action.VIEW", zzj(uri));
        }
        throw new RuntimeException("appIndexingUri is neither an HTTP(S) URL nor an \"android-app://\" URL: " + uri);
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, Action action, int i) {
        String packageName = googleApiClient.getContext().getPackageName();
        return zza(googleApiClient, zzkh.zza(action, System.currentTimeMillis(), packageName, i));
    }

    private static void zzb(String str, Uri uri) {
        if (zzk(uri)) {
            if (uri.getHost().isEmpty()) {
                throw new IllegalArgumentException("AppIndex: The web URL must have a host (follow the format http(s)://<host>/[path]). Provided URI: " + uri);
            }
        } else if (!zzl(uri)) {
            throw new IllegalArgumentException("AppIndex: The URI scheme must either be 'http(s)' or 'android-app'. If the latter, it must follow the format 'android-app://<package_name>/<scheme>/[host_path]'. Provided URI: " + uri);
        } else if (str == null || str.equals(uri.getHost())) {
            List pathSegments = uri.getPathSegments();
            if (pathSegments.isEmpty() || ((String) pathSegments.get(0)).isEmpty()) {
                throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
            }
        } else {
            throw new IllegalArgumentException("AppIndex: The android-app URI host must match the package name and follow the format android-app://<package_name>/<scheme>/[host_path]. Provided URI: " + uri);
        }
    }

    private static Uri zzj(Uri uri) {
        List pathSegments = uri.getPathSegments();
        String str = (String) pathSegments.get(0);
        Builder builder = new Builder();
        builder.scheme(str);
        if (pathSegments.size() > 1) {
            builder.authority((String) pathSegments.get(1));
            for (int i = 2; i < pathSegments.size(); i++) {
                builder.appendPath((String) pathSegments.get(i));
            }
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return builder.build();
    }

    private static boolean zzk(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    private static boolean zzl(Uri uri) {
        return "android-app".equals(uri.getScheme());
    }

    public static void zzr(List<AppIndexingLink> list) {
        if (list != null) {
            for (AppIndexingLink appIndexingLink : list) {
                zzb(null, appIndexingLink.appIndexingUrl);
            }
        }
    }

    public ActionResult action(GoogleApiClient apiClient, Action action) {
        return new zza(this, zza(apiClient, action, 1), action);
    }

    public PendingResult<Status> end(GoogleApiClient apiClient, Action action) {
        return zza(apiClient, action, 2);
    }

    public PendingResult<Status> start(GoogleApiClient apiClient, Action action) {
        return zza(apiClient, action, 1);
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Intent viewIntent, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        String packageName = apiClient.getContext().getPackageName();
        zzr(outLinks);
        return zza(apiClient, new UsageInfo(packageName, viewIntent, title, webUrl, null, outLinks, 1));
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        String packageName = apiClient.getContext().getPackageName();
        zzb(packageName, appIndexingUrl);
        return view(apiClient, activity, zza(packageName, appIndexingUrl), title, webUrl, (List) outLinks);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Intent viewIntent) {
        String packageName = apiClient.getContext().getPackageName();
        return zza(apiClient, new com.google.android.gms.appdatasearch.UsageInfo.zza().zza(UsageInfo.zza(packageName, viewIntent)).zzw(System.currentTimeMillis()).zzar(0).zzas(2).zzlR());
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Uri appUri) {
        return viewEnd(apiClient, activity, zza(apiClient.getContext().getPackageName(), appUri));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, final UsageInfo... usageInfoArr) {
        final String packageName = googleApiClient.getContext().getPackageName();
        return googleApiClient.zza(new zzc<Status>(this, googleApiClient) {
            final /* synthetic */ zzki zzTi;

            protected void zza(zzkd com_google_android_gms_internal_zzkd) throws RemoteException {
                com_google_android_gms_internal_zzkd.zza(new zzd(this), packageName, usageInfoArr);
            }
        });
    }
}
