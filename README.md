# Bookmark Manager

Aplikasi Android modern yang dirancang untuk membantu pengguna mengelola koleksi bookmark web mereka secara terorganisir. Dibangun menggunakan Jetpack Compose, aplikasi ini menawarkan antarmuka yang bersih dan responsif untuk menyimpan dan mengelompokkan tautan penting.

## Tujuan Proyek

Proyek ini dibuat sebagai sarana pembelajaran pribadi untuk mendalami pengembangan aplikasi Android Native. Sebagai pengembang yang sebelumnya terbiasa dengan Flutter, proyek ini berfungsi sebagai sarana transisi untuk memahami ekosistem Android secara mendalam, mulai dari Jetpack Compose, manajemen status dengan ViewModel, hingga navigasi native.

## Fitur Utama

- Manajemen Bookmark: Menambah dan menghapus bookmark dengan mudah yang mencakup informasi judul, URL, dan kategori.
- Pengelompokan Kategori: Secara otomatis mengekstrak kategori dari bookmark yang ada untuk mempermudah organisasi.
- Filter Kategori: Fitur penyaringan yang memungkinkan pengguna untuk fokus pada grup bookmark tertentu.
- Navigasi Type-Safe: Implementasi navigasi antar layar yang aman dan efisien menggunakan Jetpack Navigation Compose.
- Arsitektur MVVM: Pemisahan logika bisnis dan UI yang jelas menggunakan ViewModel dan StateFlow untuk manajemen status yang reaktif.

## Teknologi yang Digunakan

- Kotlin: Bahasa pemrograman utama untuk pengembangan Android.
- Jetpack Compose: Toolkit UI deklaratif untuk membangun antarmuka pengguna.
- Material 3: Implementasi sistem desain terbaru untuk pengalaman pengguna yang modern.
- ViewModel & StateFlow: Komponen arsitektur untuk mengelola data UI secara lifecycle-aware.
- Navigation Compose: Library untuk menangani navigasi antar layar di dalam Compose.
- Kotlinx Serialization: Digunakan untuk penanganan data terstruktur.

## Struktur Folder

Berikut adalah struktur folder utama dalam proyek ini:

- `app/src/main/java/com/example/bookmarkmanager/`
    - `ui/`: Berisi konfigurasi tema aplikasi (Theme, Color, Type).
    - `Bookmark.kt`: Definisi model data untuk entitas Bookmark.
    - `BookmarkViewModel.kt`: Pengelola logika bisnis, penyimpanan data sementara, dan status UI.
    - `MainActivity.kt`: Entry point aplikasi dan pengatur struktur navigasi utama.
    - `Navigation.kt`: Definisi rute dan tujuan navigasi.
    - `AddBookmarkScreen.kt`: Komponen UI untuk formulir penambahan bookmark baru.
    - `BookmarkListScreen.kt`: Komponen UI untuk menampilkan daftar bookmark dan fitur filter.

## Cara Instalasi dan Menjalankan Proyek

1. Prasyarat:
   - Instal Android Studio versi terbaru (Hedgehog atau lebih baru disarankan).
   - Pastikan SDK Android yang diperlukan sudah terpasang.

2. Klon Repositori:
   ```bash
   git clone https://github.com/username/bookmark-manager.git
   ```

3. Impor Proyek:
   - Buka Android Studio.
   - Pilih "Open" dan arahkan ke direktori hasil klon.

4. Sinkronisasi Gradle:
   - Tunggu hingga Android Studio menyelesaikan proses sinkronisasi Gradle dan mengunduh dependensi yang diperlukan.

5. Jalankan Aplikasi:
   - Hubungkan perangkat Android fisik atau jalankan Emulator.
   - Klik ikon "Run" (segitiga hijau) di toolbar atas Android Studio.
