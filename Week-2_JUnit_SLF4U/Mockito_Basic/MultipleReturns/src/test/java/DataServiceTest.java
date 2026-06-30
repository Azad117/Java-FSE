import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.DataService;
import org.example.ExternalAPI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test.*;
import org.mockito.Mockito;

public class DataServiceTest {

    @Test
    public void testDataService() {
        ExternalAPI spi = Mockito.mock(ExternalAPI.class);

        when(spi.getData())
                .thenReturn("First Data")
                .thenReturn("Second Data")
                .thenReturn("Third Data");

        DataService dataService = new DataService(spi);

        assertEquals("First Data", dataService.fetchData());
        assertEquals("Second Data", dataService.fetchData());
        assertEquals("Third Data", dataService.fetchData());
    }
}
