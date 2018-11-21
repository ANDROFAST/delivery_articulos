package com.google.android.gms.internal;

import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult;
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzlo implements CastRemoteDisplayApi {
    private static final zzl zzYy = new zzl("CastRemoteDisplayApiImpl");
    private com.google.android.gms.common.api.Api.zzc<zzlp> zzacX;
    private VirtualDisplay zzacY;
    private final zzls zzacZ = new C11441(this);

    class C11441 extends com.google.android.gms.internal.zzls.zza {
        final /* synthetic */ zzlo zzada;

        C11441(zzlo com_google_android_gms_internal_zzlo) {
            this.zzada = com_google_android_gms_internal_zzlo;
        }

        public void zzbp(int i) {
            zzlo.zzYy.zzb("onRemoteDisplayEnded", new Object[0]);
            this.zzada.zzoj();
        }
    }

    private abstract class zza extends com.google.android.gms.internal.zzlq.zza {
        final /* synthetic */ zzlo zzada;

        private zza(zzlo com_google_android_gms_internal_zzlo) {
            this.zzada = com_google_android_gms_internal_zzlo;
        }

        public void onDisconnected() throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void onError(int statusCode) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void zza(int i, int i2, Surface surface) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void zzol() throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    private static final class zzc implements CastRemoteDisplaySessionResult {
        private final Status zzTA;
        private final Display zzYK;

        public zzc(Display display) {
            this.zzTA = Status.zzaeX;
            this.zzYK = display;
        }

        public zzc(Status status) {
            this.zzTA = status;
            this.zzYK = null;
        }

        public Display getPresentationDisplay() {
            return this.zzYK;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private abstract class zzb extends com.google.android.gms.internal.zzlx.zza<CastRemoteDisplaySessionResult, zzlp> {
        final /* synthetic */ zzlo zzada;

        protected final class zza extends zza {
            private final zzlp zzadc;
            final /* synthetic */ zzb zzadd;

            public zza(zzb com_google_android_gms_internal_zzlo_zzb, zzlp com_google_android_gms_internal_zzlp) {
                this.zzadd = com_google_android_gms_internal_zzlo_zzb;
                super();
                this.zzadc = com_google_android_gms_internal_zzlp;
            }

            private int zzj(int i, int i2) {
                if (i >= i2) {
                    i = i2;
                }
                return (i * 320) / 1080;
            }

            public void onError(int statusCode) throws RemoteException {
                zzlo.zzYy.zzb("onError: %d", Integer.valueOf(statusCode));
                this.zzadd.zzada.zzoj();
                this.zzadd.zzb(new zzc(Status.zzaeZ));
            }

            public void zza(int i, int i2, Surface surface) {
                zzlo.zzYy.zzb("onConnected", new Object[0]);
                DisplayManager displayManager = (DisplayManager) this.zzadc.getContext().getSystemService("display");
                if (displayManager == null) {
                    zzlo.zzYy.zzc("Unable to get the display manager", new Object[0]);
                    this.zzadd.zzb(new zzc(Status.zzaeZ));
                    return;
                }
                this.zzadd.zzada.zzoj();
                this.zzadd.zzada.zzacY = displayManager.createVirtualDisplay("private_display", i, i2, zzj(i, i2), surface, 2);
                if (this.zzadd.zzada.zzacY == null) {
                    zzlo.zzYy.zzc("Unable to create virtual display", new Object[0]);
                    this.zzadd.zzb(new zzc(Status.zzaeZ));
                } else if (this.zzadd.zzada.zzacY.getDisplay() == null) {
                    zzlo.zzYy.zzc("Virtual display does not have a display", new Object[0]);
                    this.zzadd.zzb(new zzc(Status.zzaeZ));
                } else {
                    try {
                        this.zzadc.zza(this, this.zzadd.zzada.zzacY.getDisplay().getDisplayId());
                    } catch (RemoteException e) {
                        zzlo.zzYy.zzc("Unable to provision the route's new virtual Display", new Object[0]);
                        this.zzadd.zzb(new zzc(Status.zzaeZ));
                    } catch (IllegalStateException e2) {
                        zzlo.zzYy.zzc("Unable to provision the route's new virtual Display", new Object[0]);
                        this.zzadd.zzb(new zzc(Status.zzaeZ));
                    }
                }
            }

            public void zzol() {
                zzlo.zzYy.zzb("onConnectedWithDisplay", new Object[0]);
                Display display = this.zzadd.zzada.zzacY.getDisplay();
                if (display != null) {
                    this.zzadd.zzb(new zzc(display));
                    return;
                }
                zzlo.zzYy.zzc("Virtual display no longer has a display", new Object[0]);
                this.zzadd.zzb(new zzc(Status.zzaeZ));
            }
        }

        protected final class zzb extends zza {
            final /* synthetic */ zzb zzadd;

            protected zzb(zzb com_google_android_gms_internal_zzlo_zzb) {
                this.zzadd = com_google_android_gms_internal_zzlo_zzb;
                super();
            }

            public void onDisconnected() throws RemoteException {
                zzlo.zzYy.zzb("onDisconnected", new Object[0]);
                this.zzadd.zzada.zzoj();
                this.zzadd.zzb(new zzc(Status.zzaeX));
            }

            public void onError(int statusCode) throws RemoteException {
                zzlo.zzYy.zzb("onError: %d", Integer.valueOf(statusCode));
                this.zzadd.zzada.zzoj();
                this.zzadd.zzb(new zzc(Status.zzaeZ));
            }
        }

        public zzb(zzlo com_google_android_gms_internal_zzlo, GoogleApiClient googleApiClient) {
            this.zzada = com_google_android_gms_internal_zzlo;
            super(com_google_android_gms_internal_zzlo.zzacX, googleApiClient);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzt(status);
        }

        protected CastRemoteDisplaySessionResult zzt(Status status) {
            return new zzc(status);
        }
    }

    public zzlo(com.google.android.gms.common.api.Api.zzc<zzlp> com_google_android_gms_common_api_Api_zzc_com_google_android_gms_internal_zzlp) {
        this.zzacX = com_google_android_gms_common_api_Api_zzc_com_google_android_gms_internal_zzlp;
    }

    private void zzoj() {
        if (this.zzacY != null) {
            if (this.zzacY.getDisplay() != null) {
                zzYy.zzb("releasing virtual display: " + this.zzacY.getDisplay().getDisplayId(), new Object[0]);
            }
            this.zzacY.release();
            this.zzacY = null;
        }
    }

    public PendingResult<CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient apiClient, final String appId) {
        zzYy.zzb("startRemoteDisplay", new Object[0]);
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ zzlo zzada;

            protected void zza(zzlp com_google_android_gms_internal_zzlp) throws RemoteException {
                com_google_android_gms_internal_zzlp.zza(new zza(this, com_google_android_gms_internal_zzlp), this.zzada.zzacZ, appId);
            }
        });
    }

    public PendingResult<CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient apiClient) {
        zzYy.zzb("stopRemoteDisplay", new Object[0]);
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ zzlo zzada;

            protected void zza(zzlp com_google_android_gms_internal_zzlp) throws RemoteException {
                com_google_android_gms_internal_zzlp.zza(new zzb(this));
            }
        });
    }
}
