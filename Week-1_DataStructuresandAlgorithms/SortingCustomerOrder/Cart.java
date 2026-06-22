public class Cart 
{
    private Order[] order = new Order[10];
    
    public void addOrder(Order[] order)
    {
        order[0] = new Order(1, "John", 4783);
        order[1] = new Order(2, "Alice", 2398);
        order[2] = new Order(3, "Bob", 1298);
        order[3] = new Order(4, "Eve", 3498);
        order[4] = new Order(5, "Charlie", 1987);
        order[5] = new Order(6, "David", 2873);
        order[6] = new Order(7, "Grace", 1567);
        order[7] = new Order(8, "Frank", 4321);
        order[8] = new Order(9, "Hannah", 2765);
        order[9] = new Order(10, "Ivy", 1987);
    }

    public Order[] getOrders(){
        return order;
    }

    public void displayOrders(Order[] orders)
    {
        for (Order order : orders)
        {
            System.out.println("Order ID: " + order.getOrderId() + ", Customer Name: " + order.getCustomerName() + ", Total Price: " + order.getTotalPrice());
        }
    }

    public void bubbleSort(Order[] orders)
    {
        int n = orders.length;
        for(int i = 0;i < n - 1;i++)
        {
            for(int j = 0;j < n - 1;j++)
            {
                if(orders[j].getTotalPrice() > orders[j + 1].getTotalPrice())
                {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public void quickSort(Order[] orders, int low, int high)
    {
        if(low < high)
        {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    public int partition(Order[] orders, int low, int high)
    {
        int pivot = orders[high].getTotalPrice();
        int i = low - 1;
        for(int j = low;j < high;j++)
        {
            if(orders[j].getTotalPrice() < pivot)
            {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
    
}
