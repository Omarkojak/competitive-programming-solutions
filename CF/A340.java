package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A340 {
	
	public static int GCD(int a, int b) {
		   if (b==0) return a;
		   return GCD(b,a%b);
		}
	
	public static int LCM(int a, int b) {
		return a*(b/GCD(a,b));
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int l = LCM(in.nextInt(), in.nextInt());
		int a = in.nextInt();
		int b = in.nextInt();
		int ans = b / l - a / l;
		if(a % l == 0)
			ans++;
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
	}
}
