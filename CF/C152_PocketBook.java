package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class C152_PocketBook {
	static final long mod = (long) 1e9+7;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		char [][] words = new char [n][m];
		for(int i=0;i<n;i++)
		{
			String s = in.nextLine();
			for(int j=0;j<m;j++)
				words[i][j] = s.charAt(j);
		}
		long res = 1;
		for(int i=0;i<m;i++)
		{
			TreeSet<Character> ts = new TreeSet<>();
			for(int j=0;j<n;j++)
			{
				ts.add(words[j][i]);
			}
			res = (res*ts.size())%mod;
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
	}
}
