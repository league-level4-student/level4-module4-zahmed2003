package quadraticSieve;

import java.math.BigInteger;
import java.util.ArrayList;

public class gcd {

	public static BigInteger gcd(BigInteger a, BigInteger b) {
		if (a.mod(b).equals(BigInteger.ZERO)) {
			return b;
		} else {
			return gcd(b, a.mod(b));
		}
	}

	public static BigInteger findA(ArrayList<BigInteger> temp, BigInteger n) {
		BigInteger a = BigInteger.ONE;

		for (BigInteger i : temp) {
			a = a.multiply(i);
		}

		return a.mod(n);
	}

	public static BigInteger findB(ArrayList<BigInteger> x, BigInteger n) {
		BigInteger b = BigInteger.ONE;

		for (BigInteger i : x) {
			b = b.multiply((i.pow(2).subtract(n)));
		}
		
		b = BigSqrt.sqrt(b);
		

		return b.mod(n);
	}

}