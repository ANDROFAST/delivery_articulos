package io.card.payment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;
import java.util.UUID;

public class CreditCard implements Parcelable {
    public static final Creator CREATOR = new C05551();
    public static final int EXPIRY_MAX_FUTURE_YEARS = 15;
    private static final String TAG = CreditCard.class.getSimpleName();
    public String cardNumber;
    public String cvv;
    public int expiryMonth;
    public int expiryYear;
    boolean flipped;
    public String postalCode;
    String scanId;
    int[] xoff;
    int yoff;

    final class C05551 implements Creator {
        C05551() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CreditCard(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CreditCard[i];
        }
    }

    public CreditCard() {
        this.expiryMonth = 0;
        this.expiryYear = 0;
        this.flipped = false;
        this.xoff = new int[16];
        this.scanId = UUID.randomUUID().toString();
    }

    private CreditCard(Parcel parcel) {
        this.expiryMonth = 0;
        this.expiryYear = 0;
        this.flipped = false;
        this.cardNumber = parcel.readString();
        this.expiryMonth = parcel.readInt();
        this.expiryYear = parcel.readInt();
        this.cvv = parcel.readString();
        this.postalCode = parcel.readString();
        this.scanId = parcel.readString();
        this.yoff = parcel.readInt();
        this.xoff = parcel.createIntArray();
    }

    public CreditCard(String str, int i, int i2, String str2, String str3) {
        this.expiryMonth = 0;
        this.expiryYear = 0;
        this.flipped = false;
        this.cardNumber = str;
        this.expiryMonth = i;
        this.expiryYear = i2;
        this.cvv = str2;
        this.postalCode = str3;
    }

    public int describeContents() {
        return 0;
    }

    public CardType getCardType() {
        return CardType.fromCardNumber(this.cardNumber);
    }

    public String getFormattedCardNumber() {
        return C0560g.m838a(this.cardNumber, true, null);
    }

    public String getLastFourDigitsOfCardNumber() {
        if (this.cardNumber == null) {
            return "";
        }
        return this.cardNumber.substring(this.cardNumber.length() - Math.min(4, this.cardNumber.length()));
    }

    public String getRedactedCardNumber() {
        if (this.cardNumber == null) {
            return "";
        }
        String str = "";
        if (this.cardNumber.length() > 4) {
            str = str + String.format("%" + (this.cardNumber.length() - 4) + "s", new Object[]{""}).replace(' ', '•');
        }
        return C0560g.m838a(str + getLastFourDigitsOfCardNumber(), false, CardType.fromCardNumber(this.cardNumber));
    }

    public boolean isExpiryValid() {
        int i = this.expiryMonth;
        int i2 = this.expiryYear;
        if (i <= 0 || 12 < i) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        int i3 = instance.get(1);
        return i2 >= i3 ? (i2 != i3 || i >= instance.get(2) + 1) && i2 <= i3 + 15 : false;
    }

    public String toString() {
        String str = "{" + getCardType() + ": " + getRedactedCardNumber();
        if (this.expiryMonth > 0 || this.expiryYear > 0) {
            str = str + "  expiry:" + this.expiryMonth + "/" + this.expiryYear;
        }
        if (this.postalCode != null) {
            str = str + "  postalCode:" + this.postalCode;
        }
        if (this.cvv != null) {
            str = str + "  cvvLength:" + (this.cvv != null ? this.cvv.length() : 0);
        }
        return str + "}";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.cardNumber);
        parcel.writeInt(this.expiryMonth);
        parcel.writeInt(this.expiryYear);
        parcel.writeString(this.cvv);
        parcel.writeString(this.postalCode);
        parcel.writeString(this.scanId);
        parcel.writeInt(this.yoff);
        parcel.writeIntArray(this.xoff);
    }
}
