package cp3_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva11532_SimpleAdjacencyMaximization {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while(t-->0)
		{
			int ones = in.nextInt();
			int zeroes = in.nextInt();
			String res = "";
			while(ones>=2 && zeroes>=1)
			{
				res +="101";
				ones-=2;
				zeroes-=1;
			}
			if(ones == 1 && zeroes >=1)	
			{
				res ="01" +res;
				ones--;
				zeroes--;
			}
			while(ones-->0)
				res+= "1";
			if(res.length()==0)
				sb.append("0\n");
			else
				sb.append(Long.parseLong(res, 2)).append("\n");
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
