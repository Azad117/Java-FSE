public class Main {

    public static void main(String[] args) {
        
        Shop shop = new Shop();
        long start, end;
        int productId;

        shop.storeProducts();


        System.out.println("Linear Search");
        start = System.nanoTime();
        productId = shop.linearSearch(7);
        end = System.nanoTime();
        shop.displayProduct(productId);
        System.out.println("Time Taken : " + (end - start) + " nanoseconds");
        // Search for a product by ID

        System.out.println("\nBinary Search");
        start = System.nanoTime();
        productId = shop.binarySearch(7);
        end = System.nanoTime();
        shop.displayProduct(productId);
        System.out.println("Time Taken : " + (end - start) + " nanoseconds");
    }
    
}
