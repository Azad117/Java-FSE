public class PayPalPayment implements PaymentStratergy 
{
    @Override
    public void pay(double amount)
    {
        System.out.println("Paid " + amount + " Using PayPal");
    }
    
}
