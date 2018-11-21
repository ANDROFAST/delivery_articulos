package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zzqb implements BleApi {
    private static final Status zzayd = new Status(FitnessStatusCodes.UNSUPPORTED_PLATFORM);

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return PendingResults.zza(zzayd, client);
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, String deviceAddress) {
        return PendingResults.zza(zzayd, client);
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return PendingResults.zza(BleDevicesResult.zzR(zzayd), client);
    }

    public PendingResult<Status> startBleScan(GoogleApiClient client, StartBleScanRequest request) {
        return PendingResults.zza(zzayd, client);
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient client, BleScanCallback callback) {
        return PendingResults.zza(zzayd, client);
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return PendingResults.zza(zzayd, client);
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, String deviceAddress) {
        return PendingResults.zza(zzayd, client);
    }
}
