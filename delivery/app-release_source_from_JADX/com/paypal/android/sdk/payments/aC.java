package com.paypal.android.sdk.payments;

import java.util.ArrayList;

final class aC extends ArrayList {
    aC(aB aBVar) {
        add(PayPalConfiguration.ENVIRONMENT_PRODUCTION);
        add(PayPalConfiguration.ENVIRONMENT_SANDBOX);
        add(PayPalConfiguration.ENVIRONMENT_NO_NETWORK);
    }
}
