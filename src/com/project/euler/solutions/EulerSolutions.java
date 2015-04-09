package com.project.euler.solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

import com.project.euler.utils.GeneralUtils;
import com.project.euler.utils.MathUtils;

public class EulerSolutions {

    public static void main(String[] args) {
	//	int[] input = GeneralUtils.generateRandomIntArray(10, true, 0, 11);
	//	for(int i = 0; i < input.length; i++) {
	//	    System.out.println(input[i]);
	//	}

	// 600851475143


	long beginTime;
	long endTime;

	beginTime = System.currentTimeMillis();

	System.out.println(MathUtils.isPalindrome(101));

	endTime = System.currentTimeMillis();
	System.out.println("took: " + (endTime - beginTime) + " milliseconds.");
    }


    /**
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * Find the sum of all the multiples of 3 or 5 below 1000.
     * @param input user's input within a int[] of numbers to find the multiples for
     * @param max Stop calculating multiples for all numbers less than this set max.
     * @return
     */
    public static int eulerQuestionOne(int[] input, int max) {
	if(input.length < 1)
	    return -1;
	int sum = 0;
	List<List<Integer>> multList = new ArrayList<List<Integer>>();
	// n
	for(int i = 0; i < input.length; i++) {
	    if(input[i] > 0) {
		List<Integer> addList = MathUtils.getMultiples(input[i], max);		
		multList.add(addList);
	    }
	}

	Set<Integer> summation = new HashSet<Integer>();
	for(List<Integer> list:multList) {
	    if(list.size() > 0) {		
		for(Integer i:list) {		
		    summation.add(i);
		}
	    }
	}

	for(Integer i:summation) {
	    sum += i;
	}

	System.out.println("Returning sum: " + sum);
	return sum;
    }

    /**
     * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
     *
     *	1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
     *
     *	By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
     * @param max
     * @return
     */
    public static long eulerQuestionTwo(int max) {
	long x = 0;
	long y = 1;
	long sum = 0;
	while(x < max) {
	    x = x + y;
	    y = x - y;
	    System.out.println(x + " ");
	    if(x%2 == 0) {
		sum = sum + x;
		System.out.println(x);
	    }
	}
	System.out.println("sum: " + sum);
	return sum;
    }

    /**
     * The prime factors of 13195 are 5, 7, 13 and 29.
     *
     * What is the largest prime factor of the number 600851475143 ?
     * @param bi
     * @return
     */
    public static BigInteger eulerQuestionThree(BigInteger bi) {
	LinkedList<BigInteger> ll = MathUtils.tdFactors(bi);
	return (BigInteger) ll.getLast();
    }

    /**
     * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 * 99.
     *
     * Find the largest palindrome made from the product of two 3-digit numbers.
     * @return
     */
    public static int eulerQuestionFour() {
	int i = 999;
	int largestPal = 0;
	while(i > 99) {
	    for(int j = 999; j > 99; j--) {
		if(MathUtils.isPalindrome(i*j)) {
		    int currPal = (i*j);
		    //		    System.out.println(i + "*" + j + " = " + currPal);		    
		    //		    System.out.println(currPal + "\n");
		    if(currPal > largestPal)
			largestPal = currPal;
		}
	    }

	    i--;
	}
	return largestPal;
    }

    /**
     * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
     * 
     * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
     * @param numArr
     * @return
     */
    public static int eulerQuestionFive(int[] numArr) {
	return MathUtils.getLCM(numArr);
    }

    /**
     * The sum of the squares of the first ten natural numbers is,
     * 12 + 22 + ... + 102 = 385
     * 
     * The square of the sum of the first ten natural numbers is,
     * (1 + 2 + ... + 10)2 = 552 = 3025
     * 
     * Hence the difference between the sum of the squares of the first ten natural numbers 
     * and the square of the sum is 3025 - 385 = 2640.
     * 
     * Find the difference between the sum of the squares of the first one hundred natural 
     * numbers and the square of the sum.
     * @param max
     * @return
     */
    public static int eulerQuestionSix(int max) {
	int sqr = 0;
	int sumSqr = 0;
	int size = max;
	int diff;
	for(int i = 1; i <= size; i++) {
	    //	    System.out.print(i + ", ");
	    //	    System.out.println();
	    int tmp = (i*i);
	    sqr = tmp + sqr;
	    sumSqr = sumSqr + i;
	    if(i == size) {
		sumSqr = sumSqr*sumSqr;
	    }
	}
	//	System.out.println("sumSqr: " + sumSqr);
	//	System.out.println("sqr: " + sqr);
	diff = (sumSqr - sqr);
	System.out.println(diff);
	return diff;
    }

