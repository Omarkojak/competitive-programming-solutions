package cp5_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva10105_PolynomialCoefficients {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		long [] fac = new long[14];
		fac[0] = 1;
		for(int i=1;i<14;i++)
			fac[i] = fac[i-1] * i;
		String s = in.nextLine();
		while(s!=null && s.length()!=0)
		{
			StringTokenizer ns = new StringTokenizer(s);
			int n = Integer.parseInt(ns.nextToken());
			int k = Integer.parseInt(ns.nextToken());
			long ans = fac[n];
			while(k-->0)
				ans/=fac[in.nextInt()];
			sb.append(ans).append("\n");
			s = in.nextLine();
		}
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
	}
}
