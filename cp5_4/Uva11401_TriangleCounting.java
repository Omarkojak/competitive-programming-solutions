package cp5_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva11401_TriangleCounting {
	static long res[] = new long[((int) 1e6)+1];
	
	static void build()
	{
		res[4] = 1;
		res[5] = 3;
		res[6] = 7;
		res[7] = 13;
		long acc = 6;
		long plus = 3;
		int times = 0;
		for(int i=8;i<res.length;i++)
		{
			if(times==2)
			{
				plus++;
				times=0;
			}
			acc+=plus;
			times++;
			res[i] = res[i-1] + acc;		
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		build();
		int n = in.nextInt();
		while(n>=3)
		{
			sb.append(res[n]).append("\n");
			n = in.nextInt();
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
