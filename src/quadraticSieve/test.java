package quadraticSieve;

import java.math.BigInteger;
import java.util.ArrayList;

public class test 
{

	public static int gcd(int a, int b)
	{
		if(a%b == 0) {return b;}
		else {return gcd(b, a%b);}
	}
	
	public static BigInteger findB(ArrayList<Integer> x)
	{
		BigInteger b = BigInteger.ONE;
		for(int i = 0; i < x.size(); i++)
		{
			b = b.multiply(BigInteger.valueOf((long) Math.sqrt(Math.pow(x.get(i), 2) - 87463)));
		}
		
		
		return b;
	}
	
	public static BigInteger findA(ArrayList<Integer> x)
	{
		BigInteger a = BigInteger.ONE;
		for(int i = 0; i < x.size(); i++)
		{
			a = a.multiply(BigInteger.valueOf(x.get(i)));
		}
		
		return a;
	}
	
	
	public static void main(String[] args) 
	{
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(307);
		x.add(278);
		x.add(316);
		x.add(265);
		
		System.out.println(findB(x));
		
	}
	
	
	
}
