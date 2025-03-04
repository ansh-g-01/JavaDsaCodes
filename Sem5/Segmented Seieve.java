//Time complexity -  O(N)

import java.util.Scanner;
import java.util.Arrays;

public class Main
{
    public static void main(String args[])
    {
        Scanner input= new Scanner(System.in);//make scanner object to take input
        int n=input.nextInt();//take input from user
        //intialisation
        int sqrt=(int) Math.sqrt(n);
        boolean[] sieve = new boolean[sqrt+1];
        boolean[] prime_array = new boolean[n+1];
        Arrays.fill(prime_array,true);
        Arrays.fill(sieve,true);
        ///////



        //Finding prime numbers till square root of N , using simple sieve
        for(int i=2;i<=sqrt;i++)
        {
            if(sieve[i])
            {
                for(int j=i+i;j<=sqrt;j=j+i)
                {
                    sieve[j]=false;
                }
            }
        }
        

        //With help of prime numbers tills sqrt of n , eliminate all composites till N
        for(int i=2;i<=sqrt;i++)
        {
            if(sieve[i])
            {
                for(int j=i+i;j<=n;j=j+i)
                {
                    prime_array[j]=false;
                }
            }
        }
        
        //Print the prime numbers
        for(int i=2;i<=n;i++)
        {
            if(prime_array[i])
            {
                System.out.print(i+" ");
            }
        }
    }
}