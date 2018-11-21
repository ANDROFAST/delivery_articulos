package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaf.zzj;
import com.google.android.gms.internal.zzly;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zzsg;

public class zzp extends zzly<ContainerHolder> {
    private final Context mContext;
    private final Looper zzaeK;
    private final String zzbcF;
    private long zzbcK;
    private final TagManager zzbcR;
    private final zzd zzbcU;
    private final zzcd zzbcV;
    private final int zzbcW;
    private zzf zzbcX;
    private zzsg zzbcY;
    private volatile zzo zzbcZ;
    private volatile boolean zzbda;
    private zzj zzbdb;
    private String zzbdc;
    private zze zzbdd;
    private zza zzbde;
    private final zznl zzqD;

    class C04271 {
    }

    interface zza {
        boolean zzb(Container container);
    }

    class C07952 implements com.google.android.gms.tagmanager.zzo.zza {
        final /* synthetic */ zzp zzbdf;

        C07952(zzp com_google_android_gms_tagmanager_zzp) {
            this.zzbdf = com_google_android_gms_tagmanager_zzp;
        }

        public String zzEh() {
            return this.zzbdf.zzEh();
        }

        public void zzEj() {
            zzbg.zzaH("Refresh ignored: container loaded as default only.");
        }

        public void zzff(String str) {
            this.zzbdf.zzff(str);
        }
    }

    private class zzb implements zzbf<com.google.android.gms.internal.zzsf.zza> {
        final /* synthetic */ zzp zzbdf;

        private zzb(zzp com_google_android_gms_tagmanager_zzp) {
            this.zzbdf = com_google_android_gms_tagmanager_zzp;
        }

        public void zzEo() {
        }

        public /* synthetic */ void zzI(Object obj) {
            zza((com.google.android.gms.internal.zzsf.zza) obj);
        }

        public void zza(com.google.android.gms.internal.zzsf.zza com_google_android_gms_internal_zzsf_zza) {
            zzj com_google_android_gms_internal_zzaf_zzj;
            if (com_google_android_gms_internal_zzsf_zza.zzbgY != null) {
                com_google_android_gms_internal_zzaf_zzj = com_google_android_gms_internal_zzsf_zza.zzbgY;
            } else {
                com.google.android.gms.internal.zzaf.zzf com_google_android_gms_internal_zzaf_zzf = com_google_android_gms_internal_zzsf_zza.zzjl;
                com_google_android_gms_internal_zzaf_zzj = new zzj();
                com_google_android_gms_internal_zzaf_zzj.zzjl = com_google_android_gms_internal_zzaf_zzf;
                com_google_android_gms_internal_zzaf_zzj.zzjk = null;
                com_google_android_gms_internal_zzaf_zzj.zzjm = com_google_android_gms_internal_zzaf_zzf.version;
            }
            this.zzbdf.zza(com_google_android_gms_internal_zzaf_zzj, com_google_android_gms_internal_zzsf_zza.zzbgX, true);
        }

        public void zza(com.google.android.gms.tagmanager.zzbf.zza com_google_android_gms_tagmanager_zzbf_zza) {
            if (!this.zzbdf.zzbda) {
                this.zzbdf.zzV(0);
            }
        }
    }

    private class zzc implements zzbf<zzj> {
        final /* synthetic */ zzp zzbdf;

        private zzc(zzp com_google_android_gms_tagmanager_zzp) {
            this.zzbdf = com_google_android_gms_tagmanager_zzp;
        }

        public void zzEo() {
        }

        public /* synthetic */ void zzI(Object obj) {
            zzb((zzj) obj);
        }

