package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder implements SafeParcelable {
    public static final Creator<FilterHolder> CREATOR = new zzd();
    final int mVersionCode;
    private final Filter zzanm;
    final ComparisonFilter<?> zzase;
    final FieldOnlyFilter zzasf;
    final LogicalFilter zzasg;
    final NotFilter zzash;
    final InFilter<?> zzasi;
    final MatchAllFilter zzasj;
    final HasFilter zzask;
    final FullTextSearchFilter zzasl;
    final OwnedByMeFilter zzasm;

    FilterHolder(int versionCode, ComparisonFilter<?> comparisonField, FieldOnlyFilter fieldOnlyFilter, LogicalFilter logicalFilter, NotFilter notFilter, InFilter<?> containsFilter, MatchAllFilter matchAllFilter, HasFilter<?> hasFilter, FullTextSearchFilter fullTextSearchFilter, OwnedByMeFilter ownedByMeFilter) {
        this.mVersionCode = versionCode;
        this.zzase = comparisonField;
        this.zzasf = fieldOnlyFilter;
        this.zzasg = logicalFilter;
        this.zzash = notFilter;
        this.zzasi = containsFilter;
        this.zzasj = matchAllFilter;
        this.zzask = hasFilter;
        this.zzasl = fullTextSearchFilter;
        this.zzasm = ownedByMeFilter;
        if (this.zzase != null) {
            this.zzanm = this.zzase;
        } else if (this.zzasf != null) {
            this.zzanm = this.zzasf;
        } else if (this.zzasg != null) {
            this.zzanm = this.zzasg;
        } else if (this.zzash != null) {
            this.zzanm = this.zzash;
        } else if (this.zzasi != null) {
            this.zzanm = this.zzasi;
        } else if (this.zzasj != null) {
            this.zzanm = this.zzasj;
        } else if (this.zzask != null) {
            this.zzanm = this.zzask;
        } else if (this.zzasl != null) {
            this.zzanm = this.zzasl;
        } else if (this.zzasm != null) {
            this.zzanm = this.zzasm;
        } else {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public FilterHolder(Filter filter) {
        zzx.zzb((Object) filter, (Object) "Null filter.");
        this.mVersionCode = 2;
        this.zzase = filter instanceof ComparisonFilter ? (ComparisonFilter) filter : null;
        this.zzasf = filter instanceof FieldOnlyFilter ? (FieldOnlyFilter) filter : null;
        this.zzasg = filter instanceof LogicalFilter ? (LogicalFilter) filter : null;
        this.zzash = filter instanceof NotFilter ? (NotFilter) filter : null;
        this.zzasi = filter instanceof InFilter ? (InFilter) filter : null;
        this.zzasj = filter instanceof MatchAllFilter ? (MatchAllFilter) filter : null;
        this.zzask = filter instanceof HasFilter ? (HasFilter) filter : null;
        this.zzasl = filter instanceof FullTextSearchFilter ? (FullTextSearchFilter) filter : null;
        this.zzasm = filter instanceof OwnedByMeFilter ? (OwnedByMeFilter) filter : null;
        if (this.zzase == null && this.zzasf == null && this.zzasg == null && this.zzash == null && this.zzasi == null && this.zzasj == null && this.zzask == null && this.zzasl == null && this.zzasm == null) {
            throw new IllegalArgumentException("Invalid filter type.");
        }
        this.zzanm = filter;
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzanm;
    }

    public String toString() {
        return String.format("FilterHolder[%s]", new Object[]{this.zzanm});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }
}
