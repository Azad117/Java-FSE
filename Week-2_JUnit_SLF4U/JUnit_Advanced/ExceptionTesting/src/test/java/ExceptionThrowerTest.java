import org.example.ExceptionThrower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {
    @Test
    public void testExceptionThrower() {
        ExceptionThrower e = new ExceptionThrower();

        RuntimeException r = assertThrows(RuntimeException.class, () -> {
            e.throwException(true);
        });

        assertEquals("Exception Thrown", r.getMessage());
    }

    @Test
    public void testNoException() {
        ExceptionThrower e = new ExceptionThrower();

        assertDoesNotThrow(() -> e.throwException(false));
    }
}
