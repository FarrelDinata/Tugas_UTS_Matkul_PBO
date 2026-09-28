/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public abstract class Donasi {

    // Access modifier private -> encapsulation
    private String idDonasi;
    private String namaPendonor;
    private String namaBarang;
    private int jumlahBarang;

    // Constructor lengkap
    public Donasi(String idDonasi, String namaPendonor, String namaBarang, int jumlahBarang) {
        setIdDonasi(idDonasi);
        setNamaPendonor(namaPendonor);
        setNamaBarang(namaBarang);
        setJumlahBarang(jumlahBarang);
    }

    // Overloading constructor: jumlah otomatis 1
    public Donasi(String idDonasi, String namaPendonor, String namaBarang) {
        this(idDonasi, namaPendonor, namaBarang, 1);
    }

    // ===== Getter =====
    public String getIdDonasi() {
        return idDonasi;
    }

    public String getNamaPendonor() {
        return namaPendonor;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    // ===== Setter + validasi =====
    public void setIdDonasi(String idDonasi) {
        this.idDonasi = validasiTeks(idDonasi, "ID donasi");
    }

    public void setNamaPendonor(String namaPendonor) {
        this.namaPendonor = validasiTeks(namaPendonor, "Nama pendonor");
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = validasiTeks(namaBarang, "Nama barang");
    }

    public void setJumlahBarang(int jumlahBarang) {
        if (jumlahBarang < 1) {
            throw new IllegalArgumentException("Jumlah barang minimal 1.");
        }

        this.jumlahBarang = jumlahBarang;
    }

    // protected -> hanya bisa dipakai class ini dan subclass-nya
    protected static String validasiTeks(String teks, String namaField) {
        if (teks == null || teks.trim().isEmpty()) {
            throw new IllegalArgumentException(namaField + " tidak boleh kosong.");
        }

        return teks.trim();
    }

    // Wajib di-override oleh subclass
    public abstract String getKategori();

    // Method overriding akan dilakukan oleh subclass
    public String tampilkanInfo() {
        return "[" + getKategori() + "] " + idDonasi
                + " | Pendonor: " + namaPendonor
                + " | Barang: " + namaBarang
                + " | Jumlah: " + jumlahBarang;
    }

    // Overloading method: tampilkanInfo dengan nomor urut
    public String tampilkanInfo(int nomor) {
        return nomor + ". " + tampilkanInfo();
    }
}