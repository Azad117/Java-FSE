public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        inventory.addProduct(new Product(1,"Laptop", 10, 999));
        inventory.addProduct(new Product(2,"Smartphone", 20, 599));
        inventory.addProduct(new Product(3,"Tablet", 15, 299));
        inventory.addProduct(new Product(4,"Headphones", 30, 199));
        inventory.addProduct(new Product(5,"Smartwatch", 25, 199));

        inventory.displayProducts();
        System.out.println();

        inventory.updateProduct(new Product(2,"Smartphone", 18, 549));
        inventory.displayProducts();
        System.out.println();

        inventory.removeProduct(3);
        inventory.displayProducts();



    
    }
}
