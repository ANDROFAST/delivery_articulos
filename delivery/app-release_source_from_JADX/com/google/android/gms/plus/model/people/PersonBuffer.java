package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.internal.model.people.zzk;

public final class PersonBuffer extends AbstractDataBuffer<Person> {
    private final zzd<PersonEntity> zzbbg;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.zzpH() == null || !dataHolder.zzpH().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.zzbbg = null;
        } else {
            this.zzbbg = new zzd(dataHolder, PersonEntity.CREATOR);
        }
    }

    public Person get(int position) {
        return this.zzbbg != null ? (Person) this.zzbbg.zzbH(position) : new zzk(this.zzafC, position);
    }
}
