package cp6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Uva11588ImageCoding {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cse = 1;
		int t = in.nextInt();
		while(t-->0)
		{
			int []cnt = new int [26];
			int max = 0;
			int r = in.nextInt();
			int c = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			for(int i=0;i<r;i++)
			{
				String s = in.nextLine();
				for(int j=0;j<c;j++)
				{
					cnt[s.charAt(j) - 'A']++;
					max = Math.max(max, cnt[s.charAt(j) - 'A']);
				}
			}
			int ans = 0;
			for(int i=0;i<26;i++)
				if(cnt[i] == max)
					ans+=x*cnt[i];
				else
					ans+=y*cnt[i];
			out.printf("Case %d: %d\n", cse++, ans);
			
			
			
		}
		out.flush();
		out.close();
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
