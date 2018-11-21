package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzf;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.events.zzj;
import com.google.android.gms.drive.events.zzl;
import java.util.ArrayList;
import java.util.List;

public class zzae extends com.google.android.gms.drive.internal.zzao.zza {
    private final int zzalo;
    private final List<Integer> zzapA = new ArrayList();
    private final zzf zzapy;
    private final zza zzapz;

    private static class zza extends Handler {
        private final Context mContext;

        private zza(Looper looper, Context context) {
            super(looper);
            this.mContext = context;
        }

        private static void zza(zzl com_google_android_gms_drive_events_zzl, QueryResultEventParcelable queryResultEventParcelable) {
            DataHolder zzsA = queryResultEventParcelable.zzsA();
            if (zzsA != null) {
                final MetadataBuffer metadataBuffer = new MetadataBuffer(zzsA);
                com_google_android_gms_drive_events_zzl.zza(new zzj() {
                });
            }
            if (queryResultEventParcelable.zzsB()) {
                com_google_android_gms_drive_events_zzl.zzcL(queryResultEventParcelable.zzsC());
            }
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    zzf com_google_android_gms_drive_events_zzf = (zzf) pair.first;
                    DriveEvent driveEvent = (DriveEvent) pair.second;
                    switch (driveEvent.getType()) {
                        case 1:
                            ((ChangeListener) com_google_android_gms_drive_events_zzf).onChange((ChangeEvent) driveEvent);
                            return;
                        case 2:
                            ((CompletionListener) com_google_android_gms_drive_events_zzf).onCompletion((CompletionEvent) driveEvent);
                            return;
                        case 3:
                            zza((zzl) com_google_android_gms_drive_events_zzf, (QueryResultEventParcelable) driveEvent);
                            return;
                        case 4:
                            ((zzc) com_google_android_gms_drive_events_zzf).zza((ChangesAvailableEvent) driveEvent);
                            return;
                        case 5:
                        case 6:
                            ((zzi) com_google_android_gms_drive_events_zzf).zza((ProgressEvent) driveEvent);
                            return;
                        default:
                            zzz.zzA("EventCallback", "Unexpected event: " + driveEvent);
                            return;
                    }
                default:
                    zzz.zze(this.mContext, "EventCallback", "Don't know how to handle this event");
                    return;
            }
        }

        public void zza(zzf com_google_android_gms_drive_events_zzf, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(com_google_android_gms_drive_events_zzf, driveEvent)));
        }
    }

    public zzae(Looper looper, Context context, int i, zzf com_google_android_gms_drive_events_zzf) {
        this.zzalo = i;
        this.zzapy = com_google_android_gms_drive_events_zzf;
        this.zzapz = new zza(looper, context);
    }

    public void zzc(OnEventResponse onEventResponse) throws RemoteException {
        DriveEvent zzsT = onEventResponse.zzsT();
        zzx.zzaa(this.zzalo == zzsT.getType());
        zzx.zzaa(this.zzapA.contains(Integer.valueOf(zzsT.getType())));
        this.zzapz.zza(this.zzapy, zzsT);
    }

    public void zzdd(int i) {
        this.zzapA.add(Integer.valueOf(i));
    }

    public boolean zzde(int i) {
        return this.zzapA.contains(Integer.valueOf(i));
    }
}
