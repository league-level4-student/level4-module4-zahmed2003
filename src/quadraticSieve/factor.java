package quadraticSieve;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class factor 
{

	public ArrayList<BigInteger> quadSieve(BigInteger n, BigInteger b)
	{
		
		
		
		ArrayList<BigInteger> primes = new Sieve().sieve(b.add(BigInteger.ONE));
		ArrayList<BigInteger> factorBase = new ArrayList<BigInteger>();
		ArrayList<BigInteger> factors = new ArrayList<BigInteger>();
		
		
		
		while(n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) {n = n.divide(BigInteger.valueOf(2));}
		
		
		for(int i = 1; i < primes.size(); i++)
		{
			if(new legendreSymbol().legendreSymbol(n, primes.get(i)) == 1) {factorBase.add(primes.get(i));}	
		}
		
		
		
		BigInteger[][] A = new BigInteger[factorBase.size()][factorBase.size() - 1];
		ArrayList<BigInteger> possible = new ArrayList<BigInteger>();
		
		BigInteger start = BigInteger.ONE;
		BigInteger check = BigInteger.ZERO;
		BigInteger count = BigInteger.ONE;
		
		
		while(check.compareTo(BigInteger.valueOf(factorBase.size() - 1)) < 0)
		{
			BigInteger above = start.add(count);
			
			BigInteger[] aboveF = new GFG().mod2(above.multiply(above).subtract(n), factorBase);
			
			if(aboveF != null)
			{
				for(int i = 0; i < aboveF.length; i++)
				{
					A[i][check.intValueExact()] = aboveF[i];
				}
				possible.add(above);
				check.add(BigInteger.ONE);
			}
			
			count.add(BigInteger.ONE);
			
		}
		
		BigInteger[][] findNull = new BigInteger[A.length + A[0].length][A[0].length];
		BigInteger[][] id = Matrix.identity(A[0].length);
		
		for(int i = 0; i < A.length; i++)
		{
			for(int j = 0; j < A[i].length; j++)
			{
				findNull[i][j] = A[i][j];
			}
		}
		
		for(int i = 0; i < id.length; i++)
		{
			for(int j = 0; j < id[i].length; j++)
			{
				findNull[i + A.length][j] = id[i][j];
			}
		}
		
		
		
		Matrix t = new Matrix(findNull);
		t.transpose();
		
		t.rref();
		
		t.transpose();
		
		findNull = t.getArray();
		BigInteger[] values = null;
		
		for(int i = 0; i < findNull[0].length; i++)
		{
			BigInteger[] column = getColumn(findNull, i);
			BigInteger[] subColumn = Arrays.copyOfRange(column, 0, findNull.length - possible.size());

			int numZeroes = 0;
			
			for(int j = 0; j < subColumn.length; j++)
			{
				if(subColumn[j].compareTo(BigInteger.ZERO) == 0) {numZeroes++;}
			}
			
			if(numZeroes == subColumn.length)
			{
				
				
				values = Arrays.copyOfRange(column, findNull.length - possible.size(), findNull.length);
				
				ArrayList<BigInteger> temp = new ArrayList<BigInteger>();
				for(int k = 0; k < values.length; k++)
				{
					if(values[k].compareTo(BigInteger.ONE) == 0) {temp.add(possible.get(k));}
				}
				
				factors.add(gcd.gcd(gcd.findA(temp, n).add(gcd.findB(temp, n)).abs(), n));
				factors.add(gcd.gcd(gcd.findA(temp, n).subtract(gcd.findB(temp, n)).abs(), n));
				factors.add(null);
				
				System.out.println(factors);
				
			}
			
			
		}
		
		return factors;
		
	}
	
	BigInteger[] getColumn(BigInteger[][] matrix, int column) {
		BigInteger[] col = new BigInteger[matrix.length];
	   for(int i = 0; i < matrix.length; i++) {col[i] = matrix[i][column];}
	   
	   return col;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new factor().quadSieve(BigInteger.valueOf(8764), BigInteger.valueOf(30)));
	}
	
}
