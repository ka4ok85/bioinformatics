package com.github.ka4ok85.bioinformatics;

/*
 * Recursive Algorithm implementation
 */
public class PermutationRecursive {

	public void generate(int element, int[] otherElements, String result) {
		if (result.equals("") == false) {
			result = result + " " + element;
		} else {
			result = result + element;
		}

		if (otherElements.length > 0) {
			for (int i = 0; i < otherElements.length; i++) {
				generate(
						otherElements[i], 
						PermutationRecursive.removeElement(otherElements, otherElements[i]),
						result
				);				
			}
		} else {
			System.out.println(result);
		}
	}

	
	public static int[] removeElement(int[] array, int element) {
		int[] resultArray = new int[array.length-1];
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != element) {
				resultArray[j] = array[i];
				j++;
			}
		}

       return resultArray;
	}

    public static int factorial(int n) {
        int ret = 1;
        for (int i = 1; i <= n; ++i) {
        	ret *= i;
        }

        return ret;
    }
}
