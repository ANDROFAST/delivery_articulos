package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import java.util.Map;

@zzha
public class zzei {
    private final Context mContext;
    private final String zzAg;
    private zzb<zzbb> zzAh;
    private zzb<zzbb> zzAi;
    private zze zzAj;
    private int zzAk;
    private final VersionInfoParcel zzpI;
    private final Object zzpK;

    static class zza {
        static int zzAu = 60000;
        static int zzAv = StatusCodes.AUTH_DISABLED;
    }

    public interface zzb<T> {
        void zzc(T t);
    }

    public static class zzc<T> implements zzb<T> {
        public void zzc(T t) {
        }
    }

    public static class zzd extends zzjh<zzbe> {
        private final zze zzAw;
        private boolean zzAx;
        private final Object zzpK = new Object();

        class C07111 implements com.google.android.gms.internal.zzjg.zzc<zzbe> {
            final /* synthetic */ zzd zzAy;

            C07111(zzd com_google_android_gms_internal_zzei_zzd) {
                this.zzAy = com_google_android_gms_internal_zzei_zzd;
            }

            public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                com.google.android.gms.ads.internal.util.client.zzb.m7v("Ending javascript session.");
                ((zzbf) com_google_android_gms_internal_zzbe).zzcs();
            }

            public /* synthetic */ void zzc(Object obj) {
                zzb((zzbe) obj);
            }
        }

        class C07122 implements com.google.android.gms.internal.zzjg.zzc<zzbe> {
            final /* synthetic */ zzd zzAy;

            C07122(zzd com_google_android_gms_internal_zzei_zzd) {
                this.zzAy = com_google_android_gms_internal_zzei_zzd;
            }

            public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                com.google.android.gms.ads.internal.util.client.zzb.m7v("Releasing engine reference.");
                this.zzAy.zzAw.zzek();
            }

