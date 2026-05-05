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

    public int solve()
    {
        int[][] dp = new int[numOfItems + 1][knapSackCap + 1];

        int currentItemProfit;
        int currentItemWeight;
        int currentItemValue;
        int previousItemProfit;

        for(int i = 0; i < weights.length; i++)
        {
            dp[0][i] = 0;
        }

        for(int i = 1; i < numOfItems; i++)
        {
            currentItemWeight = weights[i - 1];
            currentItemValue = values[i - 1];

            for(int j = 0; j < weights.length; j++)
            {
                previousItemProfit = dp[i - 1][j];

                if(currentItemWeight > j)
                {
                    dp[i][j] = previousItemProfit;
                }
                else
                {
                    currentItemProfit = currentItemValue + dp[i - 1][j - currentItemWeight];

                    if(currentItemProfit > previousItemProfit)
                    {
                        dp[i][j] = currentItemProfit;
                    }
                    else
                    {
                        dp[i][j] = previousItemProfit;
                    }
                }
            }
        }

        return dp[numOfItems - 1][weights.length];
    }//end of solve()
}
