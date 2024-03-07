import java.util.ArrayList;
import java.util.List;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        // create sorted arrays
        List<List<Integer>> sortedArrays = new ArrayList<>();
        sortedArrays.add(List.of(1, 4, 5));
        sortedArrays.add(List.of(1, 3, 4));
        sortedArrays.add(List.of(2, 6));

        // Merge the sorted arrays
        List<Integer> mergedArray = mergeKSortedArrays(sortedArrays);

        // Print the merged array
        System.out.println("Merged Array: " + mergedArray);
    }

    // Function to merge k sorted arrays into a single sorted array
    public static List<Integer> mergeKSortedArrays(List<List<Integer>> sortedArrays) {
        // Initialize the merged array
        List<Integer> mergedArray = new ArrayList<>();

        // Iterate through each sorted array
        for (List<Integer> array : sortedArrays) {
            // Add all elements of the current array to the merged array
            mergedArray.addAll(array);
        }

        // Sort the merged array
        mergedArray.sort(null);

        // Return the merged array
        return mergedArray;
    }
}
