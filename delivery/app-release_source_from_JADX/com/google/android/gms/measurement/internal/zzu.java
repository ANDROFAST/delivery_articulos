package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzl.zza;

public class zzu extends zza {
    private final zzt zzaQX;
    private final boolean zzaUB;

    public zzu(zzt com_google_android_gms_measurement_internal_zzt) {
        zzx.zzy(com_google_android_gms_measurement_internal_zzt);
        this.zzaQX = com_google_android_gms_measurement_internal_zzt;
        this.zzaUB = false;
    }

    public zzu(zzt com_google_android_gms_measurement_internal_zzt, boolean z) {
        zzx.zzy(com_google_android_gms_measurement_internal_zzt);
        this.zzaQX = com_google_android_gms_measurement_internal_zzt;
        this.zzaUB = z;
    }

    private void zzeB(String str) throws SecurityException {
        if (TextUtils.isEmpty(str)) {
            this.zzaQX.zzzz().zzBl().zzez("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            zzeC(str);
        } catch (SecurityException e) {
            this.zzaQX.zzzz().zzBl().zzj("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    private void zzeC(String str) throws SecurityException {
        int myUid = this.zzaUB ? Process.myUid() : Binder.getCallingUid();
        if (!GooglePlayServicesUtil.zzb(this.zzaQX.getContext(), myUid, str)) {
            if (!GooglePlayServicesUtil.zze(this.zzaQX.getContext(), myUid) || this.zzaQX.zzBI()) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
        }
    }

    public void zza(final AppMetadata appMetadata) {
        zzx.zzy(appMetadata);
        zzeB(appMetadata.packageName);
        this.zzaQX.zzAV().zzg(new Runnable(this) {
            final /* synthetic */ zzu zzaUD;

            public void run() {
                this.zzaUD.zzeA(appMetadata.zzaSr);
                this.zzaUD.zzaQX.zzd(appMetadata);
            }
        });
    }

    public void zza(final EventParcel eventParcel, final AppMetadata appMetadata) {
        zzx.zzy(eventParcel);
        zzx.zzy(appMetadata);
        zzeB(appMetadata.packageName);
        this.zzaQX.zzAV().zzg(new Runnable(this) {
            final /* synthetic */ zzu zzaUD;

            public void run() {
                this.zzaUD.zzeA(appMetadata.zzaSr);
                this.zzaUD.zzaQX.zzb(eventParcel, appMetadata);
            }
        });
    }

    public void zza(final EventParcel eventParcel, final String str, final String str2) {
        zzx.zzy(eventParcel);
        zzx.zzcG(str);
        zzeB(str);
        this.zzaQX.zzAV().zzg(new Runnable(this) {
            final /* synthetic */ zzu zzaUD;

            public void run() {
                this.zzaUD.zzeA(str2);
                this.zzaUD.zzaQX.zza(eventParcel, str);
            }
        });
    }

    public void zza(final UserAttributeParcel userAttributeParcel, final AppMetadata appMetadata) {
        zzx.zzy(userAttributeParcel);
        zzx.zzy(appMetadata);
        zzeB(appMetadata.packageName);
        if (userAttributeParcel.getValue() == null) {
            this.zzaQX.zzAV().zzg(new Runnable(this) {
                final /* synthetic */ zzu zzaUD;

                public void run() {
                    this.zzaUD.zzeA(appMetadata.zzaSr);
                    this.zzaUD.zzaQX.zzc(userAttributeParcel, appMetadata);
                }
            });
        } else {
            this.zzaQX.zzAV().zzg(new Runnable(this) {
                final /* synthetic */ zzu zzaUD;

                public void run() {
                    this.zzaUD.zzeA(appMetadata.zzaSr);
                    this.zzaUD.zzaQX.zzb(userAttributeParcel, appMetadata);
                }
            });
        }
    }

    public void zzb(final AppMetadata appMetadata) {
        zzx.zzy(appMetadata);
        zzeB(appMetadata.packageName);
        this.zzaQX.zzAV().zzg(new Runnable(this) {
            final /* synthetic */ zzu zzaUD;

            public void run() {
                this.zzaUD.zzeA(appMetadata.zzaSr);
                this.zzaUD.zzaQX.zzc(appMetadata);
            }
        });
    }

    void zzeA(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":", 2);
            if (split.length == 2) {
                try {
                    long longValue = Long.valueOf(split[0]).longValue();
                    if (longValue > 0) {
                        this.zzaQX.zzAW().zzaTE.zzg(split[1], longValue);
                    } else {
                        this.zzaQX.zzzz().zzBm().zzj("Combining sample with a non-positive weight", Long.valueOf(longValue));
                    }
                } catch (NumberFormatException e) {
                    this.zzaQX.zzzz().zzBm().zzj("Combining sample with a non-number weight", split[0]);
                }
            }
        }
    }
}
