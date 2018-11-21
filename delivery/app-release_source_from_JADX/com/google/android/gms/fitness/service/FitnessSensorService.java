package com.google.android.gms.fitness.service;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest;
import com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zznx;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpp;
import java.util.List;

public abstract class FitnessSensorService extends Service {
    public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
    private zza zzazv;

    private static class zza extends com.google.android.gms.fitness.internal.service.zzc.zza {
        private final FitnessSensorService zzazw;

        private zza(FitnessSensorService fitnessSensorService) {
            this.zzazw = fitnessSensorService;
        }

        public void zza(FitnessDataSourcesRequest fitnessDataSourcesRequest, zzpb com_google_android_gms_internal_zzpb) throws RemoteException {
            this.zzazw.zzuP();
            com_google_android_gms_internal_zzpb.zza(new DataSourcesResult(this.zzazw.onFindDataSources(fitnessDataSourcesRequest.getDataTypes()), Status.zzaeX));
        }

        public void zza(FitnessUnregistrationRequest fitnessUnregistrationRequest, zzpp com_google_android_gms_internal_zzpp) throws RemoteException {
            this.zzazw.zzuP();
            if (this.zzazw.onUnregister(fitnessUnregistrationRequest.getDataSource())) {
                com_google_android_gms_internal_zzpp.zzp(Status.zzaeX);
            } else {
                com_google_android_gms_internal_zzpp.zzp(new Status(13));
            }
        }

        public void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, zzpp com_google_android_gms_internal_zzpp) throws RemoteException {
            this.zzazw.zzuP();
            if (this.zzazw.onRegister(fitnessSensorServiceRequest)) {
                com_google_android_gms_internal_zzpp.zzp(Status.zzaeX);
            } else {
                com_google_android_gms_internal_zzpp.zzp(new Status(13));
            }
        }
    }

    public IBinder onBind(Intent intent) {
        if (!SERVICE_INTERFACE.equals(intent.getAction())) {
            return null;
        }
        if (Log.isLoggable("FitnessSensorService", 3)) {
            Log.d("FitnessSensorService", "Intent " + intent + " received by " + getClass().getName());
        }
        return this.zzazv.asBinder();
    }

    public void onCreate() {
        super.onCreate();
        this.zzazv = new zza();
    }

    public abstract List<DataSource> onFindDataSources(List<DataType> list);

    public abstract boolean onRegister(FitnessSensorServiceRequest fitnessSensorServiceRequest);

    public abstract boolean onUnregister(DataSource dataSource);

    protected void zzuP() throws SecurityException {
        int callingUid = Binder.getCallingUid();
        String str = "com.google.android.gms";
        if (zznx.zzrU()) {
            ((AppOpsManager) getSystemService("appops")).checkPackage(callingUid, "com.google.android.gms");
            return;
        }
        String[] packagesForUid = getPackageManager().getPackagesForUid(callingUid);
        if (packagesForUid != null) {
            int length = packagesForUid.length;
            int i = 0;
            while (i < length) {
                if (!packagesForUid[i].equals("com.google.android.gms")) {
                    i++;
                } else {
                    return;
                }
            }
        }
        throw new SecurityException("Unauthorized caller");
    }
}
