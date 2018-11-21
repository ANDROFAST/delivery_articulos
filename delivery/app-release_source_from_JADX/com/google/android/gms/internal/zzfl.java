package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.R;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;

@zzha
public class zzfl extends zzfr {
    private final Context mContext;
    private String zzBU;
    private long zzBV;
    private long zzBW;
    private String zzBX;
    private String zzBY;
    private final Map<String, String> zzxc;

    class C03071 implements OnClickListener {
        final /* synthetic */ zzfl zzBZ;

        C03071(zzfl com_google_android_gms_internal_zzfl) {
            this.zzBZ = com_google_android_gms_internal_zzfl;
        }

        public void onClick(DialogInterface dialog, int which) {
            zzp.zzbx().zzb(this.zzBZ.mContext, this.zzBZ.createIntent());
        }
    }

    class C03082 implements OnClickListener {
        final /* synthetic */ zzfl zzBZ;

        C03082(zzfl com_google_android_gms_internal_zzfl) {
            this.zzBZ = com_google_android_gms_internal_zzfl;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.zzBZ.zzal("Operation denied by user.");
        }
    }

    public zzfl(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        super(com_google_android_gms_internal_zzjn, "createCalendarEvent");
        this.zzxc = map;
        this.mContext = com_google_android_gms_internal_zzjn.zzhx();
        zzez();
    }

    private String zzai(String str) {
        return TextUtils.isEmpty((CharSequence) this.zzxc.get(str)) ? "" : (String) this.zzxc.get(str);
    }

    private long zzaj(String str) {
        String str2 = (String) this.zzxc.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void zzez() {
        this.zzBU = zzai(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        this.zzBX = zzai("summary");
        this.zzBV = zzaj("start_ticks");
        this.zzBW = zzaj("end_ticks");
        this.zzBY = zzai("location");
    }

    Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.zzBU);
        data.putExtra("eventLocation", this.zzBY);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzBX);
        if (this.zzBV > -1) {
            data.putExtra("beginTime", this.zzBV);
        }
        if (this.zzBW > -1) {
            data.putExtra("endTime", this.zzBW);
        }
        data.setFlags(DriveFile.MODE_READ_ONLY);
        return data;
    }

    public void execute() {
        if (this.mContext == null) {
            zzal("Activity context is not available.");
        } else if (zzp.zzbx().zzN(this.mContext).zzdi()) {
            Builder zzM = zzp.zzbx().zzM(this.mContext);
            zzM.setTitle(zzp.zzbA().zzf(R.string.create_calendar_title, "Create calendar event"));
            zzM.setMessage(zzp.zzbA().zzf(R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
            zzM.setPositiveButton(zzp.zzbA().zzf(R.string.accept, "Accept"), new C03071(this));
            zzM.setNegativeButton(zzp.zzbA().zzf(R.string.decline, "Decline"), new C03082(this));
            zzM.create().show();
        } else {
            zzal("This feature is not available on the device.");
        }
    }
}
