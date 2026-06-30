import org.example.ExternalAPI;
import org.example.MyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void VerifyInteractions()
    {
        ExternalAPI mockapi = Mockito.mock(ExternalAPI.class);
        MyService service = new MyService(mockapi);
        service.fetchData();
        verify(mockapi).getData();
    }

}
