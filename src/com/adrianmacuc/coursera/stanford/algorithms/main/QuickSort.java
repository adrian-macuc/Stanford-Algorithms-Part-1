package com.adrianmacuc.coursera.stanford.algorithms.main;

public class QuickSort {

	public static final int PIVOT_FIRST = 0;
	public static final int PIVOT_LAST = 1;
	public static final int PIVOT_MEDIAN = 2;

	private static int comparisons;

	public static int getComparisons() {
		return comparisons;
	}

	public static void resetComparisons() {
		QuickSort.comparisons = 0;
	}

	public static int[] quickSort(int[] input, int start, int end, int pivotPosition) {
		if (end - start <= 1) {
			return input;
		}

		int split = quickSortCountComparisons(input, start, end, pivotPosition);

		quickSort(input, start, split, pivotPosition);
		quickSort(input, split + 1, end, pivotPosition);
		return input;
	}

	private static int quickSortCountComparisons(int[] input, int start, int end, int pivotPosition) {
		comparisons += end - start - 1;
		int pivot = 0;

		switch (pivotPosition) {
		case PIVOT_FIRST:
			pivot = input[start];
			break;
		case PIVOT_LAST:
			pivot = input[end - 1];
			swap(input, start, end - 1);
			break;
		case PIVOT_MEDIAN:
			int medianPos = (start + end - 1) / 2;
			int result = getMedian(input[start], input[end - 1], input[medianPos]);
			if (result == input[start]) {
				pivot = input[start];
			} else if (result == input[end - 1]) {
				pivot = input[end - 1];
				swap(input, start, end - 1);
			} else {
				pivot = input[medianPos];
				swap(input, start, medianPos);
			}
			break;
		}

		int i = start + 1, j = start + 1;

		while (j < end) {
			if (input[j] < pivot) {
				swap(input, i, j);
				++i;
			}
			++j;
		}

		swap(input, start, i - 1);
		return i - 1;
	}

	private static void swap(int[] input, int i, int j) {
		if (i == j) {
			return;
		}

		int tmp = input[j];
		input[j] = input[i];
		input[i] = tmp;

	}

	private static int getMedian(int a, int b, int c) {
		return Math.min(Math.max(a, b), Math.max(Math.min(a, b), c));
	}

}
