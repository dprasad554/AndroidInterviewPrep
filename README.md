# 📱 AndroidInterviewPrep

A modern Android application built using **Clean Architecture** principles with a scalable and maintainable structure.  

---

## 🚀 Tech Stack

- Kotlin
- MVVM Architecture
- Clean Architecture
- Hilt (Dependency Injection)
- Retrofit (Networking)
- Coroutines & Flow
- Jetpack Compose
- Unit Testing (JUnit)

---

## 🏗 Architecture Overview

This project follows **Clean Architecture** with clear separation of concerns:
## 📂 Project Structure

```text
app/
 ├── app/
 │   ├── ApiPracticeApp.kt
 │   ├── MainActivity.kt
 │
 ├── data/
 │   ├── remote/
 │   ├── repository/
 │
 ├── domain/
 │   ├── model/
 │   ├── repository/
 │   ├── usecase/
 │
 ├── di/
 │   ├── NetworkModule.kt
 │   ├── RepositoryModule.kt
 │
 ├── presentation/
 │   ├── ViewModel/
 │   ├── Compose UI/
```
