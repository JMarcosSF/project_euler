package com.project.euler.utils;

import com.datastructures.*;

public class GeneralUtils {

	/**
	 * Generates a random, unsorted int[] with only numbers specified between min and max.
	 * Also can allow duplicates or not. 
	 * @param size
	 * @param allowsDuplicate
	 * @param min
	 * @param max
	 * @return
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static int[] generateRandomIntArray(int size, boolean allowsDuplicate, int min, int max)throws ArrayIndexOutOfBoundsException {
		if(countNumbersInRange(min, max) < size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int randArr[] = new int[size];
		int randNum = MathUtils.generateRandomNumb(min, max);
		for(int i = 0; i < size; i++) {
			if(SearchAndSort.linearIntSearch(randArr, randNum) && !allowsDuplicate) {
				while(true) {
					randNum = MathUtils.generateRandomNumb(min, max);
					if(!SearchAndSort.linearIntSearch(randArr, randNum)) {
						randArr[i] = randNum;
						break;
					}
				}
			}
			randArr[i] = randNum;
			randNum = MathUtils.generateRandomNumb(min, max);
		}

		return randArr;
	}

	/**
	 * Counts all numerical ordered numbers within the user's specified range.
	 * @param min
	 * @param max
	 * @return
	 */
	public static int countNumbersInRange(int min, int max) {
		int count = 0;
		if(min > max) {
			return -1;
		}
		while(min <= max) {
			min++;
			count++;
		}
		return count;
	}

	public static int[] numStringToIntArray(String numStr) {

		if(numStr.length() <= 0)
			return new int[0];

		// Programatically instantiate array for use in solving euler problem 8
		int[] numArr = new int[numStr.length()];
		for(int i = 0; i < numStr.length(); i++) {
			numArr[i] = Character.getNumericValue(numStr.charAt(i));
		}
		// done instantiating array
		return numArr;
	}

	// For use in eurlerQuestionEleven()
	public static int getGreatestProdDownColumns(int[][] arr, int maxDigits, int columns, int rows) {
		int sum = 0;
		for(int i = 0; i < rows; i++) {
			int prod = 0;
			while((prod) < (columns-(maxDigits-1))) {
				int tmpProd = 1;
				int curr = prod;
				for(int it = 0; it < maxDigits; it++) {
					tmpProd = tmpProd * arr[curr + it][i];
					//		    System.out.print(curr + it + ", ");
					//		    System.out.print(i + ":");
					//		    System.out.print(arr[curr + it][i] + " ");
				}
				if(sum < tmpProd)
					sum = tmpProd;
				prod++;
				//		System.out.println();
			}

			//	    System.out.println();
		}
		return sum;
	}

	// For use in eurlerQuestionEleven()
	public static int getGreatestProdAcrossRows(int[][] arr, int maxDigits, int columns, int rows) {
		int prod = 0;
		for(int i = 0; i < rows; i++) {
			int tmp = 0;
			while((tmp) < (columns-(maxDigits-1))) {
				int tmpProd = 1;
				int curr = tmp;
				for(int it = 0; it < maxDigits; it++) {
					tmpProd = tmpProd * arr[i][curr+it];
					//		    System.out.print(i + ", ");
					//		    System.out.print(curr+it + ":");
					//		    System.out.print(arr[i][curr + it] + " ");
				}
				if(prod < tmpProd)
					prod = tmpProd;
				tmp++;
				//		System.out.println();
			}

			//	    System.out.println();
		}
		return prod;
	}

	// For use in eurlerQuestionEleven()
	public static int getGreatesProdDownRightDiagonal(int[][] arr, int maxDigits, int columns, int rows) {
		int prod = 0;
		for(int i = 0; i < (rows-(maxDigits - 1)); i++) {
			int tmp = 0;
			for(int j = 0; j < (columns-(maxDigits-1)); j++) {
				int tmpprod = 1;
				for(int k = 0; k < maxDigits; k++) {
					tmpprod = tmpprod * arr[k+i][k+tmp];
					//		    System.out.print(k+i + ", ");
					//		    System.out.print(k+tmp + ":");
					//		    System.out.print(arr[k+i][k+tmp] + " ");
				}
				if(prod < tmpprod) 
					prod = tmpprod;
				tmp++;
				//		System.out.println(" ");
			}
			//	    System.out.println("_________________________");
		}
		return prod;
	}

