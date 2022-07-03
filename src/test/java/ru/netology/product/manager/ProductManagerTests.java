package ru.netology.product.manager;

import org.junit.jupiter.api.Test;

import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;

import ru.netology.product.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTests {

    Book book1 = new Book(1, "history 1", 3000, "Petya Petrov");
    Book book2 = new Book(2, "history 7", 3000, "Petya Black");
    Book book3 = new Book(3, "english language", 4000, "Chine Chinov");
    Smartphone smartphone1 = new Smartphone(4, "Iphone 7", 100000, "Chine");
    Smartphone smartphone2 = new Smartphone(5, "Highscreen", 105000, "South Korea");

    @Test
    public void shouldSearchProductByManufactureFullName() {

        ProductRepository productRepository = new ProductRepository();
        ProductManager productManager = new ProductManager(productRepository);

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone1);
        productManager.add(smartphone2);

        Product[] expectedProducts = {smartphone1};
        Product[] actualProducts = productManager.searchBy(smartphone1.getManufacture());

        assertArrayEquals(actualProducts, expectedProducts);
    }

    @Test
    public void shouldSearchProductByManufactureStartWith() {

        ProductRepository productRepository = new ProductRepository();
        ProductManager productManager = new ProductManager(productRepository);

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);

        Product[] expectedProducts = {smartphone2};
        Product[] actualProducts = productManager.searchBy("South");

        assertArrayEquals(expectedProducts, actualProducts);
    }

    @Test
    public void shouldSearchProductByManufactureEndsWith() {

        ProductRepository productRepository = new ProductRepository();
        ProductManager productManager = new ProductManager(productRepository);

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);

        Product[] expectedProducts = {smartphone2};
        Product[] actualProducts = productManager.searchBy("Korea");

        assertArrayEquals(expectedProducts, actualProducts);
    }

    @Test
    public void shouldSearchProductByFullName() {

        ProductRepository productRepository = new ProductRepository();
        ProductManager productManager = new ProductManager(productRepository);

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone1);
        productManager.add(smartphone2);

        Product[] expectedProducts = {book1};
        Product[] actualProducts = productManager.searchBy(book1.getName());

        assertArrayEquals(expectedProducts, actualProducts);
    }

    @Test
    public void shouldSearchProductByNameStartWith() {

        ProductRepository productRepository = new ProductRepository();
        ProductManager productManager = new ProductManager(productRepository);

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);

        Product[] expectedProducts = {book1, book2};
        Product[] actualProducts = productManager.searchBy("history");

        assertArrayEquals(expectedProducts, actualProducts);
    }

    @Test
    public void shouldSearchProductByNameEndsWith() {

        ProductRepository productRepository = new ProductRepository();
        ProductManager productManager = new ProductManager(productRepository);

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);

        Product[] expectedProducts = {book2, smartphone1};
        Product[] actualProducts = productManager.searchBy("7");

        assertArrayEquals(expectedProducts, actualProducts);
    }

    @Test
    public void shouldSearchProductByAuthor() {

        ProductRepository productRepository = new ProductRepository();
        ProductManager productManager = new ProductManager(productRepository);

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);

        Product[] expectedProducts = {book3};
        Product[] actualProducts = productManager.searchBy(book3.getAuthor());

        assertArrayEquals(expectedProducts, actualProducts);
    }

    @Test
    public void shouldSearchProductByAuthorStartWith() {

        ProductRepository productRepository = new ProductRepository();
        ProductManager productManager = new ProductManager(productRepository);

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);

        Product[] expectedProducts = {book1, book2};
        Product[] actualProducts = productManager.searchBy("Petya");

        assertArrayEquals(expectedProducts, actualProducts);
    }

    @Test
    public void shouldSearchProductByAuthorEndsWith() {

        ProductRepository productRepository = new ProductRepository();
        ProductManager productManager = new ProductManager(productRepository);

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);

        Product[] expectedProducts = {book3};
        Product[] actualProducts = productManager.searchBy("Chinov");

        assertArrayEquals(expectedProducts, actualProducts);
    }

    @Test
    public void shouldSearchProductsByEqualParts() {

        ProductRepository productRepository = new ProductRepository();
        ProductManager productManager = new ProductManager(productRepository);

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);

        Product[] expectedProducts = {book3, smartphone1};
        Product[] actualProducts = productManager.searchBy("Chine");

        assertArrayEquals(expectedProducts, actualProducts);
    }
}
