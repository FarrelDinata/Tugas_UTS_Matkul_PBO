# Sistem Donasi Barang Bekas (Ujian Tengah Semester - PBO)

**Nama:** Farrel Fazzadinata Sumarna
**NIM:** 2509116111

## 1. Studi Kasus
Program CLI untuk mencatat donasi barang bekas dari masyarakat. Data donasi dikelompokkan
menjadi dua jenis, yaitu **pakaian** dan **elektronik**, karena tiap jenis punya informasi tambahan
yang berbeda. Fitur: Create, Read, Update, Delete (CRUD) dengan validasi input dan dummy data awal.

## 2. Struktur Package
```
src/main/java/com/mycompany/sistemdonasibarangbekas/
├── Main.java                  -> entry point, menu (tampilan), dan pengelola data ArrayList
└── model/
    ├── Donasi.java            -> superclass (abstract)
    ├── DonasiPakaian.java     -> subclass 1
    └── DonasiElektronik.java  -> subclass 2
```
Sesuai batasan **4 class**, pemisahan MVC diterapkan secara sederhana:

| Bagian MVC | Lokasi | Keterangan |
|---|---|---|
| Model | package `model` | Data & aturan validasi (Donasi, DonasiPakaian, DonasiElektronik) |
| View + Controller | `Main.java` | Menampilkan menu, membaca input, dan mengelola `ArrayList<Donasi>` |

> Catatan: View dan Controller belum dipisah menjadi class tersendiri karena dibatasi 4 class.

## 3. Diagram Kelas
```
            +-----------------------------+
            |     <<abstract>> Donasi     |
            +-----------------------------+
            | - idDonasi : String         |
            | - namaPendonor : String     |
            | - namaBarang : String       |
            | - jumlahBarang : int        |
            +-----------------------------+
            | + getter / setter (valid.)  |
            | + getKategori() : String    |  <- abstract
            | + tampilkanInfo() : String  |
            | + tampilkanInfo(int)        |  <- overloading
            +--------------+--------------+
                  ^                ^
                  |                |
   +--------------+---+      +-----+--------------------+
   |  DonasiPakaian   |      |    DonasiElektronik      |
   +------------------+      +--------------------------+
   | - ukuran         |      | - merek : String         |
   |                  |      | - masihBerfungsi : bool  |
   | + getKategori()  |      | + getKategori()          |
   | + tampilkanInfo()|      | + tampilkanInfo()        |
   +------------------+      +--------------------------+
```

## 4. Penerapan Konsep OOP

**Inheritance** – `Donasi` adalah superclass, `DonasiPakaian` dan `DonasiElektronik` adalah subclass
(`extends Donasi`). Atribut umum (id, pendonor, barang, jumlah) ada di superclass, atribut khusus
(ukuran; merek & status berfungsi) ada di subclass. Subclass memanggil `super(...)` di constructor.

**Encapsulation & Access Modifier** – semua atribut `private`, diakses lewat getter/setter `public`.
Method `validasiTeks()` bersifat `protected` (hanya untuk Donasi dan subclass-nya).
Di `Main`, ArrayList dan method bantu bersifat `private static`.

**Validasi Input**
- Setter melempar `IllegalArgumentException` jika teks kosong atau jumlah < 1.
- `Main` memvalidasi angka (harus angka dan dalam rentang), teks tidak kosong, ID tidak boleh duplikat,
  konfirmasi y/n, dan nomor data harus ada di list. Program tidak crash saat input salah.

**Dummy Data** – method `isiDataAwal()` mengisi 4 data (2 pakaian, 2 elektronik) sehingga menu
"Tampilkan Data" langsung menampilkan data.

**Polymorphism**
- *Overriding*: `tampilkanInfo()` di-override di kedua subclass (memanggil `super.tampilkanInfo()` lalu
  menambah info khusus). Di `Main`, `daftarDonasi.get(i).tampilkanInfo(...)` memanggil versi sesuai tipe objek.
- *Overloading*: `tampilkanInfo()` vs `tampilkanInfo(int nomor)`, serta constructor ganda
  (mis. `DonasiPakaian` tanpa ukuran otomatis "All Size", `DonasiElektronik` tanpa status otomatis berfungsi).

## 5. Alur Program
1. Tambah Data Donasi (pilih jenis Pakaian/Elektronik, lalu isi data)
2. Tampilkan Data Donasi
3. Ubah Data Donasi (berdasarkan nomor urut)
4. Hapus Data Donasi (dengan konfirmasi)
0. Keluar

## 6. Screenshot Program
> <img width="175" height="83" alt="image" src="https://github.com/user-attachments/assets/71d438fc-22f1-4d16-b0b2-4b8ae6909dcf" />

<img width="257" height="122" alt="Screenshot 2026-09-21 232755" src="https://github.com/user-attachments/assets/c2da9d9f-1fe7-4ab2-bff6-38a5d0ba1a51" />

