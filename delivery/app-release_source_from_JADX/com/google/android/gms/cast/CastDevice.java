package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice implements SafeParcelable {
    public static final int CAPABILITY_AUDIO_IN = 8;
    public static final int CAPABILITY_AUDIO_OUT = 4;
    public static final int CAPABILITY_VIDEO_IN = 2;
    public static final int CAPABILITY_VIDEO_OUT = 1;
    public static final Creator<CastDevice> CREATOR = new zzb();
    private final int mVersionCode;
    private int zzAk;
    private String zzYn;
    String zzYo;
    private Inet4Address zzYp;
    private String zzYq;
    private String zzYr;
    private String zzYs;
    private int zzYt;
    private List<WebImage> zzYu;
    private int zzYv;

    private CastDevice() {
        this(3, null, null, null, null, null, -1, new ArrayList(), 0, -1);
    }

    CastDevice(int versionCode, String deviceId, String hostAddress, String friendlyName, String modelName, String deviceVersion, int servicePort, List<WebImage> icons, int capabilities, int status) {
        this.mVersionCode = versionCode;
        this.zzYn = deviceId;
        this.zzYo = hostAddress;
        if (this.zzYo != null) {
            try {
                InetAddress byName = InetAddress.getByName(this.zzYo);
                if (byName instanceof Inet4Address) {
                    this.zzYp = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                this.zzYp = null;
            }
        }
        this.zzYq = friendlyName;
        this.zzYr = modelName;
        this.zzYs = deviceVersion;
        this.zzYt = servicePort;
        this.zzYu = icons;
        this.zzYv = capabilities;
        this.zzAk = status;
    }

    public static CastDevice getFromBundle(Bundle extras) {
        if (extras == null) {
            return null;
        }
        extras.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) extras.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        return getDeviceId() == null ? castDevice.getDeviceId() == null : zzf.zza(this.zzYn, castDevice.zzYn) && zzf.zza(this.zzYp, castDevice.zzYp) && zzf.zza(this.zzYr, castDevice.zzYr) && zzf.zza(this.zzYq, castDevice.zzYq) && zzf.zza(this.zzYs, castDevice.zzYs) && this.zzYt == castDevice.zzYt && zzf.zza(this.zzYu, castDevice.zzYu) && this.zzYv == castDevice.zzYv && this.zzAk == castDevice.zzAk;
    }

    public int getCapabilities() {
        return this.zzYv;
    }

    public String getDeviceId() {
        return this.zzYn;
    }

    public String getDeviceVersion() {
        return this.zzYs;
    }

    public String getFriendlyName() {
        return this.zzYq;
    }

    public WebImage getIcon(int preferredWidth, int preferredHeight) {
        WebImage webImage = null;
        if (this.zzYu.isEmpty()) {
            return null;
        }
        if (preferredWidth <= 0 || preferredHeight <= 0) {
            return (WebImage) this.zzYu.get(0);
        }
        WebImage webImage2 = null;
        for (WebImage webImage3 : this.zzYu) {
            WebImage webImage32;
            int width = webImage32.getWidth();
            int height = webImage32.getHeight();
            if (width < preferredWidth || height < preferredHeight) {
                if (width < preferredWidth && height < preferredHeight && (webImage == null || (webImage.getWidth() < width && webImage.getHeight() < height))) {
                    webImage = webImage2;
                }
                webImage32 = webImage;
                webImage = webImage2;
            } else {
                if (webImage2 == null || (webImage2.getWidth() > width && webImage2.getHeight() > height)) {
                    WebImage webImage4 = webImage;
                    webImage = webImage32;
                    webImage32 = webImage4;
                }
                webImage32 = webImage;
                webImage = webImage2;
            }
            webImage2 = webImage;
            webImage = webImage32;
        }
        if (webImage2 == null) {
            webImage2 = webImage != null ? webImage : (WebImage) this.zzYu.get(0);
        }
        return webImage2;
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.zzYu);
    }

    public Inet4Address getIpAddress() {
        return this.zzYp;
    }

    public String getModelName() {
        return this.zzYr;
    }

    public int getServicePort() {
        return this.zzYt;
    }

    public int getStatus() {
        return this.zzAk;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasCapabilities(int[] capabilities) {
        if (capabilities == null) {
            return false;
        }
        for (int hasCapability : capabilities) {
            if (!hasCapability(hasCapability)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCapability(int capability) {
        return (this.zzYv & capability) == capability;
    }

    public boolean hasIcons() {
        return !this.zzYu.isEmpty();
    }

    public int hashCode() {
        return this.zzYn == null ? 0 : this.zzYn.hashCode();
    }

    public boolean isOnLocalNetwork() {
        return !this.zzYn.startsWith("__cast_nearby__");
    }

    public boolean isSameDevice(CastDevice castDevice) {
        if (castDevice == null) {
            return false;
        }
        if (getDeviceId() == null) {
            return castDevice.getDeviceId() == null;
        } else {
            return zzf.zza(getDeviceId(), castDevice.getDeviceId());
        }
    }

    public void putInBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
        }
    }

    public String toString() {
        return String.format("\"%s\" (%s)", new Object[]{this.zzYq, this.zzYn});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
