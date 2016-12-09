package com.github.ka4ok85.bioinformatics;

import java.math.BigInteger;

/*
 * The total possible number of perfect matchings of basepair edges in the bonding graph of s.
 */
public class Run {

	public static void main(String[] args) {
		PerfectMatchings perfectMatchings = new PerfectMatchings();
		BigInteger result = perfectMatchings.calculateCounts("AUCUCAUGCAAAUCCGCAAACGGUGAUUGGUAACGGGCUCGUGUAUCCAGAGUAUUCACCCGCAACUAGUCUUGGUAG");
		System.out.println(result);
	}
}
