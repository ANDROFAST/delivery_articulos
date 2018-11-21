package com.google.android.gms.internal;

import java.io.IOException;

public final class zzsz extends zzte<zzsz> {
    public zza[] zzbph;

    public static final class zza extends zzte<zza> {
        private static volatile zza[] zzbpi;
        public String name;
        public zza zzbpj;

        public static final class zza extends zzte<zza> {
            private static volatile zza[] zzbpk;
            public int type;
            public zza zzbpl;

            public static final class zza extends zzte<zza> {
                public byte[] zzbpm;
                public String zzbpn;
                public double zzbpo;
                public float zzbpp;
                public long zzbpq;
                public int zzbpr;
                public int zzbps;
                public boolean zzbpt;
                public zza[] zzbpu;
                public zza[] zzbpv;
                public String[] zzbpw;
                public long[] zzbpx;
                public float[] zzbpy;
                public long zzbpz;

                public zza() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    r0.zzHg();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.zza.<init>():void");
                }

                public boolean equals(java.lang.Object r7) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r6 = this;
                    r1 = 1;
                    r0 = 0;
                    if (r7 != r6) goto L_0x0006;
                L_0x0004:
                    r0 = r1;
                L_0x0005:
                    return r0;
                L_0x0006:
                    r2 = r7 instanceof com.google.android.gms.internal.zzsz.zza.zza.zza;
                    if (r2 == 0) goto L_0x0005;
                L_0x000a:
                    r7 = (com.google.android.gms.internal.zzsz.zza.zza.zza) r7;
                    r2 = r6.zzbpm;
                    r3 = r7.zzbpm;
                    r2 = java.util.Arrays.equals(r2, r3);
                    if (r2 == 0) goto L_0x0005;
                L_0x0016:
                    r2 = r6.zzbpn;
                    if (r2 != 0) goto L_0x00ab;
                L_0x001a:
                    r2 = r7.zzbpn;
                    if (r2 != 0) goto L_0x0005;
                L_0x001e:
                    r2 = r6.zzbpo;
                    r2 = java.lang.Double.doubleToLongBits(r2);
                    r4 = r7.zzbpo;
                    r4 = java.lang.Double.doubleToLongBits(r4);
                    r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                    if (r2 != 0) goto L_0x0005;
                L_0x002e:
                    r2 = r6.zzbpp;
                    r2 = java.lang.Float.floatToIntBits(r2);
                    r3 = r7.zzbpp;
                    r3 = java.lang.Float.floatToIntBits(r3);
                    if (r2 != r3) goto L_0x0005;
                L_0x003c:
                    r2 = r6.zzbpq;
                    r4 = r7.zzbpq;
                    r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                    if (r2 != 0) goto L_0x0005;
                L_0x0044:
                    r2 = r6.zzbpr;
                    r3 = r7.zzbpr;
                    if (r2 != r3) goto L_0x0005;
                L_0x004a:
                    r2 = r6.zzbps;
                    r3 = r7.zzbps;
                    if (r2 != r3) goto L_0x0005;
                L_0x0050:
                    r2 = r6.zzbpt;
                    r3 = r7.zzbpt;
                    if (r2 != r3) goto L_0x0005;
                L_0x0056:
                    r2 = r6.zzbpu;
                    r3 = r7.zzbpu;
                    r2 = com.google.android.gms.internal.zzti.equals(r2, r3);
                    if (r2 == 0) goto L_0x0005;
                L_0x0060:
                    r2 = r6.zzbpv;
                    r3 = r7.zzbpv;
                    r2 = com.google.android.gms.internal.zzti.equals(r2, r3);
                    if (r2 == 0) goto L_0x0005;
                L_0x006a:
                    r2 = r6.zzbpw;
                    r3 = r7.zzbpw;
                    r2 = com.google.android.gms.internal.zzti.equals(r2, r3);
                    if (r2 == 0) goto L_0x0005;
                L_0x0074:
                    r2 = r6.zzbpx;
                    r3 = r7.zzbpx;
                    r2 = com.google.android.gms.internal.zzti.equals(r2, r3);
                    if (r2 == 0) goto L_0x0005;
                L_0x007e:
                    r2 = r6.zzbpy;
                    r3 = r7.zzbpy;
                    r2 = com.google.android.gms.internal.zzti.equals(r2, r3);
                    if (r2 == 0) goto L_0x0005;
                L_0x0088:
                    r2 = r6.zzbpz;
                    r4 = r7.zzbpz;
                    r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                    if (r2 != 0) goto L_0x0005;
                L_0x0090:
                    r2 = r6.zzbpQ;
                    if (r2 == 0) goto L_0x009c;
                L_0x0094:
                    r2 = r6.zzbpQ;
                    r2 = r2.isEmpty();
                    if (r2 == 0) goto L_0x00b7;
                L_0x009c:
                    r2 = r7.zzbpQ;
                    if (r2 == 0) goto L_0x00a8;
                L_0x00a0:
                    r2 = r7.zzbpQ;
                    r2 = r2.isEmpty();
                    if (r2 == 0) goto L_0x0005;
                L_0x00a8:
                    r0 = r1;
                    goto L_0x0005;
                L_0x00ab:
                    r2 = r6.zzbpn;
                    r3 = r7.zzbpn;
                    r2 = r2.equals(r3);
                    if (r2 != 0) goto L_0x001e;
                L_0x00b5:
                    goto L_0x0005;
                L_0x00b7:
                    r0 = r6.zzbpQ;
                    r1 = r7.zzbpQ;
                    r0 = r0.equals(r1);
                    goto L_0x0005;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.zza.equals(java.lang.Object):boolean");
                }

