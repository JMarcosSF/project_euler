package com.project.euler.utils;
import java.util.Random;

import com.datastructures.sort.BubbleSorter;
import com.datastructures.sort.QuickSorter;
import com.datastructures.sort.Sorter;

public class SearchAndSort {

    public static void main (String[] args) {
	
	long beginTime;
	long endTime;

	
	int[] testArray;
	testArray = GeneralUtils.generateRandomIntArray(1000, false, 1, 1100);

	// begin Quick Sort
	int[] qsArr = testArray.clone();
	beginTime = System.currentTimeMillis();
	
	QuickSorter qs = new QuickSorter();
	qs.sort(qsArr);
	
	endTime = System.currentTimeMillis();
	
	System.out.println("Quick Sort took: " + (endTime - beginTime) + " milliseconds.");
//	Sorter.printArray(testArray);
	// end Quick Sort
	
	// begin Bubble Sort
	int[] bsArr = testArray.clone();
	beginTime = System.currentTimeMillis();
	
	BubbleSorter bs = new BubbleSorter();
	bs.sort(bsArr);
	
	endTime = System.currentTimeMillis();
	
	System.out.println("Bubble Sort took: " + (endTime - beginTime) + " milliseconds.");
//	Sorter.printArray(testArray);
	// end Bubble Sort
	
//	linearSearch(testArray, 10);
//	System.out.println("");
//	binarySearchForValue(testArray, 9, 0, testArray.length - 1);

	//	 int factNum = 9;
	//	 System.out.println("Factorial of " + factNum + ": " + getFactorial(factNum));
    }

    /**
     * Searches the array A for the integer N. If N is not in the array,
     * then -1 is returned. If N is in the array, then the return value is
     * the first integer i that satisfies A[i] == N.
     */
    public static boolean linearIntSearch(int[] intArr, int searchVal) {
	boolean hasVal = false;
	int srchFor = searchVal;
	String indexesWithVal = "";

	for(int i = 0; i < intArr.length; i++) {
	    if(intArr[i] == searchVal) {
		hasVal = true;
		indexesWithVal += i + " ";
		// System.out.println("Has Value: " + srchFor);
	    }
	}
//	System.out.println("searchVal found: " + hasVal);
	return hasVal;
    }

    public static int getFactorial(int num) {
	if(num <= 1) {
	    return 1;
	} else {
	    return num * getFactorial(num - 1);
	}
    }

    /**
     * Search in the array A in positions numbered loIndex to hiIndex,
     * inclusive, for the specified value. If the value is found, return
     * the index in the array where it occurs. If the value is not found,
     * return -1. Precondition: The array must be sorted into increasing
     * order.
     */
    public static int binarySearchForValue(int[] intArr, int value, int lowInd, int highInd) {

	if(lowInd > highInd) {
	    // Not valid
	    return -1;
	}else {
	    // Get index of middle value
	    int midInd = (lowInd + highInd) / 2;
	    // Middle index contains search value
	    if(intArr[midInd] == value) {
		System.out.println("binarySearchForValue() found search value: " + intArr[midInd] + " at index: " + midInd);
		return intArr[midInd];
	    }else if(value < intArr[midInd]) {
		// Search value is less than value at middle index
		// so, recursively run binary search on lower half of array
		return binarySearchForValue(intArr, value, lowInd, intArr[midInd] - 1);
	    }else {
		// Search value is greater than value at middle index
		// so, recursively run binary search on upper half of array
		return binarySearchForValue(intArr, value, intArr[midInd] + 1, highInd);
	    }
	}

    }

    public static int[] swapValues(int[] intArr ,int indOne, int indTwo) {
	int temp = intArr[indOne];
	intArr[indOne] = intArr[indTwo];
	intArr[indTwo] = temp;
	return intArr;
    }

}
