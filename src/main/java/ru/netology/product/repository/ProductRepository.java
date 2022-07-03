package ru.netology.product.repository;

import ru.netology.product.Product;
import ru.netology.product.exception.NotFoundException;
import ru.netology.product.exception.AlreadyExistsException;

import java.util.Objects;

public class ProductRepository {
    private Product[] products;

    public ProductRepository() {

        products = new Product[0];
    }

    public void add(Product product) {

        if (!Objects.isNull(findProductById(product.getId()))) {

            throw new AlreadyExistsException("Product with id \"" + product.getId() + "\" already exists !");
        }

        Product[] tmp = new Product[products.length + 1];

        for (int ind = 0; ind < products.length; ind++) {

            tmp[ind] = products[ind];
        }

        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product findProductById(int id) {

        if (id > 0) {

            for (Product product : products) {

                if (product.getId() == id) {

                    return product;
                }
            }
        }

        return null;
    }

    public void removeProduct(int id) {

        if (Objects.isNull(findProductById(id))) {

            throw new NotFoundException("Product with id \"" + id + "\" was not found !");
        }

        int index = -1;
        Product[] tmp = new Product[products.length - 1];

        for (Product product : products) {

            if (product.getId() != id) {

                tmp[++index] = product;
            }
        }

        products = tmp;
    }

    public Product[] getAllProducts() {

        return products;
    }
}
