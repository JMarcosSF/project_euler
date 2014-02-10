package com.datastructures.sort;

public class BubbleSorter extends Sorter{

    @Override
    public void sort(int[] a) {
	this.a = a;
	n = a.length;
	bubbleSort();
    }
    
    /**
     * Sorts the n array elements A[0], A[1], ..., A[n-1] into increasing order.
     * O(n^2)
     */
    private void bubbleSort() {
	for(int i = 0; i < n; i++) {
	    for(int j = 0; j < n-1; j++) {
		if(a[j] > a[j+1]) {
		    int tmp = a[j];
		    a[j] = a[j+1];
		    a[j+1] = tmp;
		}
	    }
	}
    }

}
