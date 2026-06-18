import java.util.ArrayList;
import java.util.Scanner;

class Ticket {
    String customerName;
    String movieName;
    int seatNumber;
    int price;

    Ticket(String customerName, String movieName, int seatNumber, int price) {
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    void display() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Movie Name    : " + movieName);
        System.out.println("Seat Number   : " + seatNumber);
        System.out.println("Ticket Price  : ₹" + price);
        System.out.println("-----------------------------");
    }
}

public class MovieTicketSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Ticket> bookings = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n==================================");
            System.out.println("        MOVIE TICKET SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Show Movies");
            System.out.println("2. Book Ticket");
            System.out.println("3. View All Bookings");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Show Total Collection");
            System.out.println("6. Exit");
            System.out.println("==================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Movies");
                    System.out.println("1. Leo");
                    System.out.println("2. Jailer");
                    System.out.println("3. Avengers");
                    System.out.println("4. Pushpa");
                    break;

                case 2:
                    System.out.println("\n===== Ticket Booking =====");

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    System.out.println("Select Movie");
                    System.out.println("1. Leo - ₹200");
                    System.out.println("2. Jailer - ₹180");
                    System.out.println("3. Avengers - ₹250");
                    System.out.println("4. Pushpa - ₹220");

                    System.out.print("Enter movie choice: ");
                    int movieChoice = sc.nextInt();

                    String movieName = "";
                    int price = 0;

                    switch (movieChoice) {
                        case 1:
                            movieName = "Leo";
                            price = 200;
                            break;
                        case 2:
                            movieName = "Jailer";
                            price = 180;
                            break;
                        case 3:
                            movieName = "Avengers";
                            price = 250;
                            break;
                        case 4:
                            movieName = "Pushpa";
                            price = 220;
                            break;
                        default:
                            System.out.println("Invalid movie selection");
                            continue;
                    }

                    System.out.print("Enter Seat Number: ");
                    int seat = sc.nextInt();

                    Ticket t = new Ticket(name, movieName, seat, price);
                    bookings.add(t);

                    System.out.println("\n✅ Ticket Booked Successfully!");
                    break;

                case 3:
                    System.out.println("\n===== Booking Details =====");

                    if (bookings.isEmpty()) {
                        System.out.println("No bookings found.");
                    } else {
                        for (Ticket ticket : bookings) {
                            ticket.display();
                        }
                    }
                    break;

                case 4:
                    System.out.print("\nEnter Seat Number to cancel: ");
                    int cancelSeat = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < bookings.size(); i++) {
                        if (bookings.get(i).seatNumber == cancelSeat) {
                            bookings.remove(i);
                            found = true;
                            System.out.println("✅ Ticket Cancelled Successfully");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Seat not found!");
                    }
                    break;

                case 5:
                    int total = 0;
                    for (Ticket ticket : bookings) {
                        total += ticket.price;
                    }
                    System.out.println("\n💰 Total Collection: ₹" + total);
                    break;

                case 6:
                    System.out.println("Thank you for using Movie Ticket System 🎬");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        sc.close();
    }
}