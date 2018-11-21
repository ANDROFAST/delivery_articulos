package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.Map;
import java.util.Set;

public class zzj implements CapabilityApi {

    private static class zzb implements CapabilityListener {
        final CapabilityListener zzbmL;
        final String zzbmM;

        zzb(CapabilityListener capabilityListener, String str) {
            this.zzbmL = capabilityListener;
            this.zzbmM = str;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            zzb com_google_android_gms_wearable_internal_zzj_zzb = (zzb) o;
            return this.zzbmL.equals(com_google_android_gms_wearable_internal_zzj_zzb.zzbmL) ? this.zzbmM.equals(com_google_android_gms_wearable_internal_zzj_zzb.zzbmM) : false;
        }

        public int hashCode() {
            return (this.zzbmL.hashCode() * 31) + this.zzbmM.hashCode();
        }

        public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
            this.zzbmL.onCapabilityChanged(capabilityInfo);
        }
    }

    public static class zzc implements CapabilityInfo {
        private final String mName;
        private final Set<Node> zzbmN;

        public zzc(CapabilityInfo capabilityInfo) {
            this(capabilityInfo.getName(), capabilityInfo.getNodes());
        }

        public zzc(String str, Set<Node> set) {
            this.mName = str;
            this.zzbmN = set;
        }

        public String getName() {
            return this.mName;
        }

        public Set<Node> getNodes() {
            return this.zzbmN;
        }
    }

    public static class zza implements AddLocalCapabilityResult, RemoveLocalCapabilityResult {
        private final Status zzTA;

        public zza(Status status) {
            this.zzTA = status;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    public static class zzd implements GetAllCapabilitiesResult {
        private final Status zzTA;
        private final Map<String, CapabilityInfo> zzbmO;

        public zzd(Status status, Map<String, CapabilityInfo> map) {
            this.zzTA = status;
            this.zzbmO = map;
        }

        public Map<String, CapabilityInfo> getAllCapabilities() {
            return this.zzbmO;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    public static class zze implements GetCapabilityResult {
        private final Status zzTA;
        private final CapabilityInfo zzbmP;

        public zze(Status status, CapabilityInfo capabilityInfo) {
            this.zzTA = status;
            this.zzbmP = capabilityInfo;
        }

        public CapabilityInfo getCapability() {
            return this.zzbmP;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static final class zzf extends zzi<Status> {
        private CapabilityListener zzbmL;

        private zzf(GoogleApiClient googleApiClient, CapabilityListener capabilityListener) {
            super(googleApiClient);
            this.zzbmL = capabilityListener;
        }

        protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
            com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) this, this.zzbmL);
            this.zzbmL = null;
        }

        public Status zzb(Status status) {
            this.zzbmL = null;
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, IntentFilter[] intentFilterArr) {
        return zzb.zza(googleApiClient, zza(intentFilterArr), capabilityListener);
    }

    private static zza<CapabilityListener> zza(final IntentFilter[] intentFilterArr) {
        return new zza<CapabilityListener>() {
            public void zza(zzce com_google_android_gms_wearable_internal_zzce, com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, CapabilityListener capabilityListener, zzmn<CapabilityListener> com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_CapabilityApi_CapabilityListener) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zza((com.google.android.gms.internal.zzlx.zzb) com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, capabilityListener, (zzmn) com_google_android_gms_internal_zzmn_com_google_android_gms_wearable_CapabilityApi_CapabilityListener, intentFilterArr);
            }
        };
    }

    public PendingResult<Status> addCapabilityListener(GoogleApiClient client, CapabilityListener listener, String capability) {
        zzx.zzb(capability != null, (Object) "capability must not be null");
        CapabilityListener com_google_android_gms_wearable_internal_zzj_zzb = new zzb(listener, capability);
        IntentFilter zzfY = zzcc.zzfY(CapabilityApi.ACTION_CAPABILITY_CHANGED);
        if (!capability.startsWith("/")) {
            capability = "/" + capability;
        }
        zzfY.addDataPath(capability, 0);
        return zza(client, com_google_android_gms_wearable_internal_zzj_zzb, new IntentFilter[]{zzfY});
    }

    public PendingResult<Status> addListener(GoogleApiClient client, CapabilityListener listener, Uri uri, int filterType) {
        zzx.zzb(uri != null, (Object) "uri must not be null");
        boolean z = filterType == 0 || filterType == 1;
        zzx.zzb(z, (Object) "invalid filter type");
        return zza(client, listener, new IntentFilter[]{zzcc.zza(CapabilityApi.ACTION_CAPABILITY_CHANGED, uri, filterType)});
    }

    public PendingResult<AddLocalCapabilityResult> addLocalCapability(GoogleApiClient client, final String capability) {
        return client.zza(new zzi<AddLocalCapabilityResult>(this, client) {
            final /* synthetic */ zzj zzbmJ;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zzr(this, capability);
            }

            protected AddLocalCapabilityResult zzbm(Status status) {
                return new zza(status);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbm(status);
            }
        });
    }

    public PendingResult<GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient client, final int nodeFilter) {
        boolean z = true;
        if (!(nodeFilter == 0 || nodeFilter == 1)) {
            z = false;
        }
        zzx.zzab(z);
        return client.zza(new zzi<GetAllCapabilitiesResult>(this, client) {
            final /* synthetic */ zzj zzbmJ;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zzb(this, nodeFilter);
            }

            protected GetAllCapabilitiesResult zzbl(Status status) {
                return new zzd(status, null);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbl(status);
            }
        });
    }

    public PendingResult<GetCapabilityResult> getCapability(GoogleApiClient client, final String capability, final int nodeFilter) {
        boolean z = true;
        if (!(nodeFilter == 0 || nodeFilter == 1)) {
            z = false;
        }
        zzx.zzab(z);
        return client.zza(new zzi<GetCapabilityResult>(this, client) {
            final /* synthetic */ zzj zzbmJ;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zzg(this, capability, nodeFilter);
            }

            protected GetCapabilityResult zzbk(Status status) {
                return new zze(status, null);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbk(status);
            }
        });
    }

    public PendingResult<Status> removeCapabilityListener(GoogleApiClient client, CapabilityListener listener, String capability) {
        return client.zza(new zzf(client, new zzb(listener, capability)));
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, CapabilityListener listener) {
        return client.zza(new zzf(client, listener));
    }

    public PendingResult<RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient client, final String capability) {
        return client.zza(new zzi<RemoveLocalCapabilityResult>(this, client) {
            final /* synthetic */ zzj zzbmJ;

            protected void zza(zzce com_google_android_gms_wearable_internal_zzce) throws RemoteException {
                com_google_android_gms_wearable_internal_zzce.zzs(this, capability);
            }

            protected RemoveLocalCapabilityResult zzbn(Status status) {
                return new zza(status);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzbn(status);
            }
        });
    }
}
