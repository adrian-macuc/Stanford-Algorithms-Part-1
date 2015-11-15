package com.adrianmacuc.coursera.stanford.algorithms.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.adrianmacuc.coursera.stanford.algorithms.main.MinimumCut;
import com.adrianmacuc.coursera.stanford.algorithms.main.Utils;

@RunWith(Parameterized.class)
public class MinimumCutTest {

	private HashMap<Integer, ArrayList<Integer>> graph;
	private int expectedMinimumCuts;

	public MinimumCutTest(HashMap<Integer, ArrayList<Integer>> graph, int expectedMinimumCuts) {
		this.graph = graph;
		this.expectedMinimumCuts = expectedMinimumCuts;
	}

	@Parameters
	public static Collection<Object[]> data() throws IOException {
		Object[][] data = new Object[][] { 
			//test data			
			{Utils.loadGraph(new File("testdata\\MinimumCut\\sample1.txt")), 2},
			{Utils.loadGraph(new File("testdata\\MinimumCut\\sample2.txt")), 2},
			{Utils.loadGraph(new File("testdata\\MinimumCut\\sample3.txt")), 1}
		};
		return Arrays.asList(data);
	}

	@Test
	public void getSortedArray() {		
		assertEquals(expectedMinimumCuts, MinimumCut.getMinimumCut(graph, 20));
	}

}
