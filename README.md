# Shopping App

An Android Shopping App built using **Kotlin** that fetches product data from an online API and displays it in a clean RecyclerView-based UI.  
This project is built for practicing **API integration, RecyclerView, Glide image loading, and Android UI development**.

---

## Features

- Fetches product data from API using **Retrofit**
- Displays products in a **RecyclerView**
- Shows:
  - Product Image
  - Product Title
  - Product Price
  - Product Category
- Loads product images using **Glide**
- Clean and simple Android UI
- Good project for learning Android API integration

---

## Tech Stack

- **Language:** Kotlin
- **IDE:** Android Studio
- **UI:** XML, RecyclerView
- **API Calling:** Retrofit
- **Image Loading:** Glide
- **JSON Parsing:** Gson Converter

---

## API Used

This app uses the **FakeStore API** to fetch product data.

**Base URL:**  
https://https://dummyjson.com/

**Products Endpoint:**  
https://dummyjson.com/products

---

## Project Structure

```bash
com.example.shopping
│── api/
│   ├── ApiService.kt
│   └── RetrofitInstance.kt
│
│── model/
│   ├── Product.kt
│   └── Rating.kt
│
│── adapter/
│   └── ProductAdapter.kt
│
│── MainActivity.kt
