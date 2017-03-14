
package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class CF_B651_BeautifulPaintings {

	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		
		int n=in.nextInt();
		TreeMap<Integer, Integer>mp=new TreeMap<Integer,Integer>();
		ArrayList<Integer>[]a=new ArrayList[1005];
		for(int i=0;i<1005;i++)
			a[i]=new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			int x=in.nextInt();
			if(mp.containsKey(x)){
				int idx=mp.get(x)+1;
				a[idx].add(x);
				mp.put(x, idx);
			}
			else{
				//System.out.println("  1");
				mp.put(x, 0);
				a[0].add(x);
			}
		}
		int res=0;
		for(int i=0;i<1005;i++){
			
			//System.out.println(a[i].size());
			if(a[i].size()>0)
			res+=a[i].size()-1;
		}
	
		System.out.println(res);
	
	
	
	
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
