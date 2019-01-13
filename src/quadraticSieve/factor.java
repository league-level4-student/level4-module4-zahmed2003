package quadraticSieve;

import java.util.ArrayList;

public class factor 
{

	public ArrayList<Integer> factor(int n)
	{
		ArrayList<Integer> primes = new SieveOfAtkin().sieve(n+1);
		ArrayList<Integer> factorBase = new ArrayList<Integer>();
		
		for(int i = 0; i < primes.size(); i++)
		{
			if(new legendreSymbol().legendreSymbol(n, primes.get(i)) == 1) {factorBase.add(primes.get(i));}
		}
		
	}
	
}
