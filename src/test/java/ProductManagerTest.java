import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.mainclasses.Book;
import ru.netology.mainclasses.Product;
import ru.netology.mainclasses.Smartphone;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {

    @Test
    public void testAddProducts() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(111, "Geborgtes Leben", 1500, "Erich Maria Remarque");
        Book book2 = new Book(222, "Thorn Birds", 1000, "Colleen McCullough");
        Book book3 = new Book(333, "The Master and Margarita", 2000, "Mikhail Bulgakov");

        Smartphone smartphone1 = new Smartphone(01, "14 pro Max", 100_000, "Apple");
        Smartphone smartphone2 = new Smartphone(02, "Galaxy S23 Plus", 120_000, "Samsung");
        Smartphone smartphone3 = new Smartphone(03, "Galaxy S23 Ultra", 130_000, "Samsung");


        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByWhenTwoProductsFit() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(111, "Geborgtes Leben", 1500, "Erich Maria Remarque");
        Book book2 = new Book(222, "Thorn Birds", 1000, "Colleen McCullough");
        Book book3 = new Book(333, "The Master and Margarita", 2000, "Mikhail Bulgakov");

        Smartphone smartphone1 = new Smartphone(01, "14 pro Max", 100_000, "Apple");
        Smartphone smartphone2 = new Smartphone(02, "Galaxy S23 Plus", 120_000, "Samsung");
        Smartphone smartphone3 = new Smartphone(03, "Galaxy S23 Ultra", 130_000, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {smartphone2, smartphone3};
        Product[] actual = manager.searchBy("Galaxy");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByWhenOneProductsFit() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(111, "Geborgtes Leben", 1500, "Erich Maria Remarque");
        Book book2 = new Book(222, "Thorn Birds", 1000, "Colleen McCullough");
        Book book3 = new Book(333, "The Master and Margarita", 2000, "Mikhail Bulgakov");

        Smartphone smartphone1 = new Smartphone(01, "14 pro Max", 100_000, "Apple");
        Smartphone smartphone2 = new Smartphone(02, "Galaxy S23 Plus", 120_000, "Samsung");
        Smartphone smartphone3 = new Smartphone(03, "Galaxy S23 Ultra", 130_000, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Birds");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByWhenNoMatches() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(111, "Geborgtes Leben", 1500, "Erich Maria Remarque");
        Book book2 = new Book(222, "Thorn Birds", 1000, "Colleen McCullough");
        Book book3 = new Book(333, "The Master and Margarita", 2000, "Mikhail Bulgakov");

        Smartphone smartphone1 = new Smartphone(01, "14 pro Max", 100_000, "Apple");
        Smartphone smartphone2 = new Smartphone(02, "Galaxy S23 Plus", 120_000, "Samsung");
        Smartphone smartphone3 = new Smartphone(03, "Galaxy S23 Ultra", 130_000, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Anton Chehov");

        Assertions.assertArrayEquals(expected, actual);
    }
}
