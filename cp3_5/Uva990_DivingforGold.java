package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva990_DivingforGold {
	static int w,n,taken;
	static tres []a;
	static int dp[][];
	static final int inf=(int)1e9;
	static StringBuilder sb;
	
	static int solve(int idx,int trem){
		if(idx==n||trem==0)
			return 0;
		
		if(dp[idx][trem]!=-1)
			return dp[idx][trem];
		
		int take=0;
		if(trem-3*w*a[idx].d>=0)
			take=a[idx].v+solve(idx+1,trem-3*w*a[idx].d);
		int leave=solve(idx+1,trem);
		
		return dp[idx][trem]=Math.max(take, leave);
	}
	
	static void print(int idx,int trem){
		if(idx==n||trem==0)
			return;
		
		if(dp[idx][trem]==dp[idx+1][trem]){
			print(idx+1,trem);
		}else{
			if(trem-3*w*a[idx].d<0)
				return;
			sb.append(a[idx].d+" "+a[idx].v).append("\n");
			taken++;
			print(idx+1, trem-3*w*a[idx].d);
		}
		
	}
	

	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		boolean beg=true;
		while(in.ready()){
			if(beg)
				beg=false;
			else{
				System.out.println();
				in.nextLine();
			}
			int t=in.nextInt();
			w=in.nextInt();
			n=in.nextInt();
			a=new tres [n];
			for(int i=0;i<n;i++)
				a[i]=new tres(in.nextInt(),in.nextInt());
			
			dp=new int [n+2][t+5];
			for(int i=0;i<n;i++)
				Arrays.fill(dp[i], -1);
			
			System.out.println(solve(0,t));
			
			sb=new StringBuilder();
			taken=0;
			print(0,t);
			System.out.println(taken);
			System.out.print(sb.toString());
		}
	}
		static class tres{
			int d,v;
			tres(int a,int b){
				d=a;
				v=b;
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
