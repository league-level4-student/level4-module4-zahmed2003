package quadraticSieve;

import java.util.ArrayList;

class GFG {

	public int[] mod2(int n, ArrayList<Integer> base) {
		int[] factors = new int[base.size()];

		for (int i = 0; i < factors.length; i++) {
			factors[i] = 0;
		}

		for (int i = 0; i < base.size(); i++) {
			while (n % base.get(i) == 0) {
				factors[i] += 1;
				n = n / base.get(i);
			}
		}

		if (n != 1 && n != -1) {
			return null;
		} else {
			for (int i = 0; i < factors.length; i++) {
				factors[i] = factors[i] % 2;
			}

			return factors;
		}
	}

}