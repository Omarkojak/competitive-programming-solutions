package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva10684_TheJackpot {
	static int n;
	static int a[];
	
	static int rangesum()
	{
		int max = 0;
		int sum=0;
		
		for(int i=0;i<n;i++)
		{
			sum+=a[i];
			max = Math.max(max, sum);
			if(sum<0)
				sum = 0;
		}
		return max;
	}
	

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		n = in.nextInt();
		while(n!=0)
		{
			a = new int [n];
			for(int i=0;i<n;i++)
				a[i] = in.nextInt();
			int ans = rangesum();
			if(ans !=0)
				sb.append("The maximum winning streak is ").append(ans).append(".\n");
			else
				sb.append("Losing streak.\n");
			n=in.nextInt();
		}
		System.out.print(sb);
	}
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
	}
}
