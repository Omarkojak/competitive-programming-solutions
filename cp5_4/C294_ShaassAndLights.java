	package cp5_4;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.math.BigInteger;
	import java.util.Arrays;
	import java.util.StringTokenizer;
	
	public class C294_ShaassAndLights {
		static final long mod = ((long) 1e9) + 7;
	
		public static void main(String[] args) throws IOException {
			Scanner in = new Scanner(System.in);
			PrintWriter out = new PrintWriter(System.out);
			BigInteger [] fac = new BigInteger [1000];
			fac[0] = BigInteger.valueOf(1);
			for(int i=1;i<1000;i++)
				fac[i] = fac[i-1].multiply(BigInteger.valueOf(i));
			int n = in.nextInt();
			int m = in.nextInt();
			
			BigInteger ans = fac[n-m];
			int [] ind = new int [m];
			for(int i=0;i<m;i++)
				ind[i] = in.nextInt();
			Arrays.sort(ind);
			
			for(int i=0;i<m;i++)
			{
				int prev = 0;
				if(i!=0)
					prev = ind[i-1];
				int idx = ind[i] - prev-1;
				ans = ans.divide(fac[idx]);
			}
			ans = ans.divide(fac[n-ind[m-1]]);
			BigInteger two = BigInteger.valueOf(2);
			for(int i=1;i<m;i++)
			{
				if(ind[i] - ind[i-1] != 1)
					ans = ans.multiply(two.pow(ind[i] - ind[i-1] - 2));
			}
			out.println(ans.mod(BigInteger.valueOf(mod)));
			out.flush();
			out.close();
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
