package OfficialContests.feglaqualf1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Fegalqualf1_E_LockScreen {

	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		int t=in.nextInt();
		PrintWriter out=new PrintWriter(System.out);
		while(t-->0){
			int n=in.nextInt();
			int x[]=new int [n];
			int y[]=new int [n];
			for(int i=0;i<n;i++){
				x[i]=in.nextInt();
				y[i]=in.nextInt();
			}
			boolean found=false;
			for(int i=0;i<n-1;i++){
					if((x[i]!=x[i+1])&&(y[i]!=y[i+1])){
						found=true;
						break;
					}
				
			}
			if(found)
				out.println("strong");
			else
				out.println("weak");
			
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
