package quadraticSieve;

import java.math.BigInteger;
import java.util.ArrayList;

public class gcd 
{

	public static BigInteger gcd(BigInteger a, BigInteger b)
	{
		if(a.mod(b).compareTo(BigInteger.ZERO) == 0) {return b;}
		else {return gcd(b, a.mod(b));}
	}
	
	public static BigInteger findA(ArrayList<BigInteger> x, BigInteger n)
	{
		BigInteger a = BigInteger.ONE;
		
		for(BigInteger i: x)
		{
			a = a.multiply((i.mod(n)));
		}
		
		return a.mod(n);
	}
	
	public static BigInteger findB(ArrayList<BigInteger> x, BigInteger n)
	{
		BigInteger b = BigInteger.ONE;
		
		for(BigInteger i: x)
		{
			b = b.multiply(floorRoot(i.pow(2).subtract(n)).mod(n));
		}
		
		
		return b.mod(n);
	}
	
	public static BigInteger floorRoot(BigInteger n)
	{
		BigInteger guess;
		if(getDigitCount(n)%2 == 0) {guess = BigInteger.valueOf(6).multiply(BigInteger.valueOf(10).pow((getDigitCount(n) - 2)/2));}
		else {guess = BigInteger.valueOf(2).multiply(BigInteger.valueOf(10).pow((getDigitCount(n) - 1)/2));}
		
		while(guess.multiply(guess).subtract(n).abs().compareTo(guess.subtract(BigInteger.ONE).multiply(guess.subtract(BigInteger.ONE)).subtract(n).abs()) > 0 )
		{
			guess.add(guess.add(n.divide(guess)));
		}
		
		return guess;
	}
	
	public static int getDigitCount(BigInteger n)
	{
		double factor = Math.log(2)/Math.log(10);
		int digitCount = (int) (factor * n.bitCount() + 1);
		if(BigInteger.TEN.pow(digitCount - 1).compareTo(n) > 0) {return digitCount - 1;}
		return digitCount;
	}
	
}
