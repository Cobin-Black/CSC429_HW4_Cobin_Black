package org.example;

public class KnapsackDP
{
    //Spec Variables
    int[] weights;
    int[] values;
    int numOfItems;
    int knapSackCap;

    public KnapsackDP(int[] weights, int[] values, int knapSackCap)
    {
        this.weights = weights;
        this.values = values;
        this.knapSackCap = knapSackCap;
        numOfItems = weights.length;
    }
}
