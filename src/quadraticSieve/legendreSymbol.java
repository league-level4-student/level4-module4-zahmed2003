package quadraticSieve;

import java.math.BigInteger;

public class legendreSymbol {

	public int legendreSymbol(BigInteger n, int p) {

		if (n.mod(BigInteger.valueOf(p)).equals(BigInteger.ZERO)) {
			return 0;
		}

		for (int x = 1; x < p; x++) {
			if ((BigInteger.valueOf(x * x).subtract(n)).mod(BigInteger.valueOf(p)).equals(BigInteger.ZERO)) {
				return 1;
			}
		}

		return -1;
	}

}