package com.nab.portfolio.service;

/**
 * 
 */


/**
 * @author Sharad
 *
 */
public class ValidateEstimates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidateEstimates fib = new ValidateEstimates();
		System.out.println(fib.validateFibonacci(10));
		System.out.println(fib.validateFibonacci(21));
		System.out.println(fib.validateFibonacci(30));
		System.out.println(fib.validateFibonacci(5));
		
		System.out.println(fib.validateFibonacci(1));
		System.out.println(fib.validateFibonacci(34));
		
		System.out.println(fib.validateFibonacci(13));
		System.out.println(fib.validateFibonacci(8));
				
	} 
	
	public static boolean validateFibonacci(int n) {
		if(n > 0 && n <=21) {
			if(n==1) {
				return true;
			} else {
		        int fib1 = 0;
		        int fib2 = 1;
		        do {
		            int saveFib1 = fib1;
		            fib1 = fib2;
		            fib2 = saveFib1 + fib2;
		            if (fib2 == n)
			            return true;
		            }
		        while (fib2 <= n);
		        return false;
			}
		}else {
			return false;
		}

    }

}
