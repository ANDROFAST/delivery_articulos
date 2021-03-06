package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zztd {
    private final ByteBuffer zzbpP;

    public static class zza extends IOException {
        zza(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private zztd(ByteBuffer byteBuffer) {
        this.zzbpP = byteBuffer;
        this.zzbpP.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zztd(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static zztd zzD(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static int zzF(byte[] bArr) {
        return zzmz(bArr.length) + bArr.length;
    }

    public static int zzI(int i, int i2) {
        return zzmx(i) + zzmu(i2);
    }

    public static int zzJ(int i, int i2) {
        return zzmx(i) + zzmv(i2);
    }

    private static int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 'ࠀ') {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if ('?' <= charAt && charAt <= '?') {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | 128);
            } else if ((charAt2 < '?' || '?' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else if ('?' > charAt2 || charAt2 > '?' || (i3 + 1 != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3 + 1)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            } else {
                throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            zzb(charSequence, byteBuffer);
        }
    }

    public static int zzad(long j) {
        return zzag(j);
    }

    public static int zzae(long j) {
        return zzag(zzai(j));
    }

    public static int zzag(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long zzai(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int zzay(boolean z) {
        return 1;
    }

    public static int zzb(int i, double d) {
        return zzmx(i) + zzl(d);
    }

    public static int zzb(int i, zztk com_google_android_gms_internal_zztk) {
        return (zzmx(i) * 2) + zzd(com_google_android_gms_internal_zztk);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzmx(i) + zzF(bArr);
    }

    public static zztd zzb(byte[] bArr, int i, int i2) {
        return new zztd(bArr, i, i2);
    }

    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 'ࠀ') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else if (charAt < '?' || '?' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((toCodePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int zzc(int i, float f) {
        return zzmx(i) + zzj(f);
    }

    public static int zzc(int i, zztk com_google_android_gms_internal_zztk) {
        return zzmx(i) + zze(com_google_android_gms_internal_zztk);
    }

    public static int zzc(int i, boolean z) {
        return zzmx(i) + zzay(z);
    }

    private static int zzc(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < '') {
            i++;
        }
        int i2 = i;
        i = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= 'ࠀ') {
                i += zza(charSequence, i2);
                break;
            }
            i2++;
            i = ((127 - charAt) >>> 31) + i;
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    public static int zzd(int i, long j) {
        return zzmx(i) + zzad(j);
    }

    public static int zzd(zztk com_google_android_gms_internal_zztk) {
        return com_google_android_gms_internal_zztk.getSerializedSize();
    }

    public static int zze(int i, long j) {
        return zzmx(i) + zzae(j);
    }

    public static int zze(zztk com_google_android_gms_internal_zztk) {
        int serializedSize = com_google_android_gms_internal_zztk.getSerializedSize();
        return serializedSize + zzmz(serializedSize);
    }

    public static int zzga(String str) {
        int zzc = zzc((CharSequence) str);
        return zzc + zzmz(zzc);
    }

    public static int zzj(float f) {
        return 4;
    }

    public static int zzl(double d) {
        return 8;
    }

    public static int zzmB(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int zzmu(int i) {
        return i >= 0 ? zzmz(i) : 10;
    }

    public static int zzmv(int i) {
        return zzmz(zzmB(i));
    }

    public static int zzmx(int i) {
        return zzmz(zztn.zzL(i, 0));
    }

    public static int zzmz(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int zzp(int i, String str) {
        return zzmx(i) + zzga(str);
    }

    public void zzE(byte[] bArr) throws IOException {
        zzmy(bArr.length);
        zzG(bArr);
    }

    public void zzG(int i, int i2) throws IOException {
        zzK(i, 0);
        zzms(i2);
    }

    public void zzG(byte[] bArr) throws IOException {
        zzc(bArr, 0, bArr.length);
    }

    public void zzH(int i, int i2) throws IOException {
        zzK(i, 0);
        zzmt(i2);
    }

    public int zzHx() {
        return this.zzbpP.remaining();
    }

    public void zzHy() {
        if (zzHx() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void zzK(int i, int i2) throws IOException {
        zzmy(zztn.zzL(i, i2));
    }

    public void zza(int i, double d) throws IOException {
        zzK(i, 1);
        zzk(d);
    }

    public void zza(int i, zztk com_google_android_gms_internal_zztk) throws IOException {
        zzK(i, 2);
        zzc(com_google_android_gms_internal_zztk);
    }

    public void zza(int i, byte[] bArr) throws IOException {
        zzK(i, 2);
        zzE(bArr);
    }

    public void zzab(long j) throws IOException {
        zzaf(j);
    }

    public void zzac(long j) throws IOException {
        zzaf(zzai(j));
    }

    public void zzaf(long j) throws IOException {
        while ((-128 & j) != 0) {
            zzmw((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        zzmw((int) j);
    }

    public void zzah(long j) throws IOException {
        if (this.zzbpP.remaining() < 8) {
            throw new zza(this.zzbpP.position(), this.zzbpP.limit());
        }
        this.zzbpP.putLong(j);
    }

    public void zzax(boolean z) throws IOException {
        zzmw(z ? 1 : 0);
    }

    public void zzb(byte b) throws IOException {
        if (this.zzbpP.hasRemaining()) {
            this.zzbpP.put(b);
            return;
        }
        throw new zza(this.zzbpP.position(), this.zzbpP.limit());
    }

    public void zzb(int i, float f) throws IOException {
        zzK(i, 5);
        zzi(f);
    }

    public void zzb(int i, long j) throws IOException {
        zzK(i, 0);
        zzab(j);
    }

    public void zzb(int i, String str) throws IOException {
        zzK(i, 2);
        zzfZ(str);
    }

    public void zzb(int i, boolean z) throws IOException {
        zzK(i, 0);
        zzax(z);
    }

    public void zzb(zztk com_google_android_gms_internal_zztk) throws IOException {
        com_google_android_gms_internal_zztk.writeTo(this);
    }

    public void zzc(int i, long j) throws IOException {
        zzK(i, 0);
        zzac(j);
    }

    public void zzc(zztk com_google_android_gms_internal_zztk) throws IOException {
        zzmy(com_google_android_gms_internal_zztk.getCachedSize());
        com_google_android_gms_internal_zztk.writeTo(this);
    }

    public void zzc(byte[] bArr, int i, int i2) throws IOException {
        if (this.zzbpP.remaining() >= i2) {
            this.zzbpP.put(bArr, i, i2);
            return;
        }
        throw new zza(this.zzbpP.position(), this.zzbpP.limit());
    }

    public void zzfZ(String str) throws IOException {
        try {
            int zzmz = zzmz(str.length());
            if (zzmz == zzmz(str.length() * 3)) {
                int position = this.zzbpP.position();
                if (this.zzbpP.remaining() < zzmz) {
                    throw new zza(zzmz + position, this.zzbpP.limit());
                }
                this.zzbpP.position(position + zzmz);
                zza((CharSequence) str, this.zzbpP);
                int position2 = this.zzbpP.position();
                this.zzbpP.position(position);
                zzmy((position2 - position) - zzmz);
                this.zzbpP.position(position2);
                return;
            }
            zzmy(zzc((CharSequence) str));
            zza((CharSequence) str, this.zzbpP);
        } catch (Throwable e) {
            zza com_google_android_gms_internal_zztd_zza = new zza(this.zzbpP.position(), this.zzbpP.limit());
            com_google_android_gms_internal_zztd_zza.initCause(e);
            throw com_google_android_gms_internal_zztd_zza;
        }
    }

    public void zzi(float f) throws IOException {
        zzmA(Float.floatToIntBits(f));
    }

    public void zzk(double d) throws IOException {
        zzah(Double.doubleToLongBits(d));
    }

    public void zzmA(int i) throws IOException {
        if (this.zzbpP.remaining() < 4) {
            throw new zza(this.zzbpP.position(), this.zzbpP.limit());
        }
        this.zzbpP.putInt(i);
    }

    public void zzms(int i) throws IOException {
        if (i >= 0) {
            zzmy(i);
        } else {
            zzaf((long) i);
        }
    }

    public void zzmt(int i) throws IOException {
        zzmy(zzmB(i));
    }

    public void zzmw(int i) throws IOException {
        zzb((byte) i);
    }

    public void zzmy(int i) throws IOException {
        while ((i & -128) != 0) {
            zzmw((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        zzmw(i);
    }
}
