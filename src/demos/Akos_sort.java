package demos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Akos_sort {

	public static void main (String[] args) {
	
	//int [] szamok = new int[8];
	int szamok[] = {8,7,5,1,6,9,3,4,2,0};
	
	// load random numbers into szamok array:
	/*
	for (int i = 0; i < szamok.length; i++) {
		szamok[i] = (int)(10*Math.random()+1);
		System.out.println(szamok[i]);
	
	}
	*/
	
		
		Random random = new Random();
		
		// only for integers!!!
		List<Integer> numsToSort = new ArrayList();
		
		for (int i = 0; i < 5; i++) {
			numsToSort.add( random.nextInt(100));
		}
		
		
		Collections.sort(numsToSort);
		System.out.println("New array after builtin sort: " + numsToSort.toString());
		
	
	
	
	
	/*
	
	public static void selectionSort( int[] vals) {
		
		int indexMin;
		
		for (int i = 0; i < vals.length-1; i++) {
			
			indexMin = i;
			for ( int j=i+1; j < vals.length; j++) {
				if (vals[j] < vals[indexMin]) {
					indexMin = j;
				}
			}
			swap (vals, indexMin, i);
		}
	}
	*/
	
	}
	
}
