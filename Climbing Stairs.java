import java.util.Scanner;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of steps in the staircase: ");
        int numberOfSteps = scanner.nextInt();


        
        if (numberOfSteps <= 0) {
            System.out.println("Number of distinct ways to climb 0 steps: 0");
            return;
        } else if (numberOfSteps == 1) {
            System.out.println("Number of distinct ways to climb 1 step: 1");
            return;
        } else if (numberOfSteps == 2) {
            System.out.println("Number of distinct ways to climb 2 steps: 2");
            return;
        }

        // Calculate the number of distinct ways to climb the given number of steps
        int previousStep1 = 1;
        int previousStep2 = 2;
        int current = 0;

        // Iterate from the 3rd step up to numberOfSteps
        for (int i = 3; i <= numberOfSteps; i++) {
            current = previousStep1 + previousStep2;
            previousStep1 = previousStep2;
            previousStep2 = current;
        }

        // Display the result to the user
        System.out.println("Number of distinct ways to climb " + numberOfSteps + " steps: " + current);
    }
}
