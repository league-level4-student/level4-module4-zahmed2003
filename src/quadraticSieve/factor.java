package quadraticSieve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class factor {

	public ArrayList<Integer> quadSieve(int n, int b) {

		ArrayList<Integer> primes = new SieveOfAtkin().sieve(b + 1);
		ArrayList<Integer> factorBase = new ArrayList<Integer>();
		ArrayList<Integer> factors = new ArrayList<Integer>();
		factorBase.add(2);

		System.out.println("Finding factor base");

		for (int i = 1; i < primes.size(); i++) {
			if (new legendreSymbol().legendreSymbol(n, primes.get(i)) == 1) {
				factorBase.add(primes.get(i));
			}
		}

		int[][] A = new int[factorBase.size()][factorBase.size() - 1];
		ArrayList<Integer> possible = new ArrayList<Integer>();

		int check = 0;
		int count = (int) Math.floor(Math.sqrt(n));

		System.out.println("Beginning sieve");

		while (check < factorBase.size() - 1) {

			int[] aboveF = new GFG().mod2(count * count - n, factorBase);

			if (aboveF != null) {
				for (int i = 0; i < aboveF.length; i++) {
					A[i][check] = aboveF[i];
				}
				possible.add(count);
				check++;
			}

			count++;

		}

		System.out.println("Beginning Matrix calculations");
		System.out.println(possible);

		int[][] findNull = new int[A.length + A[0].length][A[0].length];
		int[][] id = Matrix.identity(A[0].length);

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				findNull[i][j] = A[i][j];
			}
		}

		for (int i = 0; i < id.length; i++) {
			for (int j = 0; j < id[i].length; j++) {
				findNull[i + A.length][j] = id[i][j];
			}
		}

		Matrix t = new Matrix(findNull);
		t.transpose();

		t.rref();

		t.transpose();

		findNull = t.getArray();
		int[] values = null;

		for (int i = 0; i < findNull[0].length; i++) {
			int[] column = getColumn(findNull, i);
			int[] subColumn = Arrays.copyOfRange(column, 0, findNull.length - possible.size());

			int numZeroes = 0;
			for (int j = 0; j < subColumn.length; j++) {
				if (subColumn[j] == 0) {
					numZeroes++;
				}
			}

			if (numZeroes == subColumn.length) {
				values = Arrays.copyOfRange(column, findNull.length - possible.size(), findNull.length);

				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (int k = 0; k < values.length; k++) {
					if (values[k] == 1) {
						temp.add(possible.get(k));
					}
				}

				factors = new ArrayList<Integer>();

				factors.add(Math.abs(gcd.gcd(gcd.findA(temp, n) + gcd.findB(temp, n), n)));
				factors.add(Math.abs(gcd.gcd(gcd.findA(temp, n) - gcd.findB(temp, n), n)));
				factors.add(null);

			}

		}

		return factors;

	}

	int[] getColumn(int[][] matrix, int column) {
		return IntStream.range(0, matrix.length).map(i -> matrix[i][column]).toArray();
	}

	public static void main(String[] args) {
		System.out.println(new factor().quadSieve(3580, 30));
	}
}
