package libManSystem;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", available=" + available +
                '}';
    }
}

class Borrower {
    String name;

    public Borrower(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class LibraryManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Borrower> borrowers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Check Book Availability");
            System.out.println("4. Manage Borrowers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    checkBookAvailability();
                    break;
                case 4:
                    manageBorrowers();
                    break;
                case 5:
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        Book newBook = new Book(title, author);
        books.add(newBook);

        System.out.println("Book added successfully: " + newBook);
    }

    private static void removeBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter book title to remove: ");
        String title = scanner.nextLine();

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                books.remove(book);
                System.out.println("Book removed successfully: " + book);
                return;
            }
        }

        System.out.println("Book not found with title: " + title);
    }

    private static void checkBookAvailability() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter book title to check availability: ");
        String title = scanner.nextLine();

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book);
                if (book.available) {
                    System.out.println("Book is available for borrowing.");
                } else {
                    System.out.println("Book is currently borrowed.");
                }
                return;
            }
        }

        System.out.println("Book not found with title: " + title);
    }

    private static void manageBorrowers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Add Borrower");
        System.out.println("2. View Borrowers");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addBorrower();
                break;
            case 2:
                viewBorrowers();
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static void addBorrower() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter borrower name: ");
        String name = scanner.nextLine();

        Borrower newBorrower = new Borrower(name);
        borrowers.add(newBorrower);

        System.out.println("Borrower added successfully: " + newBorrower);
    }

    private static void viewBorrowers() {
        System.out.println("List of Borrowers:");
        for (Borrower borrower : borrowers) {
            System.out.println(borrower);
        }
    }
}
