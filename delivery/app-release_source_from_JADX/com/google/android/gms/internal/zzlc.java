package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

class zzlc implements ProxyResult {
    private Status zzTA;
    private ProxyResponse zzVn;

    public zzlc(ProxyResponse proxyResponse) {
        this.zzVn = proxyResponse;
        this.zzTA = Status.zzaeX;
    }

    public zzlc(Status status) {
        this.zzTA = status;
    }

    public ProxyResponse getResponse() {
        return this.zzVn;
    }

    public Status getStatus() {
        return this.zzTA;
    }
}
