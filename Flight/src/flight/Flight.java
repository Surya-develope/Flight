package flight;
import java.util.Scanner;

public class Flight {

    private class Passenger {
        String name;
        Passenger next;

        public Passenger(String name) {
            this.name = name;
            this.next = null;
        }
    }

    private Passenger head;

    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);
        if (head == null) {
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) { 
                current = current.next;
            }
            current.next = newPassenger; 
        }
        System.out.println(name + " telah ditambahkan ke penerbangan.");
    }


    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("Tidak ada penumpang yang dapat dihapus.");
            return;
        }

    
        if (head.name.equals(name)) {
            head = head.next;
            System.out.println(name + " telah dihapus.");
            return;
        }

        Passenger current = head;
        Passenger previous = null;

        while (current != null && !current.name.equals(name)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Penumpang tidak ditemukan.");
        } else {
            previous.next = current.next;
            System.out.println(name + " telah dihapus.");
        }
    }

    public void displayPassengers() {
        if (head == null) {
            System.out.println("Tidak ada penumpang di daftar.");
            return;
        }

        Passenger current = head;
        System.out.println("Daftar penumpang:");
        while (current != null) {
            System.out.println("- " + current.name);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Flight flight = new Flight();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Penumpang");
            System.out.println("2. Hapus Penumpang");
            System.out.println("3. Tampilkan Penumpang");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Konsumsi newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama penumpang yang ingin ditambahkan: ");
                    String nameToAdd = scanner.nextLine();
                    flight.addPassenger(nameToAdd);
                    break;

                case 2:
                    System.out.print("Masukkan nama penumpang yang ingin dihapus: ");
                    String nameToRemove = scanner.nextLine();
                    flight.removePassenger(nameToRemove);
                    break;

                case 3:
                    flight.displayPassengers();
                    break;

                case 4:
                    exit = true;
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }
}
