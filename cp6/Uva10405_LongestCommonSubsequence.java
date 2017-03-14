package cp6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva10405_LongestCommonSubsequence {
	
	public static int lcs(char[] s1, char[] s2)
	{
		int l1 = s1.length;
		int l2 = s2.length;
		int [][]l = new int [l1+1][l2+1];
		for(int i=0;i<=l1;i++)
			for(int j=0;j<=l2;j++)
			{
				if(i == 0 || j == 0)
					l[i][j] = 0;
				else
				{
					if(s1[i-1] == s2[j-1])
						l[i][j] = 1 + l[i-1][j-1];
					else
						l[i][j] = Math.max(l[i-1][j], l[i][j-1]);
				}
			}
		return l[l1][l2];
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		//int t = 5;
		while(in.ready())
			sb.append(lcs(in.nextLine().toCharArray(), in.nextLine().toCharArray())).append("\n");
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
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}
}
