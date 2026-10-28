import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddStrategyTest {

    @Test
    void addStrategyReturnsCorrectResult() {
        OperationStrategy strategy = new AddStrategy();

        double result = strategy.execute(10, 5);

        assertEquals(15.0, result);
    }
}
