package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B677 {

	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int n=in.nextInt();
		long h=in.nextLong();
		long k=in.nextLong();
		long inside=0;
		long res=0;
		long []a=new long [n];
		for(int i=0;i<n;i++)
			a[i]=in.nextLong();
		int j=0;
			
		while(j<n){
			if(inside+a[j]<=h){
				inside+=a[j++];
			}else{
				int rem=0;
				if((inside+a[j]-h)%k!=0)
					rem++;
				long secs=(inside+a[j]-h)/k+rem;
				res+=secs;
				inside-=secs*k;
				if(inside<0)
					inside=0;
			}
		}		
		if(inside!=0){
			int rem=0;
			if(inside%k!=0)
				rem++;
			res+=inside/k+rem;
		}
		
		System.out.println(res);
		
	
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
