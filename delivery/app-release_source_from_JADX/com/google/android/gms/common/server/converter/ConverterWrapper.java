package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.zza;

public class ConverterWrapper implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final int mVersionCode;
    private final StringToIntConverter zzakO;

    ConverterWrapper(int versionCode, StringToIntConverter stringToIntConverter) {
        this.mVersionCode = versionCode;
        this.zzakO = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.mVersionCode = 1;
        this.zzakO = stringToIntConverter;
    }

    public static ConverterWrapper zza(zza<?, ?> com_google_android_gms_common_server_response_FastJsonResponse_zza___) {
        if (com_google_android_gms_common_server_response_FastJsonResponse_zza___ instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) com_google_android_gms_common_server_response_FastJsonResponse_zza___);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public int describeContents() {
        zza com_google_android_gms_common_server_converter_zza = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza com_google_android_gms_common_server_converter_zza = CREATOR;
        zza.zza(this, out, flags);
    }

    StringToIntConverter zzqQ() {
        return this.zzakO;
    }

    public zza<?, ?> zzqR() {
        if (this.zzakO != null) {
            return this.zzakO;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
}
