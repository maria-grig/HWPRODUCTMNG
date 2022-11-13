package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepTest {

    Product product1 = new Book(101, "Harry Potter Collection", 1234, "JK Rowling");
    Product product2 = new Book(112, "Modern Dictionary", 2345, "Oxford Publishing");
    Product product3 = new Book(123, "JAVA for Dummies", 1890, "Barry Burd");
    Product product4 = new Smartphone(501, "Samsung", 70000, "Android Inc.");
    Product product5 = new Smartphone(512, "IPhone13", 130000, "Apple");
    Product product6 = new Smartphone(523, "AndroidPhone", 1000, "Android Inc.");

    private ProductRep repo = new ProductRep();

    @Test
    public void shouldRemoveById() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
        repo.removeById(512);
        Product[] expected = {product1, product2, product3, product4, product6};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundException() {
        repo.save(product5);
        repo.save(product1);
        repo.save(product3);
        repo.save(product2);
        repo.save(product6);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(678);
        });


    }
}