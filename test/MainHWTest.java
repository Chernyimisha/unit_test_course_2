import DZ3.hw.MainHW;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class MainHWTest {

    MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 6, 12, 4})
    void evenOddNumberEvenTest(int n) {
        assertThat(mainHW.evenOddNumber(n)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 15, 21, 37})
    void evenOddNumberNotEvenTest(int n) {
        assertThat(mainHW.evenOddNumber(n)).isEqualTo(false);
    }
}
