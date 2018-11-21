package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.zzlx.zzb;

public class zzpt implements BleApi {

    private static class zza extends com.google.android.gms.internal.zzqc.zza {
        private final zzb<BleDevicesResult> zzakL;

        private zza(zzb<BleDevicesResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_fitness_result_BleDevicesResult) {
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_fitness_result_BleDevicesResult;
        }

        public void zza(BleDevicesResult bleDevicesResult) {
            this.zzakL.zzr(bleDevicesResult);
        }
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final BleDevice bleDevice) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpt zzaxu;

            protected void zza(zzos com_google_android_gms_internal_zzos) throws RemoteException {
                ((zzpd) com_google_android_gms_internal_zzos.zzqs()).zza(new ClaimBleDeviceRequest(bleDevice.getAddress(), bleDevice, new zzqa(this)));
            }
        });
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpt zzaxu;

            protected void zza(zzos com_google_android_gms_internal_zzos) throws RemoteException {
                ((zzpd) com_google_android_gms_internal_zzos.zzqs()).zza(new ClaimBleDeviceRequest(deviceAddress, null, new zzqa(this)));
            }
        });
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return client.zza(new zza<BleDevicesResult>(this, client) {
            final /* synthetic */ zzpt zzaxu;

            protected BleDevicesResult zzJ(Status status) {
                return BleDevicesResult.zzR(status);
            }

            protected void zza(zzos com_google_android_gms_internal_zzos) throws RemoteException {
                ((zzpd) com_google_android_gms_internal_zzos.zzqs()).zza(new ListClaimedBleDevicesRequest(new zza(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzJ(status);
            }
        });
    }

    public PendingResult<Status> startBleScan(GoogleApiClient client, final StartBleScanRequest request) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zzpt zzaxu;

            protected void zza(zzos com_google_android_gms_internal_zzos) throws RemoteException {
                ((zzpd) com_google_android_gms_internal_zzos.zzqs()).zza(new StartBleScanRequest(request, new zzqa(this)));
            }
        });
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient client, final BleScanCallback requestCallback) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zzpt zzaxu;

            protected void zza(zzos com_google_android_gms_internal_zzos) throws RemoteException {
                ((zzpd) com_google_android_gms_internal_zzos.zzqs()).zza(new StopBleScanRequest(requestCallback, new zzqa(this)));
            }
        });
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return unclaimBleDevice(client, bleDevice.getAddress());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpt zzaxu;

            protected void zza(zzos com_google_android_gms_internal_zzos) throws RemoteException {
                ((zzpd) com_google_android_gms_internal_zzos.zzqs()).zza(new UnclaimBleDeviceRequest(deviceAddress, new zzqa(this)));
            }
        });
    }
}
