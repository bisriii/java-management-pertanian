import java.util.ArrayList;
import java.util.Scanner;

class Tanaman {
   private final String nama;
    private final int lamaPanen; // dalam hari
   private final  String jenisTanah;
    private final int jumlahTanaman;

    Tanaman(String nama, int lamaPanen, String jenisTanah, int jumlahTanaman) {
        this.nama = nama;
        this.lamaPanen = lamaPanen;
        this.jenisTanah = jenisTanah;
        this.jumlahTanaman = jumlahTanaman;
    }

    void tampilkanInfo() {
        System.out.println("Nama Tanaman: " + nama);
        System.out.println("Lama Panen (hari): " + lamaPanen);
        System.out.println("Jenis Tanah: " + jenisTanah);
        System.out.println("Jumlah Tanaman: " + jumlahTanaman);
    }
}

class AplikasiManajemenPertanian {

    private static final int TAMBAH_TANAMAN = 1;
    private static final int LIHAT_DAFTAR_TANAMAN = 2;
    private static final int KELUAR = 3;
    static ArrayList<Tanaman> daftarTanaman = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n1. Tambah Tanaman");
            System.out.println("2. Lihat Daftar Tanaman");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case TAMBAH_TANAMAN:
                    tambahTanaman();
                    break;
                case LIHAT_DAFTAR_TANAMAN:
                    tampilkanDaftarTanaman();
                    break;
                case KELUAR:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    static void tambahTanaman() {
       String nama = inputString("nama tanaman:");
       int lamaPanen = inputInt("Lama Panen:");
       String jenisTanah = inputString("jenis tanah:");
       int jumlahTanaman = inputInt("jumlah tanaman");


        tambahtanaman(nama, lamaPanen, jenisTanah, jumlahTanaman);
    }

    private static void tambahtanaman(String nama, int lamaPanen, String jenisTanah, int jumlahTanaman) {
        Tanaman tanaman = new Tanaman(nama, lamaPanen, jenisTanah, jumlahTanaman);
        daftarTanaman.add(tanaman);
        System.out.println("Tanaman berhasil ditambahkan!");
    }

    private static String inputString(String pesan) {
        System.out.println(pesan);
        return scanner.nextLine();
    }

    private static int inputInt(String pesan) {
        System.out.println(pesan);
        int nilai = scanner.nextInt();
        scanner.nextLine();
        return nilai;
    }


    static void tampilkanDaftarTanaman() {
        if (daftarTanaman.isEmpty()) {
            System.out.println("Belum ada tanaman yang terdaftar.");
        } else {
            for (Tanaman tanaman : daftarTanaman) {
                tanaman.tampilkanInfo();
                System.out.println();
            }
        }
    }
}
