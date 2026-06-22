public class Main 
{
    public static void main(String[] args)
    {
        PaymentContext context = new PaymentContext(new CreditCardPayment());
        context.executePayment(100.0);

        context.setPaymentStratergy(new PayPalPayment());
        context.executePayment(200.0);
    }
}
