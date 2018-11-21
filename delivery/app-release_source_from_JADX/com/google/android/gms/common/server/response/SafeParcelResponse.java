package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzni;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zznv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SafeParcelResponse extends FastJsonResponse implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private final String mClassName;
    private final int mVersionCode;
    private final FieldMappingDictionary zzalc;
    private final Parcel zzalj;
    private final int zzalk;
    private int zzall;
    private int zzalm;

    SafeParcelResponse(int versionCode, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.mVersionCode = versionCode;
        this.zzalj = (Parcel) zzx.zzy(parcel);
        this.zzalk = 2;
        this.zzalc = fieldMappingDictionary;
        if (this.zzalc == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.zzalc.zzrl();
        }
        this.zzall = 2;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, FieldMappingDictionary dictionary, String className) {
        this.mVersionCode = 1;
        this.zzalj = Parcel.obtain();
        safeParcelable.writeToParcel(this.zzalj, 0);
        this.zzalk = 1;
        this.zzalc = (FieldMappingDictionary) zzx.zzy(dictionary);
        this.mClassName = (String) zzx.zzy(className);
        this.zzall = 2;
    }

    private static HashMap<Integer, Entry<String, Field<?, ?>>> zzG(Map<String, Field<?, ?>> map) {
        HashMap<Integer, Entry<String, Field<?, ?>>> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            hashMap.put(Integer.valueOf(((Field) entry.getValue()).zzrc()), entry);
        }
        return hashMap;
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse zza(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new SafeParcelResponse((SafeParcelable) t, zzb(t), canonicalName);
    }

    private static void zza(FieldMappingDictionary fieldMappingDictionary, FastJsonResponse fastJsonResponse) {
        Class cls = fastJsonResponse.getClass();
        if (!fieldMappingDictionary.zzb(cls)) {
            Map zzqV = fastJsonResponse.zzqV();
            fieldMappingDictionary.zza(cls, zzqV);
            for (String str : zzqV.keySet()) {
                Field field = (Field) zzqV.get(str);
                Class zzrd = field.zzrd();
                if (zzrd != null) {
                    try {
                        zza(fieldMappingDictionary, (FastJsonResponse) zzrd.newInstance());
                    } catch (Throwable e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + field.zzrd().getCanonicalName(), e);
                    } catch (Throwable e2) {
                        throw new IllegalStateException("Could not access object of type " + field.zzrd().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    private void zza(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(zznu.zzcO(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(zzni.zzj((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(zzni.zzk((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                zznv.zza(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void zza(StringBuilder stringBuilder, Field<?, ?> field, Parcel parcel, int i) {
        switch (field.zzqU()) {
            case 0:
                zzb(stringBuilder, (Field) field, zza(field, Integer.valueOf(zza.zzg(parcel, i))));
                return;
            case 1:
                zzb(stringBuilder, (Field) field, zza(field, zza.zzk(parcel, i)));
                return;
            case 2:
                zzb(stringBuilder, (Field) field, zza(field, Long.valueOf(zza.zzi(parcel, i))));
                return;
            case 3:
                zzb(stringBuilder, (Field) field, zza(field, Float.valueOf(zza.zzl(parcel, i))));
                return;
            case 4:
                zzb(stringBuilder, (Field) field, zza(field, Double.valueOf(zza.zzn(parcel, i))));
                return;
            case 5:
                zzb(stringBuilder, (Field) field, zza(field, zza.zzo(parcel, i)));
                return;
            case 6:
                zzb(stringBuilder, (Field) field, zza(field, Boolean.valueOf(zza.zzc(parcel, i))));
                return;
            case 7:
                zzb(stringBuilder, (Field) field, zza(field, zza.zzp(parcel, i)));
                return;
            case 8:
            case 9:
                zzb(stringBuilder, (Field) field, zza(field, zza.zzs(parcel, i)));
                return;
            case 10:
                zzb(stringBuilder, (Field) field, zza(field, zzl(zza.zzr(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + field.zzqU());
        }
    }

    private void zza(StringBuilder stringBuilder, String str, Field<?, ?> field, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (field.zzrf()) {
            zza(stringBuilder, field, parcel, i);
        } else {
            zzb(stringBuilder, field, parcel, i);
        }
    }

    private void zza(StringBuilder stringBuilder, Map<String, Field<?, ?>> map, Parcel parcel) {
        HashMap zzG = zzG(map);
        stringBuilder.append('{');
        int zzau = zza.zzau(parcel);
        Object obj = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            Entry entry = (Entry) zzG.get(Integer.valueOf(zza.zzcc(zzat)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                zza(stringBuilder, (String) entry.getKey(), (Field) entry.getValue(), parcel, zzat);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != zzau) {
            throw new zza.zza("Overread allowed size end=" + zzau, parcel);
        }
        stringBuilder.append('}');
    }

    private static FieldMappingDictionary zzb(FastJsonResponse fastJsonResponse) {
        FieldMappingDictionary fieldMappingDictionary = new FieldMappingDictionary(fastJsonResponse.getClass());
        zza(fieldMappingDictionary, fastJsonResponse);
        fieldMappingDictionary.zzrj();
        fieldMappingDictionary.zzri();
        return fieldMappingDictionary;
    }

    private void zzb(StringBuilder stringBuilder, Field<?, ?> field, Parcel parcel, int i) {
        if (field.zzra()) {
            stringBuilder.append("[");
            switch (field.zzqU()) {
                case 0:
                    zznh.zza(stringBuilder, zza.zzv(parcel, i));
                    break;
                case 1:
                    zznh.zza(stringBuilder, zza.zzx(parcel, i));
                    break;
                case 2:
                    zznh.zza(stringBuilder, zza.zzw(parcel, i));
                    break;
                case 3:
                    zznh.zza(stringBuilder, zza.zzy(parcel, i));
                    break;
                case 4:
                    zznh.zza(stringBuilder, zza.zzz(parcel, i));
                    break;
                case 5:
                    zznh.zza(stringBuilder, zza.zzA(parcel, i));
                    break;
                case 6:
                    zznh.zza(stringBuilder, zza.zzu(parcel, i));
                    break;
                case 7:
                    zznh.zza(stringBuilder, zza.zzB(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] zzF = zza.zzF(parcel, i);
                    int length = zzF.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        zzF[i2].setDataPosition(0);
                        zza(stringBuilder, field.zzrh(), zzF[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (field.zzqU()) {
            case 0:
                stringBuilder.append(zza.zzg(parcel, i));
                return;
            case 1:
                stringBuilder.append(zza.zzk(parcel, i));
                return;
            case 2:
                stringBuilder.append(zza.zzi(parcel, i));
                return;
            case 3:
                stringBuilder.append(zza.zzl(parcel, i));
                return;
            case 4:
                stringBuilder.append(zza.zzn(parcel, i));
                return;
            case 5:
                stringBuilder.append(zza.zzo(parcel, i));
                return;
            case 6:
                stringBuilder.append(zza.zzc(parcel, i));
                return;
            case 7:
                stringBuilder.append("\"").append(zznu.zzcO(zza.zzp(parcel, i))).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(zzni.zzj(zza.zzs(parcel, i))).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(zzni.zzk(zza.zzs(parcel, i)));
                stringBuilder.append("\"");
                return;
            case 10:
                Bundle zzr = zza.zzr(parcel, i);
                Set<String> keySet = zzr.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(zznu.zzcO(zzr.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
                return;
            case 11:
                Parcel zzE = zza.zzE(parcel, i);
                zzE.setDataPosition(0);
                zza(stringBuilder, field.zzrh(), zzE);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void zzb(StringBuilder stringBuilder, Field<?, ?> field, Object obj) {
        if (field.zzqZ()) {
            zzb(stringBuilder, (Field) field, (ArrayList) obj);
        } else {
            zza(stringBuilder, field.zzqT(), obj);
        }
    }

    private void zzb(StringBuilder stringBuilder, Field<?, ?> field, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            zza(stringBuilder, field.zzqT(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    public static HashMap<String, String> zzl(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public int describeContents() {
        zze com_google_android_gms_common_server_response_zze = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        zzx.zzb(this.zzalc, (Object) "Cannot convert to JSON on client side.");
        Parcel zzrn = zzrn();
        zzrn.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        zza(stringBuilder, this.zzalc.zzcL(this.mClassName), zzrn);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zze com_google_android_gms_common_server_response_zze = CREATOR;
        zze.zza(this, out, flags);
    }

    protected Object zzcH(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean zzcI(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Map<String, Field<?, ?>> zzqV() {
        return this.zzalc == null ? null : this.zzalc.zzcL(this.mClassName);
    }

    public Parcel zzrn() {
        switch (this.zzall) {
            case 0:
                this.zzalm = zzb.zzav(this.zzalj);
                zzb.zzI(this.zzalj, this.zzalm);
                this.zzall = 2;
                break;
            case 1:
                zzb.zzI(this.zzalj, this.zzalm);
                this.zzall = 2;
                break;
        }
        return this.zzalj;
    }

    FieldMappingDictionary zzro() {
        switch (this.zzalk) {
            case 0:
                return null;
            case 1:
                return this.zzalc;
            case 2:
                return this.zzalc;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.zzalk);
        }
    }
}
