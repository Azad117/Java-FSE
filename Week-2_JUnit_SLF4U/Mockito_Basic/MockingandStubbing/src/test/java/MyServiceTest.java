import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.example.ExternalApi;
import org.example.MyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {
    @Test
    public void testExternalApi()
    {
        ExternalApi externalApi = Mockito.mock(ExternalApi.class);

        when(externalApi.getData()).thenReturn("Hello World");

        MyService myService = new MyService(externalApi);

        assertEquals("Hello World", myService.fetchData());
    }

}
