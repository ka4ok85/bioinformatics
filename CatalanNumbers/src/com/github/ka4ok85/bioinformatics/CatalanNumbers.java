package com.github.ka4ok85.bioinformatics;

import java.util.ArrayList;
import java.util.HashMap;

public class CatalanNumbers {

	// save computing time by storing counts for subgraphs in cache 
	private HashMap<String, Long> cache = new HashMap<String, Long>();
	private HashMap<String, String> bonding = new HashMap<String, String>();
	
	public Long calculate(String rna) {
		bonding.put("A", "U");
		bonding.put("C", "G");
		bonding.put("G", "C");
		bonding.put("U", "A");
		
		Long count = countNonCrosing(rna);

		return count;
	}
	
	/*
	 * The idea behind the algorithm is as follows. Recursively split graph into 2 subgraphs until nodes count will be less then 3.
	 * 2 split rules: split line should connect only U/A or C/G codons AND new subrgaph must contain U/A and/or G/C pairs (otherwise non-crossing rule will be violated)
	 */
	private Long countNonCrosing(String rna) {
		if (rna.length() <= 2) {
			return 1L;
		} else if (cache.containsKey(rna)) {
			return cache.get(rna);
		} else {
			Long result = 0L;
			ArrayList<Integer> splits = new ArrayList<>(); 
			for (int i = 1; i < rna.length(); i = i + 2) {
				if (rna.substring(0, 1).equals(bonding.get(rna.substring(i, i+1))) && checkSubinterval(rna.substring(1, i))) {
					splits.add(i);
				}
			}
			
			for (Integer integer : splits) {
				result = result + ((countNonCrosing(rna.substring(1, integer)) % 1000000) * (countNonCrosing(rna.substring(integer+1)) % 1000000));
			}
			
			result = result % 1000000;

			cache.put(rna, result);

			return result;
		}
	}

	/*
	 * Checks subinterval consists of U/A and G/C pairs
	 */
	private Boolean checkSubinterval(String subinterval) {
		char[] subintervalArray = subinterval.toCharArray();
		int aCount = 0;
		int cCount = 0;
		int gCount = 0;
		int uCount = 0;
		for (char c : subintervalArray) {
			if ("A".charAt(0) == c) {
				aCount++;
			}
			if ("C".charAt(0) == c) {
				cCount++;
			}
			if ("G".charAt(0) == c) {
				gCount++;
			}
			if ("U".charAt(0) == c) {
				uCount++;
			}
		}
		
		return (aCount==uCount && cCount==gCount);
	} 
}
