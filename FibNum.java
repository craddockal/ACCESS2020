
/**
 * Write a description of class FibNum here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FibNum
{
    
    public int FibNum(int n)
    {
         if(n == 0)
         {
             return 0;
         }
         else if(n == 1)
         {
             return 1; 
         }
         else
         {
             return FibNum(n - 1) + FibNum(n - 2); 
         }
    }
}
