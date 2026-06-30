import org.example.ExternalAPI;
import org.example.MyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.mockito.AdditionalMatchers.*;

public class MyServiceTest {

    @Test
    public void testArgumentMatcher()
    {
        ExternalAPI api = Mockito.mock(ExternalAPI.class);
        MyService service = new MyService(api);

        service.setArgument("Azad",22);

        verify(api).argumentMethod("Azad",22);
        verify(api).argumentMethod(eq("Azad"),anyInt());
        verify(api).argumentMethod(anyString(),anyInt());
        verify(api).argumentMethod(anyString(),gt(18));
    }

}
