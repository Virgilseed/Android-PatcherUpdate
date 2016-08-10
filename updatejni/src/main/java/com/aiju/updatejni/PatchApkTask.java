package com.aiju.updatejni;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Administrator on 2016/7/28.
 */
public class PatchApkTask extends AsyncTask<String, Void, Integer> {
    private final static int RESULT_OK = 0;
    private final static int RESULT_FAIL = -1;
    private Context context;
    private String newApk;
    private String patch;
    private PatchApkCallback callback;


    public PatchApkCallback getCallback() {
        return callback;
    }

    public void setCallback(PatchApkCallback callback) {
        this.callback = callback;
    }

    public PatchApkTask(Context context, String newApk, String patch) {
        this.context = context;
        this.newApk = newApk;
        this.patch = patch;
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected Integer  doInBackground(String... params) {
        Log.e("PatchApkTask->patch:", patch);
        int result = RESULT_OK;
        try {
            UpdateJniUtils.applyPatchToOwn(context, null, newApk, patch);
        } catch (IOException e) {
            result = RESULT_FAIL;
            e.printStackTrace();
        }
        return result;
    }


    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
        if (callback != null){
            if (result == RESULT_OK)
                callback.callback(true);
            else
                callback.callback(false);
        }

    }

    public interface PatchApkCallback{
        public void callback(boolean state);
    }

}
