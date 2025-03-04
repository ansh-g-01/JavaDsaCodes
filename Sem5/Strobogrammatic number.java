import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        String s= "89";
        boolean is=true;
        
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put('6','9');
        map.put('9','6');
        map.put('8','8');
        map.put('1','1');
        map.put('0','0');
        
        
        int l=0;
        int r= s.length()-1;
        while(l<=r)
        {
            if(!map.containsKey(s.charAt(l)))
            {
                is=false;
                break;
            }
            if(map.get(s.charAt(l))!=s.charAt(r))
            {
                is=false;
                break;
            }
            l++;
            r--;
        }
    
     System.out.print(is);  
    }
}   

