package quadraticSieve;

import java.util.ArrayList;

public class SieveOfAtkin {

	public ArrayList<Integer> sieve(int limit) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		if (limit > 2)
			primes.add(2);

		if (limit > 3)
			primes.add(3);

		boolean sieve[] = new boolean[limit + 1];

		for (int i = 0; i < limit + 1; i++) {
			sieve[i] = false;
		}

		for (int x = 1; x * x < limit; x++) {
			for (int y = 1; y * y < limit; y++) {

				int n = (4 * x * x) + (y * y);
				if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
					sieve[n] ^= true;
				}

				n = (3 * x * x) + (y * y);
				if (n <= limit && n % 12 == 7) {
					sieve[n] ^= true;
				}

				n = (3 * x * x) - (y * y);
				if (x > y && n <= limit && n % 12 == 11) {
					sieve[n] ^= true;
				}
			}
		}

		for (int r = 5; r * r < limit; r++) {
			if (sieve[r]) {
				for (int i = r * r; i < limit; i += r * r)
					sieve[i] = false;
			}
		}

		for (int a = 5; a < limit; a++)
			if (sieve[a])
				primes.add(a);
		return primes;
	}

	public int numPrime(int limit) {
		return sieve(limit + 1).size();
	}
}
