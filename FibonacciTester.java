
/**
 * Tester class to create Fibonacci object based on user input as well as 
 * call the necessary mutatorand getter methods from the Fibonacci class.
 *
 * @author Tristan McGinnis
 * @version 1/13/21
 */
import java.util.Scanner;
public class FibonacciTester
{
    public static void start()
    {
        //Take user Input
     Scanner in = new Scanner(System.in); 
     System.out.println();
     System.out.print("Input number to calculate Fibonacci value: ");
     String fibString = "";
     //Interpret the user's input
     
     if(in.hasNextInt()){
         fibString = in.next();
         if(Integer.parseInt(fibString)<0){
             System.out.println("Value entered is not \"q\" or a positive integer");
             start();
            }else{
             int fib = Integer.parseInt(fibString);
             Fibonacci Choice = new Fibonacci(fib);
             fib = Choice.getFibValue();
             System.out.println("Fibonacci Value: "+fib);
             start();  
            }
        }else if(in.next().equals("q")){
            System.out.println();
            System.out.println("Exiting. . .");
            System.out.println();
        }else{
            System.out.println("Value entered is not \"q\" or a positive integer");
            start();
        }
    }
    
   //Run initial outputs to user to request input
    public static void main(String[] args)
    {
    System.out.println("~~~Calculate Fibonacci Values~~~");
    System.out.println("Press \"q\" at any time to exit");
    System.out.println();
    start();
    }
}
