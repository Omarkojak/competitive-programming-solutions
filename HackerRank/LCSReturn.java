package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class LCSReturn {
	static int l1;
	static int l2;
	static String s1;
	static String s2;
	static int L[][];
	static ArrayList<Integer> as1;
	static ArrayList<Integer> as2;
	
	public static void lcs()
	{
		L = new int [l1+1][l2+1];
		for(int i=0;i<=l1;i++)
		{
			for(int j=0;j<=l2;j++)
			{
				if(i==0 || j==0)
					L[i][j] = 0;
				else
					if(s1.charAt(i-1) == s2.charAt(j-1))
						L[i][j] = L[i-1][j-1] + 1;
					else
						L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
					
			}
		}
	}
	
	public static void get(int i, int j)
	{
		if(i >= l1+1 || j>= l2+1)
			return;
		if(s1.charAt(i-1) == s2.charAt(j-1))
		{
			as1.add(i-1);
			as2.add(j-1);
			get(i+1, j+1);
		}
		else
		{
			if(L[i+1][j] > L[i][j+1])
				get(i+1, j);
			else
				get(i, j+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		s1 = in.nextLine();l1 = s1.length();
		s2 = in.nextLine();l2 = s2.length();
		lcs();
		as1 = new ArrayList<>();
		as2 = new ArrayList<>();

		get(1,1);
		as1.add(l1-1);
		as2.add(l2);
		System.out.println(as1.toString());
		System.out.println(as2.toString());

		long ans = 0;
		for(int i=0;i<as1.size();i++)
		{
			int start = 0;
			if(i!=0)
				start = as2.get(i-1);
			int end = as2.get(i);
			TreeSet<Character> ts = new TreeSet<>();
			for(int j=start;j<end;j++)
				ts.add(s2.charAt(j));
			start = 0;
			if(i!=0)
				start = as1.get(i);
			ans += ts.size() * (as1.get(i) - start + 1);
			System.out.println(ans);
		}
		System.out.println(ans);
		
		
		
		
	}
	
	static class Pair
	{
		int i,j;
		Pair(int x, int y)
		{
			i = x;
			j = y;
			
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
