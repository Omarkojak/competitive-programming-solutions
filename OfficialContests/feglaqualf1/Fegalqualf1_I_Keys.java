package OfficialContests.feglaqualf1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Fegalqualf1_I_Keys {

	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int t=in.nextInt();
		while(t-->0){
			int n=in.nextInt();
			int k=in.nextInt();
			int []val=new int [26];
			for(int i=0;i<26;i++)
				val[i]=in.nextInt();
			
			while(n-->0){
				String curr=in.nextLine();
				long sum=0;
				for(int i=0;i<curr.length();i++){
					sum+=val[curr.charAt(i)-'a'];
				}
				if(sum>=k)
					out.println(curr);
			}
		
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
