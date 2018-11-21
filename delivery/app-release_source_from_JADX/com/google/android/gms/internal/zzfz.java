package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

@zzha
public class zzfz extends Handler {
    private final zzfy zzEp;

    public zzfz(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this(new zzga(context));
    }

    public zzfz(zzfy com_google_android_gms_internal_zzfy) {
        this.zzEp = com_google_android_gms_internal_zzfy;
    }

    private void zzc(JSONObject jSONObject) {
        try {
            this.zzEp.zza(jSONObject.getString("request_id"), jSONObject.getString("base_url"), jSONObject.getString("html"));
        } catch (Exception e) {
        }
    }

    public void handleMessage(Message msg) {
        try {
            Bundle data = msg.getData();
            if (data != null) {
                JSONObject jSONObject = new JSONObject(data.getString("data"));
                if ("fetch_html".equals(jSONObject.getString("message_name"))) {
                    zzc(jSONObject);
                }
            }
        } catch (Exception e) {
        }
    }
}
