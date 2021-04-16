
/**
 * Fibonacci class responsible for the constructor of Fibonacci objects, calculating the
 * Fibonacci Value for a given number, as well as retrieving the fibonacci value from a given 
 * number's object
 *
 * @author Tristan McGinnis
 * @version 1/13/21
 */
public class Fibonacci
{
    private int value;
   public Fibonacci(int x)
   {
      if (x == 0){
         x = 0;  
        }else if (x == 1 || x == 2){
         x = 1;   
        }else{
         x = calcFibonacci(x-1)+calcFibonacci(x-2);   
        }  
        value = x;
    }
    
    
    public int calcFibonacci(int x ){
    if (x == 0){
         return 0;  
        }else if (x == 1 || x == 2){
         return 1;   
        }else{
         return calcFibonacci(x-1)+calcFibonacci(x-2);   
        }      
    }
    
    public int getFibValue(){
        return value;   
    }
}
