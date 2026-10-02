# Smart Pantry Manager

A complete Android application for managing home ingredients and discovering recipes you can prepare with your current pantry. Built with Java, Android Studio, SQLite, and RecyclerView.

## Project Status

**Current Stage: Stage 1 - Project Structure & Navigation Setup**

This is a university-level Mobile App Development 700 practical assignment. The application is being built incrementally through multiple stages.

### Completed Stages:
- Stage 1: Android Studio project structure, Activities, XML layouts, model classes

### Most Important Business Rule

A recipe may ONLY appear in Suggested Recipes when the user's pantry contains EVERY ingredient required by that recipe AND contains at least the required quantity.

## Technology Stack

- Language: Java (Android Framework)
- IDE: Android Studio
- Database: SQLite with SQLiteOpenHelper
- UI Components: RecyclerView, CardView, Material Design
- Layouts: XML
- Navigation: Android Intents & Bottom Navigation
- Version Control: Git/GitHub

## Project Structure

SmartPantryManager/
├── app/
│   ├── src/main/java/com/example/smartpantry/
│   │   ├── activities/
│   │   └── models/
│   └── src/main/res/
│       ├── layout/
│       ├── values/
│       ├── menu/
│       └── drawable/
├── build.gradle
├── settings.gradle
└── README.md

## Getting Started

1. Open the SmartPantryManager folder in Android Studio.
2. Sync the Gradle files.
3. Create/start an Android emulator with API 24 or higher.
4. Run the app.

## Current Stage Limitations

Database functionality, persistence, adapters, recipe matching, validation and full navigation are planned for later development stages.

## Course

Mobile App Development 700