            public /* synthetic */ void zzc(Object obj) {
                zzb((zzbe) obj);
            }
        }

        class C07133 implements com.google.android.gms.internal.zzjg.zza {
            final /* synthetic */ zzd zzAy;

            C07133(zzd com_google_android_gms_internal_zzei_zzd) {
                this.zzAy = com_google_android_gms_internal_zzei_zzd;
            }

            public void run() {
                this.zzAy.zzAw.zzek();
            }
        }

        public zzd(zze com_google_android_gms_internal_zzei_zze) {
            this.zzAw = com_google_android_gms_internal_zzei_zze;
        }

        public void release() {
            synchronized (this.zzpK) {
                if (this.zzAx) {
                    return;
                }
                this.zzAx = true;
                zza(new C07111(this), new com.google.android.gms.internal.zzjg.zzb());
                zza(new C07122(this), new C07133(this));
            }
        }
    }

    public static class zze extends zzjh<zzbb> {
        private int zzAA;
        private zzb<zzbb> zzAi;
        private boolean zzAz;
        private final Object zzpK = new Object();

        class C07163 implements com.google.android.gms.internal.zzjg.zzc<zzbb> {
            final /* synthetic */ zze zzAC;

            C07163(zze com_google_android_gms_internal_zzei_zze) {
                this.zzAC = com_google_android_gms_internal_zzei_zze;
            }

            public void zza(final zzbb com_google_android_gms_internal_zzbb) {
                zzip.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ C07163 zzAD;

                    public void run() {
                        this.zzAD.zzAC.zzAi.zzc(com_google_android_gms_internal_zzbb);
                        com_google_android_gms_internal_zzbb.destroy();
                    }
                });
            }

            public /* synthetic */ void zzc(Object obj) {
                zza((zzbb) obj);
            }
        }

        public zze(zzb<zzbb> com_google_android_gms_internal_zzei_zzb_com_google_android_gms_internal_zzbb) {
            this.zzAi = com_google_android_gms_internal_zzei_zzb_com_google_android_gms_internal_zzbb;
            this.zzAz = false;
            this.zzAA = 0;
        }

        public zzd zzej() {
            final zzd com_google_android_gms_internal_zzei_zzd = new zzd(this);
            synchronized (this.zzpK) {
                zza(new com.google.android.gms.internal.zzjg.zzc<zzbb>(this) {
                    final /* synthetic */ zze zzAC;

                    public void zza(zzbb com_google_android_gms_internal_zzbb) {
                        com.google.android.gms.ads.internal.util.client.zzb.m7v("Getting a new session for JS Engine.");
                        com_google_android_gms_internal_zzei_zzd.zzg(com_google_android_gms_internal_zzbb.zzcq());
                    }

                    public /* synthetic */ void zzc(Object obj) {
                        zza((zzbb) obj);
                    }
                }, new com.google.android.gms.internal.zzjg.zza(this) {
                    final /* synthetic */ zze zzAC;

                    public void run() {
                        com.google.android.gms.ads.internal.util.client.zzb.m7v("Rejecting reference for JS Engine.");
                        com_google_android_gms_internal_zzei_zzd.reject();
                    }
                });
                zzx.zzaa(this.zzAA >= 0);
                this.zzAA++;
            }
            return com_google_android_gms_internal_zzei_zzd;
        }

        protected void zzek() {
            boolean z = true;
            synchronized (this.zzpK) {
                if (this.zzAA < 1) {
                    z = false;
                }
                zzx.zzaa(z);
                com.google.android.gms.ads.internal.util.client.zzb.m7v("Releasing 1 reference for JS Engine");
                this.zzAA--;
                zzem();
            }
        }

        public void zzel() {
            boolean z = true;
            synchronized (this.zzpK) {
                if (this.zzAA < 0) {
                    z = false;
                }
                zzx.zzaa(z);
                com.google.android.gms.ads.internal.util.client.zzb.m7v("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.zzAz = true;
                zzem();
            }
        }

        protected void zzem() {
            synchronized (this.zzpK) {
                zzx.zzaa(this.zzAA >= 0);
                if (this.zzAz && this.zzAA == 0) {
                    com.google.android.gms.ads.internal.util.client.zzb.m7v("No reference is left (including root). Cleaning up engine.");
                    zza(new C07163(this), new com.google.android.gms.internal.zzjg.zzb());
                } else {
                    com.google.android.gms.ads.internal.util.client.zzb.m7v("There are still references to the engine. Not destroying.");
                }
            }
        }
    }

    public zzei(Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.zzpK = new Object();
        this.zzAk = 1;
        this.zzAg = str;
        this.mContext = context.getApplicationContext();
        this.zzpI = versionInfoParcel;
        this.zzAh = new zzc();
        this.zzAi = new zzc();
    }

    public zzei(Context context, VersionInfoParcel versionInfoParcel, String str, zzb<zzbb> com_google_android_gms_internal_zzei_zzb_com_google_android_gms_internal_zzbb, zzb<zzbb> com_google_android_gms_internal_zzei_zzb_com_google_android_gms_internal_zzbb2) {
        this(context, versionInfoParcel, str);
        this.zzAh = com_google_android_gms_internal_zzei_zzb_com_google_android_gms_internal_zzbb;
        this.zzAi = com_google_android_gms_internal_zzei_zzb_com_google_android_gms_internal_zzbb2;
    }

    private zze zzeg() {
        final zze com_google_android_gms_internal_zzei_zze = new zze(this.zzAi);
        zzip.runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzei zzAm;

            public void run() {
                final zzbb zza = this.zzAm.zza(this.zzAm.mContext, this.zzAm.zzpI);
                zza.zza(new com.google.android.gms.internal.zzbb.zza(this) {
                    final /* synthetic */ C02911 zzAo;

                    class C02881 implements Runnable {
                        final /* synthetic */ C07061 zzAp;

                        class C02871 implements Runnable {
                            final /* synthetic */ C02881 zzAq;

                            C02871(C02881 c02881) {
                                this.zzAq = c02881;
                            }

                            public void run() {
                                zza.destroy();
                            }
                        }

                        C02881(C07061 c07061) {
                            this.zzAp = c07061;
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                            r3 = this;
                            r0 = r3.zzAp;
                            r0 = r0.zzAo;
                            r0 = r0.zzAm;
                            r1 = r0.zzpK;
                            monitor-enter(r1);
                            r0 = r3.zzAp;	 Catch:{ all -> 0x003f }
                            r0 = r0.zzAo;	 Catch:{ all -> 0x003f }
                            r0 = r0;	 Catch:{ all -> 0x003f }
                            r0 = r0.getStatus();	 Catch:{ all -> 0x003f }
                            r2 = -1;
                            if (r0 == r2) goto L_0x0025;
                        L_0x0018:
                            r0 = r3.zzAp;	 Catch:{ all -> 0x003f }
                            r0 = r0.zzAo;	 Catch:{ all -> 0x003f }
                            r0 = r0;	 Catch:{ all -> 0x003f }
                            r0 = r0.getStatus();	 Catch:{ all -> 0x003f }
                            r2 = 1;
                            if (r0 != r2) goto L_0x0027;
                        L_0x0025:
                            monitor-exit(r1);	 Catch:{ all -> 0x003f }
                        L_0x0026:
                            return;
                        L_0x0027:
                            r0 = r3.zzAp;	 Catch:{ all -> 0x003f }
                            r0 = r0.zzAo;	 Catch:{ all -> 0x003f }
                            r0 = r0;	 Catch:{ all -> 0x003f }
                            r0.reject();	 Catch:{ all -> 0x003f }
                            r0 = new com.google.android.gms.internal.zzei$1$1$1$1;	 Catch:{ all -> 0x003f }
                            r0.<init>(r3);	 Catch:{ all -> 0x003f }
                            com.google.android.gms.internal.zzip.runOnUiThread(r0);	 Catch:{ all -> 0x003f }
                            r0 = "Could not receive loaded message in a timely manner. Rejecting.";
                            com.google.android.gms.ads.internal.util.client.zzb.m7v(r0);	 Catch:{ all -> 0x003f }
                            monitor-exit(r1);	 Catch:{ all -> 0x003f }
                            goto L_0x0026;
                        L_0x003f:
                            r0 = move-exception;
                            monitor-exit(r1);	 Catch:{ all -> 0x003f }
                            throw r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzei.1.1.1.run():void");
                        }
                    }

                    public void zzcr() {
                        zzip.zzKO.postDelayed(new C02881(this), (long) zza.zzAv);
                    }
                });
                zza.zza("/jsLoaded", new zzdl(this) {
                    final /* synthetic */ C02911 zzAo;

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void zza(com.google.android.gms.internal.zzjn r4, java.util.Map<java.lang.String, java.lang.String> r5) {
                        /*
                        r3 = this;
                        r0 = r3.zzAo;
                        r0 = r0.zzAm;
                        r1 = r0.zzpK;
                        monitor-enter(r1);
                        r0 = r3.zzAo;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0051 }
                        r2 = -1;
                        if (r0 == r2) goto L_0x001f;
                    L_0x0014:
                        r0 = r3.zzAo;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0051 }
                        r2 = 1;
                        if (r0 != r2) goto L_0x0021;
                    L_0x001f:
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                    L_0x0020:
                        return;
                    L_0x0021:
                        r0 = r3.zzAo;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzAm;	 Catch:{ all -> 0x0051 }
                        r2 = 0;
                        r0.zzAk = r2;	 Catch:{ all -> 0x0051 }
                        r0 = r3.zzAo;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzAm;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzAh;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.zzc(r2);	 Catch:{ all -> 0x0051 }
                        r0 = r3.zzAo;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.zzg(r2);	 Catch:{ all -> 0x0051 }
                        r0 = r3.zzAo;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzAm;	 Catch:{ all -> 0x0051 }
                        r2 = r3.zzAo;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.zzAj = r2;	 Catch:{ all -> 0x0051 }
                        r0 = "Successfully loaded JS Engine.";
                        com.google.android.gms.ads.internal.util.client.zzb.m7v(r0);	 Catch:{ all -> 0x0051 }
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                        goto L_0x0020;
                    L_0x0051:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzei.1.2.zza(com.google.android.gms.internal.zzjn, java.util.Map):void");
                    }
                });
                final zziy com_google_android_gms_internal_zziy = new zziy();
                zzdl c07083 = new zzdl(this) {
                    final /* synthetic */ C02911 zzAo;

                    public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
                        synchronized (this.zzAo.zzAm.zzpK) {
                            com.google.android.gms.ads.internal.util.client.zzb.zzaG("JS Engine is requesting an update");
                            if (this.zzAo.zzAm.zzAk == 0) {
                                com.google.android.gms.ads.internal.util.client.zzb.zzaG("Starting reload.");
                                this.zzAo.zzAm.zzAk = 2;
                                this.zzAo.zzAm.zzeh();
                            }
                            zza.zzb("/requestReload", (zzdl) com_google_android_gms_internal_zziy.get());
                        }
                    }
                };
                com_google_android_gms_internal_zziy.set(c07083);
                zza.zza("/requestReload", c07083);
                if (this.zzAm.zzAg.endsWith(".js")) {
                    zza.zzs(this.zzAm.zzAg);
                } else if (this.zzAm.zzAg.startsWith("<html>")) {
                    zza.zzu(this.zzAm.zzAg);
                } else {
                    zza.zzt(this.zzAm.zzAg);
                }
                zzip.zzKO.postDelayed(new Runnable(this) {
                    final /* synthetic */ C02911 zzAo;

                    class C02891 implements Runnable {
                        final /* synthetic */ C02904 zzAs;

                        C02891(C02904 c02904) {
                            this.zzAs = c02904;
                        }

                        public void run() {
                            zza.destroy();
                        }
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                        r3 = this;
                        r0 = r3.zzAo;
                        r0 = r0.zzAm;
                        r1 = r0.zzpK;
                        monitor-enter(r1);
                        r0 = r3.zzAo;	 Catch:{ all -> 0x0037 }
                        r0 = r0;	 Catch:{ all -> 0x0037 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0037 }
                        r2 = -1;
                        if (r0 == r2) goto L_0x001f;
                    L_0x0014:
                        r0 = r3.zzAo;	 Catch:{ all -> 0x0037 }
                        r0 = r0;	 Catch:{ all -> 0x0037 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0037 }
                        r2 = 1;
                        if (r0 != r2) goto L_0x0021;
                    L_0x001f:
                        monitor-exit(r1);	 Catch:{ all -> 0x0037 }
                    L_0x0020:
                        return;
                    L_0x0021:
                        r0 = r3.zzAo;	 Catch:{ all -> 0x0037 }
                        r0 = r0;	 Catch:{ all -> 0x0037 }
                        r0.reject();	 Catch:{ all -> 0x0037 }
                        r0 = new com.google.android.gms.internal.zzei$1$4$1;	 Catch:{ all -> 0x0037 }
                        r0.<init>(r3);	 Catch:{ all -> 0x0037 }
                        com.google.android.gms.internal.zzip.runOnUiThread(r0);	 Catch:{ all -> 0x0037 }
                        r0 = "Could not receive loaded message in a timely manner. Rejecting.";
                        com.google.android.gms.ads.internal.util.client.zzb.m7v(r0);	 Catch:{ all -> 0x0037 }
                        monitor-exit(r1);	 Catch:{ all -> 0x0037 }
                        goto L_0x0020;
                    L_0x0037:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x0037 }
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzei.1.4.run():void");
                    }
                }, (long) zza.zzAu);
            }
        });
        return com_google_android_gms_internal_zzei_zze;
    }

    protected zzbb zza(Context context, VersionInfoParcel versionInfoParcel) {
        return new zzbd(context, versionInfoParcel, null);
    }

    protected zze zzeh() {
        final zze zzeg = zzeg();
        zzeg.zza(new com.google.android.gms.internal.zzjg.zzc<zzbb>(this) {
            final /* synthetic */ zzei zzAm;

            public void zza(zzbb com_google_android_gms_internal_zzbb) {
                synchronized (this.zzAm.zzpK) {
                    this.zzAm.zzAk = 0;
                    if (!(this.zzAm.zzAj == null || zzeg == this.zzAm.zzAj)) {
                        com.google.android.gms.ads.internal.util.client.zzb.m7v("New JS engine is loaded, marking previous one as destroyable.");
                        this.zzAm.zzAj.zzel();
                    }
                    this.zzAm.zzAj = zzeg;
                }
            }

            public /* synthetic */ void zzc(Object obj) {
                zza((zzbb) obj);
            }
        }, new com.google.android.gms.internal.zzjg.zza(this) {
            final /* synthetic */ zzei zzAm;

            public void run() {
                synchronized (this.zzAm.zzpK) {
                    this.zzAm.zzAk = 1;
                    com.google.android.gms.ads.internal.util.client.zzb.m7v("Failed loading new engine. Marking new engine destroyable.");
                    zzeg.zzel();
                }
            }
        });
        return zzeg;
    }

    public zzd zzei() {
        zzd zzej;
        synchronized (this.zzpK) {
            if (this.zzAj == null || this.zzAj.getStatus() == -1) {
                this.zzAk = 2;
                this.zzAj = zzeh();
                zzej = this.zzAj.zzej();
            } else if (this.zzAk == 0) {
                zzej = this.zzAj.zzej();
            } else if (this.zzAk == 1) {
                this.zzAk = 2;
                zzeh();
                zzej = this.zzAj.zzej();
            } else if (this.zzAk == 2) {
                zzej = this.zzAj.zzej();
            } else {
                zzej = this.zzAj.zzej();
            }
        }
        return zzej;
    }
}
