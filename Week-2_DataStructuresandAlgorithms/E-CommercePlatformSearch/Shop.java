public class Shop {

    Product[] product = new Product[10];
    
    public void storeProducts() {
        product[0] = new Product(1, "Laptop", "Electronics");
        product[1] = new Product(2, "Smartphone", "Electronics");
        product[2] = new Product(3, "Tablet", "Electronics");
        product[3] = new Product(4, "Headphones", "Electronics");
        product[4] = new Product(5, "Smartwatch", "Electronics");
        product[5] = new Product(6, "Shoes", "Fashion");
        product[6] = new Product(7, "T-shirt", "Fashion");
        product[7] = new Product(8, "Jeans", "Fashion");
        product[8] = new Product(9, "Blender", "Home Appliances");
        product[9] = new Product(10, "Microwave", "Home Appliances");
    }

    public int linearSearch(int productId) {
        for (int i = 0; i < product.length; i++) {
            if (product[i].getProductId() == productId) {
                return i; // Return the index of the found product
            }
        }
        return -1; // Product not found
    }

    public int binarySearch(int productId)
    {
        int low = 0;
        int high = product.length - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(product[mid].getProductId() == productId)
            {
                return mid; // Product found
            }
            else if(product[mid].getProductId() > productId)
            {
                high = mid - 1; // Search in the left half
            }
            else
            {
                low = mid + 1; // Search in the right half
            }
        }
        return -1;
    }

    public void displayProduct(int productId)
    {
        if(productId == -1)
        {
            System.out.println("Product not found");
        }
        else
        {
            Product foundProduct = product[productId];
            System.out.println("Name : "+product[productId].getProductName()+" Category : "+product[productId].getCategory());
        }
    }

}
