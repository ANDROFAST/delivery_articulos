package com.paypal.android.sdk;

import android.util.Base64;
import android.util.Log;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public final class C0513i {
    private static String f674a = C0513i.class.getSimpleName();
    private String f675b;

    public C0513i(String str) {
        this.f675b = str;
    }

    private static String m475a(Exception exception) {
        Log.e(f674a, exception.getMessage());
        return null;
    }

    public final String m476a(String str) {
        if (str == null) {
            return null;
        }
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f675b.getBytes("UTF8")));
            byte[] bytes = str.getBytes("UTF8");
            Cipher instance = Cipher.getInstance("DES");
            instance.init(1, generateSecret);
            return Base64.encodeToString(instance.doFinal(bytes), 0);
        } catch (Exception e) {
            return C0513i.m475a(e);
        } catch (Exception e2) {
            return C0513i.m475a(e2);
        } catch (Exception e22) {
            return C0513i.m475a(e22);
        } catch (Exception e222) {
            return C0513i.m475a(e222);
        } catch (Exception e2222) {
            return C0513i.m475a(e2222);
        } catch (Exception e22222) {
            return C0513i.m475a(e22222);
        } catch (Exception e222222) {
            return C0513i.m475a(e222222);
        }
    }

    public final String m477b(String str) {
        if (str == null) {
            return null;
        }
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f675b.getBytes("UTF8")));
            byte[] decode = Base64.decode(str, 0);
            Cipher instance = Cipher.getInstance("DES");
            instance.init(2, generateSecret);
            return new String(instance.doFinal(decode));
        } catch (Exception e) {
            return C0513i.m475a(e);
        } catch (Exception e2) {
            return C0513i.m475a(e2);
        } catch (Exception e22) {
            return C0513i.m475a(e22);
        } catch (Exception e222) {
            return C0513i.m475a(e222);
        } catch (Exception e2222) {
            return C0513i.m475a(e2222);
        } catch (Exception e22222) {
            return C0513i.m475a(e22222);
        } catch (Exception e222222) {
            return C0513i.m475a(e222222);
        } catch (Exception e2222222) {
            return C0513i.m475a(e2222222);
        }
    }
}
