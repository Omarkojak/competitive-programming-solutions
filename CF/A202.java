package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A202 {
	static char[]s;
	static int n;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		s = in.nextLine().toCharArray();
		n = s.length;
		ArrayList<String> as = new ArrayList<>();
		for(int i = (1<<n) - 1;i>=0 ;i--)
			if(isPalin(i))
			{
				String k = "";
				for(int j=n-1;j>=0;j--)
					if(((1<<j) & i) != 0)
						k+=s[j];
				as.add(k);
			}
		Collections.sort(as);
		System.out.println(as.get(as.size()-1));
		
	}
	
	public static boolean isPalin(int msk)
	{
		ArrayList<Character> as = new ArrayList<>();
		for(int i=0;i<n;i++)
			if(((1<<i) & msk) != 0)
				as.add(s[i]);
		for(int i=0,j=as.size()-1;i<j;i++, j--)
			if(as.get(i) != as.get(j))
				return false;
		return true;
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
