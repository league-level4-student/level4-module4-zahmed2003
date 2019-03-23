package quadraticSieve;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class factor {

	public List<BigInteger> quadSieve(BigInteger n, int b, int numAddToMatrix) {

		ArrayList<BigInteger> one = new ArrayList<BigInteger>();
		one.add(BigInteger.ONE);

		ArrayList<Integer> primes = new SieveOfAtkin().sieve(b + 1);
		ArrayList<Integer> factorBase = new ArrayList<Integer>();
		ArrayList<BigInteger> factors = new ArrayList<BigInteger>();
		factorBase.add(2);

		while (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
			n = n.divide(BigInteger.valueOf(2));
			factors.add(BigInteger.valueOf(2));
		}

		System.out.println("Finding factor base");

		for (int i = 1; i < primes.size(); i++) {
			if (new legendreSymbol().legendreSymbol(n, primes.get(i)) == 1) {
				factorBase.add(primes.get(i));
			}
		}

		int[][] A = new int[factorBase.size()][factorBase.size() + numAddToMatrix];
		ArrayList<BigInteger> possible = new ArrayList<BigInteger>();

		int check = 0;
		BigInteger countCheck = BigInteger.ZERO;
		BigInteger count = BigSqrt.sqrt(n);

		// System.out.println(factorBase);

		System.out.println("Beginning sieve");
		List<BigInteger> perfectSquare = sieve(check, numAddToMatrix, countCheck, factors, count, factorBase, possible, n, A);
		if(perfectSquare!= null) {
			return perfectSquare;
		}
		// System.out.println(possible);
		System.out.println("Establishing Linear Dependencies");

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

				ArrayList<BigInteger> temp = new ArrayList<BigInteger>();
				for (int k = 0; k < values.length; k++) {
					if (values[k] == 1) {
						temp.add(possible.get(k));
					}
				}

				BigInteger f1 = gcd.gcd(gcd.findA(temp, n).add(gcd.findB(temp, n)), n).abs();
				BigInteger f2 = gcd.gcd(gcd.findA(temp, n).subtract(gcd.findB(temp, n)), n).abs();

				factors.add(f1);
				factors.add(f2);

				return factors;

			}

		}

		return null;

	}

	int[] getColumn(int[][] matrix, int column) {
		return IntStream.range(0, matrix.length).map(i -> matrix[i][column]).toArray();
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(new factor().quadSieve(new BigInteger("12345678901234567890"), 10000, -1));
		long endTime = System.nanoTime();
		System.out.println("Time taken: " + ((double) endTime - startTime) / 1000000000 + " seconds");
	}
//			if (countCheck.mod(new BigInteger("10000")).compareTo(BigInteger.ZERO) == 0) {
//				System.out.println(countCheck + " values checked and " + check + "/"
//						+ (factorBase.size() + numAddToMatrix) + " values found");
//			}

	public List<BigInteger> sieve(int check, int numAddToMatrix, BigInteger countCheck, List<BigInteger> factors,
			BigInteger count, ArrayList<Integer> factorBase, ArrayList<BigInteger> possible, BigInteger n, int[][] A) {
		while (check < factorBase.size() + numAddToMatrix) {
			if (isPerfectSquare(n, count)) {
				factors.add(count);
				factors.add(count);
				return factors;
			}
			int[] aboveF = new GFG().mod2(count.multiply(count).subtract(n), factorBase);
		
			if (aboveF != null) {
				
				for (int i = 0; i < aboveF.length; i++) {
					A[i][check] = aboveF[i];
				}
				possible.add(count);
				check++;
			}

			count = count.add(BigInteger.ONE);
			countCheck = countCheck.add(BigInteger.ONE);

		}
		return null;
	}
	
	boolean isPerfectSquare(BigInteger n, BigInteger count) {
		return count.multiply(count).subtract(n).compareTo(BigInteger.ZERO) == 0;
	}

}
