# Android-PatcherUpdate
android增量更新


## 使用

#### 步骤一、

    导入Module：导入项目中的UpdateJni module，若你所在的项目没有设置Ndk配置，请先下载好Ndk并配置好Ndk，不清楚的请移步搜索；
PS: 别忘了gradle.properties添加  android.useDeprecatedNdk=true





#### 步骤二、

    下载patch差分文件（测试时候可以通过adb push命令将生成好的patch文件push到sdcard中），PS：patch文件下载后所存放目录不要最好放到 sdcard中！！！
    
#### 步骤三、调用如下代码（示例）：

    install（）是合并包成功回调


``` xml
    PatchApkTask patchApkTask = new PatchApkTask(this, newApk, fileName);
            patchApkTask.setCallback(new PatchApkTask.PatchApkCallback() {
                @Override
                public void callback(boolean state) {
                    install();
                }
            });
   patchApkTask.execute();
```  


##window生成差分patch

  生成工具在项目根目录下面：bsdiff4.3-win32.zip，具体使用如下：
  
  在bspatch.exe中输入bspatch.exe old.apk new.apk xxx.patch 命令
  
  PS:上述命令中old.apk 是旧版本的apk，new.apk是新版本的apk， xxx.patch是差分文件。因为old.apk、new.apk和xxx.patch和bspatch.exe所在的目录相同，所以不需要带有路径
  

## 联系
#### 微信：whenwherew
#### E-mail: virgilseed@gmail.com  or   seedzj.@qq.com
  




