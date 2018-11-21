package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.internal.zzni;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zznv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public interface zza<I, O> {
        I convertBack(O o);

        int zzqT();

        int zzqU();
    }

    public static class Field<I, O> implements SafeParcelable {
        public static final zza CREATOR = new zza();
        private final int mVersionCode;
        protected final int zzakU;
        protected final boolean zzakV;
        protected final int zzakW;
        protected final boolean zzakX;
        protected final String zzakY;
        protected final int zzakZ;
        protected final Class<? extends FastJsonResponse> zzala;
        protected final String zzalb;
        private FieldMappingDictionary zzalc;
        private zza<I, O> zzald;

        Field(int versionCode, int typeIn, boolean typeInArray, int typeOut, boolean typeOutArray, String outputFieldName, int safeParcelableFieldId, String concreteTypeName, ConverterWrapper wrappedConverter) {
            this.mVersionCode = versionCode;
            this.zzakU = typeIn;
            this.zzakV = typeInArray;
            this.zzakW = typeOut;
            this.zzakX = typeOutArray;
            this.zzakY = outputFieldName;
            this.zzakZ = safeParcelableFieldId;
            if (concreteTypeName == null) {
                this.zzala = null;
                this.zzalb = null;
            } else {
                this.zzala = SafeParcelResponse.class;
                this.zzalb = concreteTypeName;
            }
            if (wrappedConverter == null) {
                this.zzald = null;
            } else {
                this.zzald = wrappedConverter.zzqR();
            }
        }

        protected Field(int typeIn, boolean typeInArray, int typeOut, boolean typeOutArray, String outputFieldName, int safeParcelableFieldId, Class<? extends FastJsonResponse> concreteType, zza<I, O> converter) {
            this.mVersionCode = 1;
            this.zzakU = typeIn;
            this.zzakV = typeInArray;
            this.zzakW = typeOut;
            this.zzakX = typeOutArray;
            this.zzakY = outputFieldName;
            this.zzakZ = safeParcelableFieldId;
            this.zzala = concreteType;
            if (concreteType == null) {
                this.zzalb = null;
            } else {
                this.zzalb = concreteType.getCanonicalName();
            }
            this.zzald = converter;
        }

        public static Field zza(String str, int i, zza<?, ?> com_google_android_gms_common_server_response_FastJsonResponse_zza___, boolean z) {
            return new Field(com_google_android_gms_common_server_response_FastJsonResponse_zza___.zzqT(), z, com_google_android_gms_common_server_response_FastJsonResponse_zza___.zzqU(), false, str, i, null, com_google_android_gms_common_server_response_FastJsonResponse_zza___);
        }

        public static <T extends FastJsonResponse> Field<T, T> zza(String str, int i, Class<T> cls) {
            return new Field(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> zzb(String str, int i, Class<T> cls) {
            return new Field(11, true, 11, true, str, i, cls, null);
        }

        public static Field<Integer, Integer> zzi(String str, int i) {
            return new Field(0, false, 0, false, str, i, null, null);
        }

        public static Field<Double, Double> zzj(String str, int i) {
            return new Field(4, false, 4, false, str, i, null, null);
        }

        public static Field<Boolean, Boolean> zzk(String str, int i) {
            return new Field(6, false, 6, false, str, i, null, null);
        }

        public static Field<String, String> zzl(String str, int i) {
            return new Field(7, false, 7, false, str, i, null, null);
        }

        public static Field<ArrayList<String>, ArrayList<String>> zzm(String str, int i) {
            return new Field(7, true, 7, true, str, i, null, null);
        }

        public I convertBack(O output) {
            return this.zzald.convertBack(output);
        }

        public int describeContents() {
            zza com_google_android_gms_common_server_response_zza = CREATOR;
            return 0;
        }

        public int getVersionCode() {
            return this.mVersionCode;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.mVersionCode).append('\n');
            stringBuilder.append("                 typeIn=").append(this.zzakU).append('\n');
            stringBuilder.append("            typeInArray=").append(this.zzakV).append('\n');
            stringBuilder.append("                typeOut=").append(this.zzakW).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.zzakX).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.zzakY).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.zzakZ).append('\n');
            stringBuilder.append("       concreteTypeName=").append(zzre()).append('\n');
            if (zzrd() != null) {
                stringBuilder.append("     concreteType.class=").append(zzrd().getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.zzald == null ? "null" : this.zzald.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            zza com_google_android_gms_common_server_response_zza = CREATOR;
            zza.zza(this, out, flags);
        }

        public void zza(FieldMappingDictionary fieldMappingDictionary) {
            this.zzalc = fieldMappingDictionary;
        }

        public int zzqT() {
            return this.zzakU;
        }

        public int zzqU() {
            return this.zzakW;
        }

        public Field<I, O> zzqY() {
            return new Field(this.mVersionCode, this.zzakU, this.zzakV, this.zzakW, this.zzakX, this.zzakY, this.zzakZ, this.zzalb, zzrg());
        }

        public boolean zzqZ() {
            return this.zzakV;
        }

        public boolean zzra() {
            return this.zzakX;
        }

        public String zzrb() {
            return this.zzakY;
        }

        public int zzrc() {
            return this.zzakZ;
        }

        public Class<? extends FastJsonResponse> zzrd() {
            return this.zzala;
        }

        String zzre() {
            return this.zzalb == null ? null : this.zzalb;
        }

        public boolean zzrf() {
            return this.zzald != null;
        }

        ConverterWrapper zzrg() {
            return this.zzald == null ? null : ConverterWrapper.zza(this.zzald);
        }

        public Map<String, Field<?, ?>> zzrh() {
            zzx.zzy(this.zzalb);
            zzx.zzy(this.zzalc);
            return this.zzalc.zzcL(this.zzalb);
        }
    }

    private void zza(StringBuilder stringBuilder, Field field, Object obj) {
        if (field.zzqT() == 11) {
            stringBuilder.append(((FastJsonResponse) field.zzrd().cast(obj)).toString());
        } else if (field.zzqT() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(zznu.zzcO((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private void zza(StringBuilder stringBuilder, Field field, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                zza(stringBuilder, field, obj);
            }
        }
        stringBuilder.append("]");
    }

    public String toString() {
        Map zzqV = zzqV();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : zzqV.keySet()) {
            Field field = (Field) zzqV.get(str);
            if (zza(field)) {
                Object zza = zza(field, zzb(field));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (zza != null) {
                    switch (field.zzqU()) {
                        case 8:
                            stringBuilder.append("\"").append(zzni.zzj((byte[]) zza)).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(zzni.zzk((byte[]) zza)).append("\"");
                            break;
                        case 10:
                            zznv.zza(stringBuilder, (HashMap) zza);
                            break;
                        default:
                            if (!field.zzqZ()) {
                                zza(stringBuilder, field, zza);
                                break;
                            }
                            zza(stringBuilder, field, (ArrayList) zza);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }

    protected <O, I> I zza(Field<I, O> field, Object obj) {
        return field.zzald != null ? field.convertBack(obj) : obj;
    }

    protected boolean zza(Field field) {
        return field.zzqU() == 11 ? field.zzra() ? zzcK(field.zzrb()) : zzcJ(field.zzrb()) : zzcI(field.zzrb());
    }

    protected Object zzb(Field field) {
        String zzrb = field.zzrb();
        if (field.zzrd() == null) {
            return zzcH(field.zzrb());
        }
        zzx.zza(zzcH(field.zzrb()) == null, "Concrete field shouldn't be value object: %s", field.zzrb());
        Map zzqX = field.zzra() ? zzqX() : zzqW();
        if (zzqX != null) {
            return zzqX.get(zzrb);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(zzrb.charAt(0)) + zzrb.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract Object zzcH(String str);

    protected abstract boolean zzcI(String str);

    protected boolean zzcJ(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean zzcK(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public abstract Map<String, Field<?, ?>> zzqV();

    public HashMap<String, Object> zzqW() {
        return null;
    }

    public HashMap<String, Object> zzqX() {
        return null;
    }
}
