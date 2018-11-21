package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class CommonWalletObject implements SafeParcelable {
    public static final Creator<CommonWalletObject> CREATOR = new zza();
    private final int mVersionCode;
    String name;
    int state;
    String zzbjH;
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
    String zzif;

    public final class zza {
        final /* synthetic */ CommonWalletObject zzblv;

        private zza(CommonWalletObject commonWalletObject) {
            this.zzblv = commonWalletObject;
        }

        public CommonWalletObject zzGv() {
            return this.zzblv;
        }

        public zza zzfW(String str) {
            this.zzblv.zzif = str;
            return this;
        }
    }

    CommonWalletObject() {
        this.mVersionCode = 1;
        this.zzbjO = zznh.zzrK();
        this.zzbjQ = zznh.zzrK();
        this.zzbjT = zznh.zzrK();
        this.zzbjV = zznh.zzrK();
        this.zzbjW = zznh.zzrK();
        this.zzbjX = zznh.zzrK();
    }

    CommonWalletObject(int versionCode, String id, String classId, String name, String issuerName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, int state, ArrayList<WalletObjectMessage> messages, TimeInterval validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<LabelValueRow> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<UriData> imageModuleDataMainImageUris, ArrayList<TextModuleData> textModulesData, ArrayList<UriData> linksModuleDataUris) {
        this.mVersionCode = versionCode;
        this.zzif = id;
        this.zzbjN = classId;
        this.name = name;
        this.zzbjH = issuerName;
        this.zzbjJ = barcodeAlternateText;
        this.zzbjK = barcodeType;
        this.zzbjL = barcodeValue;
        this.zzbjM = barcodeLabel;
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
    }

    public static zza zzGu() {
        CommonWalletObject commonWalletObject = new CommonWalletObject();
        commonWalletObject.getClass();
        return new zza();
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzif;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
