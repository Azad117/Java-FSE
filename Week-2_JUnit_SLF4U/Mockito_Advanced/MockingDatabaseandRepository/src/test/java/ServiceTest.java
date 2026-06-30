import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Repository;
import org.example.Service;
import org.junit.jupiter.api.Test;

public class ServiceTest {

    @Test
    public void testRepository() {
        Repository repo = mock(Repository.class);

        when(repo.getData())
        .thenReturn("Mock Data");

        Service service = new Service(repo);

        String result = service.processData();

        assertEquals("Processed Mock Data", result);
    }
}
