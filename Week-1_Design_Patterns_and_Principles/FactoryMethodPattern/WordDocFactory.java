
public class WordDocFactory extends DocumentFactory{
    
    @Override
    Document createDocument()
    {
        return new WordDocument();
    }
}
