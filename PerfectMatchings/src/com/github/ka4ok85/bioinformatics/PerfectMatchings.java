package com.github.ka4ok85.bioinformatics;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Taking in consideration data set all actual combination generation task will take too much time
 * Simple total number can be calculated using formula
 */
public class PerfectMatchings {

	//private HashMap<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
	//private HashMap<Integer, List<Integer>> clonedEdges = new HashMap<Integer, List<Integer>>();
	
	//private List<Integer> nodes;
	//private int count = 0;
	//private int step = 1;
	
	
	public BigInteger calculateCounts(String string) {
		char[] charArray = string.toCharArray();
		int aCount = 0;
		int uCount = 0;
		int cCount = 0;
		int gCount = 0;
		
		int auCount = 0;
		int cgCount = 0;
		for (char c : charArray) {
			if (c == "A".charAt(0)) {
				aCount++;
			}

			if (c == "U".charAt(0)) {
				uCount++;
			}
			
			if (c == "C".charAt(0)) {
				cCount++;
			}
			
			if (c == "G".charAt(0)) {
				gCount++;
			}
		}
		
		if (aCount != uCount) {
			new RuntimeException("A and U pairs mismatch");
		}
		
		if (cCount != gCount) {
			new RuntimeException("C and G pairs mismatch");
		}
		
		auCount = aCount;
		cgCount = cCount;

		BigInteger auCombinationsCount = factorial(BigInteger.valueOf(auCount));
		BigInteger cgCombinationsCount = factorial(BigInteger.valueOf(cgCount));
		
		BigInteger result = auCombinationsCount.multiply(cgCombinationsCount);
		
		return result;
	}

