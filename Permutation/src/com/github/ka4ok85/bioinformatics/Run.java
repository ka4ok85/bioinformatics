package com.github.ka4ok85.bioinformatics;

public class Run {

	/*
	 * Return: The total number of permutations of length n, followed by a list of all such permutations (in any order).
	 */
	public static void main(String[] args) {

		int[] elements = {1,2,3,4};

		System.out.println(Permutation.factorial(elements.length));

		Permutation permutation = new Permutation(elements);
		permutation.generate();

	}

}
