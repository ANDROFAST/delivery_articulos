package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmt;

public final class zzy {
    public static zza<Long> zzQA = zza.zzb("analytics.max_local_dispatch_millis", 7200000);
    public static zza<Long> zzQB = zza.zzb("analytics.dispatch_alarm_millis", 7200000);
    public static zza<Long> zzQC = zza.zzb("analytics.max_dispatch_alarm_millis", 32400000);
    public static zza<Integer> zzQD = zza.zzd("analytics.max_hits_per_dispatch", 20);
    public static zza<Integer> zzQE = zza.zzd("analytics.max_hits_per_batch", 20);
    public static zza<String> zzQF = zza.zzm("analytics.insecure_host", "http://www.google-analytics.com");
    public static zza<String> zzQG = zza.zzm("analytics.secure_host", "https://ssl.google-analytics.com");
    public static zza<String> zzQH = zza.zzm("analytics.simple_endpoint", "/collect");
    public static zza<String> zzQI = zza.zzm("analytics.batching_endpoint", "/batch");
    public static zza<Integer> zzQJ = zza.zzd("analytics.max_get_length", 2036);
    public static zza<String> zzQK = zza.zzd("analytics.batching_strategy.k", zzm.BATCH_BY_COUNT.name(), zzm.BATCH_BY_COUNT.name());
    public static zza<String> zzQL = zza.zzm("analytics.compression_strategy.k", zzo.GZIP.name());
    public static zza<Integer> zzQM = zza.zzd("analytics.max_hits_per_request.k", 20);
    public static zza<Integer> zzQN = zza.zzd("analytics.max_hit_length.k", 8192);
    public static zza<Integer> zzQO = zza.zzd("analytics.max_post_length.k", 8192);
    public static zza<Integer> zzQP = zza.zzd("analytics.max_batch_post_length", 8192);
    public static zza<String> zzQQ = zza.zzm("analytics.fallback_responses.k", "404,502");
    public static zza<Integer> zzQR = zza.zzd("analytics.batch_retry_interval.seconds.k", 3600);
    public static zza<Long> zzQS = zza.zzb("analytics.service_monitor_interval", 86400000);
    public static zza<Integer> zzQT = zza.zzd("analytics.http_connection.connect_timeout_millis", 60000);
    public static zza<Integer> zzQU = zza.zzd("analytics.http_connection.read_timeout_millis", 61000);
    public static zza<Long> zzQV = zza.zzb("analytics.campaigns.time_limit", 86400000);
    public static zza<String> zzQW = zza.zzm("analytics.first_party_experiment_id", "");
    public static zza<Integer> zzQX = zza.zzd("analytics.first_party_experiment_variant", 0);
    public static zza<Boolean> zzQY = zza.zzd("analytics.test.disable_receiver", false);
    public static zza<Long> zzQZ = zza.zza("analytics.service_client.idle_disconnect_millis", 10000, 10000);
    public static zza<Boolean> zzQp = zza.zzd("analytics.service_enabled", false);
    public static zza<Boolean> zzQq = zza.zzd("analytics.service_client_enabled", true);
    public static zza<String> zzQr = zza.zzd("analytics.log_tag", "GAv4", "GAv4-SVC");
    public static zza<Long> zzQs = zza.zzb("analytics.max_tokens", 60);
    public static zza<Float> zzQt = zza.zza("analytics.tokens_per_sec", 0.5f);
    public static zza<Integer> zzQu = zza.zza("analytics.max_stored_hits", 2000, 20000);
    public static zza<Integer> zzQv = zza.zzd("analytics.max_stored_hits_per_app", 2000);
    public static zza<Integer> zzQw = zza.zzd("analytics.max_stored_properties_per_app", 100);
    public static zza<Long> zzQx = zza.zza("analytics.local_dispatch_millis", 1800000, 120000);
    public static zza<Long> zzQy = zza.zza("analytics.initial_local_dispatch_millis", 5000, 5000);
    public static zza<Long> zzQz = zza.zzb("analytics.min_local_dispatch_millis", 120000);
    public static zza<Long> zzRa = zza.zzb("analytics.service_client.connect_timeout_millis", 5000);
    public static zza<Long> zzRb = zza.zzb("analytics.service_client.second_connect_delay_millis", 5000);
    public static zza<Long> zzRc = zza.zzb("analytics.service_client.unexpected_reconnect_millis", 60000);
    public static zza<Long> zzRd = zza.zzb("analytics.service_client.reconnect_throttle_millis", 1800000);
    public static zza<Long> zzRe = zza.zzb("analytics.monitoring.sample_period_millis", 86400000);
    public static zza<Long> zzRf = zza.zzb("analytics.initialization_warning_threshold", 5000);

    public static final class zza<V> {
        private final V zzRg;
        private final zzmt<V> zzRh;
        private V zzRi;

        private zza(zzmt<V> com_google_android_gms_internal_zzmt_V, V v) {
            zzx.zzy(com_google_android_gms_internal_zzmt_V);
            this.zzRh = com_google_android_gms_internal_zzmt_V;
            this.zzRg = v;
        }

        static zza<Float> zza(String str, float f) {
            return zza(str, f, f);
        }

        static zza<Float> zza(String str, float f, float f2) {
            return new zza(zzmt.zza(str, Float.valueOf(f2)), Float.valueOf(f));
        }

        static zza<Integer> zza(String str, int i, int i2) {
            return new zza(zzmt.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static zza<Long> zza(String str, long j, long j2) {
            return new zza(zzmt.zza(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static zza<Boolean> zza(String str, boolean z, boolean z2) {
            return new zza(zzmt.zzg(str, z2), Boolean.valueOf(z));
        }

        static zza<Long> zzb(String str, long j) {
            return zza(str, j, j);
        }

        static zza<Integer> zzd(String str, int i) {
            return zza(str, i, i);
        }

        static zza<String> zzd(String str, String str2, String str3) {
            return new zza(zzmt.zzw(str, str3), str2);
        }

        static zza<Boolean> zzd(String str, boolean z) {
            return zza(str, z, z);
        }

        static zza<String> zzm(String str, String str2) {
            return zzd(str, str2, str2);
        }

        public V get() {
            return this.zzRi != null ? this.zzRi : (zzd.zzaiU && zzmt.isInitialized()) ? this.zzRh.zzpF() : this.zzRg;
        }
    }
}
