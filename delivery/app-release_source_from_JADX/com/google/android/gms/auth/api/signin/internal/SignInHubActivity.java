package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzlf;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SignInHubActivity extends FragmentActivity {
    private zzn zzWm;
    private zzj zzWn;
    private SignInConfiguration zzWo;
    private boolean zzWp;
    private String zzWq;
    private boolean zzWr;
    private int zzWs;
    private Intent zzWt;

    class C06341 implements com.google.android.gms.internal.zzld.zza {
        final /* synthetic */ SignInHubActivity zzWu;

        C06341(SignInHubActivity signInHubActivity) {
            this.zzWu = signInHubActivity;
        }

        public void zza(Exception exception) {
            String str = (exception == null || exception.getMessage() == null) ? "" : " " + exception.getMessage();
            Log.w("AuthSignInClient", "Idp signin failed!" + str);
            this.zzWu.zzaR(4);
        }

        public void zzk(Intent intent) {
            if (intent != null) {
                this.zzWu.zzj(intent);
                return;
            }
            Log.w("AuthSignInClient", "Idp signin failed!");
            this.zzWu.zzaR(4);
        }

        public void zzmV() {
            this.zzWu.setResult(0);
            this.zzWu.finish();
        }
    }

    private class zza implements LoaderCallbacks<Void> {
        final /* synthetic */ SignInHubActivity zzWu;

        private zza(SignInHubActivity signInHubActivity) {
            this.zzWu = signInHubActivity;
        }

        public Loader<Void> onCreateLoader(int i, Bundle bundle) {
            return new zzb(this.zzWu, GoogleApiClient.zzoE());
        }

        public /* synthetic */ void onLoadFinished(Loader x0, Object x1) {
            zza(x0, (Void) x1);
        }

        public void onLoaderReset(Loader<Void> loader) {
        }

        public void zza(Loader<Void> loader, Void voidR) {
            this.zzWu.setResult(this.zzWu.zzWs, this.zzWu.zzWt);
            this.zzWu.finish();
        }
    }

    private void zza(int i, int i2, Intent intent) {
        for (zzld zza : this.zzWn.zzmO()) {
            if (zza.zza(i, i2, intent, zzmU())) {
                break;
            }
        }
        if (i2 == 0) {
            finish();
        }
    }

    private void zza(int i, Intent intent) {
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.zzmD() != null) {
                GoogleSignInAccount zzmD = signInAccount.zzmD();
                this.zzWm.zzb(zzmD, this.zzWo.zzmR());
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", zzmD);
                this.zzWr = true;
                this.zzWs = i;
                this.zzWt = intent;
                zzd(i, intent);
                return;
            } else if (intent.hasExtra("errorCode")) {
                zzaS(intent.getIntExtra("errorCode", 8));
                return;
            }
        }
        zzaS(8);
    }

    private void zzaR(int i) {
        Intent intent = new Intent();
        intent.putExtra("errorCode", i);
        setResult(0, intent);
        finish();
    }

    private void zzaS(int i) {
        Parcelable status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
    }

    private void zzb(int i, Intent intent) {
        if (i == -1) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null) {
                this.zzWm.zzb(signInAccount, this.zzWo);
                setResult(-1, intent);
                finish();
                return;
            }
            Log.w("AuthSignInClient", "[SignInHubActivity] SignInAccount is null.");
            zzaR(2);
        } else if (intent == null) {
            finish();
        } else {
            Object stringExtra = intent.getStringExtra("email");
            zze zzbI = zze.zzbI(intent.getStringExtra("idProvider"));
            if (zzbI == null) {
                setResult(i, intent);
                finish();
                return;
            }
            this.zzWq = intent.getStringExtra("pendingToken");
            Intent zzmt = this.zzWo.zzmS().zzmt();
            if (!zze.FACEBOOK.equals(zzbI) || this.zzWo.zzmS() == null || zzmt == null) {
                zzld zza = this.zzWn.zza(zzbI);
                if (zza == null) {
                    Log.w("AuthSignInClient", zzbI.zzad(this) + " is not supported. Please check your configuration");
                    zzaR(1);
                    return;
                }
                int intExtra = intent.getIntExtra("userProfile", -1);
                if (intExtra == 0) {
                    if (TextUtils.isEmpty(stringExtra)) {
                        zza.zza(zzmU());
                        return;
                    } else {
                        zza.zza(stringExtra, zzmU());
                        return;
                    }
                } else if (intExtra != 1 || TextUtils.isEmpty(this.zzWq) || TextUtils.isEmpty(stringExtra)) {
                    Log.w("AuthSignInClient", "Internal error!");
                    zzaR(2);
                    return;
                } else {
                    zza.zza(stringExtra, this.zzWq, zzmU());
                    return;
                }
            }
            startActivityForResult(zzmt, 45057);
        }
    }

    private void zzc(int i, Intent intent) {
        if (i == 0) {
            setResult(0, intent);
            finish();
            return;
        }
        Intent intent2 = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
        intent2.putExtra("idpTokenType", IdpTokenType.zzWc);
        intent2.putExtra("idpToken", intent.getStringExtra("idpToken"));
        intent2.putExtra("pendingToken", this.zzWq);
        intent2.putExtra("idProvider", zze.FACEBOOK.zzmC());
        zzj(intent2);
    }

    private void zzd(int i, Intent intent) {
        getSupportLoaderManager().initLoader(0, null, new zza());
    }

    private void zzj(Intent intent) {
        intent.setPackage("com.google.android.gms");
        intent.putExtra("config", this.zzWo);
        try {
            startActivityForResult(intent, this.zzWp ? 40962 : 40961);
        } catch (ActivityNotFoundException e) {
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            if (this.zzWp) {
                zzaS(8);
            } else {
                zzaR(2);
            }
        }
    }

    private com.google.android.gms.internal.zzld.zza zzmU() {
        return new C06341(this);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        setResult(0);
        switch (requestCode) {
            case 40961:
                zzb(resultCode, data);
                return;
            case 40962:
                zza(resultCode, data);
                return;
            case 45057:
                zzc(resultCode, data);
                return;
            default:
                zza(requestCode, resultCode, data);
                return;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        int i = 0;
        super.onCreate(savedInstanceState);
        this.zzWm = zzn.zzae(this);
        this.zzWo = (SignInConfiguration) getIntent().getParcelableExtra("config");
        this.zzWp = "com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(getIntent().getAction());
        if (this.zzWo == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        zzlf com_google_android_gms_internal_zzlf;
        List linkedList = new LinkedList();
        Map hashMap = new HashMap();
        zzh.zza(this.zzWo, linkedList, hashMap);
        this.zzWn = new zzj(this, linkedList, hashMap);
        if (this.zzWo.zzmS() != null) {
            zzlf com_google_android_gms_internal_zzlf2 = (zzlf) this.zzWn.zza(zze.FACEBOOK);
            com_google_android_gms_internal_zzlf2.zzaf(this);
            if (this.zzWo.zzmQ() == null && this.zzWo.zzmR() == null) {
                i = 1;
                com_google_android_gms_internal_zzlf = com_google_android_gms_internal_zzlf2;
            } else {
                com_google_android_gms_internal_zzlf = com_google_android_gms_internal_zzlf2;
            }
        } else {
            com_google_android_gms_internal_zzlf = null;
        }
        if (savedInstanceState == null) {
            Intent intent;
            if (this.zzWp) {
                intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
            } else {
                intent = new Intent("com.google.android.gms.auth.LOGIN_PICKER");
                if ("com.google.android.gms.auth.RESOLVE_CREDENTIAL".equals(getIntent().getAction())) {
                    intent.fillIn(getIntent(), 3);
                } else {
                    this.zzWm.zzmY();
                    if (com_google_android_gms_internal_zzlf != null) {
                        try {
                            zzlf.zzag(this);
                        } catch (IllegalStateException e) {
                        }
                    }
                }
            }
            if (i != 0) {
                com_google_android_gms_internal_zzlf.zza(zzmU());
                return;
            } else {
                zzj(intent);
                return;
            }
        }
        this.zzWq = savedInstanceState.getString("pendingToken");
        this.zzWr = savedInstanceState.getBoolean("signingInGoogleApiClients");
        if (this.zzWr) {
            this.zzWs = savedInstanceState.getInt("signInResultCode");
            this.zzWt = (Intent) savedInstanceState.getParcelable("signInResultData");
            zzd(this.zzWs, this.zzWt);
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("pendingToken", this.zzWq);
        outState.putBoolean("signingInGoogleApiClients", this.zzWr);
        if (this.zzWr) {
            outState.putInt("signInResultCode", this.zzWs);
            outState.putParcelable("signInResultData", this.zzWt);
        }
    }
}
