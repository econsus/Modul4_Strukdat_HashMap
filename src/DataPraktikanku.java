import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataPraktikanku {
    private HashMap<String, String> tabelData;
    private HashMap<String, String> tabelSesiLogin;
    static DataPraktikanku dataPraktikan = new DataPraktikanku();
    static public String username;
    static public String password;

    public DataPraktikanku() {
        tabelData = new HashMap<String, String>();
        tabelSesiLogin = new HashMap<String, String>();
    }

    public void tambahData(String nimPraktikan, String namaAsisten) {
        if (nimPraktikan.startsWith("IF") && !tabelData.containsKey(nimPraktikan)) {
            tabelData.put(nimPraktikan, namaAsisten);
            System.out.println("Data berhasil ditambahkan.");
        } else {
            System.out.println("NIM tidak valid atau sudah terdaftar");
        }
    }

    public void tampil() {
        if (tabelData.isEmpty()) {
            System.out.println("Belum Ada Data yang diinputkan");
        }
        for (Map.Entry<String, String> entry : tabelData.entrySet()) {
            System.out.println("NIM : " + entry.getKey() + "\nAsisten : " + entry.getValue());
        }
    }

    public void listNimPraktikan() {
        System.out.println("Daftar NIM praktikan:");
        for (String nim : tabelData.keySet()) {
            System.out.println(nim);
        }
    }

    public void listNamaAsisten() {
        System.out.println("Daftar nama asisten:");
        for (String nama : tabelData.values()) {
            System.out.println(nama);
        }
    }

    public void totalEmail() {
        System.out.println("Total data: " + tabelData.size());
    }

    public void hapusData(String nimPraktikan, String namaAsisten) {
        if (tabelData.containsKey(nimPraktikan) && tabelData.get(nimPraktikan).equals(namaAsisten)) {
            tabelData.remove(nimPraktikan);
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Data gagal dihapus.");
        }
    }

    public void editData(String nimPraktikan, String namaAsisten) {
        if (tabelData.containsKey(nimPraktikan)) {
            tabelData.put(nimPraktikan, namaAsisten);
            System.out.println("Data berhasil diubah.");
        } else {
            System.out.println("NIM tidak terdaftar");
        }
    }

    public void login(String user, String pass) {
        dataPraktikan.tabelSesiLogin.put("mha150720", "55555");
        if (username.contains("@umm.ac.id")) {
            String[] split = username.split("@");
            username = split[0];

            if (dataPraktikan.tabelSesiLogin.containsKey(username) && dataPraktikan.tabelSesiLogin.get(username).equals(password)) {
                dataPraktikan.tampilMenu();
            } else {
                System.out.println("Username atau password anda tidak benar");
            }
        } else {
            System.out.println("Domain anda bukan @umm.ac.id");
        }
    }

    public void logout() {
        System.out.println("Anda Berhasil Logout");
    }

    public void tampilMenu() {
        Scanner scanner = new Scanner(System.in);
        int menu = 0;
        do {
            System.out.println("Menu:");
            System.out.println("1. Login");
            System.out.println("2. Tambah data");
            System.out.println("3. Tampilkan data");
            System.out.println("4. Daftar NIM praktikan");
            System.out.println("5. Daftar nama asisten");
            System.out.println("6. Total data");
            System.out.println("7. Hapus data");
            System.out.println("8. Ubah data");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1 :
                    System.out.println("welcome");
                    break;
                case 2:
                    System.out.print("Masukkan NIM praktikan (dimulai dengan IF) : ");
                    String nim = scanner.nextLine();
                    System.out.print("Masukkan nama asisten: ");
                    String nama = scanner.nextLine();
                    dataPraktikan.tambahData(nim, nama);
                    break;
                case 3:
                    dataPraktikan.tampil();
                    break;
                case 4:
                    dataPraktikan.listNimPraktikan();
                    break;
                case 5:
                    dataPraktikan.listNamaAsisten();
                    break;
                case 6:
                    dataPraktikan.totalEmail();
                    break;
                case 7:
                    System.out.print("Masukkan NIM praktikan yang ingin dihapus (dimulai dengan IF) : ");
                    nim = scanner.nextLine();
                    System.out.print("Masukkan nama asisten: ");
                    nama = scanner.nextLine();
                    dataPraktikan.hapusData(nim, nama);
                    break;
                case 8:
                    System.out.println("Masukkan NIM praktikan : ");
                    nim = scanner.nextLine();
                    System.out.println("Masukkan nama asisten baru : ");
                    nama = scanner.nextLine();
                    dataPraktikan.editData(nim, nama);
                    break;
                case 0:
                    dataPraktikan.logout();
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
            System.out.println();
        } while (menu != 0);

    }
}
