public class helloworld {

    // Main method to test the Merge Sort
    public static void main(String[] args) {
        int[] arr = {0,1,0,1,2,0,2,1,2};  // Sample array
        System.out.println("Unsorted array: ");
        printArray(arr);
        
        mergeSort(arr, 0, arr.length - 1);  // Calling the mergeSort function
        
        System.out.println("\nSorted array: ");
        printArray(arr);
    }

    // Merge Sort function
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;  // Finding the middle of the array

            // Recursively sort the two halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted sub-arrays into a single sorted array
    public static void merge(int[] arr, int left, int mid, int right) {
        // Find the sizes of the two sub-arrays to merge
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays to hold the values
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy the data into temporary arrays
        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);

        // Merge the temporary arrays back into the original array
        int i = 0;  // Initial index for leftArray
        int j = 0;  // Initial index for rightArray
        int k = left;  // Initial index for arr[]

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of leftArray[], if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArray[], if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Utility function to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
