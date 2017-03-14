package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva1231_Acorn {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while(t-->0)
		{
			int trees = in.nextInt();
			int h = in.nextInt();
			int f = in.nextInt();
			int [] dp = new int [h+1];	// h is the highest level
			int [][] acorn = new int [trees][h+1];
			
			for(int i=0;i<trees;i++)
			{
				int k = in.nextInt();
				while(k-->0)
				{
					acorn[i][in.nextInt()]++;
				}
			}

			for(int tr=0;tr<trees;tr++)
				for(int height=0;height<h+1;height++)
					dp[height] = Math.max(dp[height], acorn[tr][height]);
			
			for(int height=1;height<h+1;height++)
			{
				for(int tr=0;tr<trees;tr++)
				{
					acorn[tr][height] += Math.max(acorn[tr][height - 1],((height - f >= 0) ? dp[height - f] : 0)); 
					dp[height] = Math.max(dp[height], acorn[tr][height]); 
				}
			}
            
			sb.append(dp[h]).append("\n");
		}
		in.nextInt();
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
