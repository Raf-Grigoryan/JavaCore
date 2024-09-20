package homework.market.service;

import homework.market.model.product.Product;

public interface ProductService {

    void addProduct(Product product);

    void removeProductById(String id);

    void printProducts();

    void printProductTypes();

    boolean isEmpty();

    Product searchProductById(String id);
}
