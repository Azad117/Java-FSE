public class ExcelDocFactory extends DocumentFactory
{
    @Override
    Document createDocument()
    {
        return new ExcelDocument();
    }
    
}
