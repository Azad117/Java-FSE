import org.example.Performance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class PerformanceTest {

    @Test
    public void testPerformance() {
        Performance p = new Performance();

        assertTimeout(Duration.ofSeconds(5),p::task);
    }
}
