package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T> extends AbstractDataBuffer<T> {
    private boolean zzahO = false;
    private ArrayList<Integer> zzahP;

    protected zzf(DataHolder dataHolder) {
        super(dataHolder);
    }

    private void zzpP() {
        synchronized (this) {
            if (!this.zzahO) {
                int count = this.zzafC.getCount();
                this.zzahP = new ArrayList();
                if (count > 0) {
                    this.zzahP.add(Integer.valueOf(0));
                    String zzpO = zzpO();
                    String zzd = this.zzafC.zzd(zzpO, 0, this.zzafC.zzbI(0));
                    int i = 1;
                    while (i < count) {
                        int zzbI = this.zzafC.zzbI(i);
                        String zzd2 = this.zzafC.zzd(zzpO, i, zzbI);
                        if (zzd2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + zzpO + ", at row: " + i + ", for window: " + zzbI);
                        }
                        if (zzd2.equals(zzd)) {
                            zzd2 = zzd;
                        } else {
                            this.zzahP.add(Integer.valueOf(i));
                        }
                        i++;
                        zzd = zzd2;
                    }
                }
                this.zzahO = true;
            }
        }
    }

    public final T get(int position) {
        zzpP();
        return zzk(zzbL(position), zzbM(position));
    }

    public int getCount() {
        zzpP();
        return this.zzahP.size();
    }

    int zzbL(int i) {
        if (i >= 0 && i < this.zzahP.size()) {
            return ((Integer) this.zzahP.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    protected int zzbM(int i) {
        if (i < 0 || i == this.zzahP.size()) {
            return 0;
        }
        int count = i == this.zzahP.size() + -1 ? this.zzafC.getCount() - ((Integer) this.zzahP.get(i)).intValue() : ((Integer) this.zzahP.get(i + 1)).intValue() - ((Integer) this.zzahP.get(i)).intValue();
        if (count != 1) {
            return count;
        }
        int zzbL = zzbL(i);
        int zzbI = this.zzafC.zzbI(zzbL);
        String zzpQ = zzpQ();
        return (zzpQ == null || this.zzafC.zzd(zzpQ, zzbL, zzbI) != null) ? count : 0;
    }

    protected abstract T zzk(int i, int i2);

    protected abstract String zzpO();

    protected String zzpQ() {
        return null;
    }
}
