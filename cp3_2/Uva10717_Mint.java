package cp3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva10717_Mint {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int n = in.nextInt();
			int t = in.nextInt();
			if(n==0 && t==0)
				break;
			int [] divs = new int [n];
			for(int i=0;i<n;i++)
				divs[i] = in.nextInt();
			
			while(t-->0)
			{
				int len = in.nextInt();
				int ans1 = 0;
				for(int i= len; i>=0;i--)
				{
					int cnt = 0;
					for(int k=0;k<n&&cnt<4;k++)
						if(i%divs[k] == 0)
							cnt++;
					if(cnt >= 4)
					{
						ans1 = i;
						break;
					}
				}
				
				int ans2 = 0;
				for(int i= len;true;i++)
				{
					int cnt = 0;
					for(int k=0;k<n&&cnt<4;k++)
						if(i%divs[k] == 0)
							cnt++;
					if(cnt >= 4)
					{
						ans2 = i;
						break;
					}
				}
				sb.append(ans1 + " " + ans2).append("\n");
			}
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