    /**
     * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
     * 
     * What is the 10 001st prime number?
     * RECURSIVE:
     * @param max
     * @return
     */
    public static int eulerQuestionSevenRecursive(int max) {
	int currPrime = 0;
	int count = 0;
	int i = 0;
	while(count < max) {
	    if(MathUtils.isPrime(i)) {
		currPrime = i;
		count = count + eulerQuestionSevenRecursive(-1);
	    }
	    i++;
	}
	if(max < 0)
	    return 1;
	return currPrime;
    }

    /**
     * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
     * 
     * What is the 10 001st prime number?
     * BRUTE FORCE:
     * @param max
     * @return
     */
    public static int eulerQuestionSevenBrute(int max) {
	int currPrime = 0;
	int count = 0;
	int i = 0;
	while(count < max) {
	    if(MathUtils.isPrime(i)) {
		currPrime = i;
		count++;
	    }	    

	    i++;	
	}
	return currPrime;
    }

    public static void eulerQuestionEight() {
	String eulEightStr = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
	int[] eulEightArr = GeneralUtils.numStringToIntArray(eulEightStr);

	int greatestProd = 0;
	for(int i = 0; i < (eulEightArr.length-4); i++) {
	    int curProd = 1;
	    for(int j = i; j < (i + 5); j++) {
		System.out.print(eulEightArr[j] + "_" );
		if(eulEightArr[j] == 0) {
		    curProd = 0;
		    break;
		} else {		    
		    curProd = curProd * eulEightArr[j];
		}
	    }
	    System.out.println(" = "+ curProd);
	    if(curProd > greatestProd) {
		greatestProd = curProd;
		System.out.println("new greatestSum: " + greatestProd + "\n");
	    }
	    //	    System.out.println(curSum);
	    //	    System.out.println(eulEightArr[i] + " + " + eulEightArr[(i + 1)] + " = " + (eulEightArr[i] + eulEightArr[(i + 1)]));
	}
	System.out.println("Greatest Product: " + greatestProd);
    }

    public static int eulerQuestionNine() {
	int a, b, c, i, j, m, n, product;
	int sum = 0;
	// target sum for a + b + c 
	int targetSum = 1000;
	i = 1;
	while(true) {
	    j = 1;
	    // Pythoagorean Triples are infinite. So for efficiency, set compare to 
	    // target sum avoid unecessary iterations.
	    // At this point the condition is falst, and we know that target sum was 
	    // not found in this iteration
	    while(j < targetSum) {
		m = i;
		n = i + j;
		a = (n*n) - (m*m);
		b = (2*n)*m;
		c = (n*n) + (m*m);
		if(MathUtils.isPythagoreanTriple(a, b, c)) {
		    sum = a + b + c;
		    System.out.println(i);
		    System.out.println(j);		    
		    System.out.print("sum of " + a + " + " + b + " + " + c + " = " + sum + "\n\n");
		    if(sum == 1000) {
			//		    System.out.println("\n______________________________");
			//		    System.out.print(", sum of " + a + " + " + b + " + " + c + " = " + sum + "\n");
			product = (a*b*c);
			//		    System.out.println("product of a*b*c = " + (a*b*c));
			//		    System.out.println("______________________________");
			//		    return product;
			return product;
		    }
		}
		j++;
	    }
	    i++;
	}
    }

    public static void eulerQuestionTen() {
	long max = 2000000;
	long sum = 0;
	int i = 2;
	while(i < max) {
	    if(MathUtils.isPrime(i)) {
		System.out.println(MathUtils.isPrime(i));
		System.out.println(i);
		//		System.out.println(i);
		sum = sum + i;
		//		System.out.println(i);
	    }
	    if(i == 2) {
		i++;

	    }else {		
		i += 2;
	    }
	}
	System.out.println("sum: " + sum);
    }

