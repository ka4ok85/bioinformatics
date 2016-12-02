package com.github.ka4ok85.bioinformatics;

/*
 * return: The adjacency list corresponding to O3. You may return edges in any order.
 */
public class Run {

	public static void main(String[] args) {
		OverlapGraphs overlapGraphs = new OverlapGraphs();
		overlapGraphs.readFile();
		overlapGraphs.run();
	}

}
