import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n= input.nextInt();
        int result=n;
        int p;
        for(p=2; p*p<n; p++)
        {
            if(n%p==0)
            {
                while(n%p==0)
                {
                    n=n/p;
                }
            }
            result-=result/p;
        }
        
        if(n>1)
        {
         result-=result/p;   
        }
        System.out.println(result);
    }
}