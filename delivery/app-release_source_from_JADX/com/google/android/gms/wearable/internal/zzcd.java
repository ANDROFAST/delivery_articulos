package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

final class zzcd {

    static abstract class zzb<T> extends zza {
        private com.google.android.gms.internal.zzlx.zzb<T> zzTf;

        public zzb(com.google.android.gms.internal.zzlx.zzb<T> com_google_android_gms_internal_zzlx_zzb_T) {
            this.zzTf = com_google_android_gms_internal_zzlx_zzb_T;
        }

        public void zzX(T t) {
            com.google.android.gms.internal.zzlx.zzb com_google_android_gms_internal_zzlx_zzb = this.zzTf;
            if (com_google_android_gms_internal_zzlx_zzb != null) {
                com_google_android_gms_internal_zzlx_zzb.zzr(t);
                this.zzTf = null;
            }
        }
    }

    static final class zzo extends zza {
        zzo() {
        }

        public void zza(Status status) {
        }
    }

    static final class zza extends zzb<AddLocalCapabilityResult> {
        public zza(com.google.android.gms.internal.zzlx.zzb<AddLocalCapabilityResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_CapabilityApi_AddLocalCapabilityResult) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_CapabilityApi_AddLocalCapabilityResult);
        }

        public void zza(AddLocalCapabilityResponse addLocalCapabilityResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzj.zza(zzbz.zzfU(addLocalCapabilityResponse.statusCode)));
        }
    }

    static final class zzc extends zzb<Status> {
        public zzc(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(CloseChannelResponse closeChannelResponse) {
            zzX(new Status(closeChannelResponse.statusCode));
        }
    }

    static final class zzd extends zzb<Status> {
        public zzd(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
        }

        public void zzb(CloseChannelResponse closeChannelResponse) {
            zzX(new Status(closeChannelResponse.statusCode));
        }
    }

    static final class zze extends zzb<DeleteDataItemsResult> {
        public zze(com.google.android.gms.internal.zzlx.zzb<DeleteDataItemsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_DataApi_DeleteDataItemsResult) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_DataApi_DeleteDataItemsResult);
        }

        public void zza(DeleteDataItemsResponse deleteDataItemsResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzx.zzb(zzbz.zzfU(deleteDataItemsResponse.statusCode), deleteDataItemsResponse.zzbnu));
        }
    }

    static final class zzf extends zzb<GetAllCapabilitiesResult> {
        public zzf(com.google.android.gms.internal.zzlx.zzb<GetAllCapabilitiesResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_CapabilityApi_GetAllCapabilitiesResult) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_CapabilityApi_GetAllCapabilitiesResult);
        }

        public void zza(GetAllCapabilitiesResponse getAllCapabilitiesResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzj.zzd(zzbz.zzfU(getAllCapabilitiesResponse.statusCode), zzcd.zzD(getAllCapabilitiesResponse.zzbnw)));
        }
    }

    static final class zzg extends zzb<GetCapabilityResult> {
        public zzg(com.google.android.gms.internal.zzlx.zzb<GetCapabilityResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_CapabilityApi_GetCapabilityResult) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_CapabilityApi_GetCapabilityResult);
        }

        public void zza(GetCapabilityResponse getCapabilityResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzj.zze(zzbz.zzfU(getCapabilityResponse.statusCode), new com.google.android.gms.wearable.internal.zzj.zzc(getCapabilityResponse.zzbnx)));
        }
    }

    static final class zzh extends zzb<GetInputStreamResult> {
        private final zzt zzboI;

        public zzh(com.google.android.gms.internal.zzlx.zzb<GetInputStreamResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_Channel_GetInputStreamResult, zzt com_google_android_gms_wearable_internal_zzt) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_Channel_GetInputStreamResult);
            this.zzboI = (zzt) zzx.zzy(com_google_android_gms_wearable_internal_zzt);
        }

        public void zza(GetChannelInputStreamResponse getChannelInputStreamResponse) {
            InputStream inputStream = null;
            if (getChannelInputStreamResponse.zzbny != null) {
                inputStream = new zzp(new AutoCloseInputStream(getChannelInputStreamResponse.zzbny));
                this.zzboI.zza(inputStream.zzGL());
            }
            zzX(new zza(new Status(getChannelInputStreamResponse.statusCode), inputStream));
        }
    }

    static final class zzi extends zzb<GetOutputStreamResult> {
        private final zzt zzboI;

        public zzi(com.google.android.gms.internal.zzlx.zzb<GetOutputStreamResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_Channel_GetOutputStreamResult, zzt com_google_android_gms_wearable_internal_zzt) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_Channel_GetOutputStreamResult);
            this.zzboI = (zzt) zzx.zzy(com_google_android_gms_wearable_internal_zzt);
        }

        public void zza(GetChannelOutputStreamResponse getChannelOutputStreamResponse) {
            OutputStream outputStream = null;
            if (getChannelOutputStreamResponse.zzbny != null) {
                outputStream = new zzq(new AutoCloseOutputStream(getChannelOutputStreamResponse.zzbny));
                this.zzboI.zza(outputStream.zzGL());
            }
            zzX(new zzb(new Status(getChannelOutputStreamResponse.statusCode), outputStream));
        }
    }

    static final class zzj extends zzb<GetConnectedNodesResult> {
        public zzj(com.google.android.gms.internal.zzlx.zzb<GetConnectedNodesResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_NodeApi_GetConnectedNodesResult) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_NodeApi_GetConnectedNodesResult);
        }

        public void zza(GetConnectedNodesResponse getConnectedNodesResponse) {
            List arrayList = new ArrayList();
            arrayList.addAll(getConnectedNodesResponse.zzbnE);
            zzX(new com.google.android.gms.wearable.internal.zzbo.zza(zzbz.zzfU(getConnectedNodesResponse.statusCode), arrayList));
        }
    }

    static final class zzk extends zzb<DataItemResult> {
        public zzk(com.google.android.gms.internal.zzlx.zzb<DataItemResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_DataApi_DataItemResult) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_DataApi_DataItemResult);
        }

        public void zza(GetDataItemResponse getDataItemResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzx.zza(zzbz.zzfU(getDataItemResponse.statusCode), getDataItemResponse.zzbnF));
        }
    }

    static final class zzl extends zzb<DataItemBuffer> {
        public zzl(com.google.android.gms.internal.zzlx.zzb<DataItemBuffer> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_DataItemBuffer) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_DataItemBuffer);
        }

        public void zzah(DataHolder dataHolder) {
            zzX(new DataItemBuffer(dataHolder));
        }
    }

    static final class zzm extends zzb<GetFdForAssetResult> {
        public zzm(com.google.android.gms.internal.zzlx.zzb<GetFdForAssetResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_DataApi_GetFdForAssetResult);
        }

        public void zza(GetFdForAssetResponse getFdForAssetResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzx.zzc(zzbz.zzfU(getFdForAssetResponse.statusCode), getFdForAssetResponse.zzbnG));
        }
    }

    static final class zzn extends zzb<GetLocalNodeResult> {
        public zzn(com.google.android.gms.internal.zzlx.zzb<GetLocalNodeResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_NodeApi_GetLocalNodeResult) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_NodeApi_GetLocalNodeResult);
        }

        public void zza(GetLocalNodeResponse getLocalNodeResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzbo.zzb(zzbz.zzfU(getLocalNodeResponse.statusCode), getLocalNodeResponse.zzbnI));
        }
    }

    static final class zzp extends zzb<OpenChannelResult> {
        public zzp(com.google.android.gms.internal.zzlx.zzb<OpenChannelResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_ChannelApi_OpenChannelResult) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_ChannelApi_OpenChannelResult);
        }

        public void zza(OpenChannelResponse openChannelResponse) {
            zzX(new zza(zzbz.zzfU(openChannelResponse.statusCode), openChannelResponse.zzbmX));
        }
    }

    static final class zzq extends zzb<DataItemResult> {
        private final List<FutureTask<Boolean>> zzzm;

        zzq(com.google.android.gms.internal.zzlx.zzb<DataItemResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_DataApi_DataItemResult, List<FutureTask<Boolean>> list) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_DataApi_DataItemResult);
            this.zzzm = list;
        }

        public void zza(PutDataResponse putDataResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzx.zza(zzbz.zzfU(putDataResponse.statusCode), putDataResponse.zzbnF));
            if (putDataResponse.statusCode != 0) {
                for (FutureTask cancel : this.zzzm) {
                    cancel.cancel(true);
                }
            }
        }
    }

    static final class zzr extends zzb<Status> {
        public zzr(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(ChannelSendFileResponse channelSendFileResponse) {
            zzX(new Status(channelSendFileResponse.statusCode));
        }
    }

    static final class zzs extends zzb<RemoveLocalCapabilityResult> {
        public zzs(com.google.android.gms.internal.zzlx.zzb<RemoveLocalCapabilityResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_CapabilityApi_RemoveLocalCapabilityResult) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_CapabilityApi_RemoveLocalCapabilityResult);
        }

        public void zza(RemoveLocalCapabilityResponse removeLocalCapabilityResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzj.zza(zzbz.zzfU(removeLocalCapabilityResponse.statusCode)));
        }
    }

    static final class zzt extends zzb<SendMessageResult> {
        public zzt(com.google.android.gms.internal.zzlx.zzb<SendMessageResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_MessageApi_SendMessageResult) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_wearable_MessageApi_SendMessageResult);
        }

        public void zza(SendMessageResponse sendMessageResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzbm.zzb(zzbz.zzfU(sendMessageResponse.statusCode), sendMessageResponse.zzaKw));
        }
    }

    static final class zzu extends zzb<Status> {
        public zzu(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(ChannelReceiveFileResponse channelReceiveFileResponse) {
            zzX(new Status(channelReceiveFileResponse.statusCode));
        }
    }

    private static Map<String, CapabilityInfo> zzD(List<CapabilityInfoParcelable> list) {
        Map hashMap = new HashMap(list.size() * 2);
        for (CapabilityInfoParcelable capabilityInfoParcelable : list) {
            hashMap.put(capabilityInfoParcelable.getName(), new com.google.android.gms.wearable.internal.zzj.zzc(capabilityInfoParcelable));
        }
        return hashMap;
    }
}
