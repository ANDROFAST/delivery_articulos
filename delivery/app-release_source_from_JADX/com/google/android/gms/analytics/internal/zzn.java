package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class zzn extends zzd {
    private volatile String zzOu;
    private Future<String> zzPX;

    class C01971 implements Callable<String> {
        final /* synthetic */ zzn zzPY;

        C01971(zzn com_google_android_gms_analytics_internal_zzn) {
            this.zzPY = com_google_android_gms_analytics_internal_zzn;
        }

        public /* synthetic */ Object call() throws Exception {
            return zzjY();
        }

        public String zzjY() throws Exception {
            return this.zzPY.zzjV();
        }
    }

    class C01982 implements Callable<String> {
        final /* synthetic */ zzn zzPY;

        C01982(zzn com_google_android_gms_analytics_internal_zzn) {
            this.zzPY = com_google_android_gms_analytics_internal_zzn;
        }

        public /* synthetic */ Object call() throws Exception {
            return zzjY();
        }

        public String zzjY() throws Exception {
            return this.zzPY.zzjW();
        }
    }

    protected zzn(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
    }

    private boolean zzg(Context context, String str) {
        boolean z = false;
        zzx.zzcG(str);
        zzx.zzcy("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            zza("Storing clientId", str);
            fileOutputStream = context.openFileOutput("gaClientId", 0);
            fileOutputStream.write(str.getBytes());
            z = true;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    zze("Failed to close clientId writing stream", e);
                }
            }
        } catch (FileNotFoundException e2) {
            zze("Error creating clientId file", e2);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    zze("Failed to close clientId writing stream", e3);
                }
            }
        } catch (IOException e32) {
            zze("Error writing to clientId file", e32);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e322) {
                    zze("Failed to close clientId writing stream", e322);
                }
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3222) {
                    zze("Failed to close clientId writing stream", e3222);
                }
            }
        }
        return z;
    }

    private String zzjW() {
        String zzjX = zzjX();
        try {
            return !zzg(zziW().getContext(), zzjX) ? "0" : zzjX;
        } catch (Exception e) {
            zze("Error saving clientId file", e);
            return "0";
        }
    }

    protected String zzab(Context context) {
        FileInputStream fileInputStream;
        Object e;
        Throwable th;
        zzx.zzcy("ClientId should be loaded from worker thread");
        FileInputStream openFileInput;
        try {
            openFileInput = context.openFileInput("gaClientId");
            try {
                byte[] bArr = new byte[36];
                int read = openFileInput.read(bArr, 0, bArr.length);
                if (openFileInput.available() > 0) {
                    zzbd("clientId file seems corrupted, deleting it.");
                    openFileInput.close();
                    context.deleteFile("gaClientId");
                    if (openFileInput == null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e2) {
                        zze("Failed to close client id reading stream", e2);
                        return null;
                    }
                } else if (read < 14) {
                    zzbd("clientId file is empty, deleting it.");
                    openFileInput.close();
                    context.deleteFile("gaClientId");
                    if (openFileInput == null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e22) {
                        zze("Failed to close client id reading stream", e22);
                        return null;
                    }
                } else {
                    openFileInput.close();
                    String str = new String(bArr, 0, read);
                    zza("Read client id from disk", str);
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e3) {
                            zze("Failed to close client id reading stream", e3);
                        }
                    }
                    return str;
                }
            } catch (FileNotFoundException e4) {
                fileInputStream = openFileInput;
                if (fileInputStream != null) {
                    return null;
                }
                try {
                    fileInputStream.close();
                    return null;
                } catch (IOException e222) {
                    zze("Failed to close client id reading stream", e222);
                    return null;
                }
            } catch (IOException e5) {
                e = e5;
                try {
                    zze("Error reading client id file, deleting it", e);
                    context.deleteFile("gaClientId");
                    if (openFileInput != null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e2222) {
                        zze("Failed to close client id reading stream", e2222);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e22222) {
                            zze("Failed to close client id reading stream", e22222);
                        }
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e6) {
            fileInputStream = null;
            if (fileInputStream != null) {
                return null;
            }
            fileInputStream.close();
            return null;
        } catch (IOException e7) {
            e = e7;
            openFileInput = null;
            zze("Error reading client id file, deleting it", e);
            context.deleteFile("gaClientId");
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (Throwable th3) {
            openFileInput = null;
            th = th3;
            if (openFileInput != null) {
                openFileInput.close();
            }
            throw th;
        }
    }

    protected void zzir() {
    }

    public String zzjT() {
        String str;
        zzje();
        synchronized (this) {
            if (this.zzOu == null) {
                this.zzPX = zziW().zzc(new C01971(this));
            }
            if (this.zzPX != null) {
                try {
                    this.zzOu = (String) this.zzPX.get();
                } catch (InterruptedException e) {
                    zzd("ClientId loading or generation was interrupted", e);
                    this.zzOu = "0";
                } catch (ExecutionException e2) {
                    zze("Failed to load or generate client id", e2);
                    this.zzOu = "0";
                }
                if (this.zzOu == null) {
                    this.zzOu = "0";
                }
                zza("Loaded clientId", this.zzOu);
                this.zzPX = null;
            }
            str = this.zzOu;
        }
        return str;
    }

    String zzjU() {
        synchronized (this) {
            this.zzOu = null;
            this.zzPX = zziW().zzc(new C01982(this));
        }
        return zzjT();
    }

    String zzjV() {
        String zzab = zzab(zziW().getContext());
        return zzab == null ? zzjW() : zzab;
    }

    protected String zzjX() {
        return UUID.randomUUID().toString().toLowerCase();
    }
}
