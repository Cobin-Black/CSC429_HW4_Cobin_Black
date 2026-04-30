package org.example;

public class Main {
    public static void main(String[] args)
    {
        //#region Brute Force Section
        int[] weights = {1, 2, 5, 1, 3};
        int[] values = {20, 45, 90, 5, 30};
        int knapSackCap = 8;

        KnapsackBruteForce bruteForce = new KnapsackBruteForce(weights, values, knapSackCap);

        System.out.println("Brute Force Method:");
        for(int i = 1; i <= values.length; i++)
        {
            System.out.printf("Item %d -> Value: %2d | Weight: %d\n", i, values[i - 1], weights[i - 1]);
        }

        System.out.println("\nBrute Force Solution:");
        boolean[] solutionArray = bruteForce.solve();

        for(int i = 1; i <= values.length; i++)
        {
            System.out.printf("Item %d -> Is Used: %b\n", i, solutionArray[i - 1]);
        }
        //#endregion
    }
}