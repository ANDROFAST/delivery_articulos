package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {

    class C04151 implements OnClickListener {
        final /* synthetic */ PreviewActivity zzbeI;

        C04151(PreviewActivity previewActivity) {
            this.zzbeI = previewActivity;
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    private void zzk(String str, String str2, String str3) {
        AlertDialog create = new Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new C04151(this));
        create.show();
    }

    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            zzbg.zzaG("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.getInstance(this).zzp(data)) {
                String str = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                zzbg.zzaH(str);
                zzk("Preview failure", str, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                zzbg.zzaG("Invoke the launch activity for package name: " + getPackageName());
                startActivity(launchIntentForPackage);
                return;
            }
            zzbg.zzaG("No launch activity found for package name: " + getPackageName());
        } catch (Exception e) {
            zzbg.m9e("Calling preview threw an exception: " + e.getMessage());
        }
    }
}
