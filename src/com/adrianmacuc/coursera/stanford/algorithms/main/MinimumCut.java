package com.adrianmacuc.coursera.stanford.algorithms.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MinimumCut {

	public static int getMinimumCut(HashMap<Integer, ArrayList<Integer>> graph, int repetitions) {		
		int minimumCut = Integer.MAX_VALUE;
		for (int i = 0; i < repetitions; i++) {
			HashMap<Integer, ArrayList<Integer>> copy = Utils.getGraphCopy(graph);				
			int result = getMinimumCut(copy);			
			minimumCut = Math.min(minimumCut, result);
		}
		return minimumCut;
	}
	
	
	public static int getMinimumCut(HashMap<Integer, ArrayList<Integer>> graph) {
		while (graph.size() > 2) {
			removeRandomVertex(graph);
		}
		return graph.get(graph.keySet().toArray()[0]).size();
	}

	private static void removeRandomVertex(HashMap<Integer, ArrayList<Integer>> graph) {
		Integer vertex = getRandomVertex(graph);
		ArrayList<Integer> connectedVertices = graph.get(vertex);
		Integer vertexToBeRemove = getRandomConnectedVertex(connectedVertices);

		ArrayList<Integer> vertexConnections = graph.get(vertex);
		ArrayList<Integer> vertexToBeRemovedConnections = graph.get(vertexToBeRemove);

		vertexConnections.addAll(vertexToBeRemovedConnections);

		graph.remove(vertexToBeRemove);

		for (Integer key : graph.keySet()) {
			ArrayList<Integer> currentVertexConnectionsList = graph.get(key);
			for (Integer i : currentVertexConnectionsList) {
				if (i.intValue() == vertexToBeRemove.intValue()) {
					currentVertexConnectionsList.set(currentVertexConnectionsList.indexOf(i), vertex);
				}
			}
		}

		removeLoops(vertex, vertexConnections);
	}

	private static Integer getRandomConnectedVertex(ArrayList<Integer> connectedVertices) {
		int index = new Random().nextInt(connectedVertices.size());
		Integer randomVertex = connectedVertices.get(index);
		return randomVertex;
	}

	private static Integer getRandomVertex(HashMap<Integer, ArrayList<Integer>> graph) {
		int index = new Random().nextInt(graph.keySet().size());
		Integer randomVertex = (Integer) graph.keySet().toArray()[index];
		return randomVertex;
	}

	private static void removeLoops(Integer vertex, ArrayList<Integer> VertexConnections) {
		ArrayList<Integer> selfLoops = new ArrayList<>();

		for (Integer i : VertexConnections) {
			if (i.intValue() == vertex.intValue()) {
				selfLoops.add(i);
			}
		}
		VertexConnections.removeAll(selfLoops);
	}
}