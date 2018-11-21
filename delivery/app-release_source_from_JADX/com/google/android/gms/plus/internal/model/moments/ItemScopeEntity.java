package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ItemScopeEntity extends FastSafeParcelableJsonResponse implements ItemScope {
    public static final zza CREATOR = new zza();
    private static final HashMap<String, Field<?, ?>> zzaZz = new HashMap();
    String mName;
    final int mVersionCode;
    String zzF;
    String zzIx;
    double zzaKR;
    double zzaKS;
    final Set<Integer> zzaZA;
    ItemScopeEntity zzaZB;
    List<String> zzaZC;
    ItemScopeEntity zzaZD;
    String zzaZE;
    String zzaZF;
    String zzaZG;
    List<ItemScopeEntity> zzaZH;
    int zzaZI;
    List<ItemScopeEntity> zzaZJ;
    ItemScopeEntity zzaZK;
    List<ItemScopeEntity> zzaZL;
    String zzaZM;
    String zzaZN;
    ItemScopeEntity zzaZO;
    String zzaZP;
    String zzaZQ;
    List<ItemScopeEntity> zzaZR;
    String zzaZS;
    String zzaZT;
    String zzaZU;
    String zzaZV;
    String zzaZW;
    String zzaZX;
    String zzaZY;
    String zzaZZ;
    String zzavc;
    ItemScopeEntity zzbaa;
    String zzbab;
    String zzbac;
    String zzbad;
    ItemScopeEntity zzbae;
    ItemScopeEntity zzbaf;
    ItemScopeEntity zzbag;
    List<ItemScopeEntity> zzbah;
    String zzbai;
    String zzbaj;
    String zzbak;
    String zzbal;
    ItemScopeEntity zzbam;
    String zzban;
    String zzbao;
    String zzbap;
    ItemScopeEntity zzbaq;
    String zzbar;
    String zzbas;
    String zzbat;
    String zzbau;
    String zztN;
    String zzxX;

    static {
        zzaZz.put("about", Field.zza("about", 2, ItemScopeEntity.class));
        zzaZz.put("additionalName", Field.zzm("additionalName", 3));
        zzaZz.put("address", Field.zza("address", 4, ItemScopeEntity.class));
        zzaZz.put("addressCountry", Field.zzl("addressCountry", 5));
        zzaZz.put("addressLocality", Field.zzl("addressLocality", 6));
        zzaZz.put("addressRegion", Field.zzl("addressRegion", 7));
        zzaZz.put("associated_media", Field.zzb("associated_media", 8, ItemScopeEntity.class));
        zzaZz.put("attendeeCount", Field.zzi("attendeeCount", 9));
        zzaZz.put("attendees", Field.zzb("attendees", 10, ItemScopeEntity.class));
        zzaZz.put("audio", Field.zza("audio", 11, ItemScopeEntity.class));
        zzaZz.put("author", Field.zzb("author", 12, ItemScopeEntity.class));
        zzaZz.put("bestRating", Field.zzl("bestRating", 13));
        zzaZz.put("birthDate", Field.zzl("birthDate", 14));
        zzaZz.put("byArtist", Field.zza("byArtist", 15, ItemScopeEntity.class));
        zzaZz.put("caption", Field.zzl("caption", 16));
        zzaZz.put("contentSize", Field.zzl("contentSize", 17));
        zzaZz.put("contentUrl", Field.zzl("contentUrl", 18));
        zzaZz.put("contributor", Field.zzb("contributor", 19, ItemScopeEntity.class));
        zzaZz.put("dateCreated", Field.zzl("dateCreated", 20));
        zzaZz.put("dateModified", Field.zzl("dateModified", 21));
        zzaZz.put("datePublished", Field.zzl("datePublished", 22));
        zzaZz.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        zzaZz.put("duration", Field.zzl("duration", 24));
        zzaZz.put("embedUrl", Field.zzl("embedUrl", 25));
        zzaZz.put("endDate", Field.zzl("endDate", 26));
        zzaZz.put("familyName", Field.zzl("familyName", 27));
        zzaZz.put("gender", Field.zzl("gender", 28));
        zzaZz.put("geo", Field.zza("geo", 29, ItemScopeEntity.class));
        zzaZz.put("givenName", Field.zzl("givenName", 30));
        zzaZz.put("height", Field.zzl("height", 31));
        zzaZz.put("id", Field.zzl("id", 32));
        zzaZz.put("image", Field.zzl("image", 33));
        zzaZz.put("inAlbum", Field.zza("inAlbum", 34, ItemScopeEntity.class));
        zzaZz.put("latitude", Field.zzj("latitude", 36));
        zzaZz.put("location", Field.zza("location", 37, ItemScopeEntity.class));
        zzaZz.put("longitude", Field.zzj("longitude", 38));
        zzaZz.put("name", Field.zzl("name", 39));
        zzaZz.put("partOfTVSeries", Field.zza("partOfTVSeries", 40, ItemScopeEntity.class));
        zzaZz.put("performers", Field.zzb("performers", 41, ItemScopeEntity.class));
        zzaZz.put("playerType", Field.zzl("playerType", 42));
        zzaZz.put("postOfficeBoxNumber", Field.zzl("postOfficeBoxNumber", 43));
        zzaZz.put("postalCode", Field.zzl("postalCode", 44));
        zzaZz.put("ratingValue", Field.zzl("ratingValue", 45));
        zzaZz.put("reviewRating", Field.zza("reviewRating", 46, ItemScopeEntity.class));
        zzaZz.put("startDate", Field.zzl("startDate", 47));
        zzaZz.put("streetAddress", Field.zzl("streetAddress", 48));
        zzaZz.put("text", Field.zzl("text", 49));
        zzaZz.put("thumbnail", Field.zza("thumbnail", 50, ItemScopeEntity.class));
        zzaZz.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        zzaZz.put("tickerSymbol", Field.zzl("tickerSymbol", 52));
        zzaZz.put("type", Field.zzl("type", 53));
        zzaZz.put(PlusShare.KEY_CALL_TO_ACTION_URL, Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 54));
        zzaZz.put("width", Field.zzl("width", 55));
        zzaZz.put("worstRating", Field.zzl("worstRating", 56));
    }

    public ItemScopeEntity() {
        this.mVersionCode = 1;
        this.zzaZA = new HashSet();
    }

    ItemScopeEntity(Set<Integer> indicatorSet, int versionCode, ItemScopeEntity about, List<String> additionalName, ItemScopeEntity address, String addressCountry, String addressLocality, String addressRegion, List<ItemScopeEntity> associated_media, int attendeeCount, List<ItemScopeEntity> attendees, ItemScopeEntity audio, List<ItemScopeEntity> author, String bestRating, String birthDate, ItemScopeEntity byArtist, String caption, String contentSize, String contentUrl, List<ItemScopeEntity> contributor, String dateCreated, String dateModified, String datePublished, String description, String duration, String embedUrl, String endDate, String familyName, String gender, ItemScopeEntity geo, String givenName, String height, String id, String image, ItemScopeEntity inAlbum, double latitude, ItemScopeEntity location, double longitude, String name, ItemScopeEntity partOfTVSeries, List<ItemScopeEntity> performers, String playerType, String postOfficeBoxNumber, String postalCode, String ratingValue, ItemScopeEntity reviewRating, String startDate, String streetAddress, String text, ItemScopeEntity thumbnail, String thumbnailUrl, String tickerSymbol, String type, String url, String width, String worstRating) {
        this.zzaZA = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzaZB = about;
        this.zzaZC = additionalName;
        this.zzaZD = address;
        this.zzaZE = addressCountry;
        this.zzaZF = addressLocality;
        this.zzaZG = addressRegion;
        this.zzaZH = associated_media;
        this.zzaZI = attendeeCount;
        this.zzaZJ = attendees;
        this.zzaZK = audio;
        this.zzaZL = author;
        this.zzaZM = bestRating;
        this.zzaZN = birthDate;
        this.zzaZO = byArtist;
        this.zzaZP = caption;
        this.zzaZQ = contentSize;
        this.zztN = contentUrl;
        this.zzaZR = contributor;
        this.zzaZS = dateCreated;
        this.zzaZT = dateModified;
        this.zzaZU = datePublished;
        this.zzavc = description;
        this.zzaZV = duration;
        this.zzaZW = embedUrl;
        this.zzaZX = endDate;
        this.zzaZY = familyName;
        this.zzaZZ = gender;
        this.zzbaa = geo;
        this.zzbab = givenName;
        this.zzbac = height;
        this.zzxX = id;
        this.zzbad = image;
        this.zzbae = inAlbum;
        this.zzaKR = latitude;
        this.zzbaf = location;
        this.zzaKS = longitude;
        this.mName = name;
        this.zzbag = partOfTVSeries;
        this.zzbah = performers;
        this.zzbai = playerType;
        this.zzbaj = postOfficeBoxNumber;
        this.zzbak = postalCode;
        this.zzbal = ratingValue;
        this.zzbam = reviewRating;
        this.zzban = startDate;
        this.zzbao = streetAddress;
        this.zzbap = text;
        this.zzbaq = thumbnail;
        this.zzbar = thumbnailUrl;
        this.zzbas = tickerSymbol;
        this.zzIx = type;
        this.zzF = url;
        this.zzbat = width;
        this.zzbau = worstRating;
    }

    public ItemScopeEntity(Set<Integer> indicatorSet, ItemScopeEntity about, List<String> additionalName, ItemScopeEntity address, String addressCountry, String addressLocality, String addressRegion, List<ItemScopeEntity> associated_media, int attendeeCount, List<ItemScopeEntity> attendees, ItemScopeEntity audio, List<ItemScopeEntity> author, String bestRating, String birthDate, ItemScopeEntity byArtist, String caption, String contentSize, String contentUrl, List<ItemScopeEntity> contributor, String dateCreated, String dateModified, String datePublished, String description, String duration, String embedUrl, String endDate, String familyName, String gender, ItemScopeEntity geo, String givenName, String height, String id, String image, ItemScopeEntity inAlbum, double latitude, ItemScopeEntity location, double longitude, String name, ItemScopeEntity partOfTVSeries, List<ItemScopeEntity> performers, String playerType, String postOfficeBoxNumber, String postalCode, String ratingValue, ItemScopeEntity reviewRating, String startDate, String streetAddress, String text, ItemScopeEntity thumbnail, String thumbnailUrl, String tickerSymbol, String type, String url, String width, String worstRating) {
        this.zzaZA = indicatorSet;
        this.mVersionCode = 1;
        this.zzaZB = about;
        this.zzaZC = additionalName;
        this.zzaZD = address;
        this.zzaZE = addressCountry;
        this.zzaZF = addressLocality;
        this.zzaZG = addressRegion;
        this.zzaZH = associated_media;
        this.zzaZI = attendeeCount;
        this.zzaZJ = attendees;
        this.zzaZK = audio;
        this.zzaZL = author;
        this.zzaZM = bestRating;
        this.zzaZN = birthDate;
        this.zzaZO = byArtist;
        this.zzaZP = caption;
        this.zzaZQ = contentSize;
        this.zztN = contentUrl;
        this.zzaZR = contributor;
        this.zzaZS = dateCreated;
        this.zzaZT = dateModified;
        this.zzaZU = datePublished;
        this.zzavc = description;
        this.zzaZV = duration;
        this.zzaZW = embedUrl;
        this.zzaZX = endDate;
        this.zzaZY = familyName;
        this.zzaZZ = gender;
        this.zzbaa = geo;
        this.zzbab = givenName;
        this.zzbac = height;
        this.zzxX = id;
        this.zzbad = image;
        this.zzbae = inAlbum;
        this.zzaKR = latitude;
        this.zzbaf = location;
        this.zzaKS = longitude;
        this.mName = name;
        this.zzbag = partOfTVSeries;
        this.zzbah = performers;
        this.zzbai = playerType;
        this.zzbaj = postOfficeBoxNumber;
        this.zzbak = postalCode;
        this.zzbal = ratingValue;
        this.zzbam = reviewRating;
        this.zzban = startDate;
        this.zzbao = streetAddress;
        this.zzbap = text;
        this.zzbaq = thumbnail;
        this.zzbar = thumbnailUrl;
        this.zzbas = tickerSymbol;
        this.zzIx = type;
        this.zzF = url;
        this.zzbat = width;
        this.zzbau = worstRating;
    }

    public int describeContents() {
        zza com_google_android_gms_plus_internal_model_moments_zza = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ItemScopeEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ItemScopeEntity itemScopeEntity = (ItemScopeEntity) obj;
        for (Field field : zzaZz.values()) {
            if (zza(field)) {
                if (!itemScopeEntity.zza(field)) {
                    return false;
                }
                if (!zzb(field).equals(itemScopeEntity.zzb(field))) {
                    return false;
                }
            } else if (itemScopeEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return zzDr();
    }

    public ItemScope getAbout() {
        return this.zzaZB;
    }

    public List<String> getAdditionalName() {
        return this.zzaZC;
    }

    public ItemScope getAddress() {
        return this.zzaZD;
    }

    public String getAddressCountry() {
        return this.zzaZE;
    }

    public String getAddressLocality() {
        return this.zzaZF;
    }

    public String getAddressRegion() {
        return this.zzaZG;
    }

    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.zzaZH;
    }

    public int getAttendeeCount() {
        return this.zzaZI;
    }

    public List<ItemScope> getAttendees() {
        return (ArrayList) this.zzaZJ;
    }

    public ItemScope getAudio() {
        return this.zzaZK;
    }

    public List<ItemScope> getAuthor() {
        return (ArrayList) this.zzaZL;
    }

    public String getBestRating() {
        return this.zzaZM;
    }

    public String getBirthDate() {
        return this.zzaZN;
    }

    public ItemScope getByArtist() {
        return this.zzaZO;
    }

    public String getCaption() {
        return this.zzaZP;
    }

    public String getContentSize() {
        return this.zzaZQ;
    }

    public String getContentUrl() {
        return this.zztN;
    }

    public List<ItemScope> getContributor() {
        return (ArrayList) this.zzaZR;
    }

    public String getDateCreated() {
        return this.zzaZS;
    }

    public String getDateModified() {
        return this.zzaZT;
    }

    public String getDatePublished() {
        return this.zzaZU;
    }

    public String getDescription() {
        return this.zzavc;
    }

    public String getDuration() {
        return this.zzaZV;
    }

    public String getEmbedUrl() {
        return this.zzaZW;
    }

    public String getEndDate() {
        return this.zzaZX;
    }

    public String getFamilyName() {
        return this.zzaZY;
    }

    public String getGender() {
        return this.zzaZZ;
    }

    public ItemScope getGeo() {
        return this.zzbaa;
    }

    public String getGivenName() {
        return this.zzbab;
    }

    public String getHeight() {
        return this.zzbac;
    }

    public String getId() {
        return this.zzxX;
    }

    public String getImage() {
        return this.zzbad;
    }

    public ItemScope getInAlbum() {
        return this.zzbae;
    }

    public double getLatitude() {
        return this.zzaKR;
    }

    public ItemScope getLocation() {
        return this.zzbaf;
    }

    public double getLongitude() {
        return this.zzaKS;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.zzbag;
    }

    public List<ItemScope> getPerformers() {
        return (ArrayList) this.zzbah;
    }

    public String getPlayerType() {
        return this.zzbai;
    }

    public String getPostOfficeBoxNumber() {
        return this.zzbaj;
    }

    public String getPostalCode() {
        return this.zzbak;
    }

    public String getRatingValue() {
        return this.zzbal;
    }

    public ItemScope getReviewRating() {
        return this.zzbam;
    }

    public String getStartDate() {
        return this.zzban;
    }

    public String getStreetAddress() {
        return this.zzbao;
    }

    public String getText() {
        return this.zzbap;
    }

    public ItemScope getThumbnail() {
        return this.zzbaq;
    }

    public String getThumbnailUrl() {
        return this.zzbar;
    }

    public String getTickerSymbol() {
        return this.zzbas;
    }

    public String getType() {
        return this.zzIx;
    }

    public String getUrl() {
        return this.zzF;
    }

    public String getWidth() {
        return this.zzbat;
    }

    public String getWorstRating() {
        return this.zzbau;
    }

    public boolean hasAbout() {
        return this.zzaZA.contains(Integer.valueOf(2));
    }

    public boolean hasAdditionalName() {
        return this.zzaZA.contains(Integer.valueOf(3));
    }

    public boolean hasAddress() {
        return this.zzaZA.contains(Integer.valueOf(4));
    }

    public boolean hasAddressCountry() {
        return this.zzaZA.contains(Integer.valueOf(5));
    }

    public boolean hasAddressLocality() {
        return this.zzaZA.contains(Integer.valueOf(6));
    }

    public boolean hasAddressRegion() {
        return this.zzaZA.contains(Integer.valueOf(7));
    }

    public boolean hasAssociated_media() {
        return this.zzaZA.contains(Integer.valueOf(8));
    }

    public boolean hasAttendeeCount() {
        return this.zzaZA.contains(Integer.valueOf(9));
    }

    public boolean hasAttendees() {
        return this.zzaZA.contains(Integer.valueOf(10));
    }

    public boolean hasAudio() {
        return this.zzaZA.contains(Integer.valueOf(11));
    }

    public boolean hasAuthor() {
        return this.zzaZA.contains(Integer.valueOf(12));
    }

    public boolean hasBestRating() {
        return this.zzaZA.contains(Integer.valueOf(13));
    }

    public boolean hasBirthDate() {
        return this.zzaZA.contains(Integer.valueOf(14));
    }

    public boolean hasByArtist() {
        return this.zzaZA.contains(Integer.valueOf(15));
    }

    public boolean hasCaption() {
        return this.zzaZA.contains(Integer.valueOf(16));
    }

    public boolean hasContentSize() {
        return this.zzaZA.contains(Integer.valueOf(17));
    }

    public boolean hasContentUrl() {
        return this.zzaZA.contains(Integer.valueOf(18));
    }

    public boolean hasContributor() {
        return this.zzaZA.contains(Integer.valueOf(19));
    }

    public boolean hasDateCreated() {
        return this.zzaZA.contains(Integer.valueOf(20));
    }

    public boolean hasDateModified() {
        return this.zzaZA.contains(Integer.valueOf(21));
    }

    public boolean hasDatePublished() {
        return this.zzaZA.contains(Integer.valueOf(22));
    }

    public boolean hasDescription() {
        return this.zzaZA.contains(Integer.valueOf(23));
    }

    public boolean hasDuration() {
        return this.zzaZA.contains(Integer.valueOf(24));
    }

    public boolean hasEmbedUrl() {
        return this.zzaZA.contains(Integer.valueOf(25));
    }

    public boolean hasEndDate() {
        return this.zzaZA.contains(Integer.valueOf(26));
    }

    public boolean hasFamilyName() {
        return this.zzaZA.contains(Integer.valueOf(27));
    }

    public boolean hasGender() {
        return this.zzaZA.contains(Integer.valueOf(28));
    }

    public boolean hasGeo() {
        return this.zzaZA.contains(Integer.valueOf(29));
    }

    public boolean hasGivenName() {
        return this.zzaZA.contains(Integer.valueOf(30));
    }

    public boolean hasHeight() {
        return this.zzaZA.contains(Integer.valueOf(31));
    }

    public boolean hasId() {
        return this.zzaZA.contains(Integer.valueOf(32));
    }

    public boolean hasImage() {
        return this.zzaZA.contains(Integer.valueOf(33));
    }

    public boolean hasInAlbum() {
        return this.zzaZA.contains(Integer.valueOf(34));
    }

    public boolean hasLatitude() {
        return this.zzaZA.contains(Integer.valueOf(36));
    }

    public boolean hasLocation() {
        return this.zzaZA.contains(Integer.valueOf(37));
    }

    public boolean hasLongitude() {
        return this.zzaZA.contains(Integer.valueOf(38));
    }

    public boolean hasName() {
        return this.zzaZA.contains(Integer.valueOf(39));
    }

    public boolean hasPartOfTVSeries() {
        return this.zzaZA.contains(Integer.valueOf(40));
    }

    public boolean hasPerformers() {
        return this.zzaZA.contains(Integer.valueOf(41));
    }

    public boolean hasPlayerType() {
        return this.zzaZA.contains(Integer.valueOf(42));
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.zzaZA.contains(Integer.valueOf(43));
    }

    public boolean hasPostalCode() {
        return this.zzaZA.contains(Integer.valueOf(44));
    }

    public boolean hasRatingValue() {
        return this.zzaZA.contains(Integer.valueOf(45));
    }

    public boolean hasReviewRating() {
        return this.zzaZA.contains(Integer.valueOf(46));
    }

    public boolean hasStartDate() {
        return this.zzaZA.contains(Integer.valueOf(47));
    }

    public boolean hasStreetAddress() {
        return this.zzaZA.contains(Integer.valueOf(48));
    }

    public boolean hasText() {
        return this.zzaZA.contains(Integer.valueOf(49));
    }

    public boolean hasThumbnail() {
        return this.zzaZA.contains(Integer.valueOf(50));
    }

    public boolean hasThumbnailUrl() {
        return this.zzaZA.contains(Integer.valueOf(51));
    }

    public boolean hasTickerSymbol() {
        return this.zzaZA.contains(Integer.valueOf(52));
    }

    public boolean hasType() {
        return this.zzaZA.contains(Integer.valueOf(53));
    }

    public boolean hasUrl() {
        return this.zzaZA.contains(Integer.valueOf(54));
    }

    public boolean hasWidth() {
        return this.zzaZA.contains(Integer.valueOf(55));
    }

    public boolean hasWorstRating() {
        return this.zzaZA.contains(Integer.valueOf(56));
    }

    public int hashCode() {
        int i = 0;
        for (Field field : zzaZz.values()) {
            int hashCode;
            if (zza(field)) {
                hashCode = zzb(field).hashCode() + (i + field.zzrc());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza com_google_android_gms_plus_internal_model_moments_zza = CREATOR;
        zza.zza(this, out, flags);
    }

    public HashMap<String, Field<?, ?>> zzDq() {
        return zzaZz;
    }

    public ItemScopeEntity zzDr() {
        return this;
    }

    protected boolean zza(Field field) {
        return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
    }

    protected Object zzb(Field field) {
        switch (field.zzrc()) {
            case 2:
                return this.zzaZB;
            case 3:
                return this.zzaZC;
            case 4:
                return this.zzaZD;
            case 5:
                return this.zzaZE;
            case 6:
                return this.zzaZF;
            case 7:
                return this.zzaZG;
            case 8:
                return this.zzaZH;
            case 9:
                return Integer.valueOf(this.zzaZI);
            case 10:
                return this.zzaZJ;
            case 11:
                return this.zzaZK;
            case 12:
                return this.zzaZL;
            case 13:
                return this.zzaZM;
            case 14:
                return this.zzaZN;
            case 15:
                return this.zzaZO;
            case 16:
                return this.zzaZP;
            case 17:
                return this.zzaZQ;
            case 18:
                return this.zztN;
            case 19:
                return this.zzaZR;
            case 20:
                return this.zzaZS;
            case 21:
                return this.zzaZT;
            case 22:
                return this.zzaZU;
            case 23:
                return this.zzavc;
            case 24:
                return this.zzaZV;
            case 25:
                return this.zzaZW;
            case 26:
                return this.zzaZX;
            case 27:
                return this.zzaZY;
            case 28:
                return this.zzaZZ;
            case 29:
                return this.zzbaa;
            case 30:
                return this.zzbab;
            case 31:
                return this.zzbac;
            case 32:
                return this.zzxX;
            case 33:
                return this.zzbad;
            case 34:
                return this.zzbae;
            case 36:
                return Double.valueOf(this.zzaKR);
            case 37:
                return this.zzbaf;
            case 38:
                return Double.valueOf(this.zzaKS);
            case 39:
                return this.mName;
            case 40:
                return this.zzbag;
            case 41:
                return this.zzbah;
            case 42:
                return this.zzbai;
            case 43:
                return this.zzbaj;
            case 44:
                return this.zzbak;
            case 45:
                return this.zzbal;
            case 46:
                return this.zzbam;
            case 47:
                return this.zzban;
            case 48:
                return this.zzbao;
            case 49:
                return this.zzbap;
            case 50:
                return this.zzbaq;
            case 51:
                return this.zzbar;
            case 52:
                return this.zzbas;
            case 53:
                return this.zzIx;
            case 54:
                return this.zzF;
            case 55:
                return this.zzbat;
            case 56:
                return this.zzbau;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
        }
    }

    public /* synthetic */ Map zzqV() {
        return zzDq();
    }
}
