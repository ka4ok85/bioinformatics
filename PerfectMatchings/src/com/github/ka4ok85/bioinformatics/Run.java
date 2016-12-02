package com.github.ka4ok85.bioinformatics;

public class Run {

	public static void main(String[] args) {
		PerfectMatchings perfectMatchings = new PerfectMatchings();
		perfectMatchings.buildEdges();
		perfectMatchings.generate(perfectMatchings.getNodes(), perfectMatchings.getEdges(), 1, 0, "");

		System.out.println(perfectMatchings.getCount());
	}

}
