package MathApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TimeoutTester {
    private static MathApplication mathApplication;
    private static CalculatorService calcService;

    @BeforeAll
    public static void setUp() {
        mathApplication = new MathApplication();
        calcService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
    }

    @Test
    @DisplayName("Test with timeouts")
    public void testAddAndSubtract() {
        given(calcService.add(20.0, 10.0)).willReturn(30.0);

        given(calcService.subtract(20.0, 10.0)).willReturn(10.0);

        double addResult = calcService.add(20.0, 10.0);

        double subResult = calcService.subtract(20.0, 10.0);

        Assertions.assertEquals(addResult, 30.0);

        Assertions.assertEquals(subResult, 10.0);

        // Verify call to add method is up to 100 ms.
        verify(calcService, timeout(100)).add(20.0, 10.0);

        verify(calcService, timeout(100).times(1)).subtract(20.0, 10.0);
    }
}
