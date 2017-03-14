package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C489 {
	static boolean can(int m,int s){
		
		return s>=0&&s<=9*m;
	}
	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		int m=in.nextInt();
		int s=in.nextInt();
		
		
		int sum=s;String min="";
		boolean flag=true;

		for(int i=0;i<m&&flag;i++){
			flag=false;
			for(int dig=0;dig<=9;dig++){
				if((i>0||dig>0||(m==1&&dig==0))&&can(m-i-1,sum-dig)){	
					min+=dig+"";
					sum-=dig;
					flag=true;
					break;
				}
			}
		}
		System.out.print(flag? min:-1);
		
		sum=s;String max="";
		flag=true;
		for(int i=0;i<m&&flag;i++){
			flag=false;
			for(int dig=9;dig>=0;dig--){
				if((i>0||dig>0||(m==1&&dig==0))&&can(m-i-1,sum-dig)){	
					max+=dig+"";
					sum-=dig;
					flag=true;
					break;
				}
			}
		}
		System.out.print(" ");
		System.out.println(flag? max:-1);
				

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
