import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void multiply() {
        Main calc = new Main();
        int result = calc.multiply(2,3);

        assertEquals(6,result);
    }
}