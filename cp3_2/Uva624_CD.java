package cp3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva624_CD {
	static int sum,n;
	static int []arr;
	static int ans;
	static int nearesttotal;
	
	static void solve(int total, int msk, int idx)
	{
		if(total > sum)
			return;
		if(total > nearesttotal)
		{
			nearesttotal = total;
			ans = msk;
		}
		if(idx>=n)
			return;
		solve(total+arr[idx], msk | (1<<idx), idx+1);
		solve(total, msk, idx+1);
		
	}
	

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		while(in.ready())
		{
			sum = in.nextInt();
			n = in.nextInt();
			arr = new int [n];
			for(int i=0;i<n;i++)
				arr[i] = in.nextInt();
			ans = -1;
			nearesttotal = -1;
			solve(0,0,0);
			//System.out.println(ans);
			for(int i=0;i<n;i++)
			{
				if((ans &(1<<i)) != 0)
				{
					System.out.print(arr[i] + " ");
				}
				
			}
			System.out.println("sum:"+nearesttotal);
		}

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
