
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Uva_13032_MarblesInJars {
	static final long mod = ((long) 1e9) + 7;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		int cse = 1;
		
		while(t-->0)
		{
			int n = in.nextInt();
			int []arr = new int [n];
			for(int i=0;i<n;i++)
				arr[i] = in.nextInt();
			Arrays.sort(arr);
			long dp[][] = new long [105][105];
			dp[0][0] = 1;
			for(int i=1;i<=n;i++)
			{
				for(int j=0;j<=arr[i-1];j++)
				{
					if(j-i+1>=0)
					{
						dp[i][j] = dp[i][j] + dp[i-1][j] * (j-i+1);
						dp[i][j] %=mod;
					}
					for(int rem=j+1;rem<=arr[i-1];rem++)
					{
						dp[i][rem] += dp[i-1][j];
						dp[i][rem] %=mod;
					}
				}
			}
			long ans = 0;
			for(int i=0;i<=arr[n-1];i++)
				ans = (ans+dp[n][i])%mod;
			out.printf("Case %d: %d\n", cse++, ans);
		}
		out.flush();
		out.close();
	}
	static class Scanner
	{
		BufferedReader bf;
		StringTokenizer ns;
		
		Scanner(InputStream s)
		{
			bf = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next() throws IOException
		{
			while(ns ==null || !ns.hasMoreTokens())
				ns= new StringTokenizer(bf.readLine());
			return ns.nextToken();
		}
		
		public int nextInt() throws NumberFormatException, IOException
		{
			return Integer.parseInt(next());
		}
	}
}
