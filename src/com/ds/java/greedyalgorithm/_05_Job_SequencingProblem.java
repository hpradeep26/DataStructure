package com.ds.java.greedyalgorithm;

import java.util.Arrays;

public class _05_Job_SequencingProblem {

	//Approach
	//Sort the jobs in descending order of profit.
	//Determine the maximum deadline and create an array of that size. Initially, set each array index to -1 to indicate no jobs have been scheduled.
	//For each job, check if it can be performed on its latest possible day.
	//If possible, mark that index with the job id and add the profit to the total profit.
	//If not possible, check the previous days until an empty slot is found.
	public static void main(String[] args) {
		//Jobs = [ [1, 4, 20] , [2, 1, 10] , [3, 1, 40] , [4, 1, 30] ]
		// 2 60
		//[3, 1, 40]
		//[4, 1, 30]
		//[1, 4, 20]
		//[2, 1, 10] 
		
		
		// [ [1, 2, 100] , [2, 1, 19] , [3, 2, 27] , [4, 1, 25] , [5, 1, 15] ]
		//2 127
		 int[][] jobs = {{1, 4, 20}, {2, 1, 10}, {3, 1, 40}, {4, 1, 30}};
		 JobScheduling(jobs);
	}
	
	public static int[] JobScheduling(int[][] Jobs) {
        // Sort jobs based on profit in descending order
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

        // Total number of jobs
        int n = Jobs.length;

        /*Initialize a hash table 
        to store selected jobs.
        each element represents a 
        deadline slot, 
        initially unoccupied.*/
        int[] hash = new int[n];
        Arrays.fill(hash, -1);

        // Initialize count
        int cnt = 0;

        // Initialize the total profit earned
        int totalProfit = 0;

        // Iterate over each job
        for (int i = 0; i < n; i++) {
            /*Iterate over each deadline slot starting 
            from the job's deadline*/
            for (int j = Jobs[i][1] - 1; j >= 0; j--) {
                /*If the current deadline 
                slot is available 
                (not occupied)*/
                if (hash[j] == -1) {
                    // Count of selected jobs
                    cnt++;
                    // Mark the job as selected
                    hash[j] = Jobs[i][0];
                    // Update the total profit
                    totalProfit += Jobs[i][2];
                    // Move to the next job
                    break;
                }
            }
        }

        // Return the array
        return new int[]{cnt,totalProfit};
    }

}
