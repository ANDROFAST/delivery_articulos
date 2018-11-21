package com.paypal.android.sdk;

import android.os.Message;

public class ax implements bn {
    private static final String f1178a = ax.class.getSimpleName();
    private final C0506b f1179b;
    private ay f1180c = new ay(this);
    private aw f1181d;
    private final aC f1182e = new aC();
    private bi f1183f;

    public ax(C0506b c0506b, aw awVar, C0507c c0507c) {
        this.f1179b = c0506b;
        this.f1181d = awVar;
    }

    public final String mo3727a(bk bkVar) {
        new StringBuilder("environment:").append(this.f1181d).append(" environment.getEndpoints():").append(this.f1181d.m175b());
        if (this.f1181d == null || this.f1181d.m175b() == null) {
            return null;
        }
        String str = (String) this.f1181d.m175b().get(bkVar.mo3739a());
        new StringBuilder("returning:").append(str);
        return str;
    }

    public final void m920a() {
        this.f1183f.m253a();
    }

    public final void m921a(aE aEVar) {
        this.f1182e.m83a(aEVar);
    }

    public final void m922a(bi biVar) {
        if (this.f1183f != null) {
            throw new IllegalStateException();
        }
        this.f1183f = biVar;
    }

    public final void mo3728a(bm bmVar) {
        bmVar.mo4817m();
        C0503Y.m52a().m78f();
        if (!bmVar.mo3748a()) {
            Message message = new Message();
            message.what = 2;
            message.obj = bmVar;
            this.f1180c.sendMessage(message);
        }
    }

    public final void m924b() {
        this.f1182e.m82a();
    }

    public final void m925b(bm bmVar) {
        this.f1183f.m254a(bmVar);
    }

    public final String mo3729c() {
        return this.f1181d.m172a();
    }

    public final C0506b mo3730d() {
        return this.f1179b;
    }
}
