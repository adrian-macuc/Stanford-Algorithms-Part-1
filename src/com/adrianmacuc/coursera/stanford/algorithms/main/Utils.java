package com.adrianmacuc.coursera.stanford.algorithms.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Utils {

	public static int[] loadData(File file) throws IOException {
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

	public static HashMap<Integer, ArrayList<Integer>> loadGraph(File file) throws IOException {

		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		String line = "";

		while ((line = br.readLine()) != null) {
			StringTokenizer tkn = new StringTokenizer(line);

			ArrayList<Integer> edges = new ArrayList<>();
			Integer vertex = Integer.valueOf(tkn.nextToken());

			while (tkn.hasMoreTokens()) {
				edges.add(Integer.valueOf(tkn.nextToken()));
			}
			graph.put(vertex, edges);
		}

		br.close();

		return graph;
	}
	
	public static HashMap<Integer, ArrayList<Integer>> getGraphCopy(HashMap<Integer, ArrayList<Integer>> graph){
		
		HashMap<Integer, ArrayList<Integer>> copy = new HashMap<>();

		for (Integer key : graph.keySet()){
			ArrayList<Integer> edges = graph.get(key);
			copy.put(key, new ArrayList<>(edges));
		}
		
		return copy;
		
	}

}
