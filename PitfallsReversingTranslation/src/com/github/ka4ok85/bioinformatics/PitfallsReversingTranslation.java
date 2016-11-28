package com.github.ka4ok85.bioinformatics;

import java.util.HashMap;
import java.util.Map.Entry;

public class PitfallsReversingTranslation {
	public static HashMap<String, String> dnaTable;
    static
    {
    	dnaTable = new HashMap<String, String>();
    	dnaTable.put("GCT", "A");
    	dnaTable.put("GCC", "A");
    	dnaTable.put("GCA", "A");
    	dnaTable.put("GCG", "A");
    	
    	dnaTable.put("CGT", "R");
    	dnaTable.put("CGC", "R");
    	dnaTable.put("CGA", "R");
    	dnaTable.put("CGG", "R");
    	dnaTable.put("AGA", "R");
    	dnaTable.put("AGG", "R");
    	
    	dnaTable.put("AAT", "N");
    	dnaTable.put("AAC", "N");
    	
    	dnaTable.put("GAT", "D");
    	dnaTable.put("GAC", "D");

    	dnaTable.put("TGT", "C");
    	dnaTable.put("TGC", "C");
 
    	dnaTable.put("CAA", "Q");
    	dnaTable.put("CAG", "Q");

    	dnaTable.put("GAA", "E");
    	dnaTable.put("GAG", "E");

    	dnaTable.put("GGT", "G");
    	dnaTable.put("GGC", "G");
    	dnaTable.put("GGA", "G");
    	dnaTable.put("GGG", "G");
    	
    	dnaTable.put("CAT", "H");
    	dnaTable.put("CAC", "H");
    	
    	dnaTable.put("ATT", "I");
    	dnaTable.put("ATC", "I");    	
    	dnaTable.put("ATA", "I");
    	
    	dnaTable.put("ATG", "START");
    	
    	dnaTable.put("TTA", "L");
    	dnaTable.put("TTG", "L");
    	dnaTable.put("CTT", "L");
    	dnaTable.put("CTC", "L");
    	dnaTable.put("CTA", "L");
    	dnaTable.put("CTG", "L");
    	
    	dnaTable.put("AAA", "K");
    	dnaTable.put("AAG", "K");    	
    	
    	dnaTable.put("ATG", "M");

    	dnaTable.put("TTT", "F");
    	dnaTable.put("TTC", "F");
    	
    	dnaTable.put("CCT", "P");
    	dnaTable.put("CCC", "P");
    	dnaTable.put("CCA", "P");
    	dnaTable.put("CCG", "P");    	
    	
    	dnaTable.put("TCT", "S");
    	dnaTable.put("TCC", "S");
    	dnaTable.put("TCA", "S");
    	dnaTable.put("TCG", "S");
    	dnaTable.put("AGT", "S");
    	dnaTable.put("AGC", "S");

    	dnaTable.put("ACT", "T");
    	dnaTable.put("ACC", "T");
    	dnaTable.put("ACA", "T");
    	dnaTable.put("ACG", "T");    	

    	dnaTable.put("TGG", "W");  
    	
    	dnaTable.put("TAT", "Y");
    	dnaTable.put("TAC", "Y");
    	
    	dnaTable.put("GTT", "V");
    	dnaTable.put("GTC", "V");
    	dnaTable.put("GTA", "V");
    	dnaTable.put("GTG", "V"); 
    	
    	dnaTable.put("TAA", "STOP");
    	dnaTable.put("TGA", "STOP");
    	dnaTable.put("TAG", "STOP");    	
    }
    
    public int calculate(String input) {
    	int result = 1;
    	
    	HashMap<String, Integer> codonCounts = new HashMap<String, Integer>();
    	for (Entry<String, String> entry : dnaTable.entrySet()) {
    		if (codonCounts.containsKey(entry.getValue())) {
    			codonCounts.replace(entry.getValue(), codonCounts.get(entry.getValue()), codonCounts.get(entry.getValue()) + 1);
    		} else {
    			codonCounts.put(entry.getValue(), 1);
    		}
		}
    	
    	// calculate all possible variants
    	for (int i = 0; i < input.length(); i++) {
            result = result * codonCounts.get(String.valueOf(input.charAt(i)));
        	// apply mod 1M in order to prevent int overflow
            result = result % 1000000;
        }

    	// take in consideration 3 different codons for STOP code
    	result = result * 3;
    	
    	// apply mod 1M
    	result = result % 1000000;
    	
    	return result;
    }
}
