//Quick sort program

import java.util.Scanner;

public class QuickSort {

    // Quick Sort function
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high); // partition index
            quickSort(arr, low, p - 1); // sort left side
            quickSort(arr, p + 1, high); // sort right side
        }
    }

    // Partition function
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high]; // choose last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
