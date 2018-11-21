package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.zzu;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.zzg;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String zzank;
    private String[] zzanl;
    private Filter zzanm;
    private DriveId zzann;

    public IntentSender build(GoogleApiClient apiClient) {
        zzx.zza(apiClient.isConnected(), (Object) "Client must be connected");
        if (this.zzanl == null) {
            this.zzanl = new String[0];
        }
        if (this.zzanl.length <= 0 || this.zzanm == null) {
            try {
                return ((zzu) apiClient.zza(Drive.zzTo)).zzsF().zza(new OpenFileIntentSenderRequest(this.zzank, this.zzanl, this.zzann, this.zzanm == null ? null : new FilterHolder(this.zzanm)));
            } catch (Throwable e) {
                throw new RuntimeException("Unable to connect Drive Play Service", e);
            }
        }
        throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.zzann = (DriveId) zzx.zzy(folder);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String title) {
        this.zzank = (String) zzx.zzy(title);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] mimeTypes) {
        zzx.zzb(mimeTypes != null, (Object) "mimeTypes may not be null");
        this.zzanl = mimeTypes;
        return this;
    }

    public OpenFileActivityBuilder setSelectionFilter(Filter filter) {
        boolean z = true;
        zzx.zzb(filter != null, (Object) "filter may not be null");
        if (zzg.zza(filter)) {
            z = false;
        }
        zzx.zzb(z, (Object) "FullTextSearchFilter cannot be used as a selection filter");
        this.zzanm = filter;
        return this;
    }
}
