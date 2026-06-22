public class Main {
    public static void main(String[] args)
    {
        PaymentProcessor google = new GooglePayAdapter(new GooglePayGateway());

        PaymentProcessor phonePe = new PhonePeAdapter(new PhonePeGateway());

        google.processPayment(5000.0);
        phonePe.processPayment(7000.0);


    }
    
}