                public int hashCode() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r1 = 0;
                    r6 = 32;
                    r0 = r7.getClass();
                    r0 = r0.getName();
                    r0 = r0.hashCode();
                    r0 = r0 + 527;
                    r0 = r0 * 31;
                    r2 = r7.zzbpm;
                    r2 = java.util.Arrays.hashCode(r2);
                    r0 = r0 + r2;
                    r2 = r0 * 31;
                    r0 = r7.zzbpn;
                    if (r0 != 0) goto L_0x009c;
                L_0x0020:
                    r0 = r1;
                L_0x0021:
                    r0 = r0 + r2;
                    r2 = r7.zzbpo;
                    r2 = java.lang.Double.doubleToLongBits(r2);
                    r0 = r0 * 31;
                    r4 = r2 >>> r6;
                    r2 = r2 ^ r4;
                    r2 = (int) r2;
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbpp;
                    r2 = java.lang.Float.floatToIntBits(r2);
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbpq;
                    r4 = r7.zzbpq;
                    r4 = r4 >>> r6;
                    r2 = r2 ^ r4;
                    r2 = (int) r2;
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbpr;
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbps;
                    r0 = r0 + r2;
                    r2 = r0 * 31;
                    r0 = r7.zzbpt;
                    if (r0 == 0) goto L_0x00a4;
                L_0x0052:
                    r0 = 1231; // 0x4cf float:1.725E-42 double:6.08E-321;
                L_0x0054:
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbpu;
                    r2 = com.google.android.gms.internal.zzti.hashCode(r2);
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbpv;
                    r2 = com.google.android.gms.internal.zzti.hashCode(r2);
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbpw;
                    r2 = com.google.android.gms.internal.zzti.hashCode(r2);
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbpx;
                    r2 = com.google.android.gms.internal.zzti.hashCode(r2);
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbpy;
                    r2 = com.google.android.gms.internal.zzti.hashCode(r2);
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbpz;
                    r4 = r7.zzbpz;
                    r4 = r4 >>> r6;
                    r2 = r2 ^ r4;
                    r2 = (int) r2;
                    r0 = r0 + r2;
                    r0 = r0 * 31;
                    r2 = r7.zzbpQ;
                    if (r2 == 0) goto L_0x009a;
                L_0x0092:
                    r2 = r7.zzbpQ;
                    r2 = r2.isEmpty();
                    if (r2 == 0) goto L_0x00a7;
                L_0x009a:
                    r0 = r0 + r1;
                    return r0;
                L_0x009c:
                    r0 = r7.zzbpn;
                    r0 = r0.hashCode();
                    goto L_0x0021;
                L_0x00a4:
                    r0 = 1237; // 0x4d5 float:1.733E-42 double:6.11E-321;
                    goto L_0x0054;
                L_0x00a7:
                    r1 = r7.zzbpQ;
                    r1 = r1.hashCode();
                    goto L_0x009a;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.zza.hashCode():int");
                }

