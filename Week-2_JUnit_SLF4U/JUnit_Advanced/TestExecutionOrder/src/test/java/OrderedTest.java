import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {

    @Order(1)
    @Test
    public void test1()
    {
        System.out.println("Test A");
    }

    @Order(3)
    @Test
    public void test2()
    {
        System.out.println("Test B");
    }

    @Order(2)
    @Test
    public void test3()
    {
        System.out.println("Test C");
    }


}
