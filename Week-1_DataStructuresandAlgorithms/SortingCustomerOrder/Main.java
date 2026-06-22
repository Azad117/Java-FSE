public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Order[] orders = cart.getOrders();

        cart.addOrder(orders);
        cart.displayOrders(orders);

        System.out.print("Quick Sort: ");
        cart.quickSort(orders, 0, orders.length - 1);
        cart.displayOrders(orders);

        System.out.print("Bubble Sort: ");
        cart.bubbleSort(orders);
        cart.displayOrders(orders);


    }
}
