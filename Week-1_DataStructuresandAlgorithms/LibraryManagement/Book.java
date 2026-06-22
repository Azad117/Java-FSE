public class Book 
{
    private int Id;
    private String title;
    private String author;

    public Book(int Id, String title, String author)
    {
        this.Id = Id;
        this.title = title;
        this.author = author;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    @Override
    public String toString()
    {
        return String.format("%d | %s - %s", Id, title, author);
    }
}
