package com.github.ka4ok85.bioinformatics;

/*
 * The total number of noncrossing perfect matchings of basepair edges in the bonding graph of s, modulo 1,000,000.
 */
public class Run {

	public static void main(String[] args) {
		CatalanNumbers catalanNumbers = new CatalanNumbers();
		Long result = catalanNumbers.calculate("GCAUGCAU");

		System.out.println(result);
	}

}
