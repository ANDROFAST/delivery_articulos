package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzno;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class zzw implements zzc {
    private static final String zzbdu = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    private final Context mContext;
    private final Executor zzbdv;
    private zza zzbdw;
    private int zzbdx;
    private zznl zzqD;

    class zza extends SQLiteOpenHelper {
        final /* synthetic */ zzw zzbdA;

        zza(zzw com_google_android_gms_tagmanager_zzw, Context context, String str) {
            this.zzbdA = com_google_android_gms_tagmanager_zzw;
            super(context, str, null, 1);
        }

        private boolean zza(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        zzbg.zzaH("Error querying for table " + str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                zzbg.zzaH("Error querying for table " + str);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        private void zzc(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.zzbdA.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        public void onCreate(SQLiteDatabase db) {
            zzal.zzbl(db.getPath());
        }

        public void onOpen(SQLiteDatabase db) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (zza("datalayer", db)) {
                zzc(db);
            } else {
                db.execSQL(zzw.zzbdu);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    private static class zzb {
        final byte[] zzbdD;
        final String zzuX;

        zzb(String str, byte[] bArr) {
            this.zzuX = str;
            this.zzbdD = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.zzuX + " serialized hash = " + Arrays.hashCode(this.zzbdD);
        }
    }

    public zzw(Context context) {
        this(context, zzno.zzrM(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    zzw(Context context, zznl com_google_android_gms_internal_zznl, String str, int i, Executor executor) {
        this.mContext = context;
        this.zzqD = com_google_android_gms_internal_zznl;
        this.zzbdx = i;
        this.zzbdv = executor;
        this.zzbdw = new zza(this, this.mContext, str);
    }

    private List<zzb> zzA(List<zza> list) {
        List<zzb> arrayList = new ArrayList();
        for (zza com_google_android_gms_tagmanager_DataLayer_zza : list) {
            arrayList.add(new zzb(com_google_android_gms_tagmanager_DataLayer_zza.zzuX, zzJ(com_google_android_gms_tagmanager_DataLayer_zza.zzLI)));
        }
        return arrayList;
    }

    private List<zza> zzEv() {
        try {
            zzW(this.zzqD.currentTimeMillis());
            List<zza> zzz = zzz(zzEw());
            return zzz;
        } finally {
            zzEy();
        }
    }

    private List<zzb> zzEw() {
        SQLiteDatabase zzfn = zzfn("Error opening database for loadSerialized.");
        List<zzb> arrayList = new ArrayList();
        if (zzfn == null) {
            return arrayList;
        }
        Cursor query = zzfn.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzb(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int zzEx() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase zzfn = zzfn("Error opening database for getNumStoredEntries.");
        if (zzfn != null) {
            try {
                cursor = zzfn.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                zzbg.zzaH("Error getting numStoredEntries");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    private void zzEy() {
        try {
            this.zzbdw.close();
        } catch (SQLiteException e) {
        }
    }

    private byte[] zzJ(Object obj) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private void zzW(long j) {
        SQLiteDatabase zzfn = zzfn("Error opening database for deleteOlderThan.");
        if (zzfn != null) {
            try {
                zzbg.m10v("Deleted " + zzfn.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                zzbg.zzaH("Error deleting old entries.");
            }
        }
    }

    private synchronized void zzb(List<zzb> list, long j) {
        try {
            long currentTimeMillis = this.zzqD.currentTimeMillis();
            zzW(currentTimeMillis);
            zzjO(list.size());
            zzc(list, currentTimeMillis + j);
            zzEy();
        } catch (Throwable th) {
            zzEy();
        }
    }

    private void zzc(List<zzb> list, long j) {
        SQLiteDatabase zzfn = zzfn("Error opening database for writeEntryToDatabase.");
        if (zzfn != null) {
            for (zzb com_google_android_gms_tagmanager_zzw_zzb : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", com_google_android_gms_tagmanager_zzw_zzb.zzuX);
                contentValues.put("value", com_google_android_gms_tagmanager_zzw_zzb.zzbdD);
                zzfn.insert("datalayer", null, contentValues);
            }
        }
    }

    private void zze(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase zzfn = zzfn("Error opening database for deleteEntries.");
            if (zzfn != null) {
                try {
                    zzfn.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    zzbg.zzaH("Error deleting entries " + Arrays.toString(strArr));
                }
            }
        }
    }

    private void zzfm(String str) {
        SQLiteDatabase zzfn = zzfn("Error opening database for clearKeysWithPrefix.");
        if (zzfn != null) {
            try {
                zzbg.m10v("Cleared " + zzfn.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                zzbg.zzaH("Error deleting entries with key prefix: " + str + " (" + e + ").");
            } finally {
                zzEy();
            }
        }
    }

    private SQLiteDatabase zzfn(String str) {
        try {
            return this.zzbdw.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbg.zzaH(str);
            return null;
        }
    }

    private void zzjO(int i) {
        int zzEx = (zzEx() - this.zzbdx) + i;
        if (zzEx > 0) {
            List zzjP = zzjP(zzEx);
            zzbg.zzaG("DataLayer store full, deleting " + zzjP.size() + " entries to make room.");
            zze((String[]) zzjP.toArray(new String[0]));
        }
    }

    private List<String> zzjP(int i) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            zzbg.zzaH("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase zzfn = zzfn("Error opening database for peekEntryIds.");
        if (zzfn == null) {
            return arrayList;
        }
        try {
            query = zzfn.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzbg.zzaH("Error in peekEntries fetching entryIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            zzbg.zzaH("Error in peekEntries fetching entryIds: " + e.getMessage());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    private Object zzv(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream.readObject();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayInputStream.close();
            } catch (IOException e2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream = objectInputStream2;
            th = th4;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    private List<zza> zzz(List<zzb> list) {
        List<zza> arrayList = new ArrayList();
        for (zzb com_google_android_gms_tagmanager_zzw_zzb : list) {
            arrayList.add(new zza(com_google_android_gms_tagmanager_zzw_zzb.zzuX, zzv(com_google_android_gms_tagmanager_zzw_zzb.zzbdD)));
        }
        return arrayList;
    }

    public void zza(final com.google.android.gms.tagmanager.DataLayer.zzc.zza com_google_android_gms_tagmanager_DataLayer_zzc_zza) {
        this.zzbdv.execute(new Runnable(this) {
            final /* synthetic */ zzw zzbdA;

            public void run() {
                com_google_android_gms_tagmanager_DataLayer_zzc_zza.zzy(this.zzbdA.zzEv());
            }
        });
    }

    public void zza(List<zza> list, final long j) {
        final List zzA = zzA(list);
        this.zzbdv.execute(new Runnable(this) {
            final /* synthetic */ zzw zzbdA;

            public void run() {
                this.zzbdA.zzb(zzA, j);
            }
        });
    }

    public void zzfl(final String str) {
        this.zzbdv.execute(new Runnable(this) {
            final /* synthetic */ zzw zzbdA;

            public void run() {
                this.zzbdA.zzfm(str);
            }
        });
    }
}
