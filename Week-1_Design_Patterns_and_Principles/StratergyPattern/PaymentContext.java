public class PaymentContext 
{
    private PaymentStratergy paymentStratergy;

    public PaymentContext(PaymentStratergy paymentStratergy)
    {
        this.paymentStratergy = paymentStratergy;
    }

    public void setPaymentStratergy(PaymentStratergy paymentStratergy)
    {
        this.paymentStratergy = paymentStratergy;
    }

    public void executePayment(double amount)
    {
        paymentStratergy.pay(amount);
    }
}
