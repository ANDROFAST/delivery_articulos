package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class zzm extends zzl implements Callback {
    private final Handler mHandler;
    private final HashMap<zza, zzb> zzaki = new HashMap();
    private final com.google.android.gms.common.stats.zzb zzakj;
    private final long zzakk;
    private final Context zzrI;

    private static final class zza {
        private final String zzRA;
        private final ComponentName zzakl;

        public zza(ComponentName componentName) {
            this.zzRA = null;
            this.zzakl = (ComponentName) zzx.zzy(componentName);
        }

        public zza(String str) {
            this.zzRA = zzx.zzcG(str);
            this.zzakl = null;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_common_internal_zzm_zza = (zza) o;
            return zzw.equal(this.zzRA, com_google_android_gms_common_internal_zzm_zza.zzRA) && zzw.equal(this.zzakl, com_google_android_gms_common_internal_zzm_zza.zzakl);
        }

        public int hashCode() {
            return zzw.hashCode(this.zzRA, this.zzakl);
        }

        public String toString() {
            return this.zzRA == null ? this.zzakl.flattenToString() : this.zzRA;
        }

        public Intent zzqC() {
            return this.zzRA != null ? new Intent(this.zzRA).setPackage("com.google.android.gms") : new Intent().setComponent(this.zzakl);
        }
    }

    private final class zzb {
        private int mState = 2;
        private IBinder zzaiT;
        private ComponentName zzakl;
        private final zza zzakm = new zza(this);
        private final Set<ServiceConnection> zzakn = new HashSet();
        private boolean zzako;
        private final zza zzakp;
        final /* synthetic */ zzm zzakq;

        public class zza implements ServiceConnection {
            final /* synthetic */ zzb zzakr;

            public zza(zzb com_google_android_gms_common_internal_zzm_zzb) {
                this.zzakr = com_google_android_gms_common_internal_zzm_zzb;
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (this.zzakr.zzakq.zzaki) {
                    this.zzakr.zzaiT = binder;
                    this.zzakr.zzakl = component;
                    for (ServiceConnection onServiceConnected : this.zzakr.zzakn) {
                        onServiceConnected.onServiceConnected(component, binder);
                    }
                    this.zzakr.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (this.zzakr.zzakq.zzaki) {
                    this.zzakr.zzaiT = null;
                    this.zzakr.zzakl = component;
                    for (ServiceConnection onServiceDisconnected : this.zzakr.zzakn) {
                        onServiceDisconnected.onServiceDisconnected(component);
                    }
                    this.zzakr.mState = 2;
                }
            }
        }

        public zzb(zzm com_google_android_gms_common_internal_zzm, zza com_google_android_gms_common_internal_zzm_zza) {
            this.zzakq = com_google_android_gms_common_internal_zzm;
            this.zzakp = com_google_android_gms_common_internal_zzm_zza;
        }

        public IBinder getBinder() {
            return this.zzaiT;
        }

        public ComponentName getComponentName() {
            return this.zzakl;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.zzako;
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            this.zzakq.zzakj.zza(this.zzakq.zzrI, serviceConnection, str, this.zzakp.zzqC());
            this.zzakn.add(serviceConnection);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.zzakn.contains(serviceConnection);
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            this.zzakq.zzakj.zzb(this.zzakq.zzrI, serviceConnection);
            this.zzakn.remove(serviceConnection);
        }

        public void zzcB(String str) {
            this.mState = 3;
            this.zzako = this.zzakq.zzakj.zza(this.zzakq.zzrI, str, this.zzakp.zzqC(), this.zzakm, 129);
            if (!this.zzako) {
                this.mState = 2;
                try {
                    this.zzakq.zzakj.zza(this.zzakq.zzrI, this.zzakm);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        public void zzcC(String str) {
            this.zzakq.zzakj.zza(this.zzakq.zzrI, this.zzakm);
            this.zzako = false;
            this.mState = 2;
        }

        public boolean zzqD() {
            return this.zzakn.isEmpty();
        }
    }

    zzm(Context context) {
        this.zzrI = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzakj = com.google.android.gms.common.stats.zzb.zzrz();
        this.zzakk = 5000;
    }

    private boolean zza(zza com_google_android_gms_common_internal_zzm_zza, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzx.zzb((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzaki) {
            zzb com_google_android_gms_common_internal_zzm_zzb = (zzb) this.zzaki.get(com_google_android_gms_common_internal_zzm_zza);
            if (com_google_android_gms_common_internal_zzm_zzb != null) {
                this.mHandler.removeMessages(0, com_google_android_gms_common_internal_zzm_zzb);
                if (!com_google_android_gms_common_internal_zzm_zzb.zza(serviceConnection)) {
                    com_google_android_gms_common_internal_zzm_zzb.zza(serviceConnection, str);
                    switch (com_google_android_gms_common_internal_zzm_zzb.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(com_google_android_gms_common_internal_zzm_zzb.getComponentName(), com_google_android_gms_common_internal_zzm_zzb.getBinder());
                            break;
                        case 2:
                            com_google_android_gms_common_internal_zzm_zzb.zzcB(str);
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + com_google_android_gms_common_internal_zzm_zza);
            }
            com_google_android_gms_common_internal_zzm_zzb = new zzb(this, com_google_android_gms_common_internal_zzm_zza);
            com_google_android_gms_common_internal_zzm_zzb.zza(serviceConnection, str);
            com_google_android_gms_common_internal_zzm_zzb.zzcB(str);
            this.zzaki.put(com_google_android_gms_common_internal_zzm_zza, com_google_android_gms_common_internal_zzm_zzb);
            isBound = com_google_android_gms_common_internal_zzm_zzb.isBound();
        }
        return isBound;
    }

    private void zzb(zza com_google_android_gms_common_internal_zzm_zza, ServiceConnection serviceConnection, String str) {
        zzx.zzb((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzaki) {
            zzb com_google_android_gms_common_internal_zzm_zzb = (zzb) this.zzaki.get(com_google_android_gms_common_internal_zzm_zza);
            if (com_google_android_gms_common_internal_zzm_zzb == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + com_google_android_gms_common_internal_zzm_zza);
            } else if (com_google_android_gms_common_internal_zzm_zzb.zza(serviceConnection)) {
                com_google_android_gms_common_internal_zzm_zzb.zzb(serviceConnection, str);
                if (com_google_android_gms_common_internal_zzm_zzb.zzqD()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, com_google_android_gms_common_internal_zzm_zzb), this.zzakk);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + com_google_android_gms_common_internal_zzm_zza);
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                zzb com_google_android_gms_common_internal_zzm_zzb = (zzb) msg.obj;
                synchronized (this.zzaki) {
                    if (com_google_android_gms_common_internal_zzm_zzb.zzqD()) {
                        if (com_google_android_gms_common_internal_zzm_zzb.isBound()) {
                            com_google_android_gms_common_internal_zzm_zzb.zzcC("GmsClientSupervisor");
                        }
                        this.zzaki.remove(com_google_android_gms_common_internal_zzm_zzb.zzakp);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName), serviceConnection, str);
    }

    public boolean zza(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str), serviceConnection, str2);
    }

    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName), serviceConnection, str);
    }

    public void zzb(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str), serviceConnection, str2);
    }
}
