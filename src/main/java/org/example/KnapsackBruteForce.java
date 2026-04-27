package org.example;

public class KnapsackBruteForce
{
    int[] weights;
    int[] values;
    int numOfItems;
    int knapSackCap;

    KnapsackBruteForce(int[] weights, int[] values, int knapSackCap)
    {
        this.weights = weights;
        this.values = values;
        this.knapSackCap = knapSackCap;
        numOfItems = weights.length;
    }

    public boolean[] solve()
    {
        int maxWeight;
        int maxProfit;
        int currentWeight;
        int currentProfit;

        boolean[][] solutions;
        boolean[] currentSolution;
        boolean[] maxSolution;

        int numSolutions = (int) Math.pow(2, numOfItems);
    }
}