package cp3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva861_LittleBishops {
	static long ans;
	static int n,k;

	public static boolean valid(Bishop []a,int cidx){
		for(int i=0;i<cidx;i++)
			if(a[i].attack(a[cidx]))
				return false;
		return true;
	}
	
	public static void solve(Bishop[]a,int cidx){
		if(cidx==k){
			ans++;
			return ;
		}
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++){
				a[cidx]=new Bishop(i,j);
				if(valid(a,cidx)){
					solve(a,cidx+1);
					System.out.println("   1");
				}			}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		while(true){
			n=in.nextInt();
			k=in.nextInt();
			if(n==0&&k==0)
				break;
			ans=0;
			Bishop[] a=new Bishop[k];
			solve(a,0);
			sb.append(ans+"\n");
		}
		System.out.print(sb);
	}
	
	static class Bishop{
		int x,y;
		Bishop(int a,int b){
			x=a;y=b;
		}
		boolean attack(Bishop o){
			int dif1=Math.abs(x-o.x);
			int dif2=Math.abs(y-o.y);
			if(dif1==dif2)
				return true;
			return false;

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
