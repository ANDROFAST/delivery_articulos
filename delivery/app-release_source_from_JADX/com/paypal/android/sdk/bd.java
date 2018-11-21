package com.paypal.android.sdk;

final class bd implements Runnable {
    private /* synthetic */ bm f309a;
    private /* synthetic */ bc f310b;

    bd(bc bcVar, bm bmVar) {
        this.f310b = bcVar;
        this.f309a = bmVar;
    }

    public final void run() {
        bc.f1348c;
        new StringBuilder("Mock executing ").append(this.f309a.m281o()).append(" request: ").append(this.f309a.m274g());
        if (this.f310b.mo4789c(this.f309a)) {
            String a = this.f310b.mo4787a();
            this.f309a.m276i().mo3739a();
            new StringBuilder("mock failure:\n").append(a);
            this.f309a.m268b(a);
            bb.m941a(this.f309a, this.f310b.mo4788b());
        } else {
            CharSequence e = this.f309a.mo3752e();
            if (C0510f.m464c(e)) {
                throw new RuntimeException("Blank mock value for " + this.f309a.m276i());
            }
            this.f309a.m276i().mo3739a();
            new StringBuilder("mock response:").append(e);
            this.f309a.m268b(e);
            bb.m940a(this.f309a);
        }
        if (!this.f309a.mo3748a()) {
            try {
                bc.f1348c;
                new StringBuilder("sleep for [").append(this.f310b.f1350b).append(" ms].");
                Thread.sleep((long) this.f310b.f1350b);
                bc.f1348c;
                new StringBuilder("end [").append(this.f310b.f1350b).append(" ms] sleep");
            } catch (InterruptedException e2) {
                this.f309a.m276i().mo3739a();
            }
            this.f310b.f1349a.mo3728a(this.f309a);
        }
    }
}
