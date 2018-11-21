package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.zzh;

public class zzbj implements zzh {
    private final LargeAssetSyncRequestPayload zzbog;
    private final zzay zzboh;
    private boolean zzboi;
    private ParcelFileDescriptor zzboj;
    private long zzbok;
    private int zzbol;

    public zzbj(LargeAssetSyncRequestPayload largeAssetSyncRequestPayload, zzay com_google_android_gms_wearable_internal_zzay) {
        this.zzbog = (LargeAssetSyncRequestPayload) zzx.zzy(largeAssetSyncRequestPayload);
        this.zzboh = (zzay) zzx.zzy(com_google_android_gms_wearable_internal_zzay);
        zzx.zzy(largeAssetSyncRequestPayload.zzbnK);
        zzx.zzb(largeAssetSyncRequestPayload.zzbom >= 0, "Got negative offset: %s", Long.valueOf(largeAssetSyncRequestPayload.zzbom));
    }

    public void zzGX() throws android.os.RemoteException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x001d in list [B:6:0x0018]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = r4.zzboi;	 Catch:{ all -> 0x0026 }
        r1 = "Received onLargeAssetSyncRequest but didn't set a response.";	 Catch:{ all -> 0x0026 }
        com.google.android.gms.common.internal.zzx.zza(r0, r1);	 Catch:{ all -> 0x0026 }
        r0 = r4.zzboj;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x001e;	 Catch:{ all -> 0x0026 }
    L_0x000b:
        r0 = r4.zzboh;	 Catch:{ all -> 0x0026 }
        r1 = r4.zzboj;	 Catch:{ all -> 0x0026 }
        r2 = r4.zzbok;	 Catch:{ all -> 0x0026 }
        r0.zza(r1, r2);	 Catch:{ all -> 0x0026 }
    L_0x0014:
        r0 = r4.zzboj;
        if (r0 == 0) goto L_0x001d;
    L_0x0018:
        r0 = r4.zzboj;
        com.google.android.gms.internal.zznt.zza(r0);
    L_0x001d:
        return;
    L_0x001e:
        r0 = r4.zzboh;	 Catch:{ all -> 0x0026 }
        r1 = r4.zzbol;	 Catch:{ all -> 0x0026 }
        r0.zzli(r1);	 Catch:{ all -> 0x0026 }
        goto L_0x0014;
    L_0x0026:
        r0 = move-exception;
        r1 = r4.zzboj;
        if (r1 == 0) goto L_0x0030;
    L_0x002b:
        r1 = r4.zzboj;
        com.google.android.gms.internal.zznt.zza(r1);
    L_0x0030:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzbj.zzGX():void");
    }

    public void zzli(int i) {
        zzx.zza(!this.zzboi, (Object) "createOutputFileDescriptor called when response already set");
        this.zzbol = i;
        this.zzboi = true;
    }
}
