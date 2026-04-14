import java.util.Scanner;

public class Main19 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Data Mahasiswa
        ClassMahasiswa19[] mhs = {
            new ClassMahasiswa19("22001", "Andi", "Teknik Informatika"),
            new ClassMahasiswa19("22002", "Budi", "Teknik Informatika"),
            new ClassMahasiswa19("22003", "Citra", "Sistem Informasi Bisnis")
        };

        // Data Buku
        ClassBuku19[] buku = {
            new ClassBuku19("B001", "Algoritma", 2020),
            new ClassBuku19("B002", "Basis Data", 2019),
            new ClassBuku19("B003", "Pemrograman", 2021),
            new ClassBuku19("B004", "Fisika", 2024)
        };

        // Data Peminjaman
        ClassPeminjaman19[] pinjam = {
            new ClassPeminjaman19(mhs[0], buku[0], 7),
            new ClassPeminjaman19(mhs[1], buku[1], 3),
            new ClassPeminjaman19(mhs[2], buku[2], 10),
            new ClassPeminjaman19(mhs[2], buku[3], 6),
            new ClassPeminjaman19(mhs[0], buku[1], 4)
        };

        int pilih;
        do {
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("6. Mahasiswa Meminjam > 1 Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    System.out.println("\nDaftar Mahasiswa:");
                    for (ClassMahasiswa19 m : mhs) {
                        System.out.println("NIM: " + m.nim + " | Nama: " + m.nama + " | Prodi: " + m.prodi);
                    }
                    break;

                case 2:
                    System.out.println("\nDaftar Buku:");
                    for (ClassBuku19 b : buku) {
                        System.out.println("Kode: " + b.kode + " | Judul: " + b.judul + " | Tahun: " + b.tahun);
                    }
                    break;

                case 3:
                    System.out.println("\nData Peminjaman:");
                    for (ClassPeminjaman19 p : pinjam) {
                        System.out.println(p.mhs.nama + " | " + p.buku.judul +
                                " | Lama: " + p.lamaPinjam +
                                " | Terlambat: " + p.terlambat +
                                " | Denda: " + p.denda);
                    }
                    break;

                case 4:
                    // Insertion Sort (Descending denda)
                    for (int i = 1; i < pinjam.length; i++) {
                        ClassPeminjaman19 temp = pinjam[i];
                        int j = i - 1;
                        while (j >= 0 && pinjam[j].denda < temp.denda) {
                            pinjam[j + 1] = pinjam[j];
                            j--;
                        }
                        pinjam[j + 1] = temp;
                    }

                    System.out.println("\nSetelah diurutkan (Denda terbesar):");
                    for (ClassPeminjaman19 p : pinjam) {
                        System.out.println(p.mhs.nama + " | " + p.buku.judul +
                                " | Lama: " + p.lamaPinjam +
                                " | Terlambat: " + p.terlambat +
                                " | Denda: " + p.denda);
                    }
                    break;

                case 5:
                    System.out.print("Masukkan NIM: ");
                    String cari = sc.next();

                    boolean ketemu = false;
                    for (ClassPeminjaman19 p : pinjam) {
                        if (p.mhs.nim.equals(cari)) {
                            System.out.println(p.mhs.nama + " | " + p.buku.judul +
                                    " | Lama: " + p.lamaPinjam +
                                    " | Terlambat: " + p.terlambat +
                                    " | Denda: " + p.denda);
                            ketemu = true;
                        }
                    }

                    if (!ketemu) {
                        System.out.println("Data tidak ditemukan!");
                    }
                    break;
                case 6:
                    System.out.println("\nMahasiswa yang meminjam lebih dari 1 buku:");

                    for (int i = 0; i < mhs.length; i++) {
                         int jumlah = 0;

                    for (ClassPeminjaman19 p : pinjam) {
                         if (p.mhs.nim.equals(mhs[i].nim)) {
                      jumlah++;
                     }
        }
                 if (jumlah > 1) {
                     System.out.println(mhs[i].nim + " | " + mhs[i].nama + " | Jumlah Pinjam: " + jumlah);
                 }
                }
                break;
                    
                case 0:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilih != 0);
    }
}

