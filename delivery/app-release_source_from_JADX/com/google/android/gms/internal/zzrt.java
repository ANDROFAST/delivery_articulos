package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetApi.AttestationResult;
import com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult;
import java.util.List;

public class zzrt implements SafetyNetApi {

    static class zza implements AttestationResult {
        private final Status zzTA;
        private final AttestationData zzbbo;

        public zza(Status status, AttestationData attestationData) {
            this.zzTA = status;
            this.zzbbo = attestationData;
        }

        public String getJwsResult() {
            return this.zzbbo == null ? null : this.zzbbo.getJwsResult();
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    static class zzd implements SafeBrowsingResult {
        private Status zzTA;
        private String zzbbi = null;
        private final SafeBrowsingData zzbbs;

        public zzd(Status status, SafeBrowsingData safeBrowsingData) {
            this.zzTA = status;
            this.zzbbs = safeBrowsingData;
            if (this.zzbbs != null) {
                this.zzbbi = this.zzbbs.getMetadata();
            } else if (this.zzTA.isSuccess()) {
                this.zzTA = new Status(8);
            }
        }

        public String getMetadata() {
            return this.zzbbi;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    static abstract class zzb extends zzrq<AttestationResult> {
        protected zzrr zzbbp = new C11951(this);

        class C11951 extends zzrp {
            final /* synthetic */ zzb zzbbq;

            C11951(zzb com_google_android_gms_internal_zzrt_zzb) {
                this.zzbbq = com_google_android_gms_internal_zzrt_zzb;
            }

            public void zza(Status status, AttestationData attestationData) {
                this.zzbbq.zzb(new zza(status, attestationData));
            }
        }

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected AttestationResult zzbd(Status status) {
            return new zza(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbd(status);
        }
    }

    static abstract class zzc extends zzrq<SafeBrowsingResult> {
        protected zzrr zzbbp = new C11961(this);

        class C11961 extends zzrp {
            final /* synthetic */ zzc zzbbr;

            C11961(zzc com_google_android_gms_internal_zzrt_zzc) {
                this.zzbbr = com_google_android_gms_internal_zzrt_zzc;
            }

            public void zza(Status status, SafeBrowsingData safeBrowsingData) {
                this.zzbbr.zzb(new zzd(status, safeBrowsingData));
            }
        }

        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected SafeBrowsingResult zzbe(Status status) {
            return new zzd(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzbe(status);
        }
    }

    public PendingResult<AttestationResult> attest(GoogleApiClient googleApiClient, final byte[] nonce) {
        return googleApiClient.zza(new zzb(this, googleApiClient) {
            final /* synthetic */ zzrt zzbbl;

            protected void zza(zzru com_google_android_gms_internal_zzru) throws RemoteException {
                com_google_android_gms_internal_zzru.zza(this.zzbbp, nonce);
            }
        });
    }

    public PendingResult<SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, final List<Integer> threatTypes, final String uri) {
        if (threatTypes == null) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        } else if (!TextUtils.isEmpty(uri)) {
            return googleApiClient.zza(new zzc(this, googleApiClient) {
                final /* synthetic */ zzrt zzbbl;

                protected void zza(zzru com_google_android_gms_internal_zzru) throws RemoteException {
                    com_google_android_gms_internal_zzru.zza(this.zzbbp, threatTypes, 1, uri);
                }
            });
        } else {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
    }
}
