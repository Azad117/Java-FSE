public class PhonePeAdapter implements PaymentProcessor 
{
    private PhonePeGateway phonepeGateway;

    public PhonePeAdapter(PhonePeGateway phonepeGateway)
    {
        this.phonepeGateway = phonepeGateway;
    }

    @Override
    public void processPayment(double amount)
    {
        phonepeGateway.sendPayment(amount);
    }
}
