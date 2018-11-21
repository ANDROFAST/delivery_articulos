package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.JoinOptions;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zze extends zzj<zzi> {
    private static final zzl zzYy = new zzl("CastClientImpl");
    private static final Object zzaci = new Object();
    private static final Object zzacj = new Object();
    private final Listener zzYj;
    private double zzZL;
    private boolean zzZM;
    private ApplicationMetadata zzabQ;
    private final CastDevice zzabR;
    private final Map<String, MessageReceivedCallback> zzabS = new HashMap();
    private final long zzabT;
    private zzb zzabU;
    private String zzabV;
    private boolean zzabW;
    private boolean zzabX;
    private boolean zzabY;
    private int zzabZ;
    private int zzaca;
    private final AtomicLong zzacb = new AtomicLong(0);
    private String zzacc;
    private String zzacd;
    private Bundle zzace;
    private final Map<Long, com.google.android.gms.internal.zzlx.zzb<Status>> zzacf = new HashMap();
    private com.google.android.gms.internal.zzlx.zzb<ApplicationConnectionResult> zzacg;
    private com.google.android.gms.internal.zzlx.zzb<Status> zzach;

    private static final class zza implements ApplicationConnectionResult {
        private final String zzJX;
        private final Status zzTA;
        private final ApplicationMetadata zzack;
        private final String zzacl;
        private final boolean zzacm;

        public zza(Status status) {
            this(status, null, null, null, false);
        }

        public zza(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.zzTA = status;
            this.zzack = applicationMetadata;
            this.zzacl = str;
            this.zzJX = str2;
            this.zzacm = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.zzack;
        }

        public String getApplicationStatus() {
            return this.zzacl;
        }

        public String getSessionId() {
            return this.zzJX;
        }

        public Status getStatus() {
            return this.zzTA;
        }

        public boolean getWasLaunched() {
            return this.zzacm;
        }
    }

    private static class zzb extends com.google.android.gms.cast.internal.zzj.zza {
        private final Handler mHandler;
        private final AtomicReference<zze> zzacn;

        public zzb(zze com_google_android_gms_cast_internal_zze) {
            this.zzacn = new AtomicReference(com_google_android_gms_cast_internal_zze);
            this.mHandler = new Handler(com_google_android_gms_cast_internal_zze.getLooper());
        }

        private void zza(zze com_google_android_gms_cast_internal_zze, long j, int i) {
            synchronized (com_google_android_gms_cast_internal_zze.zzacf) {
                com.google.android.gms.internal.zzlx.zzb com_google_android_gms_internal_zzlx_zzb = (com.google.android.gms.internal.zzlx.zzb) com_google_android_gms_cast_internal_zze.zzacf.remove(Long.valueOf(j));
            }
            if (com_google_android_gms_internal_zzlx_zzb != null) {
                com_google_android_gms_internal_zzlx_zzb.zzr(new Status(i));
            }
        }

        private boolean zza(zze com_google_android_gms_cast_internal_zze, int i) {
            synchronized (zze.zzacj) {
                if (com_google_android_gms_cast_internal_zze.zzach != null) {
                    com_google_android_gms_cast_internal_zze.zzach.zzr(new Status(i));
                    com_google_android_gms_cast_internal_zze.zzach = null;
                    return true;
                }
                return false;
            }
        }

        public boolean isDisposed() {
            return this.zzacn.get() == null;
        }

        public void onApplicationDisconnected(final int statusCode) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.zzacn.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                com_google_android_gms_cast_internal_zze.zzacc = null;
                com_google_android_gms_cast_internal_zze.zzacd = null;
                zza(com_google_android_gms_cast_internal_zze, statusCode);
                if (com_google_android_gms_cast_internal_zze.zzYj != null) {
                    this.mHandler.post(new Runnable(this) {
                        final /* synthetic */ zzb zzacq;

                        public void run() {
                            if (com_google_android_gms_cast_internal_zze.zzYj != null) {
                                com_google_android_gms_cast_internal_zze.zzYj.onApplicationDisconnected(statusCode);
                            }
                        }
                    });
                }
            }
        }

        public void zza(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzacn.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                com_google_android_gms_cast_internal_zze.zzabQ = applicationMetadata;
                com_google_android_gms_cast_internal_zze.zzacc = applicationMetadata.getApplicationId();
                com_google_android_gms_cast_internal_zze.zzacd = str2;
                synchronized (zze.zzaci) {
                    if (com_google_android_gms_cast_internal_zze.zzacg != null) {
                        com_google_android_gms_cast_internal_zze.zzacg.zzr(new zza(new Status(0), applicationMetadata, str, str2, z));
                        com_google_android_gms_cast_internal_zze.zzacg = null;
                    }
                }
            }
        }

        public void zza(String str, double d, boolean z) {
            zze.zzYy.zzb("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        public void zza(String str, long j, int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzacn.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, j, i);
            }
        }

        public void zzb(final ApplicationStatus applicationStatus) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.zzacn.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zze.zzYy.zzb("onApplicationStatusChanged", new Object[0]);
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ zzb zzacq;

                    public void run() {
                        com_google_android_gms_cast_internal_zze.zza(applicationStatus);
                    }
                });
            }
        }

        public void zzb(final DeviceStatus deviceStatus) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.zzacn.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zze.zzYy.zzb("onDeviceStatusChanged", new Object[0]);
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ zzb zzacq;

                    public void run() {
                        com_google_android_gms_cast_internal_zze.zza(deviceStatus);
                    }
                });
            }
        }

        public void zzb(String str, byte[] bArr) {
            if (((zze) this.zzacn.get()) != null) {
                zze.zzYy.zzb("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
            }
        }

        public void zzbk(int i) {
            zze zzoa = zzoa();
            if (zzoa != null) {
                zze.zzYy.zzb("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
                if (i != 0) {
                    zzoa.zzbT(2);
                }
            }
        }

        public void zzbl(int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzacn.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                synchronized (zze.zzaci) {
                    if (com_google_android_gms_cast_internal_zze.zzacg != null) {
                        com_google_android_gms_cast_internal_zze.zzacg.zzr(new zza(new Status(i)));
                        com_google_android_gms_cast_internal_zze.zzacg = null;
                    }
                }
            }
        }

        public void zzbm(int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzacn.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, i);
            }
        }

        public void zzbn(int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzacn.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, i);
            }
        }

        public void zzc(String str, long j) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzacn.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, j, 0);
            }
        }

        public zze zzoa() {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzacn.getAndSet(null);
            if (com_google_android_gms_cast_internal_zze == null) {
                return null;
            }
            com_google_android_gms_cast_internal_zze.zznP();
            return com_google_android_gms_cast_internal_zze;
        }

        public void zzu(final String str, final String str2) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.zzacn.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zze.zzYy.zzb("Receive (type=text, ns=%s) %s", str, str2);
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ zzb zzacq;

                    public void run() {
                        synchronized (com_google_android_gms_cast_internal_zze.zzabS) {
                            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) com_google_android_gms_cast_internal_zze.zzabS.get(str);
                        }
                        if (messageReceivedCallback != null) {
                            messageReceivedCallback.onMessageReceived(com_google_android_gms_cast_internal_zze.zzabR, str, str2);
                            return;
                        }
                        zze.zzYy.zzb("Discarded message for unknown namespace '%s'", str);
                    }
                });
            }
        }
    }

    public zze(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzabR = castDevice;
        this.zzYj = listener;
        this.zzabT = j;
        zznP();
    }

    private void zza(ApplicationStatus applicationStatus) {
        boolean z;
        String zznM = applicationStatus.zznM();
        if (zzf.zza(zznM, this.zzabV)) {
            z = false;
        } else {
            this.zzabV = zznM;
            z = true;
        }
        zzYy.zzb("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzabW));
        if (this.zzYj != null && (z || this.zzabW)) {
            this.zzYj.onApplicationStatusChanged();
        }
        this.zzabW = false;
    }

    private void zza(DeviceStatus deviceStatus) {
        boolean z;
        ApplicationMetadata applicationMetadata = deviceStatus.getApplicationMetadata();
        if (!zzf.zza(applicationMetadata, this.zzabQ)) {
            this.zzabQ = applicationMetadata;
            this.zzYj.onApplicationMetadataChanged(this.zzabQ);
        }
        double zznS = deviceStatus.zznS();
        if (zznS == Double.NaN || Math.abs(zznS - this.zzZL) <= 1.0E-7d) {
            z = false;
        } else {
            this.zzZL = zznS;
            z = true;
        }
        boolean zzob = deviceStatus.zzob();
        if (zzob != this.zzZM) {
            this.zzZM = zzob;
            z = true;
        }
        zzYy.zzb("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzabX));
        if (this.zzYj != null && (z || this.zzabX)) {
            this.zzYj.onVolumeChanged();
        }
        int zznT = deviceStatus.zznT();
        if (zznT != this.zzabZ) {
            this.zzabZ = zznT;
            z = true;
        } else {
            z = false;
        }
        zzYy.zzb("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzabX));
        if (this.zzYj != null && (z || this.zzabX)) {
            this.zzYj.onActiveInputStateChanged(this.zzabZ);
        }
        zznT = deviceStatus.zznU();
        if (zznT != this.zzaca) {
            this.zzaca = zznT;
            z = true;
        } else {
            z = false;
        }
        zzYy.zzb("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzabX));
        if (this.zzYj != null && (z || this.zzabX)) {
            this.zzYj.onStandbyStateChanged(this.zzaca);
        }
        this.zzabX = false;
    }

    private void zza(com.google.android.gms.internal.zzlx.zzb<ApplicationConnectionResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) {
        synchronized (zzaci) {
            if (this.zzacg != null) {
                this.zzacg.zzr(new zza(new Status(2002)));
            }
            this.zzacg = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult;
        }
    }

    private void zzc(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
        synchronized (zzacj) {
            if (this.zzach != null) {
                com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status.zzr(new Status(2001));
                return;
            }
            this.zzach = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status;
        }
    }

    private void zznP() {
        this.zzabY = false;
        this.zzabZ = -1;
        this.zzaca = -1;
        this.zzabQ = null;
        this.zzabV = null;
        this.zzZL = 0.0d;
        this.zzZM = false;
    }

    private void zznV() {
        zzYy.zzb("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zzabS) {
            this.zzabS.clear();
        }
    }

    private void zznW() throws IllegalStateException {
        if (!this.zzabY || this.zzabU == null || this.zzabU.isDisposed()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    public void disconnect() {
        Throwable e;
        zzYy.zzb("disconnect(); ServiceListener=%s, isConnected=%b", this.zzabU, Boolean.valueOf(isConnected()));
        zzb com_google_android_gms_cast_internal_zze_zzb = this.zzabU;
        this.zzabU = null;
        if (com_google_android_gms_cast_internal_zze_zzb == null || com_google_android_gms_cast_internal_zze_zzb.zzoa() == null) {
            zzYy.zzb("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        zznV();
        try {
            ((zzi) zzqs()).disconnect();
            super.disconnect();
        } catch (RemoteException e2) {
            e = e2;
            try {
                zzYy.zzb(e, "Error while disconnecting the controller interface: %s", e.getMessage());
            } finally {
                super.disconnect();
            }
        } catch (IllegalStateException e3) {
            e = e3;
            zzYy.zzb(e, "Error while disconnecting the controller interface: %s", e.getMessage());
        }
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        zznW();
        return this.zzabQ;
    }

    public String getApplicationStatus() throws IllegalStateException {
        zznW();
        return this.zzabV;
    }

    public boolean isMute() throws IllegalStateException {
        zznW();
        return this.zzZM;
    }

    public void onConnectionFailed(ConnectionResult result) {
        super.onConnectionFailed(result);
        zznV();
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzaE(iBinder);
    }

    public void zzX(boolean z) throws IllegalStateException, RemoteException {
        ((zzi) zzqs()).zza(z, this.zzZL, this.zzZM);
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        zzYy.zzb("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == 1001) {
            this.zzabY = true;
            this.zzabW = true;
            this.zzabX = true;
        } else {
            this.zzabY = false;
        }
        if (i == 1001) {
            this.zzace = new Bundle();
            this.zzace.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(String str, MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        zzf.zzcb(str);
        zzca(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zzabS) {
                this.zzabS.put(str, messageReceivedCallback);
            }
            ((zzi) zzqs()).zzcf(str);
        }
    }

    public void zza(String str, LaunchOptions launchOptions, com.google.android.gms.internal.zzlx.zzb<ApplicationConnectionResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) throws IllegalStateException, RemoteException {
        zza((com.google.android.gms.internal.zzlx.zzb) com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        ((zzi) zzqs()).zza(str, launchOptions);
    }

    public void zza(String str, com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) throws IllegalStateException, RemoteException {
        zzc((com.google.android.gms.internal.zzlx.zzb) com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
        ((zzi) zzqs()).zzce(str);
    }

    public void zza(String str, String str2, JoinOptions joinOptions, com.google.android.gms.internal.zzlx.zzb<ApplicationConnectionResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) throws IllegalStateException, RemoteException {
        zza((com.google.android.gms.internal.zzlx.zzb) com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        if (joinOptions == null) {
            joinOptions = new JoinOptions();
        }
        ((zzi) zzqs()).zza(str, str2, joinOptions);
    }

    public void zza(String str, String str2, com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            zzf.zzcb(str);
            zznW();
            long incrementAndGet = this.zzacb.incrementAndGet();
            try {
                this.zzacf.put(Long.valueOf(incrementAndGet), com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
                ((zzi) zzqs()).zzb(str, str2, incrementAndGet);
            } catch (Throwable th) {
                this.zzacf.remove(Long.valueOf(incrementAndGet));
            }
        }
    }

    public void zza(String str, boolean z, com.google.android.gms.internal.zzlx.zzb<ApplicationConnectionResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) throws IllegalStateException, RemoteException {
        zza((com.google.android.gms.internal.zzlx.zzb) com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        ((zzi) zzqs()).zzf(str, z);
    }

    protected zzi zzaE(IBinder iBinder) {
        return com.google.android.gms.cast.internal.zzi.zza.zzaF(iBinder);
    }

    public void zzb(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) throws IllegalStateException, RemoteException {
        zzc((com.google.android.gms.internal.zzlx.zzb) com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
        ((zzi) zzqs()).zzoc();
    }

    public void zzca(String str) throws IllegalArgumentException, RemoteException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.zzabS) {
            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.zzabS.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((zzi) zzqs()).zzcg(str);
            } catch (Throwable e) {
                zzYy.zzb(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public void zzf(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((zzi) zzqs()).zza(d, this.zzZL, this.zzZM);
    }

    protected String zzgh() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String zzgi() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    protected Bundle zzlU() {
        Bundle bundle = new Bundle();
        zzYy.zzb("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.zzacc, this.zzacd);
        this.zzabR.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzabT);
        this.zzabU = new zzb(this);
        bundle.putParcelable("listener", new BinderWrapper(this.zzabU.asBinder()));
        if (this.zzacc != null) {
            bundle.putString("last_application_id", this.zzacc);
            if (this.zzacd != null) {
                bundle.putString("last_session_id", this.zzacd);
            }
        }
        return bundle;
    }

    public Bundle zznQ() {
        if (this.zzace == null) {
            return super.zznQ();
        }
        Bundle bundle = this.zzace;
        this.zzace = null;
        return bundle;
    }

    public void zznR() throws IllegalStateException, RemoteException {
        ((zzi) zzqs()).zznR();
    }

    public double zznS() throws IllegalStateException {
        zznW();
        return this.zzZL;
    }

    public int zznT() throws IllegalStateException {
        zznW();
        return this.zzabZ;
    }

    public int zznU() throws IllegalStateException {
        zznW();
        return this.zzaca;
    }
}
