public class Library
{
    Book[] books = {
        new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
        new Book(2, "To Kill a Mockingbird", "Harper Lee"),
        new Book(3, "1984", "George Orwell"),
        new Book(4, "Pride and Prejudice", "Jane Austen"),
        new Book(5, "The Catcher in the Rye", "J.D. Salinger"),
    };

    public void displayBooks()
    {
        System.out.println("ID | Title - Author");
        for (Book book : books)
        {
            System.out.println(book);
        }
    }

    public void linearSearch(String title)
    {
        for(Book book : books)
        {
            if(book.getTitle().equalsIgnoreCase(title))
            {
                System.out.println("Book found: " + book);
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }

    public void binarySearch(String title)
    {
        int left = 0;
        int right = books.length - 1;

        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(books[mid].getTitle().equalsIgnoreCase(title))
            {
                System.out.println("Book found: " + books[mid]);
                return;
            }
            else if(books[mid].getTitle().compareToIgnoreCase(title) < 0)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        System.out.println("Book not found: " + title);
    }
}