    public static void eulerQuestionEleven() {
	// Instantiating multi-dimensional array for eulerQuestionTen()
	int rows = 20;
	int cols = 20;
	int[][] numGrid = new int[rows][cols];

	String delim = "-";
	String x = "08|02|22|97|38|15|00|40|00|75|04|05|07|78|52|12|50|77|91|08-49|49|99|40|17|81|18|57|60|87|17|40|98|43|69|48|04|56|62|00-81|49|31|73|55|79|14|29|93|71|40|67|53|88|30|03|49|13|36|65-52|70|95|23|04|60|11|42|69|24|68|56|01|32|56|71|37|02|36|91-22|31|16|71|51|67|63|89|41|92|36|54|22|40|40|28|66|33|13|80-24|47|32|60|99|03|45|02|44|75|33|53|78|36|84|20|35|17|12|50-32|98|81|28|64|23|67|10|26|38|40|67|59|54|70|66|18|38|64|70-67|26|20|68|02|62|12|20|95|63|94|39|63|08|40|91|66|49|94|21-24|55|58|05|66|73|99|26|97|17|78|78|96|83|14|88|34|89|63|72-21|36|23|09|75|00|76|44|20|45|35|14|00|61|33|97|34|31|33|95-78|17|53|28|22|75|31|67|15|94|03|80|04|62|16|14|09|53|56|92-16|39|05|42|96|35|31|47|55|58|88|24|00|17|54|24|36|29|85|57-86|56|00|48|35|71|89|07|05|44|44|37|44|60|21|58|51|54|17|58-19|80|81|68|05|94|47|69|28|73|92|13|86|52|17|77|04|89|55|40-04|52|08|83|97|35|99|16|07|97|57|32|16|26|26|79|33|27|98|66-88|36|68|87|57|62|20|72|03|46|33|67|46|55|12|32|63|93|53|69-04|42|16|73|38|25|39|11|24|94|72|18|08|46|29|32|40|62|76|36-20|69|36|41|72|30|23|88|34|62|99|69|82|67|59|85|74|04|36|16-20|73|35|29|78|31|90|01|74|31|49|71|48|86|81|16|23|57|05|54-01|70|54|71|83|51|54|69|16|92|33|48|61|43|52|01|89|19|67|48";
	String[] strArr = x.split("-");
	String[] tmpArr;
	delim = "\\|";
	for(int i = 0; i < strArr.length; i++) {
	    tmpArr = strArr[i].split(delim);
	    for(int j = 0; j < tmpArr.length; j++) {
		numGrid[i][j] = Integer.parseInt(tmpArr[j]);
	    }
	}

	int max = 4;
	int product = 0;
	int[] prodArr = new int[6];
	prodArr[0] = GeneralUtils.getGreatestProdDownColumns(numGrid, max, cols, rows);

	prodArr[1] = GeneralUtils.getGreatestProdAcrossRows(numGrid, max, cols, rows);

	prodArr[2] = GeneralUtils.getGreatesProdDownRightDiagonal(numGrid, max, cols, rows);

	prodArr[3] = GeneralUtils.getGreatesProdUpRightDiagonal(numGrid, max, cols, rows);

	prodArr[4] = GeneralUtils.getGreatesProdUpLeftDiagonal(numGrid, max, cols, rows);

	prodArr[5] = GeneralUtils.getGreatesProdDownLeftDiagonal(numGrid, max, cols, rows);

	for(int prod:prodArr) {
	    if(product < prod)
		product = prod;
	}
	System.out.println("The greates product as per the requirements is: " + product);
    }

