package com.junitchk;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArithmeticTest {

	private Arithmetic arithmetic = new Arithmetic();

	@BeforeAll
	static void befallmet() {
		System.out.println("Before All method");
	}

	@BeforeEach
	void befeachmet() {
		arithmetic = new Arithmetic();
		System.out.println("Before Each method");
	}

	@Test
	@Order(1)
	@Tag("feature1")
	void testMet() {
		Arithmetic arith = new Arithmetic();
		System.out.println("Test 1");
		int actualVal = arith.add(-8, -5);
		assertEquals(-13, actualVal, "Addition should work for negative values also");
	}

	@Disabled
	@Order(2)
	@Tag("feature1")
	void testAdd() {
		System.out.println("Test 2");
		assertEquals(5, arithmetic.add(2, 3), "Addition should return the sum of two numbers");
	}

	@Test
	@Order(3)
	@Tag("feature2")
	void testSubtract() {
		System.out.println("Test 3");
		assertEquals(1, arithmetic.subtract(5, 4), "Subtraction should return the difference of two numbers");
	}

	@Test
	@Order(4)
	@Tag("feature1")
	void testMultiply() {
		System.out.println("Test 4");
		assertEquals(6, arithmetic.multiply(2, 3), "Multiplication should return the product of two numbers");
	}

	@Test
	@Order(5)
	@Tag("feature1")
	void testDivide() {
		System.out.println("Test 5");
		assertEquals(2, arithmetic.divide(6, 3), "Division should return the quotient of two numbers");
	}

	@Test
	@Order(6)
	@Tag("feature2")
	void testDivideByZero() {
		System.out.println("Test 6");
		ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> arithmetic.divide(1, 0),
				"Division by zero should throw ArithmeticException");
		assertEquals("Cannot divide by zero", thrown.getMessage());
	}

	@Test
	@Order(7)
	@Tag("feature1")
	void testReverse() {
		int arr[] = { 11, 22, 33, 44, 55 };
		int[] actualArr = arithmetic.reverse(arr);
		int[] expectedArr = { 55, 44, 33, 22, 11 };
		assertArrayEquals(expectedArr, actualArr, "Comparing reversed array");
		System.out.println("Test 7");
	}

	// Assignment test case
	@Test
	@Order(8)
	@Tag("feature1")
	void testMaxDouble() {
		System.out.println("Test 8");
		assertEquals(3.2, arithmetic.maxDouble(2.0, 3.2), "Max double should return the maximum of two numbers");
		System.out.println("Positive test case passed");
		assertFalse(2.0 == arithmetic.maxDouble(2.0, 3.2), "Max double should return the maximum of two numbers");
		System.out.println("Negative test case Passed");

	}

	@AfterEach
	void metAfter() {
		arithmetic = null;
		System.out.println("AfterEach");
	}

	@AfterAll
	static void metAfterAll() {
		System.out.println("AfterAll");
	}

}
