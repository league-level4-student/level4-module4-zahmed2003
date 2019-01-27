package quadraticSieve;

import java.math.BigInteger;
import java.util.ArrayList;

class GFG{ 


public BigInteger[] mod2(BigInteger n, ArrayList<BigInteger> base)  
{ 
	BigInteger[] factors = new BigInteger[base.size()];
	
	for(int i = 0; i < factors.length; i++) {factors[i] = BigInteger.ZERO;}
	
	for(int i = 0; i < base.size(); i++)
	{
		while(n.mod(base.get(i)) == BigInteger.ZERO) 
		{
			factors[i].add(BigInteger.ONE);
			n = n.divide(base.get(i));
			
		}
	}
	
	if(n.compareTo(BigInteger.ONE) != 0) {return null;}
	else 
	{
		for(int i = 0; i < factors.length; i++)
		{
			factors[i] = factors[i].mod(BigInteger.valueOf(2));
		}
		
		return factors;
	}
}


}