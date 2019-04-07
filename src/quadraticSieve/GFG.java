package quadraticSieve;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

class GFG {

	public static Object[] mod2(BigInteger bigInteger, ArrayList<Integer> base) {
		//int[] factors = new int[base.size()];
		
		HashMap<Integer, Integer> factors = new HashMap<Integer, Integer>();

		for (int i = base.size() - 1; i >= 0; i--) {
			factors.put(i,0);
			while (bigInteger.mod(BigInteger.valueOf(base.get(i))).equals(BigInteger.ZERO)) {
				factors.put(i, factors.get(i)==0? 1:0);
				bigInteger = bigInteger.divide(BigInteger.valueOf(base.get(i)));
			}
		}

		if (bigInteger.compareTo(BigInteger.ONE) != 0) {
			return null;
		} 
		
		return factors.values().toArray();
		
	}

}