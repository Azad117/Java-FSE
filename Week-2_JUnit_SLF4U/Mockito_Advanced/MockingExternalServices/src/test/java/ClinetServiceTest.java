import static org.mockito.Mockito.*;

import org.example.ClientService;
import org.example.RestClient;
import org.junit.jupiter.api.Test;

import java.security.Provider;

import static org.junit.jupiter.api.Assertions.*;


public class ClinetServiceTest {

    @Test
    public void testProcessData()
    {
        RestClient restClient = mock(RestClient.class);

        when(restClient.getResponse())
        .thenReturn("Mock Data");

        ClientService service = new ClientService(restClient);

        String result = service.processData();
        assertEquals("Mock Data", result);

    }
}
