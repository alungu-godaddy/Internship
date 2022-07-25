package MathApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class anotherAppTester {
    private static MathApplication mathApplication;
    private static CalculatorService calcService;

    @BeforeAll
    public static void setUp() {
        mathApplication = new MathApplication();
        calcService     = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
    }

    @Test
    public void testAddAndSubtract() {
        // add the behavior to add number.
        when(calcService.add(20.0, 10.0)).thenReturn(30.0);

        // subtract the behavior to subtract numbers
        when(calcService.subtract(20.0, 10.0)).thenReturn(10.0);

        // test the subtract functionality
        Assertions.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0);

        // test the addition functionality
        Assertions.assertEquals(mathApplication.add(20.0, 10.0), 30.0);

        // verify call to calcService is made or not
        verify(calcService).add(20.0, 10.0);
        verify(calcService).subtract(20.0, 10.0);

        // Create an inorder verifier for a single mock.
        InOrder inOrder = inOrder(calcService);

        inOrder.verify(calcService).subtract(20.0, 10.0);
        inOrder.verify(calcService).add(20.0, 10.0);
    }
}
