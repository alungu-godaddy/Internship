package MathApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class GivenTester {
    private static MathApplication mathApplication;
    private static CalculatorService calcService;

    @BeforeAll
    public static void setUp() {
        mathApplication = new MathApplication();
        calcService     = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
    }

    @Test
    @DisplayName("Behavior driven development")
    public void testAdd() {
        // Given
        given(calcService.add(20.0, 10.0)).willReturn(30.0);

        // when
        double result = calcService.add(20.0, 10.0);

        // then
        Assertions.assertEquals(result, 30.0);
    }
}