        public void zza(com.google.android.gms.tagmanager.zzbf.zza com_google_android_gms_tagmanager_zzbf_zza) {
            synchronized (this.zzbdf) {
                if (!this.zzbdf.isReady()) {
                    if (this.zzbdf.zzbcZ != null) {
                        this.zzbdf.zzb(this.zzbdf.zzbcZ);
                    } else {
                        this.zzbdf.zzb(this.zzbdf.zzbj(Status.zzafa));
                    }
                }
            }
            this.zzbdf.zzV(3600000);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void zzb(com.google.android.gms.internal.zzaf.zzj r6) {
            /*
            r5 = this;
            r1 = r5.zzbdf;
            monitor-enter(r1);
            r0 = r6.zzjl;	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x002a;
        L_0x0007:
            r0 = r5.zzbdf;	 Catch:{ all -> 0x0065 }
            r0 = r0.zzbdb;	 Catch:{ all -> 0x0065 }
            r0 = r0.zzjl;	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0020;
        L_0x0011:
            r0 = "Current resource is null; network resource is also null";
            com.google.android.gms.tagmanager.zzbg.m9e(r0);	 Catch:{ all -> 0x0065 }
            r0 = r5.zzbdf;	 Catch:{ all -> 0x0065 }
            r2 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
            r0.zzV(r2);	 Catch:{ all -> 0x0065 }
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
        L_0x001f:
            return;
        L_0x0020:
            r0 = r5.zzbdf;	 Catch:{ all -> 0x0065 }
            r0 = r0.zzbdb;	 Catch:{ all -> 0x0065 }
            r0 = r0.zzjl;	 Catch:{ all -> 0x0065 }
            r6.zzjl = r0;	 Catch:{ all -> 0x0065 }
        L_0x002a:
            r0 = r5.zzbdf;	 Catch:{ all -> 0x0065 }
            r2 = r5.zzbdf;	 Catch:{ all -> 0x0065 }
            r2 = r2.zzqD;	 Catch:{ all -> 0x0065 }
            r2 = r2.currentTimeMillis();	 Catch:{ all -> 0x0065 }
            r4 = 0;
            r0.zza(r6, r2, r4);	 Catch:{ all -> 0x0065 }
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
            r0.<init>();	 Catch:{ all -> 0x0065 }
            r2 = "setting refresh time to current time: ";
            r0 = r0.append(r2);	 Catch:{ all -> 0x0065 }
            r2 = r5.zzbdf;	 Catch:{ all -> 0x0065 }
            r2 = r2.zzbcK;	 Catch:{ all -> 0x0065 }
            r0 = r0.append(r2);	 Catch:{ all -> 0x0065 }
            r0 = r0.toString();	 Catch:{ all -> 0x0065 }
            com.google.android.gms.tagmanager.zzbg.m10v(r0);	 Catch:{ all -> 0x0065 }
            r0 = r5.zzbdf;	 Catch:{ all -> 0x0065 }
            r0 = r0.zzEn();	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0063;
        L_0x005e:
            r0 = r5.zzbdf;	 Catch:{ all -> 0x0065 }
            r0.zza(r6);	 Catch:{ all -> 0x0065 }
        L_0x0063:
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
            goto L_0x001f;
        L_0x0065:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzp.zzc.zzb(com.google.android.gms.internal.zzaf$zzj):void");
        }
    }

    private class zzd implements com.google.android.gms.tagmanager.zzo.zza {
        final /* synthetic */ zzp zzbdf;

        private zzd(zzp com_google_android_gms_tagmanager_zzp) {
            this.zzbdf = com_google_android_gms_tagmanager_zzp;
        }

        public String zzEh() {
            return this.zzbdf.zzEh();
        }

        public void zzEj() {
            if (this.zzbdf.zzbcV.zzlf()) {
                this.zzbdf.zzV(0);
            }
        }

        public void zzff(String str) {
            this.zzbdf.zzff(str);
        }
    }

    interface zze extends Releasable {
        void zza(zzbf<zzj> com_google_android_gms_tagmanager_zzbf_com_google_android_gms_internal_zzaf_zzj);

        void zzf(long j, String str);

        void zzfi(String str);
    }

    interface zzf extends Releasable {
        void zzEp();

        void zza(zzbf<com.google.android.gms.internal.zzsf.zza> com_google_android_gms_tagmanager_zzbf_com_google_android_gms_internal_zzsf_zza);

        void zzb(com.google.android.gms.internal.zzsf.zza com_google_android_gms_internal_zzsf_zza);

        com.google.android.gms.internal.zzsh.zzc zzjN(int i);
    }

    zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzf com_google_android_gms_tagmanager_zzp_zzf, zze com_google_android_gms_tagmanager_zzp_zze, zzsg com_google_android_gms_internal_zzsg, zznl com_google_android_gms_internal_zznl, zzcd com_google_android_gms_tagmanager_zzcd) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.zzbcR = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.zzaeK = looper;
        this.zzbcF = str;
        this.zzbcW = i;
        this.zzbcX = com_google_android_gms_tagmanager_zzp_zzf;
        this.zzbdd = com_google_android_gms_tagmanager_zzp_zze;
        this.zzbcY = com_google_android_gms_internal_zzsg;
        this.zzbcU = new zzd();
        this.zzbdb = new zzj();
        this.zzqD = com_google_android_gms_internal_zznl;
        this.zzbcV = com_google_android_gms_tagmanager_zzcd;
        if (zzEn()) {
            zzff(zzcb.zzEY().zzFa());
        }
    }

