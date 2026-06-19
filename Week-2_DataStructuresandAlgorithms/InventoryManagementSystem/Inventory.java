import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product)
    {
        products.add(product);
        System.out.println("Product added successfully");   
    }

    public void removeProduct(int productId)
    {
        for(Product product : products)
        {
            if(product.getProductId() == productId)
            {
                products.remove(product);
                System.out.println("Product removed successfully");
                return;
            }
        }
        System.out.println("Product not found in inventory");
    }

    public void updateProduct(Product updatedProduct)
    {
        for(Product prod : products)
        {
            if(prod.getProductId() == updatedProduct.getProductId())
            {
                prod.setProductName(updatedProduct.getProductName());
                prod.setQuantity(updatedProduct.getQuantity());
                prod.setPrice(updatedProduct.getPrice());
                System.out.println("Product updated successfully");
                return;
            }
        }
        System.out.println("Product not found in inventory");
    }



    public void displayProducts()
    {
        System.out.println("Products in inventory:");
        for(Product product : products)
        {
            System.out.println(product);
        }
    }


    
}
