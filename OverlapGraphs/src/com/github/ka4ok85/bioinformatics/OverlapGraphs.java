package com.github.ka4ok85.bioinformatics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OverlapGraphs {

	public void run() {
		
		HashMap<String, String> nodesList = new HashMap<String, String>();
		
		HashMap<String, ArrayList<String>> suffixesList = new HashMap<String, ArrayList<String>>();
		
		
		
		String filePath = "C:\\files\\data\\overlapgraph.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			String key = "";
			Boolean isKey = true;
			
			while ((line = br.readLine()) != null) {
		        //System.out.println(line);
		        if (isKey == false) {
		        	nodesList.put(key, line);
		        	isKey = true;
		        } else {
			        key = line.substring(1);
		        	isKey = false;
		        	
		        	
		        }
		    }

			for (Map.Entry<String, String> entry : nodesList.entrySet()) {
				// can be used for duplicates check
//System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			}
			
			String suffix = "";
			ArrayList<String> descriptionLines;
			for (Map.Entry<String, String> entry : nodesList.entrySet()) {
				suffix = entry.getValue().substring(entry.getValue().length()-3, entry.getValue().length());
				//System.out.println(suffix);
				
				if (suffixesList.containsKey(suffix)) {
					descriptionLines = suffixesList.get(suffix);
				} else {
					descriptionLines = new ArrayList<String>();
				}
				
				descriptionLines.add(entry.getKey());
				
				suffixesList.put(suffix, descriptionLines);
			}
			

			for (Map.Entry<String, ArrayList<String>> entry : suffixesList.entrySet()) {
				//System.out.println(entry.getKey());
				//System.out.println(entry.getValue());
			}
			
//System.out.println("-------");
			String prefix;
			for (Map.Entry<String, String> entry : nodesList.entrySet()) {
				// can be used for duplicates check
				//System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				prefix = entry.getValue().substring(0, 3);
				//System.out.println(prefix);
				if (suffixesList.containsKey(prefix)) {
					

					
					for (String description : suffixesList.get(prefix)) {
						if (description.equals(entry.getKey()) == false) {
							System.out.println(description + " " + entry.getKey());
						}
					}
					//System.out.println(entry.getKey() + " " + suffixesList.get(prefix));
				}
				
				
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		

		
	}
}
