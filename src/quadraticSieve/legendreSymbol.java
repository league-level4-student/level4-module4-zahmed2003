package quadraticSieve;

import java.math.BigInteger;

public class legendreSymbol {

	public int legendreSymbol(BigInteger a, BigInteger p)
	{
		if(a.mod(p) == BigInteger.ZERO) {return 0;}
		
		for(BigInteger x = BigInteger.ONE; x.compareTo(p) < 0; x = x.add(BigInteger.valueOf(1)))
		{
			if(((x.multiply(x)).subtract(a)).mod(p) == BigInteger.ZERO) {return 1;}
		}
		
		return -1;
	}
	
	
}
