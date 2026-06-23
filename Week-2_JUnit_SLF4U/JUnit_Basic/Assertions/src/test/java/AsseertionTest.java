import org.junit.Test;

import static org.junit.Assert.*;
public class AsseertionTest {

    @Test
    public void testAssertions()
    {
        assertEquals(10,5 + 5);
        assertTrue(5 > 1);
        assertFalse(5 < 1);
        assertNull(null);
        assertNotNull(new Object());
    }

}
