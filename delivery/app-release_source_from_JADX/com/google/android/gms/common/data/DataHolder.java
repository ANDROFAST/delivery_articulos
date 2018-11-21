package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataHolder implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private static final zza zzahI = new zza(new String[0], null) {
    };
    boolean mClosed;
    private final int mVersionCode;
    private final int zzabx;
    private final String[] zzahA;
    Bundle zzahB;
    private final CursorWindow[] zzahC;
    private final Bundle zzahD;
    int[] zzahE;
    int zzahF;
    private Object zzahG;
    private boolean zzahH;

    public static class zza {
        private final String[] zzahA;
        private final ArrayList<HashMap<String, Object>> zzahJ;
        private final String zzahK;
        private final HashMap<Object, Integer> zzahL;
        private boolean zzahM;
        private String zzahN;

        private zza(String[] strArr, String str) {
            this.zzahA = (String[]) zzx.zzy(strArr);
            this.zzahJ = new ArrayList();
            this.zzahK = str;
            this.zzahL = new HashMap();
            this.zzahM = false;
            this.zzahN = null;
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int versionCode, String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.zzahH = true;
        this.mVersionCode = versionCode;
        this.zzahA = columns;
        this.zzahC = windows;
        this.zzabx = statusCode;
        this.zzahD = metadata;
    }

    private DataHolder(zza builder, int statusCode, Bundle metadata) {
        this(builder.zzahA, zza(builder, -1), statusCode, metadata);
    }

    public DataHolder(String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.zzahH = true;
        this.mVersionCode = 1;
        this.zzahA = (String[]) zzx.zzy(columns);
        this.zzahC = (CursorWindow[]) zzx.zzy(windows);
        this.zzabx = statusCode;
        this.zzahD = metadata;
        zzpL();
    }

    public static DataHolder zza(int i, Bundle bundle) {
        return new DataHolder(zzahI, i, bundle);
    }

    private static CursorWindow[] zza(zza com_google_android_gms_common_data_DataHolder_zza, int i) {
        int size;
        int i2 = 0;
        if (com_google_android_gms_common_data_DataHolder_zza.zzahA.length == 0) {
            return new CursorWindow[0];
        }
        List zzb = (i < 0 || i >= com_google_android_gms_common_data_DataHolder_zza.zzahJ.size()) ? com_google_android_gms_common_data_DataHolder_zza.zzahJ : com_google_android_gms_common_data_DataHolder_zza.zzahJ.subList(0, i);
        int size2 = zzb.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(com_google_android_gms_common_data_DataHolder_zza.zzahA.length);
        int i3 = 0;
        int i4 = 0;
        while (i3 < size2) {
            if (!cursorWindow.allocRow()) {
                Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i3 + ")");
                cursorWindow = new CursorWindow(false);
                cursorWindow.setStartPosition(i3);
                cursorWindow.setNumColumns(com_google_android_gms_common_data_DataHolder_zza.zzahA.length);
                arrayList.add(cursorWindow);
                if (!cursorWindow.allocRow()) {
                    Log.e("DataHolder", "Unable to allocate row to hold data.");
                    arrayList.remove(cursorWindow);
                    return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                }
            }
            try {
                int i5;
                int i6;
                CursorWindow cursorWindow2;
                Map map = (Map) zzb.get(i3);
                boolean z = true;
                for (int i7 = 0; i7 < com_google_android_gms_common_data_DataHolder_zza.zzahA.length && z; i7++) {
                    String str = com_google_android_gms_common_data_DataHolder_zza.zzahA[i7];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z = cursorWindow.putNull(i3, i7);
                    } else if (obj instanceof String) {
                        z = cursorWindow.putString((String) obj, i3, i7);
                    } else if (obj instanceof Long) {
                        z = cursorWindow.putLong(((Long) obj).longValue(), i3, i7);
                    } else if (obj instanceof Integer) {
                        z = cursorWindow.putLong((long) ((Integer) obj).intValue(), i3, i7);
                    } else if (obj instanceof Boolean) {
                        z = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i3, i7);
                    } else if (obj instanceof byte[]) {
                        z = cursorWindow.putBlob((byte[]) obj, i3, i7);
                    } else if (obj instanceof Double) {
                        z = cursorWindow.putDouble(((Double) obj).doubleValue(), i3, i7);
                    } else if (obj instanceof Float) {
                        z = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i3, i7);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                if (z) {
                    i5 = i3;
                    i6 = 0;
                    cursorWindow2 = cursorWindow;
                } else if (i4 != 0) {
                    throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i3 + " - allocating new window.");
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(com_google_android_gms_common_data_DataHolder_zza.zzahA.length);
                    arrayList.add(cursorWindow3);
                    i5 = i3 - 1;
                    cursorWindow2 = cursorWindow3;
                    i6 = 1;
                }
                i4 = i6;
                cursorWindow = cursorWindow2;
                i3 = i5 + 1;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                size = arrayList.size();
                while (i2 < size) {
                    ((CursorWindow) arrayList.get(i2)).close();
                    i2++;
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder zzbJ(int i) {
        return zza(i, null);
    }

    private void zzg(String str, int i) {
        if (this.zzahB == null || !this.zzahB.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.zzahF) {
            throw new CursorIndexOutOfBoundsException(i, this.zzahF);
        }
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.zzahC) {
                    close.close();
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.zzahH && this.zzahC.length > 0 && !isClosed()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + (this.zzahG == null ? "internal object: " + toString() : this.zzahG.toString()) + ")");
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public int getCount() {
        return this.zzahF;
    }

    public int getStatusCode() {
        return this.zzabx;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }

    public void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zzg(str, i);
        this.zzahC[i2].copyStringToBuffer(i, this.zzahB.getInt(str), charArrayBuffer);
    }

    public long zzb(String str, int i, int i2) {
        zzg(str, i);
        return this.zzahC[i2].getLong(i, this.zzahB.getInt(str));
    }

    public int zzbI(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.zzahF;
        zzx.zzaa(z);
        while (i2 < this.zzahE.length) {
            if (i < this.zzahE[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.zzahE.length ? i2 - 1 : i2;
    }

    public int zzc(String str, int i, int i2) {
        zzg(str, i);
        return this.zzahC[i2].getInt(i, this.zzahB.getInt(str));
    }

    public boolean zzct(String str) {
        return this.zzahB.containsKey(str);
    }

    public String zzd(String str, int i, int i2) {
        zzg(str, i);
        return this.zzahC[i2].getString(i, this.zzahB.getInt(str));
    }

    public boolean zze(String str, int i, int i2) {
        zzg(str, i);
        return Long.valueOf(this.zzahC[i2].getLong(i, this.zzahB.getInt(str))).longValue() == 1;
    }

    public float zzf(String str, int i, int i2) {
        zzg(str, i);
        return this.zzahC[i2].getFloat(i, this.zzahB.getInt(str));
    }

    public byte[] zzg(String str, int i, int i2) {
        zzg(str, i);
        return this.zzahC[i2].getBlob(i, this.zzahB.getInt(str));
    }

    public Uri zzh(String str, int i, int i2) {
        String zzd = zzd(str, i, i2);
        return zzd == null ? null : Uri.parse(zzd);
    }

    public boolean zzi(String str, int i, int i2) {
        zzg(str, i);
        return this.zzahC[i2].isNull(i, this.zzahB.getInt(str));
    }

    public Bundle zzpH() {
        return this.zzahD;
    }

    public void zzpL() {
        int i;
        int i2 = 0;
        this.zzahB = new Bundle();
        for (i = 0; i < this.zzahA.length; i++) {
            this.zzahB.putInt(this.zzahA[i], i);
        }
        this.zzahE = new int[this.zzahC.length];
        i = 0;
        while (i2 < this.zzahC.length) {
            this.zzahE[i2] = i;
            i += this.zzahC[i2].getNumRows() - (i - this.zzahC[i2].getStartPosition());
            i2++;
        }
        this.zzahF = i;
    }

    String[] zzpM() {
        return this.zzahA;
    }

    CursorWindow[] zzpN() {
        return this.zzahC;
    }

    public void zzt(Object obj) {
        this.zzahG = obj;
    }
}
