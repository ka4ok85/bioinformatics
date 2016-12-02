package com.github.ka4ok85.bioinformatics;

import java.util.HashMap;
import java.util.List;

public class Run {

	public static void main(String[] args) {
//AGCUAGUCAU		
//GGUCGUACAU
//GGUCGAACAGAUCAUUAACAAGUGCCUGCGUCCUGAGUCAAAUUCGCUUCGCCUCGCCUGGACAAGGUGG
		
		PerfectMatchings perfectMatchings = new PerfectMatchings("GGUCGUACAU");
		perfectMatchings.buildEdges();
		perfectMatchings.generate(perfectMatchings.getNodes(), new HashMap<Integer, List<Integer>>(perfectMatchings.getEdges()), 1, 0, "");

		System.out.println(perfectMatchings.getCount());
	}

}
