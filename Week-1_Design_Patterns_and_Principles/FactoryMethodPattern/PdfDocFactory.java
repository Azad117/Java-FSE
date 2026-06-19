public class PdfDocFactory extends DocumentFactory
{
    @Override
    Document createDocument() 
    {
        return new PdfDocument();
    }
}