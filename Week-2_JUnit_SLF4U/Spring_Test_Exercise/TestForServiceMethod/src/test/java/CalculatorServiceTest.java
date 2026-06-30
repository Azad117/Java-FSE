import static org.junit.jupiter.api.Assertions.*;

import org.example.CalculatorService;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    @Test
    void add()
    {
        CalculatorService calculatorService = new CalculatorService();
        assertEquals(30,calculatorService.add(10, 20));
    }
}
