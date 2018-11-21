package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public class MessengerCompat implements Parcelable {
    public static final Creator<MessengerCompat> CREATOR = new C02601();
    Messenger zzaKq;
    zzb zzaKr;

    static class C02601 implements Creator<MessengerCompat> {
        C02601() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzeF(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzhd(x0);
        }

        public MessengerCompat zzeF(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            return readStrongBinder != null ? new MessengerCompat(readStrongBinder) : null;
        }

        public MessengerCompat[] zzhd(int i) {
            return new MessengerCompat[i];
        }
    }

    private final class zza extends com.google.android.gms.iid.zzb.zza {
        Handler handler;
        final /* synthetic */ MessengerCompat zzaKs;

        zza(MessengerCompat messengerCompat, Handler handler) {
            this.zzaKs = messengerCompat;
            this.handler = handler;
        }

        public void send(Message msg) throws RemoteException {
            msg.arg2 = Binder.getCallingUid();
            this.handler.dispatchMessage(msg);
        }
    }

    public MessengerCompat(Handler handler) {
        if (VERSION.SDK_INT >= 21) {
            this.zzaKq = new Messenger(handler);
        } else {
            this.zzaKr = new zza(this, handler);
        }
    }

    public MessengerCompat(IBinder target) {
        if (VERSION.SDK_INT >= 21) {
            this.zzaKq = new Messenger(target);
        } else {
            this.zzaKr = com.google.android.gms.iid.zzb.zza.zzcd(target);
        }
    }

    public static int zzc(Message message) {
        return VERSION.SDK_INT >= 21 ? zzd(message) : message.arg2;
    }

    private static int zzd(Message message) {
        return message.sendingUid;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object otherObj) {
        boolean z = false;
        if (otherObj != null) {
            try {
                z = getBinder().equals(((MessengerCompat) otherObj).getBinder());
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public IBinder getBinder() {
        return this.zzaKq != null ? this.zzaKq.getBinder() : this.zzaKr.asBinder();
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public void send(Message message) throws RemoteException {
        if (this.zzaKq != null) {
            this.zzaKq.send(message);
        } else {
            this.zzaKr.send(message);
        }
    }

    public void writeToParcel(Parcel out, int flags) {
        if (this.zzaKq != null) {
            out.writeStrongBinder(this.zzaKq.getBinder());
        } else {
            out.writeStrongBinder(this.zzaKr.asBinder());
        }
    }
}
