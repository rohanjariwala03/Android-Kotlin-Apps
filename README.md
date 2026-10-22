# Android-Kotlin-Apps

Small Android exercises I wrote in Kotlin while learning the platform. They all live in one app module (the Gradle project is still called `shared_pref`, after the first exercise), with each exercise in its own activity and package.

## Exercises

- `shared_pref/` saves whatever you type into a text field to SharedPreferences in `onPause` and restores it in `onResume`.
- `BMI/` is a BMI calculator. It takes weight (kg) and height (cm), shows the BMI to two decimals and a category (underweight, normal, overweight, obese).
- `musicPlayer/` plays a bundled WAV file with `MediaPlayer`. It has play, pause and stop buttons, a seek bar, and elapsed/remaining time in seconds.
- `videoPlayer/` plays a bundled MP4 in a `VideoView` with the standard `MediaController`.
- `api/` fetches `/posts` from [JSONPlaceholder](https://jsonplaceholder.typicode.com/) with Retrofit and Gson and shows the user id and title of each post in a RecyclerView.

`MainActivity` has a single "Open App" button. It currently opens the API exercise. The intents for the other exercises are still in `MainActivity.kt`, commented out, so switching which one the button opens means uncommenting the one you want.

## Stack

- Kotlin 1.6.0, Android Gradle Plugin 7.0.3, Gradle 7.0.2
- compileSdk / targetSdk 32, minSdk 21
- AndroidX AppCompat, Material Components, ConstraintLayout
- Retrofit 2.9.0 with the Gson converter

## Running it

Open the project in Android Studio and run the `app` configuration, or build from the command line:

```
./gradlew assembleDebug
```

AGP 7.0 needs JDK 11. The API exercise needs network access. The audio and video files in `res/raw` add about 19 MB to the repo and the APK.
