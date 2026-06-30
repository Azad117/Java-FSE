import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.FileReader;
import org.example.FileService;
import org.example.FileWriter;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FileServiceTest {
    @Test
    public void testFileService()
    {
        FileReader fileReader = mock(FileReader.class);
        FileWriter fileWriter = mock(FileWriter.class);

        when(fileReader.read())
                .thenReturn("Mock File");

        FileService fileService = new FileService(fileReader, fileWriter);

        String result = fileService.processFile();
        assertEquals("Processed Mock File", result);
    }
}
