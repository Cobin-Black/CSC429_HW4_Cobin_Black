package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        int[] weights = {1, 2, 5, 1, 3};
        int[] values = {20, 45, 90, 5, 30};
        int knapSackCap = 8;

        KnapsackBruteForce bruteForce = new KnapsackBruteForce(weights, values, knapSackCap);

        System.out.println("Brute Force Method:");
    }
}