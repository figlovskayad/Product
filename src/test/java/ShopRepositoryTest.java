import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void removeProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "футболка", 2_000);
        Product product2 = new Product(2, "кепка", 1_500);
        Product product3 = new Product(3, "джинсы", 3_500);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.remove(3);
        Product[] actual = repository.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void removeProductWhichNotExist() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "футболка", 2_000);
        Product product2 = new Product(2, "кепка", 1_500);
        Product product3 = new Product(3, "джинсы", 3_500);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> repository.remove(5));


    }
}
