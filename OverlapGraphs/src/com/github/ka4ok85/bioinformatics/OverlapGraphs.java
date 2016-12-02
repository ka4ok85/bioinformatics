package com.github.ka4ok85.bioinformatics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OverlapGraphs {

	private HashMap<String, String> nodesList = new HashMap<String, String>();
	
	// reads FASTA data into HashMap
	public void readFile() {
		String filePath = "D:\\overlapgraph.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			String key = "";
			String value = "";
			while ((line = br.readLine()) != null) {
				if (line.substring(0, 1).equals(">")) {
					if (value.equals("") == false) {
						nodesList.put(key, value);
						value = "";
					}

					key = line;
				} else {
					value = value + line;
				}
			}

			nodesList.put(key, value);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		HashMap<String, ArrayList<String>> suffixesList = new HashMap<String, ArrayList<String>>();
		String suffix = "";
		ArrayList<String> descriptionLines;
		// build unique suffixes list
		for (Map.Entry<String, String> entry : nodesList.entrySet()) {
			suffix = entry.getValue().substring(entry.getValue().length()-3, entry.getValue().length());
			if (suffixesList.containsKey(suffix)) {
				descriptionLines = suffixesList.get(suffix);
			} else {
				descriptionLines = new ArrayList<String>();
			}
				
			descriptionLines.add(entry.getKey());
			suffixesList.put(suffix, descriptionLines);
		}
			
		String prefix;
		// compare prefix and suffixes list
		for (Map.Entry<String, String> entry : nodesList.entrySet()) {
			prefix = entry.getValue().substring(0, 3);
			if (suffixesList.containsKey(prefix)) {
				for (String description : suffixesList.get(prefix)) {
					if (description.equals(entry.getKey()) == false) {
						System.out.println(description.substring(1) + " " + entry.getKey().substring(1));
					}
				}
			}
		}
	}

}