    public zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzs com_google_android_gms_tagmanager_zzs) {
        this(context, tagManager, looper, str, i, new zzcn(context, str), new zzcm(context, str, com_google_android_gms_tagmanager_zzs), new zzsg(context), zzno.zzrM(), new zzbe(30, 900000, 5000, "refreshing", zzno.zzrM()));
        this.zzbcY.zzfN(com_google_android_gms_tagmanager_zzs.zzEq());
    }

    private boolean zzEn() {
        zzcb zzEY = zzcb.zzEY();
        return (zzEY.zzEZ() == zza.CONTAINER || zzEY.zzEZ() == zza.CONTAINER_DEBUG) && this.zzbcF.equals(zzEY.getContainerId());
    }

    private synchronized void zzV(long j) {
        if (this.zzbdd == null) {
            zzbg.zzaH("Refresh requested, but no network load scheduler.");
        } else {
            this.zzbdd.zzf(j, this.zzbdb.zzjm);
        }
    }

    private synchronized void zza(zzj com_google_android_gms_internal_zzaf_zzj) {
        if (this.zzbcX != null) {
            com.google.android.gms.internal.zzsf.zza com_google_android_gms_internal_zzsf_zza = new com.google.android.gms.internal.zzsf.zza();
            com_google_android_gms_internal_zzsf_zza.zzbgX = this.zzbcK;
            com_google_android_gms_internal_zzsf_zza.zzjl = new com.google.android.gms.internal.zzaf.zzf();
            com_google_android_gms_internal_zzsf_zza.zzbgY = com_google_android_gms_internal_zzaf_zzj;
            this.zzbcX.zzb(com_google_android_gms_internal_zzsf_zza);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void zza(com.google.android.gms.internal.zzaf.zzj r9, long r10, boolean r12) {
        /*
        r8 = this;
        r6 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        monitor-enter(r8);
        if (r12 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r8.zzbda;	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r8);
        return;
    L_0x000c:
        r0 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x0016;
    L_0x0012:
        r0 = r8.zzbcZ;	 Catch:{ all -> 0x006a }
        if (r0 != 0) goto L_0x0016;
    L_0x0016:
        r8.zzbdb = r9;	 Catch:{ all -> 0x006a }
        r8.zzbcK = r10;	 Catch:{ all -> 0x006a }
        r0 = 0;
        r2 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r4 = r8.zzbcK;	 Catch:{ all -> 0x006a }
        r4 = r4 + r6;
        r6 = r8.zzqD;	 Catch:{ all -> 0x006a }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x006a }
        r4 = r4 - r6;
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x006a }
        r0 = java.lang.Math.max(r0, r2);	 Catch:{ all -> 0x006a }
        r8.zzV(r0);	 Catch:{ all -> 0x006a }
        r0 = new com.google.android.gms.tagmanager.Container;	 Catch:{ all -> 0x006a }
        r1 = r8.mContext;	 Catch:{ all -> 0x006a }
        r2 = r8.zzbcR;	 Catch:{ all -> 0x006a }
        r2 = r2.getDataLayer();	 Catch:{ all -> 0x006a }
        r3 = r8.zzbcF;	 Catch:{ all -> 0x006a }
        r4 = r10;
        r6 = r9;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ all -> 0x006a }
        r1 = r8.zzbcZ;	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x006d;
    L_0x0049:
        r1 = new com.google.android.gms.tagmanager.zzo;	 Catch:{ all -> 0x006a }
        r2 = r8.zzbcR;	 Catch:{ all -> 0x006a }
        r3 = r8.zzaeK;	 Catch:{ all -> 0x006a }
        r4 = r8.zzbcU;	 Catch:{ all -> 0x006a }
        r1.<init>(r2, r3, r0, r4);	 Catch:{ all -> 0x006a }
        r8.zzbcZ = r1;	 Catch:{ all -> 0x006a }
    L_0x0056:
        r1 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x000a;
    L_0x005c:
        r1 = r8.zzbde;	 Catch:{ all -> 0x006a }
        r0 = r1.zzb(r0);	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000a;
    L_0x0064:
        r0 = r8.zzbcZ;	 Catch:{ all -> 0x006a }
        r8.zzb(r0);	 Catch:{ all -> 0x006a }
        goto L_0x000a;
    L_0x006a:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x006d:
        r1 = r8.zzbcZ;	 Catch:{ all -> 0x006a }
        r1.zza(r0);	 Catch:{ all -> 0x006a }
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzp.zza(com.google.android.gms.internal.zzaf$zzj, long, boolean):void");
    }

    private void zzau(final boolean z) {
        this.zzbcX.zza(new zzb());
        this.zzbdd.zza(new zzc());
        com.google.android.gms.internal.zzsh.zzc zzjN = this.zzbcX.zzjN(this.zzbcW);
        if (zzjN != null) {
            this.zzbcZ = new zzo(this.zzbcR, this.zzaeK, new Container(this.mContext, this.zzbcR.getDataLayer(), this.zzbcF, 0, zzjN), this.zzbcU);
        }
        this.zzbde = new zza(this) {
            final /* synthetic */ zzp zzbdf;

            public boolean zzb(Container container) {
                return z ? container.getLastRefreshTime() + 43200000 >= this.zzbdf.zzqD.currentTimeMillis() : !container.isDefault();
            }
        };
        if (zzEn()) {
            this.zzbdd.zzf(0, "");
        } else {
            this.zzbcX.zzEp();
        }
    }

    synchronized String zzEh() {
        return this.zzbdc;
    }

    public void zzEk() {
        com.google.android.gms.internal.zzsh.zzc zzjN = this.zzbcX.zzjN(this.zzbcW);
        if (zzjN != null) {
            zzb(new zzo(this.zzbcR, this.zzaeK, new Container(this.mContext, this.zzbcR.getDataLayer(), this.zzbcF, 0, zzjN), new C07952(this)));
        } else {
            String str = "Default was requested, but no default container was found";
            zzbg.m9e(str);
            zzb(zzbj(new Status(10, str, null)));
        }
        this.zzbdd = null;
        this.zzbcX = null;
    }

    public void zzEl() {
        zzau(false);
    }

    public void zzEm() {
        zzau(true);
    }

    protected ContainerHolder zzbj(Status status) {
        if (this.zzbcZ != null) {
            return this.zzbcZ;
        }
        if (status == Status.zzafa) {
            zzbg.m9e("timer expired: setting result to failure");
        }
        return new zzo(status);
    }

    protected /* synthetic */ Result zzc(Status status) {
        return zzbj(status);
    }

    synchronized void zzff(String str) {
        this.zzbdc = str;
        if (this.zzbdd != null) {
            this.zzbdd.zzfi(str);
        }
    }
}
