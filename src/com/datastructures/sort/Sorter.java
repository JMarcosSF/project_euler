package com.datastructures.sort;

public abstract class Sorter {
    
    int[] a;
    int n;
    
    abstract public void sort(int[] a);
    
    public static void printArray(int[] intArr){

	System.out.println("----------");
	for(int i = 0; i < intArr.length; i++){

	    System.out.print("| " + i + " | ");
	    System.out.println(intArr[i] + " |");

	    System.out.println("----------");

	}

    }
    
}
