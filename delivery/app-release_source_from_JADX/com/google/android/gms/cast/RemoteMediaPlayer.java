package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final zzm zzZX = new zzm(this, null) {
        final /* synthetic */ RemoteMediaPlayer zzaad;

        protected void onMetadataUpdated() {
            this.zzaad.onMetadataUpdated();
        }

        protected void onPreloadStatusUpdated() {
            this.zzaad.onPreloadStatusUpdated();
        }

        protected void onQueueStatusUpdated() {
            this.zzaad.onQueueStatusUpdated();
        }

        protected void onStatusUpdated() {
            this.zzaad.onStatusUpdated();
        }
    };
    private final zza zzZY = new zza(this);
    private OnPreloadStatusUpdatedListener zzZZ;
    private OnQueueStatusUpdatedListener zzaaa;
    private OnMetadataUpdatedListener zzaab;
    private OnStatusUpdatedListener zzaac;
    private final Object zzpK = new Object();

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnPreloadStatusUpdatedListener {
        void onPreloadStatusUpdated();
    }

    public interface OnQueueStatusUpdatedListener {
        void onQueueStatusUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    private class zza implements zzn {
        private GoogleApiClient zzaaB;
        private long zzaaC = 0;
        final /* synthetic */ RemoteMediaPlayer zzaad;

        private final class zza implements ResultCallback<Status> {
            private final long zzaaD;
            final /* synthetic */ zza zzaaE;

            zza(zza com_google_android_gms_cast_RemoteMediaPlayer_zza, long j) {
                this.zzaaE = com_google_android_gms_cast_RemoteMediaPlayer_zza;
                this.zzaaD = j;
            }

            public /* synthetic */ void onResult(Result x0) {
                zzp((Status) x0);
            }

            public void zzp(Status status) {
                if (!status.isSuccess()) {
                    this.zzaaE.zzaad.zzZX.zzb(this.zzaaD, status.getStatusCode());
                }
            }
        }

        public zza(RemoteMediaPlayer remoteMediaPlayer) {
            this.zzaad = remoteMediaPlayer;
        }

        public void zza(String str, String str2, long j, String str3) throws IOException {
            if (this.zzaaB == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.zzaaB, str, str2).setResultCallback(new zza(this, j));
        }

        public void zzb(GoogleApiClient googleApiClient) {
            this.zzaaB = googleApiClient;
        }

        public long zzny() {
            long j = this.zzaaC + 1;
            this.zzaaC = j;
            return j;
        }
    }

    private static final class zzc implements MediaChannelResult {
        private final Status zzTA;
        private final JSONObject zzZn;

        zzc(Status status, JSONObject jSONObject) {
            this.zzTA = status;
            this.zzZn = jSONObject;
        }

        public JSONObject getCustomData() {
            return this.zzZn;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static abstract class zzb extends com.google.android.gms.cast.internal.zzb<MediaChannelResult> {
        zzo zzaaF = new C06411(this);

        class C06411 implements zzo {
            final /* synthetic */ zzb zzaaG;

            C06411(zzb com_google_android_gms_cast_RemoteMediaPlayer_zzb) {
                this.zzaaG = com_google_android_gms_cast_RemoteMediaPlayer_zzb;
            }

            public void zza(long j, int i, Object obj) {
                this.zzaaG.zzb(new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
            }

            public void zzy(long j) {
                this.zzaaG.zzb(this.zzaaG.zzq(new Status(2103)));
            }
        }

        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzq(status);
        }

        public MediaChannelResult zzq(final Status status) {
            return new MediaChannelResult(this) {
                final /* synthetic */ zzb zzaaG;

                public JSONObject getCustomData() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public RemoteMediaPlayer() {
        this.zzZX.zza(this.zzZY);
    }

    private void onMetadataUpdated() {
        if (this.zzaab != null) {
            this.zzaab.onMetadataUpdated();
        }
    }

    private void onPreloadStatusUpdated() {
        if (this.zzZZ != null) {
            this.zzZZ.onPreloadStatusUpdated();
        }
    }

    private void onQueueStatusUpdated() {
        if (this.zzaaa != null) {
            this.zzaaa.onQueueStatusUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.zzaac != null) {
            this.zzaac.onStatusUpdated();
        }
    }

    private int zzbf(int i) {
        MediaStatus mediaStatus = getMediaStatus();
        for (int i2 = 0; i2 < mediaStatus.getQueueItemCount(); i2++) {
            if (mediaStatus.getQueueItem(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.zzpK) {
            approximateStreamPosition = this.zzZX.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.zzpK) {
            mediaInfo = this.zzZX.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.zzpK) {
            mediaStatus = this.zzZX.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.zzZX.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.zzpK) {
            streamDuration = this.zzZX.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, customData);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, long[] activeTrackIds, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaInfo mediaInfo2 = mediaInfo;
        final boolean z = autoplay;
        final long j = playPosition;
        final long[] jArr = activeTrackIds;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(googleApiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, mediaInfo2, z, j, jArr, jSONObject);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                        this.zzaad.zzZY.zzb(null);
                    } catch (Throwable th) {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.zzZX.zzbZ(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(apiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, customData);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                        this.zzaad.zzZY.zzb(null);
                    } catch (Throwable th) {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(apiClient);
                    try {
                        this.zzaad.zzZX.zzc(this.zzaaF, customData);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                        this.zzaad.zzZY.zzb(null);
                    } catch (Throwable th) {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueAppendItem(GoogleApiClient apiClient, MediaQueueItem item, JSONObject customData) throws IllegalArgumentException {
        return queueInsertItems(apiClient, new MediaQueueItem[]{item}, 0, customData);
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(GoogleApiClient apiClient, MediaQueueItem item, int insertBeforeItemId, long playPosition, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaQueueItem mediaQueueItem = item;
        final int i = insertBeforeItemId;
        final long j = playPosition;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(googleApiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, new MediaQueueItem[]{mediaQueueItem}, i, 0, 0, j, jSONObject);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                        this.zzaad.zzZY.zzb(null);
                    } catch (Throwable th) {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(GoogleApiClient apiClient, MediaQueueItem item, int insertBeforeItemId, JSONObject customData) {
        return queueInsertAndPlayItem(apiClient, item, insertBeforeItemId, -1, customData);
    }

    public PendingResult<MediaChannelResult> queueInsertItems(GoogleApiClient apiClient, MediaQueueItem[] itemsToInsert, int insertBeforeItemId, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaQueueItem[] mediaQueueItemArr = itemsToInsert;
        final int i = insertBeforeItemId;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(googleApiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, mediaQueueItemArr, i, 0, -1, -1, jSONObject);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                        this.zzaad.zzZY.zzb(null);
                    } catch (Throwable th) {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient apiClient, int itemId, long playPosition, JSONObject customData) {
        final int i = itemId;
        final GoogleApiClient googleApiClient = apiClient;
        final long j = playPosition;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    if (this.zzaad.zzbf(i) == -1) {
                        zzb(zzq(new Status(0)));
                        return;
                    }
                    this.zzaad.zzZY.zzb(googleApiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, i, j, null, 0, null, jSONObject);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                    } finally {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient apiClient, int itemId, JSONObject customData) {
        return queueJumpToItem(apiClient, itemId, -1, customData);
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient apiClient, MediaQueueItem[] items, int startIndex, int repeatMode, long playPosition, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaQueueItem[] mediaQueueItemArr = items;
        final int i = startIndex;
        final int i2 = repeatMode;
        final long j = playPosition;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(googleApiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, mediaQueueItemArr, i, i2, j, jSONObject);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                        this.zzaad.zzZY.zzb(null);
                    } catch (Throwable th) {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient apiClient, MediaQueueItem[] items, int startIndex, int repeatMode, JSONObject customData) throws IllegalArgumentException {
        return queueLoad(apiClient, items, startIndex, repeatMode, -1, customData);
    }

    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(GoogleApiClient apiClient, int itemId, int newIndex, JSONObject customData) {
        final int i = itemId;
        final int i2 = newIndex;
        final GoogleApiClient googleApiClient = apiClient;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                int i = 0;
                synchronized (this.zzaad.zzpK) {
                    int zza = this.zzaad.zzbf(i);
                    if (zza == -1) {
                        zzb(zzq(new Status(0)));
                    } else if (i2 < 0) {
                        zzb(zzq(new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", new Object[]{Integer.valueOf(i2)}))));
                    } else if (zza == i2) {
                        zzb(zzq(new Status(0)));
                    } else {
                        MediaQueueItem queueItem = this.zzaad.getMediaStatus().getQueueItem(i2 > zza ? i2 + 1 : i2);
                        if (queueItem != null) {
                            i = queueItem.getItemId();
                        }
                        this.zzaad.zzZY.zzb(googleApiClient);
                        try {
                            this.zzaad.zzZX.zza(this.zzaaF, new int[]{i}, i, jSONObject);
                        } catch (IOException e) {
                            zzb(zzq(new Status(2100)));
                        } finally {
                            this.zzaad.zzZY.zzb(null);
                        }
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueNext(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(apiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, 0, -1, null, 1, null, customData);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                        this.zzaad.zzZY.zzb(null);
                    } catch (Throwable th) {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queuePrev(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(apiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, 0, -1, null, -1, null, customData);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                        this.zzaad.zzZY.zzb(null);
                    } catch (Throwable th) {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItem(GoogleApiClient apiClient, int itemId, JSONObject customData) {
        final int i = itemId;
        final GoogleApiClient googleApiClient = apiClient;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    if (this.zzaad.zzbf(i) == -1) {
                        zzb(zzq(new Status(0)));
                        return;
                    }
                    this.zzaad.zzZY.zzb(googleApiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, new int[]{i}, jSONObject);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                    } finally {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItems(GoogleApiClient apiClient, int[] itemIdsToRemove, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final int[] iArr = itemIdsToRemove;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(googleApiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, iArr, jSONObject);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                        this.zzaad.zzZY.zzb(null);
                    } catch (Throwable th) {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueReorderItems(GoogleApiClient apiClient, int[] itemIdsToReorder, int insertBeforeItemId, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final int[] iArr = itemIdsToReorder;
        final int i = insertBeforeItemId;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(googleApiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, iArr, i, jSONObject);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                        this.zzaad.zzZY.zzb(null);
                    } catch (Throwable th) {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueSetRepeatMode(GoogleApiClient apiClient, int repeatMode, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final int i = repeatMode;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(googleApiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, 0, -1, null, 0, Integer.valueOf(i), jSONObject);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                        this.zzaad.zzZY.zzb(null);
                    } catch (Throwable th) {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueUpdateItems(GoogleApiClient apiClient, MediaQueueItem[] itemsToUpdate, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaQueueItem[] mediaQueueItemArr = itemsToUpdate;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(googleApiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, 0, -1, mediaQueueItemArr, 0, null, jSONObject);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                        this.zzaad.zzZY.zzb(null);
                    } catch (Throwable th) {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient apiClient) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(apiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                        this.zzaad.zzZY.zzb(null);
                    } catch (Throwable th) {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, 0, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final long j = position;
        final int i = resumeState;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(googleApiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, j, i, jSONObject);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                        this.zzaad.zzZY.zzb(null);
                    } catch (Throwable th) {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient apiClient, final long[] trackIds) {
        if (trackIds != null) {
            return apiClient.zzb(new zzb(this, apiClient) {
                final /* synthetic */ RemoteMediaPlayer zzaad;

                protected void zza(zze com_google_android_gms_cast_internal_zze) {
                    synchronized (this.zzaad.zzpK) {
                        this.zzaad.zzZY.zzb(apiClient);
                        try {
                            this.zzaad.zzZX.zza(this.zzaaF, trackIds);
                            this.zzaad.zzZY.zzb(null);
                        } catch (IOException e) {
                            zzb(zzq(new Status(2100)));
                            this.zzaad.zzZY.zzb(null);
                        } catch (Throwable th) {
                            this.zzaad.zzZY.zzb(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackIds cannot be null");
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.zzaab = listener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener listener) {
        this.zzZZ = listener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener listener) {
        this.zzaaa = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.zzaac = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final boolean z = muteState;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(googleApiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, z, jSONObject);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IllegalStateException e) {
                        try {
                            zzb(zzq(new Status(2100)));
                        } finally {
                            this.zzaad.zzZY.zzb(null);
                        }
                    } catch (IOException e2) {
                        zzb(zzq(new Status(2100)));
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (Double.isInfinite(volume) || Double.isNaN(volume)) {
            throw new IllegalArgumentException("Volume cannot be " + volume);
        }
        final GoogleApiClient googleApiClient = apiClient;
        final double d = volume;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(googleApiClient);
                    try {
                        this.zzaad.zzZX.zza(this.zzaaF, d, jSONObject);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IllegalStateException e) {
                        try {
                            zzb(zzq(new Status(2100)));
                        } finally {
                            this.zzaad.zzZY.zzb(null);
                        }
                    } catch (IllegalArgumentException e2) {
                        zzb(zzq(new Status(2100)));
                    } catch (IOException e3) {
                        zzb(zzq(new Status(2100)));
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient apiClient, final TextTrackStyle trackStyle) {
        if (trackStyle != null) {
            return apiClient.zzb(new zzb(this, apiClient) {
                final /* synthetic */ RemoteMediaPlayer zzaad;

                protected void zza(zze com_google_android_gms_cast_internal_zze) {
                    synchronized (this.zzaad.zzpK) {
                        this.zzaad.zzZY.zzb(apiClient);
                        try {
                            this.zzaad.zzZX.zza(this.zzaaF, trackStyle);
                            this.zzaad.zzZY.zzb(null);
                        } catch (IOException e) {
                            zzb(zzq(new Status(2100)));
                            this.zzaad.zzZY.zzb(null);
                        } catch (Throwable th) {
                            this.zzaad.zzZY.zzb(null);
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(this, apiClient) {
            final /* synthetic */ RemoteMediaPlayer zzaad;

            protected void zza(zze com_google_android_gms_cast_internal_zze) {
                synchronized (this.zzaad.zzpK) {
                    this.zzaad.zzZY.zzb(apiClient);
                    try {
                        this.zzaad.zzZX.zzb(this.zzaaF, customData);
                        this.zzaad.zzZY.zzb(null);
                    } catch (IOException e) {
                        zzb(zzq(new Status(2100)));
                        this.zzaad.zzZY.zzb(null);
                    } catch (Throwable th) {
                        this.zzaad.zzZY.zzb(null);
                    }
                }
            }
        });
    }
}
