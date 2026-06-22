public class Main 
{
    public static void main(String[] args)
    {
        Library lib = new Library();

        lib.displayBooks();
        System.out.println();

        lib.linearSearch("The Great Gatsby");
        System.out.println();

        lib.binarySearch("To Kill a Mockingbird");
        System.out.println();

        
    }    
}
