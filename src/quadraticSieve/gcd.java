package quadraticSieve;

import java.util.ArrayList;

public class gcd {

	public static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		} else {
			return gcd(b, a % b);
		}
	}

	public static int findA(ArrayList<Integer> x, int n) {
		int a = 1;

		for (Integer i : x) {
			a = a * (i % n);
		}

		return a % n;
	}

	public static int findB(ArrayList<Integer> x, int n) {
		double b = 1;

		for (Integer i : x) {
			b = b * (Math.sqrt(Math.abs(Math.pow(i, 2) - n)) % n);
		}

		return (int) b % n;
	}

}