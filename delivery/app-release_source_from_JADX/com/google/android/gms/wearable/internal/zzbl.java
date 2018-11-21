package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class zzbl<T> {
    private final Map<T, zzcf<T>> zzauU = new HashMap();

    private static class zza<T> extends zzb<Status> {
        private WeakReference<Map<T, zzcf<T>>> zzbon;
        private WeakReference<T> zzboo;

        zza(Map<T, zzcf<T>> map, T t, com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
            this.zzbon = new WeakReference(map);
            this.zzboo = new WeakReference(t);
        }

        public void zza(Status status) {
            Map map = (Map) this.zzbon.get();
            Object obj = this.zzboo.get();
            if (!(status.getStatus().isSuccess() || map == null || obj == null)) {
                synchronized (map) {
                    zzcf com_google_android_gms_wearable_internal_zzcf = (zzcf) map.remove(obj);
                    if (com_google_android_gms_wearable_internal_zzcf != null) {
                        com_google_android_gms_wearable_internal_zzcf.clear();
                    }
                }
            }
            zzX(status);
        }
    }

    private static class zzb<T> extends zzb<Status> {
        private WeakReference<Map<T, zzcf<T>>> zzbon;
        private WeakReference<T> zzboo;

        zzb(Map<T, zzcf<T>> map, T t, com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
            this.zzbon = new WeakReference(map);
            this.zzboo = new WeakReference(t);
        }

        public void zza(Status status) {
            Map map = (Map) this.zzbon.get();
            Object obj = this.zzboo.get();
            if (!(status.getStatus().getStatusCode() != 4002 || map == null || obj == null)) {
                synchronized (map) {
                    zzcf com_google_android_gms_wearable_internal_zzcf = (zzcf) map.remove(obj);
                    if (com_google_android_gms_wearable_internal_zzcf != null) {
                        com_google_android_gms_wearable_internal_zzcf.clear();
                    }
                }
            }
            zzX(status);
        }
    }

    zzbl() {
    }

    public void zza(zzce com_google_android_gms_wearable_internal_zzce, com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, T t) throws RemoteException {
        synchronized (this.zzauU) {
            zzcf com_google_android_gms_wearable_internal_zzcf = (zzcf) this.zzauU.remove(t);
            if (com_google_android_gms_wearable_internal_zzcf == null) {
                com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status.zzr(new Status(4002));
                return;
            }
            com_google_android_gms_wearable_internal_zzcf.clear();
            ((zzbb) com_google_android_gms_wearable_internal_zzce.zzqs()).zza(new zzb(this.zzauU, t, com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status), new RemoveListenerRequest(com_google_android_gms_wearable_internal_zzcf));
        }
    }

    public void zza(zzce com_google_android_gms_wearable_internal_zzce, com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, T t, zzcf<T> com_google_android_gms_wearable_internal_zzcf_T) throws RemoteException {
        synchronized (this.zzauU) {
            if (this.zzauU.get(t) != null) {
                com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status.zzr(new Status(4001));
                return;
            }
            this.zzauU.put(t, com_google_android_gms_wearable_internal_zzcf_T);
            try {
                ((zzbb) com_google_android_gms_wearable_internal_zzce.zzqs()).zza(new zza(this.zzauU, t, com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status), new AddListenerRequest(com_google_android_gms_wearable_internal_zzcf_T));
            } catch (RemoteException e) {
                this.zzauU.remove(t);
                throw e;
            }
        }
    }

    public void zzb(zzce com_google_android_gms_wearable_internal_zzce) {
        synchronized (this.zzauU) {
            zzaz com_google_android_gms_wearable_internal_zzcd_zzo = new zzo();
            for (Entry entry : this.zzauU.entrySet()) {
                zzcf com_google_android_gms_wearable_internal_zzcf = (zzcf) entry.getValue();
                if (com_google_android_gms_wearable_internal_zzcf != null) {
                    com_google_android_gms_wearable_internal_zzcf.clear();
                    if (com_google_android_gms_wearable_internal_zzce.isConnected()) {
                        try {
                            ((zzbb) com_google_android_gms_wearable_internal_zzce.zzqs()).zza(com_google_android_gms_wearable_internal_zzcd_zzo, new RemoveListenerRequest(com_google_android_gms_wearable_internal_zzcf));
                            if (Log.isLoggable("WearableClient", 2)) {
                                Log.d("WearableClient", "disconnect: removed: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzcf);
                            }
                        } catch (RemoteException e) {
                            Log.w("WearableClient", "disconnect: Didn't remove: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzcf);
                        }
                    } else {
                        continue;
                    }
                }
            }
            this.zzauU.clear();
        }
    }

    public void zzes(IBinder iBinder) {
        synchronized (this.zzauU) {
            zzbb zzer = com.google.android.gms.wearable.internal.zzbb.zza.zzer(iBinder);
            zzaz com_google_android_gms_wearable_internal_zzcd_zzo = new zzo();
            for (Entry entry : this.zzauU.entrySet()) {
                zzcf com_google_android_gms_wearable_internal_zzcf = (zzcf) entry.getValue();
                try {
                    zzer.zza(com_google_android_gms_wearable_internal_zzcd_zzo, new AddListenerRequest(com_google_android_gms_wearable_internal_zzcf));
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: added: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzcf);
                    }
                } catch (RemoteException e) {
                    Log.d("WearableClient", "onPostInitHandler: Didn't add: " + entry.getKey() + "/" + com_google_android_gms_wearable_internal_zzcf);
                }
            }
        }
    }
}
