package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CF_A651_Joysticks {
	static int dp[][];
	
	static int solve(int n1,int n2){
		if(n1<=0||n2<=0)
			return 0;
		if(dp[n1][n2]!=-1)
			return dp[n1][n2];
		int a1=solve(n1+1,n2-2);
		int a2=solve(n1-2, n2+1);
		return dp[n1][n2]=Math.max(a1, a2)+1;
		
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int n1=in.nextInt();
		int n2=in.nextInt();
		int t1=0;
		//boolean f1=true;int a1=Math.min(n1, n2);int a2=Math.max(n1, n2);
	/*	dp=new int [1000][1000];
		for(int i=0;i<105;i++)
			Arrays.fill(dp[i], -1);*/
		//System.out.println(solve(n1,n2));
		
		while(n1>0&&n2>0){
			if(n1==1&&n2==1)
				break;
			int a1=Math.min(n1, n2);
			int a2=Math.max(n1, n2);
			a1++;
			a2-=2;
			t1++;
			n1=a1;
			n2=a2;
		}
		//if(n1==1&&)
		System.out.println(t1);
		
		
		//System.out.println(Math.max(t2, t1));
		
		
		
		
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
