/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class DonasiPakaian extends Donasi {

    private String ukuran;

    public DonasiPakaian(String idDonasi, String namaPendonor, String namaBarang,
                         int jumlahBarang, String ukuran) {
        super(idDonasi, namaPendonor, namaBarang, jumlahBarang);
        setUkuran(ukuran);
    }

    // Overloading constructor: ukuran default "All Size"
    public DonasiPakaian(String idDonasi, String namaPendonor, String namaBarang,
                         int jumlahBarang) {
        this(idDonasi, namaPendonor, namaBarang, jumlahBarang, "All Size");
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = validasiTeks(ukuran, "Ukuran");
    }

    @Override
    public String getKategori() {
        return "Pakaian";
    }

    @Override
    public String tampilkanInfo() {
        return super.tampilkanInfo() + " | Ukuran: " + ukuran;
    }
}

