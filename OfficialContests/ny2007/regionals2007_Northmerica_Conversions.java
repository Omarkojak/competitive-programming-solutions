package OfficialContests.ny2007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class regionals2007_Northmerica_Conversions {

	public static void main(String[] args) throws IOException {	
		Scanner in =new Scanner(System.in);
		int t=in.nextInt();
		int i=0;
		while(t-->0){
			i++;
			double v=in.nextDouble();
			String s=in.next();
			if(s.equals("kg")){
				double res=v*2.2046;
				System.out.printf("%d %.4f lb\n" ,i ,res);
			}
			if(s.equals("lb")){
				double res=v*0.4536;
				System.out.printf("%d %.4f kg\n" ,i ,res);
			}
			if(s.equals("l")){
				double res=v*0.2642;
				System.out.printf("%d %.4f g\n" ,i ,res);
			}
			
			if(s.equals("g")){
				double res=v*3.7854;
				System.out.printf("%d %.4f l\n" ,i ,res);
			}
			
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
