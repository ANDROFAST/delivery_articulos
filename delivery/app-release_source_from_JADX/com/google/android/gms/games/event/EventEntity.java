package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zznn;

public final class EventEntity implements SafeParcelable, Event {
    public static final EventEntityCreator CREATOR = new EventEntityCreator();
    private final String mName;
    private final int mVersionCode;
    private final PlayerEntity zzaAL;
    private final String zzaBp;
    private final long zzaBq;
    private final String zzaBr;
    private final boolean zzaBs;
    private final String zzavc;
    private final Uri zzazC;
    private final String zzazN;

    EventEntity(int versionCode, String eventId, String name, String description, Uri iconImageUri, String iconImageUrl, Player player, long value, String formattedValue, boolean isVisible) {
        this.mVersionCode = versionCode;
        this.zzaBp = eventId;
        this.mName = name;
        this.zzavc = description;
        this.zzazC = iconImageUri;
        this.zzazN = iconImageUrl;
        this.zzaAL = new PlayerEntity(player);
        this.zzaBq = value;
        this.zzaBr = formattedValue;
        this.zzaBs = isVisible;
    }

    public EventEntity(Event event) {
        this.mVersionCode = 1;
        this.zzaBp = event.getEventId();
        this.mName = event.getName();
        this.zzavc = event.getDescription();
        this.zzazC = event.getIconImageUri();
        this.zzazN = event.getIconImageUrl();
        this.zzaAL = (PlayerEntity) event.getPlayer().freeze();
        this.zzaBq = event.getValue();
        this.zzaBr = event.getFormattedValue();
        this.zzaBs = event.isVisible();
    }

    static int zza(Event event) {
        return zzw.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    static boolean zza(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return zzw.equal(event2.getEventId(), event.getEventId()) && zzw.equal(event2.getName(), event.getName()) && zzw.equal(event2.getDescription(), event.getDescription()) && zzw.equal(event2.getIconImageUri(), event.getIconImageUri()) && zzw.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && zzw.equal(event2.getPlayer(), event.getPlayer()) && zzw.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && zzw.equal(event2.getFormattedValue(), event.getFormattedValue()) && zzw.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    static String zzb(Event event) {
        return zzw.zzx(event).zzg("Id", event.getEventId()).zzg("Name", event.getName()).zzg("Description", event.getDescription()).zzg("IconImageUri", event.getIconImageUri()).zzg("IconImageUrl", event.getIconImageUrl()).zzg("Player", event.getPlayer()).zzg("Value", Long.valueOf(event.getValue())).zzg("FormattedValue", event.getFormattedValue()).zzg("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Event freeze() {
        return this;
    }

    public String getDescription() {
        return this.zzavc;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zznn.zzb(this.zzavc, dataOut);
    }

    public String getEventId() {
        return this.zzaBp;
    }

    public String getFormattedValue() {
        return this.zzaBr;
    }

    public void getFormattedValue(CharArrayBuffer dataOut) {
        zznn.zzb(this.zzaBr, dataOut);
    }

    public Uri getIconImageUri() {
        return this.zzazC;
    }

    public String getIconImageUrl() {
        return this.zzazN;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        zznn.zzb(this.mName, dataOut);
    }

    public Player getPlayer() {
        return this.zzaAL;
    }

    public long getValue() {
        return this.zzaBq;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isVisible() {
        return this.zzaBs;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        EventEntityCreator.zza(this, out, flags);
    }
}
