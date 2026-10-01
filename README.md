# Smart Pantry Manager

Java/XML Android application for managing pantry items and finding recipes that can be made using only ingredients already available.

## Stack
Java 17, Android SDK 35, min SDK 23, SQLiteOpenHelper, AndroidX and Material Components.

## Features
- Add, view and delete pantry items
- Local SQLite persistence
- Strict recipe matching: every required ingredient must already exist in the pantry with quantity greater than zero
- Recipe detail screen and Activity/Intent navigation

## Run
Open this repository in Android Studio, allow Gradle sync, install SDK 35 if prompted, and run on an emulator or Android device.

No Firebase, PostgreSQL, GPS, Google Maps, payments or external backend are required.