<img width="512" height="67" alt="image" src="https://github.com/user-attachments/assets/bf38c3df-0492-43cc-af50-70ca88f1f59b" /># Sistem Donasi Barang Bekas (Mini Project 2 - PBO)

**Nama:** Farrel Fazzadinata Sumarna
**NIM:** 2509116111

## 1. Studi Kasus
Program CLI untuk mencatat donasi barang bekas dari masyarakat. Data donasi dikelompokkan
menjadi dua jenis, yaitu **pakaian** dan **elektronik**, karena tiap jenis punya informasi tambahan
yang berbeda. Fitur: Create, Read, Update, Delete (CRUD) dengan validasi input dan dummy data awal.

## 2. Struktur Package
```
src/main/java/com/mycompany/sistemdonasibarangbekas/
├── Main.java                  -> entry point, menu (tampilan), dan pengelola data ArrayList
└── model/
    ├── Donasi.java            -> superclass (abstract)
    ├── DonasiPakaian.java     -> subclass 1
    └── DonasiElektronik.java  -> subclass 2
```
Sesuai batasan **4 class**, pemisahan MVC diterapkan secara sederhana:

| Bagian MVC | Lokasi | Keterangan |
|---|---|---|
| Model | package `model` | Data & aturan validasi (Donasi, DonasiPakaian, DonasiElektronik) |
| View + Controller | `Main.java` | Menampilkan menu, membaca input, dan mengelola `ArrayList<Donasi>` |

> Catatan: View dan Controller belum dipisah menjadi class tersendiri karena dibatasi 4 class.

## 3. Diagram Kelas
```
            +-----------------------------+
            |     <<abstract>> Donasi     |
            +-----------------------------+
            | - idDonasi : String         |
            | - namaPendonor : String     |
            | - namaBarang : String       |
            | - jumlahBarang : int        |
            +-----------------------------+
            | + getter / setter (valid.)  |
            | + getKategori() : String    |  <- abstract
            | + tampilkanInfo() : String  |
            | + tampilkanInfo(int)        |  <- overloading
            +--------------+--------------+
                  ^                ^
                  |                |
   +--------------+---+      +-----+--------------------+
   |  DonasiPakaian   |      |    DonasiElektronik      |
   +------------------+      +--------------------------+
   | - ukuran         |      | - merek : String         |
   |                  |      | - masihBerfungsi : bool  |
   | + getKategori()  |      | + getKategori()          |
   | + tampilkanInfo()|      | + tampilkanInfo()        |
   +------------------+      +--------------------------+
```

## 4. Penerapan Konsep OOP

**Inheritance** – `Donasi` adalah superclass, `DonasiPakaian` dan `DonasiElektronik` adalah subclass
(`extends Donasi`). Atribut umum (id, pendonor, barang, jumlah) ada di superclass, atribut khusus
(ukuran; merek & status berfungsi) ada di subclass. Subclass memanggil `super(...)` di constructor.

**Encapsulation & Access Modifier** – semua atribut `private`, diakses lewat getter/setter `public`.
Method `validasiTeks()` bersifat `protected` (hanya untuk Donasi dan subclass-nya).
Di `Main`, ArrayList dan method bantu bersifat `private static`.

**Validasi Input**
- Setter melempar `IllegalArgumentException` jika teks kosong atau jumlah < 1.
- `Main` memvalidasi angka (harus angka dan dalam rentang), teks tidak kosong, ID tidak boleh duplikat,
  konfirmasi y/n, dan nomor data harus ada di list. Program tidak crash saat input salah.

**Dummy Data** – method `isiDataAwal()` mengisi 4 data (2 pakaian, 2 elektronik) sehingga menu
"Tampilkan Data" langsung menampilkan data.

**Polymorphism**
- *Overriding*: `tampilkanInfo()` di-override di kedua subclass (memanggil `super.tampilkanInfo()` lalu
  menambah info khusus). Di `Main`, `daftarDonasi.get(i).tampilkanInfo(...)` memanggil versi sesuai tipe objek.
- *Overloading*: `tampilkanInfo()` vs `tampilkanInfo(int nomor)`, serta constructor ganda
  (mis. `DonasiPakaian` tanpa ukuran otomatis "All Size", `DonasiElektronik` tanpa status otomatis berfungsi).

## 5. Alur Program
1. Tambah Data Donasi (pilih jenis Pakaian/Elektronik, lalu isi data)
2. Tampilkan Data Donasi
3. Ubah Data Donasi (berdasarkan nomor urut)
4. Hapus Data Donasi (dengan konfirmasi)
0. Keluar

## 6. Screenshot Program
> <img width="175" height="83" alt="image" src="https://github.com/user-attachments/assets/71d438fc-22f1-4d16-b0b2-4b8ae6909dcf" />

<img width="257" height="122" alt="Screenshot 2026-09-21 232755" src="https://github.com/user-attachments/assets/c2da9d9f-1fe7-4ab2-bff6-38a5d0ba1a51" />

<img width="512" height="67" alt="image" src="https://github.com/user-attachments/assets/bf38c3df-0492-43cc-af50-70ca88f1f59b" />