                public /* synthetic */ com.google.android.gms.internal.zztk mergeFrom(com.google.android.gms.internal.zztc r2) throws java.io.IOException {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.zzC(r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.zza.mergeFrom(com.google.android.gms.internal.zztc):com.google.android.gms.internal.zztk");
                }

                public void writeTo(com.google.android.gms.internal.zztd r9) throws java.io.IOException {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r8 = this;
                    r6 = 0;
                    r1 = 0;
                    r0 = r8.zzbpm;
                    r2 = com.google.android.gms.internal.zztn.zzbqi;
                    r0 = java.util.Arrays.equals(r0, r2);
                    if (r0 != 0) goto L_0x0013;
                L_0x000d:
                    r0 = 1;
                    r2 = r8.zzbpm;
                    r9.zza(r0, r2);
                L_0x0013:
                    r0 = r8.zzbpn;
                    r2 = "";
                    r0 = r0.equals(r2);
                    if (r0 != 0) goto L_0x0023;
                L_0x001d:
                    r0 = 2;
                    r2 = r8.zzbpn;
                    r9.zzb(r0, r2);
                L_0x0023:
                    r2 = r8.zzbpo;
                    r2 = java.lang.Double.doubleToLongBits(r2);
                    r4 = 0;
                    r4 = java.lang.Double.doubleToLongBits(r4);
                    r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                    if (r0 == 0) goto L_0x0039;
                L_0x0033:
                    r0 = 3;
                    r2 = r8.zzbpo;
                    r9.zza(r0, r2);
                L_0x0039:
                    r0 = r8.zzbpp;
                    r0 = java.lang.Float.floatToIntBits(r0);
                    r2 = 0;
                    r2 = java.lang.Float.floatToIntBits(r2);
                    if (r0 == r2) goto L_0x004c;
                L_0x0046:
                    r0 = 4;
                    r2 = r8.zzbpp;
                    r9.zzb(r0, r2);
                L_0x004c:
                    r2 = r8.zzbpq;
                    r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
                    if (r0 == 0) goto L_0x0058;
                L_0x0052:
                    r0 = 5;
                    r2 = r8.zzbpq;
                    r9.zzb(r0, r2);
                L_0x0058:
                    r0 = r8.zzbpr;
                    if (r0 == 0) goto L_0x0062;
                L_0x005c:
                    r0 = 6;
                    r2 = r8.zzbpr;
                    r9.zzG(r0, r2);
                L_0x0062:
                    r0 = r8.zzbps;
                    if (r0 == 0) goto L_0x006c;
                L_0x0066:
                    r0 = 7;
                    r2 = r8.zzbps;
                    r9.zzH(r0, r2);
                L_0x006c:
                    r0 = r8.zzbpt;
                    if (r0 == 0) goto L_0x0077;
                L_0x0070:
                    r0 = 8;
                    r2 = r8.zzbpt;
                    r9.zzb(r0, r2);
                L_0x0077:
                    r0 = r8.zzbpu;
                    if (r0 == 0) goto L_0x0094;
                L_0x007b:
                    r0 = r8.zzbpu;
                    r0 = r0.length;
                    if (r0 <= 0) goto L_0x0094;
                L_0x0080:
                    r0 = r1;
                L_0x0081:
                    r2 = r8.zzbpu;
                    r2 = r2.length;
                    if (r0 >= r2) goto L_0x0094;
                L_0x0086:
                    r2 = r8.zzbpu;
                    r2 = r2[r0];
                    if (r2 == 0) goto L_0x0091;
                L_0x008c:
                    r3 = 9;
                    r9.zza(r3, r2);
                L_0x0091:
                    r0 = r0 + 1;
                    goto L_0x0081;
                L_0x0094:
                    r0 = r8.zzbpv;
                    if (r0 == 0) goto L_0x00b1;
                L_0x0098:
                    r0 = r8.zzbpv;
                    r0 = r0.length;
                    if (r0 <= 0) goto L_0x00b1;
                L_0x009d:
                    r0 = r1;
                L_0x009e:
                    r2 = r8.zzbpv;
                    r2 = r2.length;
                    if (r0 >= r2) goto L_0x00b1;
                L_0x00a3:
                    r2 = r8.zzbpv;
                    r2 = r2[r0];
                    if (r2 == 0) goto L_0x00ae;
                L_0x00a9:
                    r3 = 10;
                    r9.zza(r3, r2);
                L_0x00ae:
                    r0 = r0 + 1;
                    goto L_0x009e;
                L_0x00b1:
                    r0 = r8.zzbpw;
                    if (r0 == 0) goto L_0x00ce;
                L_0x00b5:
                    r0 = r8.zzbpw;
                    r0 = r0.length;
                    if (r0 <= 0) goto L_0x00ce;
                L_0x00ba:
                    r0 = r1;
                L_0x00bb:
                    r2 = r8.zzbpw;
                    r2 = r2.length;
                    if (r0 >= r2) goto L_0x00ce;
                L_0x00c0:
                    r2 = r8.zzbpw;
                    r2 = r2[r0];
                    if (r2 == 0) goto L_0x00cb;
                L_0x00c6:
                    r3 = 11;
                    r9.zzb(r3, r2);
                L_0x00cb:
                    r0 = r0 + 1;
                    goto L_0x00bb;
                L_0x00ce:
                    r0 = r8.zzbpx;
                    if (r0 == 0) goto L_0x00e9;
                L_0x00d2:
                    r0 = r8.zzbpx;
                    r0 = r0.length;
                    if (r0 <= 0) goto L_0x00e9;
                L_0x00d7:
                    r0 = r1;
                L_0x00d8:
                    r2 = r8.zzbpx;
                    r2 = r2.length;
                    if (r0 >= r2) goto L_0x00e9;
                L_0x00dd:
                    r2 = 12;
                    r3 = r8.zzbpx;
                    r4 = r3[r0];
                    r9.zzb(r2, r4);
                    r0 = r0 + 1;
                    goto L_0x00d8;
                L_0x00e9:
                    r2 = r8.zzbpz;
                    r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
                    if (r0 == 0) goto L_0x00f6;
                L_0x00ef:
                    r0 = 13;
                    r2 = r8.zzbpz;
                    r9.zzb(r0, r2);
                L_0x00f6:
                    r0 = r8.zzbpy;
                    if (r0 == 0) goto L_0x0110;
                L_0x00fa:
                    r0 = r8.zzbpy;
                    r0 = r0.length;
                    if (r0 <= 0) goto L_0x0110;
                L_0x00ff:
                    r0 = r8.zzbpy;
                    r0 = r0.length;
                    if (r1 >= r0) goto L_0x0110;
                L_0x0104:
                    r0 = 14;
                    r2 = r8.zzbpy;
                    r2 = r2[r1];
                    r9.zzb(r0, r2);
                    r1 = r1 + 1;
                    goto L_0x00ff;
                L_0x0110:
                    super.writeTo(r9);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.zza.writeTo(com.google.android.gms.internal.zztd):void");
                }

                public com.google.android.gms.internal.zzsz.zza.zza.zza zzC(com.google.android.gms.internal.zztc r7) throws java.io.IOException {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r6 = this;
                    r1 = 0;
                L_0x0001:
                    r0 = r7.zzHi();
                    switch(r0) {
                        case 0: goto L_0x000e;
                        case 10: goto L_0x000f;
                        case 18: goto L_0x0016;
                        case 25: goto L_0x001d;
                        case 37: goto L_0x0024;
                        case 40: goto L_0x002b;
                        case 48: goto L_0x0032;
                        case 56: goto L_0x0039;
                        case 64: goto L_0x0040;
                        case 74: goto L_0x0047;
                        case 82: goto L_0x0087;
                        case 90: goto L_0x00c7;
                        case 96: goto L_0x00fb;
                        case 98: goto L_0x012f;
                        case 104: goto L_0x0171;
                        case 114: goto L_0x01ad;
                        case 117: goto L_0x0179;
                        default: goto L_0x0008;
                    };
                L_0x0008:
                    r0 = r6.zza(r7, r0);
                    if (r0 != 0) goto L_0x0001;
                L_0x000e:
                    return r6;
                L_0x000f:
                    r0 = r7.readBytes();
                    r6.zzbpm = r0;
                    goto L_0x0001;
                L_0x0016:
                    r0 = r7.readString();
                    r6.zzbpn = r0;
                    goto L_0x0001;
                L_0x001d:
                    r2 = r7.readDouble();
                    r6.zzbpo = r2;
                    goto L_0x0001;
                L_0x0024:
                    r0 = r7.readFloat();
                    r6.zzbpp = r0;
                    goto L_0x0001;
                L_0x002b:
                    r2 = r7.zzHk();
                    r6.zzbpq = r2;
                    goto L_0x0001;
                L_0x0032:
                    r0 = r7.zzHl();
                    r6.zzbpr = r0;
                    goto L_0x0001;
                L_0x0039:
                    r0 = r7.zzHn();
                    r6.zzbps = r0;
                    goto L_0x0001;
                L_0x0040:
                    r0 = r7.zzHm();
                    r6.zzbpt = r0;
                    goto L_0x0001;
                L_0x0047:
                    r0 = 74;
                    r2 = com.google.android.gms.internal.zztn.zzc(r7, r0);
                    r0 = r6.zzbpu;
                    if (r0 != 0) goto L_0x0073;
                L_0x0051:
                    r0 = r1;
                L_0x0052:
                    r2 = r2 + r0;
                    r2 = new com.google.android.gms.internal.zzsz.zza[r2];
                    if (r0 == 0) goto L_0x005c;
                L_0x0057:
                    r3 = r6.zzbpu;
                    java.lang.System.arraycopy(r3, r1, r2, r1, r0);
                L_0x005c:
                    r3 = r2.length;
                    r3 = r3 + -1;
                    if (r0 >= r3) goto L_0x0077;
                L_0x0061:
                    r3 = new com.google.android.gms.internal.zzsz$zza;
                    r3.<init>();
                    r2[r0] = r3;
                    r3 = r2[r0];
                    r7.zza(r3);
                    r7.zzHi();
                    r0 = r0 + 1;
                    goto L_0x005c;
                L_0x0073:
                    r0 = r6.zzbpu;
                    r0 = r0.length;
                    goto L_0x0052;
                L_0x0077:
                    r3 = new com.google.android.gms.internal.zzsz$zza;
                    r3.<init>();
                    r2[r0] = r3;
                    r0 = r2[r0];
                    r7.zza(r0);
                    r6.zzbpu = r2;
                    goto L_0x0001;
                L_0x0087:
                    r0 = 82;
                    r2 = com.google.android.gms.internal.zztn.zzc(r7, r0);
                    r0 = r6.zzbpv;
                    if (r0 != 0) goto L_0x00b3;
                L_0x0091:
                    r0 = r1;
                L_0x0092:
                    r2 = r2 + r0;
                    r2 = new com.google.android.gms.internal.zzsz.zza.zza[r2];
                    if (r0 == 0) goto L_0x009c;
                L_0x0097:
                    r3 = r6.zzbpv;
                    java.lang.System.arraycopy(r3, r1, r2, r1, r0);
                L_0x009c:
                    r3 = r2.length;
                    r3 = r3 + -1;
                    if (r0 >= r3) goto L_0x00b7;
                L_0x00a1:
                    r3 = new com.google.android.gms.internal.zzsz$zza$zza;
                    r3.<init>();
                    r2[r0] = r3;
                    r3 = r2[r0];
                    r7.zza(r3);
                    r7.zzHi();
                    r0 = r0 + 1;
                    goto L_0x009c;
                L_0x00b3:
                    r0 = r6.zzbpv;
                    r0 = r0.length;
                    goto L_0x0092;
                L_0x00b7:
                    r3 = new com.google.android.gms.internal.zzsz$zza$zza;
                    r3.<init>();
                    r2[r0] = r3;
                    r0 = r2[r0];
                    r7.zza(r0);
                    r6.zzbpv = r2;
                    goto L_0x0001;
                L_0x00c7:
                    r0 = 90;
                    r2 = com.google.android.gms.internal.zztn.zzc(r7, r0);
                    r0 = r6.zzbpw;
                    if (r0 != 0) goto L_0x00ed;
                L_0x00d1:
                    r0 = r1;
                L_0x00d2:
                    r2 = r2 + r0;
                    r2 = new java.lang.String[r2];
                    if (r0 == 0) goto L_0x00dc;
                L_0x00d7:
                    r3 = r6.zzbpw;
                    java.lang.System.arraycopy(r3, r1, r2, r1, r0);
                L_0x00dc:
                    r3 = r2.length;
                    r3 = r3 + -1;
                    if (r0 >= r3) goto L_0x00f1;
                L_0x00e1:
                    r3 = r7.readString();
                    r2[r0] = r3;
                    r7.zzHi();
                    r0 = r0 + 1;
                    goto L_0x00dc;
                L_0x00ed:
                    r0 = r6.zzbpw;
                    r0 = r0.length;
                    goto L_0x00d2;
                L_0x00f1:
                    r3 = r7.readString();
                    r2[r0] = r3;
                    r6.zzbpw = r2;
                    goto L_0x0001;
                L_0x00fb:
                    r0 = 96;
                    r2 = com.google.android.gms.internal.zztn.zzc(r7, r0);
                    r0 = r6.zzbpx;
                    if (r0 != 0) goto L_0x0121;
                L_0x0105:
                    r0 = r1;
                L_0x0106:
                    r2 = r2 + r0;
                    r2 = new long[r2];
                    if (r0 == 0) goto L_0x0110;
                L_0x010b:
                    r3 = r6.zzbpx;
                    java.lang.System.arraycopy(r3, r1, r2, r1, r0);
                L_0x0110:
                    r3 = r2.length;
                    r3 = r3 + -1;
                    if (r0 >= r3) goto L_0x0125;
                L_0x0115:
                    r4 = r7.zzHk();
                    r2[r0] = r4;
                    r7.zzHi();
                    r0 = r0 + 1;
                    goto L_0x0110;
                L_0x0121:
                    r0 = r6.zzbpx;
                    r0 = r0.length;
                    goto L_0x0106;
                L_0x0125:
                    r4 = r7.zzHk();
                    r2[r0] = r4;
                    r6.zzbpx = r2;
                    goto L_0x0001;
                L_0x012f:
                    r0 = r7.zzHp();
                    r3 = r7.zzmn(r0);
                    r2 = r7.getPosition();
                    r0 = r1;
                L_0x013c:
                    r4 = r7.zzHu();
                    if (r4 <= 0) goto L_0x0148;
                L_0x0142:
                    r7.zzHk();
                    r0 = r0 + 1;
                    goto L_0x013c;
                L_0x0148:
                    r7.zzmp(r2);
                    r2 = r6.zzbpx;
                    if (r2 != 0) goto L_0x0166;
                L_0x014f:
                    r2 = r1;
                L_0x0150:
                    r0 = r0 + r2;
                    r0 = new long[r0];
                    if (r2 == 0) goto L_0x015a;
                L_0x0155:
                    r4 = r6.zzbpx;
                    java.lang.System.arraycopy(r4, r1, r0, r1, r2);
                L_0x015a:
                    r4 = r0.length;
                    if (r2 >= r4) goto L_0x016a;
                L_0x015d:
                    r4 = r7.zzHk();
                    r0[r2] = r4;
                    r2 = r2 + 1;
                    goto L_0x015a;
                L_0x0166:
                    r2 = r6.zzbpx;
                    r2 = r2.length;
                    goto L_0x0150;
                L_0x016a:
                    r6.zzbpx = r0;
                    r7.zzmo(r3);
                    goto L_0x0001;
                L_0x0171:
                    r2 = r7.zzHk();
                    r6.zzbpz = r2;
                    goto L_0x0001;
                L_0x0179:
                    r0 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
                    r2 = com.google.android.gms.internal.zztn.zzc(r7, r0);
                    r0 = r6.zzbpy;
                    if (r0 != 0) goto L_0x019f;
                L_0x0183:
                    r0 = r1;
                L_0x0184:
                    r2 = r2 + r0;
                    r2 = new float[r2];
                    if (r0 == 0) goto L_0x018e;
                L_0x0189:
                    r3 = r6.zzbpy;
                    java.lang.System.arraycopy(r3, r1, r2, r1, r0);
                L_0x018e:
                    r3 = r2.length;
                    r3 = r3 + -1;
                    if (r0 >= r3) goto L_0x01a3;
                L_0x0193:
                    r3 = r7.readFloat();
                    r2[r0] = r3;
                    r7.zzHi();
                    r0 = r0 + 1;
                    goto L_0x018e;
                L_0x019f:
                    r0 = r6.zzbpy;
                    r0 = r0.length;
                    goto L_0x0184;
                L_0x01a3:
                    r3 = r7.readFloat();
                    r2[r0] = r3;
                    r6.zzbpy = r2;
                    goto L_0x0001;
                L_0x01ad:
                    r0 = r7.zzHp();
                    r2 = r7.zzmn(r0);
                    r3 = r0 / 4;
                    r0 = r6.zzbpy;
                    if (r0 != 0) goto L_0x01d2;
                L_0x01bb:
                    r0 = r1;
                L_0x01bc:
                    r3 = r3 + r0;
                    r3 = new float[r3];
                    if (r0 == 0) goto L_0x01c6;
                L_0x01c1:
                    r4 = r6.zzbpy;
                    java.lang.System.arraycopy(r4, r1, r3, r1, r0);
                L_0x01c6:
                    r4 = r3.length;
                    if (r0 >= r4) goto L_0x01d6;
                L_0x01c9:
                    r4 = r7.readFloat();
                    r3[r0] = r4;
                    r0 = r0 + 1;
                    goto L_0x01c6;
                L_0x01d2:
                    r0 = r6.zzbpy;
                    r0 = r0.length;
                    goto L_0x01bc;
                L_0x01d6:
                    r6.zzbpy = r3;
                    r7.zzmo(r2);
                    goto L_0x0001;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.zza.zzC(com.google.android.gms.internal.zztc):com.google.android.gms.internal.zzsz$zza$zza$zza");
                }

                public com.google.android.gms.internal.zzsz.zza.zza.zza zzHg() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r6 = this;
                    r4 = 0;
                    r2 = 0;
                    r0 = com.google.android.gms.internal.zztn.zzbqi;
                    r6.zzbpm = r0;
                    r0 = "";
                    r6.zzbpn = r0;
                    r0 = 0;
                    r6.zzbpo = r0;
                    r0 = 0;
                    r6.zzbpp = r0;
                    r6.zzbpq = r4;
                    r6.zzbpr = r2;
                    r6.zzbps = r2;
                    r6.zzbpt = r2;
                    r0 = com.google.android.gms.internal.zzsz.zza.zzHc();
                    r6.zzbpu = r0;
                    r0 = com.google.android.gms.internal.zzsz.zza.zza.zzHe();
                    r6.zzbpv = r0;
                    r0 = com.google.android.gms.internal.zztn.zzbqg;
                    r6.zzbpw = r0;
                    r0 = com.google.android.gms.internal.zztn.zzboC;
                    r6.zzbpx = r0;
                    r0 = com.google.android.gms.internal.zztn.zzbqd;
                    r6.zzbpy = r0;
                    r6.zzbpz = r4;
                    r0 = 0;
                    r6.zzbpQ = r0;
                    r0 = -1;
                    r6.zzbqb = r0;
                    return r6;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.zza.zzHg():com.google.android.gms.internal.zzsz$zza$zza$zza");
                }

