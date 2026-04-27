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
        return null;
    }
}