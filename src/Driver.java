import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        DataPraktikanku data = new DataPraktikanku();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan Email : ");
        DataPraktikanku.username = scanner.nextLine();
        System.out.println("Masukkan Password : ");
        DataPraktikanku.password = scanner.nextLine();
        data.login(DataPraktikanku.username, DataPraktikanku.password);
    }
}
