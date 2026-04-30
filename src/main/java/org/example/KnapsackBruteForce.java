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

        int numSolutions = (int) Math.pow(2, numOfItems);

        boolean[][] solutions = new boolean[numSolutions][numOfItems];
        boolean[] currentSolution;
        boolean[] maxSolution;

        /*
            This generates all the possible solutions because brute force
                is exhaustive so it needs to know all possible paths
        */
        for(int i = 0; i <= numSolutions - 1; i++)
        {
            currentSolution = new boolean[numOfItems];

            //Needed an inner loop to help check if the bit is set in the array
            for(int j = 0; j <= numOfItems - 1; j++)
            {
                /*
                    This shifts the bits in the place it needs to be in the array
                        then it sets the value to a boolean.

                    This was new to me, and it wasn't working without the loop
                        I did need to look up how to do this.
                */
                currentSolution[j] = ((i >> j) & 1) == 1;
            }

            solutions[i] = currentSolution;
        }

        maxSolution = solutions[0];
        maxProfit = getProfit(maxSolution);

        for(int i = 1; i <= solutions.length - 1; i++)
        {
            currentWeight = getWeight(solutions[i]);
            currentProfit = getProfit(solutions[i]);

            if((currentWeight <= knapSackCap) && (currentProfit > maxProfit))
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