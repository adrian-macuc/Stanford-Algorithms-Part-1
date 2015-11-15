package com.adrianmacuc.coursera.stanford.algorithms.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.adrianmacuc.coursera.stanford.algorithms.main.QuickSort;

@RunWith(Parameterized.class)
public class QuickSortTest {

	private int[] input;
	private int[] expected;

	public QuickSortTest(int[] input, int[] expected) {
		this.input = input;
		this.expected = expected;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { 
			//test data			
			{new int[]{ 1, 3, 5, 7, 2, 4, 6, 8 }, new int[]{1, 2, 3, 4, 5, 6, 7, 8}},
			{new int[]{ 1, 2, 3, 4, 5, 6, 7, 8 }, new int[]{1, 2, 3, 4, 5, 6, 7, 8}},
			{new int[]{ 8, 7, 6, 5, 4, 3, 2, 1 }, new int[]{1, 2, 3, 4, 5, 6, 7, 8}}
		};
		return Arrays.asList(data);
	}

	@Test
	public void getSortedArrayPivotFirst() {		
		assertArrayEquals(expected, QuickSort.quickSort(input, 0, input.length, QuickSort.PIVOT_FIRST));		
	}
	
	@Test
	public void getSortedArrayPivotLast(){
		assertArrayEquals(expected, QuickSort.quickSort(input, 0, input.length, QuickSort.PIVOT_LAST));
	}
	
	@Test
	public void getSortedArrayPivotMedian(){
		assertArrayEquals(expected, QuickSort.quickSort(input, 0, input.length, QuickSort.PIVOT_MEDIAN));
	}

}
