import java.util.*;

public class Main 
{
	
	public static void main(String[] args) 
	{
		TribonacciListCount paths = new TribonacciListCount(6);
		
		int[][] matrix = paths.adjMatrix();
		
		paths.print(matrix);
		System.out.println();
		
		ArrayList<Integer> list = new ArrayList<Integer>();	

		// fill list
		for (int i = 0; i < 6; i++)
		{
			list.add(i);
			for (int j = 0; j < 6; j++)
			{
				if (matrix[i][j] == 1)
				{
					if (list.size() % 6 == 0)
					{
						list.add(i);
					}
					list.add(j);
					
					for (int k = 0; k < 6; k++)
					{
						if (matrix[j][k] == 1)
						{
							if (list.size() % 6 == 0)
							{
								list.add(i);
								list.add(j);
							}
							list.add(k);
							for (int m = 0; m < 6; m++)
							{
								if (matrix[k][m] == 1)
								{
									if (list.size() % 6 == 0)
									{
										list.add(i);
										list.add(j);
										list.add(k);
									}
									list.add(m);
									for (int n = 0; n < 6; n++)
									{
										if (matrix[m][n] == 1)
										{
											if (list.size() % 6 == 0)
											{
												list.add(i);
												list.add(j);
												list.add(k);
												list.add(m);
											}
											list.add(n);
											for (int p = 0; p < 6; p++)
											{
												if (matrix[n][p] == 1)
												{
													if (list.size() % 6 == 0)
													{
														list.add(i);
														list.add(j);
														list.add(k);
														list.add(m);
														list.add(n);
													}
													
													list.add(p);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		// prints sublists of length 6 that have unique integers 
		paths.process(list);
		
	} // end main
}