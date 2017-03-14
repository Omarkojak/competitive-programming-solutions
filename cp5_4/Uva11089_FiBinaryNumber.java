package cp5_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uva11089_FiBinaryNumber {
	static long []fib;
	
	public static void fib()
	{
		fib = new long [50];
		int sum = 1;
		fib[0] = 1;
		fib[1] = 2;
		for(int i=2;i<50;i++)
			fib[i] = fib[i-1] + fib[i-2];
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		fib();
		while(t-->0)
		{
			int n = Integer.parseInt(bf.readLine());
			int i = 49;
			while(fib[i] > n)	i--;
			for(;i>=0;i--)
			{
				if(fib[i] <= n)
				{
					sb.append("1");
					n -= fib[i];
				}
				else
					sb.append("0");
			}
			sb.append("\n");
				
		}
		System.out.print(sb);
	}

}
