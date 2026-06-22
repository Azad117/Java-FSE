public class GooglePayAdapter implements PaymentProcessor 
{
    private GooglePayGateway googlePayGateway;

    public GooglePayAdapter(GooglePayGateway googlePayGateway) {
        this.googlePayGateway = googlePayGateway;
    }

    @Override
    public void processPayment(double amount) {
        googlePayGateway.sendPayment(amount);
    }
}