	public static BigInteger factorial(BigInteger n) {
		BigInteger ret = BigInteger.valueOf(1L);

		for (int i = 1; n.compareTo(BigInteger.valueOf(i)) >= 0; ++i) {
			ret = ret.multiply(BigInteger.valueOf(i));
		}

		return ret;
	}	
	
/*
	public PerfectMatchings(String string) {
		char[] charArray = string.toCharArray();
		nodes = new ArrayList<Integer>();
		int index = 1;
		for (char c : charArray) {
			nodes.add(index);
			index++;
		}
		
		
		index = 1;
		int compareIndex = 1;
		for (char character : charArray) {
			for (char compareCharacter : charArray) {
				if (index != compareIndex) {
					//System.out.println(character + "_" + compareCharacter);
					if (
							(character == "A".charAt(0) && compareCharacter == "U".charAt(0)) ||
							(character == "U".charAt(0) && compareCharacter == "A".charAt(0)) ||
							(character == "C".charAt(0) && compareCharacter == "G".charAt(0)) ||
							(character == "G".charAt(0) && compareCharacter == "C".charAt(0))
					) {
						//System.out.println(character + "_" + compareCharacter);
						List<Integer> tmp = edges.get(index);
						if (tmp == null) {
							tmp = new ArrayList<Integer>();
						}
						//System.out.println(tmp);
						tmp.add(compareIndex);
						edges.put(index, new ArrayList<Integer>(tmp));
					}
				}
				compareIndex++;
			}
			index++;
			compareIndex = 1;
		}
		
		for (Entry<Integer, List<Integer>> entry : edges.entrySet()) {
//System.out.println(entry.getKey());
//System.out.println(entry.getValue());
		}

		
		
		//edges.put(1, new ArrayList<Integer>(Arrays.asList(4, 7, 10)));		
		
		//System.out.println(nodes);
	}

	public PerfectMatchings() {
		// TODO Auto-generated constructor stub
	}

	public HashMap<Integer, List<Integer>> getClonedEdges() {
		return clonedEdges;
	}

	public HashMap<Integer, List<Integer>> getClonedHashMap() {
		
		HashMap<Integer, List<Integer>> clone = new HashMap<Integer, List<Integer>>();
		for (Entry<Integer, List<Integer>> entry : edges.entrySet()) {
			
			
			ArrayList<Integer> clonedList = new ArrayList<Integer>(entry.getValue());
			clone.put(entry.getKey(), clonedList);
			
			//System.out.println(edges.get(entry.getKey()));
			


		}
		
		
		return clone;
	}
	
	public void buildEdges() {
		
		

		//HashMap<Integer, List<Integer>> clone = new HashMap<Integer, List<Integer>>();
		for (Entry<Integer, List<Integer>> entry : edges.entrySet()) {
			
			
			ArrayList<Integer> clonedList = new ArrayList<Integer>(entry.getValue());
			clonedEdges.put(entry.getKey(), clonedList);
			
			//System.out.println(edges.get(entry.getKey()));
			


		}
	}
	
	public void generate(List<Integer> currentNodes, HashMap<Integer, List<Integer>> currentEdges, int node, int connectTo, String result) {
		//System.out.println(result);
		//System.out.println("STEP" + step);
		//System.out.println("NODE" + node);
		//System.out.println("NODE connectTo" + connectTo);

		if (result.equals("")) {
			//currentEdges = new HashMap<Integer, List<Integer>>(edges);
			//System.out.println("+++++++++++");
			
			//currentEdges = getClonedEdges();
			
			for (Entry<Integer, List<Integer>> entry : getClonedEdges().entrySet()) {
				ArrayList<Integer> clonedList = new ArrayList<Integer>(entry.getValue());
				currentEdges.put(entry.getKey(), clonedList);
			}
			
			

		}

		//for (Entry<Integer, List<Integer>> entry : currentEdges.entrySet()) {
			//System.out.println("@@@" + entry.getKey());
			//System.out.println("@@@" + entry.getValue());

		//}
		
		if (connectTo == 0) {
			List<Integer> possibleEdges = currentEdges.get(node);
			//System.out.println("OOPS: " + possibleEdges);
			
			
			
			//HashMap<Integer, List<Integer>> tmp;
			//tmp = new HashMap<Integer, List<Integer>>(currentEdges);
			for (Integer nextNode : possibleEdges) {
				//System.out.println("--- CALL itself nextNode" + nextNode);
				//System.out.println("--- CALL itself nextNode" + currentNodes);
				
				
				
				//generate(currentNodes, currentEdges, node, nextNode, result);
				//System.out.println("parent generate call");
				//currentEdges = edges;
				generate(new ArrayList<Integer>(currentNodes), new HashMap<Integer, List<Integer>>(currentEdges), node, nextNode, result);
				//generate(new ArrayList<Integer>(currentNodes), new HashMap<Integer, List<Integer>>(tmp), node, nextNode, result);
			}
		}
		
		
		if (currentEdges.containsKey(node)) {
			//List<Integer> possibleEdges = currentEdges.get(node);
			//for (Integer nextNode : possibleEdges) {
				int nextNode = connectTo;
				//System.out.println("nextNode" + nextNode);
				//System.out.println("nextNode node" + node);
				//System.out.println("step" + step);
				if (nextNode == 0) {
					
					//System.out.println("RETURN: currentNodes="  + currentNodes);
					//System.out.println("RETURN: step="  + step);
					if (step != 1) {
						currentNodes.remove(Integer.valueOf(node));
						result += node + " " + currentNodes.get(0) + " - ";
						//System.out.println("RETURN: RESULT="  + result);
						//System.out.println("------------");
						System.out.println(result);
						step = 1;
						count++;
					}
					
					return;
				}
//System.out.println("***" + node);
//System.out.println("***" + currentNodes);
				//generate(currentNodes, currentEdges, nextStepNode, 0, result);
				if (currentNodes.contains(nextNode) == false) {
					// ???
					//continue;
				}
				
				
				currentEdges.remove(node);
				currentEdges.remove(nextNode);
//System.out.println(currentNodes);				
				currentNodes.remove(Integer.valueOf(node));
				
				currentNodes.remove(Integer.valueOf(nextNode));
				
				for (Entry<Integer, List<Integer>> entry : currentEdges.entrySet()) {
					//System.out.println(entry.getValue());
					entry.getValue().remove(Integer.valueOf(nextNode));
					entry.getValue().remove(Integer.valueOf(node));
				}
				
				//System.out.println(currentNodes);
				
				int nextStepNode = 0;
				for (Integer index: currentNodes) {
					nextStepNode = index;
					break;
				}
				
				//System.out.println("nextStepNode" + nextStepNode);
				
				if (nextStepNode == 0) {
					

					
						result += node + " " + nextNode + " - ";
						//System.out.println("------------");
						System.out.println(result);
						//System.out.println("stop");
						step = 1;
						count++;
						
						return;
					//break;
				} else {
				
					result += node + " " + nextNode + " - ";
					//System.out.println("child generate call");
					//System.out.println(currentNodes);
					step++;
					//for (Entry<Integer, List<Integer>> entry : currentEdges.entrySet()) {
//						System.out.println("###" + entry.getKey());
						//System.out.println("###" + entry.getValue());

					//}
					generate(currentNodes, currentEdges, nextStepNode, 0, result);
					//break;
				}
			//}
		} else {
			//System.out.println("???");
		}
		//currentEdges.n
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
*/

	
}
