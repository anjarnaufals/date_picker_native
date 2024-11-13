
# date_picker_native


## Getting Started

Implement Hosting native Android views in Flutter app with Platform Views Inside Flutter Plugin.
Current Implementation In Flutter use   `Texture Layer Hybrid Composition` with widget  `AndroidView`.

found complete information , go https://docs.flutter.dev/platform-integration/android/platform-views

  


### Android Setup

  

#### 1. Update `MainActivity`

  

Navigate to `android/app/src/main/kotlin/MainActivity.kt` and update the `MainActivity` class to register the platform view for your plugin.

  

Replace the existing content with:

  

```kotlin

import io.flutter.embedding.android.FlutterFragmentActivity

import io.flutter.embedding.engine.FlutterEngine

  

class MainActivity : FlutterFragmentActivity() {

override fun configureFlutterEngine(flutterEngine: FlutterEngine) {

    flutterEngine
              .platformViewsController
              .registry
              .registerViewFactory("<platform-view-type>", DatePickerFactory())
  }
}

```

  

#### 2. Enable Compose in `build.gradle` In `android/app/build.gradle`, enable Jetpack Compose by adding the following lines within the `android` block:

```gradle

buildFeatures {

compose = true

}

composeOptions {

kotlinCompilerExtensionVersion "1.4.8"

}

```

  

#### 3. Add Compose Dependency In`android/app/build.gradle`, add the following dependency at the bottom file:

```gradle

dependencies {

implementation 'androidx.compose.runtime:runtime:1.7.5'

}

```
