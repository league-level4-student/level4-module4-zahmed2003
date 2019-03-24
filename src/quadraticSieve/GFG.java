package quadraticSieve;

import java.math.BigInteger;
import java.util.ArrayList;

class GFG {

	public static int[] mod2(BigInteger bigInteger, ArrayList<Integer> base) {
		int[] factors = new int[base.size()];

		for (int i = 0; i < base.size(); i++) {
			while (bigInteger.mod(BigInteger.valueOf(base.get(i))).equals(BigInteger.ZERO)) {
				factors[i] += 1;
				bigInteger = bigInteger.divide(BigInteger.valueOf(base.get(i)));
			}
		}

		if (bigInteger.equals(BigInteger.ONE) == false) {
			return null;
		} else {
			for (int i = 0; i < factors.length; i++) {
				factors[i] = factors[i] % 2;
			}

			return factors;
		}
	}

}