/**
 * This program roughly calculates an approximation
 * of pi using a very abstract method of darts and
 * a circle.
 * 
 * @author Nicholas Fason
 * @version 2/2/2021
 */
import java.util.ArrayList;
import java.util.Scanner;

public class EstimatePiV2 {
    public static void main(String[] args) {
        // initialize scanner
        Scanner in = new Scanner(System.in);

        // get how many darts are required
        System.out.print("How many darts would you like thrown per trial? ");
        int dartsPerTrial = in.nextInt();

        // get how many trials
        System.out.print("How many trials would you like? ");
        int numTrials = in.nextInt();

        // space inbetween questions and results
        System.out.println();

        // close scanner
        in.close();

        // create and fill ArrayList
        ArrayList<Trial> trials = new ArrayList<Trial>();

        for (int i = 0; i < numTrials; i++) {
            trials.add(new Trial(dartsPerTrial));
        }

        System.out.println("| Trial Number | Pi Estimate |");
        System.out.println("|--------------|-------------|");

        double minPi = Double.MAX_VALUE;
        double maxPi = Double.MIN_VALUE;
        double piSum = 0.0;

        for (int i = 0; i < trials.size(); i++) {
            Trial trial = trials.get(i);

            trial.runTrial();
            
            //            |--------------|-------------|
            //            |       1      | 2.888888888 |
            System.out.printf("|     %3s      | %s |%n", i + 1, trial.toString());

            if (trial.getEstimate() < minPi)
                minPi = trial.getEstimate();
            if (trial.getEstimate() > maxPi)
                maxPi = trial.getEstimate();
            
            piSum += trial.getEstimate();
        }

        System.out.println("|--------------|-------------|");
        System.out.println("|    Minimum   | " + String.format("%11.9f", minPi) + " |");
        System.out.println("|    Maximum   | " + String.format("%11.9f", maxPi) + " |");
        System.out.println("|  Pi Estimate | " + String.format("%11.9f", (double)piSum/trials.size()) + " |");
    }
}