    /**
     * The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. 
     * The first ten terms would be: 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
     * 
     * Let us list the factors of the first seven triangle numbers:
     * 1: 1
     * 3: 1,3
     * 6: 1,2,3,6
     * 10: 1,2,5,10
     * 15: 1,3,5,15
     * 21: 1,3,7,21
     * 28: 1,2,4,7,14,28
     * We can see that 28 is the first triangle number to have over five divisors.
     * 
     * What is the value of the first triangle number to have over five hundred divisors?
     * @param targetDigitCount
     */
    public static void eulerQuestionTwelve(int targetDigitCount) {
	int count = 0;
	int iter = 1;
	int currHighCount = 0;
	while(true) {
	    int tNum = MathUtils.getTriangleNumber(iter);
	    iter++;
	    //	    System.out.print("\n" + tNum + " : ");
	    // Only checking for numbers greater than half of current tNum
	    for(int i = 1; i <= (tNum/2); i++) {

		if(tNum%i == 0) {
		    count++;
		    //		    System.out.print(i + ", ");
		    //		    return;
		}
		// Once quotient is less than number being divided,
		// break out of this loop. 
		// At this point, we have a palindromic number
		// We can stop dividing when the quotient is smaller than the
		// number we're dividing by, multiply the count by 2 and break:
		if((tNum/i) < i) {
		    //		    System.out.println(i);
		    //		    System.out.println("tNum: " + tNum);
		    //		    System.out.println("tNum/i = " + (tNum/i));
		    count = count*2;
		    break;
		}
	    }
	    //	    System.out.println("\n" + count);
	    if(currHighCount < count) {
		currHighCount = count;
		System.out.println();
		System.out.print(currHighCount + " @: " + iter + ", tNum: " + tNum + "\n");
	    }
	    //	    System.out.print(".");
	    if(count>targetDigitCount) {
		System.out.println("\ncount: " + count + "\n");
		break;
	    }
	    count = 0;
	}
    }