	// For use in eurlerQuestionEleven()
	public static int getGreatesProdUpRightDiagonal(int[][] arr, int maxDigits, int columns, int rows) {
		int prod = 0;
		for(int i = (maxDigits - 1); i < (rows); i++) {
			int tmp = 0;
			for(int j = 0; j < (columns-(maxDigits-1)); j++) {
				int tmpprod = 1;
				for(int k = 0; k < maxDigits; k++) {
					tmpprod = tmpprod * arr[Math.abs(k-i)][k+tmp];
					//		    System.out.print(Math.abs(k-i) + ", ");
					//		    System.out.println(k+tmp);
					//		    System.out.print(arr[Math.abs(k-i)][k+tmp] + "_");
				}
				if(prod < tmpprod) 
					prod = tmpprod;
				tmp++;
				//		System.out.println(" ");
			}
			//	    System.out.println("_________________________");
		}
		return prod;
	}

	// For use in eurlerQuestionEleven()
	public static int getGreatesProdUpLeftDiagonal(int[][] arr, int maxDigits, int columns, int rows) {
		int prod = 0;
		for(int i = (maxDigits - 1); i < (rows); i++) {
			int tmp = maxDigits - 1;
			for(int j = 0; j < (columns-(maxDigits-1)); j++) {
				int tmpprod = 1;
				for(int k = 0; k < maxDigits; k++) {
					tmpprod = tmpprod * arr[Math.abs(k-i)][Math.abs(k-tmp)];
					//		    System.out.print(Math.abs(k-i) + ", ");
					//		    System.out.print(k+tmp + ":");
					//		    System.out.print(arr[Math.abs(k-i)][Math.abs(k-tmp)] + ", ");
				}
				if(prod < tmpprod) 
					prod = tmpprod;
				tmp++;
				//		System.out.println(" ");
			}
			//	    System.out.println("_________________________");
		}
		return prod;
	}

	// For use in eurlerQuestionEleven()    
	public static int getGreatesProdDownLeftDiagonal(int[][] arr, int maxDigits, int columns, int rows) {
		int prod = 1;
		for(int i = 0; i < (rows-(maxDigits - 1)); i++) {
			int tmp = (maxDigits-1);
			for(int j = 0; j < (columns-(maxDigits-1)); j++) {
				int tmpProd = 1;
				for(int k = 0; k < maxDigits; k++) {
					tmpProd = tmpProd * arr[k+i][Math.abs(k-tmp)];
					//		    System.out.print(k+i + ", ");
					//		    System.out.print(Math.abs(k-tmp) + ":");
					//		    System.out.print(arr[k+i][Math.abs(k-tmp)] + " ");
				}
				if(prod < tmpProd) 
					prod = tmpProd;
				tmp++;
				//		System.out.println(" ");
			}
			//	    System.out.println("_________________________");
		}
		return prod;
	}
	
	public static boolean isSubstring(String pattern, String str) {
		int pattLength = pattern.length();
		int pattLoc = 0;
		char[] pattCharArr = pattern.toCharArray();
		char pattCurr = pattCharArr[pattLoc];
		
		int strLength = str.length();
		int strLoc = 0;
		char[] strCharArr = str.toCharArray();
		char strCurr;
		
		for(int i = 0; i < strLength; i++) {
			strLoc = i;
			strCurr = strCharArr[strLoc];
			
			while(pattCurr == strCurr) {
				if(strLoc >= strLength) {
					return false;
				}
				pattCurr = pattCharArr[pattLoc++];
				strCurr = strCharArr[strLoc++];
				if(pattLoc == pattLength) {
					return true;
				}
			}
		}
		return false;
	}

}
