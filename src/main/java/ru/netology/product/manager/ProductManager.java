package ru.netology.product.manager;

import ru.netology.product.Product;
import ru.netology.product.repository.ProductRepository;

public class ProductManager {

    private final ProductRepository repository;

    public ProductManager(ProductRepository repository) {

        this.repository = repository;
    }

    public void add(Product product) {

        repository.add(product);
    }

    public Product[] searchBy(String text) {

        Product[] result = new Product[0];

        for (Product product : repository.getAllProducts()) {

            if (product.matches(text)) {

                Product[] tmp = new Product[result.length + 1];

                for (int ind = 0; ind < result.length; ind++) {

                    tmp[ind] = result[ind];
                }

                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }

        return result;
    }

}
