package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfu;

public class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzfu zzop;

    private void zzaF() {
        if (this.zzop != null) {
            try {
                this.zzop.zzaF();
            } catch (Throwable e) {
                zzb.zzd("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.zzop != null) {
                z = this.zzop.zzfc();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onBackPressed to ad overlay:", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.zzop = zzft.zzb(this);
        if (this.zzop == null) {
            zzb.zzaH("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.zzop.onCreate(savedInstanceState);
        } catch (Throwable e) {
            zzb.zzd("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.zzop != null) {
                this.zzop.onDestroy();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    protected void onPause() {
        try {
            if (this.zzop != null) {
                this.zzop.onPause();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
        try {
            if (this.zzop != null) {
                this.zzop.onRestart();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            if (this.zzop != null) {
                this.zzop.onResume();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        try {
            if (this.zzop != null) {
                this.zzop.onSaveInstanceState(outState);
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(outState);
    }

    protected void onStart() {
        super.onStart();
        try {
            if (this.zzop != null) {
                this.zzop.onStart();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    protected void onStop() {
        try {
            if (this.zzop != null) {
                this.zzop.onStop();
            }
        } catch (Throwable e) {
            zzb.zzd("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        zzaF();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        zzaF();
    }

    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        zzaF();
    }
}
