package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.DriveEventService;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzg;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.internal.zzt.zza;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzu extends zzj<zzam> {
    private final String zzTz;
    final ConnectionCallbacks zzajO;
    private final Bundle zzaoH;
    private final boolean zzaoI;
    private volatile DriveId zzaoJ;
    private volatile DriveId zzaoK;
    private volatile boolean zzaoL = false;
    final Map<DriveId, Map<ChangeListener, zzae>> zzaoM = new HashMap();
    final Map<zzc, zzae> zzaoN = new HashMap();
    final Map<DriveId, Map<zzi, zzae>> zzaoO = new HashMap();
    final Map<DriveId, Map<zzi, zzae>> zzaoP = new HashMap();

    public zzu(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, Bundle bundle) {
        super(context, looper, 11, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzTz = com_google_android_gms_common_internal_zzf.zzqd();
        this.zzajO = connectionCallbacks;
        this.zzaoH = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        switch (queryIntentServices.size()) {
            case 0:
                this.zzaoI = false;
                return;
            case 1:
                ServiceInfo serviceInfo = ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
                if (serviceInfo.exported) {
                    this.zzaoI = true;
                    return;
                }
                throw new IllegalStateException("Drive event service " + serviceInfo.name + " must be exported in AndroidManifest.xml");
            default:
                throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + intent.getAction() + " action");
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final int i, final DriveId driveId) {
        zzx.zzb(zzg.zza(i, driveId), (Object) "id");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzu zzaoU;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zza(new RemoveEventListenerRequest(driveId, i), null, null, new zzbt(this));
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, int i, DriveId driveId, ChangesAvailableOptions changesAvailableOptions) {
        zzx.zzb(zzg.zza(i, driveId), (Object) "id");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        if (this.zzaoI) {
            final DriveId driveId2 = driveId;
            final int i2 = i;
            final ChangesAvailableOptions changesAvailableOptions2 = changesAvailableOptions;
            return googleApiClient.zzb(new zza(this, googleApiClient) {
                final /* synthetic */ zzu zzaoU;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    com_google_android_gms_drive_internal_zzu.zzsF().zza(new AddEventListenerRequest(driveId2, i2, changesAvailableOptions2), null, null, new zzbt(this));
                }
            });
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, int i, DriveId driveId, zzae com_google_android_gms_drive_internal_zzae) {
        final DriveId driveId2 = driveId;
        final int i2 = i;
        final zzae com_google_android_gms_drive_internal_zzae2 = com_google_android_gms_drive_internal_zzae;
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzu zzaoU;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zza(new RemoveEventListenerRequest(driveId2, i2), com_google_android_gms_drive_internal_zzae2, null, new zzbt(this));
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, int i, DriveId driveId, zzae com_google_android_gms_drive_internal_zzae, ChangesAvailableOptions changesAvailableOptions) {
        final DriveId driveId2 = driveId;
        final int i2 = i;
        final ChangesAvailableOptions changesAvailableOptions2 = changesAvailableOptions;
        final zzae com_google_android_gms_drive_internal_zzae2 = com_google_android_gms_drive_internal_zzae;
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzu zzaoU;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zza(new AddEventListenerRequest(driveId2, i2, changesAvailableOptions2), com_google_android_gms_drive_internal_zzae2, null, new zzbt(this));
            }
        });
    }

    PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, final List<String> pendingTags) {
        boolean z = true;
        zzx.zzab(pendingTags != null);
        if (pendingTags.isEmpty()) {
            z = false;
        }
        zzx.zzab(z);
        zzx.zza(isConnected(), (Object) "Client must be connected");
        return apiClient.zzb(new zza(this, apiClient) {
            final /* synthetic */ zzu zzaoU;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zza(new CancelPendingActionsRequest(pendingTags), new zzbt(this));
            }
        });
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzam) zzqs()).zza(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        synchronized (this.zzaoM) {
            this.zzaoM.clear();
        }
        synchronized (this.zzaoN) {
            this.zzaoN.clear();
        }
        synchronized (this.zzaoO) {
            this.zzaoO.clear();
        }
        synchronized (this.zzaoP) {
            this.zzaoP.clear();
        }
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzaZ(iBinder);
    }

    PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, 1, driveId, null);
    }

    PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        PendingResult<Status> com_google_android_gms_drive_internal_zzs_zzj;
        zzx.zzb(zzg.zza(1, driveId), (Object) "id");
        zzx.zzb((Object) changeListener, (Object) "listener");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        synchronized (this.zzaoM) {
            Map map;
            zzae com_google_android_gms_drive_internal_zzae;
            Map map2 = (Map) this.zzaoM.get(driveId);
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.zzaoM.put(driveId, hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            zzae com_google_android_gms_drive_internal_zzae2 = (zzae) map.get(changeListener);
            if (com_google_android_gms_drive_internal_zzae2 == null) {
                com_google_android_gms_drive_internal_zzae = new zzae(getLooper(), getContext(), 1, changeListener);
                map.put(changeListener, com_google_android_gms_drive_internal_zzae);
            } else if (com_google_android_gms_drive_internal_zzae2.zzde(1)) {
                com_google_android_gms_drive_internal_zzs_zzj = new zzj(googleApiClient, Status.zzaeX);
            } else {
                com_google_android_gms_drive_internal_zzae = com_google_android_gms_drive_internal_zzae2;
            }
            com_google_android_gms_drive_internal_zzae.zzdd(1);
            com_google_android_gms_drive_internal_zzs_zzj = zza(googleApiClient, 1, driveId, com_google_android_gms_drive_internal_zzae, null);
        }
        return com_google_android_gms_drive_internal_zzs_zzj;
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaoJ = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.zzaoK = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
            this.zzaoL = true;
        }
        super.zza(i, iBinder, bundle, i2);
    }

    protected zzam zzaZ(IBinder iBinder) {
        return zzam.zza.zzba(iBinder);
    }

    PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, 1, driveId);
    }

    PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        PendingResult<Status> com_google_android_gms_drive_internal_zzs_zzj;
        zzx.zzb(zzg.zza(1, driveId), (Object) "id");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        zzx.zzb((Object) changeListener, (Object) "listener");
        synchronized (this.zzaoM) {
            Map map = (Map) this.zzaoM.get(driveId);
            if (map == null) {
                com_google_android_gms_drive_internal_zzs_zzj = new zzj(googleApiClient, Status.zzaeX);
            } else {
                zzae com_google_android_gms_drive_internal_zzae = (zzae) map.remove(changeListener);
                if (com_google_android_gms_drive_internal_zzae == null) {
                    com_google_android_gms_drive_internal_zzs_zzj = new zzj(googleApiClient, Status.zzaeX);
                } else {
                    if (map.isEmpty()) {
                        this.zzaoM.remove(driveId);
                    }
                    com_google_android_gms_drive_internal_zzs_zzj = zza(googleApiClient, 1, driveId, com_google_android_gms_drive_internal_zzae);
                }
            }
        }
        return com_google_android_gms_drive_internal_zzs_zzj;
    }

    protected String zzgh() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    protected Bundle zzlU() {
        String packageName = getContext().getPackageName();
        zzx.zzy(packageName);
        zzx.zzaa(!zzqq().zzqb().isEmpty());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.zzTz)) {
            bundle.putString("proxy_package_name", this.zzTz);
        }
        bundle.putAll(this.zzaoH);
        return bundle;
    }

    public boolean zzmn() {
        return (getContext().getPackageName().equals(this.zzTz) && zzsE()) ? false : true;
    }

    public boolean zzqu() {
        return true;
    }

    boolean zzsE() {
        return GooglePlayServicesUtil.zze(getContext(), Process.myUid());
    }

    public zzam zzsF() throws DeadObjectException {
        return (zzam) zzqs();
    }

    public DriveId zzsG() {
        return this.zzaoJ;
    }

    public DriveId zzsH() {
        return this.zzaoK;
    }

    public boolean zzsI() {
        return this.zzaoL;
    }

    public boolean zzsJ() {
        return this.zzaoI;
    }
}
