package MathApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.reset;

@ExtendWith(MockitoExtension.class)
public class ResetTester {
    private static MathApplication mathApplication;
    private static CalculatorService calcService;

    @BeforeAll
    public static void setUp() {
        mathApplication = new MathApplication();
        calcService     = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
    }


    @Test
    @DisplayName("Testing asserting after reset")
    public void testAdd() {
        when(calcService.add(20.0, 10.0)).thenReturn(30.0);

        Assertions.assertEquals(mathApplication.add(20.0, 10.0), 30.0);

        // reset the mock and assert again
        reset(calcService);

        Assertions.assertEquals(mathApplication.add(20.0, 10.0), 30.0);
    }

}
