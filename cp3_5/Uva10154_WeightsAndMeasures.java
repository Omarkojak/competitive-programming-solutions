package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Uva10154_WeightsAndMeasures {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		ArrayList<Turtle> as = new ArrayList<>();
		String s = in.nextLine();
		while(s!= null && s.length()!=0)
		{
			StringTokenizer ns = new StringTokenizer(s);
			as.add(new Turtle(Integer.parseInt(ns.nextToken()), Integer.parseInt(ns.nextToken())));
			s = in.nextLine();
		} 
		Collections.sort(as);
		int N = 5610;
		int [] best = new int [N];
		Arrays.fill(best, Integer.MAX_VALUE);
		best[0] = 0;	
		
		int maxcount = 0;
		for(int i=0;i<as.size();i++)
		{
			Turtle curr = as.get(i);
			for(int j=maxcount+1;j>0;j--)
			{
				if(curr.s>= best[j-1]+curr.w && best[j-1] + curr.w < best[j])
				{
					best[j] = best[j-1] + curr.w;
					if(j>maxcount)
						maxcount = j;
				}
			}
		}
		
		System.out.println(maxcount);
	}
	
	static class Turtle implements Comparable<Turtle>
	{
		int w,s;
		Turtle(int a, int b)
		{
			w = a;
			s = b;
		}
		
		public int compareTo(Turtle o) {
			if(s != o.s)
				return s - o.s;
			return w - o.w;
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
	}
}
