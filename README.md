# 🛠️ Items App

An Android app that displays a list of items with images, titles, prices, and availability using a basic **MVVM architecture**. Though my usual preference is **Jetpack Compose**, **RecyclerView**, and **Modular Clean MVVM**, this project is built with **XML layouts** and **ListView**, based on project context and initial requirements.

## 📌 Introduction

This project is a simple implementation of fetching and displaying data from an API. The app uses:

- **MVVM architecture** (basic setup)
- **XML-based UI**
- **ListView** for listing items
- **Coil** for image loading
- **Retrofit** for networking
- **Gson** for JSON parsing

While I prefer working with **Compose** and **RecyclerView** in a modular clean architecture setup, this project was scoped to use ListView and XML, so I continued in that direction for consistency.

## ✅ Project Customization / Work Done

- 🔁 Replaced WebView with a **ListView**
- 🧭 Implemented a **Navigation Drawer** for in-app navigation
- 🗃 Pulled and displayed data from a **REST API** using **MVVM**, **Repository pattern**, and **Koin DI**
- 🖼️ Displayed images using **Glide** inside a ListView
- ⚙️ Project uses modern architecture with **ViewModel**, **LiveData**, and **Koin** for Dependency Injection
- 📄 Used **ListView** (instead of RecyclerView) as requested, with documentation in code