    /**
     * *Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
     * (*see project_files/euler_question_13_input.txt)
     */
    public static void eulerQuestionThirteen() {

	BufferedReader br = null;

	try {

	    String sCurrentLine;
	    BigInteger sum = BigInteger.ZERO;
	    br = new BufferedReader(new FileReader("project_files/euler_question_13_input.txt"));

	    while ((sCurrentLine = br.readLine()) != null) {
		BigInteger curInt = new BigInteger(sCurrentLine);
		sum = sum.add(curInt);
	    }

	    System.out.println(sum);

	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (br != null)br.close();
	    } catch (IOException ex) {
		ex.printStackTrace();
	    }
	}

    }

    /**
     * The following iterative sequence is defined for the set of positive integers:
     * n --> n/2 (n is even)
     * n --> 3n + 1 (n is odd)
     * Using the rule above and starting with 13, we generate the following sequence:
     * 13 --> 40 --> 20 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1
     * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
     * Which starting number, under one million, produces the longest chain?
     * NOTE: Once the chain starts the terms are allowed to go above one million.
     * 
     * dev note: ran into an issue with primitive type max vale here. 
     * Terms were initially being calculated well over an Integer's max value.
     * Had to switch to "long".
     */
    public static void eulerQuestionFourteen() {
	int max = 1000000;
	int greatestSize = 0;
	long greatestBase = 0;
	for(long i = 1; i < max; i++) {
	    List<Long> tmpList = MathUtils.getCollatzSeq(i);
	    if(tmpList.size() > greatestSize) {
		greatestBase = i;
		greatestSize = tmpList.size();
	    }
	}
	System.out.print("\ngreatest size: " + greatestSize + "\n" + "greatestBase: " + greatestBase);
	System.out.println();
    }

    /**
     * Starting in the top left corner of a 2�2 grid, and only being able to move to the right and down, 
     * there are exactly 6 routes to the bottom right corner.
     * 
     * How many such routes are there through a 20�20 grid?
     * http://mozartreina.com/counting-lattice-paths.html
     */
    public static void eulerQuestionFifteen() {
	//	System.out.println("  The Grid, before:  ");
	//	System.out.println("__________________________\n");
	int gridSize = 21;
	long[][] grid = new long[gridSize][gridSize];

	// setting initial value of grid
	for(int i = 0; i < gridSize; i++) {
	    grid[0][i] = 1;
	    grid[i][0] = 1;
	}

	for(int i = 0; i < gridSize; i++) {
	    for(int j = 0; j < gridSize; j++) {
		//		System.out.print(grid[i][j] + " ");
	    }
	    //	    System.out.println();
	}

	long totalPathSum = 0;
	for(int i = 0; i < gridSize; i++) {
	    for(int j = 0; j < gridSize; j++) {
		if(j > 0 && j <= gridSize-1 && i == j) {
		    int it = 1;
		    while(it < gridSize) {			
			grid[i][it] = grid[i][it-1] + grid[i-1][it];
			if(i == gridSize - 1 && it == gridSize - 1)
			    totalPathSum = grid[i][it];
			it++;
		    }
		}
	    }
	}
	//	System.out.println("\nafter:");
	//	System.out.println("__________________________\n");


	for(int i = 0; i < gridSize; i++) {
	    for(int j = 0; j < gridSize; j++) {
		//		System.out.print(grid[i][j] + " ");
	    }
	    //	    System.out.println();
	}
	System.out.println("Number of total paths: " + totalPathSum + "\n");
    }

    /**
     * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
     * What is the sum of the digits of the number 2^1000?1
     */
    public static void eulerSolutionSixteen() {
	// solution in groovy
	// need to translate to Java
	//	def startTime
	//	def endTime
	//
	//	startTime = System.currentTimeMillis()
	//	def intArr = []
	//	BigInteger bigInt = 2**1000
	//	//println bigInt
	//	int i = 0;
	//
	//	while(bigInt > 0) {
	//	    intArr.add(bigInt%10);
	//	    bigInt = bigInt/10;
	//	    i++;
	//	}
	//	println "\nbigInt has: " + intArr.size() + " digits.\n"
	//	def sum = 0
	//
	//	for(dig in intArr) {
	//	     sum = sum + dig
	//	}
	//	println "sum of all digits in bigInt: " + sum
	//	endTime = System.currentTimeMillis()
	//	println("took: " + (endTime-startTime) + " milliseconds!")


    }

    /**
     * n! means n � (n - 1) � ... � 3 � 2 � 1
     * 
     * For example, 10! = 10 � 9 � ... � 3 � 2 � 1 = 3628800,
     * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
     * 
     * Find the sum of the digits in the number 100!
     */
    public static void eulerSolutionTwenty() {
	// solution in groovy
	// need to translate to Java

	BigInteger result = BigInteger.ONE;
	BigInteger n = BigInteger.valueOf(100);
	int sum = 0;
	while (!n.equals(BigInteger.ZERO)) {
	    result = result.multiply(n);
	    n = n.subtract(BigInteger.ONE);
	    if(n.equals(BigInteger.ONE)) {
		BigInteger ten = BigInteger.valueOf(10);
		while (result.compareTo(BigInteger.ZERO) > 0) {
		    BigInteger tmpBig = result.mod(ten);
		    sum = sum + tmpBig.intValue();
		    result = result.divide(ten);
		}
		System.out.println(sum);
	    }
	}

    }

    public static void eulerQuestionFortyEight() {

	int max = 1000;
	BigInteger[] arr = new BigInteger[max];

	for(int i = max;  i > 0; i--) {

	    BigInteger tmp = MathUtils.bigExponent(BigInteger.valueOf(i), BigInteger.valueOf(i));
	    arr[(int) (i -1)] = tmp;

	}
	BigInteger bigSum = BigInteger.ZERO;
	for(BigInteger i:arr) {
	    bigSum = bigSum.add(i);
	}
	System.out.println(bigSum);

    }

    /**
     * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.
     * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.
     * What 12-digit number do you form by concatenating the three terms in this sequence?
     */
    public static void eulerQuestionFortyNine() {
	for(int i = 1000; i < 9999; i++) {
	    if(MathUtils.isPrime(i)) {
		int j = i + 3330;
		if(MathUtils.isPrime(j) && MathUtils.isPerm(i, j)) {
		    int k = j + 3330;
		    if(MathUtils.isPrime(k) && MathUtils.isPerm(j, k)) {
			if(k < 9999) {
			    String str = String.valueOf(i);
			    System.out.println(str.charAt(0));
			    System.out.println(i);
			    System.out.println(j);
			    System.out.println(k + "\n");			    
			}
		    }
		}
	    }
	}
    }

}
