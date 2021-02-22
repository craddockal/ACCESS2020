
/**
 * Write a description of class FibNumTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class FibNumTester
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        int n = -1;
        int x = 0;
        String choice = "y";
        while(choice.equals("y"))
        {
            while(n < 0)
            {
                System.out.print("\nPlease input a number greater than or equal to 0:");
                n = in.nextInt();
            }
           
            FibNum rabbits = new FibNum();
            x = rabbits.FibNum(n);
            System.out.println("This is your Fibonacci number for " + n + ": " + x);
            System.out.print("\n\nDo you want you enter another number? (y or n): ");
            choice = in.next();
            n = -1;
       }
        
    }
}
