import java.util.*;
import java.math.*;
public class Hello {

    public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
	    String inputString = sc.next();
	    int stringlength = inputString.length();
	 
	    System.out.println(factorial(stringlength).divide(duplicateStringsCount(inputString)));
	}
	
	public static BigInteger factorial(int number)
	{
	    BigInteger result = BigInteger.ONE;
	    for(int factor=2;factor<=number;factor++)
	    {
	        result = result.multiply(BigInteger.valueOf(factor));
	    }
	    return result;
	}
	
	public static BigInteger duplicateStringsCount(String inputStr)
	{
	    BigInteger total = BigInteger.ONE;
	    Map<Character,Integer> temp = new HashMap<Character,Integer>();
	    char[] chars = inputStr.toCharArray();
	    for(Character ch:chars)
	    {
	        if(Character.isLetter(ch)&&(!Character.isSpaceChar(ch)))
	        {
	        if(temp.containsKey(ch))
	            temp.put(ch,temp.get(ch)+1);
	        else
	            temp.put(ch,1);
	        }
	    }
	    
	    Set<Character> keys = temp.keySet();
	    for(Character ch:keys)
	    {
	        if(temp.get(ch)>1)
	            total = total.multiply(factorial(temp.get(ch)));    
	    }
	    return total;
	}
}
