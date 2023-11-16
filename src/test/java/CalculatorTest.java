import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    void additionExpressionEvaluation() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2,6,'+')).isEqualTo(8);
    }
    @Test
    void subtractionExpressionEvaluation () {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2,2,'-')).isEqualTo(0);
    }
    @Test
    void multiplicationExpressionEvaluation () {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2,7,'*')).isEqualTo(14);
    }
    @Test
    void divisionExpressionEvaluation () {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(100,50,'/')).isEqualTo(2);
    }
    @Test
    void expectedIllegalStateExceptionOnInvalidOperatorSymbol ()
    {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() ->
                calculator.calculation(8,4,'_'))
                .isInstanceOf(IllegalStateException.class);
    }

}
