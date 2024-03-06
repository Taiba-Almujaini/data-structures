import java.util.*;

public class PowerSetGenerator {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        // Input: Number of elements
        System.out.print("Enter the number of elements: ");
        int numElements = scanner.nextInt();

        // Input: Elements
        int[] elements = new int[numElements];
        System.out.println("Enter the elements:");
        for (int i = 0; i < numElements; i++) {
            elements[i] = scanner.nextInt();
        }

        // Generate power set
        Set<Set<Integer>> powerSet = new HashSet<>();
        int subsetsCount = 1 << numElements; // Calculate 2^n

        for (int i = 0; i < subsetsCount; i++) {
            Set<Integer> subset = new HashSet<>();
            for (int j = 0; j < numElements; j++) {
                // Check if jth bit is set in the binary representation of i
                if ((i & (1 << j)) != 0) {
                    subset.add(elements[j]);  // Add element to the subset
                }
            }
            powerSet.add(subset);// Add subset to the power set
        }

        // Output: Input elements
        System.out.println("Input: " + Arrays.toString(elements));

        // Output: Power set
        System.out.println("Output: " + powerSet);

        scanner.close();
    }

}
