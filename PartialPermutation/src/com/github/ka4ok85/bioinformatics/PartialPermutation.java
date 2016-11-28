package com.github.ka4ok85.bioinformatics;

public class PartialPermutation {
	private int n;
	private int k;

	public PartialPermutation(int n, int k) {
		this.n = n;
		this.k = k;
	}
	
	/*
	 * result = n!/(n-k)!
	 */
	public int calculate() {
		int result = 1;
		
		k = n - k;
		for (int i = n; i > k; i--) {
			result = (result * i) % 1000000;
		}
		
		return result;
	}
}
