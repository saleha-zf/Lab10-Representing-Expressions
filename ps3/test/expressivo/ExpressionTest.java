
package expressivo;
import static org.junit.Assert.*;
import org.junit.Test;
public class ExpressionTest {
   // Test cases for parse()
   @Test
   public void testParseNumber() {
       // Tests parsing valid number expressions.
       assertEquals(new Number(42), Expression.parse("42"));
       assertEquals(new Number(3.14), Expression.parse("3.14"));
   }
   @Test
   public void testParseVariable() {
       // Tests parsing valid variable expressions.
       assertEquals(new Variable("x"), Expression.parse("x"));
       assertEquals(new Variable("abc"), Expression.parse("abc"));
   }
   @Test
   public void testParseAddition() {
       // Tests parsing valid addition expressions.
       assertEquals(new Add(new Variable("x"), new Number(5)), Expression.parse("x + 5"));
       assertEquals(new Add(new Number(3), new Variable("y")), Expression.parse("3 + y"));
   }
   @Test
   public void testParseMultiplication() {
       // Tests parsing valid multiplication expressions.
       assertEquals(new Multiply(new Variable("x"), new Number(5)), Expression.parse("x * 5"));
       assertEquals(new Multiply(new Number(2.5), new Number(4.5)), Expression.parse("2.5 * 4.5"));
   }
   @Test(expected = IllegalArgumentException.class)
   public void testParseInvalidExpressionNumber() {
       // Tests invalid number format.
       Expression.parse("3.14.15");
   }
   @Test(expected = IllegalArgumentException.class)
   public void testParseInvalidExpressionOperator() {
       // Tests invalid operator (unsupported operator `-`).
       Expression.parse("x - 5");
   }
   // Test cases for toString()
   @Test
   public void testToStringNumber() {
       // Tests string representation of a number.
       assertEquals("42.0", new Number(42).toString());
   }
   @Test
   public void testToStringAddition() {
       // Tests string representation of an addition expression.
       Expression addExpr = new Add(new Variable("x"), new Number(5));
       assertEquals("(x + 5.0)", addExpr.toString());
   }
   @Test
   public void testToStringMultiplication() {
       // Tests string representation of a multiplication expression.
       Expression multExpr = new Multiply(new Number(3), new Variable("y"));
       assertEquals("(3.0 * y)", multExpr.toString());
   }
   // Test cases for equals()
   @Test
   public void testEqualsNumber() {
       // Tests equality of number expressions.
       assertEquals(new Number(42), new Number(42));
       assertNotEquals(new Number(42), new Number(43));
   }
   @Test
   public void testEqualsAddition() {
       // Tests equality of addition expressions.
       assertEquals(new Add(new Variable("x"), new Number(5)), new Add(new Variable("x"), new Number(5)));
       assertNotEquals(new Add(new Variable("x"), new Number(5)), new Add(new Variable("y"), new Number(5)));
   }
   @Test
   public void testEqualsMultiplication() {
       // Tests equality of multiplication expressions.
       assertEquals(new Multiply(new Number(3), new Variable("y")), new Multiply(new Number(3), new Variable("y")));
       assertNotEquals(new Multiply(new Number(3), new Variable("y")), new Multiply(new Variable("x"), new Variable("y")));
   }
   // Test cases for hashCode()
   @Test
   public void testHashCodeNumber() {
       assertEquals(new Number(42).hashCode(), new Number(42).hashCode());
   }
   @Test
   public void testHashCodeAddition() {
       // Tests hash code consistency for addition expressions.
       Expression addExpr1 = new Add(new Variable("x"), new Number(5));
       Expression addExpr2 = new Add(new Variable("x"), new Number(5));
       assertEquals(addExpr1.hashCode(), addExpr2.hashCode());
   }
   @Test
   public void testHashCodeMultiplication() {
       // Tests hash code consistency for multiplication expressions.
       Expression multExpr1 = new Multiply(new Number(3), new Variable("y"));
       Expression multExpr2 = new Multiply(new Number(3), new Variable("y"));
       assertEquals(multExpr1.hashCode(), multExpr2.hashCode());
   }
}


