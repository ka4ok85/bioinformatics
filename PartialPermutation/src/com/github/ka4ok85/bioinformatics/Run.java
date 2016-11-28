package com.github.ka4ok85.bioinformatics;

public class Run {

	/*
	 * Return: The total number of partial permutations P(n,k), modulo 1,000,000.
	 */
	public static void main(String[] args) {
		int n = 90;
		int k = 8;
		
		PartialPermutation partialPermutation = new PartialPermutation(n, k);
		int result = partialPermutation.calculate();
		
		System.out.println(result);

	}

}
