package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Uva10130 {
	static int n,no;
	static object []as;
	static final int inf=10000000;
	static int [][]dp;
	
	public static int solve(int idxo,int w){
		if(w<0)
			return -inf;
		if(idxo==no||w==0)
			return 0;
		if(dp[idxo][w]!=-1)
			return dp[idxo][w];
		
		int leave=solve(idxo+1,w);
		int take=as[idxo].p+solve(idxo+1,w-as[idxo].w);

		return dp[idxo][w]=Math.max(leave, take);
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		StringBuilder sb=new StringBuilder();
		while(t-->0){
			no=in.nextInt();
			as=new object[no];
			for(int i=0;i<no;i++)
				as[i]=new object(in.nextInt(),in.nextInt());
			
			n=in.nextInt();
			int []mw=new int [n];
			for(int i=0;i<n;i++)
				mw[i]=in.nextInt();
			
			/*System.out.println(Arrays.toString(mw));
			for(object o:as)
				System.out.print(o.p+" "+o.w+" ");
			*/
			int ans=0;
			for(int i=0;i<n;i++){
				dp=new int [no][mw[i]+5];
				for(int j=0;j<no;j++)
					Arrays.fill(dp[j], -1);
				ans+=solve(0,mw[i]);
			}
			sb.append(ans+"\n");
		}
		System.out.print(sb);
	}
	static class object {
		int w,p;
		object(int a,int b){
			p=a;w=b;
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
