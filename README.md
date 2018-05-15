# StorageUtil
Easily get all available external storage paths in an Android device

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
 - Add the dependency
```gradle
dependencies {
    implementation 'com.github.hendrawd:StorageUtil:1.0.0'
}
```
 - Get the external storage paths
 ```java
 String[] externalStoragePaths = StorageUtil.getStorageDirectories(context);
 // do whatever you want with the externalStoragePaths
 ```
