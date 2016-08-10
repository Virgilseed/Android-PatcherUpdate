package com.aiju.updatejni;

import android.content.Context;

import java.io.IOException;

/**
 * Created by Administrator on 2016/5/30.
 */
public class UpdateJniUtils {
    public static native int applyPatchToOldApk(String oldPath, String newPath , String patchPath);

    static{
        System.loadLibrary("updateJni");
    }

    /**
     *
     * @param oldApkPath 旧版apk文件的路径
     * @param newApkPath 新版apk文件的路径
     * @param patchPath 增量包的路径
     * @throws IOException
     */
    public static void applyPatch(String oldApkPath, String newApkPath, String patchPath) throws IOException{
        applyPatchToOldApk(oldApkPath, newApkPath, patchPath);
    }

    /**
     * 根据context获取本app的旧版apk文件，与增量包合并生成新版apk
     * @param context
     * @param newApkPath 新版apk文件路径
     * @param patchPath 增量包路径
     * @throws IOException
     */
    public static void applyPatchToOwn(Context context, String oldApkPath, String newApkPath, String patchPath) throws IOException{
        String old = context.getApplicationInfo().sourceDir;
        applyPatchToOldApk(old, newApkPath, patchPath);
    }

}
