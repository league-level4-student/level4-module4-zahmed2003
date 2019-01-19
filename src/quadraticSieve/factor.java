package quadraticSieve;

import java.util.ArrayList;
import java.util.Arrays;

public class factor 
{

	public int[][] factor(int n, int b)
	{
		ArrayList<Integer> primes = new SieveOfAtkin().sieve(n+1);
		ArrayList<Integer> factorBase = new ArrayList<Integer>();
		
		factorBase.add(-1);
		
		for(int i = 0; i < primes.size(); i++)
		{
			if(new legendreSymbol().legendreSymbol(n, primes.get(i)) == 1 && primes.get(i) < b) {factorBase.add(primes.get(i));}	
		}
		
		int[][] A = new int[factorBase.size()][factorBase.size() - 1];
		ArrayList<Integer> possible = new ArrayList<Integer>();
		
		int start = (int) Math.floor(Math.sqrt(n));
		int check = 0;
		int count = 1;
		
		
		while(check < factorBase.size() - 1)
		{
			int above = start + count;
			int below = start - count;
			
			int[] aboveF = new GFG().mod2(above*above - n, factorBase);
			int[] belowF = new GFG().mod2(below*below - n, factorBase);
			
			if(aboveF != null)
			{
				for(int i = 0; i < aboveF.length; i++)
				{
					A[i][check] = aboveF[i];
				}
				possible.add(above);
				check++;
			}
			
			if(belowF != null)
			{
				for(int i = 0; i < belowF.length; i++)
				{
					A[i][check] = belowF[i];
				}
				possible.add(below);
				check++;
			}
			
			count++;
			
		}
		
		int[][] findNull = new int[A.length + A[0].length][A[0].length];
		int[][] id = Matrix.identity(A[0].length);
		
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
		
		System.out.println(Arrays.deepToString(t.getArray()).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
		System.out.println("");
		
		t.rref();
		
		return t.getArray();
		
		
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(new factor().factor(87463, 30)).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
	}
	
}
