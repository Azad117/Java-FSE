public class Main 
{
    public static void main(String[] args) 
    {
        DocumentFactory wordFactory = new WordDocFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.read();

        DocumentFactory excelFactory = new ExcelDocFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.read();

        DocumentFactory pdfFactory = new PdfDocFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.read();
        
    }
}
