package com.paypal.android.sdk;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import io.card.payment.CardType;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class C0510f {
    private String f671a;
    private String f672b;

    public static Bitmap m449a(Activity activity, CardType cardType) {
        Bitmap imageBitmap = cardType.imageBitmap(activity);
        return imageBitmap == null ? bp.m325c("iVBORw0KGgoAAAANSUhEUgAAAFUAAAA5CAYAAABHw2d7AAAACXBIWXMAAAsTAAALEwEAmpwYAAAKT2lDQ1BQaG90b3Nob3AgSUNDIHByb2ZpbGUAAHjanVNnVFPpFj333vRCS4iAlEtvUhUIIFJCi4AUkSYqIQkQSoghodkVUcERRUUEG8igiAOOjoCMFVEsDIoK2AfkIaKOg6OIisr74Xuja9a89+bN/rXXPues852zzwfACAyWSDNRNYAMqUIeEeCDx8TG4eQuQIEKJHAAEAizZCFz/SMBAPh+PDwrIsAHvgABeNMLCADATZvAMByH/w/qQplcAYCEAcB0kThLCIAUAEB6jkKmAEBGAYCdmCZTAKAEAGDLY2LjAFAtAGAnf+bTAICd+Jl7AQBblCEVAaCRACATZYhEAGg7AKzPVopFAFgwABRmS8Q5ANgtADBJV2ZIALC3AMDOEAuyAAgMADBRiIUpAAR7AGDIIyN4AISZABRG8lc88SuuEOcqAAB4mbI8uSQ5RYFbCC1xB1dXLh4ozkkXKxQ2YQJhmkAuwnmZGTKBNA/g88wAAKCRFRHgg/P9eM4Ors7ONo62Dl8t6r8G/yJiYuP+5c+rcEAAAOF0ftH+LC+zGoA7BoBt/qIl7gRoXgugdfeLZrIPQLUAoOnaV/Nw+H48PEWhkLnZ2eXk5NhKxEJbYcpXff5nwl/AV/1s+X48/Pf14L7iJIEyXYFHBPjgwsz0TKUcz5IJhGLc5o9H/LcL//wd0yLESWK5WCoU41EScY5EmozzMqUiiUKSKcUl0v9k4t8s+wM+3zUAsGo+AXuRLahdYwP2SycQWHTA4vcAAPK7b8HUKAgDgGiD4c93/+8//UegJQCAZkmScQAAXkQkLlTKsz/HCAAARKCBKrBBG/TBGCzABhzBBdzBC/xgNoRCJMTCQhBCCmSAHHJgKayCQiiGzbAdKmAv1EAdNMBRaIaTcA4uwlW4Dj1wD/phCJ7BKLyBCQRByAgTYSHaiAFiilgjjggXmYX4IcFIBBKLJCDJiBRRIkuRNUgxUopUIFVIHfI9cgI5h1xGupE7yAAygvyGvEcxlIGyUT3UDLVDuag3GoRGogvQZHQxmo8WoJvQcrQaPYw2oefQq2gP2o8+Q8cwwOgYBzPEbDAuxsNCsTgsCZNjy7EirAyrxhqwVqwDu4n1Y8+xdwQSgUXACTYEd0IgYR5BSFhMWE7YSKggHCQ0EdoJNwkDhFHCJyKTqEu0JroR+cQYYjIxh1hILCPWEo8TLxB7iEPENyQSiUMyJ7mQAkmxpFTSEtJG0m5SI+ksqZs0SBojk8naZGuyBzmULCAryIXkneTD5DPkG+Qh8lsKnWJAcaT4U+IoUspqShnlEOU05QZlmDJBVaOaUt2ooVQRNY9aQq2htlKvUYeoEzR1mjnNgxZJS6WtopXTGmgXaPdpr+h0uhHdlR5Ol9BX0svpR+iX6AP0dwwNhhWDx4hnKBmbGAcYZxl3GK+YTKYZ04sZx1QwNzHrmOeZD5lvVVgqtip8FZHKCpVKlSaVGyovVKmqpqreqgtV81XLVI+pXlN9rkZVM1PjqQnUlqtVqp1Q61MbU2epO6iHqmeob1Q/pH5Z/YkGWcNMw09DpFGgsV/jvMYgC2MZs3gsIWsNq4Z1gTXEJrHN2Xx2KruY/R27iz2qqaE5QzNKM1ezUvOUZj8H45hx+Jx0TgnnKKeX836K3hTvKeIpG6Y0TLkxZVxrqpaXllirSKtRq0frvTau7aedpr1Fu1n7gQ5Bx0onXCdHZ4/OBZ3nU9lT3acKpxZNPTr1ri6qa6UbobtEd79up+6Ynr5egJ5Mb6feeb3n+hx9L/1U/W36p/VHDFgGswwkBtsMzhg8xTVxbzwdL8fb8VFDXcNAQ6VhlWGX4YSRudE8o9VGjUYPjGnGXOMk423GbcajJgYmISZLTepN7ppSTbmmKaY7TDtMx83MzaLN1pk1mz0x1zLnm+eb15vft2BaeFostqi2uGVJsuRaplnutrxuhVo5WaVYVVpds0atna0l1rutu6cRp7lOk06rntZnw7Dxtsm2qbcZsOXYBtuutm22fWFnYhdnt8Wuw+6TvZN9un2N/T0HDYfZDqsdWh1+c7RyFDpWOt6azpzuP33F9JbpL2dYzxDP2DPjthPLKcRpnVOb00dnF2e5c4PziIuJS4LLLpc+Lpsbxt3IveRKdPVxXeF60vWdm7Obwu2o26/uNu5p7ofcn8w0nymeWTNz0MPIQ+BR5dE/C5+VMGvfrH5PQ0+BZ7XnIy9jL5FXrdewt6V3qvdh7xc+9j5yn+M+4zw33jLeWV/MN8C3yLfLT8Nvnl+F30N/I/9k/3r/0QCngCUBZwOJgUGBWwL7+Hp8Ib+OPzrbZfay2e1BjKC5QRVBj4KtguXBrSFoyOyQrSH355jOkc5pDoVQfujW0Adh5mGLw34MJ4WHhVeGP45wiFga0TGXNXfR3ENz30T6RJZE3ptnMU85ry1KNSo+qi5qPNo3ujS6P8YuZlnM1VidWElsSxw5LiquNm5svt/87fOH4p3iC+N7F5gvyF1weaHOwvSFpxapLhIsOpZATIhOOJTwQRAqqBaMJfITdyWOCnnCHcJnIi/RNtGI2ENcKh5O8kgqTXqS7JG8NXkkxTOlLOW5hCepkLxMDUzdmzqeFpp2IG0yPTq9MYOSkZBxQqohTZO2Z+pn5mZ2y6xlhbL+xW6Lty8elQfJa7OQrAVZLQq2QqboVFoo1yoHsmdlV2a/zYnKOZarnivN7cyzytuQN5zvn//tEsIS4ZK2pYZLVy0dWOa9rGo5sjxxedsK4xUFK4ZWBqw8uIq2Km3VT6vtV5eufr0mek1rgV7ByoLBtQFr6wtVCuWFfevc1+1dT1gvWd+1YfqGnRs+FYmKrhTbF5cVf9go3HjlG4dvyr+Z3JS0qavEuWTPZtJm6ebeLZ5bDpaql+aXDm4N2dq0Dd9WtO319kXbL5fNKNu7g7ZDuaO/PLi8ZafJzs07P1SkVPRU+lQ27tLdtWHX+G7R7ht7vPY07NXbW7z3/T7JvttVAVVN1WbVZftJ+7P3P66Jqun4lvttXa1ObXHtxwPSA/0HIw6217nU1R3SPVRSj9Yr60cOxx++/p3vdy0NNg1VjZzG4iNwRHnk6fcJ3/ceDTradox7rOEH0x92HWcdL2pCmvKaRptTmvtbYlu6T8w+0dbq3nr8R9sfD5w0PFl5SvNUyWna6YLTk2fyz4ydlZ19fi753GDborZ752PO32oPb++6EHTh0kX/i+c7vDvOXPK4dPKy2+UTV7hXmq86X23qdOo8/pPTT8e7nLuarrlca7nuer21e2b36RueN87d9L158Rb/1tWeOT3dvfN6b/fF9/XfFt1+cif9zsu72Xcn7q28T7xf9EDtQdlD3YfVP1v+3Njv3H9qwHeg89HcR/cGhYPP/pH1jw9DBY+Zj8uGDYbrnjg+OTniP3L96fynQ89kzyaeF/6i/suuFxYvfvjV69fO0ZjRoZfyl5O/bXyl/erA6xmv28bCxh6+yXgzMV70VvvtwXfcdx3vo98PT+R8IH8o/2j5sfVT0Kf7kxmTk/8EA5jz/GMzLdsAAAAgY0hSTQAAeiUAAICDAAD5/wAAgOkAAHUwAADqYAAAOpgAABdvkl/FRgAABw1JREFUeNrsnM1rG9sZxp9zZqTRjD7GI9tK40S2k7jNdekqBJoUSgt3ESjdhKy6STbNxz9wu8mqtIVuC00h7vqu6y5KN4VCsQP5cuoQEsdOUkuOPmwpGkmj+Z45p4vYRXGsS2XZoIvmAWOw/Qqfn57znued8ZjgU2kAfgLghwDyACQAHJF6qQVgDcA/AfwbAAMA0vUDXwC4CeBCxKpvtQH8DcDXAExy//593L59ew7A3Ww2+73Lly9Pzs/PZycmJhRRFCnnkVF7ybZt//379+3Hjx/XVldXm4yxRQALBEAawFfnz5//2dWrV8/Ozs5qEa7+4T59+rSyuLi42el07gkAfjo3N/fL69evf39qaioTIepfoigK09PTajabja2vr2eEiYmJm9euXfsyn8+PRXgG08mTJ1OMsYR48eLFH83NzWWj3nkkIpcuXZoS5+fnpwkh0YF0RMpkMrKoaZo6ikAZYwzAFqXUBiAeIo8HQRDkRVFMfdZjBUGgo+goy7IcXdd/l8/nHwLI7AX3fg79SqXyh3w+/+PPoIZhyEfRqUEQBG/evHl5+vTp54dO/O12/SB2IuccowiVc04kSYoPsnZCiNgT6sf2glEEO+jayUH1o+xUDLr2XvUjDbX786Cv8wlUxhhGNFIN7NRe7CKnHodTRxXqN/XEgXvqUbxb0UEVOfXItn9PqIyxkcype+seZO29cu7Ibn8ASCQS3iBrp5QGUaTa59RarabdvXtXAxDr16QA2I0bN+LRmNol3/fpixcvfgHgy70d2+/7Uq/Xp8+dO3cw1FEUIYQmk8kvVFWdFUWRHKKXclEUD7ynN7IHlaIo0pUrV77r+35IKSX91nPOeSaTkaOD6tNDhk5MTKSPKppFOfWYFUE9Dqij2lOPFeooh/8ePTJkjJHdG6I8DENGCOGUUnE33zJCCAgh9BudOopQXddtAeDxeDzzMWER4jhO07btHULIZCaTUYMgCDudjs45d2VZlhRFyRmG4QRBUEyn02disZjUs6eO2vbnnPOdnZ1GPB4P0+m0wTlPyrKcrVQqNqVUmpqaUgAQQRCEVCqVMgxD3NzcbM3OznqSJMVqtVo1FotpgiCcODBZ9OvSMAzZ1tbWu0aj8QEAqtXq+2q1WgKAer1e29raesc5561Wq725ubnmOI63b5IJi8XiRqPRaABAuVwubm9vlwGgVqvtlEqlzd36VqFQWPc8z++u9zzPLxQK67qu6wBQKpUKOzs71d36arlcLjDGuK7rzWKxuBEEQXDQOizLknVdT9br9R3TNDsAIAhC4Hme5/t+h3POGWO+67pt13XdvbpYLCbG43EmCILZM67tOfX//fA8L3z06FG7UCiYYRjy58+fGy9fvjQYY3j37l3nyZMnRhAEvFKpmEtLS51Op+N11zuO4y8vL7e3trZMxhhWV1eNV69edRhj2NjYMFZWVowgCHipVDKXlpbatm0H3fWmafrLy8tGqVSyGGP82bNnxuvXrzuMMaytrRkrKytGGIasXC6bDx48MPbX77Y7omlaSpKkeKVSkUzTjDHGkMvlvpPL5XKVSqXZaDSser3e/vDhg5FOpzNnzpw5FY/H477vM9d1c/V63Ws2m+2DGJE7d+40U6mU2s/W0XXdTCQSoqIoiVarZRJCSCaTUUzTtF3XDbPZbMq2bdeyLHdsbCwpCILQdSGD6bre2e1RUne9YRh2EAShpmn/q9c0LUUppd07Rdf1jqIokqIokq7rHVEUaTqdVtrtthWGIeuq9zRNS3bX79fbt2+ryWRSyuVyY5ZlOYwxXqlUmpOTkxnLslzTNN1Tp05psVhMlCQpZlmWs7GxsW0YhpvP57WZmZnJz0bgW7duNdPptDqqp71t254gCDQejwumabqO4/iUUqqqquw4jm+apiMIgiBJUiyZTEqWZbmGYdiMMa6qqqIoihSF/31KJBLxvVipKEpCUZTE3vdkWZZkWd57mIRwzru/Fo2pg17UisbUaPaPoEY6rtnftu03siz/Cx+fCBwGMQCebds/l2X5xLfSqdvb2w9nZmZuAkgOCdSw0WgEruvOJxKJbydUxpjLOWcAjGHZcpqmoVwuB8PQyg4FlXMeu3fvnghgWJ4X4NPT0/TChQvCUEA9TE9ttVpzAH6Fw93aPZaeWiwW2fz8/MTQOLVf+b6fEwThCiEEw6QwDFPDcvr3/XTK2bNnT4yPj6cOc2v3WGzKGAeA8fHxzFA4lVIa9vuLqKqaUlU1hSHUUEAlhDQ55+NRZD86UVEUVyMMRwyVUroIwI1QHJnWKYC/AvhLxOJIZAL4I8XHf6ryewBRGxj8+sOfAPx5byJaBXAbwN8BhBGfvlUF8BsAv11YWHC6J6KHAH4N4D8AfgBA3c2x0d8EHSwCwNkF+g8AXy8sLLQB4L8DAAhT7u9BvYC1AAAAAElFTkSuQmCC", (Context) activity) : imageBitmap;
    }

    public static CardType m450a(bA bAVar) {
        return CardType.fromString(bAVar.m937h().toString());
    }

    public static String m451a(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[((int) randomAccessFile.length())];
        randomAccessFile.readFully(bArr);
        randomAccessFile.close();
        return new String(bArr, "UTF-8");
    }

    public static String m452a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "unable_to_encode:" + str;
        }
    }

    public static String m453a(Map map) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Entry entry : map.entrySet()) {
            Object obj2;
            if (obj == null) {
                stringBuilder.append("&");
                obj2 = obj;
            } else {
                obj2 = null;
            }
            stringBuilder.append(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
            obj = obj2;
        }
        return stringBuilder.toString();
    }

    public static Header m454a(String str, List list, String str2) {
        String format = String.format("Trace: [%s] %s, %s", new Object[]{str, "\"%08.8x: Operation = %80s Duration: %8.2f Iterations: %+4d\"", "memorySize * 8 + offset"});
        List arrayList = new ArrayList();
        for (Header header : list) {
            arrayList.add(header.getName() + ": " + header.getValue());
        }
        Collections.sort(arrayList);
        String str3 = TextUtils.join(";", arrayList.toArray()) + str2;
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec(format.getBytes(), "HmacSHA1"));
        instance.update(str3.getBytes());
        byte[] doFinal = instance.doFinal();
        StringBuilder stringBuilder = new StringBuilder();
        int length = doFinal.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.format("%02x", new Object[]{Byte.valueOf(doFinal[i])}));
        }
        return new BasicHeader("PayPal-Item-Id", stringBuilder.toString());
    }

    public static void m455a(Activity activity) {
        if (C0510f.m463c()) {
            activity.requestWindowFeature(8);
        }
    }

    public static void m456a(Activity activity, TextView textView, String str, String str2, Drawable drawable) {
        activity.setTitle(str2 + str);
        if (C0510f.m463c()) {
            ActionBar actionBar = activity.getActionBar();
            actionBar.setBackgroundDrawable(bo.f341c);
            actionBar.setTitle(str);
            TextView textView2 = (TextView) activity.findViewById(Resources.getSystem().getIdentifier("action_bar_title", "id", "android"));
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
            actionBar.setDisplayHomeAsUpEnabled(false);
            if (drawable == null || VERSION.SDK_INT < 14) {
                actionBar.setDisplayShowHomeEnabled(false);
            } else {
                actionBar.setIcon(drawable);
            }
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else if (textView != null) {
            textView.setText(str);
        }
    }

    public static void m457a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void m458a(File file, String str) {
        Closeable fileOutputStream;
        Throwable th;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                C0510f.m457a(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                C0510f.m457a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            C0510f.m457a(fileOutputStream);
            throw th;
        }
    }

    public static boolean m459a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean m460a(String str, String str2, String str3) {
        boolean a = C0510f.m459a((CharSequence) str2);
        if (a) {
            Log.e(str, str3 + " is empty.");
        }
        boolean e = C0510f.m468e((CharSequence) str2);
        if (e) {
            Log.e(str, str3 + " contains whitespace.");
        }
        return (a || e) ? false : true;
    }

    public static void m461b(Activity activity) {
        if ((VERSION.SDK_INT >= 11 ? 1 : null) != null) {
            activity.setTheme(16973934);
        } else {
            activity.setTheme(16973836);
        }
    }

    public static boolean m462b(CharSequence charSequence) {
        return !C0510f.m459a(charSequence);
    }

    public static boolean m463c() {
        return VERSION.SDK_INT >= 11;
    }

    public static boolean m464c(CharSequence charSequence) {
        if (charSequence != null) {
            int length = charSequence.length();
            if (length != 0) {
                for (int i = 0; i < length; i++) {
                    if (!Character.isWhitespace(charSequence.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    public static SpannableString m465d(String str) {
        if (!C0510f.m466d()) {
            return null;
        }
        String a = cz.m428a(cB.JAPANESE_COMPLIANCE_AGREEMENT);
        Object[] objArr = new Object[2];
        String str2 = (C0510f.m467d((CharSequence) str) && str.equals("ja")) ? "https://cms.paypal.com/jp/cgi-bin/marketingweb?cmd=_render-content&content_ID=ua/Legal_Hub_full&locale.x=ja_JP" : "https://cms.paypal.com/jp/cgi-bin/marketingweb?cmd=_render-content&content_ID=ua/Legal_Hub_full&locale.x=en_US";
        objArr[0] = str2;
        objArr[1] = "https://www.paypal.jp/jp/contents/regulation/info/overseas-remittance/";
        return new SpannableString(Html.fromHtml(String.format(a, objArr)));
    }

    public static boolean m466d() {
        CharSequence toLowerCase = Locale.getDefault().getCountry().toLowerCase(Locale.US);
        return !C0510f.m464c(toLowerCase) && toLowerCase.equals("jp");
    }

    public static boolean m467d(CharSequence charSequence) {
        return !C0510f.m464c(charSequence);
    }

    public static boolean m468e(CharSequence charSequence) {
        if (C0510f.m459a(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean m469e(String str) {
        if (C0510f.m464c((CharSequence) str)) {
            return false;
        }
        return (str.matches("^([a-zA-Z0-9]|_|-)*$")) && str.length() <= 32;
    }

    public String m470a() {
        return this.f671a;
    }

    public String m471b() {
        return this.f672b;
    }

    public void m472b(String str) {
        this.f671a = str;
    }

    public void m473c(String str) {
        this.f672b = str;
    }
}
