package quadraticSieve;

import java.math.BigInteger;

public class BigSqrt {

	public static BigInteger sqrt(BigInteger number) {

		BigInteger squareRoot = number.divide(BigInteger.valueOf(2));

		do {
			squareRoot = (squareRoot.add(number.divide(squareRoot))).divide(BigInteger.valueOf(2));

		} while (number.subtract(squareRoot.multiply(squareRoot)).abs()
				.compareTo(number
						.subtract(squareRoot.subtract(BigInteger.ONE).multiply(squareRoot.subtract(BigInteger.ONE)))
						.abs()) > 0);

		return squareRoot;
	}
	
}
