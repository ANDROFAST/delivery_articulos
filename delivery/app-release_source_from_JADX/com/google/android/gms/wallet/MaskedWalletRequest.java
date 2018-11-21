package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest implements SafeParcelable {
    public static final Creator<MaskedWalletRequest> CREATOR = new zzl();
    private final int mVersionCode;
    String zzbja;
    String zzbjh;
    Cart zzbjr;
    boolean zzbkc;
    boolean zzbkd;
    boolean zzbke;
    String zzbkf;
    String zzbkg;
    boolean zzbkh;
    boolean zzbki;
    CountrySpecification[] zzbkj;
    boolean zzbkk;
    boolean zzbkl;
    ArrayList<CountrySpecification> zzbkm;
    PaymentMethodTokenizationParameters zzbkn;
    ArrayList<Integer> zzbko;

    public final class Builder {
        final /* synthetic */ MaskedWalletRequest zzbkp;

        private Builder(MaskedWalletRequest maskedWalletRequest) {
            this.zzbkp = maskedWalletRequest;
        }

        public Builder addAllowedCardNetwork(int allowedCardNetwork) {
            if (this.zzbkp.zzbko == null) {
                this.zzbkp.zzbko = new ArrayList();
            }
            this.zzbkp.zzbko.add(Integer.valueOf(allowedCardNetwork));
            return this;
        }

        public Builder addAllowedCardNetworks(Collection<Integer> allowedCardNetworks) {
            if (allowedCardNetworks != null) {
                if (this.zzbkp.zzbko == null) {
                    this.zzbkp.zzbko = new ArrayList();
                }
                this.zzbkp.zzbko.addAll(allowedCardNetworks);
            }
            return this;
        }

        public Builder addAllowedCountrySpecificationForShipping(CountrySpecification countrySpecification) {
            if (this.zzbkp.zzbkm == null) {
                this.zzbkp.zzbkm = new ArrayList();
            }
            this.zzbkp.zzbkm.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection<CountrySpecification> countrySpecifications) {
            if (countrySpecifications != null) {
                if (this.zzbkp.zzbkm == null) {
                    this.zzbkp.zzbkm = new ArrayList();
                }
                this.zzbkp.zzbkm.addAll(countrySpecifications);
            }
            return this;
        }

        public MaskedWalletRequest build() {
            return this.zzbkp;
        }

        public Builder setAllowDebitCard(boolean allowDebitCard) {
            this.zzbkp.zzbkl = allowDebitCard;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean allowPrepaidCard) {
            this.zzbkp.zzbkk = allowPrepaidCard;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.zzbkp.zzbjr = cart;
            return this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.zzbkp.zzbja = currencyCode;
            return this;
        }

        public Builder setEstimatedTotalPrice(String estimatedTotalPrice) {
            this.zzbkp.zzbkf = estimatedTotalPrice;
            return this;
        }

        @Deprecated
        public Builder setIsBillingAgreement(boolean isBillingAgreement) {
            this.zzbkp.zzbki = isBillingAgreement;
            return this;
        }

        public Builder setMerchantName(String merchantName) {
            this.zzbkp.zzbkg = merchantName;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.zzbkp.zzbjh = merchantTransactionId;
            return this;
        }

        public Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paymentMethodTokenizationParameters) {
            this.zzbkp.zzbkn = paymentMethodTokenizationParameters;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean phoneNumberRequired) {
            this.zzbkp.zzbkc = phoneNumberRequired;
            return this;
        }

        public Builder setShippingAddressRequired(boolean shippingAddressRequired) {
            this.zzbkp.zzbkd = shippingAddressRequired;
            return this;
        }

        @Deprecated
        public Builder setUseMinimalBillingAddress(boolean useMinimalBillingAddress) {
            this.zzbkp.zzbke = useMinimalBillingAddress;
            return this;
        }
    }

    MaskedWalletRequest() {
        this.mVersionCode = 3;
        this.zzbkk = true;
        this.zzbkl = true;
    }

    MaskedWalletRequest(int versionCode, String merchantTransactionId, boolean phoneNumberRequired, boolean shippingAddressRequired, boolean useMinimalBillingAddress, String estimatedTotalPrice, String currencyCode, String merchantName, Cart cart, boolean shouldRetrieveWalletObjects, boolean isBillingAgreement, CountrySpecification[] allowedShippingCountrySpecifications, boolean allowPrepaidCard, boolean allowDebitCard, ArrayList<CountrySpecification> allowedCountrySpecificationsForShipping, PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, ArrayList<Integer> allowedCardNetworks) {
        this.mVersionCode = versionCode;
        this.zzbjh = merchantTransactionId;
        this.zzbkc = phoneNumberRequired;
        this.zzbkd = shippingAddressRequired;
        this.zzbke = useMinimalBillingAddress;
        this.zzbkf = estimatedTotalPrice;
        this.zzbja = currencyCode;
        this.zzbkg = merchantName;
        this.zzbjr = cart;
        this.zzbkh = shouldRetrieveWalletObjects;
        this.zzbki = isBillingAgreement;
        this.zzbkj = allowedShippingCountrySpecifications;
        this.zzbkk = allowPrepaidCard;
        this.zzbkl = allowDebitCard;
        this.zzbkm = allowedCountrySpecificationsForShipping;
        this.zzbkn = paymentMethodTokenizationParameters;
        this.zzbko = allowedCardNetworks;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public boolean allowDebitCard() {
        return this.zzbkl;
    }

    public boolean allowPrepaidCard() {
        return this.zzbkk;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<Integer> getAllowedCardNetworks() {
        return this.zzbko;
    }

    public ArrayList<CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.zzbkm;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.zzbkj;
    }

    public Cart getCart() {
        return this.zzbjr;
    }

    public String getCurrencyCode() {
        return this.zzbja;
    }

    public String getEstimatedTotalPrice() {
        return this.zzbkf;
    }

    public String getMerchantName() {
        return this.zzbkg;
    }

    public String getMerchantTransactionId() {
        return this.zzbjh;
    }

    public PaymentMethodTokenizationParameters getPaymentMethodTokenizationParameters() {
        return this.zzbkn;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Deprecated
    public boolean isBillingAgreement() {
        return this.zzbki;
    }

    public boolean isPhoneNumberRequired() {
        return this.zzbkc;
    }

    public boolean isShippingAddressRequired() {
        return this.zzbkd;
    }

    @Deprecated
    public boolean useMinimalBillingAddress() {
        return this.zzbke;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }
}
