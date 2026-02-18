
// Simple Fractional Knapsack using Greedy Method
import java.util.Scanner;

public class KnapsackGreedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        double[] weight = new double[n];
        double[] value = new double[n];
        double[] ratio = new double[n];

        // take input from the user
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            weight[i] = sc.nextDouble();

            System.out.print("Enter value of item " + (i + 1) + ": ");
            value[i] = sc.nextDouble();

            ratio[i] = value[i] / weight[i]; // value per unit weight
        }

        System.out.print("Enter capacity of knapsack: ");
        double capacity = sc.nextDouble();

        // Sorting items based on ratio (descending order)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ratio[i] < ratio[j]) {
                    // swap ratio
                    double temp = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = temp;

                    // swap weight
                    temp = weight[i];
                    weight[i] = weight[j];
                    weight[j] = temp;

                    // swap value
                    temp = value[i];
                    value[i] = value[j];
                    value[j] = temp;
                }
            }
        }

        double totalValue = 0;

        // Greedy selection
        for (int i = 0; i < n; i++) {
            if (capacity >= weight[i]) {
                totalValue += value[i];
                capacity -= weight[i];
            } else {
                totalValue += ratio[i] * capacity;
                break;
            }
        }

        System.out.println("Maximum value = " + totalValue);

        sc.close();
    }
}
