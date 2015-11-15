package com.adrianmacuc.coursera.stanford.algorithms.main;

import java.util.Arrays;

public class InversionsCount {

	private static long inversions;	

	public static long getInversionsCount() {
		return inversions;
	}

	public static void resetInversions() {
		InversionsCount.inversions = 0;
	}

	private static int[] merge(int[] a, int[] b) {
		int i = 0, j = 0;

		int[] c = new int[a.length + b.length];

		for (int k = 0; k < a.length + b.length; k++) {
			if (i < a.length && j < b.length) {
				if (a[i] < b[j]) {
					c[i + j] = a[i];
					++i;
				} else {
					c[i + j] = b[j];
					inversions += a.length - i;
					++j;
				}
			} else {
				if (i == a.length) {
					c[i + j] = b[j];
					++j;
				} else {
					c[i + j] = a[i];
					++i;
				}
			}
		}
		return c;
	}

	public static int[] mergeSort(int[] input) {
		if (input.length == 1) {
			return input;
		} else {
			int mid = input.length / 2;
			int[] left = mergeSort(Arrays.copyOfRange(input, 0, mid));
			int[] right = mergeSort(Arrays.copyOfRange(input, mid, input.length));
			return merge(left, right);
		}

	}

	

}
