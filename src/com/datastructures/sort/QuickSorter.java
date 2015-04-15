package com.datastructures.sort;

public class QuickSorter extends Sorter{

	@Override
	public void sort(int[] a) {
		this.a = a;
		n = a.length;
		quicksort(0, n - 1);
	}

	/**
	 * Apply QuicksortStep to the list of items in locations lo through hi
	 * in the array A. The value returned by this routine is the final
	 * position of the pivot item in the array.
	 */
	private int quicksortStep(int lo, int hi) {
		int pivot = a[lo]; // Get the pivot value.
		// The numbers hi and lo mark the endpoints of a range
		// of numbers that have not yet been tested. Decrease hi
		// and increase lo until they become equal, moving numbers
		// bigger than pivot so that they lie above hi and moving
		// numbers less than the pivot so that they lie below lo.
		// When we begin, A[lo] is an available space, since its
		// value has been moved into the local variable, pivot.
		while (hi > lo) {
			while (hi > lo && a[hi] >= pivot) {
				// Move hi down past numbers greater than pivot.
				// These numbers do not have to be moved.
				hi--;
				//		System.out.println("new hi: " + hi + "______________________");
			}
			if (hi == lo)
				break;
			// The number A[hi] is less than pivot. Move it into
			// the available space at A[lo], leaving an available
			// space at A[hi].
			a[lo] = a[hi];
			lo++;
			while (hi > lo && a[lo] <= pivot) {
				// Move lo up past numbers less than pivot.
				// These numbers do not have to be moved.
				lo++;
				//		System.out.println("new lo: " + lo + "______________________");
			}
			if (hi == lo)
				break;
			// The number A[lo] is greater than pivot. Move it into
			// the available space at A[hi], leaving an available
			// space at A[lo].
			a[hi] = a[lo];
			hi--;
		} // end while
		// At this point, lo has become equal to hi, and there is
		// an available space at that position. This position lies
		// between numbers less than pivot and numbers greater than
		// pivot. Put pivot in this space and return its location.
		a[lo] = pivot;
		return lo;
	} // end QuicksortStep

	/**
	 * Apply quicksort to put the array elements between
	 * position lo and position hi into increasing order.
	 * O(n log n)
	 */
	private void quicksort(int lo, int hi) {
		//	System.out.println("--------------------------");
		if (hi <= lo) {
			// The list has length one or zero. Nothing needs
			// to be done, so just return from the subroutine.
			return;
		}
		else {
			// Apply quicksortStep and get the new pivot position.
			// Then apply quicksort to sort the items that
			// precede the pivot and the items that follow it.
			int pivotPosition = quicksortStep(lo, hi);
			//	    System.out.println("pivotPosition: " + pivotPosition);
			//	    System.out.println("pivotPosition val: " + intArr[pivotPosition]);
			//	    System.out.println("quickSort below pivot...");
			quicksort(lo, pivotPosition - 1);
			//	    System.out.println("Done...");
			//	    System.out.println("quickSort above pivot...");
			quicksort(pivotPosition + 1, hi);
			//	    System.out.println("Done...");
		}
	}

}
