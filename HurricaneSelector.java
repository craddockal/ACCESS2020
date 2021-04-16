/**
 * Calculate the average category, pressure, and wind speed of Atlantic hurricanes that have occurred 
 * between a given year range and tally the number of storms in each category according to the
 * Saffir-Simpson scale.
 *
 * @author Hollie Graham
 * @version 12/17/2020
 */
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class HurricaneSelector
{
    public static void main(String[] args) throws IOException
    {
        String token = "";        
        File fileName = new File("hurricanedata.txt");
        int dataLineCount = 0;
        
        //open file and loop through the data to figure out how mny lines of data there are
        Scanner inFile = new Scanner(fileName);
        while( inFile.hasNext() )
        {
            token = inFile.nextLine();      //read next token from file
            dataLineCount++;               //increment data line count
        }//end while        
        inFile.close();                 //close input file
        
        //deifine and intialize arrays
        int[] yearData = new int[dataLineCount];
        String[] monthData = new String[dataLineCount];
        int[] pressureData = new int[dataLineCount];
        double[] windSpeedData = new double[dataLineCount];
        String[] nameData = new String[dataLineCount];
        int[] categoryData = new int[dataLineCount];
        
        //reading data in from file and storing in arrays
        //loop through the data to figure out how mny lines of data there are 
        int index = 0;
        inFile = new Scanner(fileName);
        while( inFile.hasNext() )
        {
            yearData[index] = inFile.nextInt();             //read year in from file
            monthData[index] = inFile.next();               //read month in from file
            pressureData[index] = inFile.nextInt();         //read pressure in from file
            windSpeedData[index] = inFile.nextDouble();     //read wind speed in from file
            nameData[index] = inFile.next();                //read name in from file
            index++;                                        //increment index
        }//end while
        inFile.close();                 //close input file        
        
        //loop through arrays and do calculations mph = k * 1.15078
        for(int i = 0; i < windSpeedData.length; i++)
        {
            windSpeedData[i] *= 1.15078;    //calculate knots to mph
        }        
        
        //determine storms category
        for(int i = 0; i < windSpeedData.length; i++)
        {
            if(windSpeedData[i] >= 157.0)
            {
                categoryData[i] = 5;        //set category data is equal to 5
            }
            else if(windSpeedData[i] >= 130.0)
            {
                categoryData[i] = 4;        //set category data is equal to 4
            }
            else if(windSpeedData[i] >= 111.0)
            {
                categoryData[i] = 3;        //set category data is equal to 3
            }
            else if(windSpeedData[i] >= 96.0)
            {
                categoryData[i] = 2;        //set category data is equal to 2
            }
            else if(windSpeedData[i] >= 74.0)
            {
                categoryData[i] = 1;        //set category data is equal to 1
            }
            else
            {
                categoryData[i] = 0;        //if category is not equal to any numbers above set equal to 0
            }
        }  

        //prompt user for input start year and end year
        boolean yearsInvalid = true;  //intialize if years are valid
        int startYear = 1994;         //intialize start year to an invalid year
        int endYear = 2016;           //intialize end year to an invalid year
        Scanner in;                   //defining in for user input
        
        //prompt user until they enter valid years
        while(yearsInvalid)
        {
           //prompt user for valid year and store in variable
           in = new Scanner(System.in);  //intializing in the while loop, in case the wrong number of values are entered
           System.out.print("Choose the Beginning Year and Ending Year from 1995 through 2015 (1995 2015): "); 
           startYear = in.nextInt();    //reading the start year that the user entered
           endYear = in.nextInt();      //reading the end year that the user entered

           //check for valid years
           if(!(startYear >= 1995 && startYear <= 2015))
           {
              // invalid year selection, have user re-enter
              System.out.println("  Invalid Start Year (" + startYear + "). Please try again.");
              System.out.println("");            
           }
           else if(!(endYear >= 1995 && endYear <= 2015))
           {
              // invalid year selection, have user re-enter
              System.out.println("  Invalid End Year (" + endYear + "). Please try again.");
              System.out.println("");            
           }
           else if(!(endYear >= startYear))
           {
              // invalid year selection, have user re-enter
              System.out.println("  End Year (" + endYear + ") must be greater than or equal to Start Year (" + startYear + "). Please try again.");
              System.out.println("");            
           }
           else
           {
               yearsInvalid = false;
           }
        }        
        
        //calculate totals
        int totCategory = 0;
        int totPressure = 0;
        double totWindSpeed = 0.0;
        int yearCriteriaCount = 0;
        for(int i = 0; i < yearData.length; i++)
        {
            if(yearData[i] >= startYear && yearData[i] <= endYear)
            {
                yearCriteriaCount++;                  //increment counter to know how many records match the year criteria
                totCategory += categoryData[i];       //add category total to category data and give a new total
                totPressure += pressureData[i];       //add category total to presure data and give a new total
                totWindSpeed += windSpeedData[i];     //add category total to wind speed data and give a new total
            }             
        }
        
        //define and intialize variables
        //calculate minimums and maximums
        int minCategory = Integer.MAX_VALUE;
        int minPressure = Integer.MAX_VALUE;
        double minWindSpeed = Double.MAX_VALUE;        
        int maxCategory = Integer.MIN_VALUE;
        int maxPressure = Integer.MIN_VALUE;
        double maxWindSpeed = Double.MIN_VALUE; 
        
        //traverse the year array 
        for(int i = 0; i < yearData.length; i ++)
        {
            //check to see if year matches the year criteria
            if(yearData[i] >= startYear && yearData[i] <= endYear)
            {
                //determine min and max values
                if(categoryData[i] < minCategory)
                {
                    minCategory = categoryData[i];        //set minimum Category
                } 
                if(pressureData[i] < minPressure)
                {
                    minPressure = pressureData[i];        //set minimum Pressure
                }                      
                if(windSpeedData[i] < minWindSpeed)
                {
                    minWindSpeed = windSpeedData[i];      //set minimum Wind Speed
                }                     
                if(categoryData[i] > maxCategory)
                {
                    maxCategory = categoryData[i];        //set maximum Category
                } 
                if(pressureData[i] > maxPressure)
                {
                    maxPressure = pressureData[i];        //set maximum Pressure
                }                      
                if(windSpeedData[i] > maxWindSpeed)
                {
                    maxWindSpeed = windSpeedData[i];      //set maximum Wind Speed
                }    
            }            
        }        
        
        //calculate category totals
        index = 0;    //define and intialize index variable
        int[] categoryTotals = new int[6];  //define and intialize category totals
        //loop through category data to get totals 
        for(int cat : categoryData)
        {
            //check to see if year matches the year criteria
            if(yearData[index] >= startYear && yearData[index] <= endYear)
            {
                categoryTotals[cat]++;      //increment category totals
            } 

            index++;        //increment index 
        }

        //displaying output header, formatted  
        System.out.println();
        System.out.printf("%44s\n\n", "Hurricanes " + startYear + " - " + endYear);
        System.out.printf("%5s %13s %11s %17s %21s\n", "Year", "Hurricane", "Category", "Pressure (mb)", "Wind Speed (mph)");
        System.out.println("======================================================================");
        //output the year range data
        for(int i = 0; i < nameData.length; i++)
        {
            //check to see if year matches the year criteria
            if(yearData[i] >= startYear && yearData[i] <= endYear)
            {
                //format and output hurricane data
                System.out.printf("%5d     %-13s %3d %13d %21.2f\n", yearData[i], nameData[i], categoryData[i], pressureData[i],windSpeedData[i]);
            }
        }
        
        //displaying output trailer, formatted
        System.out.println("======================================================================");
        //displaying output averages, min, max, summary, formatted
        System.out.printf("%15s %13.1f %13.1f %19.2f\n", "Average:", ((double) totCategory / (double) yearCriteriaCount), ((double) totPressure / (double) yearCriteriaCount), (totWindSpeed / yearCriteriaCount));
        System.out.printf("%15s %11d %13d %21.2f\n", "Minimum:", minCategory, minPressure, minWindSpeed);
        System.out.printf("%15s %11d %13d %21.2f\n\n", "Maximum:", maxCategory, maxPressure, maxWindSpeed);
        System.out.println("Summary of Categories");
        //loop through category totals and output
        for(int i = 1; i < categoryTotals.length; i++)
        {
            System.out.printf("%6s %s:%3d\n", "Cat", i, categoryTotals[i]);  
        }
        
        //output statistics to a file
        PrintWriter outFile = new PrintWriter(new File("HurricaneStatistics.txt"));     //opening the output data file
        outFile.printf("%44s\n\n", "Hurricanes " + startYear + " - " + endYear);
        outFile.printf("%31s %17s %21s\n", "Category", "Pressure (mb)", "Wind Speed (mph)");
        outFile.println("======================================================================");
        //output averages, min, max, summary, formatted
        outFile.printf("%15s %13.1f %13.1f %19.2f\n", "Average:", ((double) totCategory / (double) yearCriteriaCount), ((double) totPressure / (double) yearCriteriaCount), (totWindSpeed / yearCriteriaCount));
        outFile.printf("%15s %11d %13d %21.2f\n", "Minimum:", minCategory, minPressure, minWindSpeed);
        outFile.printf("%15s %11d %13d %21.2f\n\n", "Maximum:", maxCategory, maxPressure, maxWindSpeed);
        outFile.println("Summary of Categories");
        //loop through category totals and output
        for(int i = 1; i < categoryTotals.length; i++)
        {
            outFile.printf("%6s %s:%3d\n", "Cat", i, categoryTotals[i]);  
        }
        outFile.close();    //close the file when finished
    }
}
