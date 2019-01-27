package quadraticSieve;

import java.math.BigInteger;
import java.util.ArrayList;

public class Sieve 
{

  public ArrayList<BigInteger> sieve(BigInteger n) {
	  ArrayList<BigInteger> ret = new ArrayList<BigInteger>();
	  
       boolean[] primes = new boolean[(n.add(BigInteger.ONE)).intValueExact()];
       for (int i = 2; i < primes.length; i++) {
           primes[i] = true;
       }
       int num = 2;
       while (true) {
           for (int i = 2;; i++) {
               int multiple = num * i;
               if (BigInteger.valueOf(multiple).compareTo(n) > 0) {
                   break;
               } else {
                   primes[multiple] = false;
               }
           }
           boolean nextNumFound = false;
           for (int i = num + 1; i < (n.add(BigInteger.ONE)).intValueExact(); i++) {
               if (primes[i]) {
                   num = i;
                   nextNumFound = true;
                   break;
               }
           }
           if (!nextNumFound) {
               break;
           }
       }
       for (int i = 0; i < primes.length; i++) {
           if (primes[i]) {
               ret.add(BigInteger.valueOf(i));
           }
       }
       
       return ret;
  }
  
}
