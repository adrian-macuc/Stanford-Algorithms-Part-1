package com.adrianmacuc.coursera.stanford.algorithms.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		System.out.println("RESULTS");

		System.out.println("--------------------------");
		System.out.println("Programming Question-1");
		try {
			int[] input = Utils.loadData(new File("IntegerArray.txt"));
			InversionsCount.resetInversions();
			InversionsCount.mergeSort(input);
			System.out.printf("Number of inversions while merge-sorting: %d \n", InversionsCount.getInversionsCount());
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("--------------------------");
		System.out.println("Programming Question-2");
		try {
			int[] input = null;
			input = Utils.loadData(new File("QuickSort.txt"));
			QuickSort.quickSort(input, 0, input.length, QuickSort.PIVOT_FIRST);
			System.out.printf("Number of comparisons when using the number on first position as pivot: %d \n",
					QuickSort.getComparisons());
			QuickSort.resetComparisons();

			input = Utils.loadData(new File("QuickSort.txt"));
			QuickSort.quickSort(input, 0, input.length, QuickSort.PIVOT_LAST);
			System.out.printf("Number of comparisons when using the number on last position as pivot: %d\n",
					QuickSort.getComparisons());
			QuickSort.resetComparisons();

			input = Utils.loadData(new File("QuickSort.txt"));
			QuickSort.quickSort(input, 0, input.length, QuickSort.PIVOT_MEDIAN);
			System.out.printf(
					"Number of comparisons when using the number on median between first, last and middle position as pivot: %d\n",
					QuickSort.getComparisons());
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("--------------------------");
		System.out.println("Programming Question-3");
		try {
			HashMap<Integer, ArrayList<Integer>> graph = Utils.loadGraph(new File("kargerMinCut.txt"));
			System.out.println("Minimum number of cuts for the graph: " + MinimumCut.getMinimumCut(graph, 30));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
