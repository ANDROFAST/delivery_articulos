package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions> {
    private final String mName;
    private final zzc<?> zzacX;
    private final zza<?, O> zzaep;
    private final zze<?, O> zzaeq = null;
    private final zzf<?> zzaer;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public static abstract class zza<T extends zzb, O> {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public abstract T zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);

        public List<Scope> zzn(O o) {
            return Collections.emptyList();
        }
    }

    public interface zzb {
        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean isConnected();

        void zza(com.google.android.gms.common.api.GoogleApiClient.zza com_google_android_gms_common_api_GoogleApiClient_zza);

        void zza(zzp com_google_android_gms_common_internal_zzp);

        void zza(zzp com_google_android_gms_common_internal_zzp, Set<Scope> set);

        boolean zzmJ();

        Intent zzmK();

        boolean zzmn();

        IBinder zzoC();
    }

    public static final class zzc<C extends zzb> {
    }

    public interface zzd<T extends IInterface> {
        T zzW(IBinder iBinder);

        void zza(int i, T t);

        String zzgh();

        String zzgi();
    }

    public interface zze<T extends zzd, O> {
        int getPriority();

        int zzoD();

        T zzp(O o);
    }

    public static final class zzf<C extends zzd> {
    }

    public <C extends zzb> Api(String name, zza<C, O> clientBuilder, zzc<C> clientKey) {
        zzx.zzb((Object) clientBuilder, (Object) "Cannot construct an Api with a null ClientBuilder");
        zzx.zzb((Object) clientKey, (Object) "Cannot construct an Api with a null ClientKey");
        this.mName = name;
        this.zzaep = clientBuilder;
        this.zzacX = clientKey;
        this.zzaer = null;
    }

    public String getName() {
        return this.mName;
    }

    public zzc<?> zzoA() {
        zzx.zza(this.zzacX != null, (Object) "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return this.zzacX;
    }

    public boolean zzoB() {
        return this.zzaer != null;
    }

    public zza<?, O> zzoy() {
        zzx.zza(this.zzaep != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.zzaep;
    }

    public zze<?, O> zzoz() {
        zzx.zza(this.zzaeq != null, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return this.zzaeq;
    }
}
