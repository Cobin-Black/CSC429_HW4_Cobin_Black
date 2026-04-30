package org.example;

public class KnapsackGA
{
    int[] weights;
    int[] values;
    int numOfItems;
    int knapSackCap;

    public KnapsackGA(int[] weights, int[] values, int knapSackCap)
    {
        this.weights = weights;
        this.values = values;
        this.knapSackCap = knapSackCap;
        this.numOfItems = weights.length;
    }

    public boolean[] solve()
    {

    }
}
