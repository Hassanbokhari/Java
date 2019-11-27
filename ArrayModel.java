package pkg;

import java.util.Arrays;

public class ArrayModel {
	
	private int [] array = new int [10];
	
	public ArrayModel() {
		int count = 10;
		for (int i = 0 ; i < 10 ; i++) {
			array[i] = count;
			count -= 1;
		}
	}
	
	public int [] getArray() {
		return array;
	}
	
	public void Sort() {
		Arrays.sort(array);
	}
	
	public boolean Search(int x) {
		int index = Arrays.binarySearch(array, x);
		if (index > -1) {
			System.out.println("Found " +  x +  " @ " + index);
			return true;
		}
		System.out.println("Not Found");
		return false;
	}
	
	public int max() {
		int max = getMax(array);
		return max;
	}
	
	public int min() {
		int min = getMin(array);
		return min;
	}
	
	public int getMax(int[] inputArray){ 
		int maxValue = inputArray[0]; 
		for(int i = 1 ; i < inputArray.length ; i++){ 
			if(inputArray[i] > maxValue){ 
				maxValue = inputArray[i]; 
			} 
		} 
    	return maxValue; 
    }
	 
	  // Method for getting the minimum value
	  public static int getMin(int[] inputArray){ 
	    int minValue = inputArray[0]; 
	    for(int i=1;i<inputArray.length;i++){ 
	      if(inputArray[i] < minValue){ 
	        minValue = inputArray[i]; 
	      }
	     } 
	    return minValue; 
	  }  
}
