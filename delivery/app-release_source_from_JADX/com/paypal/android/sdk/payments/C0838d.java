package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.paypal.android.sdk.C0510f;
import com.paypal.android.sdk.av;
import com.paypal.android.sdk.bm;
import com.paypal.android.sdk.bp;
import com.paypal.android.sdk.cB;
import com.paypal.android.sdk.cc;
import com.paypal.android.sdk.cg;
import com.paypal.android.sdk.cy;
import com.paypal.android.sdk.cz;

class C0838d implements C0545k {
    private C1175j f1300a;
    private C1174i f1301b;

    public C0838d(PayPalService payPalService) {
        this.f1300a = new C1175j(payPalService);
        this.f1301b = new C1174i(payPalService);
    }

    static AlertDialog m1108a(Activity activity, cB cBVar, cB cBVar2, OnClickListener onClickListener) {
        return new Builder(activity).setIcon(17301543).setTitle(cz.m428a(cBVar)).setMessage(cz.m428a(cBVar2)).setPositiveButton(cz.m428a(cB.OK), onClickListener).setNegativeButton(cz.m428a(cB.CANCEL), null).create();
    }

    private static AlertDialog m1109a(Context context, cB cBVar, String str, OnClickListener onClickListener) {
        CharSequence a = cz.m428a(cBVar);
        return new Builder(context).setMessage(str).setCancelable(false).setTitle(a).setPositiveButton(cz.m428a(cB.OK), onClickListener).create();
    }

    static Dialog m1110a(Activity activity, OnClickListener onClickListener) {
        return new Builder(activity).setIcon(17301543).setCancelable(false).setTitle(cz.m428a(cB.TRY_AGAIN)).setMessage(cz.m428a(cB.SERVER_PROBLEM)).setPositiveButton(cz.m428a(cB.TRY_AGAIN), onClickListener).setNegativeButton(cz.m428a(cB.CANCEL), new C0544g(activity)).create();
    }

    static Dialog m1111a(Activity activity, cB cBVar, Bundle bundle) {
        return C0838d.m1109a((Context) activity, cBVar, bundle.getString("alert_errors"), new C0542e());
    }

    static Dialog m1112a(Activity activity, cB cBVar, Bundle bundle, int i) {
        return C0838d.m1109a((Context) activity, cBVar, bundle.getString("alert_errors"), new C0543f(activity, i));
    }

    static Dialog m1113a(Activity activity, cB cBVar, Bundle bundle, OnClickListener onClickListener) {
        return C0838d.m1109a((Context) activity, cBVar, bundle.getString("alert_errors"), onClickListener);
    }

    static Dialog m1114a(Context context, cB cBVar, cB cBVar2) {
        Dialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(cz.m428a(cBVar));
        progressDialog.setMessage(cz.m428a(cBVar2));
        progressDialog.setCancelable(false);
        return progressDialog;
    }

    public static Object m1115a(bm bmVar) {
        if (bmVar instanceof cc) {
            cc ccVar = (cc) bmVar;
            return new ProofOfPayment(ccVar.m1257w(), ccVar.m1255u(), ccVar.m1258x(), ccVar.m1259y(), ccVar.m1260z());
        } else if (bmVar instanceof cg) {
            cg cgVar = (cg) bmVar;
            return new ProofOfPayment(cgVar.m1281D(), cgVar.m1282E(), cgVar.m1284G(), cgVar.m1283F(), cgVar.m1285H());
        } else {
            throw new RuntimeException("Dev error");
        }
    }

    static void m1116a(Activity activity, TextView textView, cB cBVar) {
        C0510f.m456a(activity, textView, cBVar != null ? cz.m428a(cBVar) : "", "PayPal - ", new BitmapDrawable(activity.getResources(), bp.m298a("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyRpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoTWFjaW50b3NoKSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpCNDMzRTRFQ0M2MjQxMUUzOURBQ0E3QTY0NjU3OUI5QiIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpCNDMzRTRFREM2MjQxMUUzOURBQ0E3QTY0NjU3OUI5QiI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOkI0MzNFNEVBQzYyNDExRTM5REFDQTdBNjQ2NTc5QjlCIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOkI0MzNFNEVCQzYyNDExRTM5REFDQTdBNjQ2NTc5QjlCIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+Eyd0MQAABoFJREFUeNrMWl1M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", (Context) activity, 240)));
    }

    static void m1117a(Activity activity, aI aIVar, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = ((aIVar.f896a == null || aIVar.f896a.intValue() < 500) && !aIVar.m736c()) ? 0 : 1;
        if (i5 != 0) {
            activity.showDialog(2);
            return;
        }
        if (aIVar.m734a() && "invalid_client".equals(aIVar.f897b)) {
            i4 = 1;
        }
        if (i4 != 0) {
            C0838d.m1118a(activity, cz.m428a(cB.UNAUTHORIZED_MERCHANT_MESSAGE), 3);
        } else {
            C0838d.m1118a(activity, cz.m428a(cB.UNAUTHORIZED_DEVICE_MESSAGE), 1);
        }
    }

    static void m1118a(Activity activity, String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("alert_errors", str);
        activity.removeDialog(i);
        activity.showDialog(i, bundle);
    }

    static void m1119a(TextView textView, String str) {
        if (textView == null) {
            return;
        }
        if (str == null || av.m169c(str)) {
            textView.setVisibility(8);
        } else if (av.m168b(str)) {
            textView.setText(cz.m428a(cB.ENVIRONMENT_SANDBOX));
        } else if (av.m167a(str)) {
            textView.setText(cz.m428a(cB.ENVIRONMENT_MOCK_DATA));
        } else {
            textView.setText(str);
        }
    }

    static boolean m1120a(Activity activity) {
        String name = activity.getClass().getName();
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            Log.e("paypal.sdk", name + " called by a null activity, not allowed");
            return false;
        }
        String className = callingActivity.getClassName();
        if (className.startsWith("com.paypal.android.sdk.payments.")) {
            return true;
        }
        Log.e("paypal.sdk", name + " called by " + className + " which is not part of the SDK, not allowed");
        return false;
    }

    static Intent m1121b(Activity activity) {
        Intent intent = new Intent(activity.getApplicationContext(), PayPalService.class);
        intent.putExtra("initializingActivity", activity.getClass().getSimpleName());
        if (activity.getIntent().hasExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION)) {
            intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, activity.getIntent().getParcelableExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION));
        }
        return intent;
    }

    public void mo3785a(cy cyVar, boolean z, String str, String str2, String str3) {
        this.f1300a.mo3785a(cyVar, z, str, str2, null);
        this.f1301b.mo3785a(cyVar, z, str, str2, str3);
    }
}
