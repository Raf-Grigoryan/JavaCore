package homework.homework9;

import java.util.Scanner;


public class Library implements Commands{
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookStorage bookStorage = new BookStorage();


    public static void main(String[] args) {
        process();
    }

    private static void process() {
        boolean isRun = true;
        while (isRun) {
            Commands.commands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT -> {
                    System.out.println("BYE");
                    isRun = false;
                }
                case ADD_BOOK -> addBook();
                case PRINT_ALL_BOOKS -> bookStorage.printAllBooks();
                case BOOK_BY_NAME -> searchBookByName();
                case UPDATE_BOOK -> updateBookById();
                case SEARCH_BY_PRICE -> searchBookByPrice();
                case DELETE_BOOK -> deleteBookById();
                default -> System.out.println("Wrong command please try again!");

            }
        }
    }

    private static void deleteBookById() {
        System.out.println("Please input id");
        String id = scanner.nextLine();
        bookStorage.deleteBookById(id);
    }



    private static void addBook() {
        System.out.println("Please input book id");
        String id = scanner.nextLine();
        if (bookStorage.searchBookById(id) == null) {
            System.out.println("PLease input book name");
            String bookName = scanner.nextLine();
            System.out.println("Please input author name");
            String authorName = scanner.nextLine();
            System.out.println("Please input book price");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Please input book count");
            int count = Integer.parseInt(scanner.nextLine());
            bookStorage.add(new Book(id, bookName, authorName, price, count));
        } else {
            System.out.println("Book is exist");
        }

    }

    private static void searchBookByName() {
        System.out.println("Please input keyword");
        String keyword = scanner.nextLine();
        bookStorage.searchBookByName(keyword);
    }

    private static void updateBookById() {
        bookStorage.printAllBooks();
        System.out.println("Please input book id");
        String id = scanner.nextLine();
        Book book = bookStorage.searchBookById(id);
        if (book != null) {
            System.out.println("Please input book new name");
            String bookName = scanner.nextLine();
            System.out.println("Please input new author name");
            String authorName = scanner.nextLine();
            System.out.println("Please input book new price");
            String priceStr = scanner.nextLine();
            System.out.println("Please input book new count");
            String countStr = scanner.nextLine();

            if (bookName != null && !bookName.isEmpty()) {
                book.setTitle(bookName);
            }
            if (authorName != null && !authorName.isEmpty()) {
                book.setAuthorName(authorName);
            }
            if (priceStr != null && !priceStr.isEmpty()) {
                try {
                    book.setPrice(Double.parseDouble(priceStr));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price format.");
                }
            }
            if (countStr != null && !countStr.isEmpty()) {
                try {
                    book.setQuantity(Integer.parseInt(countStr));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid count format.");
                }
            }
        } else {
            System.out.println("Book not found!");
        }
    }

    private static void searchBookByPrice() {
        System.out.println("Please input first price");
        double price1 = Double.parseDouble(scanner.nextLine());
        System.out.println("Please input second price");
        double price2 = Double.parseDouble(scanner.nextLine());
        bookStorage.printBooksByPrice(price1, price2);
    }


}
