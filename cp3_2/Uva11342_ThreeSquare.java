package cp3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Uva11342_ThreeSquare {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		TreeMap<Integer, String> mp = new TreeMap<>();
		for(int i=0;i<=224;i++)
			for(int j=i;j<=224;j++)
				for(int k=j;k<=224;k++)
				{
					int ans = i * i + j * j + k * k;
					if(!mp.containsKey(ans))
						mp.put(ans, i+" "+j+" "+k);
				}
			
		int t = in.nextInt();
		while(t-->0)
		{
			int x = in.nextInt();
			sb.append((mp.containsKey(x))? mp.get(x) : -1).append("\n");
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
		
	}
}
