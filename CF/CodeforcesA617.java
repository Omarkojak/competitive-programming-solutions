package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeforcesA617 {
	static int []dp;
	static int x;
	static final int inf=10000000;
		
	public static int ev(int now){
		if(now==x)
			return 0;
		if(now>x)
			return inf;
		if(dp[now]!=0)
			return dp[now];
		return dp[now]= 1+min(ev(now+1),ev(now+2),ev(now+3),ev(now+4),ev(now+5));
	}
	public static int min(int a1,int a2,int a3,int a4,int a5){
		int x=Math.min(a1, a2);
		int y=Math.min(a3, a4);
		return Math.min(x,Math.min(y, a5) );
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		x=in.nextInt();
		//dp=new int[x+5];
		//System.out.println(ev(0));
		int r=0;
		if(x%5!=0)
			r++;
		System.out.println(x/5+r);
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
