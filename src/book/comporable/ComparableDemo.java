package book.comporable;

import java.util.ArrayList;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.*;

public class ComparableDemo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(14, "book 4", 500));
        products.add(new Product(11, "book 1", 200));
        products.add(new Product(13, "book 3", 400));
        products.add(new Product(12, "book 2", 300));

        products.sort(Comparator.comparingDouble(Product::getPrice));

        for (Product product : products) {
            System.out.println(product);
        }
    }
}
