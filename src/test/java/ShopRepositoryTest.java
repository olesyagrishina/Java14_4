import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void Test1() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(11, "стул", 2_000);
        Product product2 = new Product(22, "стол", 20_000);
        Product product3 = new Product(33, "диван", 200_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(11);

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void Test2() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(11, "стул", 2_000);
        Product product2 = new Product(22, "стол", 20_000);
        Product product3 = new Product(33, "диван", 200_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(100));
    }
}
