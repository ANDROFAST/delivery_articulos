package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

public final class LoyaltyWalletObject implements SafeParcelable {
    public static final Creator<LoyaltyWalletObject> CREATOR = new zzj();
    private final int mVersionCode;
    int state;
    String zzaOo;
    String zzbjG;
    String zzbjH;
    String zzbjI;
    String zzbjJ;
    String zzbjK;
    String zzbjL;
    String zzbjM;
    String zzbjN;
    ArrayList<WalletObjectMessage> zzbjO;
    TimeInterval zzbjP;
    ArrayList<LatLng> zzbjQ;
    String zzbjR;
    String zzbjS;
    ArrayList<LabelValueRow> zzbjT;
    boolean zzbjU;
    ArrayList<UriData> zzbjV;
    ArrayList<TextModuleData> zzbjW;
    ArrayList<UriData> zzbjX;
    LoyaltyPoints zzbjY;
    String zzif;

    LoyaltyWalletObject() {
        this.mVersionCode = 4;
        this.zzbjO = zznh.zzrK();
        this.zzbjQ = zznh.zzrK();
        this.zzbjT = zznh.zzrK();
        this.zzbjV = zznh.zzrK();
        this.zzbjW = zznh.zzrK();
        this.zzbjX = zznh.zzrK();
    }

    LoyaltyWalletObject(int versionCode, String id, String accountId, String issuerName, String programName, String accountName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, String classId, int state, ArrayList<WalletObjectMessage> messages, TimeInterval validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<LabelValueRow> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<UriData> imageModuleDataMainImageUris, ArrayList<TextModuleData> textModulesData, ArrayList<UriData> linksModuleDataUris, LoyaltyPoints loyaltyPoints) {
        this.mVersionCode = versionCode;
        this.zzif = id;
        this.zzbjG = accountId;
        this.zzbjH = issuerName;
        this.zzbjI = programName;
        this.zzaOo = accountName;
        this.zzbjJ = barcodeAlternateText;
        this.zzbjK = barcodeType;
        this.zzbjL = barcodeValue;
        this.zzbjM = barcodeLabel;
        this.zzbjN = classId;
        this.state = state;
        this.zzbjO = messages;
        this.zzbjP = validTimeInterval;
        this.zzbjQ = locations;
        this.zzbjR = infoModuleDataHexFontColor;
        this.zzbjS = infoModuleDataHexBackgroundColor;
        this.zzbjT = infoModuleDataLabelValueRows;
        this.zzbjU = infoModuleDataShowLastUpdateTime;
        this.zzbjV = imageModuleDataMainImageUris;
        this.zzbjW = textModulesData;
        this.zzbjX = linksModuleDataUris;
        this.zzbjY = loyaltyPoints;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountId() {
        return this.zzbjG;
    }

    public String getAccountName() {
        return this.zzaOo;
    }

    public String getBarcodeAlternateText() {
        return this.zzbjJ;
    }

    public String getBarcodeType() {
        return this.zzbjK;
    }

    public String getBarcodeValue() {
        return this.zzbjL;
    }

    public String getId() {
        return this.zzif;
    }

    public String getIssuerName() {
        return this.zzbjH;
    }

    public String getProgramName() {
        return this.zzbjI;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
