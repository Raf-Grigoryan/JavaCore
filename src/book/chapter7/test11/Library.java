package book.chapter7.test11;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private static List<Book> books = new ArrayList();
    private static int idCounter = 1000;

    public class Book {
        private String name;
        private String author;
        private final int id;

        public Book(String name) {
            this.name = name;
            id = ++idCounter;
            books.add(this);
        }

        public Book(String name, String author) {
            this.name = name;
            this.author = author;
            this.id = ++idCounter; // Присваиваем уникальный ID
            books.add(this);
        }

        public void bookInformation() {
            boolean fullName;
            if (author != null) {
                fullName = true;
            } else {
                fullName = false;
            }
            bookInformation(fullName);
        }

        private void bookInformation(boolean fullName) {
            if (fullName) {
                System.out.println("Book Author " + author + " name " + name);
            } else {
                System.out.println("Book Author unknown author: book name " + name);
            }
        }
    }

    public static void printAllBooks() {
        for (Book book : books) {
            book.bookInformation();
        }
    }

    public static void addBook(Book book) {
        books.add(book);
    }
}
