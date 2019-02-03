package quadraticSieve;

public class legendreSymbol {

	public int legendreSymbol(int a, int p) {

		if (a % p == 0) {
			return 0;
		}

		for (int x = 1; x < p; x++) {
			if ((x * x - a) % p == 0) {
				return 1;
			}
		}

		return -1;
	}

}