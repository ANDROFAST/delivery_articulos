package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;

public class zzlb implements ProxyApi {
    public PendingResult<ProxyResult> performProxyRequest(GoogleApiClient client, final ProxyRequest request) {
        zzx.zzy(client);
        zzx.zzy(request);
        return client.zzb(new zzla(this, client) {
            final /* synthetic */ zzlb zzVl;

            class C11921 extends zzkw {
                final /* synthetic */ C12121 zzVm;

                C11921(C12121 c12121) {
                    this.zzVm = c12121;
                }

                public void zza(ProxyResponse proxyResponse) {
                    this.zzVm.zzb(new zzlc(proxyResponse));
                }
            }

            protected void zza(Context context, zzkz com_google_android_gms_internal_zzkz) throws RemoteException {
                com_google_android_gms_internal_zzkz.zza(new C11921(this), request);
            }
        });
    }
}
