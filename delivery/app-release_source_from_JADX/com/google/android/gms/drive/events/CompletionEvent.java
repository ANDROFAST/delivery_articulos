package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzap.zza;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zzof;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<CompletionEvent> CREATOR = new zze();
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    final int mVersionCode;
    final int zzAk;
    final String zzTD;
    final DriveId zzamF;
    final ParcelFileDescriptor zzanH;
    final ParcelFileDescriptor zzanI;
    final MetadataBundle zzanJ;
    final List<String> zzanK;
    final IBinder zzanL;
    private boolean zzanM = false;
    private boolean zzanN = false;
    private boolean zzanO = false;

    CompletionEvent(int versionCode, DriveId driveId, String accountName, ParcelFileDescriptor baseParcelFileDescriptor, ParcelFileDescriptor modifiedParcelFileDescriptor, MetadataBundle modifiedMetadataBundle, List<String> trackingTags, int status, IBinder releaseCallback) {
        this.mVersionCode = versionCode;
        this.zzamF = driveId;
        this.zzTD = accountName;
        this.zzanH = baseParcelFileDescriptor;
        this.zzanI = modifiedParcelFileDescriptor;
        this.zzanJ = modifiedMetadataBundle;
        this.zzanK = trackingTags;
        this.zzAk = status;
        this.zzanL = releaseCallback;
    }

    private void zzsx() {
        if (this.zzanO) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    private void zzv(boolean z) {
        zzsx();
        this.zzanO = true;
        zznt.zza(this.zzanH);
        zznt.zza(this.zzanI);
        if (this.zzanJ != null && this.zzanJ.zzc(zzof.zzart)) {
            ((BitmapTeleporter) this.zzanJ.zza(zzof.zzart)).release();
        }
        if (this.zzanL == null) {
            zzz.zzB("CompletionEvent", "No callback on " + (z ? "snooze" : "dismiss"));
            return;
        }
        try {
            zza.zzbd(this.zzanL).zzv(z);
        } catch (RemoteException e) {
            zzz.zzB("CompletionEvent", "RemoteException on " + (z ? "snooze" : "dismiss") + ": " + e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void dismiss() {
        zzv(false);
    }

    public String getAccountName() {
        zzsx();
        return this.zzTD;
    }

    public InputStream getBaseContentsInputStream() {
        zzsx();
        if (this.zzanH == null) {
            return null;
        }
        if (this.zzanM) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzanM = true;
        return new FileInputStream(this.zzanH.getFileDescriptor());
    }

    public DriveId getDriveId() {
        zzsx();
        return this.zzamF;
    }

    public InputStream getModifiedContentsInputStream() {
        zzsx();
        if (this.zzanI == null) {
            return null;
        }
        if (this.zzanN) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzanN = true;
        return new FileInputStream(this.zzanI.getFileDescriptor());
    }

    public MetadataChangeSet getModifiedMetadataChangeSet() {
        zzsx();
        return this.zzanJ != null ? new MetadataChangeSet(this.zzanJ) : null;
    }

    public int getStatus() {
        zzsx();
        return this.zzAk;
    }

    public List<String> getTrackingTags() {
        zzsx();
        return new ArrayList(this.zzanK);
    }

    public int getType() {
        return 2;
    }

    public void snooze() {
        zzv(true);
    }

    public String toString() {
        String str = this.zzanK == null ? "<null>" : "'" + TextUtils.join("','", this.zzanK) + "'";
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[]{this.zzamF, Integer.valueOf(this.zzAk), str});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags | 1);
    }
}
