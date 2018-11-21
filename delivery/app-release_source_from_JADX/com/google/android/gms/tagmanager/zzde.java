package com.google.android.gms.tagmanager;

class zzde extends Number implements Comparable<zzde> {
    private double zzbgv;
    private long zzbgw;
    private boolean zzbgx = false;

    private zzde(double d) {
        this.zzbgv = d;
    }

    private zzde(long j) {
        this.zzbgw = j;
    }

    public static zzde zzX(long j) {
        return new zzde(j);
    }

    public static zzde zza(Double d) {
        return new zzde(d.doubleValue());
    }

    public static zzde zzfE(String str) throws NumberFormatException {
        try {
            return new zzde(Long.parseLong(str));
        } catch (NumberFormatException e) {
            try {
                return new zzde(Double.parseDouble(str));
            } catch (NumberFormatException e2) {
                throw new NumberFormatException(str + " is not a valid TypedNumber");
            }
        }
    }

    public byte byteValue() {
        return (byte) ((int) longValue());
    }

    public /* synthetic */ int compareTo(Object x0) {
        return zza((zzde) x0);
    }

    public double doubleValue() {
        return zzFz() ? (double) this.zzbgw : this.zzbgv;
    }

    public boolean equals(Object other) {
        return (other instanceof zzde) && zza((zzde) other) == 0;
    }

    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public int intValue() {
        return zzFB();
    }

    public long longValue() {
        return zzFA();
    }

    public short shortValue() {
        return zzFC();
    }

    public String toString() {
        return zzFz() ? Long.toString(this.zzbgw) : Double.toString(this.zzbgv);
    }

    public long zzFA() {
        return zzFz() ? this.zzbgw : (long) this.zzbgv;
    }

    public int zzFB() {
        return (int) longValue();
    }

    public short zzFC() {
        return (short) ((int) longValue());
    }

    public boolean zzFy() {
        return !zzFz();
    }

    public boolean zzFz() {
        return this.zzbgx;
    }

    public int zza(zzde com_google_android_gms_tagmanager_zzde) {
        return (zzFz() && com_google_android_gms_tagmanager_zzde.zzFz()) ? new Long(this.zzbgw).compareTo(Long.valueOf(com_google_android_gms_tagmanager_zzde.zzbgw)) : Double.compare(doubleValue(), com_google_android_gms_tagmanager_zzde.doubleValue());
    }
}
