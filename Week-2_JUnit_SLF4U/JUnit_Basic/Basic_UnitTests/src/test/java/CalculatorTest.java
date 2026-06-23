import org.example.Calculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void add()
    {
        Calculator calculator = new Calculator();
        assertEquals(20, calculator.add(10,10));
    }

    @Test
    public void subtract() {
        Calculator calculator = new Calculator();
        assertEquals(-5, calculator.sub(5, 10));
    }

    @Test
    public void multiply()
    {
        Calculator calculator = new Calculator();
        assertEquals(100,calculator.mul(10,10));
    }

    @Test
    public void divide()
    {
        Calculator calculator = new Calculator();
        assertEquals(5,calculator.div(10,2));
    }

}
