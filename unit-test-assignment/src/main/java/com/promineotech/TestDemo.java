package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
		throw new IllegalArgumentException("Both parameters must be positive!");
		}
		return a + b;
		}

		/**
		 * Returns the maximum of two integers.
		 * 
		 * @param a the first integer
		 * @param b the second integer
		 * @return the maximum of a and b
		 */
		public int max(int a, int b) {
		    return Math.max(a, b);
		}
		
		/*return the square of random numbers between 1 and 10.
		@return square of random numbers
		*/
		public int randomNumberSquare(){
			int result = getRandomResult();
			return result * result;
		
	}
		//return random numbers between 1 and 10
		
		public int getRandomResult() {
			Random random = new Random();
			return random.nextInt(10) + 1;
		}
		
		
		
		public double divideBigNumbersByA(int number, int a) {
			
			return (double)number / a;
		}
		public double dicvideNumberByZero(int number, int a) {
			if (number == 0 || a == 0) {
				throw new ArithmeticException("Can not divide nymber by (0)");
			}return (double) number/a;
		}
		
}
