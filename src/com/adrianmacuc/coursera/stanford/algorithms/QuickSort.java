package com.adrianmacuc.coursera.stanford.algorithms;

import java.io.File;
import java.io.IOException;

public class QuickSort {

	private static final int PIVOT_FIRST = 0;
	private static final int PIVOT_LAST = 1;
	private static final int PIVOT_MEDIAN = 2;

	private static int comparisons;

	public static void main(String[] args) {

		int[] input = new int[] { 4, 5, 6 };
		try {
			input = Utils.loadData(new File("QuickSort.txt"));
			quickSortCountComparisons(input, 0, input.length, PIVOT_FIRST);
			System.out.printf("Number of comparisons when using the number on first position as pivot: %d \n",
					comparisons);

			comparisons = 0;
			input = Utils.loadData(new File("QuickSort.txt"));
			quickSortCountComparisons(input, 0, input.length, PIVOT_LAST);
			System.out.printf("Number of comparisons when using the number on last position as pivot: %d\n",
					comparisons);

			comparisons = 0;
			input = Utils.loadData(new File("QuickSort.txt"));
			quickSortCountComparisons(input, 0, input.length, PIVOT_MEDIAN);
			System.out.printf(
					"Number of comparisons when using the number on median between first, last and middle position as pivot: %d\n",
					comparisons);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static int[] quickSortCountComparisons(int[] input, int start, int end, int pivotPosition) {
		if (end - start <= 1) {
			return input;
		}

		int split = quickSort(input, start, end, pivotPosition);

		quickSortCountComparisons(input, start, split, pivotPosition);
		quickSortCountComparisons(input, split + 1, end, pivotPosition);
		return input;
	}

	private static int quickSort(int[] input, int start, int end, int pivotPosition) {
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

		int i = start + 1, 
			j = start + 1;

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
		if (i == j)
			return;

		int tmp = input[j];
		input[j] = input[i];
		input[i] = tmp;

	}

	private static int getMedian(int a, int b, int c) {
		return Math.min(Math.max(a, b), Math.max(Math.min(a, b), c));
	}

}
