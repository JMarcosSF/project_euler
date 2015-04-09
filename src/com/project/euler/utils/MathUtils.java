package com.project.euler.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.datastructures.sort.QuickSorter;

public class MathUtils {

	public static List<Integer> getMultiples(int x, int top) {
		List<Integer> intList = new ArrayList<Integer>();

		if(x <=0) {
			return intList;
		}
		int tmp = 0;
		int mult = 0;

		while(mult < (top - x)) {
			tmp++;
			mult = (tmp*x);
			intList.add(mult);
		}

		return intList;
	}

	public static int generateRandomNumb(int min, int max) {
		int num = min + (int)(Math.random() * ((max - min) + 1));
		return num;
	}

	/**
	 * Checks if giving int "n" is a prime.
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {
		// Here, 2 is prime
		if(n == 2) return true;
		//check if n is a multiple of 2
		if (n%2==0) return false;
		//if not, then just check the odds
		for(int i=3;i*i<=n;i+=2) {
			if(n%i==0)
				return false;
		}
		return true;
	}

	public static LinkedList<BigInteger> tdFactors(BigInteger n)
	{
		// Set a BigInteger var representing #2
		BigInteger two = BigInteger.valueOf(2);
		LinkedList<BigInteger> fs = new LinkedList<BigInteger>();

		// If n < 2, throw an IllegalArgumentException
		if (n.compareTo(two) < 0)
		{
			throw new IllegalArgumentException("must be greater than one");
		}

		// While n is even, add to fs and divide n by two
		while (n.mod(two).equals(BigInteger.ZERO))
		{
			fs.add(two);
			n = n.divide(two);
		}

		// if n is greater than one
		// starting from 3, check if each odd number is a factor
		// of n. If so, then add f to fs and set n to n/f
		//
		// if no, then check next odd number
		// Finally, add the last n to the fs list once out of the while loop.
		if (n.compareTo(BigInteger.ONE) > 0)
		{
			BigInteger f = BigInteger.valueOf(3);
			while (f.multiply(f).compareTo(n) <= 0)
			{
				// If n is a factor of 
				if (n.mod(f).equals(BigInteger.ZERO))
				{
					System.out.println("old n: " + n);
					System.out.println(f);
					fs.add(f);
					n = n.divide(f);
					System.out.println("new n: " + n + "\n");
				}
				else
				{
					f = f.add(two);
				}
			}
			fs.add(n);
		}

		return fs;
	}

	public static BigInteger factorial(BigInteger n) {
		BigInteger result = BigInteger.ONE;

		while (!n.equals(BigInteger.ZERO)) {
			result = result.multiply(n);
			n = n.subtract(BigInteger.ONE);
		}

		return result;
	}

	public static boolean bigIntIsPrime(BigInteger num) {
		BigInteger div, rem;
		div = new BigInteger("2");

		rem = num.mod(div);
		int mod = rem.compareTo(BigInteger.ZERO);
		if(mod == 0 && num.compareTo(div) != 0) {
			return false;
		}
		BigInteger zero = BigInteger.ZERO;
		for(BigInteger i = BigInteger.valueOf(3); i.compareTo(num) == -1; i = i.add(BigInteger.ONE)) {

			if(zero.compareTo(num.mod(i)) == 0) {
				return false;
			}
		}

		//	for(BigInteger i = num; i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE)) {
		//	    if(MathUtils.bigIntIsPrime(i) && i.compareTo(num) == -1) {
		//		System.out.println(i);
		//		return;
		//	    }
		//	}

		return true;
	}

	public static boolean isPalindrome(int input) {
		List<Integer> intArr = new ArrayList<Integer>();
		int procInt = input;

		int i = 0;
		while(procInt > 0) {
			intArr.add(procInt%10);
			procInt = procInt/10;
			i++;
		}

		int y = 0;
		int tmp = 0;
		int count = 0;
		for(int j:intArr) {
			if(j == 0 && count == 0) {
				break;
			}

			tmp = j + (tmp*10);
			count++;
		}

		if(input != tmp)
			return false;

		return true;
	}

	public static int getLCM(int[] numArr) {
		QuickSorter qc = new QuickSorter();
		qc.sort(numArr);
		int length = numArr.length;
		int greatInt = numArr[length - 1];
		int lcm = greatInt;

		while(true) {
			int count = 0;
			for(int i:numArr) {
				while(lcm%i != 0) {
					lcm = lcm + greatInt;
					count = 0;
				}
				count++;
			}
			if(numArr[count-1] == numArr[length-1]) {
				return lcm;
			}
		}

	}

	public static boolean isPythagoreanTriple(int a, int b, int c) {
		if((a*a) + (b*b) == (c*c))
			return true;
		return false;
	}

	// formula n(n+1)/2
	public static int getTriangleNumber(int iter) {
		int num = 0;
		if(iter <= 0)
			return -1;

		num = iter*(iter+1)/2;

		return num;
	}

	public static int exponent(int baseNum, int exp) {
		if (exp == 0)
			return 1;
		else
			return baseNum * (exponent(baseNum, --exp)); 
	}

	// for Euler Question 48
	public static BigInteger bigExponent(BigInteger baseNum, BigInteger exp) {
		if (exp == BigInteger.ZERO)
			return BigInteger.ONE;
		else
			return baseNum.multiply(bigExponent(baseNum, exp.subtract(BigInteger.ONE))); 
	}

	// O(n)
	public static boolean isPerm(int x, int y) {
		List<Integer> lOne = intToStringArray(x);
		List<Integer> lTwo = intToStringArray(y);
		if(lOne.size() != lTwo.size()) {
			return false;
		}

		for(int str:lTwo) {
			if(!lOne.contains(str)) 
				return false;
		}

		return true;
	}

	// O(n)
	public static List<Integer> intToStringArray(int num) {
		int x = num;
		List<Integer> intList= new ArrayList<Integer>();
		while (x > 0) {
			intList.add(x%10);
			x = x/10;
		}
		return intList;
	}

	// for eulerQuestinoFourteen()
	public static List<Long> getCollatzSeq(long i) {
		List<Long> collatzList = new ArrayList<Long>();
		long num = i;
		while(num > 1) {
			if (num % 2 == 0) {
				// even
				num = num/2;
			} else {
				// odd
				num = (3*num)+1;
			}
			collatzList.add(num);
		}

		return collatzList;
	}

}
