# StorageUtil

[![](https://jitpack.io/v/hendrawd/StorageUtil.svg)](https://jitpack.io/#hendrawd/StorageUtil)

Easily get all available external storage paths in an Android device. 

## Important Note

If your minimal SDK version is 19, consider using [Storage Access Framework](https://developer.android.com/guide/topics/providers/document-provider) instead

Don't be confused with external storage term here. The Internal and External Storage terminology according to Google/official Android docs is quite different from what we think.

According to official Android docs:

**Internal Storage**: By default, files saved to the internal storage are private to your application and other applications cannot access them. When the user uninstalls your application, these files are removed/deleted. Your app user also can't access them using file manager; even after enabling "show hidden files" option in file manager. To access files in Internal Storage, you have to root your Android phone. So, this is **NOT** what we think as internal memory of the phone - Nexus 5's 32 GB internal memory.

**External Storage**:

> This can be a removable storage media (such as an SD card) or an internal (non-removable) storage

That means, both storage types like Nexus 6P's 64 GB internal memory and removable microSD card which we insert in phone's card slot are considered as External Storage.

**Removable Storage** means just microSD card storage, not the internal memory.

## How to
 - Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
 - Add the dependency (see the latest version from the jitpack badge or [Release](https://github.com/hendrawd/StorageUtil/releases))
```gradle
dependencies {
    implementation 'com.github.hendrawd:StorageUtil:x.x.x'
}
```
 - Get the external storage paths
 ```java
 String[] externalStoragePaths = StorageUtil.getStorageDirectories(context);
 // do whatever you want with the externalStoragePaths
 ```

[Click here](https://jitpack.io/#hendrawd/StorageUtil/) for the other build systems installation guide like **maven**, **sbt** and **leinigen**
