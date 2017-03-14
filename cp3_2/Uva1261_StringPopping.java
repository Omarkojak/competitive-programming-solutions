package cp3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Uva1261_StringPopping {
	
	public static boolean solve(String s){
		if(s.length()==0)
			return true;
		if(s.length()==1)
			return false;
		int occ=1;int idx=0;char last=s.charAt(0);
		int i=1;
		for(;i<s.length();i++){
			if(s.charAt(i)==last){
				occ++;
				continue;
			}
			if(occ>1){
				String test=s.substring(0, idx)+s.substring(i, s.length());
				if(solve(test))
					return true;
			}
			idx=i;occ=1;
			last=s.charAt(i);
		}
		if(idx!=s.length()-1){
			String test=s.substring(0, idx);
			if(solve(test))
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		int t=in.nextInt();
		StringBuilder sb=new StringBuilder();
		while(t-->0){
			String curr=in.nextLine();
			sb.append(solve(curr)? 1:0).append("\n");
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
