package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final ProductRepository repository = new ProductRepository();
    private final ProductManager manager = new ProductManager(repository);
    private final Book firstBook = new Book(1, "Book 1", 500, "Pelevin");
    private final Book secondBook = new Book(2, "Book 2", 460, "Lermontov");
    private final Book thirdBook = new Book(3, "Book 3", 720, "Bronte");
    private final Smartphone firstSmart = new Smartphone(4, "Galaxy", 19999, "Samsung");
    private final Smartphone secondSmart = new Smartphone(5, "Galaxy", 19999, "Xiaomi");
    private final Smartphone thirdSmart = new Smartphone(6, "iPhone 12", 59999, "Apple");
    private final Smartphone fourthSmart = new Smartphone(7, "iPhone 13", 69999, "Apple");

    @BeforeEach
    void add() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(firstSmart);
        manager.add(secondSmart);
        manager.add(thirdSmart);
        manager.add(fourthSmart);
    }

    @Test
    void shouldDeleteFoundProduct(){
        manager.removeById(1);
    }

    @Test
    void shouldNotDeleteNotFoundProduct() {
        assertThrows(NotFoundException.class, () -> {
            manager.removeById(-1);
        });
    }
}