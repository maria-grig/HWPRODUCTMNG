package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductMngTest {

    Product product1 = new Book(101, "Harry Potter Collection", 1234, "JK Rowling");
    Product product2 = new Book(112, "Modern Dictionary", 2345, "Oxford Publishing");
    Product product3 = new Book(123, "JAVA for Dummies", 1890, "Barry Burd");
    Product product4 = new Smartphone(501, "AndroidPhone", 70000, "Samsung Inc.");
    Product product5 = new Smartphone(512, "IPhone13", 130000, "Apple");
    Product product6 = new Smartphone(523, "AndroidPhone", 1000, "Honor Inc.");

    private ProductRep repo = new ProductRep();
    public ProductMng manager = new ProductMng(repo);

    @Test
    void shouldAddOneItem() {
        manager.add(product3);
        Product[] expected = {product3};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldAddAll() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBy() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        String name = "Dummies";
        Product[] expected = {product3};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchWhenSeveralProductsFit() {
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        String name = "AndroidPhone";
        Product[] expected = {product4, product6};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchWhenNoProductFit() {
        manager.add(product1);
        manager.add(product3);
        manager.add(product5);
        String name = "Galaxy";
        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }
}