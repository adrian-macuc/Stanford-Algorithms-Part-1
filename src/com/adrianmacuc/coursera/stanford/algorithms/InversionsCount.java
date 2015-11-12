package com.adrianmacuc.coursera.stanford.algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class InversionsCount {

	private static long inversions;

	public static void main(String[] args) {
		try {
			int[] input = loadData(new File("IntegerArray.txt"));
			mergeSort(input);
			System.out.printf("%d", inversions);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int[] merge(int[] a, int[] b) {
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

	private static int[] loadData(File file) throws IOException {
		int lines = countLines(file);
		int[] array = new int[lines];

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		for (int i = 0; i < lines; i++) {
			array[i] = Integer.valueOf(br.readLine());
		}

		br.close();

		return array;
	}

	private static int countLines(File file) throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		int lines = 0;

		while (br.readLine() != null) {
			++lines;
		}

		br.close();

		return lines;
	}

}
