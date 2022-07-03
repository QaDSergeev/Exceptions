package ru.netology.product.repository;

import org.junit.jupiter.api.Test;

import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.product.exception.AlreadyExistsException;
import ru.netology.product.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTests {

    Book book1 = new Book(1, "history", 3000, "Petya Petrov");
    Book book2 = new Book(2, "english language", 4000, "Ivan Ivanov");
    Smartphone smartphone1 = new Smartphone(3, "Iphone 7", 100000, "Chine");
    Smartphone smartphone2 = new Smartphone(4, "Highscreen", 105000, "South Korea");

    @Test
    public void shouldGetAllProducts() {

        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone1);
        repository.add(smartphone2);

        Product[] expectedProducts = {book1, book2, smartphone1, smartphone2};
        Product[] actualProducts = repository.getAllProducts();

        assertArrayEquals(expectedProducts, actualProducts);
    }

    @Test
    public void shouldThrowAlreadyExistsOnTryAddProductWithAlreadyId() {

        Book book3 = new Book(2, "All ready exist book", 2000, "Unknown");

        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone1);

        boolean isExceptionThrow = false;

        try {

            repository.add(book3);

        } catch (AlreadyExistsException exception) {

            exception.printStackTrace();
            isExceptionThrow = true;
        }

        assertTrue(isExceptionThrow);
    }

    @Test
    public void shouldRemoveLastProductById() {

        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone1);
        repository.add(smartphone2);

        repository.removeProduct(smartphone2.getId());

        Product[] expectedProducts = {book1, book2, smartphone1};
        Product[] actualProducts = repository.getAllProducts();

        assertArrayEquals(expectedProducts, actualProducts);
    }

    @Test
    public void shouldRemoveFirstProductById() {

        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone1);
        repository.add(smartphone2);

        repository.removeProduct(book1.getId());

        Product[] expectedProducts = {book2, smartphone1, smartphone2};
        Product[] actualProducts = repository.getAllProducts();

        assertArrayEquals(expectedProducts, actualProducts);
    }

    @Test
    public void shouldRemoveMiddleProductById() {

        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone1);
        repository.add(smartphone2);

        repository.removeProduct(smartphone1.getId());

        Product[] expectedProducts = {book1, book2, smartphone2};
        Product[] actualProducts = repository.getAllProducts();

        assertArrayEquals(expectedProducts, actualProducts);
    }

    @Test
    public void shouldThrowNotFoundException() {

        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(book2);
        repository.add(smartphone1);
        repository.add(smartphone2);

        boolean isThrowException = false;

        try {

            repository.removeProduct(6);

        } catch (NotFoundException notFoundException) {

            notFoundException.printStackTrace();
            isThrowException = true;
        }

        assertTrue(isThrowException);
    }
}
