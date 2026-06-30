import org.example.MyService;
import org.example.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;


public class MyServiceTest {

    @Test
    public void paymentProcessTest()
    {
        PaymentService paymentService = mock(PaymentService.class);

        MyService myService = new MyService(paymentService);

        myService.runProcess();

        InOrder order = inOrder(paymentService);

        order.verify(paymentService).login();

        order.verify(paymentService).paymentProcess();
        order.verify(paymentService).logout();
    }
}
