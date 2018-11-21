package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.request.OnDataPointListener;
import java.util.HashMap;
import java.util.Map;

public class zzk extends com.google.android.gms.fitness.data.zzj.zza {
    private final OnDataPointListener zzauS;

    public static class zza {
        private static final zza zzauT = new zza();
        private final Map<OnDataPointListener, zzk> zzauU = new HashMap();

        private zza() {
        }

        public static zza zztQ() {
            return zzauT;
        }

        public zzk zza(OnDataPointListener onDataPointListener) {
            zzk com_google_android_gms_fitness_data_zzk;
            synchronized (this.zzauU) {
                com_google_android_gms_fitness_data_zzk = (zzk) this.zzauU.get(onDataPointListener);
                if (com_google_android_gms_fitness_data_zzk == null) {
                    com_google_android_gms_fitness_data_zzk = new zzk(onDataPointListener);
                    this.zzauU.put(onDataPointListener, com_google_android_gms_fitness_data_zzk);
                }
            }
            return com_google_android_gms_fitness_data_zzk;
        }

        public zzk zzb(OnDataPointListener onDataPointListener) {
            zzk com_google_android_gms_fitness_data_zzk;
            synchronized (this.zzauU) {
                com_google_android_gms_fitness_data_zzk = (zzk) this.zzauU.get(onDataPointListener);
            }
            return com_google_android_gms_fitness_data_zzk;
        }

        public zzk zzc(OnDataPointListener onDataPointListener) {
            zzk com_google_android_gms_fitness_data_zzk;
            synchronized (this.zzauU) {
                com_google_android_gms_fitness_data_zzk = (zzk) this.zzauU.remove(onDataPointListener);
                if (com_google_android_gms_fitness_data_zzk != null) {
                } else {
                    com_google_android_gms_fitness_data_zzk = new zzk(onDataPointListener);
                }
            }
            return com_google_android_gms_fitness_data_zzk;
        }
    }

    private zzk(OnDataPointListener onDataPointListener) {
        this.zzauS = (OnDataPointListener) zzx.zzy(onDataPointListener);
    }

    public void zzc(DataPoint dataPoint) throws RemoteException {
        this.zzauS.onDataPoint(dataPoint);
    }
}
