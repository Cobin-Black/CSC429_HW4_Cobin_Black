package org.example;

import java.util.Random;

public class KnapsackGA
{
    //Spec Variables
    int[] weights;
    int[] values;
    int numOfItems;
    int knapSackCap;

    //Pseudocode Variables
    int popSize = 20;
    int numGens = 10;

    boolean[][] population;
    int[] fitness = new int[popSize];

    int mutationRate = 25;

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

        //This is the part of the pseudocode that wanted to population to have random solutions
        population = new boolean[popSize][numOfItems];
        for(int i = 0; i < popSize; i++)
        {
            for(int j = 0; j < numOfItems; j++)
            {
                population[i][j] = randomSelect.nextBoolean();
            }
        }

        for(int i = 1; i <= numGens; i++)
        {
            calculateFitnessProfitForAll();
            nextGenerationSolutions = createNextGeneration();
            population = nextGenerationSolutions;
        }

        for(int i = 0; i < population.length; i++)
        {
            if(calculateFitness(population[i]) > calculateFitness(maxFitnessIndividual))
            {
                maxFitnessIndividual = population[i];
            }
        }

        return maxFitnessIndividual;
    }

    //#region Helper Methods for solve()
    private void calculateFitnessProfitForAll()
    {
        for(int i = 0; i <= population.length - 1; i++)
        {
            fitness[i] = calculateFitness(population[i]);
        }
    }//end of calculateFitnessProfitForAll()

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

        //Sets it to 0 if it is not a feasible solution
        if(solutionWeight > knapSackCap)
        {
            solutionProfit = 0;
        }

        return solutionProfit;
    }//end of calculateFitness()

    private boolean[][] createNextGeneration()
    {
        boolean[][] nextGen = new boolean[population.length][numOfItems];
        int nextGenCount = 0;

        while(nextGenCount < nextGen.length)
        {
            //This is the select parent section
            boolean[] randParent1 = population[randomSelect.nextInt(population.length)];
            boolean[] randParent2 = population[randomSelect.nextInt(population.length)];

            boolean[] offSpring1 = new boolean[numOfItems];
            boolean[] offSpring2 = new boolean[numOfItems];

            /*
                This section is where the crossover will happen for the offspring.

                The crossOverPosition will get where the split of the parents is happening
                    so the children get half of each.
            */
            int crossOverPosition = numOfItems / 2;

            for(int i = 0; i < numOfItems; i++)
            {
                if(i < crossOverPosition)
                {
                    offSpring1[i] = randParent1[i];
                    offSpring2[i] = randParent2[i];
                }
                else
                {
                    offSpring1[i] = randParent2[i];
                    offSpring2[i] = randParent1[i];
                }
            }

            /*
                This is the mutation section.

                This will compare a random number of 100 to the mutationRate to see
                    if a mutation will happen. If it does it will just flip a random bit
                    of the offSpring.
            */
            if(randomSelect.nextInt(100) < mutationRate)
            {
                int mutationPosition = randomSelect.nextInt(offSpring1.length);
                offSpring1[mutationPosition] = !offSpring1[mutationPosition];
            }

            if(randomSelect.nextInt(100) < mutationRate)
            {
                int mutationPosition = randomSelect.nextInt(offSpring2.length);
                offSpring2[mutationPosition] = !offSpring2[mutationPosition];
            }

            nextGen[nextGenCount] = offSpring1;
            nextGenCount++;

            if(nextGenCount < nextGen.length)
            {
                nextGen[nextGenCount] = offSpring2;
                nextGenCount++;
            }
        }

        return nextGen;
    }//end of createNextGeneration()
    //#endregion
}