                protected int zzz() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r8 = this;
                    r6 = 0;
                    r1 = 0;
                    r0 = super.zzz();
                    r2 = r8.zzbpm;
                    r3 = com.google.android.gms.internal.zztn.zzbqi;
                    r2 = java.util.Arrays.equals(r2, r3);
                    if (r2 != 0) goto L_0x0019;
                L_0x0011:
                    r2 = 1;
                    r3 = r8.zzbpm;
                    r2 = com.google.android.gms.internal.zztd.zzb(r2, r3);
                    r0 = r0 + r2;
                L_0x0019:
                    r2 = r8.zzbpn;
                    r3 = "";
                    r2 = r2.equals(r3);
                    if (r2 != 0) goto L_0x002b;
                L_0x0023:
                    r2 = 2;
                    r3 = r8.zzbpn;
                    r2 = com.google.android.gms.internal.zztd.zzp(r2, r3);
                    r0 = r0 + r2;
                L_0x002b:
                    r2 = r8.zzbpo;
                    r2 = java.lang.Double.doubleToLongBits(r2);
                    r4 = 0;
                    r4 = java.lang.Double.doubleToLongBits(r4);
                    r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
                    if (r2 == 0) goto L_0x0043;
                L_0x003b:
                    r2 = 3;
                    r4 = r8.zzbpo;
                    r2 = com.google.android.gms.internal.zztd.zzb(r2, r4);
                    r0 = r0 + r2;
                L_0x0043:
                    r2 = r8.zzbpp;
                    r2 = java.lang.Float.floatToIntBits(r2);
                    r3 = 0;
                    r3 = java.lang.Float.floatToIntBits(r3);
                    if (r2 == r3) goto L_0x0058;
                L_0x0050:
                    r2 = 4;
                    r3 = r8.zzbpp;
                    r2 = com.google.android.gms.internal.zztd.zzc(r2, r3);
                    r0 = r0 + r2;
                L_0x0058:
                    r2 = r8.zzbpq;
                    r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
                    if (r2 == 0) goto L_0x0066;
                L_0x005e:
                    r2 = 5;
                    r4 = r8.zzbpq;
                    r2 = com.google.android.gms.internal.zztd.zzd(r2, r4);
                    r0 = r0 + r2;
                L_0x0066:
                    r2 = r8.zzbpr;
                    if (r2 == 0) goto L_0x0072;
                L_0x006a:
                    r2 = 6;
                    r3 = r8.zzbpr;
                    r2 = com.google.android.gms.internal.zztd.zzI(r2, r3);
                    r0 = r0 + r2;
                L_0x0072:
                    r2 = r8.zzbps;
                    if (r2 == 0) goto L_0x007e;
                L_0x0076:
                    r2 = 7;
                    r3 = r8.zzbps;
                    r2 = com.google.android.gms.internal.zztd.zzJ(r2, r3);
                    r0 = r0 + r2;
                L_0x007e:
                    r2 = r8.zzbpt;
                    if (r2 == 0) goto L_0x008b;
                L_0x0082:
                    r2 = 8;
                    r3 = r8.zzbpt;
                    r2 = com.google.android.gms.internal.zztd.zzc(r2, r3);
                    r0 = r0 + r2;
                L_0x008b:
                    r2 = r8.zzbpu;
                    if (r2 == 0) goto L_0x00ac;
                L_0x008f:
                    r2 = r8.zzbpu;
                    r2 = r2.length;
                    if (r2 <= 0) goto L_0x00ac;
                L_0x0094:
                    r2 = r0;
                    r0 = r1;
                L_0x0096:
                    r3 = r8.zzbpu;
                    r3 = r3.length;
                    if (r0 >= r3) goto L_0x00ab;
                L_0x009b:
                    r3 = r8.zzbpu;
                    r3 = r3[r0];
                    if (r3 == 0) goto L_0x00a8;
                L_0x00a1:
                    r4 = 9;
                    r3 = com.google.android.gms.internal.zztd.zzc(r4, r3);
                    r2 = r2 + r3;
                L_0x00a8:
                    r0 = r0 + 1;
                    goto L_0x0096;
                L_0x00ab:
                    r0 = r2;
                L_0x00ac:
                    r2 = r8.zzbpv;
                    if (r2 == 0) goto L_0x00cd;
                L_0x00b0:
                    r2 = r8.zzbpv;
                    r2 = r2.length;
                    if (r2 <= 0) goto L_0x00cd;
                L_0x00b5:
                    r2 = r0;
                    r0 = r1;
                L_0x00b7:
                    r3 = r8.zzbpv;
                    r3 = r3.length;
                    if (r0 >= r3) goto L_0x00cc;
                L_0x00bc:
                    r3 = r8.zzbpv;
                    r3 = r3[r0];
                    if (r3 == 0) goto L_0x00c9;
                L_0x00c2:
                    r4 = 10;
                    r3 = com.google.android.gms.internal.zztd.zzc(r4, r3);
                    r2 = r2 + r3;
                L_0x00c9:
                    r0 = r0 + 1;
                    goto L_0x00b7;
                L_0x00cc:
                    r0 = r2;
                L_0x00cd:
                    r2 = r8.zzbpw;
                    if (r2 == 0) goto L_0x00f2;
                L_0x00d1:
                    r2 = r8.zzbpw;
                    r2 = r2.length;
                    if (r2 <= 0) goto L_0x00f2;
                L_0x00d6:
                    r2 = r1;
                    r3 = r1;
                    r4 = r1;
                L_0x00d9:
                    r5 = r8.zzbpw;
                    r5 = r5.length;
                    if (r2 >= r5) goto L_0x00ee;
                L_0x00de:
                    r5 = r8.zzbpw;
                    r5 = r5[r2];
                    if (r5 == 0) goto L_0x00eb;
                L_0x00e4:
                    r4 = r4 + 1;
                    r5 = com.google.android.gms.internal.zztd.zzga(r5);
                    r3 = r3 + r5;
                L_0x00eb:
                    r2 = r2 + 1;
                    goto L_0x00d9;
                L_0x00ee:
                    r0 = r0 + r3;
                    r2 = r4 * 1;
                    r0 = r0 + r2;
                L_0x00f2:
                    r2 = r8.zzbpx;
                    if (r2 == 0) goto L_0x0114;
                L_0x00f6:
                    r2 = r8.zzbpx;
                    r2 = r2.length;
                    if (r2 <= 0) goto L_0x0114;
                L_0x00fb:
                    r2 = r1;
                L_0x00fc:
                    r3 = r8.zzbpx;
                    r3 = r3.length;
                    if (r1 >= r3) goto L_0x010d;
                L_0x0101:
                    r3 = r8.zzbpx;
                    r4 = r3[r1];
                    r3 = com.google.android.gms.internal.zztd.zzad(r4);
                    r2 = r2 + r3;
                    r1 = r1 + 1;
                    goto L_0x00fc;
                L_0x010d:
                    r0 = r0 + r2;
                    r1 = r8.zzbpx;
                    r1 = r1.length;
                    r1 = r1 * 1;
                    r0 = r0 + r1;
                L_0x0114:
                    r2 = r8.zzbpz;
                    r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
                    if (r1 == 0) goto L_0x0123;
                L_0x011a:
                    r1 = 13;
                    r2 = r8.zzbpz;
                    r1 = com.google.android.gms.internal.zztd.zzd(r1, r2);
                    r0 = r0 + r1;
                L_0x0123:
                    r1 = r8.zzbpy;
                    if (r1 == 0) goto L_0x0138;
                L_0x0127:
                    r1 = r8.zzbpy;
                    r1 = r1.length;
                    if (r1 <= 0) goto L_0x0138;
                L_0x012c:
                    r1 = r8.zzbpy;
                    r1 = r1.length;
                    r1 = r1 * 4;
                    r0 = r0 + r1;
                    r1 = r8.zzbpy;
                    r1 = r1.length;
                    r1 = r1 * 1;
                    r0 = r0 + r1;
                L_0x0138:
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.zza.zzz():int");
                }
            }

            public zza() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.<init>();
                r0.zzHf();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.<init>():void");
            }

            public static com.google.android.gms.internal.zzsz.zza.zza[] zzHe() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = zzbpk;
                if (r0 != 0) goto L_0x0011;
            L_0x0004:
                r1 = com.google.android.gms.internal.zzti.zzbqa;
                monitor-enter(r1);
                r0 = zzbpk;
                if (r0 != 0) goto L_0x0010;
            L_0x000b:
                r0 = 0;
                r0 = new com.google.android.gms.internal.zzsz.zza.zza[r0];
                zzbpk = r0;
            L_0x0010:
                monitor-exit(r1);
            L_0x0011:
                r0 = zzbpk;
                return r0;
            L_0x0014:
                r0 = move-exception;
                monitor-exit(r1);
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.zzHe():com.google.android.gms.internal.zzsz$zza$zza[]");
            }

            public boolean equals(java.lang.Object r5) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r1 = 1;
                r0 = 0;
                if (r5 != r4) goto L_0x0006;
            L_0x0004:
                r0 = r1;
            L_0x0005:
                return r0;
            L_0x0006:
                r2 = r5 instanceof com.google.android.gms.internal.zzsz.zza.zza;
                if (r2 == 0) goto L_0x0005;
            L_0x000a:
                r5 = (com.google.android.gms.internal.zzsz.zza.zza) r5;
                r2 = r4.type;
                r3 = r5.type;
                if (r2 != r3) goto L_0x0005;
            L_0x0012:
                r2 = r4.zzbpl;
                if (r2 != 0) goto L_0x0034;
            L_0x0016:
                r2 = r5.zzbpl;
                if (r2 != 0) goto L_0x0005;
            L_0x001a:
                r2 = r4.zzbpQ;
                if (r2 == 0) goto L_0x0026;
            L_0x001e:
                r2 = r4.zzbpQ;
                r2 = r2.isEmpty();
                if (r2 == 0) goto L_0x003f;
            L_0x0026:
                r2 = r5.zzbpQ;
                if (r2 == 0) goto L_0x0032;
            L_0x002a:
                r2 = r5.zzbpQ;
                r2 = r2.isEmpty();
                if (r2 == 0) goto L_0x0005;
            L_0x0032:
                r0 = r1;
                goto L_0x0005;
            L_0x0034:
                r2 = r4.zzbpl;
                r3 = r5.zzbpl;
                r2 = r2.equals(r3);
                if (r2 != 0) goto L_0x001a;
            L_0x003e:
                goto L_0x0005;
            L_0x003f:
                r0 = r4.zzbpQ;
                r1 = r5.zzbpQ;
                r0 = r0.equals(r1);
                goto L_0x0005;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r1 = 0;
                r0 = r3.getClass();
                r0 = r0.getName();
                r0 = r0.hashCode();
                r0 = r0 + 527;
                r0 = r0 * 31;
                r2 = r3.type;
                r0 = r0 + r2;
                r2 = r0 * 31;
                r0 = r3.zzbpl;
                if (r0 != 0) goto L_0x002c;
            L_0x001a:
                r0 = r1;
            L_0x001b:
                r0 = r0 + r2;
                r0 = r0 * 31;
                r2 = r3.zzbpQ;
                if (r2 == 0) goto L_0x002a;
            L_0x0022:
                r2 = r3.zzbpQ;
                r2 = r2.isEmpty();
                if (r2 == 0) goto L_0x0033;
            L_0x002a:
                r0 = r0 + r1;
                return r0;
            L_0x002c:
                r0 = r3.zzbpl;
                r0 = r0.hashCode();
                goto L_0x001b;
            L_0x0033:
                r1 = r3.zzbpQ;
                r1 = r1.hashCode();
                goto L_0x002a;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.hashCode():int");
            }

            public /* synthetic */ com.google.android.gms.internal.zztk mergeFrom(com.google.android.gms.internal.zztc r2) throws java.io.IOException {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.zzB(r2);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.mergeFrom(com.google.android.gms.internal.zztc):com.google.android.gms.internal.zztk");
            }

            public void writeTo(com.google.android.gms.internal.zztd r3) throws java.io.IOException {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 1;
                r1 = r2.type;
                r3.zzG(r0, r1);
                r0 = r2.zzbpl;
                if (r0 == 0) goto L_0x0010;
            L_0x000a:
                r0 = 2;
                r1 = r2.zzbpl;
                r3.zza(r0, r1);
            L_0x0010:
                super.writeTo(r3);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.writeTo(com.google.android.gms.internal.zztd):void");
            }

            public com.google.android.gms.internal.zzsz.zza.zza zzB(com.google.android.gms.internal.zztc r2) throws java.io.IOException {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
            L_0x0000:
                r0 = r2.zzHi();
                switch(r0) {
                    case 0: goto L_0x000d;
                    case 8: goto L_0x000e;
                    case 18: goto L_0x0019;
                    default: goto L_0x0007;
                };
            L_0x0007:
                r0 = r1.zza(r2, r0);
                if (r0 != 0) goto L_0x0000;
            L_0x000d:
                return r1;
            L_0x000e:
                r0 = r2.zzHl();
                switch(r0) {
                    case 1: goto L_0x0016;
                    case 2: goto L_0x0016;
                    case 3: goto L_0x0016;
                    case 4: goto L_0x0016;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0016;
                    case 7: goto L_0x0016;
                    case 8: goto L_0x0016;
                    case 9: goto L_0x0016;
                    case 10: goto L_0x0016;
                    case 11: goto L_0x0016;
                    case 12: goto L_0x0016;
                    case 13: goto L_0x0016;
                    case 14: goto L_0x0016;
                    case 15: goto L_0x0016;
                    default: goto L_0x0015;
                };
            L_0x0015:
                goto L_0x0000;
            L_0x0016:
                r1.type = r0;
                goto L_0x0000;
            L_0x0019:
                r0 = r1.zzbpl;
                if (r0 != 0) goto L_0x0024;
            L_0x001d:
                r0 = new com.google.android.gms.internal.zzsz$zza$zza$zza;
                r0.<init>();
                r1.zzbpl = r0;
            L_0x0024:
                r0 = r1.zzbpl;
                r2.zza(r0);
                goto L_0x0000;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.zzB(com.google.android.gms.internal.zztc):com.google.android.gms.internal.zzsz$zza$zza");
            }

            public com.google.android.gms.internal.zzsz.zza.zza zzHf() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r1 = 0;
                r0 = 1;
                r2.type = r0;
                r2.zzbpl = r1;
                r2.zzbpQ = r1;
                r0 = -1;
                r2.zzbqb = r0;
                return r2;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.zzHf():com.google.android.gms.internal.zzsz$zza$zza");
            }

            protected int zzz() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = super.zzz();
                r1 = 1;
                r2 = r3.type;
                r1 = com.google.android.gms.internal.zztd.zzI(r1, r2);
                r0 = r0 + r1;
                r1 = r3.zzbpl;
                if (r1 == 0) goto L_0x0018;
            L_0x0010:
                r1 = 2;
                r2 = r3.zzbpl;
                r1 = com.google.android.gms.internal.zztd.zzc(r1, r2);
                r0 = r0 + r1;
            L_0x0018:
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zza.zzz():int");
            }
        }

        public zza() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            r0.<init>();
            r0.zzHd();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.<init>():void");
        }

        public static com.google.android.gms.internal.zzsz.zza[] zzHc() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = zzbpi;
            if (r0 != 0) goto L_0x0011;
        L_0x0004:
            r1 = com.google.android.gms.internal.zzti.zzbqa;
            monitor-enter(r1);
            r0 = zzbpi;
            if (r0 != 0) goto L_0x0010;
        L_0x000b:
            r0 = 0;
            r0 = new com.google.android.gms.internal.zzsz.zza[r0];
            zzbpi = r0;
        L_0x0010:
            monitor-exit(r1);
        L_0x0011:
            r0 = zzbpi;
            return r0;
        L_0x0014:
            r0 = move-exception;
            monitor-exit(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zzHc():com.google.android.gms.internal.zzsz$zza[]");
        }

        public boolean equals(java.lang.Object r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r1 = 1;
            r0 = 0;
            if (r5 != r4) goto L_0x0006;
        L_0x0004:
            r0 = r1;
        L_0x0005:
            return r0;
        L_0x0006:
            r2 = r5 instanceof com.google.android.gms.internal.zzsz.zza;
            if (r2 == 0) goto L_0x0005;
        L_0x000a:
            r5 = (com.google.android.gms.internal.zzsz.zza) r5;
            r2 = r4.name;
            if (r2 != 0) goto L_0x0036;
        L_0x0010:
            r2 = r5.name;
            if (r2 != 0) goto L_0x0005;
        L_0x0014:
            r2 = r4.zzbpj;
            if (r2 != 0) goto L_0x0041;
        L_0x0018:
            r2 = r5.zzbpj;
            if (r2 != 0) goto L_0x0005;
        L_0x001c:
            r2 = r4.zzbpQ;
            if (r2 == 0) goto L_0x0028;
        L_0x0020:
            r2 = r4.zzbpQ;
            r2 = r2.isEmpty();
            if (r2 == 0) goto L_0x004c;
        L_0x0028:
            r2 = r5.zzbpQ;
            if (r2 == 0) goto L_0x0034;
        L_0x002c:
            r2 = r5.zzbpQ;
            r2 = r2.isEmpty();
            if (r2 == 0) goto L_0x0005;
        L_0x0034:
            r0 = r1;
            goto L_0x0005;
        L_0x0036:
            r2 = r4.name;
            r3 = r5.name;
            r2 = r2.equals(r3);
            if (r2 != 0) goto L_0x0014;
        L_0x0040:
            goto L_0x0005;
        L_0x0041:
            r2 = r4.zzbpj;
            r3 = r5.zzbpj;
            r2 = r2.equals(r3);
            if (r2 != 0) goto L_0x001c;
        L_0x004b:
            goto L_0x0005;
        L_0x004c:
            r0 = r4.zzbpQ;
            r1 = r5.zzbpQ;
            r0 = r0.equals(r1);
            goto L_0x0005;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r1 = 0;
            r0 = r3.getClass();
            r0 = r0.getName();
            r0 = r0.hashCode();
            r0 = r0 + 527;
            r2 = r0 * 31;
            r0 = r3.name;
            if (r0 != 0) goto L_0x002f;
        L_0x0015:
            r0 = r1;
        L_0x0016:
            r0 = r0 + r2;
            r2 = r0 * 31;
            r0 = r3.zzbpj;
            if (r0 != 0) goto L_0x0036;
        L_0x001d:
            r0 = r1;
        L_0x001e:
            r0 = r0 + r2;
            r0 = r0 * 31;
            r2 = r3.zzbpQ;
            if (r2 == 0) goto L_0x002d;
        L_0x0025:
            r2 = r3.zzbpQ;
            r2 = r2.isEmpty();
            if (r2 == 0) goto L_0x003d;
        L_0x002d:
            r0 = r0 + r1;
            return r0;
        L_0x002f:
            r0 = r3.name;
            r0 = r0.hashCode();
            goto L_0x0016;
        L_0x0036:
            r0 = r3.zzbpj;
            r0 = r0.hashCode();
            goto L_0x001e;
        L_0x003d:
            r1 = r3.zzbpQ;
            r1 = r1.hashCode();
            goto L_0x002d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.hashCode():int");
        }

        public /* synthetic */ com.google.android.gms.internal.zztk mergeFrom(com.google.android.gms.internal.zztc r2) throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.zzA(r2);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.mergeFrom(com.google.android.gms.internal.zztc):com.google.android.gms.internal.zztk");
        }

        public void writeTo(com.google.android.gms.internal.zztd r3) throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = 1;
            r1 = r2.name;
            r3.zzb(r0, r1);
            r0 = r2.zzbpj;
            if (r0 == 0) goto L_0x0010;
        L_0x000a:
            r0 = 2;
            r1 = r2.zzbpj;
            r3.zza(r0, r1);
        L_0x0010:
            super.writeTo(r3);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.writeTo(com.google.android.gms.internal.zztd):void");
        }

        public com.google.android.gms.internal.zzsz.zza zzA(com.google.android.gms.internal.zztc r2) throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
        L_0x0000:
            r0 = r2.zzHi();
            switch(r0) {
                case 0: goto L_0x000d;
                case 10: goto L_0x000e;
                case 18: goto L_0x0015;
                default: goto L_0x0007;
            };
        L_0x0007:
            r0 = r1.zza(r2, r0);
            if (r0 != 0) goto L_0x0000;
        L_0x000d:
            return r1;
        L_0x000e:
            r0 = r2.readString();
            r1.name = r0;
            goto L_0x0000;
        L_0x0015:
            r0 = r1.zzbpj;
            if (r0 != 0) goto L_0x0020;
        L_0x0019:
            r0 = new com.google.android.gms.internal.zzsz$zza$zza;
            r0.<init>();
            r1.zzbpj = r0;
        L_0x0020:
            r0 = r1.zzbpj;
            r2.zza(r0);
            goto L_0x0000;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zzA(com.google.android.gms.internal.zztc):com.google.android.gms.internal.zzsz$zza");
        }

        public com.google.android.gms.internal.zzsz.zza zzHd() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r1 = 0;
            r0 = "";
            r2.name = r0;
            r2.zzbpj = r1;
            r2.zzbpQ = r1;
            r0 = -1;
            r2.zzbqb = r0;
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zzHd():com.google.android.gms.internal.zzsz$zza");
        }

        protected int zzz() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = super.zzz();
            r1 = 1;
            r2 = r3.name;
            r1 = com.google.android.gms.internal.zztd.zzp(r1, r2);
            r0 = r0 + r1;
            r1 = r3.zzbpj;
            if (r1 == 0) goto L_0x0018;
        L_0x0010:
            r1 = 2;
            r2 = r3.zzbpj;
            r1 = com.google.android.gms.internal.zztd.zzc(r1, r2);
            r0 = r0 + r1;
        L_0x0018:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsz.zza.zzz():int");
        }
    }

    public zzsz() {
        zzHb();
    }

    public static zzsz zzz(byte[] bArr) throws zztj {
        return (zzsz) zztk.mergeFrom(new zzsz(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzsz)) {
            return false;
        }
        zzsz com_google_android_gms_internal_zzsz = (zzsz) o;
        if (!zzti.equals(this.zzbph, com_google_android_gms_internal_zzsz.zzbph)) {
            return false;
        }
        if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
            return com_google_android_gms_internal_zzsz.zzbpQ == null || com_google_android_gms_internal_zzsz.zzbpQ.isEmpty();
        } else {
            return this.zzbpQ.equals(com_google_android_gms_internal_zzsz.zzbpQ);
        }
    }

    public int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzti.hashCode(this.zzbph)) * 31;
        int hashCode2 = (this.zzbpQ == null || this.zzbpQ.isEmpty()) ? 0 : this.zzbpQ.hashCode();
        return hashCode2 + hashCode;
    }

    public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
        return zzz(x0);
    }

    public void writeTo(zztd output) throws IOException {
        if (this.zzbph != null && this.zzbph.length > 0) {
            for (zztk com_google_android_gms_internal_zztk : this.zzbph) {
                if (com_google_android_gms_internal_zztk != null) {
                    output.zza(1, com_google_android_gms_internal_zztk);
                }
            }
        }
        super.writeTo(output);
    }

    public zzsz zzHb() {
        this.zzbph = zza.zzHc();
        this.zzbpQ = null;
        this.zzbqb = -1;
        return this;
    }

    protected int zzz() {
        int zzz = super.zzz();
        if (this.zzbph != null && this.zzbph.length > 0) {
            for (zztk com_google_android_gms_internal_zztk : this.zzbph) {
                if (com_google_android_gms_internal_zztk != null) {
                    zzz += zztd.zzc(1, com_google_android_gms_internal_zztk);
                }
            }
        }
        return zzz;
    }

    public zzsz zzz(zztc com_google_android_gms_internal_zztc) throws IOException {
        while (true) {
            int zzHi = com_google_android_gms_internal_zztc.zzHi();
            switch (zzHi) {
                case 0:
                    break;
                case 10:
                    int zzc = zztn.zzc(com_google_android_gms_internal_zztc, 10);
                    zzHi = this.zzbph == null ? 0 : this.zzbph.length;
                    Object obj = new zza[(zzc + zzHi)];
                    if (zzHi != 0) {
                        System.arraycopy(this.zzbph, 0, obj, 0, zzHi);
                    }
                    while (zzHi < obj.length - 1) {
                        obj[zzHi] = new zza();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        com_google_android_gms_internal_zztc.zzHi();
                        zzHi++;
                    }
                    obj[zzHi] = new zza();
                    com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                    this.zzbph = obj;
                    continue;
                default:
                    if (!zza(com_google_android_gms_internal_zztc, zzHi)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
