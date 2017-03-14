package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B159 {

	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		TreeMap<Integer, Integer> markers1=new TreeMap<>();		//from diameter  to how many
		TreeMap<Integer, Integer> caps1 = new TreeMap<>();	//from diameter to how many
		int [][] markers2 = new int [1005][1005];	//from diameter to list of color codes
		int [][] caps2 = new int [1005][1005];	//from diameter to list of color codes
		
		for(int i=0;i<n;i++){
			int x = in.nextInt();
			int y =in.nextInt();
			int v=0;
			if(markers1.containsKey(y))
				v=markers1.get(y);
			markers1.put(y,v+1);
			ArrayList<Integer> as = new ArrayList<>();
			markers2[y][x]++;
		}
		
		for(int i=0;i<m;i++){
			int a = in.nextInt();
			int b =in.nextInt();
			int v=0;
			if(caps1.containsKey(b))
				v=caps1.get(b);
			caps1.put(b,v+1);
			ArrayList<Integer> as = new ArrayList<>();
			caps2[b][a]++;
		}
		
		int res1=0;int res2=0;
		for(int i=1;i<=1000;i++){
			if(!markers1.containsKey(i) || !caps1.containsKey(i))
				continue;
			res1+= Math.min(caps1.get(i),markers1.get(i));
			for(int j=0;j<=1000;j++)
				res2+=Math.min(caps2[i][j], markers2[i][j]);

		}
		System.out.println(res1+" "+res2);
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
