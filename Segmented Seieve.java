import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        int u=75;
        int l=25;
        int sqrtlimit=(int) Math.sqrt(u); // To set limit as square toot of the number  
        ArrayList<Integer> primes = new ArrayList<>();// Array to store the prime numbers from 1 to srt of n 
        
        boolean[] isprime= new boolean[sqrtlimit+1]; // boolean list to find prime numbers till 1 to sqrt of that number
        Arrays.fill(isprime,true);// Marks all numbers from 1 to root(n) as prime




        //Running Simple seive from 1 to squareroot(n) to find out prime numbers in that range and add them primes list
        
        for(int i=2;i<sqrtlimit;i++)
        {
            if(isprime[i])
            {
                primes.add(i);
                for(int p=i*i;p<sqrtlimit;p+=i)
                {
                    isprime[p]=false;
                }
            }
        }
        boolean[] primesList= new boolean[u-l+2];



            
       Arrays.fill(primesList,true);
       for(int p:primes)

       {
           int start= (int) (Math.ceil((double) l/p)) *p;
           for(int i=start;i<=u;i+=p)
           {
                primesList[i-l]=false;
           }
           
       }
       //Code to print list of prime numbers
       for(int i=l;i<=u;i++)
       {
          if(primesList[i-l])
          {
              System.out.print(i+" ");
          }
       }
        
        
    }
}
