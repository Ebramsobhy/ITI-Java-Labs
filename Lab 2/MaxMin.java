/* Q-1 Develop an application that extracts the minimum and maximum of the elements of an array of 1000 element
   and compute the search running time. */

import java.util.Random;

class MaxMinN{

	public static void main(String args[]){
		long start = System.nanoTime();
		int numbers[] = new int[1000];
		int max = -1 ,min = 100;
		for(int i = 0; i< numbers.length ; i++){
			numbers[i] = (int) (Math.floor(Math.random() * 100));
			if(numbers[i] < min) 
				min = numbers[i];
			if(numbers[i] > max) 
				max = numbers[i];
		}
		long end = System.nanoTime();
		System.out.println("Min Number is : " + min);
		System.out.println("Max Number is :  " + max);
		System.out.println("Running Time is : " + (end - start));
	}

}