package MathApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MathApplicationTester {

    // @InjectMocks annotation is used to create and inject the mock object.
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    // @Mock annotation is used to create the mock object to be injected.
    @Mock
    CalculatorService calcService;

    @Test
    public void testAdd() {
        // add the behavior of the calc service to add the two numbers.
        when(calcService.add(10.0, 20.0)).thenReturn(30.00);

        when(calcService.subtract(20.0, 10.0)).thenReturn(10.0);

        when(calcService.multiply(10.0, 20.0)).thenReturn(20.0);

        // test the add functionality.
        Assertions.assertEquals(mathApplication.add(10.0, 20.0), 30.0);
        Assertions.assertEquals(mathApplication.add(10.0, 20.0), 30.0);
        Assertions.assertEquals(mathApplication.add(10.0, 20.0), 30.0);

        Assertions.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0);

        Assertions.assertEquals(mathApplication.multiply(10.0, 20.0), 20.0);

        verify(calcService).subtract(20.0, 10.0);

        // verify the behavior
        verify(calcService, times(3)).add(10.0, 20.0);

        // verify that a method has never been called on a mock
        //verify(calcService, never()).multiply(10.0, 20.0);

        // check a minimum of 1 call count
        verify(calcService, atLeastOnce()).subtract(20.0, 10.0);

        // check if add function is called minimum 2 times
        verify(calcService, atLeast(2)).add(10.0, 20.0);

        // check if add function is called maximum 3 times
        verify(calcService, atMost(3)).add(10.0, 20.0);
    }

    @Test
    public void testAddException() {
        // add the behavior to throw exception
        doThrow(new RuntimeException("Add operation not implemented")).when(calcService).add(10.0, 20.0);

        // test the add functionality
        Assertions.assertEquals(mathApplication.add(10.0, 20.0), 30.0);
    }
}
