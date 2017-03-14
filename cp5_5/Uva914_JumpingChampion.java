package cp5_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva914_JumpingChampion {
	
	static boolean isPrime [];
	static ArrayList<Integer> primes;
	
	public static void sieve (int max){
		isPrime = new boolean [max + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		primes = new ArrayList<>();
		for(int i = 2;i <= max;i++){
			if(isPrime[i]){
	    		if(1l * i * i <= max)
	    			for(int j = i * i;j < max + 1 ;j += i)
	    			{
	    				isPrime[(int)j] = false;
	    			}
					primes.add(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sieve(((int) 1e6)+5);
		int t = in.nextInt();
		while(t-->0)
		{
			ArrayList<Integer> prim = new ArrayList<>();
			int l = in.nextInt();
			int r = in.nextInt();
			for(int k:primes)
			{
				if(k>r)
					break;
				if(k>=l && k<=r)
					prim.add(k);
			}
			int [] diff = new int [(int) 1e6];
			for(int i=0;i<prim.size()-1;i++)
				diff[prim.get(i+1) - prim.get(i)]++;
			int max=0;
			int noofmax=0;
			boolean flag = true;
			for(int i=0;i<diff.length ;i++)
			{
				if(max == diff[i] && diff[i]!=0)
					flag=false;
				if(max<diff[i])
				{
					max = diff[i];
					noofmax = i;
					flag=true;
				}
			}
			if(flag && max!=0)
				sb.append("The jumping champion is "+noofmax).append("\n");
			else
				sb.append("No jumping champion\n");
			
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
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}
}
