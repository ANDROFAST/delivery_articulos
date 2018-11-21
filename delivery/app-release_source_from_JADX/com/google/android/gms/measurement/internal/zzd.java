package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztd;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzd extends zzw {
    private static final Map<String, String> zzaSu = new ArrayMap(5);
    private final zza zzaSv = new zza(this, getContext(), zzjz());
    private final zzaa zzaSw = new zzaa(zziT());

    private class zza extends SQLiteOpenHelper {
        final /* synthetic */ zzd zzaSx;

        zza(zzd com_google_android_gms_measurement_internal_zzd, Context context, String str) {
            this.zzaSx = com_google_android_gms_measurement_internal_zzd;
            super(context, str, null, 1);
        }

        private void zza(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map<String, String> map) throws SQLiteException {
            if (!zza(sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                zza(sQLiteDatabase, str, str3, map);
            } catch (SQLiteException e) {
                this.zzaSx.zzzz().zzBl().zzj("Failed to verify columns on table that was just created", str);
                throw e;
            }
        }

        private void zza(SQLiteDatabase sQLiteDatabase, String str, String str2, Map<String, String> map) throws SQLiteException {
            Set zzb = zzb(sQLiteDatabase, str);
            String[] split = str2.split(",");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str3 = split[i];
                if (zzb.remove(str3)) {
                    i++;
                } else {
                    throw new SQLiteException("Database " + str + " is missing required column: " + str3);
                }
            }
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (!zzb.remove(entry.getKey())) {
                        sQLiteDatabase.execSQL((String) entry.getValue());
                    }
                }
            }
            if (!zzb.isEmpty()) {
                throw new SQLiteException("Database " + str + " table has extra columns");
            }
        }

        private boolean zza(SQLiteDatabase sQLiteDatabase, String str) {
            Object e;
            Throwable th;
            Cursor cursor = null;
            Cursor query;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        this.zzaSx.zzzz().zzBm().zze("Error querying for table", str, e);
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                this.zzaSx.zzzz().zzBm().zze("Error querying for table", str, e);
                if (query != null) {
                    query.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        private Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
            Set<String> hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
            try {
                Collections.addAll(hashSet, rawQuery.getColumnNames());
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (this.zzaSx.zzaSw.zzv(this.zzaSx.zzAX().zzAA())) {
                SQLiteDatabase writableDatabase;
                try {
                    writableDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.zzaSx.zzaSw.start();
                    this.zzaSx.zzzz().zzBl().zzez("Opening the database failed, dropping and recreating it");
                    this.zzaSx.getContext().getDatabasePath(this.zzaSx.zzjz()).delete();
                    try {
                        writableDatabase = super.getWritableDatabase();
                        this.zzaSx.zzaSw.clear();
                    } catch (SQLiteException e2) {
                        this.zzaSx.zzzz().zzBl().zzj("Failed to open freshly created database", e2);
                        throw e2;
                    }
                }
                return writableDatabase;
            }
            throw new SQLiteException("Database open failed");
        }

        public void onCreate(SQLiteDatabase database) {
            if (VERSION.SDK_INT >= 9) {
                File file = new File(database.getPath());
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        }

        public void onOpen(SQLiteDatabase database) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = database.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            zza(database, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
            zza(database, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", null);
            zza(database, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zzd.zzaSu);
            zza(database, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", null);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    static {
        zzaSu.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        zzaSu.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        zzaSu.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        zzaSu.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        zzaSu.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
    }

    zzd(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    private boolean zzBc() {
        return getContext().getDatabasePath(zzjz()).exists();
    }

    static int zza(Cursor cursor, int i) {
        if (VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        return window.isNull(position, i) ? 0 : window.isLong(position, i) ? 1 : window.isFloat(position, i) ? 2 : window.isString(position, i) ? 3 : window.isBlob(position, i) ? 4 : -1;
    }

    private long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzzz().zzBl().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private String zzjz() {
        if (!zzAX().zzka()) {
            return zzAX().zzkA();
        }
        if (zzAX().zzkb()) {
            return zzAX().zzkA();
        }
        zzzz().zzBn().zzez("Using secondary database");
        return zzAX().zzkB();
    }

    public void beginTransaction() {
        zzje();
        getWritableDatabase().beginTransaction();
    }

    public void endTransaction() {
        zzje();
        getWritableDatabase().endTransaction();
    }

    SQLiteDatabase getWritableDatabase() {
        zziS();
        try {
            return this.zzaSv.getWritableDatabase();
        } catch (SQLiteException e) {
            zzzz().zzBm().zzj("Error opening database", e);
            throw e;
        }
    }

    public void setTransactionSuccessful() {
        zzje();
        getWritableDatabase().setTransactionSuccessful();
    }

    public String zzAY() {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        try {
            rawQuery = getWritableDatabase().rawQuery("SELECT q.app_id FROM queue q JOIN apps a ON a.app_id=q.app_id WHERE a.measurement_enabled!=0 ORDER BY q.rowid LIMIT 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzzz().zzBl().zzj("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            zzzz().zzBl().zzj("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    void zzAZ() {
        zziS();
        zzje();
        if (zzBc()) {
            long j = zzAW().zzaTI.get();
            long elapsedRealtime = zziT().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > zzAX().zzAG()) {
                zzAW().zzaTI.set(elapsedRealtime);
                zzBa();
            }
        }
    }

    void zzBa() {
        zziS();
        zzje();
        if (zzBc()) {
            int delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zziT().currentTimeMillis()), String.valueOf(zzAX().zzAF())});
            if (delete > 0) {
                zzzz().zzBr().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    public long zzBb() {
        return zza("select max(bundle_end_timestamp) from queue", null, 0);
    }

    public zzh zzL(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        zzx.zzcG(str);
        zzx.zzcG(str2);
        zziS();
        zzje();
        try {
            Cursor query = getWritableDatabase().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    zzh com_google_android_gms_measurement_internal_zzh = new zzh(str, str2, query.getLong(0), query.getLong(1), query.getLong(2));
                    if (query.moveToNext()) {
                        zzzz().zzBl().zzez("Got multiple records for event aggregates, expected one");
                    }
                    if (query == null) {
                        return com_google_android_gms_measurement_internal_zzh;
                    }
                    query.close();
                    return com_google_android_gms_measurement_internal_zzh;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    zzzz().zzBl().zzd("Error querying events", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
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
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzzz().zzBl().zzd("Error querying events", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public void zzM(String str, String str2) {
        zzx.zzcG(str);
        zzx.zzcG(str2);
        zziS();
        zzje();
        try {
            zzzz().zzBr().zzj("Deleted user attribute rows:", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzzz().zzBl().zzd("Error deleting user attribute", str, str2, e);
        }
    }

    public void zzP(long j) {
        zziS();
        zzje();
        if (getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            zzzz().zzBl().zzez("Deleted fewer rows from queue than expected");
        }
    }

    void zza(ContentValues contentValues, String str, Object obj) {
        zzx.zzcG(str);
        zzx.zzy(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Float) {
            contentValues.put(str, (Float) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public void zza(com.google.android.gms.internal.zzqq.zzd com_google_android_gms_internal_zzqq_zzd) {
        zziS();
        zzje();
        zzx.zzy(com_google_android_gms_internal_zzqq_zzd);
        zzx.zzcG(com_google_android_gms_internal_zzqq_zzd.appId);
        zzx.zzy(com_google_android_gms_internal_zzqq_zzd.zzaVw);
        zzAZ();
        long currentTimeMillis = zziT().currentTimeMillis();
        if (com_google_android_gms_internal_zzqq_zzd.zzaVw.longValue() < currentTimeMillis - zzAX().zzAF() || com_google_android_gms_internal_zzqq_zzd.zzaVw.longValue() > zzAX().zzAF() + currentTimeMillis) {
            zzzz().zzBm().zze("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(currentTimeMillis), com_google_android_gms_internal_zzqq_zzd.zzaVw);
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzqq_zzd.getSerializedSize()];
            zztd zzD = zztd.zzD(bArr);
            com_google_android_gms_internal_zzqq_zzd.writeTo(zzD);
            zzD.zzHy();
            bArr = zzAU().zzg(bArr);
            zzzz().zzBr().zzj("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_internal_zzqq_zzd.appId);
            contentValues.put("bundle_end_timestamp", com_google_android_gms_internal_zzqq_zzd.zzaVw);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) == -1) {
                    zzzz().zzBl().zzez("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                zzzz().zzBl().zzj("Error storing bundle", e);
            }
        } catch (IOException e2) {
            zzzz().zzBl().zzj("Data loss. Failed to serialize bundle", e2);
        }
    }

    public void zza(zza com_google_android_gms_measurement_internal_zza) {
        zzx.zzy(com_google_android_gms_measurement_internal_zza);
        zziS();
        zzje();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_measurement_internal_zza.zzaRd);
        contentValues.put("app_instance_id", com_google_android_gms_measurement_internal_zza.zzaSe);
        contentValues.put("gmp_app_id", com_google_android_gms_measurement_internal_zza.zzaSf);
        contentValues.put("resettable_device_id_hash", com_google_android_gms_measurement_internal_zza.zzaSg);
        contentValues.put("last_bundle_index", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzaSh));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzaSi));
        contentValues.put("app_version", com_google_android_gms_measurement_internal_zza.zzRl);
        contentValues.put("app_store", com_google_android_gms_measurement_internal_zza.zzaSj);
        contentValues.put("gmp_version", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzaSk));
        contentValues.put("dev_cert_hash", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzaSl));
        contentValues.put("measurement_enabled", Boolean.valueOf(com_google_android_gms_measurement_internal_zza.zzaSm));
        try {
            if (getWritableDatabase().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzzz().zzBl().zzez("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            zzzz().zzBl().zzj("Error storing app", e);
        }
    }

    public void zza(zzac com_google_android_gms_measurement_internal_zzac) {
        zzx.zzy(com_google_android_gms_measurement_internal_zzac);
        zziS();
        zzje();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_measurement_internal_zzac.zzaRd);
        contentValues.put("name", com_google_android_gms_measurement_internal_zzac.mName);
        contentValues.put("set_timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zzac.zzaVf));
        zza(contentValues, "value", com_google_android_gms_measurement_internal_zzac.zzLI);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzzz().zzBl().zzez("Failed to insert/update user attribute (got -1)");
            }
        } catch (SQLiteException e) {
            zzzz().zzBl().zzj("Error storing user attribute", e);
        }
    }

    public void zza(zzh com_google_android_gms_measurement_internal_zzh) {
        zzx.zzy(com_google_android_gms_measurement_internal_zzh);
        zziS();
        zzje();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_measurement_internal_zzh.zzaRd);
        contentValues.put("name", com_google_android_gms_measurement_internal_zzh.mName);
        contentValues.put("lifetime_count", Long.valueOf(com_google_android_gms_measurement_internal_zzh.zzaSF));
        contentValues.put("current_bundle_count", Long.valueOf(com_google_android_gms_measurement_internal_zzh.zzaSG));
        contentValues.put("last_fire_timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zzh.zzaSH));
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzzz().zzBl().zzez("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            zzzz().zzBl().zzj("Error storing event aggregates", e);
        }
    }

    Object zzb(Cursor cursor, int i) {
        int zza = zza(cursor, i);
        switch (zza) {
            case 0:
                zzzz().zzBl().zzez("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Float.valueOf(cursor.getFloat(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzzz().zzBl().zzez("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzzz().zzBl().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(zza));
                return null;
        }
    }

    public List<zzac> zzev(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        zzx.zzcG(str);
        zziS();
        zzje();
        List<zzac> arrayList = new ArrayList();
        Cursor query;
        try {
            query = getWritableDatabase().query("user_attributes", new String[]{"name", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(zzAX().zzAz() + 1));
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        long j = query.getLong(1);
                        Object zzb = zzb(query, 2);
                        if (zzb == null) {
                            zzzz().zzBl().zzez("Read invalid user attribute value, ignoring it");
                        } else {
                            arrayList.add(new zzac(str, string, j, zzb));
                        }
                    } while (query.moveToNext());
                    if (arrayList.size() > zzAX().zzAz()) {
                        zzzz().zzBl().zzez("Loaded too many user attributes");
                        arrayList.remove(zzAX().zzAz());
                    }
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                zzzz().zzBl().zze("Error querying user attributes", str, e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public zza zzew(String str) {
        zza com_google_android_gms_measurement_internal_zza;
        Object e;
        Cursor cursor;
        Throwable th;
        zzx.zzcG(str);
        zziS();
        zzje();
        Cursor cursor2 = null;
        try {
            Cursor query = getWritableDatabase().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    com_google_android_gms_measurement_internal_zza = new zza(str, query.getString(0), query.getString(1), query.getString(2), query.getLong(3), query.getLong(4), query.getString(5), query.getString(6), query.getLong(7), query.getLong(8), (query.isNull(9) ? 1 : query.getInt(9)) != 0);
                    if (query.moveToNext()) {
                        zzzz().zzBl().zzez("Got multiple records for app, expected one");
                    }
                    if (query != null) {
                        query.close();
                    }
                } else {
                    com_google_android_gms_measurement_internal_zza = null;
                    if (query != null) {
                        query.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    zzzz().zzBl().zze("Error querying app", str, e);
                    com_google_android_gms_measurement_internal_zza = null;
                    if (cursor != null) {
                        cursor.close();
                    }
                    return com_google_android_gms_measurement_internal_zza;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
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
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzzz().zzBl().zze("Error querying app", str, e);
            com_google_android_gms_measurement_internal_zza = null;
            if (cursor != null) {
                cursor.close();
            }
            return com_google_android_gms_measurement_internal_zza;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        return com_google_android_gms_measurement_internal_zza;
    }

    protected void zzir() {
    }

    public List<Pair<com.google.android.gms.internal.zzqq.zzd, Long>> zzn(String str, int i, int i2) {
        List<Pair<com.google.android.gms.internal.zzqq.zzd, Long>> arrayList;
        Object e;
        Cursor cursor;
        Throwable th;
        boolean z = true;
        zziS();
        zzje();
        zzx.zzab(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        zzx.zzab(z);
        zzx.zzcG(str);
        Cursor query;
        try {
            query = getWritableDatabase().query("queue", new String[]{"rowid", "data"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        long j = query.getLong(0);
                        int length;
                        try {
                            byte[] zzq = zzAU().zzq(query.getBlob(1));
                            if (!arrayList.isEmpty() && zzq.length + i3 > i2) {
                                break;
                            }
                            zztc zzC = zztc.zzC(zzq);
                            com.google.android.gms.internal.zzqq.zzd com_google_android_gms_internal_zzqq_zzd = new com.google.android.gms.internal.zzqq.zzd();
                            try {
                                com_google_android_gms_internal_zzqq_zzd.zzw(zzC);
                                length = zzq.length + i3;
                                arrayList.add(Pair.create(com_google_android_gms_internal_zzqq_zzd, Long.valueOf(j)));
                            } catch (IOException e2) {
                                zzzz().zzBl().zze("Failed to merge queued bundle", str, e2);
                                length = i3;
                            }
                            if (!query.moveToNext() || length > i2) {
                                break;
                            }
                            i3 = length;
                        } catch (IOException e22) {
                            zzzz().zzBl().zze("Failed to unzip queued bundle", str, e22);
                            length = i3;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } else {
                    arrayList = Collections.emptyList();
                    if (query != null) {
                        query.close();
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                zzzz().zzBl().zze("Error querying bundles", str, e);
                arrayList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }
}
