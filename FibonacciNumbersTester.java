
/**
 * This program gathers the variables need by asking the user for input, it then refers to the FibonacciNumbers class to find the fibonacci number.
 *
 * @author: Daniel Anthony Holden Jones
 * @version: 1/21/2021
 * ------------------------------------------------------------------------
PROJECT TITLE: 12.05 Fibonacci.
PURPOSE OF PROJECT: To take user input then find the fibonacci value of the number, then tell the user.
VERSION or DATE: 1/21/2021
HOW TO START THIS PROJECT: Once the project is open right click the tester class, then select "void main(String[] args) then select "ok".
AUTHORS: Daniel Anthony Holden Jones
USER INSTRUCTIONS: Once the program is started, answer the prompted questions, the program will then display output.
------------------------------------------------------------------------
<+S> I was easily able to implement multiple classes and overall had an easy time with most of the program.
<-W> I had a lot of problems with figuring out how to find the fibonacci value. I also had a few problems with comparing strings and other 
older concepts we covered, but I quickly over came them and this was a needed refresher.
In the future: I will reflect back on this code and take a calm approach to the problems and brek them down into steps.
 */
import java.util.Scanner;
public class FibonacciNumbersTester
{
    public static void main(String[] args) {
        
        String userInput = "placeholder";//This is the variable for user input.
        int intInput;//Variable for the converted value.
        int finalNum; //Variable for the fibonacci value.
        //Asks user for input.
        Scanner in = new Scanner(System.in);
        while (!userInput.equals("q")){//Ends program.
          System.out.println("Please enter an integer number to find the fibonacci value of.(Once the input is above 40, the program will run slower)");
          System.out.println("Please enter a value in between 0 and 46.");
          userInput = in.next();
          if (userInput.equals("q")) {
	   System.out.println("Ending program, goodbye.");
          }
          //Parameters for question.
          else {
            intInput = Integer.parseInt(userInput);
            if (intInput >= 50){
                System.out.println("Input too high, please enter another number.");
            }
            else if (intInput < 0) {
                System.out.println("Input too low, please enter another number.");
            }
            //Calls methods if i is within the code.
            else {
             FibonacciNumbers fiboNum = new FibonacciNumbers(intInput);
             finalNum = fiboNum.calculations(intInput);
             System.out.println("Fibonacci number: " + finalNum);
            }
          }
        }
        
        
    }
}
