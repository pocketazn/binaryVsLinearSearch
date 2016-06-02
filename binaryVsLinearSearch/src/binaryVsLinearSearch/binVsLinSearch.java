package binaryVsLinearSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class binVsLinSearch 
{
	public static void main(String[] args) throws FileNotFoundException
	{

		Scanner s = new Scanner(new File("input10000.txt"));
		int arrayMarker = 0;
		int[] a = new int [10000];
		while(s.hasNextInt())
		{
			a[arrayMarker++]= s.nextInt();
		}
		System.out.println(Arrays.toString(a));
		int high2 = a.length-1;
		int key = 9999737;
		
		
		binaryTimer(a, key, 0, high2);

		linearTimer(a, key);
}

	public static void linearTimer(int[] a, int key)
	{
		long startTime = System.nanoTime();
		int truth = linear(a, key);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println(duration);
		
		if(truth == 1)
		{
			System.out.println("Found it");
		}
		else{
			System.out.println("Number Not Found");
		}
	}
	
	public static void binaryTimer(int[] a, int key, int low, int high )
	{
		long startTime = System.nanoTime();
		int truth = binarySearch(a, key, low, high);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println(duration);
		
		if( truth == -1)
			{
				System.out.println("Number Not Found");
			}
		else{
				System.out.println("Found It");
		}
	}
	
	public static int binarySearch(int[] x, int key, int low, int high)
	{
		if(low>high)
		{
			return -1;
		}
		int mid = (low+high)/2;
			
			if(key < x[mid])
			{
				return binarySearch(x,key, low, mid-1);
			}
			else if(key > x[mid])
			{
				return binarySearch(x,key, mid+1, high);
			}
			else
			{
				return mid;
			}
		
		
	}
	
	public static int linear(int[] x, int key)
	{
		for (int y = 0; y < x.length ; y++)
		{
			int a = x[y];
			if(a == key)
			{
				return 1;
			}
		}
		return 0;
	}
}
