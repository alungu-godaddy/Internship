package MathApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CallbackTester {
    private static MathApplication mathApplication;
    private static CalculatorService calcService;

    @BeforeAll
    public static void setUp() {
        mathApplication = new MathApplication();
        calcService     = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
    }

    @Test
    @DisplayName("Testing the mockito callback")
    public void TestAdd() {
        // add the behavior using generic Answer
        when(calcService.add(20.0, 10.0)).thenAnswer((Answer<Double>) invocation -> {
            // get the arguments passed to mock
            Object[] args = invocation.getArguments();

            // get the mock
            Object mock   = invocation.getMock();

            return 30.0;
        });

        // test the add functionality
        Assertions.assertEquals(mathApplication.add(20.0, 10.0), 30.0);
    }
}
