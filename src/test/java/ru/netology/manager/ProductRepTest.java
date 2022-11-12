package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepTest {

    Product product1 = new Book(101, "Harry Potter Collection", 1234, "JK Rowling");
    Product product2 = new Book(112, "Modern Dictionary", 2345, "Oxford Publishing");
    Product product3 = new Book(123, "JAVA for Dummies", 1890, "Barry Burd");
    Product product4 = new Smartphone(501, "Samsung", 70000, "Samsung Inc.");
    Product product5 = new Smartphone(512, "Iphone 13", 130000, "Apple");
    Product product6 = new Smartphone(523, "AndroidPhone", 1000, "Android Inc.");

    private ProductRep repo = new ProductRep();
    @Test
    public void shouldSaveOneItem() {
        repo.save(product4);
        Product[] expected = {product4};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

}