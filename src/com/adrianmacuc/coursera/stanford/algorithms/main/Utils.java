package com.adrianmacuc.coursera.stanford.algorithms.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
}
