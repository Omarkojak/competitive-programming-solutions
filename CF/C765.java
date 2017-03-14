package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C765 {

	static long ceil(long a, long b){
		if(b == 0)
			return 0;
		long r = 0;
		if(a%b != 0)
			r++;
		
		return a/b+r;
	}
	
	public static void main(String[] args)throws IOException {
		Scanner in = new Scanner(System.in);
		long k = in.nextLong();
		long a = in.nextLong();
		long b = in.nextLong();
		long sets1 = a/k;
		long sets2 = b/k;
		long rem1 = a - sets1*k;
		long rem2 = b - sets2*k;
		boolean f = false;
		if(ceil(rem1, k - 1) <= sets2 && ceil(rem2, k-1) <= sets1)
			f = true;
		System.out.println(f? sets1 + sets2 : -1);
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
