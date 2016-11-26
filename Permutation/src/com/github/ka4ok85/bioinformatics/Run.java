package com.github.ka4ok85.bioinformatics;

public class Run {

	/*
	 * Return: The total number of permutations of length n, followed by a list of all such permutations (in any order).
	 */
	public static void main(String[] args) {

		// non-recursive approach
		int[] elements = {1,2,3,4};

		System.out.println(Permutation.factorial(elements.length));

		Permutation permutation = new Permutation(elements);
		permutation.generate();


		// recursive approach
		int[] elements2 = {6,5,4,3,2,1};

		System.out.println(PermutationRecursive.factorial(elements2.length));

		PermutationRecursive permutationRecursive = new PermutationRecursive();
		for (int i = 0; i < elements2.length; i++) {
			permutationRecursive.generate(
					elements2[i], 
					PermutationRecursive.removeElement(elements2, elements2[i]),
					""

			);
		}
	}

}
