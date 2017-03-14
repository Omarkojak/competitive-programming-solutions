package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CodeforcesC626 {
	static long []dp;
	
	static long solve(int n,int m,int i){
		if(i==0)
			return Math.max(n, m);
		if(dp[i]!=-1)
			return dp[i];
		long a1=solve(n+2, m, i-1); 
		long a2=solve(n, m+3, i-1); 
		return dp[i]=Math.min(a1, a2);
	}

	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		int ln=in.nextInt();
		int lm=in.nextInt();
		if(ln==0){
			System.out.println(lm*3);
			return;
		}
		if(lm==0){
			System.out.println(ln*2);
			return;
		}
		//Queue<Integer> q=new LinkedList<Integer>();
		int itrsct=0;
		for(int i=2;i<=Math.min(lm*3, ln*2);i++)
			if(i%2==0&&i%3==0){
				itrsct++;
				//q.add(i);
			}
		//System.out.println(itrsct);
		//dp=new long [itrsct+5];
		//Arrays.fill(dp, -1);
		//System.out.println(solve(ln*2,lm*3,itrsct));
		ln*=2;
		lm*=3;
		while(itrsct>0){
			itrsct--;
			if(ln+2<lm){
				ln+=2;
			}else
				if(lm+3<ln)
					lm+=3;
				else{
					if(ln+2<lm+3){
						if((ln+2)%3==0&&itrsct!=0)
							ln+=4;
						else
							ln+=2;
					}else{
						if(ln+2!=lm+3)
							lm+=3;
						else
							lm+=4;
					}
				}
		}
		//System.out.println(lm +" "+ln);
		System.out.println(Math.max(lm, ln));
		
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
