import java.util.Scanner;
import java.util.Arrays;

public class Main
{
    public static void main(String args[])
    {
        Scanner input= new Scanner(System.in);
        int n=input.nextInt();
        boolean[] sieve = new boolean[n+1];
        Arrays.fill(sieve,true);
        for(int i=2;i<n;i++)
        {
            if(sieve[i])
            {
                for(int j=i+i;j<=n;j=j+i)
                {
                    sieve[j]=false;
                }
            }
        }
        
        for(int i=2;i<=n;i++)
        {
            if(sieve[i])
            {
                System.out.print(i+" ");
            }
        }
    }
}