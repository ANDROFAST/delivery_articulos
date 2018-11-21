package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class zzrn implements Moments {

    private static abstract class zza extends com.google.android.gms.plus.Plus.zza<LoadMomentsResult> {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMomentsResult zzbb(final Status status) {
            return new LoadMomentsResult(this) {
                final /* synthetic */ zza zzaZt;

                public MomentBuffer getMomentBuffer() {
                    return null;
                }

                public String getNextPageToken() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public String getUpdated() {
                    return null;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbb(status);
        }
    }

    private static abstract class zzb extends com.google.android.gms.plus.Plus.zza<Status> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private static abstract class zzc extends com.google.android.gms.plus.Plus.zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zza(this, googleApiClient) {
            final /* synthetic */ zzrn zzaZm;

            protected void zza(zze com_google_android_gms_plus_internal_zze) {
                com_google_android_gms_plus_internal_zze.zzl(this);
            }
        });
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        final int i = maxResults;
        final String str = pageToken;
        final Uri uri = targetUrl;
        final String str2 = type;
        final String str3 = userId;
        return googleApiClient.zza(new zza(this, googleApiClient) {
            final /* synthetic */ zzrn zzaZm;

            protected void zza(zze com_google_android_gms_plus_internal_zze) {
                com_google_android_gms_plus_internal_zze.zza(this, i, str, uri, str2, str3);
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, final String momentId) {
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            final /* synthetic */ zzrn zzaZm;

            protected void zza(zze com_google_android_gms_plus_internal_zze) {
                com_google_android_gms_plus_internal_zze.zzeS(momentId);
                zzb(Status.zzaeX);
            }
        });
    }

    public PendingResult<Status> write(GoogleApiClient googleApiClient, final Moment moment) {
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzrn zzaZm;

            protected void zza(zze com_google_android_gms_plus_internal_zze) {
                com_google_android_gms_plus_internal_zze.zza((com.google.android.gms.internal.zzlx.zzb) this, moment);
            }
        });
    }
}
