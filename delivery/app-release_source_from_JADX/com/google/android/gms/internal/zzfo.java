package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.R;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzha
public class zzfo extends zzfr {
    private final Context mContext;
    private final Map<String, String> zzxc;

    class C03112 implements OnClickListener {
        final /* synthetic */ zzfo zzCt;

        C03112(zzfo com_google_android_gms_internal_zzfo) {
            this.zzCt = com_google_android_gms_internal_zzfo;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.zzCt.zzal("User canceled the download.");
        }
    }

    public zzfo(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        super(com_google_android_gms_internal_zzjn, "storePicture");
        this.zzxc = map;
        this.mContext = com_google_android_gms_internal_zzjn.zzhx();
    }

    public void execute() {
        if (this.mContext == null) {
            zzal("Activity context is not available");
        } else if (zzp.zzbx().zzN(this.mContext).zzdf()) {
            final String str = (String) this.zzxc.get("iurl");
            if (TextUtils.isEmpty(str)) {
                zzal("Image url cannot be empty.");
            } else if (URLUtil.isValidUrl(str)) {
                final String zzak = zzak(str);
                if (zzp.zzbx().zzaB(zzak)) {
                    Builder zzM = zzp.zzbx().zzM(this.mContext);
                    zzM.setTitle(zzp.zzbA().zzf(R.string.store_picture_title, "Save image"));
                    zzM.setMessage(zzp.zzbA().zzf(R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
                    zzM.setPositiveButton(zzp.zzbA().zzf(R.string.accept, "Accept"), new OnClickListener(this) {
                        final /* synthetic */ zzfo zzCt;

                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                ((DownloadManager) this.zzCt.mContext.getSystemService("download")).enqueue(this.zzCt.zzf(str, zzak));
                            } catch (IllegalStateException e) {
                                this.zzCt.zzal("Could not store picture.");
                            }
                        }
                    });
                    zzM.setNegativeButton(zzp.zzbA().zzf(R.string.decline, "Decline"), new C03112(this));
                    zzM.create().show();
                    return;
                }
                zzal("Image type not recognized: " + zzak);
            } else {
                zzal("Invalid image url: " + str);
            }
        } else {
            zzal("Feature is not supported by the device.");
        }
    }

    String zzak(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    Request zzf(String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        zzp.zzbz().zza(request);
        return request;
    }
}
