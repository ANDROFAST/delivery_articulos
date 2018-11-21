package com.google.android.gms.fitness;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.concurrent.TimeUnit;

public interface HistoryApi {

    public static class ViewIntentBuilder {
        private final Context mContext;
        private long zzQj;
        private final DataType zzatO;
        private DataSource zzatP;
        private long zzatQ;
        private String zzatR;

        public ViewIntentBuilder(Context context, DataType dataType) {
            this.mContext = context;
            this.zzatO = dataType;
        }

        private Intent zzl(Intent intent) {
            if (this.zzatR == null) {
                return intent;
            }
            Intent intent2 = new Intent(intent).setPackage(this.zzatR);
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent2, 0);
            if (resolveActivity == null) {
                return intent;
            }
            intent2.setComponent(new ComponentName(this.zzatR, resolveActivity.activityInfo.name));
            return intent2;
        }

        public Intent build() {
            boolean z = true;
            zzx.zza(this.zzQj > 0, (Object) "Start time must be set");
            if (this.zzatQ <= this.zzQj) {
                z = false;
            }
            zzx.zza(z, (Object) "End time must be set and after start time");
            Intent intent = new Intent(Fitness.ACTION_VIEW);
            intent.setType(DataType.getMimeType(this.zzatP.getDataType()));
            intent.putExtra(Fitness.EXTRA_START_TIME, this.zzQj);
            intent.putExtra(Fitness.EXTRA_END_TIME, this.zzatQ);
            zzc.zza(this.zzatP, intent, DataSource.EXTRA_DATA_SOURCE);
            return zzl(intent);
        }

        public ViewIntentBuilder setDataSource(DataSource dataSource) {
            zzx.zzb(dataSource.getDataType().equals(this.zzatO), "Data source %s is not for the data type %s", dataSource, this.zzatO);
            this.zzatP = dataSource;
            return this;
        }

        public ViewIntentBuilder setPreferredApplication(String packageName) {
            this.zzatR = packageName;
            return this;
        }

        public ViewIntentBuilder setTimeInterval(long start, long end, TimeUnit timeUnit) {
            this.zzQj = timeUnit.toMillis(start);
            this.zzatQ = timeUnit.toMillis(end);
            return this;
        }
    }

    PendingResult<Status> deleteData(GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest);

    PendingResult<Status> insertData(GoogleApiClient googleApiClient, DataSet dataSet);

    PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient googleApiClient, DataType dataType);

    PendingResult<DataReadResult> readData(GoogleApiClient googleApiClient, DataReadRequest dataReadRequest);
}
