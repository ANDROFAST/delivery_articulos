package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import java.util.LinkedList;
import java.util.List;

@zzha
class zzeb {
    private final List<zza> zzpw = new LinkedList();

    interface zza {
        void zzb(zzec com_google_android_gms_internal_zzec) throws RemoteException;
    }

    class C11371 extends com.google.android.gms.ads.internal.client.zzo.zza {
        final /* synthetic */ zzeb zzzA;

        class C06971 implements zza {
            final /* synthetic */ C11371 zzzB;

            C06971(C11371 c11371) {
                this.zzzB = c11371;
            }

            public void zzb(zzec com_google_android_gms_internal_zzec) throws RemoteException {
                if (com_google_android_gms_internal_zzec.zzpz != null) {
                    com_google_android_gms_internal_zzec.zzpz.onAdClosed();
                }
                zzp.zzbI().zzdX();
            }
        }

        class C06993 implements zza {
            final /* synthetic */ C11371 zzzB;

            C06993(C11371 c11371) {
                this.zzzB = c11371;
            }

            public void zzb(zzec com_google_android_gms_internal_zzec) throws RemoteException {
                if (com_google_android_gms_internal_zzec.zzpz != null) {
                    com_google_android_gms_internal_zzec.zzpz.onAdLeftApplication();
                }
            }
        }

        class C07004 implements zza {
            final /* synthetic */ C11371 zzzB;

            C07004(C11371 c11371) {
                this.zzzB = c11371;
            }

            public void zzb(zzec com_google_android_gms_internal_zzec) throws RemoteException {
                if (com_google_android_gms_internal_zzec.zzpz != null) {
                    com_google_android_gms_internal_zzec.zzpz.onAdLoaded();
                }
            }
        }

        class C07015 implements zza {
            final /* synthetic */ C11371 zzzB;

            C07015(C11371 c11371) {
                this.zzzB = c11371;
            }

            public void zzb(zzec com_google_android_gms_internal_zzec) throws RemoteException {
                if (com_google_android_gms_internal_zzec.zzpz != null) {
                    com_google_android_gms_internal_zzec.zzpz.onAdOpened();
                }
            }
        }

        C11371(zzeb com_google_android_gms_internal_zzeb) {
            this.zzzA = com_google_android_gms_internal_zzeb;
        }

        public void onAdClosed() throws RemoteException {
            this.zzzA.zzpw.add(new C06971(this));
        }

        public void onAdFailedToLoad(final int errorCode) throws RemoteException {
            this.zzzA.zzpw.add(new zza(this) {
                final /* synthetic */ C11371 zzzB;

                public void zzb(zzec com_google_android_gms_internal_zzec) throws RemoteException {
                    if (com_google_android_gms_internal_zzec.zzpz != null) {
                        com_google_android_gms_internal_zzec.zzpz.onAdFailedToLoad(errorCode);
                    }
                }
            });
            zzb.m7v("Pooled interstitial failed to load.");
        }

        public void onAdLeftApplication() throws RemoteException {
            this.zzzA.zzpw.add(new C06993(this));
        }

        public void onAdLoaded() throws RemoteException {
            this.zzzA.zzpw.add(new C07004(this));
            zzb.m7v("Pooled interstitial loaded.");
        }

        public void onAdOpened() throws RemoteException {
            this.zzzA.zzpw.add(new C07015(this));
        }
    }

    class C11382 extends com.google.android.gms.ads.internal.client.zzu.zza {
        final /* synthetic */ zzeb zzzA;

        C11382(zzeb com_google_android_gms_internal_zzeb) {
            this.zzzA = com_google_android_gms_internal_zzeb;
        }

        public void onAppEvent(final String name, final String info) throws RemoteException {
            this.zzzA.zzpw.add(new zza(this) {
                final /* synthetic */ C11382 zzzE;

                public void zzb(zzec com_google_android_gms_internal_zzec) throws RemoteException {
                    if (com_google_android_gms_internal_zzec.zzzM != null) {
                        com_google_android_gms_internal_zzec.zzzM.onAppEvent(name, info);
                    }
                }
            });
        }
    }

    class C11393 extends com.google.android.gms.internal.zzgc.zza {
        final /* synthetic */ zzeb zzzA;

        C11393(zzeb com_google_android_gms_internal_zzeb) {
            this.zzzA = com_google_android_gms_internal_zzeb;
        }

        public void zza(final zzgb com_google_android_gms_internal_zzgb) throws RemoteException {
            this.zzzA.zzpw.add(new zza(this) {
                final /* synthetic */ C11393 zzzG;

                public void zzb(zzec com_google_android_gms_internal_zzec) throws RemoteException {
                    if (com_google_android_gms_internal_zzec.zzzN != null) {
                        com_google_android_gms_internal_zzec.zzzN.zza(com_google_android_gms_internal_zzgb);
                    }
                }
            });
        }
    }

    class C11404 extends com.google.android.gms.internal.zzcl.zza {
        final /* synthetic */ zzeb zzzA;

        C11404(zzeb com_google_android_gms_internal_zzeb) {
            this.zzzA = com_google_android_gms_internal_zzeb;
        }

        public void zza(final zzck com_google_android_gms_internal_zzck) throws RemoteException {
            this.zzzA.zzpw.add(new zza(this) {
                final /* synthetic */ C11404 zzzI;

                public void zzb(zzec com_google_android_gms_internal_zzec) throws RemoteException {
                    if (com_google_android_gms_internal_zzec.zzzO != null) {
                        com_google_android_gms_internal_zzec.zzzO.zza(com_google_android_gms_internal_zzck);
                    }
                }
            });
        }
    }

    class C11415 extends com.google.android.gms.ads.internal.client.zzn.zza {
        final /* synthetic */ zzeb zzzA;

        class C07051 implements zza {
            final /* synthetic */ C11415 zzzJ;

            C07051(C11415 c11415) {
                this.zzzJ = c11415;
            }

            public void zzb(zzec com_google_android_gms_internal_zzec) throws RemoteException {
                if (com_google_android_gms_internal_zzec.zzzP != null) {
                    com_google_android_gms_internal_zzec.zzzP.onAdClicked();
                }
            }
        }

        C11415(zzeb com_google_android_gms_internal_zzeb) {
            this.zzzA = com_google_android_gms_internal_zzeb;
        }

        public void onAdClicked() throws RemoteException {
            this.zzzA.zzpw.add(new C07051(this));
        }
    }

    zzeb() {
    }

    void zza(final zzec com_google_android_gms_internal_zzec) {
        Handler handler = zzip.zzKO;
        for (final zza com_google_android_gms_internal_zzeb_zza : this.zzpw) {
            handler.post(new Runnable(this) {
                final /* synthetic */ zzeb zzzA;

                public void run() {
                    try {
                        com_google_android_gms_internal_zzeb_zza.zzb(com_google_android_gms_internal_zzec);
                    } catch (Throwable e) {
                        zzb.zzd("Could not propagate interstitial ad event.", e);
                    }
                }
            });
        }
    }

    void zzc(zzk com_google_android_gms_ads_internal_zzk) {
        com_google_android_gms_ads_internal_zzk.zza(new C11371(this));
        com_google_android_gms_ads_internal_zzk.zza(new C11382(this));
        com_google_android_gms_ads_internal_zzk.zza(new C11393(this));
        com_google_android_gms_ads_internal_zzk.zza(new C11404(this));
        com_google_android_gms_ads_internal_zzk.zza(new C11415(this));
    }
}
