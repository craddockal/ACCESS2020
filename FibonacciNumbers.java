
/**
 * This class is meant to find the fibonacci number of a value, this class has 1 method and 1 private variable.
 *
 * @author: Daniel Anthony Holden Jones. 
 * @version: 1/21/2021
 */
public class FibonacciNumbers
{
    //Private variables.
    private int userNum;
    /**
     * Constructor for the object fiboNum which is used for user input.
     * @param n1. assigns this value to private variable userNum.
     */
    FibonacciNumbers(int n1)
    {
        userNum =n1;
    }
    
    /**
     * Mutator method to find a fibonacci number using user input.
     * @param userNum.
     * @return the same method but using userNum-1 + another sum of the method but the parameteris userNum - 2.
     * 
     */
    public  int calculations(int userNum)
    {
        
          if (userNum == 0) {
			return 0;
		}
	  if (userNum == 1 || userNum == 2) {
			return 1;
		}
	  return calculations(userNum-1) + calculations(userNum-2);
         
        
    }
}
