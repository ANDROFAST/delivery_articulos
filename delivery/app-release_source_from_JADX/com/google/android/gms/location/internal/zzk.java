package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzd;
import java.util.HashMap;
import java.util.Map;

public class zzk {
    private final Context mContext;
    private final zzp<zzi> zzaLF;
    private ContentProviderClient zzaLS = null;
    private boolean zzaLT = false;
    private Map<LocationCallback, zza> zzaLU = new HashMap();
    private Map<LocationListener, zzc> zzauU = new HashMap();

    private static class zzb extends Handler {
        private final LocationListener zzaLX;

        public zzb(LocationListener locationListener) {
            this.zzaLX = locationListener;
        }

        public zzb(LocationListener locationListener, Looper looper) {
            super(looper);
            this.zzaLX = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.zzaLX.onLocationChanged(new Location((Location) msg.obj));
                    return;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    return;
            }
        }
    }

    private static class zza extends com.google.android.gms.location.zzc.zza {
        private Handler zzaLV;

        zza(final LocationCallback locationCallback, Looper looper) {
            if (looper == null) {
                looper = Looper.myLooper();
                zzx.zza(looper != null, (Object) "Can't create handler inside thread that has not called Looper.prepare()");
            }
            this.zzaLV = new Handler(this, looper) {
                final /* synthetic */ zza zzaLW;

                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case 0:
                            locationCallback.onLocationResult((LocationResult) msg.obj);
                            return;
                        case 1:
                            locationCallback.onLocationAvailability((LocationAvailability) msg.obj);
                            return;
                        default:
                            return;
                    }
                }
            };
        }

        private void zzb(int i, Object obj) {
            if (this.zzaLV == null) {
                Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            this.zzaLV.sendMessage(obtain);
        }

        public void onLocationAvailability(LocationAvailability state) {
            zzb(1, state);
        }

        public void onLocationResult(LocationResult locationResult) {
            zzb(0, locationResult);
        }

        public void release() {
            this.zzaLV = null;
        }
    }

    private static class zzc extends com.google.android.gms.location.zzd.zza {
        private Handler zzaLV;

        zzc(LocationListener locationListener, Looper looper) {
            if (looper == null) {
                zzx.zza(Looper.myLooper() != null, (Object) "Can't create handler inside thread that has not called Looper.prepare()");
            }
            this.zzaLV = looper == null ? new zzb(locationListener) : new zzb(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.zzaLV == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.zzaLV.sendMessage(obtain);
        }

        public void release() {
            this.zzaLV = null;
        }
    }

    public zzk(Context context, zzp<zzi> com_google_android_gms_location_internal_zzp_com_google_android_gms_location_internal_zzi) {
        this.mContext = context;
        this.zzaLF = com_google_android_gms_location_internal_zzp_com_google_android_gms_location_internal_zzi;
    }

    private zza zza(LocationCallback locationCallback, Looper looper) {
        zza com_google_android_gms_location_internal_zzk_zza;
        synchronized (this.zzaLU) {
            com_google_android_gms_location_internal_zzk_zza = (zza) this.zzaLU.get(locationCallback);
            if (com_google_android_gms_location_internal_zzk_zza == null) {
                com_google_android_gms_location_internal_zzk_zza = new zza(locationCallback, looper);
            }
            this.zzaLU.put(locationCallback, com_google_android_gms_location_internal_zzk_zza);
        }
        return com_google_android_gms_location_internal_zzk_zza;
    }

    private zzc zza(LocationListener locationListener, Looper looper) {
        zzc com_google_android_gms_location_internal_zzk_zzc;
        synchronized (this.zzauU) {
            com_google_android_gms_location_internal_zzk_zzc = (zzc) this.zzauU.get(locationListener);
            if (com_google_android_gms_location_internal_zzk_zzc == null) {
                com_google_android_gms_location_internal_zzk_zzc = new zzc(locationListener, looper);
            }
            this.zzauU.put(locationListener, com_google_android_gms_location_internal_zzk_zzc);
        }
        return com_google_android_gms_location_internal_zzk_zzc;
    }

    public Location getLastLocation() {
        this.zzaLF.zzqr();
        try {
            return ((zzi) this.zzaLF.zzqs()).zzdS(this.mContext.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.zzauU) {
                for (zzd com_google_android_gms_location_zzd : this.zzauU.values()) {
                    if (com_google_android_gms_location_zzd != null) {
                        ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(com_google_android_gms_location_zzd, null));
                    }
                }
                this.zzauU.clear();
            }
            synchronized (this.zzaLU) {
                for (com.google.android.gms.location.zzc com_google_android_gms_location_zzc : this.zzaLU.values()) {
                    if (com_google_android_gms_location_zzc != null) {
                        ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(com_google_android_gms_location_zzc, null));
                    }
                }
                this.zzaLU.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void zza(PendingIntent pendingIntent, zzg com_google_android_gms_location_internal_zzg) throws RemoteException {
        this.zzaLF.zzqr();
        ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zzb(pendingIntent, com_google_android_gms_location_internal_zzg));
    }

    public void zza(LocationCallback locationCallback, zzg com_google_android_gms_location_internal_zzg) throws RemoteException {
        this.zzaLF.zzqr();
        zzx.zzb((Object) locationCallback, (Object) "Invalid null callback");
        synchronized (this.zzaLU) {
            com.google.android.gms.location.zzc com_google_android_gms_location_zzc = (zza) this.zzaLU.remove(locationCallback);
            if (com_google_android_gms_location_zzc != null) {
                com_google_android_gms_location_zzc.release();
                ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(com_google_android_gms_location_zzc, com_google_android_gms_location_internal_zzg));
            }
        }
    }

    public void zza(LocationListener locationListener, zzg com_google_android_gms_location_internal_zzg) throws RemoteException {
        this.zzaLF.zzqr();
        zzx.zzb((Object) locationListener, (Object) "Invalid null listener");
        synchronized (this.zzauU) {
            zzd com_google_android_gms_location_zzd = (zzc) this.zzauU.remove(locationListener);
            if (this.zzaLS != null && this.zzauU.isEmpty()) {
                this.zzaLS.release();
                this.zzaLS = null;
            }
            if (com_google_android_gms_location_zzd != null) {
                com_google_android_gms_location_zzd.release();
                ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(com_google_android_gms_location_zzd, com_google_android_gms_location_internal_zzg));
            }
        }
    }

    public void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzg com_google_android_gms_location_internal_zzg) throws RemoteException {
        this.zzaLF.zzqr();
        ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(locationRequest), pendingIntent, com_google_android_gms_location_internal_zzg));
    }

    public void zza(LocationRequest locationRequest, LocationListener locationListener, Looper looper, zzg com_google_android_gms_location_internal_zzg) throws RemoteException {
        this.zzaLF.zzqr();
        ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(locationRequest), zza(locationListener, looper), com_google_android_gms_location_internal_zzg));
    }

    public void zza(LocationRequestInternal locationRequestInternal, LocationCallback locationCallback, Looper looper, zzg com_google_android_gms_location_internal_zzg) throws RemoteException {
        this.zzaLF.zzqr();
        ((zzi) this.zzaLF.zzqs()).zza(LocationRequestUpdateData.zza(locationRequestInternal, zza(locationCallback, looper), com_google_android_gms_location_internal_zzg));
    }

    public void zza(zzg com_google_android_gms_location_internal_zzg) throws RemoteException {
        this.zzaLF.zzqr();
        ((zzi) this.zzaLF.zzqs()).zza(com_google_android_gms_location_internal_zzg);
    }

    public void zzai(boolean z) throws RemoteException {
        this.zzaLF.zzqr();
        ((zzi) this.zzaLF.zzqs()).zzai(z);
        this.zzaLT = z;
    }

    public void zzc(Location location) throws RemoteException {
        this.zzaLF.zzqr();
        ((zzi) this.zzaLF.zzqs()).zzc(location);
    }

    public LocationAvailability zzyc() {
        this.zzaLF.zzqr();
        try {
            return ((zzi) this.zzaLF.zzqs()).zzdT(this.mContext.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void zzyd() {
        if (this.zzaLT) {
            try {
                zzai(false);
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
