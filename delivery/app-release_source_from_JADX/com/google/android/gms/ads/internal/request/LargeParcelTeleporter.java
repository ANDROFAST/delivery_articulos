package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zznt;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

@zzha
public final class LargeParcelTeleporter implements SafeParcelable {
    public static final Creator<LargeParcelTeleporter> CREATOR = new zzl();
    final int mVersionCode;
    ParcelFileDescriptor zzHf;
    private Parcelable zzHg;
    private boolean zzHh;

    LargeParcelTeleporter(int versionCode, ParcelFileDescriptor parcelFileDescriptor) {
        this.mVersionCode = versionCode;
        this.zzHf = parcelFileDescriptor;
        this.zzHg = null;
        this.zzHh = true;
    }

    public LargeParcelTeleporter(SafeParcelable teleportee) {
        this.mVersionCode = 1;
        this.zzHf = null;
        this.zzHg = teleportee;
        this.zzHh = false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (this.zzHf == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzHg.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                this.zzHf = zzf(marshall);
            } finally {
                obtain.recycle();
            }
        }
        zzl.zza(this, dest, flags);
    }

    public <T extends SafeParcelable> T zza(Creator<T> creator) {
        if (this.zzHh) {
            if (this.zzHf == null) {
                zzb.m6e("File descriptor is empty, returning null.");
                return null;
            }
            Closeable dataInputStream = new DataInputStream(new AutoCloseInputStream(this.zzHf));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                zznt.zzb(dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.zzHg = (SafeParcelable) creator.createFromParcel(obtain);
                    this.zzHh = false;
                } finally {
                    obtain.recycle();
                }
            } catch (Throwable e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th) {
                zznt.zzb(dataInputStream);
            }
        }
        return (SafeParcelable) this.zzHg;
    }

    protected <T> ParcelFileDescriptor zzf(final byte[] bArr) {
        Throwable e;
        ParcelFileDescriptor parcelFileDescriptor = null;
        final Closeable autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new Runnable(this) {
                    final /* synthetic */ LargeParcelTeleporter zzHk;

                    public void run() {
                        Throwable e;
                        Closeable dataOutputStream;
                        try {
                            dataOutputStream = new DataOutputStream(autoCloseOutputStream);
                            try {
                                dataOutputStream.writeInt(bArr.length);
                                dataOutputStream.write(bArr);
                                if (dataOutputStream == null) {
                                    zznt.zzb(autoCloseOutputStream);
                                } else {
                                    zznt.zzb(dataOutputStream);
                                }
                            } catch (IOException e2) {
                                e = e2;
                                try {
                                    zzb.zzb("Error transporting the ad response", e);
                                    zzp.zzbA().zzb(e, true);
                                    if (dataOutputStream != null) {
                                        zznt.zzb(autoCloseOutputStream);
                                    } else {
                                        zznt.zzb(dataOutputStream);
                                    }
                                } catch (Throwable th) {
                                    e = th;
                                    if (dataOutputStream != null) {
                                        zznt.zzb(autoCloseOutputStream);
                                    } else {
                                        zznt.zzb(dataOutputStream);
                                    }
                                    throw e;
                                }
                            }
                        } catch (IOException e3) {
                            e = e3;
                            dataOutputStream = null;
                            zzb.zzb("Error transporting the ad response", e);
                            zzp.zzbA().zzb(e, true);
                            if (dataOutputStream != null) {
                                zznt.zzb(dataOutputStream);
                            } else {
                                zznt.zzb(autoCloseOutputStream);
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            dataOutputStream = null;
                            if (dataOutputStream != null) {
                                zznt.zzb(dataOutputStream);
                            } else {
                                zznt.zzb(autoCloseOutputStream);
                            }
                            throw e;
                        }
                    }
                }).start();
                return createPipe[0];
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            autoCloseOutputStream = parcelFileDescriptor;
            zzb.zzb("Error transporting the ad response", e);
            zzp.zzbA().zzb(e, true);
            zznt.zzb(autoCloseOutputStream);
            return parcelFileDescriptor;
        }
    }
}
