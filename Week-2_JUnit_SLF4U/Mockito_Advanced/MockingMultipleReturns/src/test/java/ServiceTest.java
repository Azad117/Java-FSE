import static org.mockito.Mockito.*;

import org.example.Repository;
import org.example.Service;
import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;

public class ServiceTest {
    @Test
    public void testService()
    {
        Repository repo = mock(Repository.class);
        when(repo.getData())
                .thenReturn("First Mock")
                .thenReturn("Second Mock");

        Service service = new Service(repo);

        String first = service.processData();
        String second = service.processData();

        assertEquals("Processed First Mock", first);
        assertEquals("Processed Second Mock", second);
    }

}
