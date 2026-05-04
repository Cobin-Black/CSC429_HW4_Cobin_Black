package org.example;

public class Main {
    public static void main(String[] args)
    {
        //#region Brute Force Section
        int[] weightsBF = {1, 2, 5, 1, 3};
        int[] valuesBF = {20, 45, 90, 5, 30};
        int knapSackCapBF = 8;

        KnapsackBruteForce bruteForce = new KnapsackBruteForce(weightsBF, valuesBF, knapSackCapBF);

        System.out.println("Brute Force Method:");
        for(int i = 1; i <= valuesBF.length; i++)
        {
            System.out.printf("Item %d -> Value: %2d | Weight: %d\n", i, valuesBF[i - 1], weightsBF[i - 1]);
        }

        System.out.println("\nBrute Force Solution:");
        System.out.println("Knapsack Weight: " + knapSackCapBF);

        boolean[] solutionArray = bruteForce.solve();

        int bfTotalValue = 0;
        int bfTotalWeight = 0;

        System.out.println();
        for(int i = 1; i <= valuesBF.length; i++)
        {
            System.out.printf("Item %d -> Is Used: %b\n", i, solutionArray[i - 1]);

            if(solutionArray[i - 1])
            {
                bfTotalValue += valuesBF[i - 1];
                bfTotalWeight += weightsBF[i - 1];
            }
        }

        System.out.println("\nTotal Value: " + bfTotalValue);
        System.out.println("Total Weight: " + bfTotalWeight);
        //#endregion

        //#region Genetic Algo Section
        int[] weightsGA = {8, 12, 3, 7, 3, 9, 1, 4};
        int[] valuesGA = {30, 120, 220, 3, 21, 22, 317, 48};
        int knapSackCapGA = 16;

        KnapsackGA ga = new KnapsackGA(weightsGA, valuesGA, knapSackCapGA);

        System.out.println("\n-------------------------------------");
        System.out.println("Genetic Algorithm Method:");
        for(int i = 1; i <= valuesGA.length; i++)
        {
            System.out.printf("Item %d -> Value: %4d | Weight: %d\n", i, valuesGA[i - 1], weightsGA[i - 1]);
        }

        System.out.println("\nGenetic Algorithm Solution:");
        System.out.printf("Mutation Rate: %d\nPopulation Size: %-2d\nGeneration Amount: %d\nKnapsack Weight: %d\n",
                ga.mutationRate, ga.popSize, ga.numGens, knapSackCapGA);

        boolean[] gaSolutionArray = ga.solve();
        int gaTotalValue = 0;
        int gaTotalWeight = 0;

        System.out.println();
        for(int i = 1; i <= valuesGA.length; i++)
        {
            System.out.printf("Item %d -> Is Used: %b\n", i, gaSolutionArray[i - 1]);

            if(gaSolutionArray[i - 1])
            {
                gaTotalValue += valuesGA[i - 1];
                gaTotalWeight += weightsGA[i - 1];
            }
        }

        System.out.println("\nTotal Value: " + gaTotalValue);
        System.out.println("Total Weight: " + gaTotalWeight);
        //#endregion

        //#region Dynamic Prog Section
        int[] weightsDP = {8, 3, 1, 12, 5, 3, 4};
        int[] valuesDP = {60, 140, 13, 200, 35, 88, 5};
        int knapSackCapDP = 20;

        KnapsackDP dp = new KnapsackDP(weightsDP, valuesDP, knapSackCapDP);
    }
}