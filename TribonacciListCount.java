import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TribonacciListCount 
{
	// number of vertices
	int n = 0;
	
	// constructor 
	TribonacciListCount(int n)
	{
		this.n = n;
	}
	
	// determines the possible listings for a chain upset tournament given the traversal of its adjacency matrix and the number of vertices
	public void process(ArrayList<Integer> list)
	{
		if (list.size() % this.n != 0)
		{
			throw new IllegalArgumentException();
		}
		
		int count = 0;
		Integer[] arr = new Integer[list.size()];
			
		arr = list.toArray(arr);
			
		for (int i = 0; i < list.size(); i++)
		{
			if (i % n == 0 && i != 0)
			{
				Integer[] subList = Arrays.copyOfRange(arr, i - n, i);
				if (areUnique(subList))
				{
					System.out.println(Arrays.toString(subList));
					count++;
				}
			}			
		}
		
		System.out.println("The number of listings is " + count);
	}
	
	// returns true if all Integers in a given array are unique
	private static boolean areUnique(Integer a[]) 
	{
		Set<Integer> s =  new HashSet<Integer>(Arrays.asList(a));
		return (s.size() == a.length);
	}
	
	// returns an adjacency matrix representing the results of a chain upset tournament
	public int[][] adjMatrix()
	{
		int row = this.n;
		int col = this.n;
		
		int[][] matrix = new int[row][col];
		
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				if (i == j + 1 || i < j -1)
				{
					matrix[i][j] = 1;
				}	
			}
		}
		
		return matrix;
	}
	
	// prints a given matrix
	public void print(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
	         System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
