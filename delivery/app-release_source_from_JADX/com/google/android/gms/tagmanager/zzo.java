package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;

class zzo implements ContainerHolder {
    private Status zzTA;
    private final Looper zzaeK;
    private boolean zzanO;
    private Container zzbcN;
    private Container zzbcO;
    private zzb zzbcP;
    private zza zzbcQ;
    private TagManager zzbcR;

    public interface zza {
        String zzEh();

        void zzEj();

        void zzff(String str);
    }

    private class zzb extends Handler {
        private final ContainerAvailableListener zzbcS;
        final /* synthetic */ zzo zzbcT;

        public zzb(zzo com_google_android_gms_tagmanager_zzo, ContainerAvailableListener containerAvailableListener, Looper looper) {
            this.zzbcT = com_google_android_gms_tagmanager_zzo;
            super(looper);
            this.zzbcS = containerAvailableListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    zzfh((String) msg.obj);
                    return;
                default:
                    zzbg.m9e("Don't know how to handle this message.");
                    return;
            }
        }

        public void zzfg(String str) {
            sendMessage(obtainMessage(1, str));
        }

        protected void zzfh(String str) {
            this.zzbcS.onContainerAvailable(this.zzbcT, str);
        }
    }

    public zzo(Status status) {
        this.zzTA = status;
        this.zzaeK = null;
    }

    public zzo(TagManager tagManager, Looper looper, Container container, zza com_google_android_gms_tagmanager_zzo_zza) {
        this.zzbcR = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.zzaeK = looper;
        this.zzbcN = container;
        this.zzbcQ = com_google_android_gms_tagmanager_zzo_zza;
        this.zzTA = Status.zzaeX;
        tagManager.zza(this);
    }

    private void zzEi() {
        if (this.zzbcP != null) {
            this.zzbcP.zzfg(this.zzbcO.zzEf());
        }
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.zzanO) {
                zzbg.m9e("ContainerHolder is released.");
            } else {
                if (this.zzbcO != null) {
                    this.zzbcN = this.zzbcO;
                    this.zzbcO = null;
                }
                container = this.zzbcN;
            }
        }
        return container;
    }

    String getContainerId() {
        if (!this.zzanO) {
            return this.zzbcN.getContainerId();
        }
        zzbg.m9e("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public Status getStatus() {
        return this.zzTA;
    }

    public synchronized void refresh() {
        if (this.zzanO) {
            zzbg.m9e("Refreshing a released ContainerHolder.");
        } else {
            this.zzbcQ.zzEj();
        }
    }

    public synchronized void release() {
        if (this.zzanO) {
            zzbg.m9e("Releasing a released ContainerHolder.");
        } else {
            this.zzanO = true;
            this.zzbcR.zzb(this);
            this.zzbcN.release();
            this.zzbcN = null;
            this.zzbcO = null;
            this.zzbcQ = null;
            this.zzbcP = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerAvailableListener listener) {
        if (this.zzanO) {
            zzbg.m9e("ContainerHolder is released.");
        } else if (listener == null) {
            this.zzbcP = null;
        } else {
            this.zzbcP = new zzb(this, listener, this.zzaeK);
            if (this.zzbcO != null) {
                zzEi();
            }
        }
    }

    String zzEh() {
        if (!this.zzanO) {
            return this.zzbcQ.zzEh();
        }
        zzbg.m9e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public synchronized void zza(Container container) {
        if (!this.zzanO) {
            if (container == null) {
                zzbg.m9e("Unexpected null container.");
            } else {
                this.zzbcO = container;
                zzEi();
            }
        }
    }

    public synchronized void zzfd(String str) {
        if (!this.zzanO) {
            this.zzbcN.zzfd(str);
        }
    }

    void zzff(String str) {
        if (this.zzanO) {
            zzbg.m9e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.zzbcQ.zzff(str);
        }
    }
}
