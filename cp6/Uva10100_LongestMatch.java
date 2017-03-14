package cp6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva10100_LongestMatch {
	static ArrayList<String> a1;
	static ArrayList<String> a2;
	
	public static int lcs()
	{
		if(a1.isEmpty() || a2.isEmpty())
			return -1;
		int l1= a1.size();
		int l2 = a2.size();
		int [][]l = new int [l1+1][l2+1];
		for(int i=0;i<=l1;i++)
		{
			for(int j=0;j<=l2;j++)
			{
				if(i == 0 || j==0)
					l[i][j] = 0;
				else
				{
					if(a1.get(i-1).equals(a2.get(j-1)))
						l[i][j] = 1+ l[i-1][j-1];
					else
						l[i][j] = Math.max(l[i-1][j], l[i][j-1]);
				}
			}
		}
		return l[l1][l2];
	}
	
	
	public static void conv(String s, int val)
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++)
			if(validc(s.charAt(i)))
				sb.append(s.charAt(i));
			else
				if(sb.length() != 0)
				{
					if(val == 1)
						a1.add(sb.toString());
					else
						a2.add(sb.toString());
					sb = new StringBuilder();
				}
		if(sb.length()!=0)
		{
			if(val == 1)
				a1.add(sb.toString());
			else
				a2.add(sb.toString());
		}
	}
	
	public static boolean validc(char c)
	{
		return (c - 'A' >= 0 && c-'A' <=26) || (c - 'a' >= 0 && c-'a' <=26) || (c - '0' >= 0 && c-'0' <=9);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int cse = 1;
		//int t = 3;
		while(in.ready())
		{
			a1 = new ArrayList<>();
			a2 = new ArrayList<>();
			conv(in.nextLine(), 1);
			conv(in.nextLine(), 2);
		//	System.out.println(a1.toString());
			//System.out.println(a2.toString());
			int val = lcs();
			if(cse < 10)
				sb.append(" " + cse++ + ". ");
			else
				sb.append(cse+++". ");
			if(val == -1)
				sb.append("Blank!\n");
			else
				sb.append("Length of longest match: ").append(val).append("\n");
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
