public class ClassPeminjaman19 {
    ClassMahasiswa19 mhs;
    ClassBuku19 buku;
    int lamaPinjam, terlambat, denda;

    ClassPeminjaman19(ClassMahasiswa19 mhs, ClassBuku19 buku, int lamaPinjam) {
        this.mhs = mhs;
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;
        hitungDenda();
    }

    void hitungDenda() {
        int batas = 5;
        terlambat = lamaPinjam - batas;

        if (terlambat > 0) {
            denda = terlambat * 2000;
        } else {
            terlambat = 0;
            denda = 0;
        }
    }

    void tampil() {
        System.out.println(mhs.nim + " | " + mhs.nama + " | " 
            + buku.judul + " | " + lamaPinjam + 
            " | Terlambat: " + terlambat + 
            " | Denda: " + denda);
    }
}