package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.HashMap;
import java.util.Map;

public class zza extends com.google.android.gms.fitness.request.zzn.zza {
    private final BleScanCallback zzaye;

    public static class zza {
        private static final zza zzayf = new zza();
        private final Map<BleScanCallback, zza> zzayg = new HashMap();

        private zza() {
        }

        public static zza zzug() {
            return zzayf;
        }

        public zza zza(BleScanCallback bleScanCallback) {
            zza com_google_android_gms_fitness_request_zza;
            synchronized (this.zzayg) {
                com_google_android_gms_fitness_request_zza = (zza) this.zzayg.get(bleScanCallback);
                if (com_google_android_gms_fitness_request_zza == null) {
                    com_google_android_gms_fitness_request_zza = new zza(bleScanCallback);
                    this.zzayg.put(bleScanCallback, com_google_android_gms_fitness_request_zza);
                }
            }
            return com_google_android_gms_fitness_request_zza;
        }

        public zza zzb(BleScanCallback bleScanCallback) {
            zza com_google_android_gms_fitness_request_zza;
            synchronized (this.zzayg) {
                com_google_android_gms_fitness_request_zza = (zza) this.zzayg.get(bleScanCallback);
                if (com_google_android_gms_fitness_request_zza != null) {
                } else {
                    com_google_android_gms_fitness_request_zza = new zza(bleScanCallback);
                }
            }
            return com_google_android_gms_fitness_request_zza;
        }
    }

    private zza(BleScanCallback bleScanCallback) {
        this.zzaye = (BleScanCallback) zzx.zzy(bleScanCallback);
    }

    public void onDeviceFound(BleDevice device) throws RemoteException {
        this.zzaye.onDeviceFound(device);
    }

    public void onScanStopped() throws RemoteException {
        this.zzaye.onScanStopped();
    }
}
