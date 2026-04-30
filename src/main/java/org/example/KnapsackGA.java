package org.example;

import java.util.Random;

public class KnapsackGA
{
    int[] weights;
    int[] values;
    int numOfItems;
    int knapSackCap;

    boolean[][] population;
    int[] fitness;

    int popSize = 20;
    int numGens = 60;

    Random randomSelect = new Random();

    public KnapsackGA(int[] weights, int[] values, int knapSackCap)
    {
        this.weights = weights;
        this.values = values;
        this.knapSackCap = knapSackCap;
        this.numOfItems = weights.length;
    }

    public boolean[] solve()
    {
        boolean[][] nextGenerationSolutions = new boolean[popSize][numOfItems];
        boolean[] maxFitnessIndividual = new boolean[numOfItems];

        population = new boolean[randomSelect.nextInt()][randomSelect.nextInt()];

        for(int i = 1; i < numGens; i++)
        {
            calculateFitnessProfitForAll();
            nextGenerationSolutions = createNextGeneration();
            population = nextGenerationSolutions;
        }

        boolean[] currentMaxFit = new boolean[numOfItems];
        for(int i = 0; i < population.length; i++)
        {
            if(calculateFitness(population[i]) > calculateFitness(currentMaxFit))
            {
                maxFitnessIndividual = population[i];
            }
        }

        return maxFitnessIndividual;
    }

    private int calculateFitness(boolean[] solution)
    {
        int solutionProfit = 0;
        int solutionWeight = 0;

        for(int i = 0; i <= solution.length - 1; i++)
        {
            if(solution[i])
            {
                solutionProfit = solutionProfit + values[i];
                solutionWeight = solutionWeight + weights[i];
            }
        }

        if(solutionWeight > knapSackCap)
        {
            solutionProfit = 0;
        }

        return solutionProfit;
    }
}
