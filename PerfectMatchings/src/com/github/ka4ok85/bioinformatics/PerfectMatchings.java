package com.github.ka4ok85.bioinformatics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

public class PerfectMatchings {

	private HashMap<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
	private List<Integer> nodes;
	private int count = 0;
	
	public void buildEdges() {
		
		

		
		edges.put(1, new ArrayList<Integer>(Arrays.asList(4, 7, 10)));
		edges.put(2, new ArrayList<Integer>(Arrays.asList(3, 8)));
		edges.put(3, new ArrayList<Integer>(Arrays.asList(2, 6)));
		edges.put(4, new ArrayList<Integer>(Arrays.asList(1, 5, 9)));
		edges.put(5, new ArrayList<Integer>(Arrays.asList(4, 7, 10)));
		edges.put(6, new ArrayList<Integer>(Arrays.asList(3, 8)));
		edges.put(7, new ArrayList<Integer>(Arrays.asList(1, 5, 9)));
		edges.put(8, new ArrayList<Integer>(Arrays.asList(2, 6)));
		edges.put(9, new ArrayList<Integer>(Arrays.asList(4, 7, 10)));
		edges.put(10, new ArrayList<Integer>(Arrays.asList(1, 5, 9)));

		

		/*
		edges.put(1, Arrays.asList(4, 7, 10));
		edges.put(2, Arrays.asList(3, 8));
		edges.put(3, Arrays.asList(2, 6));
		edges.put(4, Arrays.asList(1, 5, 9));
		edges.put(5, Arrays.asList(4, 7, 10));
		edges.put(6, Arrays.asList(3, 8));
		edges.put(7, Arrays.asList(1, 5, 9));
		edges.put(8, Arrays.asList(2, 6));
		edges.put(9, Arrays.asList(4, 7, 10));
		edges.put(10, Arrays.asList(1, 5, 9));
*/

		nodes = new ArrayList<Integer>();
		nodes.add(1);
		nodes.add(2);
		nodes.add(3);
		nodes.add(4);
		nodes.add(5);
		nodes.add(6);
		nodes.add(7);
		nodes.add(8);
		nodes.add(9);
		nodes.add(10);
	}
	
	public void generate(List<Integer> currentNodes, HashMap<Integer, List<Integer>> currentEdges, int node, int connectTo, String result) {
		System.out.println(result);
		System.out.println("NODE" + node);
		

		
		if (connectTo == 0) {
			List<Integer> possibleEdges = currentEdges.get(node);
			for (Integer nextNode : possibleEdges) {
				System.out.println("--- CALL itself nextNode" + nextNode);
				System.out.println("--- CALL itself nextNode" + currentNodes);
				
				
				
				
				//generate(currentNodes, currentEdges, node, nextNode, result);
				System.out.println("parent generate call");
				generate(new ArrayList<Integer>(currentNodes), new HashMap<Integer, List<Integer>>(currentEdges), node, nextNode, result);
			}
		}
		
		
		if (currentEdges.containsKey(node)) {
			//List<Integer> possibleEdges = currentEdges.get(node);
			//for (Integer nextNode : possibleEdges) {
				int nextNode = connectTo;
				System.out.println("nextNode" + nextNode);
				if (nextNode == 0) {
					return;
				}
System.out.println("***" + node);
System.out.println("***" + currentNodes);
				//generate(currentNodes, currentEdges, nextStepNode, 0, result);
				if (currentNodes.contains(nextNode) == false) {
					// ???
					//continue;
				}
				
				
				currentEdges.remove(node);
				currentEdges.remove(nextNode);
System.out.println(currentNodes);				
				currentNodes.remove(Integer.valueOf(node));
				
				currentNodes.remove(Integer.valueOf(nextNode));
				
				for (Entry<Integer, List<Integer>> entry : currentEdges.entrySet()) {
					//System.out.println(entry.getValue());
					entry.getValue().remove(Integer.valueOf(nextNode));
					entry.getValue().remove(Integer.valueOf(node));
				}
				
				System.out.println(currentNodes);
				
				int nextStepNode = 0;
				for (Integer index: currentNodes) {
					nextStepNode = index;
					break;
				}
				
				System.out.println("nextStepNode" + nextStepNode);
				
				if (nextStepNode == 0) {
					

					
						result += node + " " + nextNode + " - ";
						System.out.println("------------");
						System.out.println(result);
						System.out.println("stop");
						count++;
						return;
					//break;
				} else {
				
					result += node + " " + nextNode + " - ";
					System.out.println("child generate call");
					System.out.println(currentNodes);
					generate(currentNodes, currentEdges, nextStepNode, 0, result);
					//break;
				}
			//}
		} else {
			System.out.println("???");
		}
		//currentEdges.n
		/*
		if (result.equals("") == false) {
			result = result + " " + element;
		} else {
			result = result + element;
		}

		if (otherElements.length > 0) {
			for (int i = 0; i < otherElements.length; i++) {
				generate(
						otherElements[i], 
						PermutationRecursive.removeElement(otherElements, otherElements[i]),
						result
				);				
			}
		} else {
			System.out.println(result);
		}
		*/
	}

	public HashMap<Integer, List<Integer>> getEdges() {
		return edges;
	}

	public List<Integer> getNodes() {
		return nodes;
	}

	public int getCount() {
		return count;
	}
	

}