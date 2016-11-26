package com.github.ka4ok85.bioinformatics;

public class Run {
	
	/*
	 * Return: The total number of signed permutations (-1 -2,-1 2,1 -2,1 2,-2 -1,-2 1,2 -1,2 1) of length n, followed by a list of all such permutations
	 */
	public static void main(String[] args) {
		
		// non-recursive approach
		int[] elements = {-4,-3,-2,-1,1,2,3,4};

		//System.out.println(SignedPermutation.getSignedPermutationsCount(4));

		//SignedPermutation permutation = new SignedPermutation(elements);
		//permutation.generate();


		// recursive approach
		int[] elements2 = {5,4,3,2,1};

		System.out.println(SignedPermutationRecursive.getSignedPermutationsCount(elements2.length));

		SignedPermutationRecursive signedPermutation = new SignedPermutationRecursive();
		for (int i = 0; i < elements2.length; i++) {
			signedPermutation.generate(
					elements2[i], 
					SignedPermutationRecursive.removeElement(elements2, elements2[i]),
					""
			);
			
			signedPermutation.generate(
					-1*elements2[i], 
					SignedPermutationRecursive.removeElement(elements2, elements2[i]),
					""
			);
		}
	}
}
