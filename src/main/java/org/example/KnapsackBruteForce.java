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

        boolean[][] solutions = new boolean[0][];
        boolean[] currentSolution;
        boolean[] maxSolution;

        int numSolutions = (int) Math.pow(2, numOfItems);

        /*
            This generates all the possible solutions because brute force
                is exhaustive so it needs to know all possible paths
        */
        for(int i = 0; i <= numSolutions - 1; i++)
        {
            currentSolution = new boolean[i];
            solutions[i] = currentSolution;
        }

        maxSolution = solutions[0];
        maxProfit = getProfit(maxSolution);
    }

    private int getProfit(boolean[] maxSolution)
    {

    }
}