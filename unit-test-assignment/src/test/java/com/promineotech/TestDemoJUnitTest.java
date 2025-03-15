package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	public TestDemo testDemo;
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
	if(!expectException) {
	assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
	}else {
	assertThatThrownBy(() -> testDemo.addPositive(a, b))
	.isInstanceOf(IllegalArgumentException.class);
	}
}
	public static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
        		Arguments.of(2, 3, 5, false),
        		Arguments.of(-1, 3, 0, true),
        		Arguments.of(0, 0, 0, true),
        		Arguments.of(2, -3, 0, true)
        );
    }
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
	assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
	assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	assertThat(testDemo.addPositive(1, 1)).isEqualTo(2);
	assertThat(testDemo.addPositive(10, 20)).isEqualTo(30);
	assertThat(testDemo.addPositive(100, 200)).isEqualTo(300);
	assertThat(testDemo.addPositive(9, 6)).isEqualTo(15);
	}
	/*
	 * Test the max method in TestDemo.
	 */
	@Test
	void assertThatMaxIsCorrect() {
		//test with equal numbers
		assertThat(testDemo.max(5, 5)).isEqualTo(5);
		
		//test with first number is greater than second number
		assertThat(testDemo.max(2, 1)).isEqualTo(2);
		
		//test with first number is greater than second number.
		assertThat(testDemo.max(5, 10)).isEqualTo(10);
	}
	
	@Test
	void assertThatnumberDefidedIsCorrect() {
		
		//test with big number.
		assertThat(testDemo.divideBigNumbersByA(10, 5)).isEqualTo(2);
		
		//test with small number
		assertThat(testDemo.divideBigNumbersByA(2, 5)).isEqualTo(0.4);
		
		//test if number is 0.
		assertThat(testDemo.divideBigNumbersByA(0, 5)).isEqualTo(0);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
	TestDemo mockDemo = spy(testDemo);
	doReturn(5).when(mockDemo).getRandomResult();

	int fiveSquared = mockDemo.randomNumberSquare();

	assertThat(fiveSquared).isEqualTo(25);

	}

}
