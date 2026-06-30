import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.NetworkClient;
import org.example.NetworkService;
import org.junit.jupiter.api.Test;

public class NetworkServiceTest {
    @Test
    public void testConnect() {
        NetworkClient networkClient = mock(NetworkClient.class);

        when(networkClient.connect())
                .thenReturn("Mock Connection");

        NetworkService  networkService = new NetworkService(networkClient);
        assertEquals("Connected to Mock Connection",networkService.connectToServer());
    }
}
