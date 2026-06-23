import org.example.EvenChecker;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {

    EvenChecker evenChecker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 16,20,1000,0})
    public void evenCheckTest(int n)
    {
        assertTrue(evenChecker.checkEven(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,9,15,17,59,-1})
    public void isOdd(int n)
    {
        assertFalse(evenChecker.checkEven(n));
    }


}
