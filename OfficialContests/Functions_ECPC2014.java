package OfficialContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Functions_ECPC2014 {
	static final long mod = ((long) 1e9) + 7;
	static long[][] comb;
	static long [] fac;
	static long [][] pow;
	static long [][] f;

	static void nCr(int N)		
	{
		comb = new long[N][N];
		comb[0][0] = 1;
		for (int i = 1; i < N; i++)
		{
			comb[i][0] = 1;
			for (int j = 1; j <= i; j++)
				comb[i][j] = (comb[i-1][j] + comb[i-1][j-1]) % mod;		
		}
	}
	
	static void fac()
	{
		fac = new long [1001];
		fac[0] = 1;
		for(int i=1;i<1001;i++)
			fac[i] = (fac[i-1] * i) % mod;
	}
	
	static void pow()
	{
		pow = new long[1001][1001];
		for(int i=1;i<1001;i++)
		{
			pow[i][0] = 1;
			for(int j=1;j<1001;j++)
				pow[i][j] = (pow[i][j-1] * i)%mod;
		}
	
	}
	
	static void f() //dp for surjective
	{		
		f = new long[101][1001];
		f[0][0] = 1;
		for (int i = 1; i < 101; i++) 
			for (int j = 1; j < 1001; j++) 
				for (int k = 1; k <= i; k++) 
				{
					f[i][j] += (comb[i][k] * f[i - k][j - 1]) % mod;
					f[i][j] %= mod;
				}
			
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		nCr(1005);
		fac();
		pow();
		int cse = 1;
		int t = in.nextInt();
		while(t-->0)
		{
			int x = in.nextInt();
			int y = in.nextInt();
			
			long inj = 0;
			for(int i=1;i<=y;i++)
			{
				long ans = 0;
				for(int j=1;j<=i;j++)
				{
					ans += (((comb[x][j] * comb[i][j])%mod) * fac[j])%mod;
					ans %= mod;
				}
				inj += (ans*comb[y][i])%mod;
				inj %= mod;
			}
			
			long surj = 0;

			
			long bij = 0;
			for(int i = 1;i<=Math.min(x, y);i++)
			{
				bij += (((comb[x][i] * comb[y][i])%mod) * fac[i] )%mod;
				bij%=mod;
			}
			
			long total = 0;
			for(int i=1;i<=y;i++)
			{
				long ans = 0;
				for(int j=1;j<=x;j++)
				{
					ans += (comb[x][j] * pow[i][j])%mod;
					ans%=mod;
				}
				total += (ans*comb[y][i])%mod;
				total %=mod;
			}
			
			out.printf("Case %d: %d %d %d %d\n", cse++, inj, surj, bij, total);
		}
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
