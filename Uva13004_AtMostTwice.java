import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva13004_AtMostTwice {
	static String s;
	static int k;
	static final long inf = ((long) 1e18) + 1000;
	static long [][] dp;
	static long [] mul;
	
	public static int checkones(int msk)
	{
		int cnt = 0;
		while(msk>0)
		{
			if(msk % 2 == 1)
				cnt++;
			msk >>= 1;
		}
		return cnt;
	}
	
	public static long solve(int less,int msk)	// less : 0 true -- 1 false
	{
		int idx = checkones(msk);
		
		if(idx==s.length())
			return 0;
			
		if(dp[less][msk] !=0)
			return dp[less][msk];
		
		
		int digit = s.charAt(idx) - '0';

		long max = - inf;
		if(less == 1)
		{	
			if(((1<<digit) & msk) == 0)
			{
				long a1 =  solve(1, ((1<<digit) | msk));
				if(a1 != -inf)
				{
					a1 += conv(digit, idx);
					max = Math.max(max, a1);
				}
			}
			else
			{
				if((1<<(digit + 10) & msk) == 0)
				{
					long a1 =  solve(1, ((1<<(digit+10)) | msk));
					if(a1 != -inf)
					{
						a1 += conv(digit, idx);
						max = Math.max(max, a1);
					}
				}
			}
		}
			
		for(int i=0;i<=9;i++)
		{
			if(less == 1 && i >= digit)
				continue;
			
			if(((1<<i) & msk) == 0)
			{
				long a1 = solve(0, ((1<<i) | msk));
				if(a1 == -inf)
					continue;
				a1 += conv(i, idx);
				max = Math.max(max, a1);
			}
			else
			{
				if(((1<<(i+10)) & msk) == 0)
				{
					long a1 = solve(0, ((1<<(i+10)) | msk));
					if(a1 == -inf)
						continue;
					a1 += conv(i, idx);
					max = Math.max(max, a1);
					
				}
				else
					continue;
			}
		}
		return dp[less][msk] = max;
	}
	
	public static long conv(int x, int idx)
	{
		int end = s.length() - idx -1 ;
		
		return ((long)x)*mul[end];
	}
	
	public static void create()
	{
		mul = new long [19];
		mul[0] = 1;
		for(int i=1;i<19;i++)
			mul[i] = mul[i-1] * 10;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		s = in.nextLine();
		create();
		while(s!=null && s.length() !=0)
		{	
			dp = new long [2][1<<20];
			//System.out.println(conv(2,8));

		//	System.out.println(s);
			//System.out.println(k);
			sb.append(solve(1,0)).append("\n");
			s = in.nextLine();
		}
		System.out.print(sb);
	}
	static class Scanner
	{
		StringTokenizer ns;
		BufferedReader bf;
		
		Scanner(InputStream s)
		{
			bf = new BufferedReader(new InputStreamReader(s));
		}
		
		String next() throws IOException
		{
			while(ns == null || !ns.hasMoreTokens())
				ns = new StringTokenizer(bf.readLine());
			return ns.nextToken();
		}
		
		int nextInt() throws IOException, NumberFormatException
		{
			return Integer.parseInt(next());
		}
		
		long nextLong() throws IOException, NumberFormatException
		{
			return Long.parseLong(next());
		}
		
		public String nextLine() throws IOException
		{
			return bf.readLine();
		}
	}

}
