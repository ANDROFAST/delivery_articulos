package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.C0494N;
import java.util.HashMap;

final class C0550r extends HashMap {
    C0550r() {
        put(C0517B.openid_connect, C0494N.OPENID);
        put(C0517B.oauth_fullname, C0494N.PROFILE);
        put(C0517B.oauth_gender, C0494N.PROFILE);
        put(C0517B.oauth_date_of_birth, C0494N.PROFILE);
        put(C0517B.oauth_timezone, C0494N.PROFILE);
        put(C0517B.oauth_locale, C0494N.PROFILE);
        put(C0517B.oauth_language, C0494N.PROFILE);
        put(C0517B.oauth_age_range, C0494N.PAYPAL_ATTRIBUTES);
        put(C0517B.oauth_account_verified, C0494N.PAYPAL_ATTRIBUTES);
        put(C0517B.oauth_account_type, C0494N.PAYPAL_ATTRIBUTES);
        put(C0517B.oauth_account_creation_date, C0494N.PAYPAL_ATTRIBUTES);
        put(C0517B.oauth_email, C0494N.EMAIL);
        put(C0517B.oauth_street_address1, C0494N.ADDRESS);
        put(C0517B.oauth_street_address2, C0494N.ADDRESS);
        put(C0517B.oauth_city, C0494N.ADDRESS);
        put(C0517B.oauth_state, C0494N.ADDRESS);
        put(C0517B.oauth_country, C0494N.ADDRESS);
        put(C0517B.oauth_zip, C0494N.ADDRESS);
        put(C0517B.oauth_phone_number, C0494N.PHONE);
    }
}
