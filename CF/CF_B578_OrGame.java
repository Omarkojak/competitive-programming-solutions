package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_B578_OrGame {

	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner (System.in);
		int n=in.nextInt();int k=in.nextInt();int x=in.nextInt();
		long []a=new long [n+1];
		long prefix[]=new long [n+1];
		long suffix[]=new long [n+2];
		int pow=(int)Math.pow(x, k);
		for(int i=1;i<=n;i++){
			a[i]=in.nextLong();
			prefix[i]=prefix[i-1]|a[i];
		}
		for(int i=n;i>0;i--)
			suffix[i]=a[i]|suffix[i+1];
		
		long ans=0l;
		for(int i=1;i<=n;i++)
			ans=Math.max(ans, prefix[i-1]|suffix[i+1]|a[i]*pow);
		System.out.println(ans);
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
