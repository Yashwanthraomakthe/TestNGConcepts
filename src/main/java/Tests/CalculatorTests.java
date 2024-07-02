package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.tat.module4.Calculator;

public class CalculatorTests {
	public static Calculator calculator;

	@BeforeMethod(alwaysRun = true)
	public void beforeEachTest() {
		calculator = new Calculator();
		String threadName = Thread.currentThread().getName();
		System.out.println("Thread Name: " + threadName);

	}

	@Test(groups = "negative", enabled = true)
	public void addition_NegativeNumbers1() {

		int result = (int) calculator.mult(-25, -5);
		Assert.assertNotSame(result, 30);

	}

	@AfterMethod
	public void afterEachTest() {
		calculator = null;

	}

	@Test(groups = "positive", enabled = true)
	public void addition_NegativeNumbers() {

		int result = (int) calculator.sum(-5, -10);
		Assert.assertEquals(result, -15);

	}

	@Test(groups = "positive", enabled = true)
	public void addition_PositiveNumbers() {

		int result = (int) calculator.sum(5, 10);
		Assert.assertEquals(result, 15);

	}

	@Test(groups = "positive", enabled = true)
	public void addition_PositiveAndNegativeNumbers1() {

		int result = (int) calculator.sum(5, -10);
		Assert.assertEquals(result, -5);

	}

	@Test(groups = "positive", enabled = true)
	public void multiplication_NegativeNumbers() {

		int result = (int) calculator.mult(-5, -10);
		Assert.assertEquals(result, 50);

	}

	@DataProvider(name = "numbers")
	public Object[][] testData() {
		return new Object[][] { { 2, 3, 5 }, { 0, 0, 0 }, { -5, 5, 0 } };
	}

	@Test(dataProvider = "numbers", groups = "positive", enabled = true)
	public void addition(int num1, int num2, int expected) {

		int result = (int) calculator.sum(num1, num2);
		Assert.assertEquals(result, expected);

	}

	@Test(groups = "negative", enabled = true)
	public void testDivision_ByZero() {

		try {
			calculator.div(10, 0);
			Assert.fail("Expected ArithmeticException was not thrown");
		} catch (ArithmeticException e) {
			System.out.println(e);
		}

	}

	@Test(groups = "negative", enabled = true)
	public void multiplication_postiveNumbers() {

		int result = (int) calculator.mult(5, 5);
		Assert.assertNotSame(result, -25);

	}

	@Test(groups = "negative", enabled = true)
	public void division_FindingRemainder() {

		int result = (int) calculator.div(25, 5);
		Assert.assertNotSame(result, 0);

	}

	@Test(expectedExceptions = ArithmeticException.class, groups = "negative", enabled = true)
	public void testDivideByZero() {
		calculator.div(1, 0);
	}

	@Test(groups = "negative", enabled = true)
	public void multiplication_NegativeNumbers1() {

		int result = (int) calculator.mult(-5, -5);
		Assert.assertNotSame(result, -25);

	}

}