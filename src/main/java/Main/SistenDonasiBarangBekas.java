/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import java.util.ArrayList;
import java.util.Scanner;
import model.Donasi;
import model.DonasiElektronik;
import model.DonasiPakaian;

/**
 *
 * @author DELL
 */
public class SistenDonasiBarangBekas {
    private static final ArrayList<Donasi> daftarDonasi = new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        isiDataAwal();

        int pilihan;
        do {
            tampilkanMenu();
            pilihan = bacaAngka("Pilih menu: ", 0, 4);

            switch (pilihan) {
                case 1:
                    tambahDonasi();
                    break;
                case 2:
                    lihatDonasi();
                    break;
                case 3:
                    ubahDonasi();
                    break;
                case 4:
                    hapusDonasi();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
            }
        } while (pilihan != 0);

        input.close();
    }

    // ================= DUMMY DATA =================
    private static void isiDataAwal() {
        daftarDonasi.add(new DonasiPakaian("D001", "Budi Santoso", "Jaket Hoodie", 3, "L"));
        daftarDonasi.add(new DonasiPakaian("D002", "Siti Aminah", "Kemeja Batik", 5)); // overloading
        daftarDonasi.add(new DonasiElektronik("D003", "Andi Wijaya", "Kipas Angin", 2, "Miyako", true));
        daftarDonasi.add(new DonasiElektronik("D004", "Rina Lestari", "Setrika", 1, "Philips")); // overloading
    }

    // ================= MENU =================
    private static void tampilkanMenu() {
        System.out.println("\n=== SISTEM DONASI BARANG BEKAS ===");
        System.out.println("1. Tambah Data Donasi");
        System.out.println("2. Tampilkan Data Donasi");
        System.out.println("3. Ubah Data Donasi");
        System.out.println("4. Hapus Data Donasi");
        System.out.println("0. Keluar");
    }

    // ================= CREATE =================
    private static void tambahDonasi() {
        System.out.println("\n--- Tambah Donasi ---");
        String id;
        while (true) {
            id = bacaTeks("ID Donasi: ");
            if (idSudahAda(id)) {
                System.out.println("ID sudah dipakai, gunakan ID lain.");
            } else {
                break;
            }
        }

        int jenis = bacaAngka("Jenis barang (1. Pakaian, 2. Elektronik): ", 1, 2);
        String pendonor = bacaTeks("Nama Pendonor: ");
        String barang = bacaTeks("Nama Barang: ");
        int jumlah = bacaAngka("Jumlah Barang (1-1000): ", 1, 1000);

        try {
            if (jenis == 1) {
                String ukuran = bacaTeks("Ukuran (S/M/L/XL/All Size): ");
                daftarDonasi.add(new DonasiPakaian(id, pendonor, barang, jumlah, ukuran));
            } else {
                String merek = bacaTeks("Merek: ");
                boolean berfungsi = bacaYaTidak("Masih berfungsi? (y/n): ");
                daftarDonasi.add(new DonasiElektronik(id, pendonor, barang, jumlah, merek, berfungsi));
            }
            System.out.println("Donasi berhasil ditambahkan!");
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal menambah data: " + e.getMessage());
        }
    }

    // ================= READ =================
    private static void lihatDonasi() {
        if (daftarDonasi.isEmpty()) {
            System.out.println("Belum ada data donasi.");
            return;
        }
        System.out.println("\n=== DAFTAR DONASI ===");
        for (int i = 0; i < daftarDonasi.size(); i++) {
            // Polymorphism: method yang dipanggil sesuai tipe objek sebenarnya
            System.out.println(daftarDonasi.get(i).tampilkanInfo(i + 1));
        }
    }

    // ================= UPDATE =================
    private static void ubahDonasi() {
        if (daftarDonasi.isEmpty()) {
            System.out.println("Belum ada data donasi.");
            return;
        }
        lihatDonasi();
        int no = bacaAngka("Nomor donasi yang diubah: ", 1, daftarDonasi.size());
        Donasi d = daftarDonasi.get(no - 1);

        try {
            d.setNamaPendonor(bacaTeks("Nama pendonor baru: "));
            d.setNamaBarang(bacaTeks("Nama barang baru: "));
            d.setJumlahBarang(bacaAngka("Jumlah baru (1-1000): ", 1, 1000));

            if (d instanceof DonasiPakaian) {
                ((DonasiPakaian) d).setUkuran(bacaTeks("Ukuran baru: "));
            } else if (d instanceof DonasiElektronik) {
                DonasiElektronik e = (DonasiElektronik) d;
                e.setMerek(bacaTeks("Merek baru: "));
                e.setMasihBerfungsi(bacaYaTidak("Masih berfungsi? (y/n): "));
            }
            System.out.println("Donasi berhasil diubah!");
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal mengubah data: " + e.getMessage());
        }
    }

    // ================= DELETE =================
    private static void hapusDonasi() {
        if (daftarDonasi.isEmpty()) {
            System.out.println("Belum ada data donasi.");
            return;
        }
        lihatDonasi();
        int no = bacaAngka("Nomor donasi yang dihapus: ", 1, daftarDonasi.size());
        if (bacaYaTidak("Yakin hapus data ini? (y/n): ")) {
            daftarDonasi.remove(no - 1);
            System.out.println("Donasi berhasil dihapus!");
        } else {
            System.out.println("Penghapusan dibatalkan.");
        }
    }

    // ================= VALIDASI INPUT =================
    private static boolean idSudahAda(String id) {
        for (Donasi d : daftarDonasi) {
            if (d.getIdDonasi().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    private static int bacaAngka(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String teks = input.nextLine().trim();
            try {
                int angka = Integer.parseInt(teks);
                if (angka >= min && angka <= max) {
                    return angka;
                }
                System.out.println("Masukkan angka antara " + min + " sampai " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    private static String bacaTeks(String prompt) {
        while (true) {
            System.out.print(prompt);
            String teks = input.nextLine().trim();
            if (!teks.isEmpty()) {
                return teks;
            }
            System.out.println("Input tidak boleh kosong.");
        }
    }

    private static boolean bacaYaTidak(String prompt) {
        while (true) {
            System.out.print(prompt);
            String teks = input.nextLine().trim().toLowerCase();
            if (teks.equals("y")) {
                return true;
            }
            if (teks.equals("n")) {
                return false;
            }
            System.out.println("Ketik y atau n.");
        }
    }
}
    

