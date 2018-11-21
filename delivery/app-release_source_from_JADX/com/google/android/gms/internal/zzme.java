package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.signin.internal.AuthAccountResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzme implements zzmh {
    private final Context mContext;
    private final GoogleApiAvailability zzaeL;
    private final com.google.android.gms.common.api.Api.zza<? extends zzsc, zzsd> zzaeM;
    private final zzmi zzafD;
    private ConnectionResult zzafF;
    private int zzafG;
    private int zzafH = 0;
    private boolean zzafI = false;
    private int zzafJ;
    private final Bundle zzafK = new Bundle();
    private final Set<com.google.android.gms.common.api.Api.zzc> zzafL = new HashSet();
    private zzsc zzafM;
    private int zzafN;
    private boolean zzafO;
    private boolean zzafP;
    private zzp zzafQ;
    private boolean zzafR;
    private boolean zzafS;
    private final com.google.android.gms.common.internal.zzf zzafT;
    private final Map<Api<?>, Integer> zzafU;
    private ArrayList<Future<?>> zzafV = new ArrayList();
    private final Lock zzafz;

    class C03591 implements Runnable {
        final /* synthetic */ zzme zzafW;

        C03591(zzme com_google_android_gms_internal_zzme) {
            this.zzafW = com_google_android_gms_internal_zzme;
        }

        public void run() {
            this.zzafW.zzaeL.zzaj(this.zzafW.mContext);
        }
    }

    private abstract class zzi implements Runnable {
        final /* synthetic */ zzme zzafW;

        private zzi(zzme com_google_android_gms_internal_zzme) {
            this.zzafW = com_google_android_gms_internal_zzme;
        }

        public void run() {
            this.zzafW.zzafz.lock();
            try {
                if (!Thread.interrupted()) {
                    zzpc();
                    this.zzafW.zzafz.unlock();
                }
            } catch (RuntimeException e) {
                this.zzafW.zzafD.zza(e);
            } finally {
                this.zzafW.zzafz.unlock();
            }
        }

        protected abstract void zzpc();
    }

    private class zzc extends zzi {
        final /* synthetic */ zzme zzafW;

        private zzc(zzme com_google_android_gms_internal_zzme) {
            this.zzafW = com_google_android_gms_internal_zzme;
            super();
        }

        public void zzpc() {
            this.zzafW.zzafM.zza(this.zzafW.zzafQ, this.zzafW.zzafD.zzafp.zzagq, new zza(this.zzafW));
        }
    }

    private static class zzd implements com.google.android.gms.common.api.GoogleApiClient.zza {
        private final WeakReference<zzme> zzafX;
        private final Api<?> zzafm;
        private final int zzafn;

        public zzd(zzme com_google_android_gms_internal_zzme, Api<?> api, int i) {
            this.zzafX = new WeakReference(com_google_android_gms_internal_zzme);
            this.zzafm = api;
            this.zzafn = i;
        }

        public void zza(ConnectionResult connectionResult) {
            boolean z = false;
            zzme com_google_android_gms_internal_zzme = (zzme) this.zzafX.get();
            if (com_google_android_gms_internal_zzme != null) {
                if (Looper.myLooper() == com_google_android_gms_internal_zzme.zzafD.zzafp.getLooper()) {
                    z = true;
                }
                zzx.zza(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                com_google_android_gms_internal_zzme.zzafz.lock();
                try {
                    if (com_google_android_gms_internal_zzme.zzbA(0)) {
                        if (!connectionResult.isSuccess()) {
                            com_google_android_gms_internal_zzme.zzb(connectionResult, this.zzafm, this.zzafn);
                        }
                        if (com_google_android_gms_internal_zzme.zzpd()) {
                            com_google_android_gms_internal_zzme.zzpe();
                        }
                        com_google_android_gms_internal_zzme.zzafz.unlock();
                    }
                } finally {
                    com_google_android_gms_internal_zzme.zzafz.unlock();
                }
            }
        }

        public void zzb(ConnectionResult connectionResult) {
            boolean z = true;
            zzme com_google_android_gms_internal_zzme = (zzme) this.zzafX.get();
            if (com_google_android_gms_internal_zzme != null) {
                if (Looper.myLooper() != com_google_android_gms_internal_zzme.zzafD.zzafp.getLooper()) {
                    z = false;
                }
                zzx.zza(z, (Object) "onReportAccountValidation must be called on the GoogleApiClient handler thread");
                com_google_android_gms_internal_zzme.zzafz.lock();
                try {
                    if (com_google_android_gms_internal_zzme.zzbA(1)) {
                        if (!connectionResult.isSuccess()) {
                            com_google_android_gms_internal_zzme.zzb(connectionResult, this.zzafm, this.zzafn);
                        }
                        if (com_google_android_gms_internal_zzme.zzpd()) {
                            com_google_android_gms_internal_zzme.zzpg();
                        }
                        com_google_android_gms_internal_zzme.zzafz.unlock();
                    }
                } finally {
                    com_google_android_gms_internal_zzme.zzafz.unlock();
                }
            }
        }
    }

    private class zze extends zzi {
        final /* synthetic */ zzme zzafW;
        private final Map<com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.api.GoogleApiClient.zza> zzagd;

        public zze(zzme com_google_android_gms_internal_zzme, Map<com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.api.GoogleApiClient.zza> map) {
            this.zzafW = com_google_android_gms_internal_zzme;
            super();
            this.zzagd = map;
        }

        public void zzpc() {
            int isGooglePlayServicesAvailable = this.zzafW.zzaeL.isGooglePlayServicesAvailable(this.zzafW.mContext);
            if (isGooglePlayServicesAvailable != 0) {
                final ConnectionResult connectionResult = new ConnectionResult(isGooglePlayServicesAvailable, null);
                this.zzafW.zzafD.zza(new zza(this, this.zzafW) {
                    final /* synthetic */ zze zzagf;

                    public void zzpc() {
                        this.zzagf.zzafW.zzi(connectionResult);
                    }
                });
                return;
            }
            if (this.zzafW.zzafO) {
                this.zzafW.zzafM.connect();
            }
            for (com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb : this.zzagd.keySet()) {
                com_google_android_gms_common_api_Api_zzb.zza((com.google.android.gms.common.api.GoogleApiClient.zza) this.zzagd.get(com_google_android_gms_common_api_Api_zzb));
            }
        }
    }

    private class zzf extends zzi {
        final /* synthetic */ zzme zzafW;
        private final ArrayList<com.google.android.gms.common.api.Api.zzb> zzagg;

        public zzf(zzme com_google_android_gms_internal_zzme, ArrayList<com.google.android.gms.common.api.Api.zzb> arrayList) {
            this.zzafW = com_google_android_gms_internal_zzme;
            super();
            this.zzagg = arrayList;
        }

        public void zzpc() {
            if (this.zzafW.zzafD.zzafp.zzagq.isEmpty()) {
                this.zzafW.zzafD.zzafp.zzagq = this.zzafW.zzpl();
            }
            Iterator it = this.zzagg.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.Api.zzb) it.next()).zza(this.zzafW.zzafQ, this.zzafW.zzafD.zzafp.zzagq);
            }
        }
    }

    private class zzg implements ConnectionCallbacks, OnConnectionFailedListener {
        final /* synthetic */ zzme zzafW;

        private zzg(zzme com_google_android_gms_internal_zzme) {
            this.zzafW = com_google_android_gms_internal_zzme;
        }

        public void onConnected(Bundle connectionHint) {
            this.zzafW.zzafM.zza(new zzb(this.zzafW));
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.zzafW.zzafz.lock();
            try {
                if (this.zzafW.zzh(result)) {
                    this.zzafW.zzpj();
                    this.zzafW.zzph();
                } else {
                    this.zzafW.zzi(result);
                }
                this.zzafW.zzafz.unlock();
            } catch (Throwable th) {
                this.zzafW.zzafz.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
        }
    }

    private class zzh extends zzi {
        final /* synthetic */ zzme zzafW;
        private final ArrayList<com.google.android.gms.common.api.Api.zzb> zzagg;

        public zzh(zzme com_google_android_gms_internal_zzme, ArrayList<com.google.android.gms.common.api.Api.zzb> arrayList) {
            this.zzafW = com_google_android_gms_internal_zzme;
            super();
            this.zzagg = arrayList;
        }

        public void zzpc() {
            Iterator it = this.zzagg.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.Api.zzb) it.next()).zza(this.zzafW.zzafQ);
            }
        }
    }

    private static class zzb extends com.google.android.gms.common.internal.zzt.zza {
        private final WeakReference<zzme> zzafX;

        zzb(zzme com_google_android_gms_internal_zzme) {
            this.zzafX = new WeakReference(com_google_android_gms_internal_zzme);
        }

        public void zzb(final ResolveAccountResponse resolveAccountResponse) {
            final zzme com_google_android_gms_internal_zzme = (zzme) this.zzafX.get();
            if (com_google_android_gms_internal_zzme != null) {
                com_google_android_gms_internal_zzme.zzafD.zza(new zza(this, com_google_android_gms_internal_zzme) {
                    final /* synthetic */ zzb zzagc;

                    public void zzpc() {
                        com_google_android_gms_internal_zzme.zza(resolveAccountResponse);
                    }
                });
            }
        }
    }

    private static class zza extends com.google.android.gms.signin.internal.zzb {
        private final WeakReference<zzme> zzafX;

        zza(zzme com_google_android_gms_internal_zzme) {
            this.zzafX = new WeakReference(com_google_android_gms_internal_zzme);
        }

        public void zza(final ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
            final zzme com_google_android_gms_internal_zzme = (zzme) this.zzafX.get();
            if (com_google_android_gms_internal_zzme != null) {
                com_google_android_gms_internal_zzme.zzafD.zza(new zza(this, com_google_android_gms_internal_zzme) {
                    final /* synthetic */ zza zzaga;

                    public void zzpc() {
                        com_google_android_gms_internal_zzme.zzf(connectionResult);
                    }
                });
            }
        }
    }

    public zzme(zzmi com_google_android_gms_internal_zzmi, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, Map<Api<?>, Integer> map, GoogleApiAvailability googleApiAvailability, com.google.android.gms.common.api.Api.zza<? extends zzsc, zzsd> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd, Lock lock, Context context) {
        this.zzafD = com_google_android_gms_internal_zzmi;
        this.zzafT = com_google_android_gms_common_internal_zzf;
        this.zzafU = map;
        this.zzaeL = googleApiAvailability;
        this.zzaeM = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd;
        this.zzafz = lock;
        this.mContext = context;
    }

    private void zzZ(boolean z) {
        if (this.zzafM != null) {
            if (this.zzafM.isConnected() && z) {
                this.zzafM.zzDL();
            }
            this.zzafM.disconnect();
            this.zzafQ = null;
        }
    }

    private void zza(ResolveAccountResponse resolveAccountResponse) {
        if (zzbA(0)) {
            ConnectionResult zzqI = resolveAccountResponse.zzqI();
            if (zzqI.isSuccess()) {
                this.zzafQ = resolveAccountResponse.zzqH();
                this.zzafP = true;
                this.zzafR = resolveAccountResponse.zzqJ();
                this.zzafS = resolveAccountResponse.zzqK();
                zzpe();
            } else if (zzh(zzqI)) {
                zzpj();
                zzpe();
            } else {
                zzi(zzqI);
            }
        }
    }

    private boolean zza(int i, int i2, ConnectionResult connectionResult) {
        return (i2 != 1 || zzg(connectionResult)) ? this.zzafF == null || i < this.zzafG : false;
    }

    private void zzb(ConnectionResult connectionResult, Api<?> api, int i) {
        if (i != 2) {
            int priority = api.zzoy().getPriority();
            if (zza(priority, i, connectionResult)) {
                this.zzafF = connectionResult;
                this.zzafG = priority;
            }
        }
        this.zzafD.zzagJ.put(api.zzoA(), connectionResult);
    }

    private boolean zzbA(int i) {
        if (this.zzafH == i) {
            return true;
        }
        Log.i("GoogleApiClientConnecting", this.zzafD.zzafp.zzpt());
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + zzbB(this.zzafH) + " but received callback for step " + zzbB(i), new Exception());
        zzi(new ConnectionResult(8, null));
        return false;
    }

    private String zzbB(int i) {
        switch (i) {
            case 0:
                return "STEP_GETTING_SERVICE_BINDINGS";
            case 1:
                return "STEP_VALIDATING_ACCOUNT";
            case 2:
                return "STEP_AUTHENTICATING";
            case 3:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void zzf(ConnectionResult connectionResult) {
        if (!zzbA(2)) {
            return;
        }
        if (connectionResult.isSuccess()) {
            zzph();
        } else if (zzh(connectionResult)) {
            zzpj();
            zzph();
        } else {
            zzi(connectionResult);
        }
    }

    private boolean zzg(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.zzaeL.zzbu(connectionResult.getErrorCode()) != null;
    }

    private boolean zzh(ConnectionResult connectionResult) {
        return this.zzafN != 2 ? this.zzafN == 1 && !connectionResult.hasResolution() : true;
    }

    private void zzi(ConnectionResult connectionResult) {
        zzpk();
        zzZ(!connectionResult.hasResolution());
        this.zzafD.zzj(connectionResult);
        if (!this.zzafI) {
            this.zzafD.zzagN.zze(connectionResult);
        }
        this.zzafI = false;
    }

    private boolean zzpd() {
        this.zzafJ--;
        if (this.zzafJ > 0) {
            return false;
        }
        if (this.zzafJ < 0) {
            Log.i("GoogleApiClientConnecting", this.zzafD.zzafp.zzpt());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zzi(new ConnectionResult(8, null));
            return false;
        } else if (this.zzafF == null) {
            return true;
        } else {
            this.zzafD.zzagM = this.zzafG;
            zzi(this.zzafF);
            return false;
        }
    }

    private void zzpe() {
        if (this.zzafJ == 0) {
            if (!this.zzafO) {
                zzph();
            } else if (this.zzafP) {
                zzpf();
            }
        }
    }

    private void zzpf() {
        ArrayList arrayList = new ArrayList();
        this.zzafH = 1;
        this.zzafJ = this.zzafD.zzagp.size();
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.zzafD.zzagp.keySet()) {
            if (!this.zzafD.zzagJ.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                arrayList.add(this.zzafD.zzagp.get(com_google_android_gms_common_api_Api_zzc));
            } else if (zzpd()) {
                zzpg();
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzafV.add(zzmj.zzpz().submit(new zzh(this, arrayList)));
        }
    }

    private void zzpg() {
        this.zzafH = 2;
        this.zzafD.zzafp.zzagq = zzpl();
        this.zzafV.add(zzmj.zzpz().submit(new zzc()));
    }

    private void zzph() {
        ArrayList arrayList = new ArrayList();
        this.zzafH = 3;
        this.zzafJ = this.zzafD.zzagp.size();
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.zzafD.zzagp.keySet()) {
            if (!this.zzafD.zzagJ.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                arrayList.add(this.zzafD.zzagp.get(com_google_android_gms_common_api_Api_zzc));
            } else if (zzpd()) {
                zzpi();
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzafV.add(zzmj.zzpz().submit(new zzf(this, arrayList)));
        }
    }

    private void zzpi() {
        this.zzafD.zzpx();
        zzmj.zzpz().execute(new C03591(this));
        if (this.zzafM != null) {
            if (this.zzafR) {
                this.zzafM.zza(this.zzafQ, this.zzafS);
            }
            zzZ(false);
        }
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.zzafD.zzagJ.keySet()) {
            ((com.google.android.gms.common.api.Api.zzb) this.zzafD.zzagp.get(com_google_android_gms_common_api_Api_zzc)).disconnect();
        }
        this.zzafD.zzagN.zzi(this.zzafK.isEmpty() ? null : this.zzafK);
        if (this.zzafI) {
            this.zzafI = false;
            disconnect();
        }
    }

    private void zzpj() {
        this.zzafO = false;
        this.zzafD.zzafp.zzagq = Collections.emptySet();
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.zzafL) {
            if (!this.zzafD.zzagJ.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                this.zzafD.zzagJ.put(com_google_android_gms_common_api_Api_zzc, new ConnectionResult(17, null));
            }
        }
    }

    private void zzpk() {
        Iterator it = this.zzafV.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.zzafV.clear();
    }

    private Set<Scope> zzpl() {
        if (this.zzafT == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.zzafT.zzqa());
        Map zzqc = this.zzafT.zzqc();
        for (Api api : zzqc.keySet()) {
            if (!this.zzafD.zzagJ.containsKey(api.zzoA())) {
                hashSet.addAll(((com.google.android.gms.common.internal.zzf.zza) zzqc.get(api)).zzVH);
            }
        }
        return hashSet;
    }

    public void begin() {
        this.zzafD.zzagJ.clear();
        this.zzafI = false;
        this.zzafO = false;
        this.zzafF = null;
        this.zzafH = 0;
        this.zzafN = 2;
        this.zzafP = false;
        this.zzafR = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (Api api : this.zzafU.keySet()) {
            com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb = (com.google.android.gms.common.api.Api.zzb) this.zzafD.zzagp.get(api.zzoA());
            int intValue = ((Integer) this.zzafU.get(api)).intValue();
            int i2 = (api.zzoy().getPriority() == 1 ? 1 : 0) | i;
            if (com_google_android_gms_common_api_Api_zzb.zzmn()) {
                this.zzafO = true;
                if (intValue < this.zzafN) {
                    this.zzafN = intValue;
                }
                if (intValue != 0) {
                    this.zzafL.add(api.zzoA());
                }
            }
            hashMap.put(com_google_android_gms_common_api_Api_zzb, new zzd(this, api, intValue));
            i = i2;
        }
        if (i != 0) {
            this.zzafO = false;
        }
        if (this.zzafO) {
            this.zzafT.zza(Integer.valueOf(this.zzafD.zzafp.getSessionId()));
            ConnectionCallbacks com_google_android_gms_internal_zzme_zzg = new zzg();
            this.zzafM = (zzsc) this.zzaeM.zza(this.mContext, this.zzafD.zzafp.getLooper(), this.zzafT, this.zzafT.zzqg(), com_google_android_gms_internal_zzme_zzg, com_google_android_gms_internal_zzme_zzg);
        }
        this.zzafJ = this.zzafD.zzagp.size();
        this.zzafV.add(zzmj.zzpz().submit(new zze(this, hashMap)));
    }

    public void connect() {
        this.zzafI = false;
    }

    public void disconnect() {
        Iterator it = this.zzafD.zzafp.zzagj.iterator();
        while (it.hasNext()) {
            zze com_google_android_gms_internal_zzmg_zze = (zze) it.next();
            if (com_google_android_gms_internal_zzmg_zze.zzoQ() != 1) {
                com_google_android_gms_internal_zzmg_zze.cancel();
                it.remove();
            }
        }
        if (this.zzafF != null || this.zzafD.zzafp.zzagj.isEmpty()) {
            zzpk();
            zzZ(true);
            this.zzafD.zzj(null);
            return;
        }
        this.zzafI = true;
    }

    public void onConnected(Bundle connectionHint) {
        if (zzbA(3)) {
            if (connectionHint != null) {
                this.zzafK.putAll(connectionHint);
            }
            if (zzpd()) {
                zzpi();
            }
        }
    }

    public void onConnectionSuspended(int cause) {
        zzi(new ConnectionResult(8, null));
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.internal.zzlx.zza<R, A>> T zza(T t) {
        this.zzafD.zzafp.zzagj.add(t);
        return t;
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        if (zzbA(3)) {
            zzb(connectionResult, api, i);
            if (zzpd()) {
                zzpi();
            }
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.internal.zzlx.zza<? extends Result, A>> T zzb(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
