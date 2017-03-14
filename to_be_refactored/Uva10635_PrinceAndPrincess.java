package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Uva10635_PrinceAndPrincess {
	static int []a1;
	static int []a2;
	static int p,q;
	

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while(t-->0)
		{
			int n = in.nextInt();
			p = in.nextInt() + 1;
			q = in.nextInt() + 1;
			a1 = new int [p];
			a2 = new int [q];
			for(int i=0;i<p;i++)
				a1[i] = in.nextInt();
			for(int i=0;i<q;i++)
				a2[i] = in.nextInt();
		//	sb.append(solve(0,0)).append("\n");
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
		
	}
}
