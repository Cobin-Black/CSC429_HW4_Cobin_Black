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

    public boolean[] solve(int[] weights, int[] values, int n, int w)
    {
        int maxWeight;
        int maxProfit;
        int currentWeight;
        int currentProfit;

        int numSolutions = (int) Math.pow(2, numOfItems);

        boolean[][] solutions = new boolean[numSolutions][];
        boolean[] currentSolution;
        boolean[] maxSolution;

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

        for(int i = 1; i <= solutions.length - 1; i++)
        {
            currentWeight = getWeight(solutions[i]);
            currentProfit = getProfit(solutions[i]);

            if((currentWeight <= w) && (currentProfit > maxProfit))
            {
                maxSolution = solutions[i];
                maxProfit = currentProfit;
            }
        }

        return maxSolution;
    }

    private int getWeight(boolean[] solution)
    {
        int weight = 0;

        for(int i = 0; i < solution.length; i++)
        {
            if(solution[i])
            {
                weight += weights[i];
            }
        }

        return weight;
    }

    private int getProfit(boolean[] maxSolution)
    {
        int profit = 0;

        for(int i = 0; i < maxSolution.length; i++)
        {
            if(maxSolution[i])
            {
                profit += values[i];
            }
        }

        return profit;
    }
}