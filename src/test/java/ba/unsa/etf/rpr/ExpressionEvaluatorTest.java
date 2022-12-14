package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionEvaluatorTest
{
    /**
     * Test 1. testing basic expressions
     */
    @Test
    void Test1() {
        assertEquals(100, ExpressionEvaluator.evaluate("( 75 + 25 )"));
    }

    /**
     * Test 2. testing basic expressions
     */
    @Test
    void Test2() {
        assertEquals(32, ExpressionEvaluator.evaluate("( 40 - 8 )"));
    }
    /**
     * Test 3. testing basic expressions
     */
    @Test
    void Test3() {
        assertEquals(63, ExpressionEvaluator.evaluate("( 7 * 9 )"));
    }
    /**
     * Test 4. testing basic expression
     */
    @Test
    void Test4() {
        assertEquals(10, ExpressionEvaluator.evaluate("( 100 / 10 )"));
    }
    /**
     * Test 5. testing basic expressions
     */
    @Test
    void Test5() {
        assertEquals(13, ExpressionEvaluator.evaluate("( 1 + sqrt ( 144 ) ) "));
    }
    /**
     * Test 6. incorrectly formatted expression
     * @throws RuntimeException throws exception
     */
    @Test
    void Test6() throws RuntimeException {
        Assertions.assertThrows(RuntimeException.class, ()->{
            ExpressionEvaluator.evaluate("( 123 +  + 212 )");
        });
    }
    /**
     * Test 7. incorrectly formatted expression
     * @throws RuntimeException throws exception
     */
    @Test
    void Test7() throws RuntimeException{
        Assertions.assertThrows(RuntimeException.class, ()->{
            ExpressionEvaluator.evaluate("(1 + 1 + 1 + 1 + 1 )");
        });
    }
    /**
     * Test 8. incorrectly formatted expression
     * @throws RuntimeException throws exception
     */
    @Test
    void Test8() throws RuntimeException{
        Assertions.assertThrows(RuntimeException.class, ()->{
            ExpressionEvaluator.evaluate(" 34 * 2 )");
        });
    }
    /**
     * Test 9. testing complex expression
     */
    @Test
    void Test9() {
        assertEquals(16, ExpressionEvaluator.evaluate("( ( 2 * sqrt ( 144 ) ) - ( 16 / 2 ) )"));
    }
    /**
     * Test 10. testing dividing by zero.
     * @throws RuntimeException throws exception
     */
    @Test
    void Test10() throws RuntimeException{
        Assertions.assertThrows(RuntimeException.class, ()->{
            ExpressionEvaluator.evaluate("( 1 / 0 )");
        });
    }
}
