package quadraticSieve;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Matrix 
{
	BigInteger[][] m;
	
	public Matrix(BigInteger[][] m)
	{
		this.m = m;
	}
	
	public void transpose()
	{
		BigInteger[][] t = new BigInteger[m[0].length][m.length];
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[i].length; j++)
			{
				t[j][i] = m[i][j];
			}
		}
		
		m = t;
	}
	
	public void switchRows(int rowA, int rowB) {
			BigInteger tmpRow[] = m[rowA];
		   m[rowA] = m[rowB];
		   m[rowB] = tmpRow;
		}
	
	public void rref()
	{
		int i = 0;
		int j = 0;
		boolean check = false;
		
		System.out.println(Arrays.deepToString(m).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
		System.out.println("");
		
		while(i < m.length && j < m[i].length)
		{
			while (m[i][j].compareTo(BigInteger.ZERO) == 0)
			{
				for(int k = i+1; k < m.length; k++)
				{
					if(m[k][j].compareTo(BigInteger.ONE) == 0) 
					{
						switchRows(i, k); 
						check = true;
						
						System.out.println(Arrays.deepToString(m).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
						System.out.println("");
						
						break;
					}
				}
				if(check != true) {j++;}
				if(check) {check = false;}
				
			}
			
			for(int k = 0; k < m.length; k++)
			{
				if(k != i && m[k][j].compareTo(BigInteger.ONE) == 0)
				{
					for(int l = 0; l < m[0].length; l++)
					{
						m[k][l] = m[k][l].add(m[i][l]).mod(BigInteger.valueOf(2));
					}
					System.out.println(Arrays.deepToString(m).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
					System.out.println("");
				}
			}
			
			i++;
			j++;
		}
			
	}
	
	
	
	public static BigInteger[][] identity(int n)
	{
		BigInteger[][] id = new BigInteger[n][n];
		
		for(int i = 0; i < id.length; i++)
		{
			for(int j = 0; j < id[i].length; j++)
			{
				if(i == j) {id[i][j] = BigInteger.ONE;}
				else {id[i][j] = BigInteger.ZERO;}
			}
		}
		
		return id;
	}
	
	public BigInteger[][] getArray()
	{
		return m;
	}
	
	
	
}
