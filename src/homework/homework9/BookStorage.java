package homework.homework9;

public class BookStorage {
    private Book[] books = new Book[10];
    private int size = -1;

    public void add(Book book) {
        if (size == books.length) {
            extend();
        }
        books[++size] = book;
    }

    private void extend() {
        Book[] tmp = new Book[size + 10];
        System.arraycopy(books, 0, tmp, 0, size);
        books = tmp;
    }

    public Book searchBookById(String id) {
        if (size > -1) {
            for (int i = 0; i <= size; i++) {
                if (books[i].getId().equals(id)) {
                    return books[i];
                }
            }
        }
        return null;
    }

    public void printAllBooks() {
        for (int i = 0; i <= size; i++) {
            System.out.println(books[i]);
        }
    }

    public void searchBookByName(String bookName) {
        for (int i = 0; i <= size; i++) {
            if (books[i].getAuthorName().equals(bookName)) {
                System.out.println(books[i]);
            }
        }
    }

    public void printBooksByPrice(double price1, double price2) {
        if (price1 > price2) {
            System.out.println("The first price cannot be more than the second!");
        } else {
            for (int i = 0; i <= size; i++) {
                if (books[i].getPrice() >= price1 && books[i].getPrice() <= price2) {
                    System.out.println(books[i]);
                }
            }
        }

    }

    public void deleteBookById(String id) {
        boolean found = false;
        if (size < 0) {
            System.out.println("Storage is empty");
        } else {
            for (int i = 0; i <= size; i++) {
                if (books[i].getId().equals(id)) {
                    found = true;
                    for (int j = i; j < size; j++) {
                        books[j] = books[j + 1];
                    }
                    books[size] = null;
                    size--;
                    System.out.println("Book with ID " + id + " has been deleted.");
                    break;
                }
            }

            if (!found) {
                System.out.println("Book with ID " + id + " not found.");
            }
        }
    }

}


