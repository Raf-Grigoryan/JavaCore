package homework.market.service.Impl;

import homework.market.model.product.Product;
import homework.market.model.product.ProductType;
import homework.market.service.ProductService;

public class ProductServiceImpl implements ProductService {
    private Product[] products = new Product[10];
    private int size = -1;

    @Override
    public void addProduct(Product product) {
        if (size == products.length) {
            extend();
        }
        products[++size] = product;

    }

    private void extend() {
        Product[] tmp = new Product[products.length + 10];
        System.arraycopy(products, 0, tmp, 0, size);
        products = tmp;
    }


    @Override
    public void removeProductById(String id) {
        boolean found = false;
        if (size < 0) {
            System.out.println("Storage is empty");
        } else {
            for (int i = 0; i <= size; i++) {
                if (products[i].getId().equals(id)) {
                    found = true;
                    for (int j = i; j <= size; j++) {
                        products[j] = products[j + 1];
                    }
                    products[size] = null;
                    size--;
                    System.out.println("Product with ID " + id + " has been deleted.");
                    break;
                }
            }

            if (!found) {
                System.out.println("Product with ID " + id + " not found.");
            }
        }
    }


    @Override
    public void printProducts() {
        for (int i = 0; i <= size; i++) {
            System.out.println(products[i]);
        }
    }

    @Override
    public void printProductTypes() {
        ProductType[] productTypes = ProductType.values();
        for (ProductType productType : productTypes) {
            System.out.println(productType.name());
        }
    }

    @Override
    public boolean isEmpty() {
        return size <= -1;
    }

    @Override
    public Product searchProductById(String id) {
        for (int i = 0; i <= size; i++) {
            if (products[i].getId().equals(id)) {
                return products[i];
            }
        }
        return null;
    }
}
